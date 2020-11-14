package io.github.vampirestudios.molecularcraft.registries;

import io.github.vampirestudios.molecularcraft.blocks.AssemblerBlock;
import io.github.vampirestudios.molecularcraft.blocks.DisassemblerBlock;
import io.github.vampirestudios.molecularcraft.blocks.MicroscopeBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {

    public static Block DISASSEMBLER;
    public static Block MICROSCOPE;
    public static Block ASSEMBLER;

    public static void init() {
//        DISASSEMBLER = register("disassembler", new DisassemblerBlock());
        MICROSCOPE = register("microscope", new MicroscopeBlock());
        ASSEMBLER = register("assembler", new AssemblerBlock());
    }

    private static Block register(String name, Block block) {
        Registry.register(Registry.ITEM, new Identifier("molecularcraft", name), new BlockItem(block, new Item.Settings().group(ModItems.MACHINES)));
        return Registry.register(Registry.BLOCK, new Identifier("molecularcraft", name), block);
    }
}
