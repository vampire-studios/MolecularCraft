package io.github.vampirestudios.molecularcraft.enums;

import io.github.vampirestudios.molecularcraft.molecules.Molecule;
import io.github.vampirestudios.molecularcraft.molecules.MoleculeStack;

import static io.github.vampirestudios.molecularcraft.enums.Atoms.*;

public class Molecules {

    public static MoleculeStack water;
    public static Molecule ironMolecule;

    public static void init() {
        water = new MoleculeStack(new Molecule(HYDROGEN, 2), new Molecule(OXYGEN));
        ironMolecule = new Molecule(IRON);
    }
}
