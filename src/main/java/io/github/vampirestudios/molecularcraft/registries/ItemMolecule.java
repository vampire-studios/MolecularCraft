package io.github.vampirestudios.molecularcraft.registries;

import io.github.vampirestudios.molecularcraft.molecules.Molecule;
import io.github.vampirestudios.molecularcraft.molecules.MoleculeStack;
import io.github.vampirestudios.molecularcraft.utils.ItemMoleculeComponent;

import java.util.*;

public class ItemMolecule {

    private List<ItemMoleculeComponent> list;

    public ItemMolecule(ItemMoleculeComponent... stack) {
        this(Arrays.asList(stack));
    }

    public ItemMolecule(List<ItemMoleculeComponent> list) {
        this.list = list;
    }

    public ItemMolecule() {
        this(new ArrayList<ItemMoleculeComponent>());
    }

    public List<ItemMoleculeComponent> getListCopy() {
        List<ItemMoleculeComponent> newList = new ArrayList<>();
        for (ItemMoleculeComponent itemMoleculeComponent : this.list) {
            newList.add(itemMoleculeComponent.copy());
        }
        return newList;
    }

    public List<ItemMoleculeComponent> getList() {
        return list;
    }

    public void addMoleculeComponment(ItemMoleculeComponent moleculeStack) {
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

    public ItemMolecule addMoleculeComponments(Collection<ItemMoleculeComponent> moleculeStack) {
        moleculeStack.forEach(this::addMoleculeComponment);
        return this;
    }
}


