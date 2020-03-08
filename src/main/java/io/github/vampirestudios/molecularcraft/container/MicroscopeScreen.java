package io.github.vampirestudios.molecularcraft.container;

import io.github.vampirestudios.molecularcraft.blocks.entities.DisassemblerBlockEntity;
import io.github.vampirestudios.molecularcraft.blocks.entities.MicroscopeBlockEntity;
import io.github.vampirestudios.molecularcraft.molecules.MoleculeStack;
import io.github.vampirestudios.molecularcraft.registries.ItemMolecules;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.LiteralText;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import spinnery.common.BaseContainerScreen;
import spinnery.widget.*;
import spinnery.widget.api.Position;
import spinnery.widget.api.Size;
import team.reborn.energy.EnergySide;

public class MicroscopeScreen extends BaseContainerScreen<MicroscopeContainer> {
    WStaticText dynamicText;
    MicroscopeBlockEntity blockEntity;

    public MicroscopeScreen(MicroscopeContainer linkedContainer, PlayerEntity player, BlockPos pos) {
        super(new LiteralText(""), linkedContainer, player);

        blockEntity = (MicroscopeBlockEntity) player.world.getBlockEntity(pos);

        WInterface mainInterface = getInterface();

        WPanel panel = mainInterface.createChild(WPanel.class, Position.of(0, 0, 0), Size.of(170, 180)).setInterface(mainInterface);

        panel.setLabel(new LiteralText("Microscope"));

        panel.setOnAlign(WAbstractWidget::center);

        panel.center();

        mainInterface.add(panel);

        WSlot.addPlayerInventory(Position.of(panel, ((panel.getWidth()) / 2) - (int) (18 * 4.5f), 90, 1), Size.of(18, 18), mainInterface);

        dynamicText = panel.createChild(WStaticText.class, Position.of(panel, 30, 22, 1));
        dynamicText.setText("BaseText");
        panel.add(dynamicText);

        WSlot.addArray(Position.of(panel, 10, 22, 1), Size.of(18, 18), mainInterface, 0, 1, 1, 1);

        WSlot.addArray(Position.of(panel, 50, 50, 1), Size.of(18, 18), mainInterface, 1, 1, 1, 1);

        WSlot.addArray(Position.of(panel, 125, 50, 1), Size.of(18, 18), mainInterface, 2, 1, 1, 1);

        panel.createChild(WButton.class, Position.of(panel, 70, 50, 1), Size.of(50, 18)).setLabel("Create Recipe");
    }

    @Override
    public void tick() {
        ItemStack one = blockEntity.getInvStack(0);
        String oneId = Registry.ITEM.getId(one.getItem()).toString();
        if (ItemMolecules.registry.containsKey(oneId)) {
            ItemMolecules itemMolecule = ItemMolecules.registry.get(oneId);
            String string = "";
            for (MoleculeStack moleculeStack : itemMolecule.getList()) {
                string += moleculeStack.getAmount() + moleculeStack.getFormula() + " ";
            }
            dynamicText.setText(string);
        } else {
            dynamicText.setText(" ");
        }
        super.tick();
    }
}
