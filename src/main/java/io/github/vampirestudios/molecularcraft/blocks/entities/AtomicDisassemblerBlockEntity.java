package io.github.vampirestudios.molecularcraft.blocks.entities;

import io.github.vampirestudios.molecularcraft.container.ImplementedInventory;
import io.github.vampirestudios.molecularcraft.registries.ModBlockEntities;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.DefaultedList;

public class AtomicDisassemblerBlockEntity extends BlockEntity implements ImplementedInventory {
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
}
