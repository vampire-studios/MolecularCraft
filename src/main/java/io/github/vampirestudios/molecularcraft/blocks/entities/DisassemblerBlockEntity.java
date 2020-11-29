package io.github.vampirestudios.molecularcraft.blocks.entities;

import io.github.cottonmc.cotton.gui.PropertyDelegateHolder;
import io.github.vampirestudios.molecularcraft.container.DisassemblerScreenHandler;
import io.github.vampirestudios.molecularcraft.enums.Atoms;
import io.github.vampirestudios.molecularcraft.items.MoleculeStackItem;
import io.github.vampirestudios.molecularcraft.items.StackedAtomItem;
import io.github.vampirestudios.molecularcraft.items.StackedMoleculeStackItem;
import io.github.vampirestudios.molecularcraft.molecules.Molecule;
import io.github.vampirestudios.molecularcraft.molecules.MoleculeStack;
import io.github.vampirestudios.molecularcraft.registries.ItemMolecule;
import io.github.vampirestudios.molecularcraft.registries.ItemMoleculesDataManager;
import io.github.vampirestudios.molecularcraft.registries.ModBlockEntities;
import io.github.vampirestudios.molecularcraft.utils.ItemMoleculeComponment;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.BlockState;
import net.minecraft.block.InventoryProvider;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Tickable;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.Nullable;
import team.reborn.energy.EnergySide;
import team.reborn.energy.EnergyStorage;
import team.reborn.energy.EnergyTier;

import java.util.*;

public class DisassemblerBlockEntity extends BlockEntity implements Tickable, EnergyStorage, ExtendedScreenHandlerFactory, /*ImplementedInventory,*/ PropertyDelegateHolder, InventoryProvider {
    private double energy;
    private final MachineInventory inventory = new DisassemblerInventory(19);

    public DisassemblerBlockEntity() {
        super(ModBlockEntities.disassemblerBlockEntityBlockEntityType);
        this.energy = this.getMaxStoredPower();
    }

    @Override
    public CompoundTag toTag(CompoundTag tag) {
        tag = Inventories.toTag(tag, this.getItems());
        tag.putDouble("energy", this.getStored(EnergySide.UNKNOWN));
        return super.toTag(tag);
    }

    @Override
    public void fromTag(BlockState state, CompoundTag tag) {
        super.fromTag(state, tag);
        this.setStored(tag.getDouble("energy"));
        Inventories.fromTag(tag, this.getItems());
    }

    @Override
    public void tick() {
        ItemStack inputStack = this.inventory.getStack(0);
        String inputId = Registry.ITEM.getId(inputStack.getItem()).toString();
        if (ItemMoleculesDataManager.REGISTRY.containsKey(inputId)) {
            ItemMolecule itemMolecule = ItemMoleculesDataManager.REGISTRY.get(inputId);
            List<ItemStack> outputs = new ArrayList<>();
            for (ItemMoleculeComponment itemMoleculeComponment : itemMolecule.getListCopy()) {
                ItemStack stack = itemMoleculeComponment.getItemStack();
                while (stack.getCount() > 64) {
                    stack.decrement(64);
                    outputs.add(new ItemStack(stack.getItem(), 64));
                }
                outputs.add(stack);
            }
            if (this.canDisassemble(outputs)) {
                this.disassemble(outputs);
            } else {
                outputs.clear();
                for (ItemMoleculeComponment itemMoleculeComponment : itemMolecule.getListCopy()) {
                    int count = itemMoleculeComponment.getAmount();
                    if (count > 63) {
                        ItemStack itemStack = itemMoleculeComponment.getStackedItemStack(1);
                        while (itemStack.getCount() > 64) {
                            inputStack.decrement(64);
                            outputs.add(new ItemStack(itemStack.getItem(), 64));
                        }
                        outputs.add(itemStack);
                    }
                    outputs.add(itemMoleculeComponment.getItemStack());
                }

                if (this.canDisassemble(outputs)) {
                    this.disassemble(outputs);
                }
            }
        } else if (inputStack.getItem() instanceof MoleculeStackItem) {
            MoleculeStackItem moleculeStackItem = (MoleculeStackItem) inputStack.getItem();
            MoleculeStack moleculeStack = moleculeStackItem.getMoleculeStack();
            List<ItemStack> outputs = new ArrayList<>();
            for (Molecule molecule : moleculeStack.getMolecules()) {
                outputs.add(molecule.getItemStack());
            }

            if (canDisassemble(outputs)) {
                disassemble(outputs);
            }
        } else if (inputStack.getItem() instanceof StackedMoleculeStackItem) {
            StackedMoleculeStackItem stackedMoleculeStackItem = (StackedMoleculeStackItem) inputStack.getItem();
            MoleculeStack moleculeStack = stackedMoleculeStackItem.getMoleculeStack();
            List<ItemStack> ouputs = new ArrayList<>(Collections.singleton(new ItemStack(moleculeStack.getItem(), 64)));

            if (canDisassemble(ouputs)) disassemble(ouputs);
        } else if (inputStack.getItem() instanceof StackedAtomItem) {
            StackedAtomItem stackedAtomItem = (StackedAtomItem) inputStack.getItem();
            Atoms atom = stackedAtomItem.getAtom();
            List<ItemStack> outputs = new ArrayList<>(Collections.singleton(new ItemStack(atom.getItem(), 64)));

            if (canDisassemble(outputs)) disassemble(outputs);
        }
    }

    private boolean canDisassemble(List<ItemStack> outputs) {
        Map<Item, Integer> inInventory = new HashMap<>();
        Map<Item, Integer> numberOfStacks = new HashMap<>();
        int air = 0;
        for (ItemStack stack : this.getItems()) {
            Item item = stack.getItem();
            int count = stack.getCount();
            if (inInventory.containsKey(item)) {
                inInventory.replace(item, inInventory.get(item) + count);
            } else {
                inInventory.put(item, count);
            }
            if (item == Items.AIR) air++;

            if (numberOfStacks.containsKey(item)) {
                numberOfStacks.replace(item, numberOfStacks.get(item) + 1);
            } else {
                numberOfStacks.put(item, 1);
            }
        }

        for (ItemStack output : outputs) {
            Item item = output.getItem();
            int count = output.getCount();

            if (!inInventory.containsKey(item)) {
                if (air == 0) return false;
                else air--;
            } else {
                int inCount = inInventory.get(item);
                int stackNumber = numberOfStacks.get(item);
                int maxCountIn = stackNumber * item.getMaxCount();
                int free = maxCountIn - inCount;
                if (free < count) {
                    if (air == 0) return false;
                    else air--;
                }
            }
        }

        return true;
    }

    private void disassemble(List<ItemStack> outputs) {
        for (ItemStack output : outputs) {
            this.inventory.addStack(output);
        }

        this.inventory.removeStack(0, 1);
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
    public void writeScreenOpeningData(ServerPlayerEntity serverPlayerEntity, PacketByteBuf packetByteBuf) {
        packetByteBuf.writeBlockPos(this.pos);
    }

    @Override
    public Text getDisplayName() {
        return new TranslatableText("block.molecularcraft.disassembler");
    }

    @Override
    public @Nullable ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        return new DisassemblerScreenHandler(syncId, inv, this.pos, ScreenHandlerContext.create(this.world, this.pos));
    }

    public DefaultedList<ItemStack> getItems() {
        return this.inventory.getStacks();
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

    @Override
    public SidedInventory getInventory(BlockState state, WorldAccess world, BlockPos pos) {
        return this.inventory;
    }
}
