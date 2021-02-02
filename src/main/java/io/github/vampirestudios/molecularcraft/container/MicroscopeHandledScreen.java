package io.github.vampirestudios.molecularcraft.container;

import io.github.cottonmc.cotton.gui.client.CottonInventoryScreen;
import io.github.cottonmc.cotton.gui.widget.WText;
import io.github.vampirestudios.molecularcraft.enums.Atoms;
import io.github.vampirestudios.molecularcraft.items.MoleculeStackItem;
import io.github.vampirestudios.molecularcraft.items.StackedAtomItem;
import io.github.vampirestudios.molecularcraft.items.StackedMoleculeStackItem;
import io.github.vampirestudios.molecularcraft.molecules.Molecule;
import io.github.vampirestudios.molecularcraft.molecules.MoleculeStack;
import io.github.vampirestudios.molecularcraft.registries.ItemMolecule;
import io.github.vampirestudios.molecularcraft.registries.ItemMoleculesDataManager;
import io.github.vampirestudios.molecularcraft.utils.ItemMoleculeComponent;
import io.github.vampirestudios.molecularcraft.utils.StringHelper;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.util.registry.Registry;

public class MicroscopeHandledScreen extends CottonInventoryScreen<MicroscopeScreenHandler> {
    WText dynamicText;

    public MicroscopeHandledScreen(MicroscopeScreenHandler linkedContainer, PlayerEntity player, Text title) {
        super(linkedContainer, player, title);
        dynamicText = linkedContainer.dynamicText;
    }

    @Override
    public void tick() {
        ItemStack one = this.getScreenHandler().getStacks().get(0);
        String oneId = Registry.ITEM.getId(one.getItem()).toString();
        if (ItemMoleculesDataManager.REGISTRY.containsKey(oneId)) {
            ItemMolecule itemMolecule = ItemMoleculesDataManager.REGISTRY.get(oneId);
            StringBuilder string = new StringBuilder();
            for (ItemMoleculeComponent moleculeStack : itemMolecule.getListCopy()) {
                int moleculeStackAmount = moleculeStack.getAmount();
                string.append(moleculeStackAmount);
                if (moleculeStack instanceof MoleculeStack) {
                    for (Molecule molecule : ((MoleculeStack) moleculeStack).getMolecules()) {
                        int moleculeAmount = molecule.getAmount();
                        Atoms atom = molecule.getAtom();
                        string.append(atom.getSymbol());
                        if (moleculeAmount > 1)
                            string.append(StringHelper.subscriptNumbers(Integer.toString(moleculeAmount)));
                    }
                } else {
                    Atoms atom = ((Molecule) moleculeStack).getAtom();
                    string.append(atom.getSymbol());
                }
                string.append(" ");
            }
            dynamicText.setText(new LiteralText(string.toString()));
        } else if (one.getItem() instanceof MoleculeStackItem) {
            MoleculeStackItem moleculeStackItem = (MoleculeStackItem) one.getItem();
            MoleculeStack moleculeStack = moleculeStackItem.getMoleculeStack();
            dynamicText.setText(new LiteralText(moleculeStack.getFormula()));
        } else if (one.getItem() instanceof StackedMoleculeStackItem) {
            StackedMoleculeStackItem moleculeStackItem = (StackedMoleculeStackItem) one.getItem();
            MoleculeStack moleculeStack = moleculeStackItem.getMoleculeStack();
            dynamicText.setText(new LiteralText("64*" + moleculeStack.getFormula()));
        } else if (one.getItem() instanceof StackedAtomItem) {
            StackedAtomItem moleculeStackItem = (StackedAtomItem) one.getItem();
            Atoms atom = moleculeStackItem.getAtom();
            dynamicText.setText(new LiteralText(atom.getStackedSymbol(1)));
        } else {
            dynamicText.setText(new LiteralText(""));
        }
        super.tick();
    }
}
