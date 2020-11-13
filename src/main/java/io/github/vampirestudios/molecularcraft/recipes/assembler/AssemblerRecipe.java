package io.github.vampirestudios.molecularcraft.recipes.assembler;

import net.minecraft.item.ItemStack;

import java.util.List;

public class AssemblerRecipe {
    private final List<ItemStack> inputs;
    private final ItemStack output;

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
