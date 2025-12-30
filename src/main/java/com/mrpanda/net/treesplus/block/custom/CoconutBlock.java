package com.mrpanda.net.treesplus.block.custom;

import net.minecraft.block.*;
import net.minecraft.entity.FallingBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CoconutBlock extends Block {

    public CoconutBlock(AbstractBlock.Settings settings) {
        super(settings);
    }

    @Override
    protected void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify) {
        if (pos.up().equals(sourcePos) && world.isAir(pos.up()) && world.isAir(pos.down())) {
            dropCoconut(world, pos, state);
        }
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (!world.isClient && world.isAir(pos.down())) {
            dropCoconut(world, pos, state);
            return ActionResult.SUCCESS;
        }
        return ActionResult.PASS;
    }

    private void dropCoconut(World world, BlockPos pos, BlockState state) {
        FallingBlockEntity entity = FallingBlockEntity.spawnFromBlock(world, pos, state);
        entity.setHurtEntities(2.0f, 40);
        entity.dropItem = true;
        world.setBlockState(pos, Blocks.AIR.getDefaultState(), 3);
    }
}
