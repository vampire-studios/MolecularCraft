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
    public static MoleculeStack carbonMolecule;
    public static MoleculeStack lava;
    public static MoleculeStack obsidianMolecule;
    public static MoleculeStack glassMolecule;
    public static MoleculeStack woolMolecule;
    public static MoleculeStack concreteMolecule;
    public static MoleculeStack cementMolecule;
    public static MoleculeStack calciumMolecule;
    public static MoleculeStack livingMolecules;
    public static MoleculeStack clayMolecule;
    public static MoleculeStack coalMolecule;
    public static MoleculeStack bronzeMolecule;
    public static MoleculeStack inkMolecule;
    public static MoleculeStack diamondMolecule;
    public static MoleculeStack goldMolecule;
    public static MoleculeStack slimeMolecule;



    public static void init() {
        water = new MoleculeStack(new Molecule(HYDROGEN, 2), new Molecule(OXYGEN));
        ironMolecule = new Molecule(IRON);
        celluloseMolecule = new MoleculeStack(new Molecule(CARBON, 6), new Molecule(HYDROGEN, 10), new Molecule(OXYGEN, 5));
        carbonMolecule = new MoleculeStack(new Molecule(CARBON,1));
        diamondMolecule = carbonMolecule.setAmount(new MoleculesAmountHelper.MoleculeAmount(4, INGOT).getAmount());
        lava = new MoleculeStack(new Molecule(CARBON, 5));
        glassMolecule = new MoleculeStack(new Molecule(SILICON), new Molecule(OXYGEN, 2));
        woolMolecule = new MoleculeStack(new Molecule(CARBON, 2), new Molecule(HYDROGEN, 13), new Molecule(OXYGEN, 7), new Molecule(NITROGEN, 6));
        concreteMolecule = new MoleculeStack(new Molecule(HYDROGEN, 2), new Molecule(OXYGEN, 13), new Molecule(SILICON, 2), new Molecule(SULFUR, 1), new Molecule(ALUMINIUM, 2), new Molecule(IRON, 2), new Molecule(CALCIUM));
        cementMolecule = new MoleculeStack(new Molecule(OXYGEN, 12), new Molecule(SILICON, 2), new Molecule(SULFUR, 1), new Molecule(ALUMINIUM, 2), new Molecule(IRON, 2), new Molecule(CALCIUM));
        calciumMolecule = new MoleculeStack(new Molecule(CALCIUM,1));
        livingMolecules = new MoleculeStack(new Molecule(CARBON), new Molecule(HYDROGEN), new Molecule(OXYGEN), new Molecule(NITROGEN), new Molecule(SULFUR), new Molecule(PHOSPHORUS));
        clayMolecule = new MoleculeStack(new Molecule(HYDROGEN, 4), new Molecule(OXYGEN, 7), new Molecule(SILICON, 2), new Molecule(ALUMINIUM, 2));
        coalMolecule = new MoleculeStack(new Molecule(CARBON, 7), new Molecule(HYDROGEN, 1), new Molecule(OXYGEN, 1), new Molecule(SULFUR, 1));
        bronzeMolecule = new MoleculeStack(new Molecule(COPPER, 4), new Molecule(TIN, 4));
        //For Bells and Mods//
        inkMolecule = new MoleculeStack(new Molecule(CARBON, 4), new Molecule(HYDROGEN, 7), new Molecule(OXYGEN, 2), new Molecule(CHLORINE, 1));
        obsidianMolecule = water.setAmount(new MoleculesAmountHelper.MoleculeAmount(2, INGOT).getAmount());
        obsidianMolecule = lava.setAmount(new MoleculesAmountHelper.MoleculeAmount(2, INGOT).getAmount());
        goldMolecule = new MoleculeStack(new Molecule(GOLD,1));
        slimeMolecule = new MoleculeStack(new Molecule(SILICON, 2), new Molecule(HYDROGEN, 2), new Molecule(OXYGEN,1 ));

    }
}
