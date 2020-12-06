package io.github.vampirestudios.molecularcraft.container.widget;

import io.github.cottonmc.cotton.gui.client.ScreenDrawing;
import io.github.cottonmc.cotton.gui.widget.WBar;
import io.github.vampirestudios.molecularcraft.MolecularCraft;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

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

    @Environment(EnvType.CLIENT)
    @Override
    public void paint(MatrixStack matrices, int x, int y, int mouseX, int mouseY) {
        if (this.bg != null) {
            ScreenDrawing.texturedRect(x, y, this.getWidth(), this.getHeight(), this.bg, -1);
        } else {
            ScreenDrawing.coloredRect(x, y, this.getWidth(), this.getHeight(), ScreenDrawing.colorAtOpacity(0, 0.25F));
        }

        float percent = (float)this.properties.get(this.field) / (float)this.properties.get(this.max);
        if (percent < 0.0F) {
            percent = 0.0F;
        }

        if (percent > 1.0F) {
            percent = 1.0F;
        }

        int barMax = this.getWidth();
        if (this.direction == WBar.Direction.DOWN || this.direction == WBar.Direction.UP) {
            barMax = this.getHeight();
        }

        percent = (float)((int)(percent * (float)barMax)) / (float)barMax;
        int barSize = (int)((float)barMax * percent);
        if (barSize > 0) {
            switch(this.direction) {
                case UP:
                    int top = y + this.getHeight();
                    top -= barSize;
                    if (this.bar != null) {
                        ScreenDrawing.texturedRect(x, top, this.getWidth(), barSize, this.bar.image, this.bar.u1, MathHelper.lerp(percent, this.bar.v2, this.bar.v1), this.bar.u2, this.bar.v2, -1);
                    } else {
                        ScreenDrawing.coloredRect(x, top, this.getWidth(), barSize, ScreenDrawing.colorAtOpacity(16777215, 0.5F));
                    }
                    break;
                case RIGHT:
                    if (this.bar != null) {
                        ScreenDrawing.texturedRect(x, y, barSize, this.getHeight(), this.bar.image, this.bar.u1, this.bar.v1, MathHelper.lerp(percent, this.bar.u1, this.bar.u2), this.bar.v2, -1);
                    } else {
                        ScreenDrawing.coloredRect(x, y, barSize, this.getHeight(), ScreenDrawing.colorAtOpacity(16777215, 0.5F));
                    }
                    break;
                case DOWN:
                    if (this.bar != null) {
                        ScreenDrawing.texturedRect(x, y, this.getWidth(), barSize, this.bar.image, this.bar.u1, this.bar.v1, this.bar.u2, MathHelper.lerp(percent, this.bar.v1, this.bar.v2), -1);
                    } else {
                        ScreenDrawing.coloredRect(x, y, this.getWidth(), barSize, ScreenDrawing.colorAtOpacity(16777215, 0.5F));
                    }
                    break;
                case LEFT:
                    int left = x + this.getWidth();
                    left -= barSize;
                    if (this.bar != null) {
                        ScreenDrawing.texturedRect(left, y, barSize, this.getHeight(), this.bar.image, MathHelper.lerp(percent, this.bar.u2, this.bar.u1), this.bar.v1, this.bar.u2, this.bar.v2, -1);
                    } else {
                        ScreenDrawing.coloredRect(left, y, barSize, this.getHeight(), ScreenDrawing.colorAtOpacity(16777215, 0.5F));
                    }
            }

        }
    }
}
