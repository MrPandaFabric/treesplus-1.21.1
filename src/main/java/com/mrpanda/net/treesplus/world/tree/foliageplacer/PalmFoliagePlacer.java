package com.mrpanda.net.treesplus.world.tree.foliageplacer;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.mrpanda.net.treesplus.world.tree.ModFoliagePlacerTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.foliage.FoliagePlacerType;

public class PalmFoliagePlacer extends FoliagePlacer {
    public static final MapCodec<PalmFoliagePlacer> CODEC = RecordCodecBuilder.mapCodec(instance ->
            fillFoliagePlacerFields(instance).apply(instance, PalmFoliagePlacer::new));

    public PalmFoliagePlacer(IntProvider radius, IntProvider offset) {
        super(radius, offset);
    }

    @Override
    protected FoliagePlacerType<?> getType() {
        return ModFoliagePlacerTypes.PALM_FOLIAGE_PLACER;
    }

    @Override
    protected void generate(TestableWorld world, BlockPlacer placer, Random random, TreeFeatureConfig config, int trunkHeight, TreeNode treeNode, int foliageHeight, int radius, int offset) {
        BlockPos center = treeNode.getCenter();


        this.place(world, placer, random, config, center.up());
        for (Direction dir : Direction.Type.HORIZONTAL) {
            this.place(world, placer, random, config, center.offset(dir));
        }

        for (Direction dir : Direction.Type.HORIZONTAL) {

            generateSecureFrond(world, placer, random, config, center, dir, null, 5);

            generateSecureFrond(world, placer, random, config, center, dir, dir.rotateYClockwise(), 4);
        }
    }

    private void generateSecureFrond(TestableWorld world, BlockPlacer placer, Random random, TreeFeatureConfig config, BlockPos center, Direction d1, Direction d2, int length) {
        BlockPos.Mutable mutable = center.mutableCopy();

        for (int i = 1; i <= length; i++) {
            mutable.move(d1);
            if (d2 != null) mutable.move(d2);

            if (i <= 2) mutable.move(Direction.UP);
            if (i >= 4) mutable.move(Direction.DOWN);

            this.place(world, placer, random, config, mutable);


            this.place(world, placer, random, config, mutable.down());
        }
    }

    private void place(TestableWorld world, BlockPlacer placer, Random random, TreeFeatureConfig config, BlockPos pos) {
        if (world.testBlockState(pos, state -> state.isAir() || state.isOf(net.minecraft.block.Blocks.WATER))) {

            placer.placeBlock(pos, config.foliageProvider.get(random, pos));
        }
    }

    @Override public int getRandomHeight(Random random, int trunkHeight, TreeFeatureConfig config) { return 0; }
    @Override protected boolean isInvalidForLeaves(Random random, int dx, int y, int dz, int radius, boolean giantTrunk) { return false; }
}
