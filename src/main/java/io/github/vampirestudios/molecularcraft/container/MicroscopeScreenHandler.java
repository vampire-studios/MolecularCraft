package io.github.vampirestudios.molecularcraft.container;

import io.github.cottonmc.cotton.gui.SyncedGuiDescription;
import io.github.cottonmc.cotton.gui.widget.*;
import io.github.cottonmc.cotton.gui.widget.data.HorizontalAlignment;
import io.github.cottonmc.cotton.gui.widget.data.VerticalAlignment;
import io.github.vampirestudios.molecularcraft.MolecularCraft;
import io.github.vampirestudios.molecularcraft.blocks.entities.MicroscopeBlockEntity;
import io.github.vampirestudios.molecularcraft.container.widget.WEnergyBar;
import io.github.vampirestudios.molecularcraft.container.widget.WTextPanel;
import io.github.vampirestudios.molecularcraft.enums.Atoms;
import io.github.vampirestudios.molecularcraft.items.MoleculeStackItem;
import io.github.vampirestudios.molecularcraft.items.RecipeItem;
import io.github.vampirestudios.molecularcraft.items.StackedAtomItem;
import io.github.vampirestudios.molecularcraft.items.StackedMoleculeStackItem;
import io.github.vampirestudios.molecularcraft.molecules.MoleculeStack;
import io.github.vampirestudios.molecularcraft.recipes.AssemblerRecipeManager;
import io.github.vampirestudios.molecularcraft.recipes.assembler.AssemblerRecipe;
import io.github.vampirestudios.molecularcraft.registries.ItemMoleculesDataManager;
import io.github.vampirestudios.molecularcraft.registries.ModContainers;
import io.github.vampirestudios.molecularcraft.registries.ModItems;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.text.LiteralText;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;

public class MicroscopeScreenHandler extends SyncedGuiDescription {

    WText dynamicText;
    MicroscopeBlockEntity blockEntity;
    WButton wButton;
    WText errorText;

    public MicroscopeScreenHandler(int synchronizationID, PlayerInventory linkedPlayerInventory, BlockPos pos, ScreenHandlerContext context) {
        super(ModContainers.MICROSCOPE_SCREEN_HANDLER, synchronizationID, linkedPlayerInventory, getBlockInventory(context, 3), getBlockPropertyDelegate(context, 2));
        blockEntity = (MicroscopeBlockEntity) this.world.getBlockEntity(pos);

        WGridPanel root = new WGridPanel();
        setRootPanel(root);
        root.setSize(160, 200);

        WItemSlot itemSlot = new WItemSlot(blockInventory, 0, 1, 1, false);
        root.add(itemSlot, 0, 1);

        WItemSlot paperSlot = new WItemSlot(blockInventory, 1, 1, 1, false)
                .setFilter((itemStack) -> itemStack.getItem() == Items.PAPER);
        root.add(paperSlot, 0, 3);

        WItemSlot resultSlot = new WItemSlot(blockInventory, 2, 1, 1, false)
                .setFilter((itemStack -> itemStack.getItem() == ModItems.RECIPE))
                .setInsertingAllowed(false);
        resultSlot.addChangeListener((slot, inventory, var3, stack) -> this.sendContentUpdates());
        root.add(resultSlot, 2, 2);

        WBar energyBar = new WEnergyBar(0, 1);
        root.add(energyBar, 0, 4, 4, 1);

        WGridPanel textPanel = new WTextPanel();
        root.add(textPanel, 4, 1, 5, 3);
        dynamicText = new WText(new LiteralText(""))
                .setHorizontalAlignment(HorizontalAlignment.CENTER)
                .setVerticalAlignment(VerticalAlignment.CENTER);
        textPanel.add(dynamicText, 0, 0, 5, 3);

        wButton = new WButton(new TranslatableText("text.molecularcraft.gui.create_recipe")).setOnClick(this::createRecipe);
        root.add(wButton, 4, 4, 5, 1);

        errorText = new WText(new LiteralText(""))
                .setColor(0xf54242).setDarkmodeColor(0xf54242)
                .setVerticalAlignment(VerticalAlignment.CENTER);
        root.add(errorText, 0, 5, 9, 2);

        root.add(this.createPlayerInventoryPanel(), 0, 7);

        root.validate(this);
    }

    private void createRecipe() {
        ItemStack inputStack = this.getStacks().get(0);
        String inputId = Registry.ITEM.getId(inputStack.getItem()).toString();
        ItemStack paperStack = this.getStacks().get(1);
        ItemStack resultStack = this.getStacks().get(2);
        if (resultStack.getItem() != Items.AIR) {
                errorText.setText(new TranslatableText("text.molecularcraft.gui.microscope.error.full"));
        } else {
            errorText.setText(new LiteralText(""));
            if (paperStack.getItem() == Items.AIR) {
                errorText.setText(new TranslatableText("text.molecularcraft.gui.microscope.error.paper"));
            } else {
                errorText.setText(new LiteralText(""));
                if (!ItemMoleculesDataManager.REGISTRY.containsKey(inputId)
                        && !(inputStack.getItem() instanceof MoleculeStackItem)
                        && !(inputStack.getItem() instanceof StackedAtomItem)
                        && !(inputStack.getItem() instanceof StackedMoleculeStackItem)) {
                    errorText.setText(new TranslatableText("text.molecularcraft.gui.microscope.error.no_formula"));
                } else {
                    errorText.setText(new LiteralText(""));
                    AssemblerRecipe recipe;
                    if (inputStack.getItem() instanceof MoleculeStackItem) {
                        MoleculeStack moleculeStack = ((MoleculeStackItem)inputStack.getItem()).getMoleculeStack();
                        recipe = AssemblerRecipeManager.createRecipe(inputStack.getItem(), moleculeStack.getMolecules());
                    } else if (inputStack.getItem() instanceof StackedAtomItem) {
                        StackedAtomItem stackedAtomItem = (StackedAtomItem) inputStack.getItem();
                        Atoms atom = stackedAtomItem.getAtom();
                        recipe = AssemblerRecipeManager.createRecipe(stackedAtomItem, new ItemStack(atom.getItem(), 64));
                    } else if (inputStack.getItem() instanceof StackedMoleculeStackItem) {
                        StackedMoleculeStackItem stackedMoleculeStackItem = (StackedMoleculeStackItem) inputStack.getItem();
                        MoleculeStack moleculeStack = stackedMoleculeStackItem.getMoleculeStack();
                        recipe = AssemblerRecipeManager.createRecipe(stackedMoleculeStackItem, new ItemStack(moleculeStack.getItem(), 64));
                    } else {
                        recipe = AssemblerRecipeManager.createRecipe(inputStack.getItem(), ItemMoleculesDataManager.REGISTRY.get(inputId));
                    }
                    ItemStack recipeItem = new ItemStack(ModItems.RECIPE);
                    RecipeItem.setRecipeComponent(recipeItem, recipe);
                    MolecularCraft.sendSlotUpdatePacket(this.syncId, 2, recipeItem);
                    paperStack.decrement(1);
                    MolecularCraft.sendSlotUpdatePacket(this.syncId, 1, paperStack);
                }
            }
        }

    }
}
