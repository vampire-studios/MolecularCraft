package io.github.vampirestudios.molecularcraft.molecules;

import io.github.vampirestudios.molecularcraft.enums.Atoms;

public class Molecule {
    private Atoms atom = null;
    private int amount = 1;

    public Molecule(Atoms atom, int amount) {
        this.atom = atom;
        this.amount = amount;
    }

    public Molecule(Atoms atom) {
        this.atom = atom;
    }

    public Atoms getAtom() {
        return atom;
    }

    public int getAmount() {
        return amount;
    }
}
