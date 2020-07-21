package io.github.vampirestudios.molecularcraft.molecules;

import io.github.vampirestudios.molecularcraft.MolecularCraft;
import io.github.vampirestudios.molecularcraft.enums.Molecules;
import io.github.vampirestudios.molecularcraft.enums.MoleculesAmountHelper;
import io.github.vampirestudios.molecularcraft.items.MoleculeStackItem;
import io.github.vampirestudios.molecularcraft.utils.ItemMoleculeComponment;
import io.github.vampirestudios.molecularcraft.utils.StringHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MoleculeStack implements ItemMoleculeComponment {
    private List<Molecule> molecules = new ArrayList<>();
    private int amount;

    public MoleculeStack(int amount, Molecule... molecules) {
        this.amount = amount;
        this.molecules.addAll(Arrays.asList(molecules));
    }

    public MoleculeStack(int amount, List<Molecule> list) {
        this.amount = amount;
        this.molecules = list;
//        if (Registry.ITEM.get(new Identifier("molecularcraft", getRegistryName())) == null
//                || Registry.ITEM.get(new Identifier("molecularcraft", getRegistryName())) == Items.AIR) {
//            this.moleculeStackItem = Registry.register(Registry.ITEM,
//                    new Identifier("molecularcraft", getRegistryName()),
//                    new MoleculeStackItem(this));
//        } else {
//            this.moleculeStackItem = Registry.ITEM.get(new Identifier("molecularcraft", getRegistryName()));
//        }
//        if (this.moleculeStackItem instanceof  MoleculeStackItem) ((MoleculeStackItem) this.moleculeStackItem).setMoleculeStack(this);
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
//        if (Registry.ITEM.get(new Identifier("molecularcraft", getRegistryName())) == null
//                || Registry.ITEM.get(new Identifier("molecularcraft", getRegistryName())) == Items.AIR) {
//            this.moleculeStackItem = Registry.register(Registry.ITEM,
//                    new Identifier("molecularcraft", getRegistryName()),
//                    new MoleculeStackItem(this));
//        } else {
//            this.moleculeStackItem = Registry.ITEM.get(new Identifier("molecularcraft", getRegistryName()));
//        }
//        if (this.moleculeStackItem instanceof  MoleculeStackItem) ((MoleculeStackItem) this.moleculeStackItem).setMoleculeStack(this);
//        Molecules.identifiers.add(getRegistryName());
    }

    public MoleculeStack setAmount(int amount) {
        return new MoleculeStack(amount, this.getMolecules());
    }

    public MoleculeStack setAmount(MoleculesAmountHelper.MoleculeAmountUnit amount) {
        return this.setAmount(amount.getAmount());
    }

    public MoleculeStack setAmount(MoleculesAmountHelper.MoleculeAmount amount) {
        return this.setAmount(amount.getAmount());
    }

    public MoleculeStack multiplyAmountBy(int multiplier) {
        return this.setAmount(this.getAmount() * multiplier);
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
            string.append(molecule.getAtom().getSymbol());
            if (molecule.getAmount() > 1) {
                string.append(molecule.getAmount());
            }
        }

        return string.toString().toLowerCase();
    }

//    public void setMoleculeStackItem(MoleculeStackItem moleculeStackItem) {
//        this.moleculeStackItem = moleculeStackItem;
//    }

    @Override
    public Item getItem() {
        return Registry.ITEM.get(new Identifier(MolecularCraft.MODID, this.getRegistryName()));
    }

    @Override
    public ItemStack getItemStack() {
        return new ItemStack(this::getItem, getAmount());
    }

    public String getFormula() {
        StringBuilder string = new StringBuilder();

        for (Molecule molecule : getMolecules()) {
            string.append(molecule.getAtom().getSymbol());
            if (molecule.getAmount() > 1) {
                string.append(molecule.getAmount());
            }
        }

        return StringHelper.subscriptNumbers(string.toString());
    }
}
