package io.github.vampirestudios.molecularcraft.blocks;

import io.github.vampirestudios.molecularcraft.blocks.entities.DisassemblerBlockEntity;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.SidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.*;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

public class DisassemblerBlock extends BaseMachineBlock implements InventoryProvider{

    public DisassemblerBlock() {
        super(AbstractBlock.Settings.of(Material.METAL));
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
            player.openHandledScreen(state.createScreenHandlerFactory(world, pos));
        }


        return ActionResult.SUCCESS;
    }

    @Override
    public void onStacksDropped(BlockState state, ServerWorld world, BlockPos pos, ItemStack stack) {
        super.onStacksDropped(state, world, pos, stack);
    }

    @Override
    public SidedInventory getInventory(BlockState state, WorldAccess world, BlockPos pos) {
        BlockEntity be = world.getBlockEntity(pos);
        if (be instanceof DisassemblerBlockEntity) {
            return ((DisassemblerBlockEntity)be).getInventory(state,world,pos);
        }
        return null;
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
