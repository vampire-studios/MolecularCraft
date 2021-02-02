package io.github.vampirestudios.molecularcraft.recipes;

import io.github.vampirestudios.molecularcraft.molecules.Molecule;
import io.github.vampirestudios.molecularcraft.recipes.assembler.AssemblerRecipe;
import io.github.vampirestudios.molecularcraft.registries.ItemMolecule;
import io.github.vampirestudios.molecularcraft.utils.ItemMoleculeComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AssemblerRecipeManager {

    public static AssemblerRecipe createRecipe(Item output, ItemMolecule itemMolecule) {
        List<ItemStack> list = new ArrayList<>();
        for (ItemMoleculeComponent itemMoleculeComponent : itemMolecule.getListCopy()) {
            Item input = itemMoleculeComponent.getItem();
            list.add(new ItemStack(input, itemMoleculeComponent.getAmount()));
        }
        return new AssemblerRecipe(list, new ItemStack(output));
    }

    public static AssemblerRecipe createRecipe(Item output, List<Molecule> molecules) {
        List<ItemStack> list = new ArrayList<>();
        for (Molecule molecule : molecules) {
            list.add(molecule.getItemStack());
        }
        return new AssemblerRecipe(list, new ItemStack(output));
    }

    public static  AssemblerRecipe createRecipe(Item output, ItemStack ingredient) {
        List<ItemStack> list = new ArrayList<ItemStack>(Collections.singleton(ingredient));
        return new AssemblerRecipe(list, new ItemStack(output));
    }

}
