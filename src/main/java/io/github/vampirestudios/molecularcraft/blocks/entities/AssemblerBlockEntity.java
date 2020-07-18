package io.github.vampirestudios.molecularcraft.blocks.entities;

import io.github.vampirestudios.molecularcraft.container.AssemblerScreenHandler;
import io.github.vampirestudios.molecularcraft.registries.ModBlockEntities;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.util.Tickable;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;
import team.reborn.energy.EnergySide;
import team.reborn.energy.EnergyStorage;
import team.reborn.energy.EnergyTier;

public class AssemblerBlockEntity extends BlockEntity implements Tickable, EnergyStorage, NamedScreenHandlerFactory, ImplementedInventory {
    private double energy;
//    public BaseInventory inventory = new BaseInventory(20);
    private final DefaultedList<ItemStack> items = DefaultedList.ofSize(20, ItemStack.EMPTY);

    public AssemblerBlockEntity() {
        super(ModBlockEntities.assemblerBlockEntityBlockEntityType);
        this.energy = 20_000;
    }

    @Override
    public CompoundTag toTag(CompoundTag tag) {
//        InventoryUtilities.write(this.inventory, tag);
        Inventories.toTag(tag, this.items);
        tag.putDouble("energy", this.getStored(EnergySide.UNKNOWN));
        return super.toTag(tag);
    }

    @Override
    public void fromTag(BlockState state, CompoundTag tag) {
        super.fromTag(state, tag);
//        inventory = new BaseInventory(20);
//        InventoryUtilities.read(inventory, tag);
        Inventories.fromTag(tag, this.items);
        this.setStored(tag.getDouble("energy"));
    }

    @Override
    public void tick() {

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

//    @Override
//    public void fromClientTag(CompoundTag tag) {
//        super.fromTag(tag);
//        inventory = new BaseInventory(20);
//        InventoryUtilities.read(inventory, tag);
//        this.setStored(tag.getDouble("energy"));
//
//    }
//
//    @Override
//    public CompoundTag toClientTag(CompoundTag tag) {
//        InventoryUtilities.write(this.inventory, tag);
//        tag.putDouble("energy", this.getStored(EnergySide.UNKNOWN));
//        return super.toTag(tag);
//    }

    @Override
    public Text getDisplayName() {
        return new LiteralText("Assembler");
    }

    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        return new AssemblerScreenHandler(syncId, inv, this.pos, ScreenHandlerContext.create(this.world, this.pos));
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return this.items;
    }
}
