package io.github.vampirestudios.molecularcraft.blocks.entities;

import com.google.common.collect.Lists;
import io.github.vampirestudios.molecularcraft.container.ImplementedInventory;
import io.github.vampirestudios.molecularcraft.enums.ItemMolecules;
import io.github.vampirestudios.molecularcraft.items.MoleculeStackItem;
import io.github.vampirestudios.molecularcraft.molecules.Molecule;
import io.github.vampirestudios.molecularcraft.molecules.MoleculeStack;
import io.github.vampirestudios.molecularcraft.registries.ModBlockEntities;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.DefaultedList;
import net.minecraft.util.Identifier;
import net.minecraft.util.Tickable;
import net.minecraft.util.math.Direction;
import net.minecraft.util.registry.Registry;
import java.util.List;

public class AtomicDisassemblerBlockEntity extends BlockEntity implements ImplementedInventory, SidedInventory, Tickable {
    private final DefaultedList<ItemStack> items = DefaultedList.ofSize(19, ItemStack.EMPTY);

    public AtomicDisassemblerBlockEntity() {
        super(ModBlockEntities.atomicDisassemblerBlockEntityBlockEntityType);
    }

    @Override
    public CompoundTag toTag(CompoundTag tag) {
        Inventories.toTag(tag, items);
        return super.toTag(tag);
    }

    @Override
    public void fromTag(CompoundTag tag) {
        super.fromTag(tag);
        Inventories.fromTag(tag, items);
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return items;
    }

    @Override
    public boolean canInsertInvStack(int slot, ItemStack stack, Direction direction) {
        return slot == 0 && stack.isItemEqual(getInvStack(0));
    }

    @Override
    public boolean canExtractInvStack(int slot, ItemStack stack, Direction direction) {
        return slot != 0;
    }

    @Override
    public int[] getInvAvailableSlots(Direction side) {
        // Just return an array of all slots
        int[] result = new int[getItems().size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = i;
        }

        return result;
    }

    @Override
    public int getInvMaxStackAmount() {
        return 1024;
    }

    @Override
    public void tick() {
        if (!this.world.isClient) {
            ItemStack firstSlotItemStack = getInvStack(0);
            if (firstSlotItemStack.isEmpty()) return;

            String id = Registry.ITEM.getId(firstSlotItemStack.getItem()).toString();
            firstSlotItemStack.decrement(1);
            for (ItemMolecules itemMolecule : ItemMolecules.registry) {
                if (itemMolecule.getId().equals(id)) {
                    List<MoleculeStack> moleculeStackList = itemMolecule.getList();
                    boolean[] booleans = new boolean[moleculeStackList.size()];
                    for (int x = 0; x < booleans.length; x++)
                        booleans[x] = false;
                    for (int k = 1; k < getInvSize(); k++) {
                        ItemStack itemStack = getInvStack(k);
                        for (int g = 0; g < moleculeStackList.size(); g++) {
                            if (booleans[g]) continue;
                            ItemStack moleculeStackItemStack = moleculeStackList.get(g).getMoleculeStackItemStack();
                            if (moleculeStackItemStack.isEmpty() || moleculeStackList.get(g).getMoleculeStackItem() == null || moleculeStackList.get(g).getMoleculeStackItem() == Items.AIR) {
                                moleculeStackItemStack = new ItemStack(Registry.ITEM.get(
                                        new Identifier("molecularcraft", moleculeStackList.get(g).getMolecules().get(0).getAtom().getSymbol().toLowerCase())),
                                        moleculeStackList.get(g).getAmount());
                            }
                            if (itemStack.isEmpty()) {
                                setInvStack(k, moleculeStackItemStack);
                                booleans[g] = true;
                                break;
                            } else {
                                if (itemStack.isItemEqual(moleculeStackItemStack)) {
                                    int amount = itemStack.getCount();
                                    int count = moleculeStackItemStack.getCount();
                                    int som = count + amount;
                                    moleculeStackItemStack.setCount(som);
                                    setInvStack(k, moleculeStackItemStack);
                                    booleans[g] = true;
                                    break;
                                } else {
                                    booleans[g] = false;
                                }
                            }
                        }
                        boolean molboolean = true;
                        for (boolean boo : booleans) {
                            if (!boo) {
                                molboolean = false;
                                break;
                            }
                        }
                        if (molboolean) break;
                    }
                break;
                }
            }

            if (firstSlotItemStack.getItem() instanceof MoleculeStackItem) {
                MoleculeStackItem moleculeStackItem = (MoleculeStackItem) firstSlotItemStack.getItem();
                MoleculeStack moleculeStack = moleculeStackItem.getMoleculeStack();
                List<Molecule> moleculeList = moleculeStack.getMolecules();
                boolean[] booleans = new boolean[moleculeList.size()];
                for (int x = 0; x < booleans.length; x++)
                    booleans[x] = false;
                for (int k = 0; k < getInvSize(); k++) {
                    ItemStack itemStack = getInvStack(k);
                    for (int g = 0; g < moleculeList.size(); g++) {
                        if (booleans[g]) continue;
                        ItemStack moleculeStackItemStack = new ItemStack(Registry.ITEM.get(
                                    new Identifier("molecularcraft", moleculeList.get(g).getAtom().getSymbol().toLowerCase())),
                                    moleculeList.get(g).getAmount() * moleculeStack.getAmount());
                        if (itemStack.isEmpty()) {
                            setInvStack(k, moleculeStackItemStack);
                            booleans[g] = true;
                            break;
                        } else {
                            if (itemStack.isItemEqual(moleculeStackItemStack)) {
                                int amount = itemStack.getCount();
                                int count = moleculeStackItemStack.getCount();
                                int som = count + amount;
                                moleculeStackItemStack.setCount(som);
                                setInvStack(k, moleculeStackItemStack);
                                booleans[g] = true;
                                break;
                            } else {
                                booleans[g] = false;
                            }
                        }
                    }

                    boolean molboolean = true;
                    for (boolean boo : booleans) {
                        if (!boo) {
                            molboolean = false;
                            break;
                        }
                    }
                    if (molboolean) break;
                }
            }
        }
    }
}
