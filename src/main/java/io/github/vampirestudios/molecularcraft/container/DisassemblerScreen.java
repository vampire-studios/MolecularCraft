package io.github.vampirestudios.molecularcraft.container;

import io.github.cottonmc.cotton.gui.client.CottonInventoryScreen;
import net.minecraft.entity.player.PlayerEntity;

public class DisassemblerScreen extends CottonInventoryScreen<DisassemblerContainer> {
    public DisassemblerScreen(DisassemblerContainer container, PlayerEntity player) {
        super(container, player);
    }
}
