package io.github.vampirestudios.molecularcraft.container;

import io.github.vampirestudios.molecularcraft.blocks.entities.AssemblerBlockEntity;
import io.github.vampirestudios.molecularcraft.blocks.entities.DisassemblerBlockEntity;
import io.github.vampirestudios.molecularcraft.registries.ModItems;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.text.LiteralText;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import spinnery.common.BaseContainerScreen;
import spinnery.widget.*;
import spinnery.widget.api.Position;
import spinnery.widget.api.Size;
import team.reborn.energy.EnergySide;

public class AssemblerScreen extends BaseContainerScreen<AssemblerContainer> {
    WStaticText energyText;
    AssemblerBlockEntity blockEntity;

    public AssemblerScreen(AssemblerContainer linkedContainer, PlayerEntity player, BlockPos pos) {
        super(new LiteralText(""), linkedContainer, player);

        blockEntity = (AssemblerBlockEntity) player.world.getBlockEntity(pos);

        WInterface mainInterface = getInterface();

        WPanel panel = mainInterface.createChild(WPanel.class, Position.of(0, 0, 0), Size.of(170, 180)).setInterface(mainInterface);

        panel.setLabel(new LiteralText("Assembler"));

        panel.setOnAlign(WAbstractWidget::center);

        panel.center();

        mainInterface.add(panel);

        WSlot.addPlayerInventory(Position.of(panel, ((panel.getWidth()) / 2) - (int) (18 * 4.5f), 90, 1), Size.of(18, 18), mainInterface);

        WSlot.addArray(Position.of(panel,4, 65, 1), Size.of(18, 18), mainInterface, 18, 1, 1, 1);
        WSlot.addArray(Position.of(panel,148, 65, 1), Size.of(18, 18), mainInterface, 19, 1, 1, 1);

        WSlot.addArray(Position.of(panel, 4, 22, 1), Size.of(18, 18), mainInterface, 0, 1, 9, 2);


        for (WAbstractWidget widget : mainInterface.getWidgets()) {
            if (widget instanceof WSlot && ((WSlot) widget).getInventoryNumber() == 1) {
                if (((WSlot) widget).getSlotNumber() < 18) {
                    ((WSlot) widget).setOverrideMaximumCount(true);
                    ((WSlot) widget).setMaximumCount(1024);
                }
                if (((WSlot) widget).getSlotNumber() == 18) {
                    ((WSlot) widget).setPreviewStack(new ItemStack(ModItems.RECIPE));
                }
            }
        }
    }

    @Override
    public void tick() {
//        double max = this.blockEntity.getMaxStoredPower();
//        double energy = this.blockEntity.getStored(EnergySide.UNKNOWN);
//        LiteralText energyT = new LiteralText("Energy: " + energy + "/" + max);
//        energyText.setText(energyT);
        ItemStack recipe = blockEntity.inventory.getInvStack(18);
        if (recipe.getItem() == ModItems.RECIPE) {
            CompoundTag tag = recipe.getTag();
            ListTag list = tag.getList("inputs", 10);
            for (int i = 0; i < list.size() ; i++) {
                CompoundTag tag1 = list.getCompound(i);
                int amount = tag1.getInt("count");
                String id = tag1.getString("id");
                Item item = Registry.ITEM.get(new Identifier(id));
                ItemStack itemStack = new ItemStack(item, amount);
                for (WAbstractWidget widget : getInterface().getWidgets()) {
                    if (widget instanceof WSlot && ((WSlot) widget).getInventoryNumber() == 1) {
                        if (((WSlot) widget).getSlotNumber() == i) {
                            ((WSlot) widget).setPreviewStack(itemStack);
                        }
                    }
                }
            }
        } else {
            for (WAbstractWidget widget : getInterface().getWidgets()) {
                if (widget instanceof WSlot && ((WSlot) widget).getInventoryNumber() == 1) {
                    if (((WSlot) widget).getSlotNumber() < 18) {
                        ((WSlot) widget).setPreviewStack(new ItemStack(Items.AIR));
                    }
                }
            }
        }
        super.tick();
    }
}
