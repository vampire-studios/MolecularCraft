package io.github.vampirestudios.molecularcraft.enums;

import io.github.vampirestudios.molecularcraft.molecules.Isotope;

import static io.github.vampirestudios.molecularcraft.utils.TimeHelper.*;

public enum Atoms {
    HYDROGEN(AtomFamilies.REACTIVE_NONMETAL, AtomType.GAS, 1, 1.008F, new Isotope[]{
            new Isotope("hydrogen", 0, 99.98F, Isotope.DecayMod.STABLE),
            new Isotope("hydrogen", 1, 0.02F, Isotope.DecayMod.STABLE),
            new Isotope("hydrogen", 2, (long)(1000L * SECONDS_IN_A_YEAR * 12.32F), Isotope.DecayMod.BETA_MINUS,
                    new Isotope("helium", 1, 0.0002F, Isotope.DecayMod.STABLE))
    }),
    HELIUM(AtomFamilies.NOBLE_GAS, AtomType.GAS,2, 4.0026F, new Isotope[]{
            new Isotope("helium", 1, 0.0002F, Isotope.DecayMod.STABLE),
            new Isotope("helium", 2, 99.9998F, Isotope.DecayMod.STABLE)
    }),
    LITHIUM(AtomFamilies.ALKALI_METAL,3, 6.94F, new Isotope[]{
            new Isotope("lithium", 3, 7.59F, Isotope.DecayMod.STABLE),
            new Isotope("lithium", 4, 92.41F, Isotope.DecayMod.STABLE)
    }),
    BERYLLIUM(AtomFamilies.ALKALIN_EARTH_METAL,4, 9.0122F, new Isotope[]{
            new Isotope("beryllium", 3, (long)(1000L * SECONDS_IN_A_DAY * 53.12F), Isotope.DecayMod.ELECTRON_CAPTURE,
                    new Isotope("lithium", 4, 92.41F, Isotope.DecayMod.STABLE)),
            new Isotope("beryllium", 3, (long)(1000L * SECONDS_IN_A_DAY * 53.12F), Isotope.DecayMod.GAMMA_RAY),
            new Isotope("beryllium", 5, 100F, Isotope.DecayMod.STABLE),
            new Isotope("beryllium", 6, (long)(1000L * SECONDS_IN_A_YEAR * (1.39F * 10 * 10 * 10 * 10 * 10 * 10)), Isotope.DecayMod.BETA_MINUS,
                    new Isotope("boron", 5, 20F, Isotope.DecayMod.STABLE))
    }),
    BORON(AtomFamilies.METALLOID,5, 10.81F, new Isotope[]{
            new Isotope("boron", 5, 20F, Isotope.DecayMod.STABLE),
            new Isotope("boron", 6, 80F, Isotope.DecayMod.STABLE)
    }),
    CARBON(AtomFamilies.REACTIVE_NONMETAL,6, 12.011F, new Isotope[]{
            new Isotope("carbon", 5, -1, (long)(1000L * SECONDS_IN_A_MINUTE * 20), Isotope.DecayMod.BETA_PLUS,
                    new Isotope("boron", 5, 20F, Isotope.DecayMod.STABLE)),
            new Isotope("carbon", 6, 98.9F, Isotope.DecayMod.STABLE),
            new Isotope("carbon", 7, 1.1F, Isotope.DecayMod.STABLE),
            new Isotope("carbon", 8, (long)(1000L * SECONDS_IN_A_YEAR * 5730L), Isotope.DecayMod.BETA_MINUS,
                    new Isotope("nitrogen", 7, 99.6F, Isotope.DecayMod.STABLE))
    }),
    NITROGEN(AtomFamilies.REACTIVE_NONMETAL, AtomType.GAS,7, 14.007F, new Isotope[]{
            new Isotope("nitrogen", 6, -1F, (long)(1000L * SECONDS_IN_A_MINUTE * 9.965F), Isotope.DecayMod.ELECTRON_CAPTURE,
                    new Isotope("carbon", 7, 1.1F, Isotope.DecayMod.STABLE)),
            new Isotope("nitrogen", 7, 99.6F, Isotope.DecayMod.STABLE),
            new Isotope("nitrogen", 8, 0.4F, Isotope.DecayMod.STABLE)
    }),
    OXYGEN(AtomFamilies.REACTIVE_NONMETAL,AtomType.GAS,8,15.999F),
    FLUORINE(AtomFamilies.REACTIVE_NONMETAL,AtomType.GAS,9,18.998F),
    NEON(AtomFamilies.NOBLE_GAS,AtomType.GAS,10,20.180F),
    SODIUM(AtomFamilies.ALKALI_METAL,11,22.990F),
    MAGNESIUM(AtomFamilies.ALKALIN_EARTH_METAL,12,24.305F),
    ALUMINIUM(AtomFamilies.POST_TRANSITION_METAL,13,26.982F),
    SILICON(AtomFamilies.METALLOID,14,28.085F),
    PHOSPHORUS(AtomFamilies.REACTIVE_NONMETAL,15,30.974F),
    SULFUR(AtomFamilies.REACTIVE_NONMETAL,16,32.06F),
    CHLORINE(AtomFamilies.REACTIVE_NONMETAL,AtomType.GAS,17,35.45F),
    ARGON(AtomFamilies.NOBLE_GAS,AtomType.GAS,18,39.88F),
    POTASSIUM(AtomFamilies.ALKALI_METAL, 19, 39.098F),
    CALCIUM(AtomFamilies.ALKALIN_EARTH_METAL, 20, 40.078F),
    SCANDIUM(AtomFamilies.TRANSITION_METAL, 21, 44.956F),
    TITANIUM(AtomFamilies.TRANSITION_METAL, 22, 47.867F),
    VANADIUM(AtomFamilies.TRANSITION_METAL, 23, 50.942F),
    CHROMIUM(AtomFamilies.TRANSITION_METAL, 24,51.996F),
    MANGANESE(AtomFamilies.TRANSITION_METAL, 25, 54.938F),
    IRON(AtomFamilies.TRANSITION_METAL,  26, 55.845F),
    COBALT(AtomFamilies.TRANSITION_METAL, 27, 58.933F),
    NICKEL(AtomFamilies.TRANSITION_METAL, 28, 58.693F),
    COPPER(AtomFamilies.TRANSITION_METAL, 29, 63.546F),
    ZINC(AtomFamilies.POST_TRANSITION_METAL, 30, 65.38F),
    GALLIUM(AtomFamilies.POST_TRANSITION_METAL, 31, 69.723F),
    GERMANIUM(AtomFamilies.METALLOID, 32, 72.630F),
    ARSENIC(AtomFamilies.METALLOID, 33, 74.922F),
    SELENIUM(AtomFamilies.REACTIVE_NONMETAL, 34, 78.971F),
    BROMINE(AtomFamilies.REACTIVE_NONMETAL, AtomType.LIQUID, 35, 79.904F),
    KRYPTON(AtomFamilies.NOBLE_GAS, AtomType.GAS, 36, 83.798F),
    RUBIDIUM(AtomFamilies.ALKALI_METAL, 37, 85.468F),
    STRONTIUM(AtomFamilies.ALKALIN_EARTH_METAL, 38, 87.62F),
    YTTRIUM(AtomFamilies.TRANSITION_METAL, 39, 88.906F),
    ZIRCONIUM(AtomFamilies.TRANSITION_METAL, 40, 91.224F),
    NIOBIUM(AtomFamilies.TRANSITION_METAL, 41, 92.906F),
    MOLYBDENUM(AtomFamilies.TRANSITION_METAL, 42, 95.95F),
    TECHNETIUM(AtomFamilies.TRANSITION_METAL, 43, 97.0F, AtomOccurence.FROM_DECAY),
    RUTHENIUM(AtomFamilies.TRANSITION_METAL, 44, 101.07F),
    RHODIUM(AtomFamilies.TRANSITION_METAL, 45, 102.91F),
    PALLADIUM(AtomFamilies.TRANSITION_METAL, 46, 106.42F),
    SILVER(AtomFamilies.TRANSITION_METAL, 47, 107.87F),
    CADMIUM(AtomFamilies.POST_TRANSITION_METAL, 48, 112.41F),
    INDIUM(AtomFamilies.POST_TRANSITION_METAL, 49, 114.82F),
    TIN(AtomFamilies.POST_TRANSITION_METAL, 50, 118.71F),
    ANTIMONY(AtomFamilies.METALLOID, AtomType.SOLID, 51, 121.76F),
    TELLURIUM(AtomFamilies.METALLOID, AtomType.SOLID, 52, 127.60F),
    IODINE(AtomFamilies.REACTIVE_NONMETAL, 53, 126.90F),
    XENON(AtomFamilies.NOBLE_GAS, AtomType.GAS, 54, 131.29F),
    CAESIUM(AtomFamilies.ALKALI_METAL, 55, 132.91F),
    BARIUM(AtomFamilies.ALKALIN_EARTH_METAL, 56, 137.33F),
    LANTHANUM(AtomFamilies.LANTHANIDE, 57, 138.91F),
    CERIUM(AtomFamilies.LANTHANIDE, 58, 140.12F),
    PRASEODYMIUM(AtomFamilies.LANTHANIDE, 59, 140.91F),
    NEODYMIUM(AtomFamilies.LANTHANIDE, 60, 144.24F),
    PROMETHIUM(AtomFamilies.LANTHANIDE, 61, 145.0F, AtomOccurence.FROM_DECAY),
    SAMARIUM(AtomFamilies.LANTHANIDE, 62, 150.36F),
    EUROPIUM(AtomFamilies.LANTHANIDE, 63, 151.96F),
    GADOLINIUM(AtomFamilies.LANTHANIDE, 64, 157.25F),
    TERBIUM(AtomFamilies.LANTHANIDE, 65, 158.93F),
    DYSPROSIUM(AtomFamilies.LANTHANIDE, 66, 162.50F),
    HOLMIUM(AtomFamilies.LANTHANIDE, 67, 164.93F),
    ERBIUM(AtomFamilies.LANTHANIDE, 68, 167.26F),
    THULIUM(AtomFamilies.LANTHANIDE, 69, 168.93F),
    YTTERBIUM(AtomFamilies.LANTHANIDE, 70, 173.05F),
    LUTETIUM(AtomFamilies.LANTHANIDE, 71, 174.97F),
    HAFNIUM(AtomFamilies.TRANSITION_METAL, 72, 178.49F),
    TANTALUM(AtomFamilies.TRANSITION_METAL, 73, 180.95F),
    TUNGSTEN(AtomFamilies.TRANSITION_METAL, 74, 183.84F),
    RHENIUM(AtomFamilies.TRANSITION_METAL, 75, 186.21F),
    OSMIUM(AtomFamilies.TRANSITION_METAL, 76, 190.23F),
    IRIDIUM(AtomFamilies.TRANSITION_METAL, 77, 192.22F),
    PLATINUM(AtomFamilies.TRANSITION_METAL, 78, 195.08F),
    GOLD(AtomFamilies.TRANSITION_METAL, 79, 196.97F),
    MERCURY(AtomFamilies.POST_TRANSITION_METAL, AtomType.LIQUID, 80, 200.59F),
    THALLIUM(AtomFamilies.POST_TRANSITION_METAL, 81, 204.38F),
    LEAD(AtomFamilies.POST_TRANSITION_METAL, 82, 207.2F),
    BISMUTH(AtomFamilies.POST_TRANSITION_METAL, 83, 208.98F),
    POLONIUM(AtomFamilies.POST_TRANSITION_METAL, 84, 209.0F, AtomOccurence.FROM_DECAY),
    ASTATINE(AtomFamilies.METALLOID, 85, 210.0F),
    RADON(AtomFamilies.NOBLE_GAS, AtomType.GAS, 86, 222.0F, AtomOccurence.FROM_DECAY),
    FRANCIUM(AtomFamilies.ALKALI_METAL, 87, 223.0F, AtomOccurence.FROM_DECAY),
    RADIUM(AtomFamilies.ALKALIN_EARTH_METAL, 88, 226.0F, AtomOccurence.FROM_DECAY),
    ACTINIUM(AtomFamilies.ACTINIDE, 89, 227, AtomOccurence.FROM_DECAY),
    THORIUM(AtomFamilies.ACTINIDE, 90, 232.04F),
    PROTACTINIUM(AtomFamilies.ACTINIDE, 91, 231.04F, AtomOccurence.FROM_DECAY),
    URANIUM(AtomFamilies.ACTINIDE, 92, 238.03F),
    NEPTUNIUM(AtomFamilies.ACTINIDE, 93, 237.0F, AtomOccurence.FROM_DECAY),
    PLUTONIUM(AtomFamilies.ACTINIDE, 94, 244.0F, AtomOccurence.FROM_DECAY),
    AMERICIUM(AtomFamilies.ACTINIDE, 95, 243.0F, AtomOccurence.SYNTHETIC),
    CURIUM(AtomFamilies.ACTINIDE, 96, 247, AtomOccurence.SYNTHETIC),
    BERKELIUM(AtomFamilies.ACTINIDE, 97, 251, AtomOccurence.SYNTHETIC),
    CALIFORNIUM(AtomFamilies.ACTINIDE, 98, 251, AtomOccurence.SYNTHETIC),
    EINSTEINIUM(AtomFamilies.ACTINIDE, 99, 252, AtomOccurence.SYNTHETIC),
    FERMIUM(AtomFamilies.ACTINIDE, AtomType.UNKNOW, 100, 257, AtomOccurence.SYNTHETIC),
    MENDELEVIUM(AtomFamilies.ACTINIDE, AtomType.UNKNOW, 101, 258, AtomOccurence.SYNTHETIC),
    NOBELIUM(AtomFamilies.ACTINIDE, AtomType.UNKNOW, 102, 259, AtomOccurence.SYNTHETIC),
    LAWRENCIUM(AtomFamilies.ACTINIDE, AtomType.UNKNOW, 103, 266, AtomOccurence.SYNTHETIC),
    RUTHERFORDIUM(AtomFamilies.TRANSITION_METAL, AtomType.UNKNOW, 104, 267, AtomOccurence.SYNTHETIC),
    DUBNIUM(AtomFamilies.TRANSITION_METAL, AtomType.UNKNOW, 105, 268, AtomOccurence.SYNTHETIC),
    SEABORGIUM(AtomFamilies.TRANSITION_METAL, AtomType.UNKNOW, 106, 269, AtomOccurence.SYNTHETIC),
    BOHRIUM(AtomFamilies.TRANSITION_METAL, AtomType.UNKNOW, 107, 270, AtomOccurence.SYNTHETIC),
    HASSIUM(AtomFamilies.TRANSITION_METAL, AtomType.UNKNOW, 108, 269, AtomOccurence.SYNTHETIC),
    MEITNERIUM(AtomFamilies.UNKNOW, AtomType.UNKNOW, 109, 278, AtomOccurence.SYNTHETIC),
    DARMSTADTIUM(AtomFamilies.UNKNOW, AtomType.UNKNOW, 110, 281, AtomOccurence.SYNTHETIC),
    ROENTGENIUM(AtomFamilies.UNKNOW, AtomType.UNKNOW, 111, 282, AtomOccurence.SYNTHETIC),
    COPERNICIUM(AtomFamilies.POST_TRANSITION_METAL, AtomType.UNKNOW, 112, 285, AtomOccurence.SYNTHETIC),
    NIHONIUM(AtomFamilies.UNKNOW, AtomType.UNKNOW, 113, 286, AtomOccurence.SYNTHETIC),
    FLEROVIUM(AtomFamilies.UNKNOW, AtomType.UNKNOW, 114, 289, AtomOccurence.SYNTHETIC),
    MOSCOVIUM(AtomFamilies.UNKNOW, AtomType.UNKNOW, 115, 290, AtomOccurence.SYNTHETIC),
    LIVERMORIUM(AtomFamilies.UNKNOW, AtomType.UNKNOW, 116, 293, AtomOccurence.SYNTHETIC),
    TENNESSINE(AtomFamilies.UNKNOW, AtomType.UNKNOW, 117, 294, AtomOccurence.SYNTHETIC),
    OGANESSON(AtomFamilies.UNKNOW, AtomType.UNKNOW, 118, 294, AtomOccurence.SYNTHETIC);
    // Source : https://en.wikipedia.org/wiki/Periodic_table.

    private AtomFamilies atomFamily;
    private AtomType atomType;
    private int atomicNumber;
    private float atomicMass;
    private AtomOccurence atomOccurence;
    private Isotope[] isotopes;

    Atoms(AtomFamilies atomFamily, AtomType atomType, int atomicNumber, float atomicMass, Isotope[] isotopes) {
        this.atomFamily = atomFamily;
        this.atomType = atomType;
        this.atomicNumber = atomicNumber;
        this.atomicMass = atomicMass;
        this.atomOccurence = AtomOccurence.PRIMORDIAL;
        this.isotopes = isotopes;
    }

    Atoms(AtomFamilies atomFamily, int atomicNumber, float atomicMass, Isotope[] isotopes) {
        this.atomFamily = atomFamily;
        this.atomType = AtomType.SOLID;
        this.atomicNumber = atomicNumber;
        this.atomicMass = atomicMass;
        this.atomOccurence = AtomOccurence.PRIMORDIAL;
        this.isotopes = isotopes;
    }

    Atoms(AtomFamilies atomFamily, AtomType atomType, int atomicNumber, float atomicMass, AtomOccurence atomOccurence, Isotope[] isotopes) {
        this.atomFamily = atomFamily;
        this.atomType = atomType;
        this.atomicNumber = atomicNumber;
        this.atomicMass = atomicMass;
        this.atomOccurence = atomOccurence;
        this.isotopes = isotopes;
    }

    Atoms(AtomFamilies atomFamily, int atomicNumber, float atomicMass, AtomOccurence atomOccurence, Isotope[] isotopes) {
        this.atomFamily = atomFamily;
        this.atomType = AtomType.SOLID;
        this.atomicNumber = atomicNumber;
        this.atomicMass = atomicMass;
        this.atomOccurence = atomOccurence;
        this.isotopes = isotopes;
    }

    public Isotope[] getIsotopes() {
        return isotopes;
    }

    public AtomOccurence getAtomOccurence() {
        return atomOccurence;
    }

    public AtomFamilies getAtomFamily() {
        return atomFamily;
    }

    public AtomType getAtomType() {
        return atomType;
    }

    public int getAtomicNumber() {
        return atomicNumber;
    }

    public float getAtomicMass() {
        return atomicMass;
    }

    public String getTranslatableName() {
        return "atom.molecularcraft." + name().toLowerCase() + ".name";
    }

    public String getSymbol() {
        return "atom.molecularcraft." + name().toLowerCase() + ".symbol";
    }

}
