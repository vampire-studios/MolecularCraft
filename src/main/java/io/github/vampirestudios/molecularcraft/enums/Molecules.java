package io.github.vampirestudios.molecularcraft.enums;

import com.mojang.serialization.Lifecycle;
import io.github.vampirestudios.molecularcraft.MolecularCraft;
import io.github.vampirestudios.molecularcraft.config.MoleculeDataConfig;
import io.github.vampirestudios.molecularcraft.molecules.MoleculeStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.util.registry.SimpleRegistry;

public class Molecules {

    public static final SimpleRegistry<MoleculeStack> MOLECULE_STACKS = new SimpleRegistry<>(RegistryKey.ofRegistry(new Identifier(MolecularCraft.MODID, "molecule_stacks")), Lifecycle.stable());

    public static void init() {
        MoleculeDataConfig CONFIG = new MoleculeDataConfig();
        if (!CONFIG.fileExist()) {
            CONFIG.createFile();
        }
        CONFIG.load();
    }
}
