//package io.github.vampirestudios.molecularcraft.container;
//
//import io.github.vampirestudios.molecularcraft.MolecularCraft;
//import io.github.vampirestudios.molecularcraft.blocks.entities.MicroscopeBlockEntity;
//import io.github.vampirestudios.molecularcraft.items.RecipeItem;
//import io.github.vampirestudios.molecularcraft.molecules.MoleculeStack;
//import io.github.vampirestudios.molecularcraft.recipes.AssemblerRecipeManager;
//import io.github.vampirestudios.molecularcraft.recipes.assembler.AssemblerRecipe;
//import io.github.vampirestudios.molecularcraft.registries.ItemMolecules;
//import io.github.vampirestudios.molecularcraft.registries.ModItems;
//import net.minecraft.entity.player.PlayerEntity;
//import net.minecraft.item.ItemStack;
//import net.minecraft.item.Items;
//import net.minecraft.text.LiteralText;
//import net.minecraft.util.math.BlockPos;
//import net.minecraft.util.registry.Registry;
//import spinnery.common.BaseHandledScreen;
//import spinnery.widget.*;
//import spinnery.widget.api.Position;
//import spinnery.widget.api.Size;
//
//public class MicroscopeHandledScreen extends BaseHandledScreen<MicroscopeScreenHandler> {
//    WStaticText energyText;
//    WStaticText errorText;
//    WStaticText dynamicText;
//    MicroscopeBlockEntity blockEntity;
//    WButton button;
//
//    public MicroscopeHandledScreen(MicroscopeScreenHandler linkedContainer, PlayerEntity player, BlockPos pos) {
//        super(new LiteralText(""), linkedContainer, player);
//
//        blockEntity = (MicroscopeBlockEntity) player.world.getBlockEntity(pos);
//
//        WInterface mainInterface = getInterface();
//
//        WPanel panel = mainInterface.createChild(WPanel::new, Position.of(0, 0, 0), Size.of(170, 180)).setInterface(mainInterface);
//
//        panel.setLabel(new LiteralText("Microscope"));
//
//        panel.setOnAlign(WAbstractWidget::center);
//
//        panel.center();
//
//        mainInterface.add(panel);
//
//        WSlot.addPlayerInventory(Position.of(panel, ((panel.getWidth()) / 2) - (int) (18 * 4.5f), 90, 1), Size.of(18, 18), mainInterface);
//
//        dynamicText = panel.createChild(WStaticText::new, Position.of(panel, 30, 22, 1));
//        dynamicText.setText(" ");
//        panel.add(dynamicText);
//
//        WSlot.addArray(Position.of(panel, 10, 22, 1), Size.of(18, 18), mainInterface, 0, 1, 1, 1);
//
//        WSlot.addArray(Position.of(panel, 10, 50, 1), Size.of(18, 18), mainInterface, 1, 1, 1, 1);
//
//        WSlot.addArray(Position.of(panel, 125, 50, 1), Size.of(18, 18), mainInterface, 2, 1, 1, 1);
//
//        button = panel.createChild(WButton::new, Position.of(panel, 30, 50, 1), Size.of(90, 18)).setLabel("Create Recipe");
//
//        errorText = panel.createChild(WStaticText::new, Position.of(panel, 10, 70, 1));
//        errorText.setText(" ");
//
//        energyText = panel.createChild(WStaticText::new, Position.of(panel, 30, 32, 1));
//        energyText.setText(" ");
//    }
//
//    @Override
//    public void tick() {
//        double energy = blockEntity.getStored(null);
//        double maxE = blockEntity.getMaxStoredPower();
//        energyText.setText("Energy: " + energy + "/" + maxE);
//        ItemStack one = blockEntity.getInvStack(0);
//        String oneId = Registry.ITEM.getId(one.getItem()).toString();
//        ItemStack two = blockEntity.getInvStack(1);
//        String twoId = Registry.ITEM.getId(two.getItem()).toString();
//        ItemStack three = blockEntity.getInvStack(2);
//        String threeId = Registry.ITEM.getId(three.getItem()).toString();
//        if (ItemMolecules.registry.containsKey(oneId)) {
//            ItemMolecules itemMolecule = ItemMolecules.registry.get(oneId);
//            StringBuilder string = new StringBuilder();
//            for (MoleculeStack moleculeStack : itemMolecule.getList()) {
//                if (moleculeStack.getAmount() > 1) string.append(moleculeStack.getAmount());
//                string.append(moleculeStack.getFormula()).append(" ");
//            }
//            dynamicText.setText(string.toString());
//        } else {
//            dynamicText.setText(" ");
//        }
//        if (button.isLowered()) {
//            if (three.getItem() != Items.AIR) {
//                errorText.setText("Recipe Item Slot is already occupied!");
//            } else {
//                errorText.setText(" ");
//                if (two.getItem() == Items.AIR || two.getItem() != Items.PAPER) {
//                    errorText.setText("You need paper to generate a recipe!");
//                } else {
//                    errorText.setText(" ");
//                    if (!ItemMolecules.registry.containsKey(oneId)) {
//                        errorText.setText("The Item you try to get the chemical recipe doesn't have a chemical formula!");
//                    } else {
//                        errorText.setText(" ");
//                        AssemblerRecipe recipe = AssemblerRecipeManager.createRecipe(oneId, ItemMolecules.registry.get(oneId));
//                        ItemStack recipeItem = new ItemStack(ModItems.RECIPE);
//                        RecipeItem.setRecipeComponent(recipeItem, recipe);
//                        MolecularCraft.sendSlotUpdatePacket(this.getHandler().syncId, 2, 1, recipeItem);
//                        MolecularCraft.sendSlotUpdatePacket(this.getHandler().syncId, 1, 1, new ItemStack(two.getItem(), two.getCount() - 1));
//                    }
//                }
//            }
//        }
//        super.tick();
//    }
//}
