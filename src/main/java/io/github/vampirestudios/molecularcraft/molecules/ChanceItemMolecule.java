package io.github.vampirestudios.molecularcraft.molecules;

import io.github.vampirestudios.molecularcraft.registries.ItemMolecules;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ChanceItemMolecule extends ItemMolecules {
    private List<List<MoleculeStack>> lists = new ArrayList<>();

    public ChanceItemMolecule() {
        super();
    }

    public ChanceItemMolecule(MoleculeStack[]... stack) {
        for (MoleculeStack[] moleculeStacks : stack) {
            lists.add(Arrays.asList(moleculeStacks));
        }
    }

    @Override
    public List<MoleculeStack> getList() {
        return lists.get(new Random().nextInt(lists.size()));
    }
}
