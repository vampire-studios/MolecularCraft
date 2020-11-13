package io.github.vampirestudios.molecularcraft.container;

import io.github.cottonmc.cotton.gui.SyncedGuiDescription;
import io.github.cottonmc.cotton.gui.widget.WButton;
import io.github.cottonmc.cotton.gui.widget.WGridPanel;
import io.github.cottonmc.cotton.gui.widget.WItemSlot;
import io.github.cottonmc.cotton.gui.widget.WLabel;
import io.github.vampirestudios.molecularcraft.blocks.entities.MicroscopeBlockEntity;
import io.github.vampirestudios.molecularcraft.registries.ModContainers;
import io.github.vampirestudios.molecularcraft.registries.ModItems;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Items;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.text.LiteralText;
import net.minecraft.util.math.BlockPos;

public class MicroscopeScreenHandler extends SyncedGuiDescription {

    WLabel dynamicText;
    MicroscopeBlockEntity blockEntity;
    WLabel energyText;
    WButton wButton;

    public MicroscopeScreenHandler(int synchronizationID, PlayerInventory linkedPlayerInventory, BlockPos pos, ScreenHandlerContext context) {
        super(ModContainers.MICROSCOPE_SCREEN_HANDLER, synchronizationID, linkedPlayerInventory, getBlockInventory(context, 3), getBlockPropertyDelegate(context));
        blockEntity = (MicroscopeBlockEntity) this.world.getBlockEntity(pos);

        WGridPanel root = new WGridPanel();
        setRootPanel(root);
        root.setSize(160, 200);

        WItemSlot itemSlot = new WItemSlot(blockInventory, 0, 1, 1, false);
        root.add(itemSlot, 0, 1);

        WItemSlot paperSlot = new WItemSlot(blockInventory, 1, 1, 1, false)
                .setFilter((itemStack) -> itemStack.getItem() == Items.PAPER);
        root.add(paperSlot, 0, 4);

        WItemSlot resultSlot = new WItemSlot(blockInventory, 2, 1, 1, false)
                .setFilter((itemStack -> itemStack.getItem() == ModItems.RECIPE))
                .setInsertingAllowed(true);
        root.add(resultSlot, 8, 4);

        energyText = new WLabel(new LiteralText("Test"));
        root.add(energyText, 0, 3);
        dynamicText = new WLabel(new LiteralText("Test"));
        root.add(dynamicText, 7, 2);

        wButton = new WButton(new LiteralText("Create Recipe"));
        root.add(wButton, 4, 12);

        root.add(this.createPlayerInventoryPanel(), 0, 6);

        root.validate(this);
    }
}
