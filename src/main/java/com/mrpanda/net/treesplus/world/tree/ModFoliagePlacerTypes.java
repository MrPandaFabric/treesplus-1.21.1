package com.mrpanda.net.treesplus.world.tree;

import com.mrpanda.net.treesplus.Treesplus;
import com.mrpanda.net.treesplus.world.tree.foliageplacer.PalmFoliagePlacer;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.foliage.FoliagePlacerType;

public class ModFoliagePlacerTypes {
    public static final FoliagePlacerType<PalmFoliagePlacer> PALM_FOLIAGE_PLACER =
            new FoliagePlacerType<>(PalmFoliagePlacer.CODEC);

    public static void register() {
        Registry.register(Registries.FOLIAGE_PLACER_TYPE,
                Identifier.of(Treesplus.MOD_ID, "palm_foliage_placer"),
                PALM_FOLIAGE_PLACER);
    }
}
