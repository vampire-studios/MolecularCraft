package io.github.vampirestudios.molecularcraft.molecules;

import io.github.vampirestudios.molecularcraft.enums.Atoms;
import io.github.vampirestudios.molecularcraft.enums.Molecules;
import io.github.vampirestudios.molecularcraft.enums.MoleculesAmountHelper;
import io.github.vampirestudios.molecularcraft.items.MoleculeStackItem;
import io.github.vampirestudios.molecularcraft.utils.StringHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
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

    public MoleculeStack(int amount, List<Molecule> list) {
        this.amount = amount;
        this.molecules = list;
        if (Registry.ITEM.get(new Identifier("molecularcraft", getRegistryName())) == null
                || Registry.ITEM.get(new Identifier("molecularcraft", getRegistryName())) == Items.AIR) {
            this.moleculeStackItem = Registry.register(Registry.ITEM,
                    new Identifier("molecularcraft", getRegistryName()),
                    new MoleculeStackItem(this));
        } else {
            this.moleculeStackItem = (MoleculeStackItem) Registry.ITEM.get(new Identifier("molecularcraft", getRegistryName()));
        }
        this.moleculeStackItem.setMoleculeStack(this);
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
        if (Registry.ITEM.get(new Identifier("molecularcraft", getRegistryName())) == null
                || Registry.ITEM.get(new Identifier("molecularcraft", getRegistryName())) == Items.AIR) {
            this.moleculeStackItem = Registry.register(Registry.ITEM,
                    new Identifier("molecularcraft", getRegistryName()),
                    new MoleculeStackItem(this));
        } else {
            this.moleculeStackItem = (MoleculeStackItem) Registry.ITEM.get(new Identifier("molecularcraft", getRegistryName()));
        }
        this.moleculeStackItem.setMoleculeStack(this);
        Molecules.identifiers.add(getRegistryName());
    }

    public MoleculeStack setAmount(int amount) {
        return new MoleculeStack(amount, this.getMolecules());
    }

    public MoleculeStack setAmount(MoleculesAmountHelper.MoleculeAmountUnit amount) {
        return this.setAmount(amount.getAmount());
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

    public String getFormula() {
        StringBuilder string = new StringBuilder();

        for (Molecule molecule : getMolecules()) {
            string.append(molecule.getAtom().getSymbol()).append(molecule.getAmount());
        }

        return StringHelper.subscriptNumbers(string.toString());
    }
}
