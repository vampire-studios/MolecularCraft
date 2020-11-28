package io.github.vampirestudios.molecularcraft.blocks.entities;

import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Direction;
import org.jetbrains.annotations.Nullable;

public class DisassemblerInventory extends MachineInventory {

    public DisassemblerInventory(int size) {
        super(size);
    }

    public DisassemblerInventory(ItemStack... stacks) {
        super(stacks);
    }

    @Override
    public int[] getAvailableSlots(Direction side) {
        return side == Direction.UP ? new int[]{0}
                : new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18};
    }

    @Override
    public boolean canInsert(int slot, ItemStack stack, @Nullable Direction dir) {
        return dir == Direction.UP && slot == 0;
    }

    @Override
    public boolean canExtract(int slot, ItemStack stack, Direction dir) {
        return dir == Direction.DOWN && slot != 0;
    }
}
