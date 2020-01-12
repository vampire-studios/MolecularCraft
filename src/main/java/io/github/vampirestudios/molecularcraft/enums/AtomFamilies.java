package io.github.vampirestudios.molecularcraft.enums;

public enum AtomFamilies {
    ALKALI_METAL(AtomFamiliesGroup.METAL),
    ALKALIN_EARTH_METAL(AtomFamiliesGroup.METAL),
    LANTHANIDE(AtomFamiliesGroup.METAL),
    ACTINIDE(AtomFamiliesGroup.METAL),
    TRANSITION_METAL(AtomFamiliesGroup.METAL),
    POST_TRANSITION_METAL(AtomFamiliesGroup.METAL),
    METALLOID(AtomFamiliesGroup.METALLOID),
    REACTIVE_NONMETAL(AtomFamiliesGroup.NONMETAL),
    NOBLE_GAS(AtomFamiliesGroup.NONMETAL),
    UNKNOW(AtomFamiliesGroup.UNKNOW);

    private AtomFamiliesGroup atomFamiliesGroup;

    AtomFamilies(AtomFamiliesGroup atomFamiliesGroup) {
        this.atomFamiliesGroup = atomFamiliesGroup;
    }

    public AtomFamiliesGroup getAtomFamiliesGroup() {
        return atomFamiliesGroup;
    }

    public enum AtomFamiliesGroup {
        METAL,
        METALLOID,
        NONMETAL,
        UNKNOW;
    }
}
