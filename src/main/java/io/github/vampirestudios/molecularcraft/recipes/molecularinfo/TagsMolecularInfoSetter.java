package io.github.vampirestudios.molecularcraft.recipes.molecularinfo;

import io.github.vampirestudios.molecularcraft.registries.ItemMolecule;
import io.github.vampirestudios.molecularcraft.registries.ItemMoleculesDataManager;
import net.minecraft.block.Block;
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
            Tag<Item> itemTag = minecraftServer.getTagManager().getItems().getTag(new Identifier(s));
            if (itemTag != null) {
                itemTag.values().forEach(item -> {
                    Identifier identifier = Registry.ITEM.getId(item);
                    ItemMoleculesDataManager.registerData(identifier.toString(), itemMolecules);
                });
            }
            Tag<Block> blockTag = minecraftServer.getTagManager().getBlocks().getTag(new Identifier(s));
            if (blockTag != null) {
                blockTag.values().forEach(block -> {
                    Identifier identifier = Registry.BLOCK.getId(block);
                    ItemMoleculesDataManager.registerData(identifier.toString(), itemMolecules);
                });
            }
        });
        ItemMoleculesDataManager.TAGS.clear();
    }
}
