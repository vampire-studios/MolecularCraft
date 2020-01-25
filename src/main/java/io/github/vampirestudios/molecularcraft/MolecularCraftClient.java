package io.github.vampirestudios.molecularcraft;

import io.github.vampirestudios.molecularcraft.container.AssemblerContainer;
import io.github.vampirestudios.molecularcraft.container.AssemblerScreen;
import io.github.vampirestudios.molecularcraft.container.DisassemblerContainer;
import io.github.vampirestudios.molecularcraft.container.DisassemblerScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.screen.ScreenProviderRegistry;
import net.minecraft.container.BlockContext;
import net.minecraft.util.Identifier;

public class MolecularCraftClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ScreenProviderRegistry.INSTANCE.registerFactory(new Identifier("molecularcraft:disassembler"),
                (syncId, id, player, buf) -> new DisassemblerScreen(new DisassemblerContainer(syncId, player.inventory, BlockContext.create(player.world, buf.readBlockPos())),player));
        ScreenProviderRegistry.INSTANCE.registerFactory(new Identifier("molecularcraft:assembler"),
                (syncId, id, player, buf) -> new AssemblerScreen(new AssemblerContainer(syncId, player.inventory, BlockContext.create(player.world, buf.readBlockPos())),player));
    }
}
