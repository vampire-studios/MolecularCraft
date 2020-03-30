package io.github.vampirestudios.molecularcraft.recipes.molecularinfo;

import io.github.vampirestudios.molecularcraft.registries.ItemMolecules;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.*;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.DefaultedList;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractMolecularInfoSetter {
    private RecipeType recipeType;
    private Identifier identifier;

    public AbstractMolecularInfoSetter(RecipeType recipeType, Identifier identifier) {
        this.recipeType = recipeType;
        this.identifier = identifier;
    }

    public Identifier getIdentifier() {
        return identifier;
    }

    public RecipeType getRecipeType() {
        return recipeType;
    }

    public abstract void setMolecularInfo(MinecraftServer minecraftServer);
}
