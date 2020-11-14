package io.github.vampirestudios.molecularcraft.container.widget;

import io.github.cottonmc.cotton.gui.client.BackgroundPainter;
import io.github.vampirestudios.molecularcraft.MolecularCraft;
import net.minecraft.util.Identifier;

public class BackgroundPainters {
    public static final BackgroundPainter TEXT = BackgroundPainter.createNinePatch(new Identifier(MolecularCraft.MODID, "textures/widget/panel/text.png"));
}
