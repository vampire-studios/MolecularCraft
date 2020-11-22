package io.github.vampirestudios.molecularcraft.blocks.entities;

import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Direction;
import org.jetbrains.annotations.Nullable;

public class AssemblerInventory extends MachineInventory {

    public AssemblerInventory(int size) {
        super(size);
    }

    public AssemblerInventory(ItemStack... stacks) {
        super(stacks);
    }

    @Override
    public int[] getAvailableSlots(Direction side) {
        return side == Direction.DOWN ? new int[]{19}
            : new int[]{0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17};
    }

    @Override
    public boolean canInsert(int slot, ItemStack stack, @Nullable Direction dir) {
        return dir == Direction.UP && canInsert(stack) && slot < 18;
    }

    @Override
    public boolean canExtract(int slot, ItemStack stack, Direction dir) {
        return dir == Direction.DOWN && slot == 19;
    }

    @Override
    public void addToNewSlot(ItemStack stack) {
        for(int i = 0; i < this.size() - 2; ++i) {
            ItemStack itemStack = this.getStack(i);
            if (itemStack.isEmpty()) {
                this.setStack(i, stack.copy());
                stack.setCount(0);
                return;
            }
        }

    }

    @Override
    public void addToExistingSlot(ItemStack stack) {
        for(int i = 0; i < this.size() - 2; ++i) {
            ItemStack itemStack = this.getStack(i);
            if (this.canCombine(itemStack, stack)) {
                this.transfer(stack, itemStack);
                if (stack.isEmpty()) {
                    return;
                }
            }
        }
    }

    @Override
    public boolean canInsert(ItemStack stack) {
        int count = stack.getCount();
        for (int i = 0; i < this.size() - 2; i++) {
            if (count == 0) break;
            ItemStack itemStack = this.getStack(i);
            int slotCount = itemStack.getCount();
            if (itemStack.isEmpty() || this.canCombine(itemStack, stack) && itemStack.getCount() < itemStack.getMaxCount()) {
                while (slotCount < itemStack.getMaxCount() && count != 0) {
                    slotCount++;
                    count--;
                }
            }
        }

        return count == 0;
    }
}
