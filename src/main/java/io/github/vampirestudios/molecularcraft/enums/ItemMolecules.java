package io.github.vampirestudios.molecularcraft.enums;

import io.github.vampirestudios.molecularcraft.molecules.Molecule;
import io.github.vampirestudios.molecularcraft.molecules.MoleculeStack;

import java.util.*;

import static io.github.vampirestudios.molecularcraft.enums.Molecules.water;

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
                water,
                new MoleculeStack(48, new Molecule(Atoms.IRON))
        );
        new ItemMolecules("minecraft:bucket",
                new MoleculeStack(48, new Molecule(Atoms.IRON)));
        new ItemMolecules("minecraft:iron_ingot",
                new MoleculeStack(16, new Molecule(Atoms.IRON)));
        new ItemMolecules("minecraft:iron_helmet",
                new MoleculeStack(80, new Molecule(Atoms.IRON)));
        new ItemMolecules("minecraft:iron_chestplate",
                new MoleculeStack(128, new Molecule(Atoms.IRON)));
        new ItemMolecules("minecraft:iron_leggings",
                new MoleculeStack(112, new Molecule(Atoms.IRON)));
        new ItemMolecules("minecraft:cauldron",
                new MoleculeStack(112, new Molecule(Atoms.IRON)));
        new ItemMolecules("minecraft:minecart",
                new MoleculeStack(80, new Molecule(Atoms.IRON)));
        new ItemMolecules("minecraft:iron_boots",
                new MoleculeStack(64, new Molecule(Atoms.IRON)));
        new ItemMolecules("minecraft:heavy_weighted_pressure_plate",
                new MoleculeStack(32, new Molecule(Atoms.IRON)));
    }
}
