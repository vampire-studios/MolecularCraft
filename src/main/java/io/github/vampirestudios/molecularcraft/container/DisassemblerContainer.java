package io.github.vampirestudios.molecularcraft.container;

import io.github.cottonmc.cotton.gui.CottonCraftingController;
import io.github.cottonmc.cotton.gui.widget.WGridPanel;
import io.github.cottonmc.cotton.gui.widget.WItemSlot;
import io.github.cottonmc.cotton.gui.widget.WTextField;
import io.github.cottonmc.cotton.gui.widget.WTitle;
import io.github.vampirestudios.molecularcraft.blocks.DisassemblerBlock;
import net.minecraft.container.BlockContext;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.recipe.RecipeType;

public class DisassemblerContainer extends CottonCraftingController {

    public DisassemblerContainer(int syncId, PlayerInventory playerInventory, BlockContext context) {
        super(RecipeType.STONECUTTING, syncId, playerInventory, getBlockInventory(context), getBlockPropertyDelegate(context));

        WGridPanel wGridPanel = new WGridPanel();
        setRootPanel(wGridPanel);
        wGridPanel.setSize(150, 180);

        WTitle containerName = new WTitle(DisassemblerBlock.CONTAINER_NAME);
        wGridPanel.add(containerName, 5, 0);

        WItemSlot itemSlot = WItemSlot.of(blockInventory, 0);
        wGridPanel.add(itemSlot, 4, 1);
        int c = 1;
        for (int i = 3; i < 5; i++) {
            for (int a = 0; a < 9; a++) {
                WItemSlot itemSlots = WItemSlot.of(blockInventory, c);
                wGridPanel.add(itemSlots, a, i);
                c++;
            }
        }

        wGridPanel.add(this.createPlayerInventoryPanel(), 0, 6);

        wGridPanel.validate(this);
    }
}
