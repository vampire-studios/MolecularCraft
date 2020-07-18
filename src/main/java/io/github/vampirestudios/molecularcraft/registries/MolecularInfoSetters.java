package io.github.vampirestudios.molecularcraft.registries;

import com.mojang.serialization.Lifecycle;
import io.github.vampirestudios.molecularcraft.MolecularCraft;
import io.github.vampirestudios.molecularcraft.recipes.molecularinfo.AbstractMolecularInfoSetter;
import io.github.vampirestudios.molecularcraft.recipes.molecularinfo.CraftingMolecularInfoSetter;
import io.github.vampirestudios.molecularcraft.recipes.molecularinfo.TagsMolecularInfoSetter;
import net.minecraft.recipe.RecipeType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.util.registry.SimpleRegistry;

public class MolecularInfoSetters {

    public static final SimpleRegistry<AbstractMolecularInfoSetter> REGISTRY =
                    new SimpleRegistry<>(RegistryKey.ofRegistry(MolecularCraft.id("molecularinfosetters")), Lifecycle.stable());

    public static AbstractMolecularInfoSetter TAGS;
    public static AbstractMolecularInfoSetter CRAFTING;

    public static void init() {
        TAGS = register(new TagsMolecularInfoSetter(null, new Identifier("tags")));
        CRAFTING = register(new CraftingMolecularInfoSetter(RecipeType.CRAFTING, new Identifier("crafting")));
    }

    private static AbstractMolecularInfoSetter register(AbstractMolecularInfoSetter abstractMolecularInfoSetter) {
        return Registry.register(REGISTRY, abstractMolecularInfoSetter.getIdentifier(), abstractMolecularInfoSetter);
    }
}
