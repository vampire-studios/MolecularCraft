package io.github.vampirestudios.molecularcraft.container;

import io.github.cottonmc.cotton.gui.CottonCraftingController;
import io.github.cottonmc.cotton.gui.widget.*;
import io.github.vampirestudios.molecularcraft.blocks.DisassemblerBlock;
import io.github.vampirestudios.molecularcraft.blocks.entities.DisassemblerBlockEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.container.BlockContext;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.recipe.RecipeType;
import net.minecraft.text.TranslatableText;
import team.reborn.energy.EnergySide;

public class DisassemblerContainer extends CottonCraftingController {

    private WDynamicLabel dynamicLabel;
    private BlockContext context;

    public DisassemblerContainer(int syncId, PlayerInventory playerInventory, BlockContext context) {
        super(RecipeType.STONECUTTING, syncId, playerInventory, getBlockInventory(context), getBlockPropertyDelegate(context));

        this.context = context;

        WGridPanel wGridPanel = new WGridPanel();
        setRootPanel(wGridPanel);
        wGridPanel.setSize(150, 180);

        WLabel containerName = new WLabel(new TranslatableText("container.molecularcraft.disassembler").asString());
        wGridPanel.add(containerName, 5, 0);

        this.dynamicLabel = new WDynamicLabel(() -> {
            double energyStored = (double)context.run((world1, blockPos) -> {
                BlockEntity blockEntity = this.world.getBlockEntity(blockPos);
                return ((DisassemblerBlockEntity)blockEntity).getStored(EnergySide.UNKNOWN);
            }).orElse(0D);
            double maxEnergyStored = (double)context.run((world1, blockPos) -> {
                BlockEntity blockEntity = this.world.getBlockEntity(blockPos);
                return ((DisassemblerBlockEntity)blockEntity).getMaxStoredPower();
            }).orElse(0D);
            return "Energy: " + energyStored + "/" + maxEnergyStored;
        });

        wGridPanel.add(this.dynamicLabel, 5, 1);

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

    public void tick() {
        this.rootPanel.tick();
        this.rootPanel.remove(this.dynamicLabel);
        this.dynamicLabel = new WDynamicLabel(() -> {
            double energyStored = (double)this.context.run((world1, blockPos) -> {
                BlockEntity blockEntity = this.world.getBlockEntity(blockPos);
                return ((DisassemblerBlockEntity)blockEntity).getStored(EnergySide.UNKNOWN);
            }).orElse(0D);
            double maxEnergyStored = (double)this.context.run((world1, blockPos) -> {
                BlockEntity blockEntity = this.world.getBlockEntity(blockPos);
                return ((DisassemblerBlockEntity)blockEntity).getMaxStoredPower();
            }).orElse(0D);
            return "Energy: " + energyStored + "/" + maxEnergyStored;
        });

        ((WGridPanel)this.rootPanel).add(this.dynamicLabel, 5, 1);
    }
}
