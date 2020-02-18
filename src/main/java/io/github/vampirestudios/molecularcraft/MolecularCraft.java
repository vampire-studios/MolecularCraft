package io.github.vampirestudios.molecularcraft;

import io.github.vampirestudios.molecularcraft.registries.ItemMolecules;
import io.github.vampirestudios.molecularcraft.enums.Molecules;
import io.github.vampirestudios.molecularcraft.registries.ModBlockEntities;
import io.github.vampirestudios.molecularcraft.registries.ModBlocks;
import io.github.vampirestudios.molecularcraft.registries.ModContainers;
import io.github.vampirestudios.molecularcraft.registries.ModItems;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;

public class MolecularCraft implements ModInitializer {
	public static final String MODID = "molecularcraft";
//	public static final Identifier DISASSEMBLER_ENERGY_UPDATE_PACKET_ID = id("disassembler_energy_update");

	@Override
	public void onInitialize() {
		System.out.println("Initializing MolecularCraft");
		ModBlocks.init();
		ModBlockEntities.init();
		ModContainers.init();
		Molecules.init();
		ModItems.init();
		ItemMolecules.init();
	}

	public static Identifier id(String path) {
		return new Identifier(MODID, path);
	}
}
