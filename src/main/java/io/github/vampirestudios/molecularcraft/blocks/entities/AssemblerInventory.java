package io.github.vampirestudios.molecularcraft.blocks.entities;

import net.minecraft.inventory.SidedInventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.Direction;
import org.jetbrains.annotations.Nullable;

public class AssemblerInventory extends SimpleInventory implements SidedInventory {

    public AssemblerInventory(int size) {
        super(size);
    }

    public AssemblerInventory(ItemStack... itemStacks) {
        super(itemStacks);
    }

    @Override
    public int[] getAvailableSlots(Direction side) {
        int[] returnvalue = new int[this.size() - 1];
        for (int i = 0; i < returnvalue.length; i++) {
            returnvalue[i] = i;
        }
        return returnvalue;
    }

    @Override
    public boolean canInsert(int slot, ItemStack stack, @Nullable Direction dir) {
        return slot == 0 && (
                this.getStack(0).getItem() == Items.AIR ||
                        (stack.getItem() == this.getStack(0).getItem() && ItemStack.areTagsEqual(stack, this.getStack(0)))
                );
    }

    @Override
    public boolean canExtract(int slot, ItemStack stack, Direction dir) {
        return slot != 0;
    }
}
