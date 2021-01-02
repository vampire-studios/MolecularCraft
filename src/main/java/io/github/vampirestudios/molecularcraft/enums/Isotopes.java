package io.github.vampirestudios.molecularcraft.enums;

import io.github.vampirestudios.molecularcraft.molecules.Isotope;
import net.fabricmc.loader.api.FabricLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import static io.github.vampirestudios.molecularcraft.enums.Atoms.*;
import static io.github.vampirestudios.molecularcraft.utils.TimeHelper.*;

public class Isotopes {
    private static final Map<Atoms, Map<Integer, Isotope>> ATOM_ISOTOPES_MAP = new HashMap<>();

    public static void init() {
        for (Atoms atom : Atoms.values()) {
            ATOM_ISOTOPES_MAP.put(atom, new HashMap<>());
        }

        register(HYDROGEN, 1, 99.98F);
        register(HYDROGEN, 2, 0.02F);
        register(HYDROGEN, 3, Isotope.Abundance.TRACE, y(12.32F), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.BETA_MINUS, HELIUM, 3)
        });

        register(HELIUM, 3, 0.0002F);
        register(HELIUM, 4, 99.9998F);

        register(LITHIUM, 6, 7.59F);
        register(LITHIUM, 7, 92.41F);

        register(BERYLLIUM, 7, Isotope.Abundance.TRACE, d(53.12F), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.ELECTRON_CAPTURE, LITHIUM, 7)
        });
        register(BERYLLIUM, 9, 100F);
        register(BERYLLIUM, 10, Isotope.Abundance.TRACE, y(1.39F, 6), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.BETA_MINUS, BORON, 10)
        });

        register(BORON, 10, 20F);
        register(BORON, 11, 80F);

        register(CARBON, 11, Isotope.Abundance.SYNTHETIC, min(20F), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.BETA_PLUS, BORON, 11)
        });
        register(CARBON, 12, 98.9F);
        register(CARBON, 13, 1.1F);
        register(CARBON, 14, Isotope.Abundance.TRACE, y(5730F), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.BETA_MINUS, NITROGEN, 14)
        });

        register(NITROGEN, 13, Isotope.Abundance.SYNTHETIC, min(9.965F), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.ELECTRON_CAPTURE, CARBON, 13)
        });
        register(NITROGEN, 14, 99.6F);
        register(NITROGEN, 15, 0.4F);

        register(OXYGEN, 16, 99.76F);
        register(OXYGEN, 17, 0.04F);
        register(OXYGEN, 18, 0.2F);

        register(FLUORINE, 18, Isotope.Abundance.TRACE, min(109.8F), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.BETA_PLUS, 97F, OXYGEN, 18),
                new Isotope.Decay(Isotope.DecayMod.ELECTRON_CAPTURE, 3F, OXYGEN, 18)
        });
        register(FLUORINE, 19, 100F);

        register(NEON, 20, 90.48F);
        register(NEON, 21, 0.27F);
        register(NEON, 22, 9.25F);

        register(SODIUM, 22, Isotope.Abundance.TRACE, y(2.602F), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.BETA_PLUS, NEON, 22)
        });
        register(SODIUM, 23, 100F);
        register(SODIUM, 24, Isotope.Abundance.TRACE, h(14.96F), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.BETA_MINUS, MAGNESIUM, 24)
        });

        register(MAGNESIUM, 24, 79F);
        register(MAGNESIUM, 25, 10F);
        register(MAGNESIUM, 26, 11F);

        register(ALUMINIUM, 26, Isotope.Abundance.TRACE, y(7.17F, 5), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.BETA_PLUS, 85F, MAGNESIUM, 26),
                new Isotope.Decay(Isotope.DecayMod.ELECTRON_CAPTURE, 15F, MAGNESIUM, 26)
        });
        register(ALUMINIUM, 27, 100F);

        register(SILICON, 28, 92.2F);
        register(SILICON, 29, 4.7F);
        register(SILICON, 30, 3.1F);
        register(SILICON, 31, Isotope.Abundance.TRACE, h(2.62F), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.BETA_MINUS, PHOSPHORUS, 31)
        });
        register(SILICON, 32, Isotope.Abundance.TRACE, y(153F), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.BETA_MINUS, PHOSPHORUS, 32)
        });

        register(PHOSPHORUS, 31, 100F);
        register(PHOSPHORUS, 32, Isotope.Abundance.TRACE, d(14.28F), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.BETA_MINUS, SULFUR, 32)
        });
        register(PHOSPHORUS, 33, Isotope.Abundance.TRACE, d(25.3F), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.BETA_MINUS, SULFUR, 33)
        });

        register(SULFUR, 32, 94.99F);
        register(SULFUR, 33, 0.75F);
        register(SULFUR, 34, 4.25F);
        register(SULFUR, 35, Isotope.Abundance.TRACE, d(87.37F), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.BETA_MINUS, CHLORINE, 35)
        });
        register(SULFUR, 36, 0.01F);

        register(CHLORINE, 35, 76F);
        register(CHLORINE, 36, Isotope.Abundance.TRACE, y(3.01F, 5), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.BETA_MINUS, 98.1F, ARGON, 36),
                new Isotope.Decay(Isotope.DecayMod.BETA_PLUS, 1.9F, SULFUR, 36)
        });
        register(CHLORINE, 37, 24F);

        register(ARGON, 36, 0.334F);
        register(ARGON, 37, Isotope.Abundance.SYNTHETIC, d(35F), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.ELECTRON_CAPTURE, CHLORINE, 37)
        });
        register(ARGON, 38, 0.063F);
        register(ARGON, 39, Isotope.Abundance.TRACE, y(269F), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.BETA_MINUS, POTASSIUM, 39)
        });
        register(ARGON, 40, 99.604F);
        register(ARGON, 41, Isotope.Abundance.SYNTHETIC, min(109.34F), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.BETA_MINUS, POTASSIUM, 41)
        });
        register(ARGON, 42, Isotope.Abundance.SYNTHETIC, y(32.9F), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.BETA_MINUS, POTASSIUM, 42)
        });

        register(POTASSIUM, 39, 93.258F);
        register(POTASSIUM, 40, 0.012F, y(1.248F, 9), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.BETA_MINUS, 89.28F, CALCIUM, 40),
                new Isotope.Decay(Isotope.DecayMod.ELECTRON_CAPTURE, 10.72F, ARGON, 40),
                new Isotope.Decay(Isotope.DecayMod.BETA_PLUS, 0.001F, ARGON, 40)
        });
        register(POTASSIUM, 41, 6.73F);
        register(POTASSIUM, 42, Isotope.Abundance.TRACE, h(12.355F), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.BETA_MINUS, CALCIUM, 42)
        });

        register(CALCIUM, 40, 99.941F);
        register(CALCIUM, 41, Isotope.Abundance.TRACE, y(9.94F, 4), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.ELECTRON_CAPTURE, POTASSIUM, 41)
        });
        register(CALCIUM, 42, 0.647F);
        register(CALCIUM, 43, 0.135F);
        register(CALCIUM, 44, 2.086F);
        register(CALCIUM, 45, Isotope.Abundance.SYNTHETIC, d(162.6F), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.BETA_MINUS, SCANDIUM, 45)
        });
        register(CALCIUM, 46, 0.004F);
        register(CALCIUM, 47, Isotope.Abundance.SYNTHETIC, d(4.5F), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.BETA_MINUS, SCANDIUM, 47)
        });
        register(CALCIUM, 48, 0.187F, y(6.4F, 19), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.DOUBLE_BETA_MINUS, TITANIUM, 48)
        });

        register(SCANDIUM, 44, Isotope.Abundance.SYNTHETIC, h(3.97F), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.BETA_PLUS, CALCIUM, 44)
        });
        register(SCANDIUM, 45, 100F);
        register(SCANDIUM, 46, Isotope.Abundance.SYNTHETIC, d(83.79F), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.BETA_MINUS, TITANIUM, 46)
        });
        register(SCANDIUM, 47, Isotope.Abundance.SYNTHETIC, h(80.38F), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.BETA_MINUS, TITANIUM, 47)
        });
        register(SCANDIUM, 48, Isotope.Abundance.SYNTHETIC, h(43.67F), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.BETA_MINUS, TITANIUM, 48)
        });

        register(TITANIUM, 44, Isotope.Abundance.SYNTHETIC, y(63F), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.ELECTRON_CAPTURE, SCANDIUM, 44)
        });
        register(TITANIUM, 46, 8.25F);
        register(TITANIUM, 47, 7.44F);
        register(TITANIUM, 48, 73.72F);
        register(TITANIUM, 49, 5.41F);
        register(TITANIUM, 50, 5.18F);

        register(VANADIUM, 48, Isotope.Abundance.SYNTHETIC, d(16F), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.BETA_PLUS, TITANIUM, 48)
        });
        register(VANADIUM, 49, Isotope.Abundance.SYNTHETIC, d(330F), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.ELECTRON_CAPTURE, TITANIUM, 49)
        });
        register(VANADIUM, 50, 0.25F, y(1.5F, 17), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.ELECTRON_CAPTURE, 83F, TITANIUM, 50),
                new Isotope.Decay(Isotope.DecayMod.BETA_MINUS, 17F, CHROMIUM, 50)
        });
        register(VANADIUM, 51, 99.75F);

        register(CHROMIUM, 50, 4.345F);
        register(CHROMIUM, 51, Isotope.Abundance.SYNTHETIC, d(27.7025F), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.ELECTRON_CAPTURE, VANADIUM, 51)
        });
        register(CHROMIUM, 52, 83.789F);
        register(CHROMIUM, 53, 9.501F);
        register(CHROMIUM, 54, 2.365F);

        register(MANGANESE, 52, Isotope.Abundance.SYNTHETIC, d(5.6F), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.BETA_PLUS, CHROMIUM, 52)
        });
        register(MANGANESE, 53, Isotope.Abundance.TRACE, y(3.74F, 6), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.ELECTRON_CAPTURE, CHROMIUM, 53)
        });
        register(MANGANESE, 54, Isotope.Abundance.SYNTHETIC, d(312F), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.ELECTRON_CAPTURE, 99.98F, CHROMIUM, 54),
                new Isotope.Decay(Isotope.DecayMod.BETA_MINUS, 0.01F, IRON, 54),
                new Isotope.Decay(Isotope.DecayMod.BETA_PLUS, 0.01F, CHROMIUM, 54)
        });
        register(MANGANESE, 55, 100F);

        register(IRON, 54, 5.85F);
        register(IRON, 55, Isotope.Abundance.SYNTHETIC, y(2.73F), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.ELECTRON_CAPTURE, MANGANESE, 55)
        });
        register(IRON, 56, 91.75F);
        register(IRON, 57, 2.12F);
        register(IRON, 58, 0.28F);
        register(IRON, 59, Isotope.Abundance.SYNTHETIC, d(44.6F), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.BETA_MINUS, COBALT, 59)
        });
        register(IRON, 60, Isotope.Abundance.TRACE, y(2.6F, 6), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.BETA_MINUS, COBALT, 60)
        });

        register(COBALT, 56, Isotope.Abundance.SYNTHETIC, d(77.27F), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.ELECTRON_CAPTURE, IRON, 56)
        });
        register(COBALT, 57, Isotope.Abundance.SYNTHETIC, d(271.79F), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.ELECTRON_CAPTURE, IRON, 57)
        });
        register(COBALT, 58, Isotope.Abundance.SYNTHETIC, d(70.86F), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.ELECTRON_CAPTURE, IRON, 58)
        });
        register(COBALT, 59, 100F);
        register(COBALT, 60, Isotope.Abundance.SYNTHETIC, y(5.2714F), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.BETA_MINUS, NICKEL, 60)
        });

        register(NICKEL, 58, 68.077F);
        register(NICKEL, 59, Isotope.Abundance.TRACE, y(7.6F, 4), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.ELECTRON_CAPTURE, COBALT, 59)
        });
        register(NICKEL, 60, 26.223F);
        register(NICKEL, 61, 1.14F);
        register(NICKEL, 62, 3.635F);
        register(NICKEL, 63, Isotope.Abundance.SYNTHETIC, y(100), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.BETA_MINUS, COPPER, 63)
        });
        register(NICKEL, 64, 0.926F);

        register(COPPER, 63, 69.17F);
        register(COPPER, 64, Isotope.Abundance.SYNTHETIC, h(12.7F), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.BETA_PLUS, 61, NICKEL, 64),
                new Isotope.Decay(Isotope.DecayMod.BETA_MINUS, 39, ZINC, 64)
        });
        register(COPPER, 65, 30.83F);
        register(COPPER, 67, Isotope.Abundance.SYNTHETIC, h(61.83F), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.BETA_MINUS, ZINC, 67)
        });

        register(ZINC, 64, 49.2F);
        register(ZINC, 65, Isotope.Abundance.SYNTHETIC, d(244), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.BETA_MINUS, COPPER, 65)
        });
        register(ZINC, 66, 27.7F);
        register(ZINC, 67, 4);
        register(ZINC, 68, 18.5F);
        register(ZINC, 69, Isotope.Abundance.SYNTHETIC, min(56), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.BETA_MINUS, GALLIUM, 69)
        });
        register(ZINC, 70, 0.6F);
        register(ZINC, 71, Isotope.Abundance.SYNTHETIC, min(2.4F), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.BETA_MINUS, GALLIUM, 71)
        });
        register(ZINC, 72, Isotope.Abundance.SYNTHETIC, h(46.5F), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.BETA_MINUS, GALLIUM, 72)
        });

        register(GALLIUM, 66, Isotope.Abundance.SYNTHETIC, h(9.5F), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.BETA_PLUS, ZINC, 66)
        });
        register(GALLIUM, 67, Isotope.Abundance.SYNTHETIC, d(3.3F), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.ELECTRON_CAPTURE, ZINC, 67)
        });
        register(GALLIUM, 68, Isotope.Abundance.SYNTHETIC, h(1.2F), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.BETA_PLUS, ZINC, 68)
        });
        register(GALLIUM, 69, 60.11F);
        register(GALLIUM, 70, Isotope.Abundance.SYNTHETIC, min(21), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.BETA_MINUS, 99.59F, GERMANIUM, 70),
                new Isotope.Decay(Isotope.DecayMod.ELECTRON_CAPTURE, 0.41F, ZINC, 70)
        });
        register(GALLIUM, 71, 39.89F);
        register(GALLIUM, 72, Isotope.Abundance.SYNTHETIC, h(14.1F), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.BETA_MINUS, GERMANIUM, 72)
        });
        register(GALLIUM, 73, Isotope.Abundance.SYNTHETIC, h(4.9F), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.BETA_MINUS, GERMANIUM, 73)
        });

        register(GERMANIUM, 68, Isotope.Abundance.SYNTHETIC, d(270.95F), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.ELECTRON_CAPTURE, GALLIUM, 68)
        });
        register(GERMANIUM, 70, 20.52F);
        register(GERMANIUM, 71, Isotope.Abundance.SYNTHETIC, d(11.3F), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.ELECTRON_CAPTURE, GALLIUM, 71)
        });
        register(GERMANIUM, 72, 27.45F);
        register(GERMANIUM, 73, 7.76F);
        register(GERMANIUM, 74, 36.7F);
        register(GERMANIUM, 76, 7.75F, y(1.78F, 21), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.DOUBLE_BETA_MINUS, SELENIUM, 76)
        });

        register(ARSENIC, 72, Isotope.Abundance.TRACE, h(26.01F), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.BETA_PLUS, GERMANIUM, 72)
        });
        register(ARSENIC, 73, Isotope.Abundance.SYNTHETIC, d(80.3F), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.ELECTRON_CAPTURE, GERMANIUM, 73)
        });
        register(ARSENIC, 74, Isotope.Abundance.SYNTHETIC, d(17.8F), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.BETA_PLUS, 66F, GERMANIUM, 74),
                new Isotope.Decay(Isotope.DecayMod.BETA_MINUS, 34F, SELENIUM, 74)
        });
        register(ARSENIC, 75, 100F);

        register(SELENIUM, 72, Isotope.Abundance.SYNTHETIC, d(8.4F), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.ELECTRON_CAPTURE, ARSENIC, 72)
        });
        register(SELENIUM, 74, 0.86F);
        register(SELENIUM, 75, Isotope.Abundance.SYNTHETIC, d(119.8F), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.ELECTRON_CAPTURE, ARSENIC, 75)
        });
        register(SELENIUM, 76, 9.23F);
        register(SELENIUM, 77, 7.6F);
        register(SELENIUM, 78, 23.69F);
        register(SELENIUM, 79, Isotope.Abundance.TRACE, y(3.27F, 5), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.BETA_MINUS, BROMINE, 79)
        });
        register(SELENIUM, 80, 49.80F);
        register(SELENIUM, 82, 8.82F, y(1.08F, 20), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.DOUBLE_BETA_MINUS, KRYPTON, 82)
        });

        register(BROMINE, 79, 51F);
        register(BROMINE, 81, 49F);

        register(KRYPTON, 78, 0.36F, y(9.2F, 21), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.DOUBLE_ELECTRON_CAPTURE, SELENIUM, 78)
        });
        register(KRYPTON, 79, Isotope.Abundance.SYNTHETIC, h(35F), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.BETA_PLUS, BROMINE, 79)
        });
        register(KRYPTON, 80, 2.29F);
        register(KRYPTON, 81, Isotope.Abundance.TRACE, y(2.3F, 5), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.ELECTRON_CAPTURE, BROMINE, 81)
        });
        register(KRYPTON, 82, 11.59F);
        register(KRYPTON, 83, 11.50F);
        register(KRYPTON, 84, 56.99F);
        register(KRYPTON, 85, Isotope.Abundance.SYNTHETIC, y(11F), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.BETA_MINUS, RUBIDIUM, 85)
        });
        register(KRYPTON, 86, 17.28F);

        register(RUBIDIUM, 82, Isotope.Abundance.TRACE, min(1.273F), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.BETA_PLUS, KRYPTON, 82)
        });
        register(RUBIDIUM, 83, Isotope.Abundance.SYNTHETIC, d(86.2F), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.ELECTRON_CAPTURE, KRYPTON, 83)
        });
        register(RUBIDIUM, 84, Isotope.Abundance.SYNTHETIC, d(32.9F), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.BETA_PLUS, 96.2F, KRYPTON, 84),
                new Isotope.Decay(Isotope.DecayMod.BETA_MINUS, 3.8F, STRONTIUM, 84)
        });
        register(RUBIDIUM, 85, 72.71F);
        register(RUBIDIUM, 86, Isotope.Abundance.SYNTHETIC, d(18.7F), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.BETA_MINUS, 99.9948F, STRONTIUM, 86),
                new Isotope.Decay(Isotope.DecayMod.ELECTRON_CAPTURE, 0.0052F, KRYPTON, 86)
        });
        register(RUBIDIUM, 87, 27.83F, y(4.9F, 10), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.BETA_MINUS, STRONTIUM, 87)
        });

        register(STRONTIUM, 82, Isotope.Abundance.SYNTHETIC, d(25.36F), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.ELECTRON_CAPTURE, RUBIDIUM, 82)
        });
        register(STRONTIUM, 83, Isotope.Abundance.SYNTHETIC, d(1.35F), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.BETA_PLUS, RUBIDIUM, 83)
        });
        register(STRONTIUM, 84, 0.56F);
        register(STRONTIUM, 85, Isotope.Abundance.SYNTHETIC, d(64.84F), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.ELECTRON_CAPTURE, RUBIDIUM, 85)
        });
        register(STRONTIUM, 86, 9.86F);
        register(STRONTIUM, 87, 7.00F);
        register(STRONTIUM, 88, 82.58F);
        register(STRONTIUM, 89, Isotope.Abundance.SYNTHETIC, d(50.52F), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.BETA_MINUS, YTTRIUM, 89)
        });
        register(STRONTIUM, 90, Isotope.Abundance.TRACE, y(28.90F), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.BETA_MINUS, YTTRIUM, 90)
        });

        register(YTTRIUM, 87, Isotope.Abundance.SYNTHETIC, d(3.4F), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.ELECTRON_CAPTURE, STRONTIUM, 87)
        });
        register(YTTRIUM, 88, Isotope.Abundance.SYNTHETIC, d(106.6F), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.BETA_PLUS, STRONTIUM, 88)
        });
        register(YTTRIUM, 89, 100F);
        register(YTTRIUM, 90, Isotope.Abundance.SYNTHETIC, d(2.7F), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.BETA_MINUS, ZIRCONIUM, 90)
        });
        register(YTTRIUM, 91, Isotope.Abundance.SYNTHETIC, d(58.5F), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.BETA_MINUS, ZIRCONIUM, 91)
        });

        register(ZIRCONIUM, 88, Isotope.Abundance.SYNTHETIC, d(83.4F), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.ELECTRON_CAPTURE, YTTRIUM, 88)
        });
        register(ZIRCONIUM, 89, Isotope.Abundance.SYNTHETIC, h(78.4F), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.BETA_PLUS, YTTRIUM, 89)
        });
        register(ZIRCONIUM, 90, 51.45F);
        register(ZIRCONIUM, 91, 11.22F);
        register(ZIRCONIUM, 92, 17.15F);
        register(ZIRCONIUM, 93, Isotope.Abundance.TRACE, y(1.53F, 6), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.BETA_MINUS, NIOBIUM, 93)
        });
        register(ZIRCONIUM, 94, 17.38F);
        register(ZIRCONIUM, 96, 2.80F, y(2.0F, 19), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.DOUBLE_BETA_MINUS, MOLYBDENUM, 96)
        });

        register(NIOBIUM, 90, Isotope.Abundance.SYNTHETIC, h(15F), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.BETA_PLUS, ZIRCONIUM, 90)
        });
        register(NIOBIUM, 91, Isotope.Abundance.SYNTHETIC, y(680F), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.ELECTRON_CAPTURE, 99.98F, ZIRCONIUM, 91),
                new Isotope.Decay(Isotope.DecayMod.BETA_PLUS, 0.013F, ZIRCONIUM, 91)
        });
        register(NIOBIUM, 92, Isotope.Abundance.TRACE, y(3.47F, 7), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.BETA_PLUS, 99.95F, ZIRCONIUM, 92),
                new Isotope.Decay(Isotope.DecayMod.BETA_MINUS, 0.05F, MOLYBDENUM, 92)
        });
        register(NIOBIUM, 93, 100F);
        register(NIOBIUM, 94, Isotope.Abundance.TRACE, y(20.3F, 3), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.BETA_MINUS, MOLYBDENUM, 94)
        });
        register(NIOBIUM, 95, Isotope.Abundance.SYNTHETIC, d(35F), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.BETA_MINUS, MOLYBDENUM, 95)
        });
        register(NIOBIUM, 96, Isotope.Abundance.SYNTHETIC, h(24F), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.BETA_MINUS, MOLYBDENUM, 96)
        });

        register(MOLYBDENUM, 92, 14.65F);
        register(MOLYBDENUM, 93, Isotope.Abundance.SYNTHETIC, y(4, 3), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.ELECTRON_CAPTURE, NIOBIUM, 93)
        });
        register(MOLYBDENUM, 94, 9.19F);
        register(MOLYBDENUM, 95, 15.87F);
        register(MOLYBDENUM, 96, 16.67F);
        register(MOLYBDENUM, 97, 9.58F);
        register(MOLYBDENUM, 98, 24.29F);
        register(MOLYBDENUM, 99, Isotope.Abundance.SYNTHETIC, h(65.94F), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.BETA_MINUS, TECHNETIUM, 99)
        });
        register(MOLYBDENUM, 100, 9.74F, y(7.8F, 18), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.DOUBLE_BETA_MINUS, RUTHENIUM, 100)
        });

        register(TECHNETIUM, 95, Isotope.Abundance.SYNTHETIC, h(20.01F), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.BETA_PLUS, MOLYBDENUM, 95)
        });
        register(TECHNETIUM, 96, Isotope.Abundance.SYNTHETIC, d(4.3F), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.BETA_PLUS, MOLYBDENUM, 96)
        });
        register(TECHNETIUM, 97, Isotope.Abundance.SYNTHETIC, y(4.21F, 6), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.ELECTRON_CAPTURE, MOLYBDENUM, 97)
        });
        register(TECHNETIUM, 98, Isotope.Abundance.SYNTHETIC, y(4.2F, 6), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.BETA_MINUS, RUTHENIUM, 98)
        });
        register(TECHNETIUM, 99, Isotope.Abundance.TRACE, y(2.111F, 5), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.BETA_MINUS, RUTHENIUM, 99)
        });

        register(RUTHENIUM, 96, 5.54F);
        register(RUTHENIUM, 97, Isotope.Abundance.SYNTHETIC, d(2.9F), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.BETA_PLUS, TECHNETIUM, 97)
        });
        register(RUTHENIUM, 98, 1.87F);
        register(RUTHENIUM, 99, 12.76F);
        register(RUTHENIUM, 100, 12.60F);
        register(RUTHENIUM, 101, 17.06F);
        register(RUTHENIUM, 102, 31.55F);
        register(RUTHENIUM, 103, Isotope.Abundance.SYNTHETIC, d(39.26F), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.BETA_MINUS, RHODIUM, 103)
        });
        register(RUTHENIUM, 104, 18.62F);
        register(RUTHENIUM, 106, Isotope.Abundance.SYNTHETIC, d(373.59F), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.BETA_MINUS, RHODIUM, 106)
        });

        register(RHODIUM, 99, Isotope.Abundance.SYNTHETIC, d(16.1F), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.BETA_PLUS,  RUTHENIUM, 99)
        });
        register(RHODIUM, 100, Isotope.Abundance.SYNTHETIC, h(20.81F), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.BETA_PLUS, RUTHENIUM, 100)
        });
        register(RHODIUM, 101, Isotope.Abundance.SYNTHETIC, y(3.3F), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.ELECTRON_CAPTURE, RUTHENIUM, 101)
        });
        register(RHODIUM, 102, Isotope.Abundance.SYNTHETIC, d(207F), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.BETA_PLUS, 80, RUTHENIUM, 102),
                new Isotope.Decay(Isotope.DecayMod.BETA_MINUS, 20, PALLADIUM, 102)
        });
        register(RHODIUM, 103, 100);
        register(RHODIUM, 105, Isotope.Abundance.SYNTHETIC, h(35.36F), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.BETA_MINUS, PALLADIUM, 105)
        });
        register(RHODIUM, 106, Isotope.Abundance.SYNTHETIC, s(29.808F), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.BETA_MINUS, PALLADIUM, 106)
        });

        register(PALLADIUM, 100, Isotope.Abundance.SYNTHETIC, d(3.63F), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.ELECTRON_CAPTURE, RHODIUM, 100)
        });
        register(PALLADIUM, 102, 1.02F);
        register(PALLADIUM, 103, Isotope.Abundance.SYNTHETIC, d(16.991F), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.ELECTRON_CAPTURE, RHODIUM, 103)
        });
        register(PALLADIUM, 104, 11.14F);
        register(PALLADIUM, 105, 22.33F);
        register(PALLADIUM, 106, 27.33F);
        register(PALLADIUM, 107, Isotope.Abundance.TRACE, y(6.5F, 6), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.BETA_MINUS, SILVER, 107)
        });
        register(PALLADIUM, 108, 26.46F);
        register(PALLADIUM, 110, 11.72F);

        register(SILVER, 105, Isotope.Abundance.SYNTHETIC, d(41.2F), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.ELECTRON_CAPTURE, PALLADIUM, 105)
        });
        register(SILVER, 107, 51.839F);
        register(SILVER, 109, 48.161F);
        register(SILVER, 111, Isotope.Abundance.SYNTHETIC, d(7.45F), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.BETA_MINUS, CADMIUM, 111)
        });

        register(CADMIUM, 106, 1.25F);
        register(CADMIUM, 107, Isotope.Abundance.SYNTHETIC, h(6.5F), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.ELECTRON_CAPTURE, SILVER, 107)
        });
        register(CADMIUM, 108, 0.89F);
        register(CADMIUM, 109, Isotope.Abundance.SYNTHETIC, d(462.6F), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.ELECTRON_CAPTURE, SILVER, 109)
        });
        register(CADMIUM, 110, 12.47F);
        register(CADMIUM, 111, 12.80F);
        register(CADMIUM, 112, 24.11F);
        register(CADMIUM, 113, 12.23F, y(7.7F, 15), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.BETA_MINUS, INDIUM, 113)
        });
        register(CADMIUM, 114, 28.75F);
        register(CADMIUM, 115, Isotope.Abundance.SYNTHETIC, h(53.46F), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.BETA_MINUS, INDIUM, 115)
        });
        register(CADMIUM, 116, 7.51F, y(3.1F, 19), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.DOUBLE_BETA_MINUS, TIN, 116)
        });

        register(INDIUM, 111, Isotope.Abundance.SYNTHETIC, d(2.8F), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.ELECTRON_CAPTURE, CADMIUM, 111)
        });
        register(INDIUM, 113, 4.28F);
        register(INDIUM, 115, 95.72F, y(4.41F, 14), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.BETA_MINUS, TIN, 115)
        });

        register(TIN, 112, 0.97F);
        register(TIN, 114, 0.66F);
        register(TIN, 115, 0.34F);
        register(TIN, 116, 14.54F);
        register(TIN, 117, 7.68F);
        register(TIN, 118, 24.22F);
        register(TIN, 119, 8.59F);
        register(TIN, 120, 32.58F);
        register(TIN, 122, 4.63F);
        register(TIN, 124, 5.79F);
        register(TIN, 126, Isotope.Abundance.TRACE, y(2.3F, 5), new Isotope.Decay[]{
                new Isotope.Decay(Isotope.DecayMod.BETA_MINUS, ANTIMONY, 126)
        });

        if (FabricLoader.getInstance().isDevelopmentEnvironment()) {
            Logger logger = LogManager.getLogger();
            Isotope isotope = null;
            int i = 0;
            while (isotope == null || isotope.getNucleonNumber() != 46) {
                i++;
                isotope = getRandomIsotope(CALCIUM);
            }
            logger.info(i);

            for (Map.Entry<Atoms, Map<Integer, Isotope>> entry : ATOM_ISOTOPES_MAP.entrySet()) {
                Atoms atom = entry.getKey();
                for (Map.Entry<Integer, Isotope> entry1 : entry.getValue().entrySet()) {
                    int number= entry1.getKey();
                    Isotope isotope1 = entry1.getValue();
                    for (Isotope.Decay decay : isotope1.getDecays()) {
                        if (decay.hasProduct()) {
                            Atoms decayAtom = decay.getAtom();
                            int decayNumber = decay.getNucleonNumber();
                            if (!ATOM_ISOTOPES_MAP.get(decayAtom).containsKey(decayNumber)) {
                                logger.info("Unknown Isotope: " + decayAtom.getSymbol() + decayNumber);
                            }
                        }
                    }
                }
            }
        }
    }

    private static void register(Atoms atom, int nucleonNumber, Isotope.Abundance abundance, float abundancePercent, boolean decay, TimeAmount halfLife, Isotope.Decay... decays) {
        Isotope isotope = new Isotope(atom, nucleonNumber, abundance, abundancePercent, decay, halfLife, decays);
        ATOM_ISOTOPES_MAP.get(atom).put(nucleonNumber, isotope);
    }

    private static void register(Atoms atom, int nucleonNumber, float abundancePercent) {
        register(atom, nucleonNumber, Isotope.Abundance.AMOUNT, abundancePercent, false, new TimeAmount(TimeAmount.Unit.MILLISECOND, -1));
    }

    private static void register(Atoms atom, int nucleonNumber, Isotope.Abundance abundance, TimeAmount halfLife, Isotope.Decay[] decays) {
        register(atom, nucleonNumber, abundance, 0F, true, halfLife, decays);
    }

    private static void register(Atoms atom, int nucleonNumber, float abundancePercent, TimeAmount halfLife, Isotope.Decay[] decays) {
        register(atom, nucleonNumber, Isotope.Abundance.AMOUNT, abundancePercent, true, halfLife, decays);
    }


    public static Isotope getRandomIsotope(Atoms atom) {
        Isotope isotope = null;
        Map<Integer, Isotope> atomIsotopes = ATOM_ISOTOPES_MAP.get(atom);
        List<Isotope> naturalIsotopes = new ArrayList<>();
        for (Isotope entry : atomIsotopes.values()) {
            if (entry.getAbundance() == Isotope.Abundance.AMOUNT) {
                naturalIsotopes.add(entry);
            }
        }

        BigDecimal max = new BigDecimal(0);
        for (Isotope entry : naturalIsotopes) {
            max = max.add(new BigDecimal(entry.getAbundancePercent()));
        }

        Random random = ThreadLocalRandom.current();
        BigDecimal randomPercent = new BigDecimal(random.nextDouble()).multiply(max);

        BigDecimal currentPercent = new BigDecimal(0);

        for (Isotope entry : naturalIsotopes) {
            currentPercent = currentPercent.add(new BigDecimal(entry.getAbundancePercent()));
            if (randomPercent.compareTo(currentPercent) <= 0) {
                isotope = entry;
                break;
            }
        }

        return isotope;
    }



    private static TimeAmount y(float year) {
        return new TimeAmount(TimeAmount.Unit.YEAR, year);
    }

    private static TimeAmount y(float year, int tenPower) {
        float years = year;
        for (int g = 0; g < tenPower; g++) years = years * 10;
        return new TimeAmount(TimeAmount.Unit.YEAR, years);
    }

    private static TimeAmount d(float day) {
        return new TimeAmount(TimeAmount.Unit.DAY, day);
    }

    private static TimeAmount h(float hour) {
        return new TimeAmount(TimeAmount.Unit.HOUR, hour);
    }

    private static TimeAmount min(float minute) {
        return new TimeAmount(TimeAmount.Unit.MINUTE, minute);
    }

    private static TimeAmount s(float second) {
        return new TimeAmount(TimeAmount.Unit.SECOND, second);
    }
}
