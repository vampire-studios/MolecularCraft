package io.github.vampirestudios.molecularcraft;

import com.swordglowsblue.artifice.api.Artifice;
import io.github.vampirestudios.molecularcraft.container.*;
import io.github.vampirestudios.molecularcraft.enums.Atoms;
import io.github.vampirestudios.molecularcraft.enums.Molecules;
import io.github.vampirestudios.molecularcraft.registries.ModContainers;
import io.github.vampirestudios.molecularcraft.utils.PacketHandler;
import io.netty.buffer.ByteBuf;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.fabricmc.fabric.api.network.ClientSidePacketRegistry;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.Identifier;

import static io.github.vampirestudios.molecularcraft.MolecularCraft.MODID;

@Environment(EnvType.CLIENT)
public class MolecularCraftClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ScreenRegistry.<MicroscopeScreenHandler, MicroscopeHandledScreen>register(ModContainers.MICROSCOPE_SCREEN_HANDLER, (gui, inventory, title) -> new MicroscopeHandledScreen(gui, inventory.player, title));
        ScreenRegistry.<AssemblerScreenHandler, AssemblerHandledScreen>register(ModContainers.ASSEMBLER_SCREEN_HANDLER, (gui, inventory, title) -> new AssemblerHandledScreen(gui, inventory.player, title));
        ScreenRegistry.<DisassemblerScreenHandler, DisassemblerHandledScreen>register(ModContainers.DISASSEMBLER_SCREEN_HANDLER, (gui, inventory, title) -> new DisassemblerHandledScreen(gui, inventory.player, title));

        Artifice.registerAssetPack(id("assets").toString(), clientResourcePackBuilder -> {
            for (Atoms atom : Atoms.values()) {
                clientResourcePackBuilder.addItemModel(id(atom.getSymbol().toLowerCase()), modelBuilder -> {
                    modelBuilder.parent(id("minecraft", "item/generated"));
                    modelBuilder.texture("layer0", id("item/atom"));
                });
                clientResourcePackBuilder.addItemModel(id(atom.getSymbol().toLowerCase() + "_64"), modelBuilder -> {
                    modelBuilder.parent(id("minecraft", "item/generated"));
                    modelBuilder.texture("layer0", id("item/atom"));
                });
            }
            for (Identifier identifier : Molecules.MOLECULE_STACKS.getIds()) {
                clientResourcePackBuilder.addItemModel(identifier, modelBuilder -> {
                    modelBuilder.parent(id("minecraft", "item/generated"));
                    modelBuilder.texture("layer0", id("item/molecule"));
                });
                clientResourcePackBuilder.addItemModel(MolecularCraft.id(identifier.getPath() + "_64"), modelBuilder -> {
                    modelBuilder.parent(id("minecraft", "item/generated"));
                    modelBuilder.texture("layer0", id("item/molecule"));
                });
            }
        });

        ClientSidePacketRegistry.INSTANCE.register(MolecularCraft.MOLECULAR_INFO_PACKET,
                (packetContext, attachedData) -> {
                    ByteBuf byteBuf = attachedData.copy();
                    packetContext.getTaskQueue().execute(() -> {
                        PacketHandler.readMolecularInfoPacket(new PacketByteBuf(byteBuf));
                    });
                });
    }

    public static Identifier id(String path) {
        return id(MODID, path);
    }

    public static Identifier id(String modID, String path) {
        return new Identifier(modID, path);
    }
}
