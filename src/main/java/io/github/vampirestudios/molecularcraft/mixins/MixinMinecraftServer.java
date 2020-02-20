package io.github.vampirestudios.molecularcraft.mixins;

import io.github.vampirestudios.molecularcraft.registries.ItemMolecules;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.*;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.DefaultedList;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.level.LevelProperties;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.ArrayList;
import java.util.List;

@Mixin(MinecraftServer.class)
public abstract class MixinMinecraftServer {

    @Shadow public abstract RecipeManager getRecipeManager();

    private List<String> list;

    @Inject(
            method = "reloadDataPacks",
            at = @At("RETURN")
    )
    private void reloadData(LevelProperties levelProperties, CallbackInfo ci) {
        this.list = new ArrayList<>();
        System.out.println("Parsing recipe to set molecular composition of outputs");
        this.getRecipeManager().values().forEach(recipe -> {
            if (recipe.getType() == RecipeType.CRAFTING && (recipe instanceof ShapedRecipe || recipe instanceof ShapelessRecipe)) {
                ItemStack output = recipe.getOutput();
                DefaultedList<Ingredient> inputs = recipe.getPreviewInputs();
                ItemMolecules itemMolecule = new ItemMolecules();
                for (Ingredient ingredient : inputs) {
                    for (ItemStack input : ingredient.getMatchingStacksClient()) {
                        Identifier identifier = Registry.ITEM.getId(input.getItem());
                        if (ItemMolecules.registry.containsKey(identifier.toString())) {
                            ItemMolecules itemMolecules = ItemMolecules.registry.get(identifier.toString());
                            itemMolecule.addMoleculeStacks(itemMolecules.getList());
                        }
                    }
                }
                if (!itemMolecule.getList().isEmpty()) {
                    if (!ItemMolecules.registry.containsKey(Registry.ITEM.getId(output.getItem()).toString())) {
                        ItemMolecules.register(Registry.ITEM.getId(output.getItem()).toString(), itemMolecule);
                    }
                } else {
                    if (!ItemMolecules.registry.containsKey(Registry.ITEM.getId(output.getItem()).toString())) {
                        list.add(recipe.getId().toString());
                    }
                }
            }
        });
        System.out.println("Parsing remaining recipes");
        while (!this.list.isEmpty()) {
            List<String> toRemove = new ArrayList<>();
            for (String id : this.list) {
                Recipe recipe = this.getRecipeManager().get(new Identifier(id)).get();
                ItemStack output = recipe.getOutput();
                DefaultedList<Ingredient> inputs = recipe.getPreviewInputs();
                ItemMolecules itemMolecule = new ItemMolecules();
                for (Ingredient ingredient : inputs) {
                    for (ItemStack input : ingredient.getMatchingStacksClient()) {
                        Identifier identifier = Registry.ITEM.getId(input.getItem());
                        if (ItemMolecules.registry.containsKey(identifier.toString())) {
                            ItemMolecules itemMolecules = ItemMolecules.registry.get(identifier.toString());
                            itemMolecule.addMoleculeStacks(itemMolecules.getList());
                        }
                    }
                }
                if (!itemMolecule.getList().isEmpty()) {
                    toRemove.add(id);
                    ItemMolecules.register(Registry.ITEM.getId(output.getItem()).toString(), itemMolecule);
                }
            }
            for (String id : toRemove)
                this.list.remove(id);
            if (toRemove.isEmpty()) break;
        }
        System.out.println("Could not define molecular composition from those recipes:");
        for (String id : this.list) {
            Recipe recipe = this.getRecipeManager().get(new Identifier(id)).get();
            ItemStack output = recipe.getOutput();
            DefaultedList<Ingredient> inputs = recipe.getPreviewInputs();
            StringBuilder inputbuilder = new StringBuilder();
            for (Ingredient ingredient : inputs) {
                for (ItemStack input : ingredient.getMatchingStacksClient()) {
                    Identifier identifier = Registry.ITEM.getId(input.getItem());
                    inputbuilder.append(identifier.toString()).append("\n");
                }
            }
            String builder = "____________\n" +
                    "Recipe ID: " + id + "\n" +
                    "  \n" +
                    "Output: " + Registry.ITEM.getId(output.getItem()).toString() + "\n" +
                    "  \nInputs:\n" +
                    inputbuilder.toString() +
                    "\n___________";
            System.out.println(builder);
        }
    }
}
