package io.github.vampirestudios.molecularcraft.container;

import io.github.cottonmc.cotton.gui.client.CottonInventoryScreen;
import net.minecraft.entity.player.PlayerEntity;

public class MolecularDisassemblerScreen extends CottonInventoryScreen<MolecularDisassemblerContainer> {
    public MolecularDisassemblerScreen(MolecularDisassemblerContainer container, PlayerEntity player) {
        super(container, player);
    }
}
