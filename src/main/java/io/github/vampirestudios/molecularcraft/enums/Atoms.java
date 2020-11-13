package io.github.vampirestudios.molecularcraft.enums;

import io.github.vampirestudios.molecularcraft.MolecularCraft;
import io.github.vampirestudios.molecularcraft.molecules.Isotope;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static io.github.vampirestudios.molecularcraft.utils.TimeHelper.*;

public enum Atoms {
    HYDROGEN("H", AtomFamilies.REACTIVE_NONMETAL, AtomType.GAS, 1, 1.008F),
    HELIUM("He", AtomFamilies.NOBLE_GAS, AtomType.GAS,2, 4.0026F),
    LITHIUM("Li", AtomFamilies.ALKALI_METAL,3, 6.94F),
    BERYLLIUM("Be", AtomFamilies.ALKALIN_EARTH_METAL,4, 9.0122F),
    BORON("B", AtomFamilies.METALLOID,5, 10.81F),
    CARBON("C", AtomFamilies.REACTIVE_NONMETAL,6, 12.011F),
    NITROGEN("N", AtomFamilies.REACTIVE_NONMETAL, AtomType.GAS,7, 14.007F),
    OXYGEN("O", AtomFamilies.REACTIVE_NONMETAL,AtomType.GAS,8,15.999F),
    FLUORINE("F", AtomFamilies.REACTIVE_NONMETAL,AtomType.GAS,9,18.998F),
    NEON("Ne", AtomFamilies.NOBLE_GAS,AtomType.GAS,10,20.180F),
    SODIUM("Na", AtomFamilies.ALKALI_METAL,11,22.990F),
    MAGNESIUM("Mg", AtomFamilies.ALKALIN_EARTH_METAL,12,24.305F),
    ALUMINIUM("Al", AtomFamilies.POST_TRANSITION_METAL,13,26.982F),
    SILICON("Si", AtomFamilies.METALLOID,14,28.085F),
    PHOSPHORUS("P", AtomFamilies.REACTIVE_NONMETAL,15,30.974F),
    SULFUR("S", AtomFamilies.REACTIVE_NONMETAL,16,32.06F),
    CHLORINE("Cl", AtomFamilies.REACTIVE_NONMETAL, AtomType.GAS,17,35.45F),
    ARGON("Ar", AtomFamilies.NOBLE_GAS, AtomType.GAS,18,39.88F),
    POTASSIUM("K", AtomFamilies.ALKALI_METAL, 19, 39.098F),
    CALCIUM("Ca", AtomFamilies.ALKALIN_EARTH_METAL, 20, 40.078F),
    SCANDIUM("Sc", AtomFamilies.TRANSITION_METAL, 21, 44.956F),
    TITANIUM("Ti", AtomFamilies.TRANSITION_METAL, 22, 47.867F),
    VANADIUM("V", AtomFamilies.TRANSITION_METAL, 23, 50.942F),
    CHROMIUM("Cr", AtomFamilies.TRANSITION_METAL, 24,51.996F),
    MANGANESE("Mn", AtomFamilies.TRANSITION_METAL, 25, 54.938F),
    IRON("Fe", AtomFamilies.TRANSITION_METAL,  26, 55.845F),
    COBALT("Co", AtomFamilies.TRANSITION_METAL, 27, 58.933F),
    NICKEL("Ni", AtomFamilies.TRANSITION_METAL, 28, 58.693F),
    COPPER("Cu", AtomFamilies.TRANSITION_METAL, 29, 63.546F),
    ZINC("Zn", AtomFamilies.POST_TRANSITION_METAL, 30, 65.38F),
    GALLIUM("Ga", AtomFamilies.POST_TRANSITION_METAL, 31, 69.723F),
    GERMANIUM("Ge", AtomFamilies.METALLOID, 32, 72.630F),
    ARSENIC("As", AtomFamilies.METALLOID, 33, 74.922F),
    SELENIUM("Se", AtomFamilies.REACTIVE_NONMETAL, 34, 78.971F),
    BROMINE("Br", AtomFamilies.REACTIVE_NONMETAL, AtomType.LIQUID, 35, 79.904F),
    KRYPTON("Kr", AtomFamilies.NOBLE_GAS, AtomType.GAS, 36, 83.798F),
    RUBIDIUM("Rb", AtomFamilies.ALKALI_METAL, 37, 85.468F),
    STRONTIUM("Sr", AtomFamilies.ALKALIN_EARTH_METAL, 38, 87.62F),
    YTTRIUM("Y", AtomFamilies.TRANSITION_METAL, 39, 88.906F),
    ZIRCONIUM("Zr", AtomFamilies.TRANSITION_METAL, 40, 91.224F),
    NIOBIUM("Nb", AtomFamilies.TRANSITION_METAL, 41, 92.906F),
    MOLYBDENUM("Mo", AtomFamilies.TRANSITION_METAL, 42, 95.95F),
    TECHNETIUM("Tc", AtomFamilies.TRANSITION_METAL, 43, 97.0F, AtomOccurence.FROM_DECAY),
    RUTHENIUM("Ru", AtomFamilies.TRANSITION_METAL, 44, 101.07F),
    RHODIUM("Rh", AtomFamilies.TRANSITION_METAL, 45, 102.91F),
    PALLADIUM("Pd", AtomFamilies.TRANSITION_METAL, 46, 106.42F),
    SILVER("Ag", AtomFamilies.TRANSITION_METAL, 47, 107.87F),
    CADMIUM("Cd", AtomFamilies.POST_TRANSITION_METAL, 48, 112.41F),
    INDIUM("In", AtomFamilies.POST_TRANSITION_METAL, 49, 114.82F),
    TIN("Sn", AtomFamilies.POST_TRANSITION_METAL, 50, 118.71F),
    ANTIMONY("Sb", AtomFamilies.METALLOID, AtomType.SOLID, 51, 121.76F),
    TELLURIUM("Te", AtomFamilies.METALLOID, AtomType.SOLID, 52, 127.60F),
    IODINE("I", AtomFamilies.REACTIVE_NONMETAL, 53, 126.90F),
    XENON("Xe", AtomFamilies.NOBLE_GAS, AtomType.GAS, 54, 131.29F),
    CAESIUM("Cs", AtomFamilies.ALKALI_METAL, 55, 132.91F),
    BARIUM("Ba", AtomFamilies.ALKALIN_EARTH_METAL, 56, 137.33F),
    LANTHANUM("La", AtomFamilies.LANTHANIDE, 57, 138.91F),
    CERIUM("Ce", AtomFamilies.LANTHANIDE, 58, 140.12F),
    PRASEODYMIUM("Pr", AtomFamilies.LANTHANIDE, 59, 140.91F),
    NEODYMIUM("Nd", AtomFamilies.LANTHANIDE, 60, 144.24F),
    PROMETHIUM("Pm", AtomFamilies.LANTHANIDE, 61, 145.0F, AtomOccurence.FROM_DECAY),
    SAMARIUM("Sm", AtomFamilies.LANTHANIDE, 62, 150.36F),
    EUROPIUM("Eu", AtomFamilies.LANTHANIDE, 63, 151.96F),
    GADOLINIUM("Gd", AtomFamilies.LANTHANIDE, 64, 157.25F),
    TERBIUM("Tb", AtomFamilies.LANTHANIDE, 65, 158.93F),
    DYSPROSIUM("Dy", AtomFamilies.LANTHANIDE, 66, 162.50F),
    HOLMIUM("Ho", AtomFamilies.LANTHANIDE, 67, 164.93F),
    ERBIUM("Er", AtomFamilies.LANTHANIDE, 68, 167.26F),
    THULIUM("Tm", AtomFamilies.LANTHANIDE, 69, 168.93F),
    YTTERBIUM("Yb", AtomFamilies.LANTHANIDE, 70, 173.05F),
    LUTETIUM("Lu", AtomFamilies.LANTHANIDE, 71, 174.97F),
    HAFNIUM("Hf", AtomFamilies.TRANSITION_METAL, 72, 178.49F),
    TANTALUM("Ta", AtomFamilies.TRANSITION_METAL, 73, 180.95F),
    TUNGSTEN("W", AtomFamilies.TRANSITION_METAL, 74, 183.84F),
    RHENIUM("Re", AtomFamilies.TRANSITION_METAL, 75, 186.21F),
    OSMIUM("Os", AtomFamilies.TRANSITION_METAL, 76, 190.23F),
    IRIDIUM("Ir", AtomFamilies.TRANSITION_METAL, 77, 192.22F),
    PLATINUM("Pt", AtomFamilies.TRANSITION_METAL, 78, 195.08F),
    GOLD("Au", AtomFamilies.TRANSITION_METAL, 79, 196.97F),
    MERCURY("Hg", AtomFamilies.POST_TRANSITION_METAL, AtomType.LIQUID, 80, 200.59F),
    THALLIUM("Tl", AtomFamilies.POST_TRANSITION_METAL, 81, 204.38F),
    LEAD("Pb", AtomFamilies.POST_TRANSITION_METAL, 82, 207.2F),
    BISMUTH("Bi", AtomFamilies.POST_TRANSITION_METAL, 83, 208.98F),
    POLONIUM("Po", AtomFamilies.POST_TRANSITION_METAL, 84, 209.0F, AtomOccurence.FROM_DECAY),
    ASTATINE("At", AtomFamilies.METALLOID, 85, 210.0F),
    RADON("Rn", AtomFamilies.NOBLE_GAS, AtomType.GAS, 86, 222.0F, AtomOccurence.FROM_DECAY),
    FRANCIUM("Fr", AtomFamilies.ALKALI_METAL, 87, 223.0F, AtomOccurence.FROM_DECAY),
    RADIUM("Ra", AtomFamilies.ALKALIN_EARTH_METAL, 88, 226.0F, AtomOccurence.FROM_DECAY),
    ACTINIUM("Ac", AtomFamilies.ACTINIDE, 89, 227, AtomOccurence.FROM_DECAY),
    THORIUM("Th", AtomFamilies.ACTINIDE, 90, 232.04F),
    PROTACTINIUM("Pa", AtomFamilies.ACTINIDE, 91, 231.04F, AtomOccurence.FROM_DECAY),
    URANIUM("U", AtomFamilies.ACTINIDE, 92, 238.03F),
    NEPTUNIUM("Np", AtomFamilies.ACTINIDE, 93, 237.0F, AtomOccurence.FROM_DECAY),
    PLUTONIUM("Pu", AtomFamilies.ACTINIDE, 94, 244.0F, AtomOccurence.FROM_DECAY),
    AMERICIUM("Am", AtomFamilies.ACTINIDE, 95, 243.0F, AtomOccurence.SYNTHETIC),
    CURIUM("Cm", AtomFamilies.ACTINIDE, 96, 247, AtomOccurence.SYNTHETIC),
    BERKELIUM("Bk", AtomFamilies.ACTINIDE, 97, 251, AtomOccurence.SYNTHETIC),
    CALIFORNIUM("Cf", AtomFamilies.ACTINIDE, 98, 251, AtomOccurence.SYNTHETIC),
    EINSTEINIUM("Es", AtomFamilies.ACTINIDE, 99, 252, AtomOccurence.SYNTHETIC),
    FERMIUM("Fm", AtomFamilies.ACTINIDE, AtomType.UNKNOW, 100, 257, AtomOccurence.SYNTHETIC),
    MENDELEVIUM("Md", AtomFamilies.ACTINIDE, AtomType.UNKNOW, 101, 258, AtomOccurence.SYNTHETIC),
    NOBELIUM("No", AtomFamilies.ACTINIDE, AtomType.UNKNOW, 102, 259, AtomOccurence.SYNTHETIC),
    LAWRENCIUM("Lr", AtomFamilies.ACTINIDE, AtomType.UNKNOW, 103, 266, AtomOccurence.SYNTHETIC),
    RUTHERFORDIUM("Rf", AtomFamilies.TRANSITION_METAL, AtomType.UNKNOW, 104, 267, AtomOccurence.SYNTHETIC),
    DUBNIUM("Db", AtomFamilies.TRANSITION_METAL, AtomType.UNKNOW, 105, 268, AtomOccurence.SYNTHETIC),
    SEABORGIUM("Sg", AtomFamilies.TRANSITION_METAL, AtomType.UNKNOW, 106, 269, AtomOccurence.SYNTHETIC),
    BOHRIUM("Bh", AtomFamilies.TRANSITION_METAL, AtomType.UNKNOW, 107, 270, AtomOccurence.SYNTHETIC),
    HASSIUM("Hs", AtomFamilies.TRANSITION_METAL, AtomType.UNKNOW, 108, 269, AtomOccurence.SYNTHETIC),
    MEITNERIUM("Mt", AtomFamilies.UNKNOW, AtomType.UNKNOW, 109, 278, AtomOccurence.SYNTHETIC),
    DARMSTADTIUM("Ds", AtomFamilies.UNKNOW, AtomType.UNKNOW, 110, 281, AtomOccurence.SYNTHETIC),
    ROENTGENIUM("Rg", AtomFamilies.UNKNOW, AtomType.UNKNOW, 111, 282, AtomOccurence.SYNTHETIC),
    COPERNICIUM("Cn", AtomFamilies.POST_TRANSITION_METAL, AtomType.UNKNOW, 112, 285, AtomOccurence.SYNTHETIC),
    NIHONIUM("Nh", AtomFamilies.UNKNOW, AtomType.UNKNOW, 113, 286, AtomOccurence.SYNTHETIC),
    FLEROVIUM("Fl", AtomFamilies.UNKNOW, AtomType.UNKNOW, 114, 289, AtomOccurence.SYNTHETIC),
    MOSCOVIUM("Mc", AtomFamilies.UNKNOW, AtomType.UNKNOW, 115, 290, AtomOccurence.SYNTHETIC),
    LIVERMORIUM("Lv", AtomFamilies.UNKNOW, AtomType.UNKNOW, 116, 293, AtomOccurence.SYNTHETIC),
    TENNESSINE("Ts", AtomFamilies.UNKNOW, AtomType.UNKNOW, 117, 294, AtomOccurence.SYNTHETIC),
    OGANESSON("Og", AtomFamilies.UNKNOW, AtomType.UNKNOW, 118, 294, AtomOccurence.SYNTHETIC);
    // Source : https://en.wikipedia.org/wiki/Periodic_table.

    private final String symbol;
    private final AtomFamilies atomFamily;
    private final AtomType atomType;
    private final int atomicNumber;
    private final float atomicMass;
    private final AtomOccurence atomOccurence;

    Atoms(String symbol, AtomFamilies atomFamily, AtomType atomType, int atomicNumber, float atomicMass) {
        this.symbol = symbol;
        this.atomFamily = atomFamily;
        this.atomType = atomType;
        this.atomicNumber = atomicNumber;
        this.atomicMass = atomicMass;
        this.atomOccurence = AtomOccurence.PRIMORDIAL;
    }

    Atoms(String symbol, AtomFamilies atomFamily, int atomicNumber, float atomicMass) {
        this.symbol = symbol;
        this.atomFamily = atomFamily;
        this.atomType = AtomType.SOLID;
        this.atomicNumber = atomicNumber;
        this.atomicMass = atomicMass;
        this.atomOccurence = AtomOccurence.PRIMORDIAL;
    }

    Atoms(String symbol, AtomFamilies atomFamily, AtomType atomType, int atomicNumber, float atomicMass, AtomOccurence atomOccurence) {
        this.symbol = symbol;
        this.atomFamily = atomFamily;
        this.atomType = atomType;
        this.atomicNumber = atomicNumber;
        this.atomicMass = atomicMass;
        this.atomOccurence = atomOccurence;
    }

    Atoms(String symbol, AtomFamilies atomFamily, int atomicNumber, float atomicMass, AtomOccurence atomOccurence) {
        this.symbol = symbol;
        this.atomFamily = atomFamily;
        this.atomType = AtomType.SOLID;
        this.atomicNumber = atomicNumber;
        this.atomicMass = atomicMass;
        this.atomOccurence = atomOccurence;
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
        return symbol;
    }

    public Item getItem() {
        return Registry.ITEM.get(new Identifier(MolecularCraft.MODID, this.getSymbol().toLowerCase()));
    }

    public static Atoms fromSymbol(String symbol) {
        for (Atoms atom : values()) {
            if (atom.symbol.equals(symbol)) return atom;
        }
        return Atoms.HYDROGEN;
    }

}
