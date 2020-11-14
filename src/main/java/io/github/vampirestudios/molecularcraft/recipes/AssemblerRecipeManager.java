package io.github.vampirestudios.molecularcraft.recipes;

import io.github.vampirestudios.molecularcraft.molecules.Molecule;
import io.github.vampirestudios.molecularcraft.recipes.assembler.AssemblerRecipe;
import io.github.vampirestudios.molecularcraft.registries.ItemMolecule;
import io.github.vampirestudios.molecularcraft.utils.ItemMoleculeComponment;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.ArrayList;
import java.util.List;

public class AssemblerRecipeManager {

    public static AssemblerRecipe createRecipe(Item output, ItemMolecule itemMolecule) {
        List<ItemStack> list = new ArrayList<>();
        for (ItemMoleculeComponment itemMoleculeComponment : itemMolecule.getList()) {
            Item input = itemMoleculeComponment.getItem();
            list.add(new ItemStack(input, itemMoleculeComponment.getAmount()));
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

}
