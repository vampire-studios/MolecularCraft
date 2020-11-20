package io.github.vampirestudios.molecularcraft.blocks.entities;

import io.github.cottonmc.cotton.gui.PropertyDelegateHolder;
import io.github.vampirestudios.molecularcraft.container.AssemblerScreenHandler;
import io.github.vampirestudios.molecularcraft.items.StackedAtomItem;
import io.github.vampirestudios.molecularcraft.items.StackedMoleculeStackItem;
import io.github.vampirestudios.molecularcraft.registries.ModBlockEntities;
import io.github.vampirestudios.molecularcraft.registries.ModItems;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;
import net.minecraft.util.Tickable;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import team.reborn.energy.EnergySide;
import team.reborn.energy.EnergyStorage;
import team.reborn.energy.EnergyTier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AssemblerBlockEntity extends BlockEntity implements Tickable, EnergyStorage, ExtendedScreenHandlerFactory, ImplementedInventory, PropertyDelegateHolder {
    private double energy;
    private final DefaultedList<ItemStack> items = DefaultedList.ofSize(20, ItemStack.EMPTY);

    public AssemblerBlockEntity() {
        super(ModBlockEntities.assemblerBlockEntityBlockEntityType);
        this.energy = 20_000;
    }

    @Override
    public CompoundTag toTag(CompoundTag tag) {
        tag = Inventories.toTag(tag, this.items);
        tag.putDouble("energy", this.getStored(EnergySide.UNKNOWN));
        return super.toTag(tag);
    }

    @Override
    public void fromTag(BlockState state, CompoundTag tag) {
        super.fromTag(state, tag);
        if (this.world == null) this.setStored(tag.getDouble("energy"));
        Inventories.fromTag(tag, this.items);
    }

    @Override
    public void tick() {
        ItemStack recipe = this.getStack(18);
        if (recipe.getItem() == ModItems.RECIPE) {
            CompoundTag tag = recipe.getTag();
            String outputId = tag.getString("outputId");
            Item outputItem = Registry.ITEM.get(new Identifier(outputId));
            List<ItemStack> ingredients = new ArrayList<>();
            ListTag list = (ListTag) tag.get("inputs");
            list.forEach(tag1 -> {
                CompoundTag compoundTag = (CompoundTag) tag1;
                Item item = Registry.ITEM.get(new Identifier(compoundTag.getString("id")));
                int count = compoundTag.getInt("count");
                ingredients.add(new ItemStack(item, count));
            });

            ItemStack resultStack = this.getStack(19);
            if (resultStack.getItem() == outputItem) {
                if (resultStack.getCount() < outputItem.getMaxCount()) {
                    if (this.canAssemble(ingredients)) this.assemble(outputId, ingredients);
                }
            } else if (resultStack.getItem() == Items.AIR) {
                if (this.canAssemble(ingredients)) this.assemble(outputId, ingredients);
            }
        }
    }

    private boolean canAssemble(List<ItemStack> ingredients) {
        Map<Item, Integer> inInventory = new HashMap<>();
        for (ItemStack stack : this.getItems()) {
            Item item = stack.getItem();
            int count = stack.getCount();
            if (item instanceof StackedMoleculeStackItem || item instanceof StackedAtomItem) {
                if (item instanceof  StackedMoleculeStackItem) {
                    StackedMoleculeStackItem stackedMoleculeStackItem = (StackedMoleculeStackItem) item;
                    item = stackedMoleculeStackItem.getMoleculeStack().getItem();
                    count *= 64;
                } else {
                    StackedAtomItem stackedAtomItem = (StackedAtomItem) item;
                    item = stackedAtomItem.getAtom().getItem();
                    count *= 64;
                }
            }

            if (inInventory.containsKey(item)) {
                inInventory.replace(item, inInventory.get(item) + count);
            } else {
                inInventory.put(item, count);
            }
        }

        for (ItemStack ingredient : ingredients) {
            Item item = ingredient.getItem();
            int count = ingredient.getCount();

            if (!inInventory.containsKey(item)) return false;
            int inCount = inInventory.get(item);
            if (inCount < count) return false;
        }

        return true;
    }

    private void assemble(String outputId, List<ItemStack> ingredients) {
        for (ItemStack ingredient : ingredients) {
            Item ingredientItem = ingredient.getItem();
            int ingredientCount = ingredient.getCount();
            for (int i = 0; i < this.getItems().size() - 2; i++) {
                if (ingredientCount == 0) break;
                ItemStack slotStack = this.getStack(i);
                if (slotStack.getItem() == ingredientItem) {
                    while (slotStack.getCount() != 0) {
                        if (ingredientCount == 0) break;

                        slotStack.decrement(1);
                        this.setStack(i, slotStack);
                        ingredientCount--;
                    }
                }
            }

            if (ingredientCount > 0) {
                for (int i = 0; i < this.getItems().size() - 2; i++) {
                    if (ingredientCount == 0) break;
                    ItemStack slotStack = this.getStack(i);
                    int amount = slotStack.getCount();
                    if (slotStack.getItem() instanceof StackedAtomItem) {
                        StackedAtomItem stackedAtomItem = (StackedAtomItem) slotStack.getItem();
                        Item atomItem = stackedAtomItem.getAtom().getItem();
                        if (ingredientItem == atomItem) {
                            while (amount > 0 && ingredientCount > 0) {
                                slotStack.decrement(1);
                                this.setStack(i, slotStack);
                                int slotCount = 64;
                                while (ingredientCount > 0 && slotCount > 0) {
                                    ingredientCount--;
                                    slotCount--;
                                }

                                if (slotCount > 0) {
                                    ItemStack toDropStack = new ItemStack(atomItem, slotCount);
                                    this.tryInsertingItemStack(toDropStack);
                                }
                            }
                        }
                    } else if (slotStack.getItem() instanceof StackedMoleculeStackItem) {
                        StackedMoleculeStackItem stackedAtomItem = (StackedMoleculeStackItem) slotStack.getItem();
                        Item atomItem = stackedAtomItem.getMoleculeStack().getItem();
                        if (ingredientItem == atomItem) {
                            while (amount > 0 && ingredientCount > 0) {
                                slotStack.decrement(1);
                                this.setStack(i, slotStack);
                                int slotCount = 64;
                                while (ingredientCount > 0 && slotCount > 0) {
                                    ingredientCount--;
                                    slotCount--;
                                }

                                if (slotCount > 0) {
                                    ItemStack toDropStack = new ItemStack(atomItem, slotCount);
                                    this.tryInsertingItemStack(toDropStack);
                                }
                            }
                        }
                    }
                }
            }
        }
        Item outputItem = Registry.ITEM.get(new Identifier(outputId));
        ItemStack outputStack = this.getStack(19);
        if (outputStack.getItem() == outputItem) {
            outputStack.increment(1);
        } else {
            outputStack = new ItemStack(outputItem);
        }
        this.setStack(19, outputStack);
    }

    public void tryInsertingItemStack(ItemStack stack) {
        Item stackItem = stack.getItem();
        int stackAmount = stack.getCount();

        for (int i = 0; i < 18; i++) {
            if (stackAmount == 0) break;
            ItemStack slotStack = this.getStack(i);
            Item slotItem = slotStack.getItem();
            int slotAmount = slotStack.getCount();
            if (stackItem == slotItem && slotStack.getTag() == stack.getTag()) {
                while (slotAmount < slotItem.getMaxCount() && stackAmount > 0) {
                    slotAmount++;
                    stackAmount--;
                }
                slotStack.setCount(slotAmount);
                this.setStack(i, slotStack);
            } else if (slotItem == Items.AIR) {
                this.setStack(i, stack);
                stackAmount = 0;
            }
        }

        if (stackAmount > 0) {
            stack.setCount(stackAmount);
            ItemEntity itemEntity = new ItemEntity(this.world, this.pos.getX(), this.pos.getY(), this.pos.getZ(), stack);
            this.world.spawnEntity(itemEntity);
        }
    }

    @Override
    public World getWorld() {
        return super.getWorld();
    }

    @Override
    public double getStored(EnergySide face) {
        return this.energy;
    }

    @Override
    public void setStored(double amount) {
        this.energy = amount;
    }

    @Override
    public double getMaxStoredPower() {
        return 50_000;
    }

    @Override
    public EnergyTier getTier() {
        return EnergyTier.HIGH;
    }

    @Override
    public double getMaxInput(EnergySide side) {
        return 512;
    }

    @Override
    public double getMaxOutput(EnergySide side) {
        return 0;
    }

    @Override
    public Text getDisplayName() {
        return new TranslatableText("block.molecularcraft.assembler");
    }

    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        return new AssemblerScreenHandler(syncId, inv, this.pos, ScreenHandlerContext.create(this.world, this.pos));
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return this.items;
    }

    @Override
    public void writeScreenOpeningData(ServerPlayerEntity serverPlayerEntity, PacketByteBuf packetByteBuf) {
        packetByteBuf.writeBlockPos(this.pos);
    }

    @Override
    public PropertyDelegate getPropertyDelegate() {
        return new PropertyDelegate() {
            @Override
            public int get(int index) {
                if (index == 0) return (int) energy;
                if (index == 1) return (int) getMaxStoredPower();
                return -1;
            }

            @Override
            public void set(int index, int value) {
                if (index == 0) energy = value;
            }

            @Override
            public int size() {
                return 2;
            }
        };
    }
}
