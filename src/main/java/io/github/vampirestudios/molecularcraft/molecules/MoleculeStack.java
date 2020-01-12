package io.github.vampirestudios.molecularcraft.molecules;

import io.github.vampirestudios.molecularcraft.enums.Atoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MoleculeStack {
    private List<Molecule> molecules = new ArrayList<>();
    private int amount;

    public MoleculeStack(int amount, Molecule... molecules) {
        this.amount = amount;
        this.molecules.addAll(Arrays.asList(molecules));
    }

    public int getAmount() {
        return amount;
    }

    public List<Molecule> getMolecules() {
        return molecules;
    }
}
