package io.github.vampirestudios.molecularcraft.container;

import io.github.vampirestudios.molecularcraft.blocks.entities.DisassemblerBlockEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Items;
import net.minecraft.text.LiteralText;
import net.minecraft.util.math.BlockPos;
import spinnery.common.BaseContainer;
import spinnery.widget.*;

public class DisassemblerContainer extends BaseContainer {

    DisassemblerBlockEntity blockEntity = null;

    public DisassemblerContainer(int synchronizationID, PlayerInventory linkedPlayerInventory, BlockPos pos) {
        super(synchronizationID, linkedPlayerInventory);

        blockEntity = (DisassemblerBlockEntity) getWorld().getBlockEntity(pos);

        WInterface wInterface = getInterface();

        getInventories().put(1, blockEntity.inventory);

        WSlot.addHeadlessPlayerInventory(wInterface);

        WSlot.addHeadlessArray(wInterface, 0, 1, 1, 1);
        WSlot.addHeadlessArray(wInterface, 1, 1, 9, 2);

        for (WAbstractWidget widget : wInterface.getWidgets()) {
            if (widget instanceof WSlot && ((WSlot) widget).getInventoryNumber() == 1) {
                ((WSlot) widget).setOverrideMaximumCount(true);
                ((WSlot) widget).setMaximumCount(1024);
                if (((WSlot) widget).getSlotNumber() > 0) {
                    ((WSlot) widget).accept(Items.AIR);
                    ((WSlot) widget).setWhitelist();
                }
            }
        }
    }
}
