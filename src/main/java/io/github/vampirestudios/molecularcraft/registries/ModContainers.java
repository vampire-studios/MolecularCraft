package io.github.vampirestudios.molecularcraft.registries;

import io.github.vampirestudios.molecularcraft.container.AssemblerContainer;
import io.github.vampirestudios.molecularcraft.container.DisassemblerContainer;
import io.github.vampirestudios.molecularcraft.container.MicroscopeContainer;
import net.fabricmc.fabric.api.container.ContainerProviderRegistry;
import net.minecraft.container.BlockContext;
import net.minecraft.util.Identifier;

public class ModContainers {

    public static void init() {
        ContainerProviderRegistry.INSTANCE.registerFactory(new Identifier("molecularcraft:disassembler"),
                (syncId, id, player, buf) -> new DisassemblerContainer(syncId, player.inventory, buf.readBlockPos()));
        ContainerProviderRegistry.INSTANCE.registerFactory(new Identifier("molecularcraft:microscope"),
                (syncId, id, player, buf) -> new MicroscopeContainer(syncId, player.inventory, buf.readBlockPos()));
        ContainerProviderRegistry.INSTANCE.registerFactory(new Identifier("molecularcraft:assembler"),
                (syncId, id, player, buf) -> new AssemblerContainer(syncId, player.inventory, buf.readBlockPos()));
    }
}
