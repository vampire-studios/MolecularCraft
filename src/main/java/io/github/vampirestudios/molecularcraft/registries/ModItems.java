package io.github.vampirestudios.molecularcraft.registries;

import io.github.vampirestudios.molecularcraft.MolecularCraft;
import io.github.vampirestudios.molecularcraft.enums.Atoms;
import io.github.vampirestudios.molecularcraft.enums.Molecules;
import io.github.vampirestudios.molecularcraft.items.AtomItem;
import io.github.vampirestudios.molecularcraft.items.IsotopeItem;
import io.github.vampirestudios.molecularcraft.items.RecipeItem;
import io.github.vampirestudios.molecularcraft.items.StackedAtomItem;
import io.github.vampirestudios.molecularcraft.molecules.Isotope;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.Random;

public class ModItems {

    public static ItemGroup ATOMS = FabricItemGroupBuilder.create(MolecularCraft.id("atoms")).icon(() -> {
        int length = Atoms.values().length;
        int rand = new Random().nextInt(length);
        Atoms atom = Atoms.values()[rand];
        Item item = Registry.ITEM.get(MolecularCraft.id(atom.getSymbol().toLowerCase()));
        return new ItemStack(item);
    }).build();

    public static ItemGroup MOLECULES = FabricItemGroupBuilder.create(MolecularCraft.id("molecules")).icon(() -> {
        int length = Molecules.MOLECULE_STACKS.getIds().size();
        int rand = new Random().nextInt(length);
        String atom = Molecules.MOLECULE_STACKS.get(rand).getRegistryName();
        Item item = Registry.ITEM.get(MolecularCraft.id(atom));
        return new ItemStack(item);
    }).build();

    public static ItemGroup MACHINES = FabricItemGroupBuilder.create(MolecularCraft.id("machines"))
            .icon(() -> new ItemStack(ModBlocks.MICROSCOPE)).build();

    public static Item RECIPE;

    public static void init() {
        RECIPE = Registry.register(Registry.ITEM, new Identifier(MolecularCraft.MODID, "recipe"), new RecipeItem());
        for (Atoms atom : Atoms.values()) {
            Item item = new AtomItem(atom);
            Registry.register(Registry.ITEM, new Identifier(MolecularCraft.MODID, atom.getSymbol().toLowerCase()), item);
            Item stacked = new StackedAtomItem(atom);
            Registry.register(Registry.ITEM, MolecularCraft.id(atom.getSymbol().toLowerCase() + "_64"), stacked);

//            if (atom.getIsotopes() != null) {
//                int num = 0;
//                for (Isotope isotope : atom.getIsotopes()) {
//                    Item isotopeItem = new IsotopeItem(isotope);
//                    Registry.register(Registry.ITEM,
//                            new Identifier("molecularcraft:isotope_" + atom.getSymbol().toLowerCase() + "_" + num),
//                            isotopeItem);
//                    num++;
//                }
//            }
        }
    }
}
