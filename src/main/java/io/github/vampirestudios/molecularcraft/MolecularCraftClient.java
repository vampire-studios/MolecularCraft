package io.github.vampirestudios.molecularcraft;

import io.github.vampirestudios.molecularcraft.container.DisassemblerContainer;
import io.github.vampirestudios.molecularcraft.container.DisassemblerScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.screen.ScreenProviderRegistry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

public class MolecularCraftClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ScreenProviderRegistry.INSTANCE.registerFactory(new Identifier("molecularcraft:disassembler"),
                (syncId, id, player, buf) -> {
                    BlockPos pos = buf.readBlockPos();
                    return new DisassemblerScreen(new DisassemblerContainer(syncId, player.inventory, pos), player, pos);
        });
//        ScreenProviderRegistry.INSTANCE.registerFactory(new Identifier("molecularcraft:assembler"),
//                (syncId, id, player, buf) -> new AssemblerScreen(new AssemblerContainer(syncId, player.inventory, BlockContext.create(player.world, buf.readBlockPos())),player));
//
//        ClientSidePacketRegistry.INSTANCE.register(MolecularCraft.DISASSEMBLER_ENERGY_UPDATE_PACKET_ID,
//                (packetContext, attachedData) -> {
//                    BlockPos blockPos = attachedData.readBlockPos();
//                    double energy = attachedData.readDouble();
//                    packetContext.getTaskQueue().execute(() -> {
//                        World world = packetContext.getPlayer().world;
//                        BlockEntity blockEntity = world.getBlockEntity(blockPos);
//                        if (blockEntity instanceof DisassemblerBlockEntity) {
//                            ((DisassemblerBlockEntity)blockEntity).setStored(energy);
//                        }
//                    });
//                });
    }
}
