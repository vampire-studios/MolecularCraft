package io.github.vampirestudios.molecularcraft.items;

import io.github.vampirestudios.molecularcraft.molecules.MoleculeStack;
import io.github.vampirestudios.molecularcraft.registries.ModItems;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.World;

import java.util.List;

public class StackedMoleculeStackItem extends Item {
    private MoleculeStack moleculeStack;

    public StackedMoleculeStackItem(MoleculeStack moleculeStack) {
        super(new Settings().group(ModItems.MOLECULES));
        this.moleculeStack = moleculeStack;
    }

    public MoleculeStack getMoleculeStack() {
        return moleculeStack;
    }

    @Override
    public Text getName() {
        return new TranslatableText("item.molecularcraft.molecule_mole_stack");
    }

    @Override
    public Text getName(ItemStack itemStack) {
        return new TranslatableText("item.molecularcraft.molecule_mole_stack");
    }

    @Environment(EnvType.CLIENT)
    @Override
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);
        String translationKey = "molecule.molecularcraft." + this.getMoleculeStack().getRegistryName();
        String translated = new TranslatableText(translationKey).getString();
        String text = "64*" + translated + " (" + "64" + this.getMoleculeStack().getFormula() + ")";
        if (translationKey.equals(translated)) {
            text = "64" + this.getMoleculeStack().getFormula();
        }
        tooltip.add(new LiteralText(text));
    }

    public void setMoleculeStack(MoleculeStack moleculeStack) {
        this.moleculeStack = moleculeStack;
    }
}
