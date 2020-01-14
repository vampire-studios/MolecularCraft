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
        List<Text> tooltip = (List<Text>)callbackInfo.getReturnValue();
        String id = Registry.ITEM.getId(((ItemStack)(Object) this).getItem()).toString();
        for (ItemMolecules itemMolecules : ItemMolecules.registry) {
            if (itemMolecules.getId().trim().equals(id.trim())) {
                StringBuilder builder = new StringBuilder();
                for (MoleculeStack moleculeStack : itemMolecules.getList()) {
                    int moleculeStackAmount = moleculeStack.getAmount();
                    builder.append(moleculeStackAmount);
                    for (Molecule molecule : moleculeStack.getMolecules()) {
                        int moleculeAmount = molecule.getAmount();
                        Atoms atom = molecule.getAtom();
                        builder.append(new TranslatableText(atom.getSymbol()).asString());
                        if (moleculeAmount > 1) builder.append(subscriptNumbers(Integer.toString(moleculeAmount)));
                    }
                    builder.append(" ");
                }
                tooltip.add(new LiteralText(builder.toString()));
            }
        };
        callbackInfo.setReturnValue(tooltip);
    }

    private String subscriptNumbers(String string)
    {
        string = string.replace('0', '\u2080');
        string = string.replace('1', '\u2081');
        string = string.replace('2', '\u2082');
        string = string.replace('3', '\u2083');
        string = string.replace('4', '\u2084');
        string = string.replace('5', '\u2085');
        string = string.replace('6', '\u2086');
        string = string.replace('7', '\u2087');
        string = string.replace('8', '\u2088');
        string = string.replace('9', '\u2089');
        return string;
    }
}
