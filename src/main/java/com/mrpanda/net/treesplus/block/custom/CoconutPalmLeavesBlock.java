package com.mrpanda.net.treesplus.block.custom;

import com.mrpanda.net.treesplus.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

public class CoconutPalmLeavesBlock extends Block {
    public static final IntProperty DISTANCE = Properties.DISTANCE_1_7;
    public static final BooleanProperty PERSISTENT = Properties.PERSISTENT;

    public CoconutPalmLeavesBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState()
                .with(DISTANCE, 7)
                .with(PERSISTENT, false));
    }

    @Override
    public boolean isTransparent(BlockState state, BlockView world, BlockPos pos) {
        return true;
    }

    @Override
    public int getOpacity(BlockState state, BlockView world, BlockPos pos) {
        return 1;
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(PERSISTENT, true).with(DISTANCE, 7);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(DISTANCE, PERSISTENT);
    }

    @Override
    public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
        if (!world.isClient && !state.get(PERSISTENT)) {
            int newDist = getDiagonalDistance(world, pos);
            if (newDist != state.get(DISTANCE)) {
                world.setBlockState(pos, state.with(DISTANCE, newDist), Block.NOTIFY_LISTENERS | 16);
            }
        }
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (state.get(PERSISTENT)) return;
        int distance = state.get(DISTANCE);

        if (distance >= 7) {
            dropStacks(state, world, pos);
            world.removeBlock(pos, false);
        } else if (distance == 1 && random.nextInt(30) == 0) {
            BlockPos below = pos.down();
            if (world.isAir(below)) {
                world.setBlockState(below, ModBlocks.COCONUT.getDefaultState());
            }
        }
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if (!state.get(PERSISTENT)) {
            world.scheduleBlockTick(pos, this, 1 + world.getRandom().nextInt(3));
        }
        return state;
    }

    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (!state.get(PERSISTENT)) {
            int i = getDiagonalDistance(world, pos);
            if (i != state.get(DISTANCE)) {
                world.setBlockState(pos, state.with(DISTANCE, i), Block.NOTIFY_LISTENERS | 16);
            }
        }
    }

    public static int getDiagonalDistance(WorldAccess world, BlockPos pos) {
        for (Direction dir : Direction.values()) {
            if (world.getBlockState(pos.offset(dir)).isIn(BlockTags.LOGS)) return 1;
        }

        int minDistance = 7;
        BlockPos.Mutable mutable = new BlockPos.Mutable();
        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                for (int z = -1; z <= 1; z++) {
                    if (x == 0 && y == 0 && z == 0) continue;
                    mutable.set(pos.getX() + x, pos.getY() + y, pos.getZ() + z);
                    BlockState neighbor = world.getBlockState(mutable);
                    if (neighbor.isIn(BlockTags.LOGS)) return 1;
                    if (neighbor.contains(DISTANCE)) {
                        int d = neighbor.get(DISTANCE);
                        if (d < minDistance) minDistance = d + 1;
                    }
                    if (minDistance == 2) break;
                }
                if (minDistance == 2) break;
            }
            if (minDistance == 2) break;
        }
        return minDistance;
    }
}
