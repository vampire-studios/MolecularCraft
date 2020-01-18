package io.github.vampirestudios.molecularcraft.registries;

import io.github.vampirestudios.molecularcraft.enums.Atoms;
import io.github.vampirestudios.molecularcraft.items.AtomItem;
import io.github.vampirestudios.molecularcraft.items.IsotopeItem;
import io.github.vampirestudios.molecularcraft.molecules.Isotope;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    public static void init() {
        for (Atoms atom : Atoms.values()) {
            Item item = new AtomItem(atom);
            Registry.register(Registry.ITEM, new Identifier("molecularcraft:atom_mole_" + atom.getAtomicNumber()), item);
            if (atom.getIsotopes() != null) {
                int num = 0;
                for (Isotope isotope : atom.getIsotopes()) {
                    Item isotopeItem = new IsotopeItem(isotope);
                    Registry.register(Registry.ITEM,
                            new Identifier("molecularcraft:isotope_" + atom.getAtomicNumber() + "_" + num),
                            isotopeItem);
                    num++;
                }
            }
        }
    }
}
