package io.github.vampirestudios.molecularcraft.container;

import io.github.vampirestudios.molecularcraft.blocks.entities.MicroscopeBlockEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Items;
import net.minecraft.util.math.BlockPos;
import spinnery.common.BaseContainer;
import spinnery.widget.WAbstractWidget;
import spinnery.widget.WInterface;
import spinnery.widget.WSlot;

public class MicroscopeContainer extends BaseContainer {

    MicroscopeBlockEntity blockEntity = null;

    public MicroscopeContainer(int synchronizationID, PlayerInventory linkedPlayerInventory, BlockPos pos) {
        super(synchronizationID, linkedPlayerInventory);
        blockEntity = (MicroscopeBlockEntity) getWorld().getBlockEntity(pos);

        WInterface wInterface = getInterface();

        getInventories().put(1, blockEntity.inventory);


        WSlot.addHeadlessPlayerInventory(wInterface);
        WSlot.addHeadlessArray(wInterface, 0, 1, 1, 1);
        WSlot.addHeadlessArray(wInterface, 1, 1, 1, 1);
        WSlot.addHeadlessArray(wInterface, 2, 1, 1, 1);

        for (WAbstractWidget widget : wInterface.getWidgets()) {
            if (widget instanceof WSlot) {
                WSlot slot = (WSlot) widget;
                if (slot.getInventoryNumber() == 1) {
                    if (slot.getSlotNumber() == 1) {
                        slot.accept(Items.PAPER);
                        slot.setWhitelist();
                    }
                    if (slot.getSlotNumber() == 2) {
                        slot.accept(Items.AIR);
                        slot.setWhitelist();
                    }
                }
            }
        }
    }
}
