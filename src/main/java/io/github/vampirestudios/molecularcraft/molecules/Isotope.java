package io.github.vampirestudios.molecularcraft.molecules;

public class Isotope {
    private String atomName;
    private int neutronNumber;
    private float abundance = 0.00F;
    private long halfLife = -1;
    private DecayMod decayMod;
    private Isotope product;

    public Isotope(String atomName, int neutronNumber, float abundance, long halfLife, DecayMod decayMod, Isotope product) {
        this.atomName = atomName;
        this.neutronNumber = neutronNumber;
        this.abundance = abundance;
        this.halfLife = halfLife;
        this.decayMod = decayMod;
        this.product = product;
    }

    public Isotope(String atomName, int neutronNumber, float abundance, DecayMod decayMod) {
        this.atomName = atomName;
        this.neutronNumber = neutronNumber;
        this.abundance = abundance;
        this.decayMod = decayMod;
    }

    public Isotope(String atomName, int neutronNumber, long halfLife, DecayMod decayMod, Isotope product) {
        this.atomName = atomName;
        this.neutronNumber = neutronNumber;
        this.halfLife = halfLife;
        this.decayMod = decayMod;
        this.product = product;
    }

    public Isotope(String atomName, int neutronNumber, int abundance, long halfLife, DecayMod decayMod) {
        this.atomName = atomName;
        this.neutronNumber = neutronNumber;
        this.abundance = abundance;
        this.halfLife = halfLife;
        this.decayMod = decayMod;
    }

    public Isotope(String atomName, int neutronNumber, DecayMod decayMod, Isotope isotope) {
        this.atomName = atomName;
        this.neutronNumber = neutronNumber;
        this.decayMod = decayMod;
        this.product = isotope;
    }

    public Isotope(String atomName, int neutronNumber, DecayMod decayMod) {
        this.atomName = atomName;
        this.neutronNumber = neutronNumber;
        this.decayMod = decayMod;
    }

    public String getAtomName() {
        return atomName;
    }

    public DecayMod getDecayMod() {
        return decayMod;
    }

    public float getAbundance() {
        return abundance;
    }

    public long getHalfLife() {
        return halfLife;
    }

    public int getNeutronNumber() {
        return neutronNumber;
    }

    public Isotope getProduct() {
        return product;
    }

    public enum DecayMod {
        STABLE,BETA_MINUS,BETA_PLUS,DOUBLE_BETA_MINUS,DOUBLE_BETA_PLUS,ELECTRON_CAPTURE,GAMMA_RAY, INTERNAL_CONVERSION;
    }
}
