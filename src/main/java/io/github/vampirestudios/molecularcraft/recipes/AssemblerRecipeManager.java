package io.github.vampirestudios.molecularcraft.recipes;

import io.github.vampirestudios.molecularcraft.MolecularCraft;
import io.github.vampirestudios.molecularcraft.molecules.MoleculeStack;
import io.github.vampirestudios.molecularcraft.recipes.assembler.AssemblerRecipe;
import io.github.vampirestudios.molecularcraft.registries.ItemMolecule;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.ArrayList;
import java.util.List;

public class AssemblerRecipeManager {

    public static AssemblerRecipe createRecipe(String id, ItemMolecule itemMolecule) {
        Item output = Registry.ITEM.get(new Identifier(id));
        List<ItemStack> list = new ArrayList<>();
//        for (MoleculeStack moleculeStack : itemMolecule.getList()) {
//            Item input = moleculeStack.getItem();
//            if (input == null || input == Items.AIR) {
//                input = Registry.ITEM.get(new Identifier(MolecularCraft.MODID, moleculeStack.getRegistryName()));
//            }
//            list.add(new ItemStack(input, moleculeStack.getAmount()));
//        }
        return new AssemblerRecipe(list, new ItemStack(output));
    }

}
