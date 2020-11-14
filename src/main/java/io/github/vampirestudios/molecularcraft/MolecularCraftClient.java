package io.github.vampirestudios.molecularcraft;

import com.swordglowsblue.artifice.api.Artifice;
import io.github.vampirestudios.molecularcraft.container.*;
import io.github.vampirestudios.molecularcraft.enums.Atoms;
import io.github.vampirestudios.molecularcraft.enums.Molecules;
import io.github.vampirestudios.molecularcraft.registries.ModContainers;
import io.github.vampirestudios.molecularcraft.utils.PacketHandler;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.fabricmc.fabric.api.network.ClientSidePacketRegistry;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.Identifier;

import static io.github.vampirestudios.molecularcraft.MolecularCraft.MODID;

@Environment(EnvType.CLIENT)
public class MolecularCraftClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
//        ScreenProviderRegistry.INSTANCE.registerFactory(new Identifier("molecularcraft:disassembler"),
//                (syncId, id, player, buf) -> {
//                    BlockPos pos = buf.readBlockPos();
//                    return new DisassemblerHandledScreen(new DisassemblerScreenHandler(syncId, player.inventory, pos), player, pos);
//        });
        ScreenRegistry.<MicroscopeScreenHandler, MicroscopeHandledScreen>register(ModContainers.MICROSCOPE_SCREEN_HANDLER, (gui, inventory, title) -> new MicroscopeHandledScreen(gui, inventory.player, title));
        ScreenRegistry.<AssemblerScreenHandler, AssemblerHandledScreen>register(ModContainers.ASSEMBLER_SCREEN_HANDLER, (gui, inventory, title) -> new AssemblerHandledScreen(gui, inventory.player, title));
        ScreenRegistry.<DisassemblerScreenHandler, DisassemblerHandledScreen>register(ModContainers.DISASSEMBLER_SCREEN_HANDLER, (gui, inventory, title) -> new DisassemblerHandledScreen(gui, inventory.player, title));

        Artifice.registerAssetPack(id("assets").toString(), clientResourcePackBuilder -> {
            for (Atoms atom : Atoms.values()) {
                clientResourcePackBuilder.addItemModel(id(atom.getSymbol().toLowerCase()), modelBuilder -> {
                    modelBuilder.parent(id("minecraft", "item/generated"));
                    modelBuilder.texture("layer0", id("item/atom"));
                });
            }
            for (Identifier identifier : Molecules.MOLECULE_STACKS.getIds()) {
                clientResourcePackBuilder.addItemModel(identifier, modelBuilder -> {
                    modelBuilder.parent(id("minecraft", "item/generated"));
                    modelBuilder.texture("layer0", id("item/molecule"));
                });
            }
        });

        ClientSidePacketRegistry.INSTANCE.register(MolecularCraft.MOLECULAR_INFO_PACKET,
                (packetContext, attachedData) -> {
                    CompoundTag tag = attachedData.readCompoundTag();
                    packetContext.getTaskQueue().execute(() -> {
                        assert tag != null;
                        PacketHandler.readMolecularInfoPacket(tag);
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
