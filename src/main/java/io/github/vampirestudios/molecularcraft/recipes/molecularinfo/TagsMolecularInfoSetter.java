package io.github.vampirestudios.molecularcraft.recipes.molecularinfo;

import io.github.vampirestudios.molecularcraft.registries.ItemMolecule;
import io.github.vampirestudios.molecularcraft.registries.ItemMoleculesDataManager;
import net.minecraft.item.Item;
import net.minecraft.recipe.RecipeType;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class TagsMolecularInfoSetter extends AbstractMolecularInfoSetter {
    public TagsMolecularInfoSetter(RecipeType<?> recipeType, Identifier identifier) {
        super(recipeType, identifier);
    }

    @Override
    public void setMolecularInfo(MinecraftServer minecraftServer) {
        ItemMoleculesDataManager.TAGS.forEach((s, itemMolecules) -> {
            Tag<Item> tag = minecraftServer.getTagManager().getItems().getTag(new Identifier(s));
            if (tag != null) {
                tag.values().forEach(item -> {
                    Identifier identifier = Registry.ITEM.getId(item);
                    ItemMolecule.register(identifier.toString(), itemMolecules);
                });
            }
        });
        ItemMoleculesDataManager.TAGS.clear();
    }
}
