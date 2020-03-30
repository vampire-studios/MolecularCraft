package io.github.vampirestudios.molecularcraft.recipes.molecularinfo;

import io.github.vampirestudios.molecularcraft.registries.ItemMolecules;
import net.minecraft.item.Item;
import net.minecraft.recipe.RecipeManager;
import net.minecraft.recipe.RecipeType;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tag.RegistryTagManager;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class TagsMolecularInfoSetter extends AbstractMolecularInfoSetter {
    public TagsMolecularInfoSetter(RecipeType recipeType, Identifier identifier) {
        super(recipeType, identifier);
    }

    @Override
    public void setMolecularInfo(MinecraftServer minecraftServer) {
        ItemMolecules.tags.forEach((s, itemMolecules) -> {
            Tag<Item> tag = minecraftServer.getTagManager().items().get(new Identifier(s));
            if (tag != null) {
                tag.values().forEach(item -> {
                    Identifier identifier = Registry.ITEM.getId(item);
                    ItemMolecules.register(identifier.toString(), itemMolecules);
                });
            }
        });
        ItemMolecules.tags.clear();
    }
}
