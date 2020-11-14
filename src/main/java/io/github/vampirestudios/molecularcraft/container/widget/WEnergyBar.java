package io.github.vampirestudios.molecularcraft.container.widget;

import io.github.cottonmc.cotton.gui.widget.WBar;
import io.github.vampirestudios.molecularcraft.MolecularCraft;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;

public class WEnergyBar extends WBar {
    private static final Identifier BACKGROUND = new Identifier(MolecularCraft.MODID, "textures/widget/energy_bar_bg.png");
    private static final Identifier BAR = new Identifier(MolecularCraft.MODID, "textures/widget/energy_bar.png");

    public WEnergyBar(int field, int maxfield) {
        super(BACKGROUND, BAR, field, maxfield, WBar.Direction.RIGHT);
    }

    @Override
    public void renderTooltip(MatrixStack matrices, int x, int y, int tX, int tY) {
        this.withTooltip(new TranslatableText("text.molecularcraft.gui.energy",
                this.getProperties().get(this.field), this.getProperties().get(this.max)));
        super.renderTooltip(matrices, x, y, tX, tY);
    }
}
