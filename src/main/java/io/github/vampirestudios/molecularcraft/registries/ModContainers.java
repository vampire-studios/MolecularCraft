package io.github.vampirestudios.molecularcraft.registries;

import io.github.vampirestudios.molecularcraft.container.AssemblerScreenHandler;
import io.github.vampirestudios.molecularcraft.container.DisassemblerScreenHandler;
import io.github.vampirestudios.molecularcraft.container.MicroscopeScreenHandler;
import net.fabricmc.fabric.api.container.ContainerProviderRegistry;
import net.minecraft.util.Identifier;

public class ModContainers {

    public static void init() {
        ContainerProviderRegistry.INSTANCE.registerFactory(new Identifier("molecularcraft:disassembler"),
                (syncId, id, player, buf) -> new DisassemblerScreenHandler(syncId, player.inventory, buf.readBlockPos()));
        ContainerProviderRegistry.INSTANCE.registerFactory(new Identifier("molecularcraft:microscope"),
                (syncId, id, player, buf) -> new MicroscopeScreenHandler(syncId, player.inventory, buf.readBlockPos()));
        ContainerProviderRegistry.INSTANCE.registerFactory(new Identifier("molecularcraft:assembler"),
                (syncId, id, player, buf) -> new AssemblerScreenHandler(syncId, player.inventory, buf.readBlockPos()));
    }
}
