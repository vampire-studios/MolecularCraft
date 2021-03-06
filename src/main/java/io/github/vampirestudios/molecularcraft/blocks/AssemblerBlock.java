package io.github.vampirestudios.molecularcraft.blocks;

import io.github.vampirestudios.molecularcraft.blocks.entities.AssemblerBlockEntity;
import io.github.vampirestudios.molecularcraft.blocks.entities.MicroscopeBlockEntity;
import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.fabricmc.fabric.api.container.ContainerProviderRegistry;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.fabricmc.fabric.impl.container.ContainerProviderImpl;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.SidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.*;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

public class AssemblerBlock extends BaseMachineBlock implements InventoryProvider {

    public AssemblerBlock() {
        super(AbstractBlock.Settings.of(Material.METAL));
    }

    @Override
    public BlockEntity createBlockEntity(BlockView blockView) {
        return new AssemblerBlockEntity();
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (world.isClient) return ActionResult.PASS;

        BlockEntity be = world.getBlockEntity(pos);
        if (be instanceof AssemblerBlockEntity) {
            player.openHandledScreen(state.createScreenHandlerFactory(world, pos));
        }


        return ActionResult.SUCCESS;
    }

    @Override
    public NamedScreenHandlerFactory createScreenHandlerFactory(BlockState state, World world, BlockPos pos) {
        return (ExtendedScreenHandlerFactory) world.getBlockEntity(pos);
    }

    @Override
    public void onStacksDropped(BlockState state, ServerWorld world, BlockPos pos, ItemStack stack) {
        super.onStacksDropped(state, world, pos, stack);
    }

    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (state.getBlock() != newState.getBlock()) {
            AssemblerBlockEntity blockEntity = (AssemblerBlockEntity) world.getBlockEntity(pos);

            for (int i = 0; i < blockEntity.getInventory(state, world, pos).size(); ++i) {
                ItemStack stackB = blockEntity.getInventory(state, world, pos).getStack(i).copy();

                do {
                    int intA = Math.min(stackB.getCount(), stackB.getMaxCount());

                    ItemStack stackC = stackB.copy();

                    stackC.setCount(intA);
                    stackB.decrement(intA);

                    ItemScatterer.spawn(world, pos, DefaultedList.copyOf(ItemStack.EMPTY, stackC.copy()));
                } while (!stackB.isEmpty());
            }

            super.onStateReplaced(state, world, pos, newState, moved);
        }
    }

    @Override
    public SidedInventory getInventory(BlockState state, WorldAccess world, BlockPos pos) {
        BlockEntity e = world.getBlockEntity(pos);
        if (e instanceof AssemblerBlockEntity) {
            return ((AssemblerBlockEntity)e).getInventory(state, world, pos);
        }
        return null;
    }
}
