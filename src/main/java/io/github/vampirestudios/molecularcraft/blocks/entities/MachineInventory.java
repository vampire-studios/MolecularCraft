package io.github.vampirestudios.molecularcraft.blocks.entities;

import io.github.vampirestudios.molecularcraft.mixins.SimpleInventoryAccessor;
import net.minecraft.inventory.SidedInventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.collection.DefaultedList;

import java.util.Iterator;

public abstract class MachineInventory extends SimpleInventory implements SidedInventory {

    public MachineInventory(int size) {
        super(size);
    }

    public MachineInventory(ItemStack... stacks) {
        super(stacks);
    }

    @Override
    public ItemStack addStack(ItemStack stack) {
        ItemStack itemStack = stack.copy();
        this.addToExistingSlot(itemStack);
        if (itemStack.isEmpty()) {
            return ItemStack.EMPTY;
        } else {
            this.addToNewSlot(itemStack);
            return itemStack.isEmpty() ? ItemStack.EMPTY : itemStack;
        }
    }

    @Override
    public boolean canInsert(ItemStack stack) {
        boolean bl = false;
        Iterator var3 = this.getStacks().iterator();

        while(var3.hasNext()) {
            ItemStack itemStack = (ItemStack)var3.next();
            if (itemStack.isEmpty() || this.canCombine(itemStack, stack) && itemStack.getCount() < itemStack.getMaxCount()) {
                bl = true;
                break;
            }
        }

        return bl;
    }

    public void addToNewSlot(ItemStack stack) {
        for(int i = 0; i < this.size(); ++i) {
            ItemStack itemStack = this.getStack(i);
            if (itemStack.isEmpty()) {
                this.setStack(i, stack.copy());
                stack.setCount(0);
                return;
            }
        }

    }

    public void addToExistingSlot(ItemStack stack) {
        for(int i = 0; i < this.size(); ++i) {
            ItemStack itemStack = this.getStack(i);
            if (this.canCombine(itemStack, stack)) {
                this.transfer(stack, itemStack);
                if (stack.isEmpty()) {
                    return;
                }
            }
        }

    }

    public boolean canCombine(ItemStack one, ItemStack two) {
        return one.getItem() == two.getItem() && ItemStack.areTagsEqual(one, two);
    }

    public void transfer(ItemStack source, ItemStack target) {
        int i = Math.min(this.getMaxCountPerStack(), target.getMaxCount());
        int j = Math.min(source.getCount(), i - target.getCount());
        if (j > 0) {
            target.increment(j);
            source.decrement(j);
            this.markDirty();
        }

    }

    public int containStack(ItemStack itemStack) {
        int count = 0;

        for (int i = 0; i < this.size(); i++) {
            ItemStack slot = this.getStack(i);
            if (itemStack == slot) {
                count += slot.getCount();
            }
        }

        return count;
    }

    public int containItem(Item item) {
        return this.containStack(new ItemStack(item));
    }

    public DefaultedList<ItemStack> getStacks() {
        return ((SimpleInventoryAccessor)this).molecularcraft$getStacks();
    }
}
