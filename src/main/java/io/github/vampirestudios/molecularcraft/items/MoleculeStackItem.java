package io.github.vampirestudios.molecularcraft.items;

import io.github.vampirestudios.molecularcraft.molecules.MoleculeStack;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class MoleculeStackItem extends Item {
    private MoleculeStack moleculeStack;

    public MoleculeStackItem(MoleculeStack moleculeStack) {
        super(new Item.Settings().group(ItemGroup.COMBAT));
        this.moleculeStack = moleculeStack;
    }

    public MoleculeStack getMoleculeStack() {
        return moleculeStack;
    }
}
