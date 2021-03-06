package io.github.vampirestudios.molecularcraft.container;

import io.github.cottonmc.cotton.gui.SyncedGuiDescription;
import io.github.cottonmc.cotton.gui.widget.*;
import io.github.vampirestudios.molecularcraft.container.widget.WEnergyBar;
import io.github.vampirestudios.molecularcraft.items.AtomItem;
import io.github.vampirestudios.molecularcraft.items.MoleculeStackItem;
import io.github.vampirestudios.molecularcraft.items.StackedAtomItem;
import io.github.vampirestudios.molecularcraft.items.StackedMoleculeStackItem;
import io.github.vampirestudios.molecularcraft.registries.ModContainers;
import io.github.vampirestudios.molecularcraft.registries.ModItems;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.util.math.BlockPos;

public class AssemblerScreenHandler extends SyncedGuiDescription {

    public AssemblerScreenHandler(int synchronizationID, PlayerInventory linkedPlayerInventory, BlockPos pos, ScreenHandlerContext context) {
        super(ModContainers.ASSEMBLER_SCREEN_HANDLER, synchronizationID, linkedPlayerInventory, getBlockInventory(context, 20), getBlockPropertyDelegate(context, 2));

        WGridPanel root = new WGridPanel(1);
        setRootPanel(root);
        root.setSize(160, 160);

        WItemSlot itemSlot = new WItemSlot(blockInventory, 0, 9,2, false)
                .setFilter(itemStack -> itemStack.getItem() instanceof AtomItem
                        || itemStack.getItem() instanceof MoleculeStackItem
                        || itemStack.getItem() instanceof StackedAtomItem
                        || itemStack.getItem() instanceof StackedMoleculeStackItem);
        root.add(itemSlot, 0, 12);
        WItemSlot itemSlot1 = new WItemSlot(blockInventory, 18, 1,1, false)
                .setFilter(itemStack -> {
                    boolean bol = true;

                    if (itemStack.getTag() == null) bol = false;
                    else {
                        CompoundTag tag = itemStack.getTag();
                        if (tag.get("inputs") == null) bol = false;
                    }

                    return itemStack.getCount() < 2 && itemStack.getItem() == ModItems.RECIPE && bol;
                });
        root.add(itemSlot1, 0, 51);
        WItemSlot itemSlot2 = new WItemSlot(blockInventory, 19, 1,1, false).setInsertingAllowed(false);
        root.add(itemSlot2, 144, 51);
        WBar energyBar = new WEnergyBar(0,1);
        root.add(energyBar, 32, 52, 99, 16);

        root.add(this.createPlayerInventoryPanel(), 0, 72);

        root.validate(this);
    }
}
