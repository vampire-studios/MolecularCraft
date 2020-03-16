package io.github.vampirestudios.molecularcraft.container;

import io.github.vampirestudios.molecularcraft.blocks.entities.AssemblerBlockEntity;
import io.github.vampirestudios.molecularcraft.blocks.entities.DisassemblerBlockEntity;
import io.github.vampirestudios.molecularcraft.registries.ModItems;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Items;
import net.minecraft.util.math.BlockPos;
import spinnery.common.BaseScreenHandler;
import spinnery.widget.WAbstractWidget;
import spinnery.widget.WInterface;
import spinnery.widget.WSlot;

public class AssemblerScreenHandler extends BaseScreenHandler {

    AssemblerBlockEntity blockEntity = null;

    public AssemblerScreenHandler(int synchronizationID, PlayerInventory linkedPlayerInventory, BlockPos pos) {
        super(synchronizationID, linkedPlayerInventory);

        blockEntity = (AssemblerBlockEntity) getWorld().getBlockEntity(pos);

        WInterface wInterface = getInterface();

        getInventories().put(1, blockEntity.inventory);

        WSlot.addHeadlessPlayerInventory(wInterface);

        WSlot.addHeadlessArray(wInterface, 18, 1, 1, 1);
        WSlot.addHeadlessArray(wInterface, 19, 1, 1, 1);

        WSlot.addHeadlessArray(wInterface, 0, 1, 9, 2);

        for (WAbstractWidget widget : wInterface.getWidgets()) {
            if (widget instanceof WSlot && ((WSlot) widget).getInventoryNumber() == 1) {
                if (((WSlot) widget).getSlotNumber() < 18) {
                    ((WSlot) widget).setOverrideMaximumCount(true);
                    ((WSlot) widget).setMaximumCount(1024);
                }
            }
        }
    }
}
