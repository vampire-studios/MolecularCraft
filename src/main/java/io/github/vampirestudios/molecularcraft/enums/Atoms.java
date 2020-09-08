package io.github.vampirestudios.molecularcraft.enums;

import io.github.vampirestudios.molecularcraft.MolecularCraft;
import io.github.vampirestudios.molecularcraft.molecules.Isotope;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static io.github.vampirestudios.molecularcraft.utils.TimeHelper.*;

public enum Atoms {
    HYDROGEN("H", AtomFamilies.REACTIVE_NONMETAL, AtomType.GAS, 1, 1.008F, new Isotope[]{
            new Isotope("hydrogen", 0, 99.98F, Isotope.DecayMod.STABLE),
            new Isotope("hydrogen", 1, 0.02F, Isotope.DecayMod.STABLE),
            new Isotope("hydrogen", 2, Isotope.DecayMod.BETA_MINUS,
                    new Isotope("helium", 1, 0.0002F, Isotope.DecayMod.STABLE))
    }),
    HELIUM("He", AtomFamilies.NOBLE_GAS, AtomType.GAS,2, 4.0026F, new Isotope[]{
            new Isotope("helium", 1, 0.0002F, Isotope.DecayMod.STABLE),
            new Isotope("helium", 2, 99.9998F, Isotope.DecayMod.STABLE)
    }),
    LITHIUM("Li", AtomFamilies.ALKALI_METAL,3, 6.94F, new Isotope[]{
            new Isotope("lithium", 3, 7.59F, Isotope.DecayMod.STABLE),
            new Isotope("lithium", 4, 92.41F, Isotope.DecayMod.STABLE)
    }),
    BERYLLIUM("Be", AtomFamilies.ALKALIN_EARTH_METAL,4, 9.0122F, new Isotope[]{
            new Isotope("beryllium", 3, (long)(1000L * SECONDS_IN_A_DAY * 53.12F), Isotope.DecayMod.ELECTRON_CAPTURE,
                    new Isotope("lithium", 4, 92.41F, Isotope.DecayMod.STABLE)),
            new Isotope("beryllium", 3, (long)(1000L * SECONDS_IN_A_DAY * 53.12F), Isotope.DecayMod.GAMMA_RAY),
            new Isotope("beryllium", 5, 100F, Isotope.DecayMod.STABLE),
            new Isotope("beryllium", 6, Isotope.DecayMod.BETA_MINUS,
                    new Isotope("boron", 5, 20F, Isotope.DecayMod.STABLE))
    }),
    BORON("B", AtomFamilies.METALLOID,5, 10.81F, new Isotope[]{
            new Isotope("boron", 5, 20F, Isotope.DecayMod.STABLE),
            new Isotope("boron", 6, 80F, Isotope.DecayMod.STABLE)
    }),
    CARBON("C", AtomFamilies.REACTIVE_NONMETAL,6, 12.011F, new Isotope[]{
            new Isotope("carbon", 5, -1, (long)(1000L * SECONDS_IN_A_MINUTE * 20), Isotope.DecayMod.BETA_PLUS,
                    new Isotope("boron", 5, 20F, Isotope.DecayMod.STABLE)),
            new Isotope("carbon", 6, 98.9F, Isotope.DecayMod.STABLE),
            new Isotope("carbon", 7, 1.1F, Isotope.DecayMod.STABLE),
            new Isotope("carbon", 8, Isotope.DecayMod.BETA_MINUS,
                    new Isotope("nitrogen", 7, 99.6F, Isotope.DecayMod.STABLE))
    }),
    NITROGEN("N", AtomFamilies.REACTIVE_NONMETAL, AtomType.GAS,7, 14.007F, new Isotope[]{
            new Isotope("nitrogen", 6, -1F, (long)(1000L * SECONDS_IN_A_MINUTE * 9.965F), Isotope.DecayMod.ELECTRON_CAPTURE,
                    new Isotope("carbon", 7, 1.1F, Isotope.DecayMod.STABLE)),
            new Isotope("nitrogen", 7, 99.6F, Isotope.DecayMod.STABLE),
            new Isotope("nitrogen", 8, 0.4F, Isotope.DecayMod.STABLE)
    }),
    OXYGEN("O", AtomFamilies.REACTIVE_NONMETAL,AtomType.GAS,8,15.999F, new Isotope[]{
            new Isotope("oxygen", 8, 99.76F, Isotope.DecayMod.STABLE),
            new Isotope("oxygen", 9, 0.04F, Isotope.DecayMod.STABLE),
            new Isotope("oxygen", 10, 0.20F, Isotope.DecayMod.STABLE)
    }),
    FLUORINE("F", AtomFamilies.REACTIVE_NONMETAL,AtomType.GAS,9,18.998F, new Isotope[]{
            new Isotope("fluorine", 9, (long)(1000L * SECONDS_IN_A_MINUTE * 109.8F), Isotope.DecayMod.BETA_PLUS,
                    new Isotope("oxygen", 10, 0.20F, Isotope.DecayMod.STABLE)),
            new Isotope("fluorine", 9, (long)(1000L * SECONDS_IN_A_MINUTE * 109.8F), Isotope.DecayMod.ELECTRON_CAPTURE,
                    new Isotope("oxygen", 10, 0.20F, Isotope.DecayMod.STABLE)),
            new Isotope("fluorine", 10, 100.00F, Isotope.DecayMod.STABLE)
    }),
    NEON("Ne", AtomFamilies.NOBLE_GAS,AtomType.GAS,10,20.180F, new Isotope[]{
            new Isotope("neon", 10, 90.48F, Isotope.DecayMod.STABLE),
            new Isotope("neon", 11, 0.27F, Isotope.DecayMod.STABLE),
            new Isotope("neon", 12, 9.25F, Isotope.DecayMod.STABLE)
    }),
    SODIUM("Na", AtomFamilies.ALKALI_METAL,11,22.990F, new Isotope[]{
            new Isotope("sodium", 11, Isotope.DecayMod.BETA_PLUS,
                    new Isotope("neon", 12, 9.25F, Isotope.DecayMod.STABLE)),
            new Isotope("sodium", 12, 100.00F, Isotope.DecayMod.STABLE),
            new Isotope("sodium", 13, (long)(1000L * SECONDS_IN_AN_HOUR * 14.96F), Isotope.DecayMod.BETA_MINUS,
                    new Isotope("magnesium", 12, 79.00F, Isotope.DecayMod.STABLE))
    }),
    MAGNESIUM("Mg", AtomFamilies.ALKALIN_EARTH_METAL,12,24.305F, new Isotope[]{
            new Isotope("magnesium", 12, 79.00F, Isotope.DecayMod.STABLE),
            new Isotope("magnesium", 13, 10.00F, Isotope.DecayMod.STABLE),
            new Isotope("magnesium", 14, 11.00F, Isotope.DecayMod.STABLE)
    }),
    ALUMINIUM("Al", AtomFamilies.POST_TRANSITION_METAL,13,26.982F, new Isotope[]{
            new Isotope("aluminium", 13, Isotope.DecayMod.BETA_PLUS,
                    new Isotope("magnesium", 14, 11.00F, Isotope.DecayMod.STABLE)),
            new Isotope("aluminium", 13, Isotope.DecayMod.ELECTRON_CAPTURE,
                    new Isotope("magnesium", 14, 11.00F, Isotope.DecayMod.STABLE)),
            new Isotope("aluminium", 13, Isotope.DecayMod.GAMMA_RAY),
            new Isotope("aluminium", 14, 100.00F, Isotope.DecayMod.STABLE)
    }),
    SILICON("Si", AtomFamilies.METALLOID,14,28.085F, new Isotope[]{
            new Isotope("silicon", 14, 92.20F, Isotope.DecayMod.STABLE),
            new Isotope("silicon", 15, 4.70F, Isotope.DecayMod.STABLE),
            new Isotope("silicon", 16, 3.10F, Isotope.DecayMod.STABLE),
            new Isotope("silicon", 17, hoursToMillisecond(2.62F), Isotope.DecayMod.BETA_MINUS,
                    new Isotope("phosphorus", 16, 100.00F, Isotope.DecayMod.STABLE)),
            new Isotope("silicon", 18, Isotope.DecayMod.BETA_MINUS,
                    new Isotope("phosphorus", 17, daysToMillisecond(14.28F), Isotope.DecayMod.BETA_MINUS,
                            new Isotope("sulfur", 16, 94.99F, Isotope.DecayMod.STABLE)))
    }),
    PHOSPHORUS("P", AtomFamilies.REACTIVE_NONMETAL,15,30.974F, new Isotope[]{
            new Isotope("phosphorus", 16, 100.00F, Isotope.DecayMod.STABLE),
            new Isotope("phosphorus", 17, daysToMillisecond(14.28F), Isotope.DecayMod.BETA_MINUS,
                    new Isotope("sulfur", 16, 94.99F, Isotope.DecayMod.STABLE)),
            new Isotope("phosphorus", 18, daysToMillisecond(25.3F), Isotope.DecayMod.BETA_MINUS,
                    new Isotope("sulfur", 17, 0.75F, Isotope.DecayMod.STABLE))
    }),
    SULFUR("S", AtomFamilies.REACTIVE_NONMETAL,16,32.06F, new Isotope[]{
            new Isotope("sulfur", 16, 94.99F, Isotope.DecayMod.STABLE),
            new Isotope("sulfur", 17, 0.75F, Isotope.DecayMod.STABLE),
            new Isotope("sulfur", 18, 4.25F, Isotope.DecayMod.STABLE),
            new Isotope("sulfur", 19, daysToMillisecond(87.37F), Isotope.DecayMod.BETA_MINUS,
                    new Isotope("chlorine", 18, 76.00F, Isotope.DecayMod.STABLE)),
            new Isotope("sulfur", 20, 0.01F, Isotope.DecayMod.STABLE),
    }),
    CHLORINE("Cl", AtomFamilies.REACTIVE_NONMETAL, AtomType.GAS,17,35.45F, new Isotope[]{
            new Isotope("chlorine", 18, 76.00F, Isotope.DecayMod.STABLE),
            new Isotope("chlorine", 19, Isotope.DecayMod.BETA_MINUS,
                    new Isotope("argon", 18, 0.334F, Isotope.DecayMod.STABLE)),
            new Isotope("chlorine", 19, Isotope.DecayMod.ELECTRON_CAPTURE,
                    new Isotope("sulfur", 20, 0.01F, Isotope.DecayMod.STABLE)),
            new Isotope("chlorine", 20, 24.00F, Isotope.DecayMod.STABLE)
    }),
    ARGON("Ar", AtomFamilies.NOBLE_GAS, AtomType.GAS,18,39.88F, new Isotope[]{
            new Isotope("argon", 18, 0.334F, Isotope.DecayMod.STABLE),
            new Isotope("argon", 19, -1, daysToMillisecond(35F), Isotope.DecayMod.ELECTRON_CAPTURE,
                    new Isotope("chlorine", 20, 24.00F, Isotope.DecayMod.STABLE)),
            new Isotope("argon", 20, 0.063F, Isotope.DecayMod.STABLE),
            new Isotope("argon", 21, Isotope.DecayMod.BETA_MINUS,
                    new Isotope("potassium", 20, 93.258F, Isotope.DecayMod.STABLE)),
            new Isotope("argon", 22, 99.604F, Isotope.DecayMod.STABLE),

            new Isotope("argon", 23, minutesToMillisecond(109.34F), Isotope.DecayMod.BETA_MINUS,
                    new Isotope("potassium", 22, 6.730F, Isotope.DecayMod.STABLE)),

            new Isotope("argon", 24, Isotope.DecayMod.BETA_MINUS,
                    new Isotope("potassium", 23, hoursToMillisecond(12.3557F), Isotope.DecayMod.BETA_MINUS,
                            new Isotope("calcium", 22, 0.647F, Isotope.DecayMod.STABLE)))
    }),
    POTASSIUM("K", AtomFamilies.ALKALI_METAL, 19, 39.098F, new Isotope[]{
            new Isotope("potassium", 20, 93.258F, Isotope.DecayMod.STABLE),
            new Isotope("potassium", 21, Isotope.DecayMod.BETA_MINUS,
                    new Isotope("calcium", 20, 96.941F, Isotope.DecayMod.STABLE)),
            new Isotope("potassium", 21, Isotope.DecayMod.ELECTRON_CAPTURE,
                    new Isotope("argon", 22, 99.604F, Isotope.DecayMod.STABLE)),
            new Isotope("potassium", 21, Isotope.DecayMod.BETA_PLUS,
                    new Isotope("argon", 22, 99.604F, Isotope.DecayMod.STABLE)),
            new Isotope("potassium", 22, 6.730F, Isotope.DecayMod.STABLE)
    }),
    CALCIUM("Ca", AtomFamilies.ALKALIN_EARTH_METAL, 20, 40.078F, new Isotope[]{
            new Isotope("calcium", 20, 96.941F, Isotope.DecayMod.STABLE),
            new Isotope("calcium", 21, Isotope.DecayMod.ELECTRON_CAPTURE,
                    new Isotope("potassium", 22, 6.730F, Isotope.DecayMod.STABLE)),
            new Isotope("calcium", 22, 0.647F, Isotope.DecayMod.STABLE),
            new Isotope("calcium", 23, 0.135F, Isotope.DecayMod.STABLE),
            new Isotope("calcium", 24, 2.086F, Isotope.DecayMod.STABLE),
            new Isotope("calcium", 25, Isotope.DecayMod.BETA_MINUS,
                    new Isotope("scandium", 24, 100.00F, Isotope.DecayMod.STABLE)),
            new Isotope("calcium", 26, 0.004F, Isotope.DecayMod.STABLE),

            new Isotope("calcium", 27, -1, daysToMillisecond(4.5F), Isotope.DecayMod.BETA_MINUS,
                    new Isotope("scandium", 26, Isotope.DecayMod.BETA_MINUS,
                            new Isotope("titanium", 25, 7.44F, Isotope.DecayMod.STABLE))),
            new Isotope("calcium", 27, -1, daysToMillisecond(4.5F), Isotope.DecayMod.BETA_MINUS,
                    new Isotope("scandium", 26, Isotope.DecayMod.GAMMA_RAY)),

            new Isotope("calcium", 27, -1, daysToMillisecond(4.5F), Isotope.DecayMod.GAMMA_RAY),
            new Isotope("calcium", 28, Isotope.DecayMod.DOUBLE_BETA_MINUS,
                    new Isotope("titanium", 26, 73.72F, Isotope.DecayMod.STABLE))
    }),
    SCANDIUM("Sc", AtomFamilies.TRANSITION_METAL, 21, 44.956F, new Isotope[]{
            new Isotope("scandium", 23, hoursToMillisecond(3.97F), Isotope.DecayMod.BETA_PLUS,
                    new Isotope("calcium", 24, 2.086F, Isotope.DecayMod.STABLE)),
            new Isotope("scandium", 23, -1, hoursToMillisecond(58.61F), Isotope.DecayMod.INTERNAL_CONVERSION,
                    new Isotope("scandium", 23, hoursToMillisecond(3.97F), Isotope.DecayMod.BETA_PLUS,
                            new Isotope("calcium", 24, 2.086F, Isotope.DecayMod.STABLE))),
            new Isotope("scandium", 24, 100.00F, Isotope.DecayMod.STABLE),
            new Isotope("scandium", 25, Isotope.DecayMod.BETA_MINUS,
                    new Isotope("titanium", 24, 8.25F, Isotope.DecayMod.STABLE)),
            new Isotope("scandium", 25, Isotope.DecayMod.GAMMA_RAY),
            new Isotope("scandium", 26, Isotope.DecayMod.BETA_MINUS,
                    new Isotope("titanium", 25, 7.44F, Isotope.DecayMod.STABLE)),
            new Isotope("scandium", 26, Isotope.DecayMod.GAMMA_RAY),
            new Isotope("scandium", 27, -1, hoursToMillisecond(43.67F), Isotope.DecayMod.BETA_MINUS,
                    new Isotope("titanium", 26, 73.72F, Isotope.DecayMod.STABLE)),
            new Isotope("scandium", 27, -1, hoursToMillisecond(43.67F), Isotope.DecayMod.GAMMA_RAY)
    }),
    TITANIUM("Ti", AtomFamilies.TRANSITION_METAL, 22, 47.867F, new Isotope[]{
            new Isotope("titanium", 22, Isotope.DecayMod.ELECTRON_CAPTURE,
                    new Isotope("scandium", 23, hoursToMillisecond(3.97F), Isotope.DecayMod.BETA_PLUS,
                            new Isotope("calcium", 24, 2.086F, Isotope.DecayMod.STABLE))),
            new Isotope("titanium", 22, Isotope.DecayMod.GAMMA_RAY),
            new Isotope("titanium", 24, 8.25F, Isotope.DecayMod.STABLE),
            new Isotope("titanium", 25, 7.44F, Isotope.DecayMod.STABLE),
            new Isotope("titanium", 26, 73.72F, Isotope.DecayMod.STABLE),
            new Isotope("titanium", 27, 5.41F, Isotope.DecayMod.STABLE),
            new Isotope("titanium", 28, 5.18F, Isotope.DecayMod.STABLE)
    }),
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

    private String symbol;
    private AtomFamilies atomFamily;
    private AtomType atomType;
    private int atomicNumber;
    private float atomicMass;
    private AtomOccurence atomOccurence;
    private Isotope[] isotopes;

    Atoms(String symbol, AtomFamilies atomFamily, AtomType atomType, int atomicNumber, float atomicMass, Isotope[] isotopes) {
        this.symbol = symbol;
        this.atomFamily = atomFamily;
        this.atomType = atomType;
        this.atomicNumber = atomicNumber;
        this.atomicMass = atomicMass;
        this.atomOccurence = AtomOccurence.PRIMORDIAL;
        this.isotopes = isotopes;
    }

    Atoms(String symbol, AtomFamilies atomFamily, int atomicNumber, float atomicMass, Isotope[] isotopes) {
        this.symbol = symbol;
        this.atomFamily = atomFamily;
        this.atomType = AtomType.SOLID;
        this.atomicNumber = atomicNumber;
        this.atomicMass = atomicMass;
        this.atomOccurence = AtomOccurence.PRIMORDIAL;
        this.isotopes = isotopes;
    }

    Atoms(String symbol, AtomFamilies atomFamily, AtomType atomType, int atomicNumber, float atomicMass, AtomOccurence atomOccurence, Isotope[] isotopes) {
        this.symbol = symbol;
        this.atomFamily = atomFamily;
        this.atomType = atomType;
        this.atomicNumber = atomicNumber;
        this.atomicMass = atomicMass;
        this.atomOccurence = atomOccurence;
        this.isotopes = isotopes;
    }

    Atoms(String symbol, AtomFamilies atomFamily, int atomicNumber, float atomicMass, AtomOccurence atomOccurence, Isotope[] isotopes) {
        this.symbol = symbol;
        this.atomFamily = atomFamily;
        this.atomType = AtomType.SOLID;
        this.atomicNumber = atomicNumber;
        this.atomicMass = atomicMass;
        this.atomOccurence = atomOccurence;
        this.isotopes = isotopes;
    }

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
        return symbol;
    }

    public Item getItem() {
        return Registry.ITEM.get(new Identifier(MolecularCraft.MODID, this.getSymbol().toLowerCase()));
    }

    private static long yearsToMillisecond(float year) {
        return (long)(1000L * SECONDS_IN_A_YEAR * year);
    }

    private static long yearsToMillisecond(float year, int tenPower) {
        float years = year;
        for (int g = 0; g < tenPower; g++) years = years * 10;
        return (long)(1000L * SECONDS_IN_A_YEAR * years);
    }

    private static long daysToMillisecond(float day) {
        return (long)(1000L * SECONDS_IN_A_DAY * day);
    }

    private static long hoursToMillisecond(float hour) {
        return (long)(1000L * SECONDS_IN_AN_HOUR * hour);
    }

    private static long minutesToMillisecond(float minute) {
        return (long)(1000L * SECONDS_IN_A_MINUTE * minute);
    }

    private static long secondsToMillisecond(float second) {
        return (long)(1000L * second);
    }

    public static Atoms fromSymbol(String symbol) {
        for (Atoms atom : values()) {
            if (atom.symbol.toLowerCase().equals(symbol.toLowerCase())) return atom;
        }
        return Atoms.HYDROGEN;
    }

}
