package io.github.vampirestudios.molecularcraft.molecules;

import io.github.vampirestudios.molecularcraft.enums.Atoms;
import io.github.vampirestudios.molecularcraft.utils.ItemMoleculeComponment;
import io.github.vampirestudios.molecularcraft.utils.StringHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Molecule implements ItemMoleculeComponment {
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
    public ItemMoleculeComponment setAmount(int amount) {
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

    public String getFormula() {
        StringBuilder string = new StringBuilder();

        string.append(this.atom.getSymbol());
        if (this.amount > 1) {
            string.append(this.amount);
        }

        return StringHelper.subscriptNumbers(string.toString());
    }
}
