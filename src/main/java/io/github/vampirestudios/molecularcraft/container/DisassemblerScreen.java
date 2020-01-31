package io.github.vampirestudios.molecularcraft.container;

import io.github.vampirestudios.molecularcraft.blocks.entities.DisassemblerBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import spinnery.common.BaseContainer;
import spinnery.common.BaseContainerScreen;
import spinnery.widget.*;
import team.reborn.energy.EnergySide;

public class DisassemblerScreen extends BaseContainerScreen<DisassemblerContainer> {
    WDynamicText dynamicText;
    DisassemblerBlockEntity blockEntity;

    public DisassemblerScreen(DisassemblerContainer linkedContainer, PlayerEntity player, BlockPos pos) {
        super(new LiteralText(""), linkedContainer, player);

        blockEntity = (DisassemblerBlockEntity) player.world.getBlockEntity(pos);

        WInterface mainInterface = new WInterface(WPosition.of(WType.FREE, 0, 0, 0), WSize.of(170, 180), linkedContainer);

        mainInterface.setLabel(new LiteralText("Disassembler"));

        mainInterface.center();

        getHolder().add(mainInterface);

        WSlot.addPlayerInventory(WSize.of(18, 18), mainInterface, BaseContainer.PLAYER_INVENTORY);

        WSlot.addArray(WPosition.of(WType.ANCHORED, 75, 22, 0, mainInterface), WSize.of(18, 18), mainInterface, 0, 1, 1, 1);

        WSlot.addArray(WPosition.of(WType.ANCHORED, 4, 50, 0, mainInterface), WSize.of(18, 18), mainInterface, 1, 1, 9, 2);

        dynamicText = new WDynamicText(WPosition.of(WType.ANCHORED, 4, 22, 0, mainInterface), WSize.of(100, 18), mainInterface);
        dynamicText.setText("Test");

        for (WWidget widget : mainInterface.getWidgets()) {
            if (widget instanceof WSlot && ((WSlot) widget).getInventoryNumber() == 1) {
                ((WSlot) widget).setOverrideMaximumCount(true);
                ((WSlot) widget).setMaximumCount(1024);
            }
        }
    }

    @Override
    public void tick() {
        double max = this.blockEntity.getMaxStoredPower();
        double energy = this.blockEntity.getStored(EnergySide.UNKNOWN);
        this.dynamicText.setText("Energy: " + energy + "/" + max);
        super.tick();
    }

    //    @Override
//    public void tick() {
//        super.tick();
//        this.container.tick();
//    }
}
