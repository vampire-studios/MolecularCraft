package io.github.arthurbambou.molecularcraft.enums;

public enum Atoms {
    HYDROGEN("H", AtomFamilies.REACTIVE_NONMETAL, AtomType.GAS, 1, 1.008F),
    HELIUM("He", AtomFamilies.NOBLE_GAS, AtomType.GAS,2, 4.0026F),
    LITHIUM("Li", AtomFamilies.ALKALI_METAL, AtomType.SOLID,3, 6.94F),
    BERYLLIUM("Be", AtomFamilies.ALKALIN_EARTH_METAL, AtomType.SOLID,4, 9.0122F),
    BORON("B", AtomFamilies.METALLOID, AtomType.SOLID,5, 10.81F),
    CARBON("C", AtomFamilies.REACTIVE_NONMETAL, AtomType.SOLID,6, 12.011F),
    NITROGEN("N", AtomFamilies.REACTIVE_NONMETAL, AtomType.GAS,7, 14.007F),
    OXYGEN("O",AtomFamilies.REACTIVE_NONMETAL,AtomType.GAS,8,15.999F),
    FLUORINE("F",AtomFamilies.REACTIVE_NONMETAL,AtomType.GAS,9,18.998F),
    NEON("Ne",AtomFamilies.NOBLE_GAS,AtomType.GAS,10,20.180F),
    SODIUM("Na",AtomFamilies.ALKALI_METAL,AtomType.SOLID,11,22.990F),
    MAGNESIUM("Mg",AtomFamilies.ALKALIN_EARTH_METAL,AtomType.SOLID,12,24.305F),
    ALUMINIUM("Al",AtomFamilies.POST_TRANSITION_METAL,AtomType.SOLID,13,26.982F),
    SILICON("Si",AtomFamilies.METALLOID,AtomType.SOLID,14,28.085F),
    PHOSPHORUS("P",AtomFamilies.REACTIVE_NONMETAL,AtomType.SOLID,15,30.974F),
    SULFUR("S",AtomFamilies.REACTIVE_NONMETAL,AtomType.SOLID,16,32.06F),
    CHLORINE("Cl",AtomFamilies.REACTIVE_NONMETAL,AtomType.GAS,17,35.45F),
    ARGON("Ar",AtomFamilies.NOBLE_GAS,AtomType.GAS,18,39.88F);
    // Source : https://en.wikipedia.org/wiki/Periodic_table. 

    private String symbol;
    private AtomFamilies atomFamily;
    private AtomType atomType;
    private int atomicNumber;
    private float atomicMass;

    Atoms(String symbol, AtomFamilies atomFamily, AtomType atomType, int atomicNumber, float atomicMass) {
        this.symbol = symbol;
        this.atomFamily = atomFamily;
        this.atomType = atomType;
        this.atomicNumber = atomicNumber;
        this.atomicMass = atomicMass;
    }

    public String getSymbol() {
        return symbol;
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
