package io.github.vampirestudios.molecularcraft.molecules;

import io.github.vampirestudios.molecularcraft.enums.Atoms;
import io.github.vampirestudios.molecularcraft.enums.MoleculesAmountHelper;
import io.github.vampirestudios.molecularcraft.items.MoleculeStackItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MoleculeStack {
    private List<Molecule> molecules = new ArrayList<>();
    private int amount;
    private MoleculeStackItem moleculeStackItem;

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
        this.moleculeStackItem = Registry.register(Registry.ITEM,
                new Identifier("molecularcraft", getRegistryName()),
                new MoleculeStackItem(this));
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

    public String getRegistryName() {
        StringBuilder string = new StringBuilder();

        for (Molecule molecule : getMolecules()) {
            string.append(molecule.getAtom().getSymbol()).append(molecule.getAmount());
        }

        return string.toString().toLowerCase();
    }

    public void setMoleculeStackItem(MoleculeStackItem moleculeStackItem) {
        this.moleculeStackItem = moleculeStackItem;
    }

    public MoleculeStackItem getMoleculeStackItem() {
        return moleculeStackItem;
    }

    public ItemStack getMoleculeStackItemStack() {
        return new ItemStack(this::getMoleculeStackItem, getAmount());
    }
}
