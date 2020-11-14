package io.github.vampirestudios.molecularcraft.container;

import io.github.cottonmc.cotton.gui.client.CottonInventoryScreen;
import io.github.cottonmc.cotton.gui.widget.WLabel;
import io.github.cottonmc.cotton.gui.widget.WText;
import io.github.vampirestudios.molecularcraft.blocks.entities.MicroscopeBlockEntity;
import io.github.vampirestudios.molecularcraft.registries.ItemMolecule;
import io.github.vampirestudios.molecularcraft.registries.ItemMoleculesDataManager;
import io.github.vampirestudios.molecularcraft.utils.ItemMoleculeComponment;
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
            for (ItemMoleculeComponment moleculeStack : itemMolecule.getList()) {
                if (moleculeStack.getAmount() > 1) string.append(moleculeStack.getAmount());
                string.append(moleculeStack.getFormula()).append(" ");
            }
            dynamicText.setText(new LiteralText(string.toString()));
        } else {
            dynamicText.setText(new LiteralText(""));
        }


//        if (button.isLowered()) {
//            if (three.getItem() != Items.AIR) {
//                errorText.setText("Recipe Item Slot is already occupied!");
//            } else {
//                errorText.setText(" ");
//                if (two.getItem() == Items.AIR || two.getItem() != Items.PAPER) {
//                    errorText.setText("You need paper to generate a recipe!");
//                } else {
//                    errorText.setText(" ");
//                    if (!ItemMolecule.registry.containsKey(oneId)) {
//                        errorText.setText("The Item you try to get the chemical recipe doesn't have a chemical formula!");
//                    } else {
//                        errorText.setText(" ");
//                        AssemblerRecipe recipe = AssemblerRecipeManager.createRecipe(oneId, ItemMolecule.registry.get(oneId));
//                        ItemStack recipeItem = new ItemStack(ModItems.RECIPE);
//                        RecipeItem.setRecipeComponent(recipeItem, recipe);
//                        MolecularCraft.sendSlotUpdatePacket(this.getHandler().syncId, 2, 1, recipeItem);
//                        MolecularCraft.sendSlotUpdatePacket(this.getHandler().syncId, 1, 1, new ItemStack(two.getItem(), two.getCount() - 1));
//                    }
//                }
//            }
//        }
        super.tick();
    }
}
