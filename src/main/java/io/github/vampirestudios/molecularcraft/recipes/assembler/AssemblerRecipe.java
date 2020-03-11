package io.github.vampirestudios.molecularcraft.recipes.assembler;

import net.minecraft.item.ItemStack;

import java.util.List;

public class AssemblerRecipe {
    private List<ItemStack> inputs;
    private ItemStack output;

    public AssemblerRecipe(List<ItemStack> inputs, ItemStack output) {
        this.inputs = inputs;
        this.output = output;
    }

    public ItemStack getOutput() {
        return output;
    }

    public List<ItemStack> getInputs() {
        return inputs;
    }
}
