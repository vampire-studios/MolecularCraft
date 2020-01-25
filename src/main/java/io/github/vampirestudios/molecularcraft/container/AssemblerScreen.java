package io.github.vampirestudios.molecularcraft.container;

import io.github.cottonmc.cotton.gui.client.CottonInventoryScreen;
import net.minecraft.entity.player.PlayerEntity;

public class AssemblerScreen extends CottonInventoryScreen<AssemblerContainer> {
    public AssemblerScreen(AssemblerContainer container, PlayerEntity player) {
        super(container, player);
    }
}
