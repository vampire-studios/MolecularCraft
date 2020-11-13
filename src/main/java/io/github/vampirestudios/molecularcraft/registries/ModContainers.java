package io.github.vampirestudios.molecularcraft.registries;

import io.github.vampirestudios.molecularcraft.container.AssemblerScreenHandler;
//import io.github.vampirestudios.molecularcraft.container.DisassemblerScreenHandler;
//import io.github.vampirestudios.molecularcraft.container.MicroscopeScreenHandler;
import io.github.vampirestudios.molecularcraft.container.MicroscopeScreenHandler;
import net.fabricmc.fabric.api.container.ContainerProviderRegistry;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class ModContainers {

    public static ScreenHandlerType<AssemblerScreenHandler> ASSEMBLER_SCREEN_HANDLER;
    public static ScreenHandlerType<MicroscopeScreenHandler> MICROSCOPE_SCREEN_HANDLER;

    public static void init() {
//        ContainerProviderRegistry.INSTANCE.registerFactory(new Identifier("molecularcraft:disassembler"),
//                (syncId, id, player, buf) -> new DisassemblerScreenHandler(syncId, player.inventory, buf.readBlockPos()));
//        ContainerProviderRegistry.INSTANCE.registerFactory(new Identifier("molecularcraft:microscope"),
//                (syncId, id, player, buf) -> new MicroscopeScreenHandler(syncId, player.inventory, buf.readBlockPos()));
        ASSEMBLER_SCREEN_HANDLER = ScreenHandlerRegistry.registerExtended(new Identifier("molecularcraft:assembler"), (syncId, inventory, packetByteBuf) -> new AssemblerScreenHandler(syncId, inventory, packetByteBuf.readBlockPos(), ScreenHandlerContext.EMPTY));
        MICROSCOPE_SCREEN_HANDLER = ScreenHandlerRegistry.registerExtended(new Identifier("molecularcraft:microscope"), (syncId, inventory, packetByteBuf) -> new MicroscopeScreenHandler(syncId, inventory, packetByteBuf.readBlockPos(), ScreenHandlerContext.EMPTY));
    }
}
