package io.github.vampirestudios.molecularcraft.container;

import io.github.vampirestudios.molecularcraft.blocks.entities.DisassemblerBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.LiteralText;
import net.minecraft.util.math.BlockPos;
import spinnery.common.BaseContainer;
import spinnery.common.BaseContainerScreen;
import spinnery.widget.*;
import spinnery.widget.api.Position;
import spinnery.widget.api.Size;
import team.reborn.energy.EnergySide;

public class DisassemblerScreen extends BaseContainerScreen<DisassemblerContainer> {
    WStaticText dynamicText;
    DisassemblerBlockEntity blockEntity;

    public DisassemblerScreen(DisassemblerContainer linkedContainer, PlayerEntity player, BlockPos pos) {
        super(new LiteralText(""), linkedContainer, player);

        blockEntity = (DisassemblerBlockEntity) player.world.getBlockEntity(pos);

        WInterface mainInterface = getInterface();

        WPanel panel = mainInterface.createChild(WPanel.class, Position.of(0, 0, 0), Size.of(170, 180)).setInterface(mainInterface);

        panel.setLabel(new LiteralText("Disassembler"));

        panel.setOnAlign(WAbstractWidget::center);

        panel.center();

        mainInterface.add(panel);

        WSlot.addPlayerInventory(Position.of(panel, ((panel.getWidth()) / 2) - (int) (18 * 4.5f), 90, 1), Size.of(18, 18), mainInterface);

        WSlot.addArray(Position.of(panel,75, 22, 1), Size.of(18, 18), mainInterface, 0, 1, 1, 1);

        WSlot.addArray(Position.of(panel, 4, 50, 1), Size.of(18, 18), mainInterface, 1, 1, 9, 2);


//        dynamicText = new WStaticText(Position.of(panel, 4, 22, 0), Size.of(60, 18), mainInterface)
//                .setLabel(new LiteralText("§oTest"));

        for (WAbstractWidget widget : mainInterface.getWidgets()) {
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
//        this.dynamicText.setText(new LiteralText("Energy: " + energy + "/" + max));
        super.tick();
    }
}
