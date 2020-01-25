package io.github.vampirestudios.molecularcraft.registries;

import io.github.vampirestudios.molecularcraft.container.AssemblerContainer;
import io.github.vampirestudios.molecularcraft.container.DisassemblerContainer;
import net.fabricmc.fabric.api.container.ContainerProviderRegistry;
import net.minecraft.container.BlockContext;
import net.minecraft.util.Identifier;

public class ModContainers {

    public static void init() {
        ContainerProviderRegistry.INSTANCE.registerFactory(new Identifier("molecularcraft:disassembler"),
                (syncId, id, player, buf) -> new DisassemblerContainer(syncId, player.inventory, BlockContext.create(player.world, buf.readBlockPos())));
        ContainerProviderRegistry.INSTANCE.registerFactory(new Identifier("molecularcraft:assembler"),
                (syncId, id, player, buf) -> new AssemblerContainer(syncId, player.inventory, BlockContext.create(player.world, buf.readBlockPos())));
    }
}
