package io.github.vampirestudios.molecularcraft.mixins;

import io.github.vampirestudios.molecularcraft.enums.Atoms;
import io.github.vampirestudios.molecularcraft.molecules.ChanceItemMolecule;
import io.github.vampirestudios.molecularcraft.molecules.Molecule;
import io.github.vampirestudios.molecularcraft.molecules.MoleculeStack;
import io.github.vampirestudios.molecularcraft.registries.ItemMolecule;
import io.github.vampirestudios.molecularcraft.registries.ItemMoleculesDataManager;
import io.github.vampirestudios.molecularcraft.utils.ItemMoleculeComponment;
import io.github.vampirestudios.molecularcraft.utils.StringHelper;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(ItemStack.class)
public class ItemStackMixin {
//        implements IsotopeItemStackImpl {
//    private long life;
//
//    @Inject(method = "<init>(Lnet/minecraft/item/ItemConvertible;)V", at = @At("RETURN"))
//    public void molecularcraft_constructor(ItemConvertible item, CallbackInfo ci) {
//        if (item != null) {
//            Item item1 = item.asItem();
//            if (item1 != null) {
//                if (item1 instanceof IsotopeItem) {
//                    IsotopeItem isotopeItem = (IsotopeItem) item1;
//                    if (isotopeItem.getIsotope().getDecayMod() != Isotope.DecayMod.STABLE && isotopeItem.getIsotope().getHalfLife() > 0) {
//                        System.out.println("-");
//                        System.out.println(isotopeItem.getIsotope().getHalfLife());
//                        System.out.println("- -");
//                        System.out.println((isotopeItem.getIsotope().getHalfLife() / 1000) * 20);
//                        this.life = (isotopeItem.getIsotope().getHalfLife() / 1000) * 20;
//                    }
//                }
//            }
//        }
//    }

    @Inject(method = "getTooltip(Lnet/minecraft/entity/player/PlayerEntity;Lnet/minecraft/client/item/TooltipContext;)Ljava/util/List;", at = @At("RETURN"), cancellable = true)
    public void molecularcraft_getToolTip(PlayerEntity player, TooltipContext context, CallbackInfoReturnable callbackInfo) {
        List<Text> tooltip = (List<Text>)callbackInfo.getReturnValue();
        CompoundTag tag = ((ItemStack)(Object)this).getOrCreateTag();
        if (tag.contains("inputs", 9)) {
            String outputId = tag.getString("outputId");
            tooltip.add(new LiteralText("Recipe ID: " + outputId));
        }

        Identifier id = Registry.ITEM.getId(((ItemStack)(Object) this).getItem());
        if (ItemMoleculesDataManager.REGISTRY.containsKey(id.toString())) {
            tooltip.add(new LiteralText("Chemical Formula:").formatted(Formatting.DARK_BLUE));
            ItemMolecule itemMolecule = ItemMoleculesDataManager.REGISTRY.get(id.toString());
            if (itemMolecule instanceof ChanceItemMolecule) {
//                List<List<MoleculeStack>> listList = ((ChanceItemMolecule) itemMolecule).getLists();
//                for (List<MoleculeStack> list : listList) {
//                    for (MoleculeStack moleculeStack : list) {
//                        int moleculeStackAmount = moleculeStack.getAmount();
//                        builder.append(moleculeStackAmount);
//                        for (Molecule molecule : moleculeStack.getMolecules()) {
//                            int moleculeAmount = molecule.getAmount();
//                            Atoms atom = molecule.getAtom();
//                            builder.append(new TranslatableText(atom.getSymbol()).getString());
//                            if (moleculeAmount > 1)
//                                builder.append(StringHelper.subscriptNumbers(Integer.toString(moleculeAmount)));
//                        }
//                        builder.append(" ");
//                    }
//                    builder.append("/ ");
//                }
            } else {
                for (ItemMoleculeComponment moleculeStack : itemMolecule.getListCopy()) {
                    StringBuilder builder = new StringBuilder();
                    int moleculeStackAmount = moleculeStack.getAmount();
                    builder.append(moleculeStackAmount);
                    if (moleculeStack instanceof MoleculeStack) {
                        for (Molecule molecule : ((MoleculeStack) moleculeStack).getMolecules()) {
                            int moleculeAmount = molecule.getAmount();
                            Atoms atom = molecule.getAtom();
                            builder.append(atom.getSymbol());
                            if (moleculeAmount > 1)
                                builder.append(StringHelper.subscriptNumbers(Integer.toString(moleculeAmount)));
                        }
                    } else {
                        Atoms atom = ((Molecule) moleculeStack).getAtom();
                        builder.append(atom.getSymbol());
                    }
                    tooltip.add(new LiteralText("- " + builder.toString()).formatted(Formatting.BLUE));
                }
            }
//            if (string.endsWith(" / ")) string = string.substring(0, string.length() - 3);
        }

//        if (((ItemStack)(Object)this).getItem() instanceof IsotopeItem) {
//            IsotopeItem isotopeItem = (IsotopeItem) ((ItemStack)(Object)this).getItem();
//            if (isotopeItem.getIsotope().getDecayMod() != Isotope.DecayMod.STABLE) {
//                float ticks = this.life;
//                float seconds = ticks / 20;
//                float minutes = seconds / 60;
//                float hours = minutes / 60;
//                float days = hours / 24;
//                float years = days / TimeHelper.DAYS_IN_A_YEAR;
//                System.out.println("- - -");
//                System.out.println(this.life);
//                System.out.println(" -------- ");
//                System.out.println(ticks);
//                System.out.println(seconds);
//                System.out.println(minutes);
//                System.out.println(hours);
//                System.out.println(days);
//                System.out.println(years);
//
//                long year = 0;
//                if (years > 0) year = (long) (1 * years);
//                long day = 0;
//                if (days > 0) day = (long) (1 * days);
//                long hour = 0;
//                if (hours > 0) hour = (long) (1 * hours);
//                long minute = 0;
//                if (minutes > 0) minute = (long) (1 * minutes);
//                long second = 0;
//                if (seconds > 0) second = (long) (1 * seconds);
//                long tick = 0;
//                if (ticks > 0) tick = (long) (1 * ticks);
//
//                System.out.println(" --- ");
//                System.out.println(tick);
//                System.out.println(second);
//                System.out.println(minute);
//                System.out.println(hour);
//                System.out.println(day);
//                System.out.println(year);
//
//                long remainingYear = year;
//                long remainingDay = (long) (day % TimeHelper.DAYS_IN_A_YEAR);
//                long remainingHour = hour % 24;
//                long remainingMinute = minute % 60;
//                long remainingSecond = second % 60;
//                long remainingTick = tick % 20;
//
//                System.out.println(" --- ");
//                System.out.println(remainingTick);
//                System.out.println(remainingSecond);
//                System.out.println(remainingMinute);
//                System.out.println(remainingHour);
//                System.out.println(remainingDay);
//                System.out.println(remainingYear);
//
//                tooltip.add(new LiteralText("Time remaining before disintegration :"));
//                if (remainingYear > 0) tooltip.add(new LiteralText(remainingYear + " Year(s)"));
//                if (remainingDay > 0) tooltip.add(new LiteralText(remainingDay + " Day(s)"));
//                if (remainingHour > 0) tooltip.add(new LiteralText(remainingHour + " Hour(s)"));
//                if (remainingMinute > 0) tooltip.add(new LiteralText(remainingMinute + " Minute(s)"));
//                if (remainingSecond > 0) tooltip.add(new LiteralText(remainingSecond + " Second(s)"));
//                if (remainingTick > 0) tooltip.add(new LiteralText(remainingTick + " Tick(s)"));
//            }
//
//
//        }
        callbackInfo.setReturnValue(tooltip);
    }

//    @Inject(method = "copy", cancellable = true, at = @At("RETURN"))
//    public void molecularcraft_copy(CallbackInfoReturnable callbackInfo) {
//        ItemStack itemStack = (ItemStack) callbackInfo.getReturnValue();
//        ItemStackUtils.copy(((ItemStack) (Object) this), itemStack);
//
//
//
//
//        callbackInfo.setReturnValue(itemStack);
//    }
//
//    @Override
//    public long getLife() {
//        return this.life;
//    }
//
//    @Override
//    public void setLife(long life) {
//        this.life = life;
//    }
}
