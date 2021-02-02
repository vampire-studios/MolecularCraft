package io.github.vampirestudios.molecularcraft.molecules;

import io.github.vampirestudios.molecularcraft.enums.Atoms;
import io.github.vampirestudios.molecularcraft.utils.ItemMoleculeComponent;
import io.github.vampirestudios.molecularcraft.utils.StringHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Molecule implements ItemMoleculeComponent {
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

    @Override
    public int getAmount() {
        return amount;
    }

    @Override
    public ItemMoleculeComponent setAmount(int amount) {
        return new Molecule(this.atom, this.amount);
    }

    @Override
    public Item getItem() {
        return this.getAtom().getItem();
    }

    @Override
    public ItemStack getItemStack() {
        return new ItemStack(this::getItem, this.getAmount());
    }

    @Override
    public Item getStackedItem(int power) {
        return this.getAtom().getStackedItem(power);
    }

    @Override
    public ItemStack getStackedItemStack(int power) {
        int stackNumber = 0;
        while (amount > Math.pow(64, power) - 1) {
            stackNumber++;
            this.amount = (int) (amount - Math.pow(64, power));
        }
        return new ItemStack(this.getStackedItem(power), stackNumber);
    }

    @Override
    public String getFormula() {
        StringBuilder string = new StringBuilder();

        string.append(this.atom.getSymbol());
        if (this.amount > 1) {
            string.append(this.amount);
        }

        return StringHelper.subscriptNumbers(string.toString());
    }

    @Override
    public Type getType() {
        return Type.MOLECULE;
    }

    @Override
    public ItemMoleculeComponent copy() {
        return new Molecule(this.atom, this.amount);
    }
}
