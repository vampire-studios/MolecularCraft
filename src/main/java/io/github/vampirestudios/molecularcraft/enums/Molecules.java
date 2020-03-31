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
    public static MoleculeStack lignin;
    public static MoleculeStack xylan;
    public static MoleculeStack glucomannan;

    public static Molecule carbonMolecule;
    public static MoleculeStack lava;
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
    public static Molecule iridium;
    public static Molecule lead;
    public static Molecule osmium;
    public static Molecule palladium;
    public static MoleculeStack peridot;
    public static Molecule platinum;
    public static Molecule plutonium;
    public static MoleculeStack ruby;
    public static MoleculeStack sapphire;
    public static Molecule silver;
    public static Molecule thorium;
    public static Molecule tin;
    public static Molecule titanium;
    public static MoleculeStack topaz;
    public static Molecule tungsten;
    public static Molecule uranium;
    public static Molecule zinc;

    public static void init() {
        water = new MoleculeStack(new Molecule(HYDROGEN, 2), new Molecule(OXYGEN));
        ironMolecule = new Molecule(IRON);
        celluloseMolecule = new MoleculeStack(new Molecule(CARBON, 6), new Molecule(HYDROGEN, 10), new Molecule(OXYGEN, 5));
        lignin = new MoleculeStack(new Molecule(CARBON, 31), new Molecule(HYDROGEN, 34), new Molecule(OXYGEN, 11));
        xylan = new MoleculeStack(new Molecule(CARBON, 6), new Molecule(HYDROGEN, 22), new Molecule(OXYGEN, 31));
        glucomannan = new MoleculeStack(new Molecule(CARBON, 24), new Molecule(HYDROGEN, 42), new Molecule(OXYGEN, 21));

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
        iridium = new Molecule(IRIDIUM);
        lead = new Molecule(LEAD);
        osmium = new Molecule(OSMIUM);
        palladium = new Molecule(PALLADIUM);
        peridot = new MoleculeStack(new Molecule(MAGNESIUM, 2), new Molecule(SILICON), new Molecule(OXYGEN, 4));
        platinum = new Molecule(PLATINUM);
        plutonium = new Molecule(PLUTONIUM);
        ruby = new MoleculeStack(new Molecule(ALUMINIUM, 2), new Molecule(OXYGEN, 3));
        sapphire = new MoleculeStack(new Molecule(ALUMINIUM, 2), new Molecule(OXYGEN, 3));
        silver = new Molecule(SILVER);
        thorium = new Molecule(THORIUM);
        tin = new Molecule(TIN);
        titanium = new Molecule(TITANIUM);
        topaz = new MoleculeStack(new Molecule(ALUMINIUM, 2), new Molecule(SILICON), new Molecule(FLUORINE, 2), new Molecule(OXYGEN, 2), new Molecule(HYDROGEN, 2));
        tungsten = new Molecule(TUNGSTEN);
        uranium = new Molecule(URANIUM);
        zinc = new Molecule(ZINC);
    }
}
