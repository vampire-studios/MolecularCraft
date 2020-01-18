package io.github.vampirestudios.molecularcraft.items;

import io.github.vampirestudios.molecularcraft.enums.Atoms;
import io.github.vampirestudios.molecularcraft.impl.IsotopeItemStackImpl;
import io.github.vampirestudios.molecularcraft.molecules.Isotope;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class IsotopeItem extends Item {
    private Isotope isotope;

    public IsotopeItem(Isotope isotope) {
        super(new Settings().maxCount(1).group(ItemGroup.FOOD));
        this.isotope = isotope;
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        super.inventoryTick(stack, world, entity, slot, selected);
        if (this.isotope.getDecayMod() != Isotope.DecayMod.STABLE) {
            long life = ((IsotopeItemStackImpl)(Object)stack).getLife();
            ((IsotopeItemStackImpl)(Object)stack).setLife(life - 1);
            System.out.println(life);
        }
    }

    public Isotope getIsotope() {
        return isotope;
    }
}
