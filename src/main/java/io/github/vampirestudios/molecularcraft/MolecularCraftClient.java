package io.github.vampirestudios.molecularcraft;

import io.github.vampirestudios.molecularcraft.blocks.DisassemblerBlock;
import io.github.vampirestudios.molecularcraft.blocks.entities.DisassemblerBlockEntity;
import io.github.vampirestudios.molecularcraft.container.AssemblerContainer;
import io.github.vampirestudios.molecularcraft.container.AssemblerScreen;
import io.github.vampirestudios.molecularcraft.container.DisassemblerContainer;
import io.github.vampirestudios.molecularcraft.container.DisassemblerScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.screen.ScreenProviderRegistry;
import net.fabricmc.fabric.api.network.ClientSidePacketRegistry;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.container.BlockContext;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class MolecularCraftClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ScreenProviderRegistry.INSTANCE.registerFactory(new Identifier("molecularcraft:disassembler"),
                (syncId, id, player, buf) -> new DisassemblerScreen(new DisassemblerContainer(syncId, player.inventory, BlockContext.create(player.world, buf.readBlockPos())),player));
        ScreenProviderRegistry.INSTANCE.registerFactory(new Identifier("molecularcraft:assembler"),
                (syncId, id, player, buf) -> new AssemblerScreen(new AssemblerContainer(syncId, player.inventory, BlockContext.create(player.world, buf.readBlockPos())),player));

        ClientSidePacketRegistry.INSTANCE.register(MolecularCraft.DISASSEMBLER_ENERGY_UPDATE_PACKET_ID,
                (packetContext, attachedData) -> {
                    BlockPos blockPos = attachedData.readBlockPos();
                    double energy = attachedData.readDouble();
                    packetContext.getTaskQueue().execute(() -> {
                        World world = packetContext.getPlayer().world;
                        BlockEntity blockEntity = world.getBlockEntity(blockPos);
                        if (blockEntity instanceof DisassemblerBlockEntity) {
                            ((DisassemblerBlockEntity)blockEntity).setStored(energy);
                        }
                    });
                });
    }
}
