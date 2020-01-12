package io.github.vampirestudios.molecularcraft.registries;

import io.github.vampirestudios.molecularcraft.enums.Atoms;
import io.github.vampirestudios.molecularcraft.items.AtomMole;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    public static void init() {
        for (Atoms atom : Atoms.values()) {
            Item item = new AtomMole(atom);
            Registry.register(Registry.ITEM, new Identifier("molecularcraft:atom_mole_" + atom.getAtomicNumber()), item);
        }
    }
}
