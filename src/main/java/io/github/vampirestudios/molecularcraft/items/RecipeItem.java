package io.github.vampirestudios.molecularcraft.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class RecipeItem extends Item {

    public RecipeItem() {
        super(new Settings().group(ItemGroup.MISC));
    }
}
