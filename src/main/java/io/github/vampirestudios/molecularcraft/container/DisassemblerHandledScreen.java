package io.github.vampirestudios.molecularcraft.container;

import io.github.cottonmc.cotton.gui.client.CottonInventoryScreen;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;

public class DisassemblerHandledScreen extends CottonInventoryScreen<DisassemblerScreenHandler> {

    public DisassemblerHandledScreen(DisassemblerScreenHandler linkedContainer, PlayerEntity player, Text title) {
        super(linkedContainer, player, title);
    }
}
