package io.github.vampirestudios.molecularcraft.container;

import io.github.cottonmc.cotton.gui.SyncedGuiDescription;
import io.github.cottonmc.cotton.gui.widget.WGridPanel;
import io.github.cottonmc.cotton.gui.widget.WItemSlot;
import io.github.cottonmc.cotton.gui.widget.WLabel;
import io.github.cottonmc.cotton.gui.widget.WTextField;
import io.github.vampirestudios.molecularcraft.blocks.entities.AssemblerBlockEntity;
import io.github.vampirestudios.molecularcraft.registries.ModContainers;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.text.LiteralText;
import net.minecraft.util.math.BlockPos;

public class AssemblerScreenHandler extends SyncedGuiDescription {

    AssemblerBlockEntity blockEntity;
    WLabel textField;

    public AssemblerScreenHandler(int synchronizationID, PlayerInventory linkedPlayerInventory, BlockPos pos, ScreenHandlerContext context) {
        super(ModContainers.ASSEMBLER_SCREEN_HANDLER, synchronizationID, linkedPlayerInventory, getBlockInventory(context, 20), getBlockPropertyDelegate(context));

        blockEntity = (AssemblerBlockEntity) this.world.getBlockEntity(pos);

        WGridPanel root = new WGridPanel();
        setRootPanel(root);
        root.setSize(160, 200);

        WItemSlot itemSlot = new WItemSlot(blockInventory, 0, 9,2, false);
        root.add(itemSlot, 0, 1);
        WItemSlot itemSlot1 = new WItemSlot(blockInventory, 18, 1,1, false);
        root.add(itemSlot1, 0, 4);
        WItemSlot itemSlot2 = new WItemSlot(blockInventory, 19, 1,1, false);
        root.add(itemSlot2, 8, 4);
        textField = new WLabel(new LiteralText("Test"));
        root.add(textField, 0, 3);

        root.add(this.createPlayerInventoryPanel(), 0, 6);

        root.validate(this);

//        WInterface wInterface = getInterface();
//
//        getInventories().put(1, blockEntity.inventory);
//
//        WSlot.addHeadlessPlayerInventory(wInterface);
//
//        WSlot.addHeadlessArray(wInterface, 18, 1, 1, 1);
//        WSlot.addHeadlessArray(wInterface, 19, 1, 1, 1);
//
//        WSlot.addHeadlessArray(wInterface, 0, 1, 9, 2);
//
//        for (WAbstractWidget widget : wInterface.getWidgets()) {
//            if (widget instanceof WSlot && ((WSlot) widget).getInventoryNumber() == 1) {
//                if (((WSlot) widget).getSlotNumber() < 18) {
//                    ((WSlot) widget).setOverrideMaximumCount(true);
//                    ((WSlot) widget).setMaximumCount(1024);
//                }
//            }
//        }
    }
}
