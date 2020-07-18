package io.github.vampirestudios.molecularcraft.blocks;

import io.github.vampirestudios.molecularcraft.blocks.entities.DisassemblerBlockEntity;
import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.fabricmc.fabric.api.container.ContainerProviderRegistry;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.context.LootContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Property;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.*;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class DisassemblerBlock extends BaseMachineBlock {

    public DisassemblerBlock() {
        super(FabricBlockSettings.of(Material.METAL).build());
    }

    @Override
    public BlockEntity createBlockEntity(BlockView blockView) {
        return new DisassemblerBlockEntity();
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (world.isClient) return ActionResult.PASS;

        BlockEntity be = world.getBlockEntity(pos);
        if (be instanceof DisassemblerBlockEntity) {
            ContainerProviderRegistry.INSTANCE.openContainer(new Identifier("molecularcraft:disassembler"), player, (packetByteBuf -> packetByteBuf.writeBlockPos(pos)));
        }


        return ActionResult.SUCCESS;
    }

    @Override
    public void onStacksDropped(BlockState state, World world, BlockPos pos, ItemStack stack) {
        super.onStacksDropped(state, world, pos, stack);
    }

//    @Override
//    public void onBlockRemoved(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
//        if (state.getBlock() != newState.getBlock()) {
//            DisassemblerBlockEntity blockEntity = (DisassemblerBlockEntity) world.getBlockEntity(pos);
//
//            for (int i = 0; i < blockEntity.getInvSize(); ++i) {
//                ItemStack stackB = blockEntity.getInvStack(i).copy();
//
//                do {
//                    int intA = Math.min(stackB.getCount(), stackB.getMaxCount());
//
//                    ItemStack stackC = stackB.copy();
//
//                    stackC.setCount(intA);
//                    stackB.decrement(intA);
//
//                    ItemScatterer.spawn(world, pos, DefaultedList.copyOf(ItemStack.EMPTY, stackC.copy()));
//                } while (!stackB.isEmpty());
//            }
//
//            super.onBlockRemoved(state, world, pos, newState, moved);
//        }
//    }
}
