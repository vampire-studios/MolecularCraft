package io.github.vampirestudios.molecularcraft.enums;

import io.github.vampirestudios.molecularcraft.molecules.Molecule;
import io.github.vampirestudios.molecularcraft.molecules.MoleculeStack;

import java.util.ArrayList;
import java.util.List;

import static io.github.vampirestudios.molecularcraft.enums.Atoms.*;
import static io.github.vampirestudios.molecularcraft.enums.MoleculesAmountHelper.MetalOres.INGOT;

public class Molecules {

    public static final List<String> identifiers = new ArrayList<>();

    public static MoleculeStack water;
    public static Molecule ironMolecule;
    public static MoleculeStack celluloseMolecule;
    public static Molecule carbonMolecule;
    public static MoleculeStack lava;
    public static MoleculeStack obsidianMolecule;
    public static MoleculeStack siliconDioxide;
    public static MoleculeStack woolMolecule;
    public static MoleculeStack concreteMolecule;
    public static MoleculeStack cementMolecule;
    public static Molecule calciumMolecule;
    public static MoleculeStack livingMolecules;
    public static MoleculeStack clayMolecule;
    public static MoleculeStack coalMolecule;
    public static MoleculeStack bronzeMolecule;
    public static MoleculeStack inkMolecule;
    public static MoleculeStack diamondMolecule;
    public static Molecule goldMolecule;
    public static MoleculeStack slimeMolecule;

    public static MoleculeStack nitrate;

    public static MoleculeStack serine;
    public static MoleculeStack glycine;
    public static MoleculeStack alinine;

    public static MoleculeStack emerald;
    public static Molecule aluminum;
    public static Molecule cobalt;
    public static Molecule copper;
    public static MoleculeStack electrum;

    public static void init() {
        water = new MoleculeStack(new Molecule(HYDROGEN, 2), new Molecule(OXYGEN));
        ironMolecule = new Molecule(IRON);
        celluloseMolecule = new MoleculeStack(new Molecule(CARBON, 6), new Molecule(HYDROGEN, 10), new Molecule(OXYGEN, 5));
        carbonMolecule = new Molecule(CARBON);
        diamondMolecule = new MoleculeStack(new Molecule(CARBON, 64), new Molecule(CARBON, 64), new Molecule(CARBON, 64), new Molecule(CARBON, 64));
        lava = new MoleculeStack(new Molecule(CARBON, 5));
        siliconDioxide = new MoleculeStack(new Molecule(SILICON), new Molecule(OXYGEN, 2));
        woolMolecule = new MoleculeStack(new Molecule(CARBON, 2), new Molecule(HYDROGEN, 13), new Molecule(OXYGEN, 7), new Molecule(NITROGEN, 6));
        concreteMolecule = new MoleculeStack(new Molecule(HYDROGEN, 2), new Molecule(OXYGEN, 13), new Molecule(SILICON, 2), new Molecule(SULFUR, 1), new Molecule(ALUMINIUM, 2), new Molecule(IRON, 2), new Molecule(CALCIUM));
        cementMolecule = new MoleculeStack(new Molecule(OXYGEN, 12), new Molecule(SILICON, 2), new Molecule(SULFUR, 1), new Molecule(ALUMINIUM, 2), new Molecule(IRON, 2), new Molecule(CALCIUM));
        calciumMolecule = new Molecule(CALCIUM);
        livingMolecules = new MoleculeStack(new Molecule(CARBON), new Molecule(HYDROGEN), new Molecule(OXYGEN), new Molecule(NITROGEN), new Molecule(SULFUR), new Molecule(PHOSPHORUS));
        clayMolecule = new MoleculeStack(new Molecule(HYDROGEN, 4), new Molecule(OXYGEN, 7), new Molecule(SILICON, 2), new Molecule(ALUMINIUM, 2));
        coalMolecule = new MoleculeStack(new Molecule(CARBON, 7), new Molecule(HYDROGEN, 1), new Molecule(OXYGEN, 1), new Molecule(SULFUR, 1));
        inkMolecule = new MoleculeStack(new Molecule(CARBON, 4), new Molecule(HYDROGEN, 7), new Molecule(OXYGEN, 2), new Molecule(CHLORINE, 1));
        obsidianMolecule = water.setAmount(new MoleculesAmountHelper.MoleculeAmount(2, INGOT).getAmount());
        obsidianMolecule = lava.setAmount(new MoleculesAmountHelper.MoleculeAmount(2, INGOT).getAmount());
        goldMolecule = new Molecule(GOLD);
        slimeMolecule = new MoleculeStack(new Molecule(SILICON, 2), new Molecule(HYDROGEN, 2), new Molecule(OXYGEN,1 ));
        nitrate = new MoleculeStack(new Molecule(NITROGEN), new Molecule(OXYGEN, 3));
        serine = new MoleculeStack(new Molecule(CARBON, 3), new Molecule(HYDROGEN, 7), new Molecule(NITROGEN), new Molecule(OXYGEN, 3));
        glycine = new MoleculeStack(new Molecule(CARBON, 2), new Molecule(HYDROGEN, 5), new Molecule(NITROGEN), new Molecule(OXYGEN, 2));
        alinine = new MoleculeStack(new Molecule(CARBON, 2), new Molecule(HYDROGEN, 7), new Molecule(NITROGEN), new Molecule(OXYGEN, 2));
        emerald = new MoleculeStack(new Molecule(BERYLLIUM, 3), new Molecule(ALUMINIUM, 2), new Molecule(SILICON, 6), new Molecule(OXYGEN, 18)); // Be3Al2(SiO3)6



        aluminum = new Molecule(ALUMINIUM);
        bronzeMolecule = new MoleculeStack(new Molecule(COPPER, 9), new Molecule(TIN));
        cobalt = new Molecule(COBALT);
        copper = new Molecule(COPPER);
        electrum = new MoleculeStack(goldMolecule, new Molecule(SILVER));
    }
}
