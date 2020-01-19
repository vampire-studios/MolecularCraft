package io.github.vampirestudios.molecularcraft;

import io.github.vampirestudios.molecularcraft.enums.ItemMolecules;
import io.github.vampirestudios.molecularcraft.enums.Molecules;
import io.github.vampirestudios.molecularcraft.registries.ModBlockEntities;
import io.github.vampirestudios.molecularcraft.registries.ModBlocks;
import io.github.vampirestudios.molecularcraft.registries.ModContainers;
import io.github.vampirestudios.molecularcraft.registries.ModItems;
import net.fabricmc.api.ModInitializer;

public class MolecularCraft implements ModInitializer {
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
}
