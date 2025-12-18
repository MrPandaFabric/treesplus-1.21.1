package com.mrpanda.net.treesplus.block.custom;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
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
        super.neighborUpdate(state, world, pos, sourceBlock, sourcePos, notify);
        BlockPos above = pos.up();
        if (world.isAir(above)) {
            dropCoconut(world, pos, state);
        }
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (!world.isClient) {
            dropCoconut(world, pos, state);
            return ActionResult.SUCCESS;
        }
        return ActionResult.CONSUME;
    }

    private void dropCoconut(World world, BlockPos pos, BlockState state) {
        FallingBlockEntity fallingBlockEntity = FallingBlockEntity.spawnFromBlock(world, pos, state);
        fallingBlockEntity.setHurtEntities(2.0f, 40);
        fallingBlockEntity.dropItem = true;
        world.removeBlock(pos, false);
    }
}
