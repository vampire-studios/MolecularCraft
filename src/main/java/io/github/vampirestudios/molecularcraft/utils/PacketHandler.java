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
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.PacketByteBuf;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class PacketHandler {

    public static void sendMolecularInfoPacket(PlayerEntity playerEntity) {
        CompoundTag compoundTag = new CompoundTag();
        ListTag molecularInfoList = new ListTag();
        for (Map.Entry<String, ItemMolecule> entry : ItemMoleculesDataManager.REGISTRY.entrySet()) {
            CompoundTag molecularInfo = new CompoundTag();
            molecularInfo.putString("id",entry.getKey());
            ItemMolecule itemMolecule = entry.getValue();

            ListTag itemMoleculeList = new ListTag();

            for (ItemMoleculeComponment itemMoleculeComponment : itemMolecule.getList()) {
                CompoundTag itemMoleculeTag = new CompoundTag();
                ItemMoleculeComponment.Type type = itemMoleculeComponment.getType();
                itemMoleculeTag.putString("type", type.name());
                itemMoleculeTag.putInt("amount", itemMoleculeComponment.getAmount());
                switch (type) {
                    case MOLECULE:
                        Molecule molecule = (Molecule) itemMoleculeComponment;
                        itemMoleculeTag.putString("atom", molecule.getAtom().name());
                        break;
                    case MOLECULE_STACK:
                        MoleculeStack moleculeStack = (MoleculeStack) itemMoleculeComponment;
                        ListTag moleculeList = new ListTag();
                        for (Molecule molecule1 : moleculeStack.getMolecules()) {
                            CompoundTag moleculeTag = new CompoundTag();
                            moleculeTag.putString("atom", molecule1.getAtom().name());
                            moleculeTag.putInt("amount", molecule1.getAmount());
                            moleculeList.add(moleculeTag);
                        }
                        itemMoleculeTag.put("molecules", moleculeList);
                        break;
                    default:
                        break;
                }
                itemMoleculeList.add(itemMoleculeTag);
            }
            molecularInfo.put("itemMolecules", itemMoleculeList);
            molecularInfoList.add(molecularInfo);
        }

        compoundTag.put("infos", molecularInfoList);

        PacketByteBuf packetByteBuf = new PacketByteBuf(Unpooled.buffer());

        packetByteBuf.writeCompoundTag(compoundTag);

        ServerSidePacketRegistry.INSTANCE.sendToPlayer(playerEntity, MolecularCraft.MOLECULAR_INFO_PACKET, packetByteBuf);
    }

    public static void readMolecularInfoPacket(CompoundTag compoundTag) {
        ItemMoleculesDataManager.REGISTRY.clear();

        ListTag listTag = (ListTag) compoundTag.get("infos");

        for (Iterator<Tag> it = listTag.iterator(); it.hasNext(); ) {
            CompoundTag molecularInfo = (CompoundTag) it.next();
            String id = molecularInfo.getString("id");

            ListTag itemMoleculeList = (ListTag) molecularInfo.get("itemMolecules");

            List<ItemMoleculeComponment> itemMoleculeComponmentList = new ArrayList<>();

            for (Iterator<Tag> iter = itemMoleculeList.iterator(); iter.hasNext(); ) {
                CompoundTag itemMoleculeTag = (CompoundTag) iter.next();
                int amount = itemMoleculeTag.getInt("amount");

                switch (ItemMoleculeComponment.Type.valueOf(itemMoleculeTag.getString("type"))) {
                    case MOLECULE:
                        Atoms atom = Atoms.valueOf(itemMoleculeTag.getString("atom"));
                        itemMoleculeComponmentList.add(new Molecule(atom, amount));
                        break;
                    case MOLECULE_STACK:
                        ListTag moleculeTags = (ListTag) itemMoleculeTag.get("molecules");
                        List<Molecule> moleculeList = new ArrayList<>();

                        for (Iterator<Tag> iterator = moleculeTags.iterator(); iterator.hasNext(); ) {
                            CompoundTag moleculeTag = (CompoundTag) iterator.next();
                            Atoms moleculeAtom = Atoms.valueOf(moleculeTag.getString("atom"));
                            int moleculeAmount = moleculeTag.getInt("amount");

                            moleculeList.add(new Molecule(moleculeAtom, moleculeAmount));
                        }

                        itemMoleculeComponmentList.add(new MoleculeStack(amount, moleculeList));
                        break;
                    default:
                        break;
                }

            }

            ItemMoleculesDataManager.REGISTRY.put(id, new ItemMolecule(itemMoleculeComponmentList));
        }
    }
}
