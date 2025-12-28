package com.mrpanda.net.treesplus.world;

import com.mrpanda.net.treesplus.Treesplus;
import com.mrpanda.net.treesplus.block.ModBlocks;
import com.mrpanda.net.treesplus.world.tree.foliage.foliageplacer.PalmFoliagePlacer;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.blockpredicate.BlockPredicate;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.treedecorator.AttachedToLeavesTreeDecorator;
import net.minecraft.world.gen.trunk.BendingTrunkPlacer;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

import java.util.List;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> COCONUT_PALM_JUNGLE_KEY = registerKey("coconut_palm_jungle");
    public static final RegistryKey<ConfiguredFeature<?, ?>> COCONUT_PALM_BEACH_KEY = registerKey("coconut_palm_beach");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {

        AttachedToLeavesTreeDecorator coconutDecorator = new AttachedToLeavesTreeDecorator(
                0.25f,
                1,
                0,
                BlockStateProvider.of(ModBlocks.COCONUT),
                1,
                List.of(Direction.DOWN)
        );


        register(context, COCONUT_PALM_JUNGLE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.PALM_LOG),
                new StraightTrunkPlacer(9, 3, 1),
                BlockStateProvider.of(ModBlocks.COCONUT_PALM_LEAVES),
                new PalmFoliagePlacer(ConstantIntProvider.create(4), ConstantIntProvider.create(0)),
                new TwoLayersFeatureSize(1, 0, 1)
        ).decorators(List.of(coconutDecorator)).ignoreVines().build());

        register(context, COCONUT_PALM_BEACH_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.PALM_LOG),
                new BendingTrunkPlacer(5, 2, 1, 5, ConstantIntProvider.create(4)),
                BlockStateProvider.of(ModBlocks.COCONUT_PALM_LEAVES),
                new PalmFoliagePlacer(ConstantIntProvider.create(4), ConstantIntProvider.create(0)),
                new TwoLayersFeatureSize(1, 0, 1)
        ).decorators(List.of(coconutDecorator)).ignoreVines().dirtProvider(BlockStateProvider.of(Blocks.SAND)).build());
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(Treesplus.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
