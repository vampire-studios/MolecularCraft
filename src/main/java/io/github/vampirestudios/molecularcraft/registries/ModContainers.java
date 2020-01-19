package io.github.vampirestudios.molecularcraft.registries;

import io.github.vampirestudios.molecularcraft.container.MolecularDisassemblerContainer;
import net.fabricmc.fabric.api.container.ContainerProviderRegistry;
import net.minecraft.container.BlockContext;
import net.minecraft.util.Identifier;

public class ModContainers {

    public static void init() {
        ContainerProviderRegistry.INSTANCE.registerFactory(new Identifier("molecularcraft:disassembler"),
                (syncId, id, player, buf) -> new MolecularDisassemblerContainer(syncId, player.inventory, BlockContext.create(player.world, buf.readBlockPos())));
        }
}
