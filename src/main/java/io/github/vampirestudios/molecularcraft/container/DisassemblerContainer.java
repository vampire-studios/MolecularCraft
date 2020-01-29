package io.github.vampirestudios.molecularcraft.container;

import io.github.vampirestudios.molecularcraft.blocks.DisassemblerBlock;
import io.github.vampirestudios.molecularcraft.blocks.entities.DisassemblerBlockEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.container.BlockContext;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.recipe.RecipeType;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.math.BlockPos;
import spinnery.common.BaseContainer;
import spinnery.widget.WInterface;
import spinnery.widget.WSlot;
import spinnery.widget.WWidget;
import team.reborn.energy.EnergySide;

public class DisassemblerContainer extends BaseContainer {

//    private WDynamicLabel dynamicLabel;
//    private BlockContext context;

    DisassemblerBlockEntity blockEntity = null;

    public DisassemblerContainer(int synchronizationID, PlayerInventory linkedPlayerInventory, BlockPos pos) {
        super(synchronizationID, linkedPlayerInventory);

        blockEntity = (DisassemblerBlockEntity) getLinkedWorld().getBlockEntity(pos);

        WInterface wInterface = new WInterface(this);

        getHolder().add(wInterface);

        getInventories().put(1, blockEntity.inventory);

        WSlot.addPlayerInventory(wInterface, PLAYER_INVENTORY);

        WSlot.addArray(wInterface, 0, 1, 1, 1);
        WSlot.addArray(wInterface, 1, 1, 9, 2);

        for (WWidget widget : wInterface.getWidgets()) {
            if (widget instanceof WSlot && ((WSlot) widget).getInventoryNumber() == 1) {
                ((WSlot) widget).setOverrideMaximumCount(true);
                ((WSlot) widget).setMaximumCount(1024);
            }
        }
    }

//    public DisassemblerContainer(int syncId, PlayerInventory playerInventory, BlockContext context) {
//        super(RecipeType.STONECUTTING, syncId, playerInventory, getBlockInventory(context), getBlockPropertyDelegate(context));
//
//        this.context = context;
//
//        WGridPanel wGridPanel = new WGridPanel();
//        setRootPanel(wGridPanel);
//        wGridPanel.setSize(150, 180);
//
//        WLabel containerName = new WLabel(new TranslatableText("container.molecularcraft.disassembler").asString());
//        wGridPanel.add(containerName, 5, 0);
//
//        this.dynamicLabel = new WDynamicLabel(() -> {
//            double energyStored = (double)context.run((world1, blockPos) -> {
//                BlockEntity blockEntity = this.world.getBlockEntity(blockPos);
//                return ((DisassemblerBlockEntity)blockEntity).getStored(EnergySide.UNKNOWN);
//            }).orElse(0D);
//            double maxEnergyStored = (double)context.run((world1, blockPos) -> {
//                BlockEntity blockEntity = this.world.getBlockEntity(blockPos);
//                return ((DisassemblerBlockEntity)blockEntity).getMaxStoredPower();
//            }).orElse(0D);
//            return "Energy: " + energyStored + "/" + maxEnergyStored;
//        });
//
//        wGridPanel.add(this.dynamicLabel, 5, 1);
//
//        WItemSlot itemSlot = WItemSlot.of(blockInventory, 0);
//        wGridPanel.add(itemSlot, 4, 1);
//        int c = 1;
//        for (int i = 3; i < 5; i++) {
//            for (int a = 0; a < 9; a++) {
//                WItemSlot itemSlots = WItemSlot.of(blockInventory, c);
//                wGridPanel.add(itemSlots, a, i);
//                c++;
//            }
//        }
//
//        wGridPanel.add(this.createPlayerInventoryPanel(), 0, 6);
//
//        wGridPanel.validate(this);
//
//    }

//    public void tick() {
//        this.rootPanel.tick();
//        this.rootPanel.remove(this.dynamicLabel);
//        this.dynamicLabel = new WDynamicLabel(() -> {
//            double energyStored = (double)this.context.run((world1, blockPos) -> {
//                BlockEntity blockEntity = this.world.getBlockEntity(blockPos);
//                return ((DisassemblerBlockEntity)blockEntity).getStored(EnergySide.UNKNOWN);
//            }).orElse(0D);
//            double maxEnergyStored = (double)this.context.run((world1, blockPos) -> {
//                BlockEntity blockEntity = this.world.getBlockEntity(blockPos);
//                return ((DisassemblerBlockEntity)blockEntity).getMaxStoredPower();
//            }).orElse(0D);
//            return "Energy: " + energyStored + "/" + maxEnergyStored;
//        });
//
//        ((WGridPanel)this.rootPanel).add(this.dynamicLabel, 5, 1);
//    }
}
