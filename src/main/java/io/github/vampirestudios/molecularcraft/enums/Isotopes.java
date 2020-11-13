package io.github.vampirestudios.molecularcraft.enums;

import io.github.vampirestudios.molecularcraft.molecules.Isotope;

import java.util.HashMap;
import java.util.Map;

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
                new Isotope.Decay(Isotope.DecayMod.ELECTRON_CAPTURE, LITHIUM, 7),
                new Isotope.Decay(Isotope.DecayMod.GAMMA_RAY)
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
