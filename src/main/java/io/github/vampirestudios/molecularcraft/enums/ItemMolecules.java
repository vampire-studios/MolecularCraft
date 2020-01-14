package io.github.vampirestudios.molecularcraft.enums;

import io.github.vampirestudios.molecularcraft.molecules.Molecule;
import io.github.vampirestudios.molecularcraft.molecules.MoleculeStack;

import java.util.*;

public class ItemMolecules {

    public static List<ItemMolecules> registry = new ArrayList<>();

    private String id;
    private List<MoleculeStack> list;

    public ItemMolecules(String id, MoleculeStack... stack) {
        this.id = id;
        this.list = Arrays.asList(stack);
        registry.add(this);
    }

    public String getId() {
        return id;
    }

    public List<MoleculeStack> getList() {
        return list;
    }

    public static void init() {
        new ItemMolecules("minecraft:water_bucket",
                new MoleculeStack(16, new Molecule(Atoms.HYDROGEN, 2), new Molecule(Atoms.OXYGEN)),
                new MoleculeStack(48, new Molecule(Atoms.IRON))
        );
        new ItemMolecules("minecraft:bucket",
                new MoleculeStack(48, new Molecule(Atoms.IRON)));
        new ItemMolecules("minecraft:iron_ingot",
                new MoleculeStack(16, new Molecule(Atoms.IRON)));
    }
}
