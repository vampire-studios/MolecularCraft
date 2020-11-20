package io.github.vampirestudios.molecularcraft.registries;

import io.github.vampirestudios.molecularcraft.molecules.Molecule;
import io.github.vampirestudios.molecularcraft.molecules.MoleculeStack;
import io.github.vampirestudios.molecularcraft.utils.ItemMoleculeComponment;

import java.util.*;

public class ItemMolecule {

    private List<ItemMoleculeComponment> list;

    public ItemMolecule(ItemMoleculeComponment... stack) {
        this(Arrays.asList(stack));
    }

    public ItemMolecule(List<ItemMoleculeComponment> list) {
        this.list = list;
    }

    public ItemMolecule() {
        this(new ArrayList<ItemMoleculeComponment>());
    }

    public List<ItemMoleculeComponment> getListCopy() {
        List<ItemMoleculeComponment> newList = new ArrayList<>();
        for (ItemMoleculeComponment itemMoleculeComponment : this.list) {
            newList.add(itemMoleculeComponment.copy());
        }
        return newList;
    }

    public List<ItemMoleculeComponment> getList() {
        return list;
    }

    public void addMoleculeComponment(ItemMoleculeComponment moleculeStack) {
        if (moleculeStack instanceof MoleculeStack) {
            MoleculeStack moleculeStack1 = (MoleculeStack) moleculeStack;
            List<Molecule> moleculeList = moleculeStack1.getMolecules();

            for (int k = 0; this.list.size() > k; k++) {
                if (this.list.get(k) instanceof MoleculeStack) {
                    MoleculeStack listStack = (MoleculeStack) this.list.get(k);
                    List<Molecule> moleculeList1 = listStack.getMolecules();
                    if (moleculeList.size() == moleculeList1.size()) {
                        boolean equal = true;
                        for (Molecule m1 : moleculeList) {
                            boolean subEqual = false;
                            for (Molecule m2 : moleculeList1) {
                                if (m1.getAtom() == m2.getAtom() && m1.getAmount() == m2.getAmount()) {
                                    subEqual = true;
                                    break;
                                }
                            }
                            if (!subEqual) {
                                equal = false;
                                break;
                            }
                        }
                        if (equal) {
                            moleculeStack1 = listStack.setAmount(listStack.getAmount() + moleculeStack1.getAmount());
                            this.list.set(k, moleculeStack1);
                            return;
                        }
                    }
                }
            }
        } else {
            Molecule molecule = (Molecule) moleculeStack;

            for (int k = 0; this.list.size() > k; k++) {
                if (this.list.get(k) instanceof Molecule) {
                    Molecule listMolecule = (Molecule) this.list.get(k);
                    if (molecule.getAtom() == listMolecule.getAtom()) {
                        listMolecule = new Molecule(molecule.getAtom(), molecule.getAmount() + listMolecule.getAmount());
                        this.list.set(k, listMolecule);
                        return;
                    }
                }
            }
        }

        this.list.add(moleculeStack);
    }

    public ItemMolecule addMoleculeComponments(Collection<ItemMoleculeComponment> moleculeStack) {
        moleculeStack.forEach(this::addMoleculeComponment);
        return this;
    }
}


