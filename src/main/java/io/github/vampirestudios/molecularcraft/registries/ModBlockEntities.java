package io.github.vampirestudios.molecularcraft.registries;

import io.github.vampirestudios.molecularcraft.blocks.entities.AtomicDisassemblerBlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.registry.Registry;

public class ModBlockEntities {

    public static BlockEntityType<AtomicDisassemblerBlockEntity> atomicDisassemblerBlockEntityBlockEntityType;

    public static void init() {
        atomicDisassemblerBlockEntityBlockEntityType = Registry.register(Registry.BLOCK_ENTITY,
                "molecularcraft:atomic_disassembler", BlockEntityType.Builder.create(AtomicDisassemblerBlockEntity::new, ModBlocks.ATOMIC_DISASSEMBLER).build(null));
    }
}
