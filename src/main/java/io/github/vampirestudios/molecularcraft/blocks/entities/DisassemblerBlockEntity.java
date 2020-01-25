package io.github.vampirestudios.molecularcraft.blocks.entities;

import io.github.vampirestudios.molecularcraft.container.ImplementedInventory;
import io.github.vampirestudios.molecularcraft.enums.ItemMolecules;
import io.github.vampirestudios.molecularcraft.items.MoleculeStackItem;
import io.github.vampirestudios.molecularcraft.molecules.Molecule;
import io.github.vampirestudios.molecularcraft.molecules.MoleculeStack;
import io.github.vampirestudios.molecularcraft.recipes.DisassemblerRecipeManager;
import io.github.vampirestudios.molecularcraft.registries.ModBlockEntities;
import net.minecraft.block.entity.BlockEntity;
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
import net.minecraft.world.World;

import java.util.List;

public class DisassemblerBlockEntity extends BlockEntity implements ImplementedInventory, SidedInventory, Tickable {
    private final DefaultedList<ItemStack> items = DefaultedList.ofSize(19, ItemStack.EMPTY);

    public DisassemblerBlockEntity() {
        super(ModBlockEntities.disassemblerBlockEntityBlockEntityType);
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
        return slot == 0;
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
        DisassemblerRecipeManager.tick(this);
    }

    @Override
    public boolean isValidInvStack(int slot, ItemStack stack) {
        return slot == 0 && (stack.getItem() instanceof MoleculeStackItem
                || ItemMolecules.items.contains(Registry.ITEM.getId(stack.getItem()).toString()));
    }

    @Override
    public World getWorld() {
        return super.getWorld();
    }
}
