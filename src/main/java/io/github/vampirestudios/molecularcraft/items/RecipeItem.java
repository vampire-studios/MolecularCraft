package io.github.vampirestudios.molecularcraft.items;

import io.github.vampirestudios.molecularcraft.recipes.assembler.AssemblerRecipe;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.util.registry.Registry;

public class RecipeItem extends Item {
    public RecipeItem() {
        super(new Settings().group(ItemGroup.MISC));
    }

    public static void setRecipeComponent(ItemStack recipeItem, AssemblerRecipe recipe) {
        CompoundTag tag = recipeItem.getOrCreateTag();
        tag.putInt("outputCount", recipe.getOutput().getCount());
        tag.putString("outputId", Registry.ITEM.getId(recipe.getOutput().getItem()).toString());
        ListTag listTag = tag.getList("inputs", 10);
        for (ItemStack itemStack : recipe.getInputs()) {
            CompoundTag tag1 = new CompoundTag();
            tag1.putString("id", Registry.ITEM.getId(itemStack.getItem()).toString());
            tag1.putInt("count", itemStack.getCount());
            System.out.println(tag1.getType());
            listTag.add(tag1);
        }
        tag.put("inputs", listTag);
    }
}
