package io.github.vampirestudios.molecularcraft.enums;

import io.github.vampirestudios.molecularcraft.molecules.Molecule;
import io.github.vampirestudios.molecularcraft.molecules.MoleculeStack;

public class Molecules {

    public static MoleculeStack water;

    public static void init() {
        water = new MoleculeStack(16, new Molecule(Atoms.HYDROGEN, 2), new Molecule(Atoms.OXYGEN));
    }
}
