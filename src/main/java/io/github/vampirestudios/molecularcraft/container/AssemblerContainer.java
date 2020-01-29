//package io.github.vampirestudios.molecularcraft.container;
//
//import io.github.vampirestudios.molecularcraft.blocks.AssemblerBlock;
//import io.github.vampirestudios.molecularcraft.blocks.DisassemblerBlock;
//import io.github.vampirestudios.molecularcraft.blocks.entities.AssemblerBlockEntity;
//import net.minecraft.container.BlockContext;
//import net.minecraft.entity.player.PlayerInventory;
//import net.minecraft.recipe.RecipeType;
//import spinnery.common.BaseContainer;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class AssemblerContainer extends BaseContainer {
//    public AssemblerContainer(int synchronizationID, PlayerInventory linkedPlayerInventory) {
//        super(synchronizationID, linkedPlayerInventory);
//    }
//
////    public AssemblerContainer(int syncId, PlayerInventory playerInventory, BlockContext context) {
////        super(RecipeType.STONECUTTING, syncId, playerInventory, getBlockInventory(context), getBlockPropertyDelegate(context));
////
////        WGridPanel wGridPanel = new WGridPanel();
////        setRootPanel(wGridPanel);
////        wGridPanel.setSize(150, 180);
////
////        WTitle containerName = new WTitle(AssemblerBlock.CONTAINER_NAME);
////        wGridPanel.add(containerName, 5, 0);
////
////        int c = 0;
////        for (int i = 2; i < 11; i++) {
////            WItemSlot itemSlots = WItemSlot.of(blockInventory, c);
////            wGridPanel.add(itemSlots, 1, i);
////            c++;
////        }
////
////        List<WButton> buttons = new ArrayList<WButton>();
////        buttons.add(new WButton());
////
////        WListPanel listPanel = new WListPanel(buttons, WButton::new, (list, supplier) -> {
////            System.out.println("I don't know what to do");
////        });
////
////        wGridPanel.add(listPanel, 3, 1);
////
////        wGridPanel.add(this.createPlayerInventoryPanel(), 1, 13);
////
////        wGridPanel.validate(this);
////    }
//}
