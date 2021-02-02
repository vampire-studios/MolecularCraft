package io.github.vampirestudios.molecularcraft.utils;

import io.github.vampirestudios.molecularcraft.MolecularCraft;
import io.github.vampirestudios.molecularcraft.enums.Atoms;
import io.github.vampirestudios.molecularcraft.molecules.Molecule;
import io.github.vampirestudios.molecularcraft.molecules.MoleculeStack;
import io.github.vampirestudios.molecularcraft.registries.ItemMolecule;
import io.github.vampirestudios.molecularcraft.registries.ItemMoleculesDataManager;
import io.netty.buffer.Unpooled;
import net.fabricmc.fabric.api.network.ServerSidePacketRegistry;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.PacketByteBuf;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PacketHandler {

    public static void sendMolecularInfoPacket(PlayerEntity playerEntity) {
        PacketByteBuf packetByteBuf = new PacketByteBuf(Unpooled.buffer());
        packetByteBuf.writeInt(ItemMoleculesDataManager.REGISTRY.size());
        for (Map.Entry<String, ItemMolecule> entry : ItemMoleculesDataManager.REGISTRY.entrySet()) {
            packetByteBuf.writeString(entry.getKey());
            ItemMolecule itemMolecule = entry.getValue();
            List<ItemMoleculeComponent> itemMoleculeComponentList = itemMolecule.getListCopy();
            packetByteBuf.writeInt(itemMoleculeComponentList.size());

            for (ItemMoleculeComponent itemMoleculeComponent : itemMoleculeComponentList) {
                ItemMoleculeComponent.Type type = itemMoleculeComponent.getType();
                packetByteBuf.writeEnumConstant(type);
                packetByteBuf.writeInt(itemMoleculeComponent.getAmount());
                switch (type) {
                    case MOLECULE:
                        Molecule molecule = (Molecule) itemMoleculeComponent;
                        packetByteBuf.writeEnumConstant(molecule.getAtom());
                        break;
                    case MOLECULE_STACK:
                        MoleculeStack moleculeStack = (MoleculeStack) itemMoleculeComponent;
                        packetByteBuf.writeInt(moleculeStack.getMolecules().size());
                        for (Molecule molecule1 : moleculeStack.getMolecules()) {
                            packetByteBuf.writeEnumConstant(molecule1.getAtom());
                            packetByteBuf.writeInt(molecule1.getAmount());
                        }
                        break;
                    default:
                        break;
                }
            }
        }

        ServerSidePacketRegistry.INSTANCE.sendToPlayer(playerEntity, MolecularCraft.MOLECULAR_INFO_PACKET, packetByteBuf);
    }

    public static void readMolecularInfoPacket(PacketByteBuf packetByteBuf) {
        ItemMoleculesDataManager.REGISTRY.clear();
        int size = packetByteBuf.readInt();

        for (int i = 0; i < size; i++) {
            String id = packetByteBuf.readString();
            List<ItemMoleculeComponent> itemMoleculeComponentList = new ArrayList<>();
            int iMCLSize = packetByteBuf.readInt();

            for (int j = 0; j < iMCLSize; j++) {
                ItemMoleculeComponent.Type type = packetByteBuf.readEnumConstant(ItemMoleculeComponent.Type.class);
                int amount = packetByteBuf.readInt();
                switch (type) {
                    case MOLECULE:
                        Atoms atom = packetByteBuf.readEnumConstant(Atoms.class);
                        itemMoleculeComponentList.add(new Molecule(atom, amount));
                        break;
                    case MOLECULE_STACK:
                        int moleculeSize = packetByteBuf.readInt();
                        List<Molecule> moleculeList = new ArrayList<>();
                        for (int k = 0; k < moleculeSize; k++) {
                            Atoms atoms = packetByteBuf.readEnumConstant(Atoms.class);
                            int moleculeAmount = packetByteBuf.readInt();
                            moleculeList.add(new Molecule(atoms, moleculeAmount));
                        }
                        itemMoleculeComponentList.add(new MoleculeStack(amount, moleculeList));
                        break;
                    default:
                        break;
                }
            }

            ItemMoleculesDataManager.REGISTRY.put(id, new ItemMolecule(itemMoleculeComponentList));
        }
    }
}
