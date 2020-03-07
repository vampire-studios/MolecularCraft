package io.github.vampirestudios.molecularcraft.container;

import io.github.vampirestudios.molecularcraft.blocks.entities.DisassemblerBlockEntity;
import io.github.vampirestudios.molecularcraft.blocks.entities.MicroscopeBlockEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.math.BlockPos;
import spinnery.common.BaseContainer;
import spinnery.widget.WInterface;
import spinnery.widget.WSlot;
import spinnery.widget.WStaticText;

public class MicroscopeContainer extends BaseContainer {

    MicroscopeBlockEntity blockEntity = null;
    WStaticText staticText = null;

    public MicroscopeContainer(int synchronizationID, PlayerInventory linkedPlayerInventory, BlockPos pos) {
        super(synchronizationID, linkedPlayerInventory);
        blockEntity = (MicroscopeBlockEntity) getWorld().getBlockEntity(pos);

        WInterface wInterface = getInterface();

        getInventories().put(1, blockEntity.inventory);


        WSlot.addHeadlessPlayerInventory(wInterface);
        WSlot.addHeadlessArray(wInterface, 0, 1, 1, 1);
        WSlot.addHeadlessArray(wInterface, 1, 1, 1, 1);
        WSlot.addHeadlessArray(wInterface, 2, 1, 1, 1);

        staticText = new WStaticText();
        staticText.setText("BaseText");
        wInterface.add(staticText);
    }
}
