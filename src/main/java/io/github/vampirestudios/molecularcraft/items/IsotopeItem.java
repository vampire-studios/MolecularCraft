package io.github.vampirestudios.molecularcraft.items;

import io.github.vampirestudios.molecularcraft.enums.Atoms;
import io.github.vampirestudios.molecularcraft.impl.IsotopeItemStackImpl;
import io.github.vampirestudios.molecularcraft.molecules.Isotope;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.World;

import java.util.List;

public class IsotopeItem extends Item {
    private Isotope isotope;

    public IsotopeItem(Isotope isotope) {
        super(new Settings().group(ItemGroup.FOOD));
        this.isotope = isotope;
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        super.inventoryTick(stack, world, entity, slot, selected);
//        if (this.isotope.getDecayMod() != Isotope.DecayMod.STABLE) {
//            long life = ((IsotopeItemStackImpl)(Object)stack).getLife();
//            ((IsotopeItemStackImpl)(Object)stack).setLife(life - 1);
//            System.out.println(life);
//        }
    }

    public Isotope getIsotope() {
        return isotope;
    }

    @Override
    public Text getName() {
        return new TranslatableText("item.molecularcraft.isotope_mole");
    }

    @Override
    public Text getName(ItemStack itemStack) {
        return new TranslatableText("item.molecularcraft.isotope_mole");
    }

    @Environment(EnvType.CLIENT)
    @Override
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);
        Atoms atom = this.isotope.getAtom();
        String atomName = new TranslatableText(atom.getTranslatableName()).getString();
        tooltip.add(new LiteralText(atomName + " " + this.isotope.getNucleonNumber()));
    }
}
