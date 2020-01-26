package io.github.vampirestudios.molecularcraft.blocks.entities;

import io.github.vampirestudios.molecularcraft.container.ImplementedInventory;
import io.github.vampirestudios.molecularcraft.enums.ItemMolecules;
import io.github.vampirestudios.molecularcraft.items.MoleculeStackItem;
import io.github.vampirestudios.molecularcraft.recipes.DisassemblerRecipeManager;
import io.github.vampirestudios.molecularcraft.registries.ModBlockEntities;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.DefaultedList;
import net.minecraft.util.Tickable;
import net.minecraft.util.math.Direction;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import team.reborn.energy.EnergySide;
import team.reborn.energy.EnergyStorage;
import team.reborn.energy.EnergyTier;

public class DisassemblerBlockEntity extends BlockEntity implements ImplementedInventory, SidedInventory, Tickable, EnergyStorage {
    private final DefaultedList<ItemStack> items = DefaultedList.ofSize(19, ItemStack.EMPTY);
    private double energy;

    public DisassemblerBlockEntity() {
        super(ModBlockEntities.disassemblerBlockEntityBlockEntityType);
        this.energy = 0;
    }

    @Override
    public CompoundTag toTag(CompoundTag tag) {
        Inventories.toTag(tag, items);
        tag.putDouble("energy", this.energy);
        return super.toTag(tag);
    }

    @Override
    public void fromTag(CompoundTag tag) {
        super.fromTag(tag);
        Inventories.fromTag(tag, items);
        this.energy = tag.getDouble("energy");
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
}
