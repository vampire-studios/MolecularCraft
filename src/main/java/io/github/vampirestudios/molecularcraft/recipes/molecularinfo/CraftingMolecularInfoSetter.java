package io.github.vampirestudios.molecularcraft.recipes.molecularinfo;

import io.github.vampirestudios.molecularcraft.recipes.tracker.RecipeTracker;
import io.github.vampirestudios.molecularcraft.recipes.tracker.RecipeTrackerManager;
import io.github.vampirestudios.molecularcraft.registries.ItemMolecule;
import io.github.vampirestudios.molecularcraft.registries.ItemMoleculesDataManager;
import io.github.vampirestudios.molecularcraft.utils.IngredientAccessor;
import io.github.vampirestudios.molecularcraft.utils.ItemMoleculeComponent;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.*;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CraftingMolecularInfoSetter extends AbstractMolecularInfoSetter {
    public CraftingMolecularInfoSetter(RecipeType<?> recipeType, Identifier identifier) {
        super(recipeType, identifier);
    }

    @Override
    public void setMolecularInfo(MinecraftServer minecraftServer) {
        for (Map.Entry<String, ItemMolecule> entry : ItemMoleculesDataManager.DATA_PACKED.entrySet()) {
            RecipeTrackerManager.registerData(entry.getKey(), new RecipeTracker(null, entry.getKey(), entry.getValue(), 1));
        }
        RecipeManager recipeManager = minecraftServer.getRecipeManager();
        List<String> list = new ArrayList<>();
        if (FabricLoader.getInstance().isDevelopmentEnvironment()) System.out.println("Parsing recipe to set molecular composition of outputs");
        for (Recipe<?> recipe : recipeManager.values()) {
            if (recipe.getType() == this.getRecipeType() && (recipe instanceof ShapedRecipe || recipe instanceof ShapelessRecipe)) {

                ItemStack output = recipe.getOutput();
                Identifier outputIdentifier = Registry.ITEM.getId(output.getItem());
                if (ItemMoleculesDataManager.REGISTRY.containsKey(outputIdentifier.toString())) continue;

                DefaultedList<Ingredient> inputs = recipe.getPreviewInputs();
                Map<String, Integer> ingrs = new HashMap<>();
                ItemMolecule itemMolecule = new ItemMolecule();
                boolean incomplete = false;
                for (Ingredient ingredient : inputs) {
                    for (ItemStack input : ((IngredientAccessor)(Object)ingredient).getMatchingStacks()) {
                        Identifier identifier = Registry.ITEM.getId(input.getItem());
                        if (ItemMoleculesDataManager.REGISTRY.containsKey(identifier.toString())) {
                            ItemMolecule itemMolecules = ItemMoleculesDataManager.REGISTRY.get(identifier.toString());
                            itemMolecule.addMoleculeComponments(itemMolecules.getListCopy());
                        } else {
                            incomplete = true;
                            list.add(recipe.getId().toString());
                        }
                        if (!ingrs.containsKey(identifier.toString())) ingrs.put(identifier.toString(), 1);
                        else ingrs.put(identifier.toString(), ingrs.get(identifier.toString()) + 1);
                        break;
                    }
                    if (incomplete) break;
                }
                if (incomplete) continue;

                RecipeTrackerManager.register(outputIdentifier.toString(), new RecipeTracker(recipe.getId().toString(), outputIdentifier.toString(), itemMolecule, output.getCount()));
//                if (incomplete) continue;
//                List<ItemMoleculeComponent> componments = new ArrayList<>();
//                for (ItemMoleculeComponent stack : itemMolecule.getListCopy()) {
//                    float amnt = stack.getAmount()/(float)output.getCount();
//                    if (Float.compare(amnt, (float) ((int) amnt)) != 0 && FabricLoader.getInstance().isDevelopmentEnvironment()) {
//                        System.out.println("Warning: Non int amount of molecule component detected!\nrecipe id: " + recipe.getId().toString()
//                                + "\nmolecule component: " + stack.getFormula() + "\namount: " + amnt + " = " + stack.getAmount() + "/" + output.getCount());
//                    }
//                    componments.add(stack.setAmount((int) amnt));
//                }
//                ItemMolecule itemMolecule1 = new ItemMolecule(componments);
//                if (!itemMolecule1.getListCopy().isEmpty()) {
//                    if (!ItemMoleculesDataManager.REGISTRY.containsKey(Registry.ITEM.getId(output.getItem()).toString())) {
//                        ItemMoleculesDataManager.register(Registry.ITEM.getId(output.getItem()).toString(), itemMolecule1);
//                    }
//                } else {
//                    if (!ItemMoleculesDataManager.REGISTRY.containsKey(Registry.ITEM.getId(output.getItem()).toString())) {
//                        list.add(recipe.getId().toString());
//                    }
//                }
            }
        }
//        if (FabricLoader.getInstance().isDevelopmentEnvironment())System.out.println("Parsing remaining recipes");
//        while (!list.isEmpty()) {
//            List<String> toRemove = new ArrayList<>();
//            for (String id : list) {
//                Recipe<?> recipe = recipeManager.get(new Identifier(id)).get();
//                ItemStack output = recipe.getOutput();
//                DefaultedList<Ingredient> inputs = recipe.getPreviewInputs();
//                ItemMolecule itemMolecule = new ItemMolecule();
//                boolean incomplete = false;
//                for (Ingredient ingredient : inputs) {
//                    for (ItemStack input : ((IngredientAccessor)(Object)ingredient).getMatchingStacks()) {
//                        Identifier identifier = Registry.ITEM.getId(input.getItem());
//                        if (ItemMoleculesDataManager.REGISTRY.containsKey(identifier.toString())) {
//                            ItemMolecule itemMolecules = ItemMoleculesDataManager.REGISTRY.get(identifier.toString());
//                            itemMolecule.addMoleculeComponments(itemMolecules.getListCopy());
//                        } else {
//                            incomplete = true;
//                        }
//                        if (!incomplete) break;
//                    }
//                    if (incomplete) break;
//                }
//                if (incomplete) continue;
//                List<ItemMoleculeComponent> componments = new ArrayList<>();
//                for (ItemMoleculeComponent stack : itemMolecule.getListCopy()) {
//                    float amnt = stack.getAmount()/(float)output.getCount();
//                    if (Float.compare(amnt, (float) ((int) amnt)) != 0 && FabricLoader.getInstance().isDevelopmentEnvironment()) {
//                        System.out.println("Warning: Non int amount of molecule component detected!\nrecipe id: " + recipe.getId().toString()
//                                + "\nmolecule component: " + stack.getFormula() + "\namount: " + amnt + " = " + stack.getAmount() + "/" + output.getCount());
//                    }
//                    componments.add(stack.setAmount((int) amnt));
//                }
//                ItemMolecule itemMolecule1 = new ItemMolecule(componments);
//                for (ItemMoleculeComponent stack : itemMolecule1.getListCopy()) {
//                    if (stack.getAmount() == 0) {
//                        if (FabricLoader.getInstance().isDevelopmentEnvironment()) {
//                            System.out.println("---------");
//                            System.out.println("Recipe id : " + recipe.getId().toString());
//                            System.out.println("Error, null amount of molecule stack : " + stack.getFormula());
//                            System.out.println("---------");
//                        }
//                    }
//                }
//                if (!itemMolecule1.getListCopy().isEmpty()) {
//                    toRemove.add(id);
//                    ItemMoleculesDataManager.register(Registry.ITEM.getId(output.getItem()).toString(), itemMolecule1);
//                }
//            }
//            for (String id : toRemove) {
//                list.remove(id);
//            }
//            if (toRemove.isEmpty()) break;
//        }
////        System.out.println("Could not define molecular composition from those recipes:");
//        for (String id : list) {
//            Recipe<?> recipe = recipeManager.get(new Identifier(id)).get();
//            ItemStack output = recipe.getOutput();
//            DefaultedList<Ingredient> inputs = recipe.getPreviewInputs();
//            StringBuilder inputbuilder = new StringBuilder();
//            for (Ingredient ingredient : inputs) {
//                for (ItemStack input : ((IngredientAccessor)(Object)ingredient).getMatchingStacks()) {
//                    Identifier identifier = Registry.ITEM.getId(input.getItem());
//                    inputbuilder.append(identifier.toString()).append("\n");
//                    break;
//                }
//            }
//            String builder = "____________\n" +
//                    "Recipe ID: " + id + "\n" +
//                    "  \n" +
//                    "Output: " + Registry.ITEM.getId(output.getItem()).toString() + "\n" +
//                    "  \nInputs:\n" +
//                    inputbuilder.toString() +
//                    "\n___________";
////            System.out.println(builder);
//        }
    }
}
