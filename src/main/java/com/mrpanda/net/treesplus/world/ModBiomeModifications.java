package com.mrpanda.net.treesplus.world;

import net.fabricmc.fabric.api.biome.v1.BiomeModificationContext;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.biome.v1.ModificationPhase;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;

public class ModBiomeModifications {

    public static void registerRemovals() {
        BiomeModifications.create(Identifier.of("treesplus", "remove_jungle_features"))
                .add(ModificationPhase.REMOVALS,
                        BiomeSelectors.includeByKey(
                                BiomeKeys.BAMBOO_JUNGLE,
                                BiomeKeys.JUNGLE,
                                BiomeKeys.SPARSE_JUNGLE
                        ),
                        context -> {
                            remove(context, "trees_jungle");
                            remove(context, "jungle_bush");
                            remove(context, "bamboo_vegetation");
                            remove(context, "trees_sparse_jungle");
                        }
                );
    }

    private static void remove(BiomeModificationContext context, String path) {
        context.getGenerationSettings().removeFeature(
                GenerationStep.Feature.VEGETAL_DECORATION,
                RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.ofVanilla(path))
        );
    }
}
