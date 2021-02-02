package io.github.vampirestudios.molecularcraft.utils;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public interface ItemMoleculeComponent {

    Item getItem();

    ItemStack getItemStack();

    Item getStackedItem(int power);

    ItemStack getStackedItemStack(int power);

    int getAmount();

    ItemMoleculeComponent setAmount(int amount);

    String getFormula();

    Type getType();

    ItemMoleculeComponent copy();

    enum Type {
        MOLECULE,
        MOLECULE_STACK;
    }
}
