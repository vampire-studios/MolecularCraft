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

    public enum BaseMaterials implements MoleculeAmountUnit {
        WOOD(128),
        STONE(2);

        private final int amount;

        BaseMaterials(int amount) {
            this.amount = amount;
        }

        @Override
        public int getAmount() {
            return this.amount;
        }
    }

    public static class MoleculeAmount {
        private int amount;
        private MoleculeAmountUnit moleculeAmountUnit;

        public MoleculeAmount(int amount, MoleculeAmountUnit moleculeAmountUnit) {
            this.amount = amount;
            this.moleculeAmountUnit = moleculeAmountUnit;
        }

        public MoleculeAmount(MoleculeAmountUnit moleculeAmountUnit) {
            this.amount = 1;
            this.moleculeAmountUnit = moleculeAmountUnit;
        }

        public int getAmount() {
            return amount * moleculeAmountUnit.getAmount();
        }
    }

}
