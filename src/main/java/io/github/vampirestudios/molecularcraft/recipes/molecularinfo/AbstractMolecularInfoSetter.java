package io.github.vampirestudios.molecularcraft.recipes.molecularinfo;

import net.minecraft.recipe.*;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.Identifier;

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
