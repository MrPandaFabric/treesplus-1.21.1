package com.mrpanda.net.treesplus.world.tree;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
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

        // 1. MASSIVER KERN (Zentrum füllen)
        // Y=0 bis Y=1 (Nur aufwärts und bündig, nichts hängt unter den Stamm-Endpunkt)
        for (int y = 0; y <= 1; y++) {
            for (int x = -1; x <= 1; x++) {
                for (int z = -1; z <= 1; z++) {
                    this.place(world, placer, random, config, center.add(x, y, z));
                }
            }
        }

        // 2. DIE ZWEI HAUPT-SCHICHTEN
        for (Direction dir : Direction.Type.HORIZONTAL) {
            Direction diag = dir.rotateYClockwise();

            // EBENE 1: DIE KRONE (Steil nach oben)
            // Schießt 3 hoch, knickt spät ab
            generateAdvancedFrond(world, placer, random, config, center, dir, null, radius - 1, 3, 4);

            // EBENE 2: DIE SPANNWEITE (Gerade zur Seite & Leicht höher)
            // Startet 1 Block höher, geht weit geradeaus (downStart 5)
            generateAdvancedFrond(world, placer, random, config, center.up(), dir, null, radius + 1, 0, 5);

            // Diagonale Füllung (für die Sternform)
            generateAdvancedFrond(world, placer, random, config, center.up(), dir, diag, radius, 0, 4);
        }
    }

    private void generateAdvancedFrond(TestableWorld world, BlockPlacer placer, Random random, TreeFeatureConfig config, BlockPos center, Direction dir1, Direction dir2, int length, int upSteps, int downStart) {
        BlockPos.Mutable mutable = center.mutableCopy();

        for (int i = 1; i <= length; i++) {
            mutable.move(dir1);
            if (dir2 != null) mutable.move(dir2);

            if (i <= upSteps) {
                mutable.move(Direction.UP);
            } else if (downStart > 0 && i >= downStart) {
                mutable.move(Direction.DOWN);
            }

            this.place(world, placer, random, config, mutable);
            this.place(world, placer, random, config, mutable.down());
        }
    }

    private void place(TestableWorld world, BlockPlacer placer, Random random, TreeFeatureConfig config, BlockPos pos) {
        if (world.testBlockState(pos, state -> state.isAir() || state.isOf(net.minecraft.block.Blocks.WATER))) {
            placer.placeBlock(pos, config.foliageProvider.get(random, pos));
        }
    }

    @Override
    public int getRandomHeight(Random random, int trunkHeight, TreeFeatureConfig config) {
        return 0;
    }

    @Override
    protected boolean isInvalidForLeaves(Random random, int dx, int y, int dz, int radius, boolean giantTrunk) {
        return false;
    }
}
