package com.mrpanda.net.treesplus.datagen;

import com.mrpanda.net.treesplus.block.ModBlocks;
import com.mrpanda.net.treesplus.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSingleton(ModBlocks.COCONUT_PALM_LEAVES, TexturedModel.LEAVES);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModBlocks.COCONUT.asItem(), Models.GENERATED);
        itemModelGenerator.register(ModItems.HALF_COCONUT, Models.GENERATED);
    }
}