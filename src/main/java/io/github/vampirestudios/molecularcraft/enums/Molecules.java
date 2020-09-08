package io.github.vampirestudios.molecularcraft.enums;

import com.mojang.serialization.Lifecycle;
import io.github.vampirestudios.molecularcraft.MolecularCraft;
import io.github.vampirestudios.molecularcraft.config.MoleculeDataConfig;
import io.github.vampirestudios.molecularcraft.molecules.Molecule;
import io.github.vampirestudios.molecularcraft.molecules.MoleculeStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.util.registry.SimpleRegistry;

import java.util.ArrayList;
import java.util.List;

import static io.github.vampirestudios.molecularcraft.enums.Atoms.*;
import static io.github.vampirestudios.molecularcraft.enums.MoleculesAmountHelper.MetalOres.INGOT;

public class Molecules {

    public static final SimpleRegistry<MoleculeStack> MOLECULE_STACKS = new SimpleRegistry<>(RegistryKey.ofRegistry(new Identifier(MolecularCraft.MODID, "molecule_stacks")), Lifecycle.stable());

    public static MoleculeStack water;
    public static MoleculeStack celluloseMolecule;
    public static MoleculeStack lignin;
    public static MoleculeStack xylan;
    public static MoleculeStack glucomannan;

    public static MoleculeStack lava;
    public static MoleculeStack siliconDioxide;
    public static MoleculeStack woolMolecule;
    public static MoleculeStack concreteMolecule;
    public static MoleculeStack cementMolecule;
    public static MoleculeStack livingMolecules;
    public static MoleculeStack clayMolecule;
    public static MoleculeStack coalMolecule;
    public static MoleculeStack bronzeMolecule;
    public static MoleculeStack inkMolecule;
    public static MoleculeStack diamondMolecule;
    public static MoleculeStack slimeMolecule;

    public static MoleculeStack nitrate;

    public static MoleculeStack serine;
    public static MoleculeStack glycine;
    public static MoleculeStack alinine;

    public static MoleculeStack emerald;
    public static MoleculeStack electrum;
    public static MoleculeStack peridot;
    public static MoleculeStack ruby;
    public static MoleculeStack sapphire;
    public static MoleculeStack topaz;

    private static MoleculeDataConfig CONFIG;

    public static void init() {
        CONFIG = new MoleculeDataConfig();
        if (!CONFIG.fileExist()) {
            CONFIG.createFile();
        }
        CONFIG.load();
    }
}
