package io.github.vampirestudios.molecularcraft.registries;

import io.github.vampirestudios.molecularcraft.blocks.entities.AssemblerBlockEntity;
import io.github.vampirestudios.molecularcraft.blocks.entities.DisassemblerBlockEntity;
import io.github.vampirestudios.molecularcraft.blocks.entities.MicroscopeBlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.registry.Registry;

public class ModBlockEntities {

    public static BlockEntityType<DisassemblerBlockEntity> disassemblerBlockEntityBlockEntityType;
    public static BlockEntityType<MicroscopeBlockEntity> microscopeBlockEntityBlockEntityType;
    public static BlockEntityType<AssemblerBlockEntity> assemblerBlockEntityBlockEntityType;

    public static void init() {
//        disassemblerBlockEntityBlockEntityType = Registry.register(Registry.BLOCK_ENTITY_TYPE,
//                "molecularcraft:disassembler", BlockEntityType.Builder.create(DisassemblerBlockEntity::new, ModBlocks.DISASSEMBLER).build(null));
//        microscopeBlockEntityBlockEntityType = Registry.register(Registry.BLOCK_ENTITY_TYPE,
//                "molecularcraft:microscope", BlockEntityType.Builder.create(MicroscopeBlockEntity::new, ModBlocks.MICROSCOPE).build(null));
        assemblerBlockEntityBlockEntityType = Registry.register(Registry.BLOCK_ENTITY_TYPE,
                "molecularcraft:assembler", BlockEntityType.Builder.create(AssemblerBlockEntity::new, ModBlocks.ASSEMBLER).build(null));
    }
}
