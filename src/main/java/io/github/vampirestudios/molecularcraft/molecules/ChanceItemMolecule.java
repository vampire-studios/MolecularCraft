package io.github.vampirestudios.molecularcraft.molecules;

import io.github.vampirestudios.molecularcraft.registries.ItemMolecule;
import io.github.vampirestudios.molecularcraft.utils.ItemMoleculeComponment;

import java.util.*;

public class ChanceItemMolecule extends ItemMolecule {
    private List<List<ItemMoleculeComponment>> lists = new ArrayList<>();

    public ChanceItemMolecule() {
        super();
    }

    public ChanceItemMolecule(MoleculeStack[]... stack) {
        this();
        for (MoleculeStack[] moleculeStacks : stack) {
            lists.add(Arrays.asList(moleculeStacks));
        }
    }

    @Override
    public List<ItemMoleculeComponment> getListCopy() {
        return lists.get(new Random().nextInt(lists.size()));
    }

    public List<List<ItemMoleculeComponment>> getLists() {
        return lists;
    }

    public ChanceItemMolecule addMoleculeStackList(List<ItemMoleculeComponment> moleculeStackList) {
        this.lists.add(moleculeStackList);

        return this;
    }

    public ChanceItemMolecule addMoleculeStackList(Collection<List<ItemMoleculeComponment>> moleculeStackListList) {
        moleculeStackListList.forEach(this::addMoleculeStackList);
        return this;
    }

//    @Override
//    public ChanceItemMolecule addMoleculeStack(ItemMoleculeComponment moleculeStack) {
//        for (List<ItemMoleculeComponment> moleculeStackList : this.lists) {
//            MoleculeStack moleculeStack1 = moleculeStack;
//            List<Molecule> moleculeList = moleculeStack1.getMolecules();
//
//            for (int k = 0; moleculeStackList.size() > k; k++) {
//                List<Molecule> moleculeList1 = moleculeStackList.get(k).getMolecules();
//                if (moleculeList.equals(moleculeList1)) {
//                    moleculeStack1 = moleculeStackList.get(k).setAmount(moleculeStackList.get(k).getAmount() + moleculeStack.getAmount());
//                    moleculeStackList.set(k, moleculeStack1);
//                    return this;
//                }
//            }
//
//            moleculeStackList.add(moleculeStack1);
//        }
//        return this;
//    }
//    @Override
//    public ChanceItemMolecule addMoleculeStacks(Collection<MoleculeStack> moleculeStack) {
//        moleculeStack.forEach(this::addMoleculeStack);
//        return this;
//    }
}
