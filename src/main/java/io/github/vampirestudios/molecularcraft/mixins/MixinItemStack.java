package io.github.vampirestudios.molecularcraft.mixins;

import io.github.vampirestudios.molecularcraft.enums.Atoms;
import io.github.vampirestudios.molecularcraft.enums.ItemMolecules;
import io.github.vampirestudios.molecularcraft.molecules.Molecule;
import io.github.vampirestudios.molecularcraft.molecules.MoleculeStack;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.registry.Registry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.Cancellable;

import java.util.ArrayList;
import java.util.List;

@Mixin(ItemStack.class)
public class MixinItemStack {

    @Inject(method = "getTooltip(Lnet/minecraft/entity/player/PlayerEntity;Lnet/minecraft/client/item/TooltipContext;)Ljava/util/List;", at = @At("RETURN"), cancellable = true)
    public void molecularcraft_getToolTip(PlayerEntity player, TooltipContext context, CallbackInfoReturnable callbackInfo) {
        System.out.println("HEY");
        List<Text> tooltip = (List<Text>)callbackInfo.getReturnValue();
        String id = Registry.ITEM.getId(((ItemStack)(Object) this).getItem()).toString();
        for (ItemMolecules itemMolecules : ItemMolecules.registry) {
            System.out.println(itemMolecules.getId() + "==" + id);
            if (itemMolecules.getId().trim().equals(id.trim())) {
                StringBuilder builder = new StringBuilder();
                System.out.println(builder.toString());
                System.out.println("Test?");
                for (MoleculeStack moleculeStack : itemMolecules.getList()) {
                    int moleculeStackAmount = moleculeStack.getAmount();
                    builder.append(moleculeStackAmount);
                    for (Molecule molecule : moleculeStack.getMolecules()) {
                        int moleculeAmount = molecule.getAmount();
                        Atoms atom = molecule.getAtom();
                        builder.append(new TranslatableText(atom.getSymbol()).asString());
                        builder.append(moleculeAmount);
                    }
                    builder.append(" ");
                }
                System.out.println(builder.toString().toString());
                tooltip.add(new LiteralText(builder.toString().toString()));
            }
        };
        callbackInfo.setReturnValue(tooltip);
    }
}
