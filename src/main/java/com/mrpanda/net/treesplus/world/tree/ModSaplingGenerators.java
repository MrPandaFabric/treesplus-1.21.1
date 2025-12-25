package com.mrpanda.net.treesplus.world.tree;


import com.mrpanda.net.treesplus.Treesplus;
import com.mrpanda.net.treesplus.world.ModConfiguredFeatures;
import net.minecraft.block.SaplingGenerator;

import java.util.Optional;

public class ModSaplingGenerators {
    public static final SaplingGenerator COCONUT_PALM = new SaplingGenerator(Treesplus.MOD_ID + ":coconut_palm",
            Optional.empty(), Optional.of(ModConfiguredFeatures.COCONUT_PALM_JUNGLE_KEY), Optional.empty());
}