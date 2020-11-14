package io.github.vampirestudios.molecularcraft.container;

import io.github.cottonmc.cotton.gui.SyncedGuiDescription;
import io.github.cottonmc.cotton.gui.widget.WBar;
import io.github.cottonmc.cotton.gui.widget.WGridPanel;
import io.github.cottonmc.cotton.gui.widget.WItemSlot;
import io.github.vampirestudios.molecularcraft.container.widget.WEnergyBar;
import io.github.vampirestudios.molecularcraft.registries.ModContainers;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.util.math.BlockPos;

public class DisassemblerScreenHandler extends SyncedGuiDescription {

    public DisassemblerScreenHandler(int synchronizationID, PlayerInventory linkedPlayerInventory, BlockPos pos, ScreenHandlerContext context) {
        super(ModContainers.DISASSEMBLER_SCREEN_HANDLER, synchronizationID, linkedPlayerInventory, getBlockInventory(context, 19), getBlockPropertyDelegate(context, 2));

        WGridPanel root = new WGridPanel();
        setRootPanel(root);
        root.setSize(160, 200);

        WItemSlot inputSlot = new WItemSlot(blockInventory, 0, 1, 1, false);
        root.add(inputSlot, 4, 1);
        WItemSlot outputSlots = new WItemSlot(blockInventory, 1, 9, 2, false)
                .setInsertingAllowed(false);
        root.add(outputSlots, 0, 3);

        WBar energyBar = new WEnergyBar(0, 1);
        root.add(energyBar, 0, 5, 9, 1);

        root.add(this.createPlayerInventoryPanel(), 0, 6);

        root.validate(this);
    }
}
