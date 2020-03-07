package io.github.vampirestudios.molecularcraft.recipes;

import io.github.vampirestudios.molecularcraft.MolecularCraft;
import io.github.vampirestudios.molecularcraft.items.MoleculeStackItem;
import io.github.vampirestudios.molecularcraft.molecules.Molecule;
import io.github.vampirestudios.molecularcraft.molecules.MoleculeStack;
import io.github.vampirestudios.molecularcraft.recipes.assembler.AssemblerRecipe;
import io.github.vampirestudios.molecularcraft.registries.ItemMolecules;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.ArrayList;
import java.util.List;

public class AssemblerRecipeManager {

    public static boolean isValidRecipe(AssemblerRecipe recipe) {
        ItemStack output = recipe.getOutput();
        List<ItemStack> inputs = recipe.getInputs();
        String id = Registry.ITEM.getId(output.getItem()).toString();
        List<Boolean> booleans = new ArrayList<>();
        if (output.getItem() instanceof MoleculeStackItem) {
            MoleculeStack moleculeStack = ((MoleculeStackItem) output.getItem()).getMoleculeStack();
            for (int b = 0; b < inputs.size(); b++) {
                ItemStack input = inputs.get(b);
                boolean bol = false;
                for (Molecule molecule : moleculeStack.getMolecules()) {
                    Item atom = Registry.ITEM.get(new Identifier(MolecularCraft.MODID, molecule.getAtom().getSymbol().toLowerCase()));
                    if (input.getItem() == atom && input.getCount() == molecule.getAmount()) bol = true;
                }
                booleans.add(bol);
            }
        } else {
            ItemMolecules itemMolecule = ItemMolecules.registry.get(id);
            if (itemMolecule == null) return false;
            for (int b = 0; b < inputs.size(); b++) {
                ItemStack input = inputs.get(b);
                boolean bool = false;
                for (MoleculeStack moleculeStack : itemMolecule.getList()) {
                    if (moleculeStack.getMoleculeStackItem() == input.getItem() && moleculeStack.getAmount() == input.getCount()) bool = true;
                }
                booleans.add(bool);
            }
        }

        for (boolean bool : booleans) {
            if (!bool) return false;
        }
        return true;
    }

}
