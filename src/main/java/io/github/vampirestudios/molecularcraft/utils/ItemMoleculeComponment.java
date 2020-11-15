package io.github.vampirestudios.molecularcraft.utils;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public interface ItemMoleculeComponment {

    Item getItem();

    ItemStack getItemStack();

    Item getStackedItem(int power);

    ItemStack getStackedItemStack(int power);

    int getAmount();

    ItemMoleculeComponment setAmount(int amount);

    String getFormula();

    Type getType();

    ItemMoleculeComponment copy();

    enum Type {
        MOLECULE,
        MOLECULE_STACK;
    }
}
