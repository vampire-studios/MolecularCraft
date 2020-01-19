package io.github.vampirestudios.molecularcraft;

import io.github.vampirestudios.molecularcraft.container.MolecularDisassemblerContainer;
import io.github.vampirestudios.molecularcraft.container.MolecularDisassemblerScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.screen.ScreenProviderRegistry;
import net.minecraft.container.BlockContext;
import net.minecraft.util.Identifier;

public class MolecularCraftClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ScreenProviderRegistry.INSTANCE.registerFactory(new Identifier("molecularcraft:disassembler"),
                (syncId, id, player, buf) -> new MolecularDisassemblerScreen(new MolecularDisassemblerContainer(syncId, player.inventory, BlockContext.create(player.world, buf.readBlockPos())),player));
    }
}
