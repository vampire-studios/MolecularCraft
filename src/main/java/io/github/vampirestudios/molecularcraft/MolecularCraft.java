package io.github.vampirestudios.molecularcraft;

import io.github.vampirestudios.molecularcraft.enums.ItemMolecules;
import io.github.vampirestudios.molecularcraft.enums.Molecules;
import io.github.vampirestudios.molecularcraft.registries.ModItems;
import net.fabricmc.api.ModInitializer;

public class MolecularCraft implements ModInitializer {
	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		System.out.println("Hello Fabric world!");
		Molecules.init();
		ModItems.init();
		ItemMolecules.init();
	}
}
