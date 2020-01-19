package io.github.vampirestudios.molecularcraft.enums;

import io.github.vampirestudios.molecularcraft.molecules.Molecule;
import io.github.vampirestudios.molecularcraft.molecules.MoleculeStack;

import static io.github.vampirestudios.molecularcraft.enums.Atoms.*;

public class Molecules {

    public static MoleculeStack water;
    public static Molecule ironMolecule;
    public static MoleculeStack celluloseMolecule;
    public static Molecule carbonMolecule;
    public static Molecule lava;
    public static MoleculeStack obsidianMolecule;
    public static MoleculeStack glassMolecule;
    public static MoleculeStack woolMolecule;
    public static MoleculeStack concreteMolecule;
    public static MoleculeStack cementMolecule;
    public static Molecule calciumMolecule;
    public static MoleculeStack livingMolecules;
    public static MoleculeStack clayMolecule;
    public static MoleculeStack coalMolecule;


    public static void init() {
        water = new MoleculeStack(new Molecule(HYDROGEN, 2), new Molecule(OXYGEN));
        ironMolecule = new Molecule(IRON);
        celluloseMolecule = new MoleculeStack(new Molecule(CARBON, 6), new Molecule(HYDROGEN, 10), new Molecule(OXYGEN, 5));
        carbonMolecule = new Molecule(CARBON);
        lava = new Molecule(CARBON, 5);
        glassMolecule = new MoleculeStack(new Molecule(SILICON), new Molecule(OXYGEN, 2));
        woolMolecule = new MoleculeStack(new Molecule(CARBON, 2), new Molecule(HYDROGEN, 13), new Molecule(OXYGEN, 7), new Molecule(NITROGEN, 6));
        concreteMolecule = new MoleculeStack(new Molecule(HYDROGEN, 2), new Molecule(OXYGEN, 13), new Molecule(SILICON, 2), new Molecule(SULFUR, 1), new Molecule(ALUMINIUM, 2), new Molecule(IRON, 2), new Molecule(CALCIUM));
        cementMolecule = new MoleculeStack(new Molecule(OXYGEN, 12), new Molecule(SILICON, 2), new Molecule(SULFUR, 1), new Molecule(ALUMINIUM, 2), new Molecule(IRON, 2), new Molecule(CALCIUM));
        calciumMolecule = new Molecule(CALCIUM);
        livingMolecules = new MoleculeStack(new Molecule(CARBON), new Molecule(HYDROGEN), new Molecule(OXYGEN), new Molecule(NITROGEN), new Molecule(SULFUR), new Molecule(PHOSPHORUS));
        clayMolecule = new MoleculeStack(new Molecule(HYDROGEN, 4), new Molecule(OXYGEN, 7), new Molecule(SILICON, 2), new Molecule(ALUMINIUM, 2));
        coalMolecule = new MoleculeStack(new Molecule(CARBON, 7), new Molecule(HYDROGEN, 1), new Molecule(OXYGEN, 1), new Molecule(SULFUR, 1));

    }
}
