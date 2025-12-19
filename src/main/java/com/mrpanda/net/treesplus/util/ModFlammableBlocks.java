package com.mrpanda.net.treesplus.util;

import com.mrpanda.net.treesplus.block.ModBlocks;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;

public class ModFlammableBlocks {

    public static void registerFlammableBlocks() {

        StrippableBlockRegistry.register(ModBlocks.PALM_LOG, ModBlocks.STRIPPED_PALM_LOG);
        StrippableBlockRegistry.register(ModBlocks.PALM_WOOD, ModBlocks.STRIPPED_PALM_WOOD);

        FlammableBlockRegistry instance = FlammableBlockRegistry.getDefaultInstance();

        instance.add(ModBlocks.PALM_LOG, 5, 5);
        instance.add(ModBlocks.PALM_WOOD, 5, 5);
        instance.add(ModBlocks.STRIPPED_PALM_LOG, 5, 5);
        instance.add(ModBlocks.STRIPPED_PALM_WOOD, 5, 5);

        instance.add(ModBlocks.PALM_PLANKS, 5, 20);
        instance.add(ModBlocks.COCONUT_PALM_LEAVES, 30, 60);
    }
}
