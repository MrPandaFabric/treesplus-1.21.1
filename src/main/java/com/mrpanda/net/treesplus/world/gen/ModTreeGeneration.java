package com.mrpanda.net.treesplus.world.gen;

import com.mrpanda.net.treesplus.world.ModPlacedFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;

public class ModTreeGeneration {
    public static void generateTrees() {
       BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.JUNGLE,BiomeKeys.SPARSE_JUNGLE,BiomeKeys.BAMBOO_JUNGLE),
              GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.COCONUT_PALM_JUNGLE_PLACED_KEY);

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.BEACH),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.COCONUT_PALM_BEACH_PLACED_KEY);
    }
}