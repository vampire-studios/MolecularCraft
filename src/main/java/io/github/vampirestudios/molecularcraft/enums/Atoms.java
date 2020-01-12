package io.github.vampirestudios.molecularcraft.enums;

public enum Atoms {
    HYDROGEN(AtomFamilies.REACTIVE_NONMETAL, AtomType.GAS, 1, 1.008F),
    HELIUM(AtomFamilies.NOBLE_GAS, AtomType.GAS,2, 4.0026F),
    LITHIUM(AtomFamilies.ALKALI_METAL,3, 6.94F),
    BERYLLIUM(AtomFamilies.ALKALIN_EARTH_METAL,4, 9.0122F),
    BORON(AtomFamilies.METALLOID,5, 10.81F),
    CARBON(AtomFamilies.REACTIVE_NONMETAL,6, 12.011F),
    NITROGEN(AtomFamilies.REACTIVE_NONMETAL, AtomType.GAS,7, 14.007F),
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
    LUTETIUM(AtomFamilies.LANTHANIDE, 71, 174.97F);
    // Source : https://en.wikipedia.org/wiki/Periodic_table. 

    private AtomFamilies atomFamily;
    private AtomType atomType;
    private int atomicNumber;
    private float atomicMass;
    private AtomOccurence atomOccurence;

    Atoms(AtomFamilies atomFamily, AtomType atomType, int atomicNumber, float atomicMass) {
        this.atomFamily = atomFamily;
        this.atomType = atomType;
        this.atomicNumber = atomicNumber;
        this.atomicMass = atomicMass;
        this.atomOccurence = AtomOccurence.PRIMORDIAL;
    }

    Atoms(AtomFamilies atomFamily, int atomicNumber, float atomicMass) {
        this.atomFamily = atomFamily;
        this.atomType = AtomType.SOLID;
        this.atomicNumber = atomicNumber;
        this.atomicMass = atomicMass;
        this.atomOccurence = AtomOccurence.PRIMORDIAL;
    }

    Atoms(AtomFamilies atomFamily, AtomType atomType, int atomicNumber, float atomicMass, AtomOccurence atomOccurence) {
        this.atomFamily = atomFamily;
        this.atomType = atomType;
        this.atomicNumber = atomicNumber;
        this.atomicMass = atomicMass;
        this.atomOccurence = atomOccurence;
    }

    Atoms(AtomFamilies atomFamily, int atomicNumber, float atomicMass, AtomOccurence atomOccurence) {
        this.atomFamily = atomFamily;
        this.atomType = AtomType.SOLID;
        this.atomicNumber = atomicNumber;
        this.atomicMass = atomicMass;
        this.atomOccurence = atomOccurence;
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
}
