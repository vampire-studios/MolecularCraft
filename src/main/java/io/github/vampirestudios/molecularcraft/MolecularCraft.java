package io.github.vampirestudios.molecularcraft;

import io.github.vampirestudios.molecularcraft.registries.*;
import io.github.vampirestudios.molecularcraft.enums.Molecules;
import net.fabricmc.api.ModInitializer;
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
//		ServerSidePacketRegistry.INSTANCE.register(SLOT_UPDATE_PACKET, (packetContext, packetByteBuffer) -> {
//			int syncId = packetByteBuffer.readInt();
//			int slotNumber = packetByteBuffer.readInt();
//			int inventoryNumber = packetByteBuffer.readInt();
//			CompoundTag tag = packetByteBuffer.readCompoundTag();
//			ItemStack stack = StackUtilities.read(tag);
//			packetContext.getTaskQueue().execute(() -> {
//				if (packetContext.getPlayer().currentScreenHandler instanceof BaseScreenHandler && packetContext.getPlayer().currentScreenHandler.syncId == syncId) {
//					BaseScreenHandler container = (BaseScreenHandler)packetContext.getPlayer().currentScreenHandler;
//					container.getInventory(inventoryNumber).setInvStack(slotNumber, stack);
//					Iterator var6 = container.getInterface().getAllWidgets().iterator();
//
//					while(var6.hasNext()) {
//						WAbstractWidget widget = (WAbstractWidget)var6.next();
//						if (widget instanceof WSlot && ((WSlot)widget).getInventoryNumber() == inventoryNumber && ((WSlot)widget).getSlotNumber() == slotNumber) {
//							((WSlot)widget).setStack(container.getInventory(inventoryNumber).getInvStack(slotNumber));
//						}
//					}
//				}
//
//			});
//		});
	}

//	public static void sendSlotUpdatePacket(int syncId, int slotNumber, int inventoryNumber, ItemStack stack) {
//		PacketByteBuf buffer = new PacketByteBuf(Unpooled.buffer());
//		buffer.writeInt(syncId);
//		buffer.writeInt(slotNumber);
//		buffer.writeInt(inventoryNumber);
//		buffer.writeCompoundTag(StackUtilities.write(stack));
//		ClientSidePacketRegistry.INSTANCE.sendToServer(SLOT_UPDATE_PACKET, buffer);
//	}

	public static Identifier id(String path) {
		return new Identifier(MODID, path);
	}
}
