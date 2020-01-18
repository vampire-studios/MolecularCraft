package io.github.vampirestudios.molecularcraft.molecules;

import io.github.vampirestudios.molecularcraft.enums.Atoms;
import io.github.vampirestudios.molecularcraft.enums.MoleculesAmountHelper;

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

    public MoleculeStack(MoleculesAmountHelper.MoleculeAmountUnit amountUnit, Molecule... molecules) {
        this.amount = amountUnit.getAmount();
        this.molecules.addAll(Arrays.asList(molecules));
    }

    public MoleculeStack(MoleculesAmountHelper.MoleculeAmount amount, Molecule... molecules) {
        this.amount = amount.getAmount();
        this.molecules.addAll(Arrays.asList(molecules));
    }

    public MoleculeStack(Molecule... molecules) {
        this.amount = 1;
        this.molecules.addAll(Arrays.asList(molecules));
    }

    public MoleculeStack setAmount(int amount) {
        this.amount = amount;
        return this;
    }

    public int getAmount() {
        return amount;
    }

    public List<Molecule> getMolecules() {
        return molecules;
    }
}
