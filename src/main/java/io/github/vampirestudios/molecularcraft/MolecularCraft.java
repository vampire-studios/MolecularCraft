package io.github.vampirestudios.molecularcraft;

import io.github.cottonmc.cotton.gui.SyncedGuiDescription;
import io.github.vampirestudios.molecularcraft.registries.*;
import io.github.vampirestudios.molecularcraft.enums.Molecules;
import io.netty.buffer.Unpooled;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.network.ClientSidePacketRegistry;
import net.fabricmc.fabric.api.network.ServerSidePacketRegistry;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.Identifier;

public class MolecularCraft implements ModInitializer {
	public static final String MODID = "molecularcraft";
	public static final Identifier SLOT_UPDATE_PACKET = new Identifier(MODID, "slot_update");
	public static final Identifier MOLECULAR_INFO_PACKET = new Identifier(MODID, "molecular_info");


	@Override
	public void onInitialize() {
		System.out.println("Initializing MolecularCraft");
		ModItems.init();
		ModBlocks.init();
		ModBlockEntities.init();
		ModContainers.init();
		Molecules.init();
		MolecularInfoSetters.init();
		ServerSidePacketRegistry.INSTANCE.register(SLOT_UPDATE_PACKET, (packetContext, packetByteBuffer) -> {
			int syncId = packetByteBuffer.readInt();
			int slotNumber = packetByteBuffer.readInt();
			ItemStack stack = packetByteBuffer.readItemStack();
			packetContext.getTaskQueue().execute(() -> {
				if (packetContext.getPlayer().currentScreenHandler instanceof SyncedGuiDescription && packetContext.getPlayer().currentScreenHandler.syncId == syncId) {
					SyncedGuiDescription container = (SyncedGuiDescription)packetContext.getPlayer().currentScreenHandler;
					container.setStackInSlot(slotNumber, stack);
				}

			});
		});
	}

	public static void sendSlotUpdatePacket(int syncId, int slotNumber, ItemStack stack) {
		PacketByteBuf buffer = new PacketByteBuf(Unpooled.buffer());
		buffer.writeInt(syncId);
		buffer.writeInt(slotNumber);
		buffer.writeItemStack(stack);
		ClientSidePacketRegistry.INSTANCE.sendToServer(SLOT_UPDATE_PACKET, buffer);
	}

	public static Identifier id(String path) {
		return new Identifier(MODID, path);
	}
}
