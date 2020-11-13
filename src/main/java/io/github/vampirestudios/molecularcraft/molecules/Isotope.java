package io.github.vampirestudios.molecularcraft.molecules;

import io.github.vampirestudios.molecularcraft.enums.Atoms;
import io.github.vampirestudios.molecularcraft.utils.TimeHelper;

public class Isotope {
    private Atoms atom;
    private int nucleonNumber;
    private Abundance abundance;
    private float abundancePercent;
    private boolean decay;
    private TimeHelper.TimeAmount halfLife;
    private Decay[] decays;

    public Isotope(Atoms atom, int nucleonNumber, Abundance abundance, float abundancePercent, boolean decay, TimeHelper.TimeAmount halfLife, Decay[] decays) {
        this.atom = atom;
        this.nucleonNumber = nucleonNumber;
        this.abundance = abundance;
        this.abundancePercent = abundancePercent;
        this.decay = decay;
        this.halfLife = halfLife;
        this.decays = decays;
    }

    public Atoms getAtom() {
        return atom;
    }

    public int getNucleonNumber() {
        return nucleonNumber;
    }

    public Abundance getAbundance() {
        return abundance;
    }

    public float getAbundancePercent() {
        return abundancePercent;
    }

    public boolean doesDecay() {
        return decay;
    }

    public TimeHelper.TimeAmount getHalfLife() {
        return halfLife;
    }

    public Decay[] getDecays() {
        return decays;
    }

    public enum DecayMod {
        STABLE,BETA_MINUS,BETA_PLUS,DOUBLE_BETA_MINUS,DOUBLE_BETA_PLUS,ELECTRON_CAPTURE,GAMMA_RAY, INTERNAL_CONVERSION;
    }

    public enum Abundance {
        SYNTHETIC,
        TRACE,
        AMOUNT
    }

    public static class Decay {
        private final DecayMod mod;
        private final boolean product;
        private final Atoms atom;
        private final int nucleonNumber;
        private final float chance;

        public Decay(DecayMod mod, Atoms atom, int nucleonNumber) {
            this.mod = mod;
            this.atom = atom;
            this.nucleonNumber = nucleonNumber;
            this.product = true;
            this.chance = 100F;
        }

        public Decay(DecayMod mod) {
            this.mod = mod;
            this.product = false;
            this.atom = null;
            this.nucleonNumber = 0;
            this.chance = 100F;
        }

        public Decay(DecayMod mod, float chance, Atoms atom, int nucleonNumber) {
            this.mod = mod;
            this.atom = atom;
            this.nucleonNumber = nucleonNumber;
            this.product = true;
            this.chance = chance;
        }

        public Decay(DecayMod mod, float chance) {
            this.mod = mod;
            this.product = false;
            this.atom = null;
            this.nucleonNumber = 0;
            this.chance = chance;
        }

        public DecayMod getMod() {
            return mod;
        }

        public Atoms getAtom() {
            return atom;
        }

        public int getNucleonNumber() {
            return nucleonNumber;
        }

        public boolean hasProduct() {
            return product;
        }

        public float getChance() {
            return chance;
        }
    }
}
