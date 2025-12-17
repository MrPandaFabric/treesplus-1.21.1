package com.mrpanda.net.treesplus.block.custom;

import com.mrpanda.net.treesplus.block.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.LeavesBlock;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;

public class CoconutPalmLeavesBlock extends LeavesBlock {
    public CoconutPalmLeavesBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        super.randomTick(state, world, pos, random);

        if (!state.get(PERSISTENT) && random.nextInt(30) == 0) {
            BlockPos below = pos.down();
            if (world.isAir(below)) {
                world.setBlockState(below, ModBlocks.COCONUT.getDefaultState());
            }
        }
    }
}