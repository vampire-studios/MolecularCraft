package io.github.vampirestudios.molecularcraft;

import io.github.vampirestudios.molecularcraft.registries.*;
import io.github.vampirestudios.molecularcraft.enums.Molecules;
import io.netty.buffer.Unpooled;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.network.ClientSidePacketRegistry;
import net.fabricmc.fabric.api.network.ServerSidePacketRegistry;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.Identifier;
import net.minecraft.util.PacketByteBuf;
import spinnery.common.BaseScreenHandler;
import spinnery.util.StackUtilities;
import spinnery.widget.WAbstractWidget;
import spinnery.widget.WSlot;

import java.util.Iterator;

public class MolecularCraft implements ModInitializer {
	public static final String MODID = "molecularcraft";
	public static final Identifier SLOT_UPDATE_PACKET = new Identifier(MODID, "slot_update");

	@Override
	public void onInitialize() {
		System.out.println("Initializing MolecularCraft");
		ModBlocks.init();
		ModBlockEntities.init();
		ModContainers.init();
		Molecules.init();
		ModItems.init();
		ItemMolecules.init();
		MolecularInfoSetters.init();
		ServerSidePacketRegistry.INSTANCE.register(SLOT_UPDATE_PACKET, (packetContext, packetByteBuffer) -> {
			int syncId = packetByteBuffer.readInt();
			int slotNumber = packetByteBuffer.readInt();
			int inventoryNumber = packetByteBuffer.readInt();
			CompoundTag tag = packetByteBuffer.readCompoundTag();
			ItemStack stack = StackUtilities.read(tag);
			packetContext.getTaskQueue().execute(() -> {
				if (packetContext.getPlayer().currentScreenHandler instanceof BaseScreenHandler && packetContext.getPlayer().currentScreenHandler.syncId == syncId) {
					BaseScreenHandler container = (BaseScreenHandler)packetContext.getPlayer().currentScreenHandler;
					container.getInventory(inventoryNumber).setInvStack(slotNumber, stack);
					Iterator var6 = container.getInterface().getAllWidgets().iterator();

					while(var6.hasNext()) {
						WAbstractWidget widget = (WAbstractWidget)var6.next();
						if (widget instanceof WSlot && ((WSlot)widget).getInventoryNumber() == inventoryNumber && ((WSlot)widget).getSlotNumber() == slotNumber) {
							((WSlot)widget).setStack(container.getInventory(inventoryNumber).getInvStack(slotNumber));
						}
					}
				}

			});
		});
	}

	public static void sendSlotUpdatePacket(int syncId, int slotNumber, int inventoryNumber, ItemStack stack) {
		PacketByteBuf buffer = new PacketByteBuf(Unpooled.buffer());
		buffer.writeInt(syncId);
		buffer.writeInt(slotNumber);
		buffer.writeInt(inventoryNumber);
		buffer.writeCompoundTag(StackUtilities.write(stack));
		ClientSidePacketRegistry.INSTANCE.sendToServer(SLOT_UPDATE_PACKET, buffer);
	}

	public static Identifier id(String path) {
		return new Identifier(MODID, path);
	}
}
