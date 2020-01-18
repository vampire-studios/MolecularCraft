package io.github.vampirestudios.molecularcraft.impl;

import io.github.vampirestudios.molecularcraft.items.IsotopeItem;
import io.github.vampirestudios.molecularcraft.molecules.Isotope;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemStackUtils {

    public static void copy(ItemStack from, ItemStack to) {
        if (from.getItem() instanceof IsotopeItem) {
            IsotopeItem isotopeItem = (IsotopeItem) from.getItem();
            if (isotopeItem.getIsotope().getDecayMod() != Isotope.DecayMod.STABLE) {
                long theLife = ((IsotopeItemStackImpl)(Object)from).getLife();
                ((IsotopeItemStackImpl)(Object)to).setLife(theLife);
            }
        }
    }
}
