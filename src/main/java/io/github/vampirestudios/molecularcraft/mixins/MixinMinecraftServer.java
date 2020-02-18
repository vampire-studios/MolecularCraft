package io.github.vampirestudios.molecularcraft.mixins;

import io.github.vampirestudios.molecularcraft.molecules.MoleculeStack;
import io.github.vampirestudios.molecularcraft.registries.ItemMolecules;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.*;
import net.minecraft.resource.ResourcePackManager;
import net.minecraft.resource.ResourcePackProfile;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.DefaultedList;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.level.LevelProperties;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftServer.class)
public abstract class MixinMinecraftServer {

    @Shadow public abstract RecipeManager getRecipeManager();

    @Inject(
            method = "reloadDataPacks",
            at = @At("RETURN")
    )
    private void reloadData(LevelProperties levelProperties, CallbackInfo ci) {
        System.out.println("!!!!TEST!!!!");
        this.getRecipeManager().values().forEach(recipe -> {
            if (recipe.getType() == RecipeType.CRAFTING && (recipe instanceof ShapedRecipe || recipe instanceof ShapelessRecipe)) {
                System.out.println(recipe.getId().toString());
                System.out.println(" ");
                ItemStack output = recipe.getOutput();
                DefaultedList<Ingredient> inputs = recipe.getPreviewInputs();
                ItemMolecules itemMolecule = new ItemMolecules();
                for (Ingredient ingredient : inputs) {
                    for (ItemStack input : ingredient.getMatchingStacksClient()) {
                        Identifier identifier = Registry.ITEM.getId(input.getItem());
                        System.out.println(identifier.toString());
                        if (ItemMolecules.registry.containsKey(identifier.toString())) {
                            System.out.println("Yes?");
                            ItemMolecules itemMolecules = ItemMolecules.registry.get(identifier.toString());
                            itemMolecule.addMoleculeStacks(itemMolecules.getList());
                        }
                    }
                }
                System.out.println(" ");
                System.out.println(Registry.ITEM.getId(output.getItem()).toString());
                if (!itemMolecule.getList().isEmpty()) {
                    ItemMolecules.register(Registry.ITEM.getId(output.getItem()).toString(), itemMolecule);
//                    System.out.println(ItemMolecules.registry.get(Registry.ITEM.getId(output.getItem()).toString()).toString());
                }
                System.out.println("______________");
            }
        });
    }
}
