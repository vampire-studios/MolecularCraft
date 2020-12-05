package io.github.vampirestudios.molecularcraft.mixins;

import io.github.vampirestudios.molecularcraft.utils.IngredientAccessor;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(Ingredient.class)
public abstract class IngredientMixin implements IngredientAccessor {

    @Shadow
    protected abstract void cacheMatchingStacks();

    @Shadow private ItemStack[] matchingStacks;

    public ItemStack[] getMatchingStacks() {
        this.cacheMatchingStacks();
        return this.matchingStacks;
    }
}
