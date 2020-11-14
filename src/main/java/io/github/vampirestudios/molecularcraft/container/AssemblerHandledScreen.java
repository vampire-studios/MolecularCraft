package io.github.vampirestudios.molecularcraft.container;

import io.github.cottonmc.cotton.gui.client.CottonInventoryScreen;
import io.github.cottonmc.cotton.gui.widget.WLabel;
import io.github.vampirestudios.molecularcraft.MolecularCraft;
import io.github.vampirestudios.molecularcraft.blocks.entities.AssemblerBlockEntity;
import io.github.vampirestudios.molecularcraft.registries.ModItems;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;

public class AssemblerHandledScreen extends CottonInventoryScreen<AssemblerScreenHandler> {

    public AssemblerHandledScreen(AssemblerScreenHandler linkedContainer, PlayerEntity player, Text title) {
        super(linkedContainer, player, title);
    }
}
