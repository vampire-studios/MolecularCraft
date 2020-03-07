package io.github.vampirestudios.molecularcraft.container;

import io.github.vampirestudios.molecularcraft.blocks.entities.DisassemblerBlockEntity;
import io.github.vampirestudios.molecularcraft.blocks.entities.MicroscopeBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.LiteralText;
import net.minecraft.util.math.BlockPos;
import spinnery.common.BaseContainerScreen;
import spinnery.widget.*;
import spinnery.widget.api.Position;
import spinnery.widget.api.Size;
import team.reborn.energy.EnergySide;

public class MicroscopeScreen extends BaseContainerScreen<MicroscopeContainer> {
    WStaticText dynamicText;
    MicroscopeBlockEntity blockEntity;

    public MicroscopeScreen(MicroscopeContainer linkedContainer, PlayerEntity player, BlockPos pos) {
        super(new LiteralText(""), linkedContainer, player);

        blockEntity = (MicroscopeBlockEntity) player.world.getBlockEntity(pos);

        WInterface mainInterface = getInterface();

        WPanel panel = mainInterface.createChild(WPanel.class, Position.of(0, 0, 0), Size.of(170, 180)).setInterface(mainInterface);

        panel.setLabel(new LiteralText("Microscope"));

        panel.setOnAlign(WAbstractWidget::center);

        panel.center();

        mainInterface.add(panel);

        WSlot.addPlayerInventory(Position.of(panel, ((panel.getWidth()) / 2) - (int) (18 * 4.5f), 90, 1), Size.of(18, 18), mainInterface);

        dynamicText = new WStaticText();
        dynamicText.setText("BaseText");
        panel.add(dynamicText);

        WSlot.addArray(Position.of(panel, 75, 22, 1), Size.of(18, 18), mainInterface, 0, 1, 1, 1);

        WSlot.addArray(Position.of(panel, 75, 50, 1), Size.of(18, 18), mainInterface, 1, 1, 1, 1);

        WSlot.addArray(Position.of(panel, 75, 75, 1), Size.of(18, 18), mainInterface, 2, 1, 1, 1);

//        WSlot.addArray(Position.of(panel,75, 22, 1), Size.of(18, 18), mainInterface, 0, 1, 1, 1);
//
//        WSlot.addArray(Position.of(panel, 4, 50, 1), Size.of(18, 18), mainInterface, 1, 1, 9, 2);


//        dynamicText = new WStaticText(Position.of(panel, 4, 22, 0), Size.of(60, 18), mainInterface)
//                .setLabel(new LiteralText("§oTest"));
    }

    @Override
    public void tick() {
//        double max = this.blockEntity.getMaxStoredPower();
//        double energy = this.blockEntity.getStored(EnergySide.UNKNOWN);
//        this.dynamicText.setText(new LiteralText("Energy: " + energy + "/" + max));
        super.tick();
    }
}
