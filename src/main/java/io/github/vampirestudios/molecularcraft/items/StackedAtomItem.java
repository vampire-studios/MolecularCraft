package io.github.vampirestudios.molecularcraft.items;

import io.github.vampirestudios.molecularcraft.enums.Atoms;
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

public class StackedAtomItem extends Item {
    private Atoms atom;

    public StackedAtomItem(Atoms atom) {
        super(new Settings().group(ModItems.ATOMS));
        this.atom = atom;
    }

    public Atoms getAtom() {
        return atom;
    }

    @Override
    public Text getName() {
        return new TranslatableText("item.molecularcraft.atom_mole_stack");
    }

    @Override
    public Text getName(ItemStack itemStack) {
        return new TranslatableText("item.molecularcraft.atom_mole_stack");
    }

    @Environment(EnvType.CLIENT)
    @Override
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);
        tooltip.add(new LiteralText("64*" +new TranslatableText(this.atom.getTranslatableName()).getString() + " (" + this.atom.getStackedSymbol(1) + ")"));
    }
}
