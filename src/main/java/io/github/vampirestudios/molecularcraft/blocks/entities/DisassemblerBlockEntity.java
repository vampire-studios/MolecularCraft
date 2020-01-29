package io.github.vampirestudios.molecularcraft.blocks.entities;

import io.github.vampirestudios.molecularcraft.MolecularCraft;
import io.github.vampirestudios.molecularcraft.enums.ItemMolecules;
import io.github.vampirestudios.molecularcraft.items.MoleculeStackItem;
import io.github.vampirestudios.molecularcraft.recipes.DisassemblerRecipeManager;
import io.github.vampirestudios.molecularcraft.registries.ModBlockEntities;
import io.netty.buffer.Unpooled;
import net.fabricmc.fabric.api.block.entity.BlockEntityClientSerializable;
import net.fabricmc.fabric.api.network.ServerSidePacketRegistry;
import net.fabricmc.fabric.api.server.PlayerStream;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.DefaultedList;
import net.minecraft.util.PacketByteBuf;
import net.minecraft.util.Tickable;
import net.minecraft.util.math.Direction;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import spinnery.common.BaseInventory;
import spinnery.util.InventoryUtilities;
import team.reborn.energy.EnergySide;
import team.reborn.energy.EnergyStorage;
import team.reborn.energy.EnergyTier;

import java.util.stream.Stream;

public class DisassemblerBlockEntity extends BlockEntity implements Tickable, EnergyStorage, BlockEntityClientSerializable {
    private final DefaultedList<ItemStack> items = DefaultedList.ofSize(19, ItemStack.EMPTY);
    private double energy;
    public BaseInventory inventory = new BaseInventory(19);

    public DisassemblerBlockEntity() {
        super(ModBlockEntities.disassemblerBlockEntityBlockEntityType);
        this.energy = 0;
    }

    @Override
    public CompoundTag toTag(CompoundTag tag) {
        tag = InventoryUtilities.write(this.inventory);
        tag.putDouble("energy", this.getStored(EnergySide.UNKNOWN));
        return super.toTag(tag);
    }

    @Override
    public void fromTag(CompoundTag tag) {
        super.fromTag(tag);
        inventory = new BaseInventory(19);
        InventoryUtilities.read(inventory, tag);
        this.setStored(tag.getDouble("energy"));
    }

    @Override
    public void tick() {
        DisassemblerRecipeManager.tick(this);
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
//        if (this.world != null) {
//            if (!this.world.isClient) {
//                Stream<PlayerEntity> watchingPlayers = PlayerStream.watching(this.getWorld(), this.getPos());
//                // Look at the other methods of `PlayerStream` to capture different groups of players.
//
//                // We'll get to this later
//                PacketByteBuf passedData = new PacketByteBuf(Unpooled.buffer());
//                passedData.writeBlockPos(this.getPos());
//                passedData.writeDouble(this.energy);
//
//                // Then we'll send the packet to all the players
//                watchingPlayers.forEach(player ->
//                        ServerSidePacketRegistry.INSTANCE.sendToPlayer(player, MolecularCraft.DISASSEMBLER_ENERGY_UPDATE_PACKET_ID, passedData));
//            }
//        }
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
    public void fromClientTag(CompoundTag tag) {
        super.fromTag(tag);
        inventory = new BaseInventory(19);
        InventoryUtilities.read(inventory, tag);
        this.setStored(tag.getDouble("energy"));

    }

    @Override
    public CompoundTag toClientTag(CompoundTag tag) {
        tag = InventoryUtilities.write(this.inventory);
        tag.putDouble("energy", this.getStored(EnergySide.UNKNOWN));
        return super.toTag(tag);
    }
}
