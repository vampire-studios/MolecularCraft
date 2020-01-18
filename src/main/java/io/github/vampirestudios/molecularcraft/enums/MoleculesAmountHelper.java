package io.github.vampirestudios.molecularcraft.enums;

public class MoleculesAmountHelper {

    public enum MetalOres implements MoleculeAmountUnit {
        NUGGET(3),
        INGOT(27),
        BLOCK(243);

        private int amount;

        MetalOres(int amount) {
            this.amount = amount;
        }

        @Override
        public int getAmount() {
            return amount;
        }
    }

    public interface  MoleculeAmountUnit {

        int getAmount();
    }

    public static class MoleculeAmount {
        int amount;
        MoleculeAmountUnit moleculeAmountUnit;

        public MoleculeAmount(int amount, MoleculeAmountUnit moleculeAmountUnit) {
            this.amount = amount;
            this.moleculeAmountUnit = moleculeAmountUnit;
        }

        public int getAmount() {
            return amount * moleculeAmountUnit.getAmount();
        }
    }

}
