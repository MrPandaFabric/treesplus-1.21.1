package com.mrpanda.net.treesplus;

import com.mrpanda.net.treesplus.block.ModBlocks;
import com.mrpanda.net.treesplus.entity.ModBoats;
import com.terraformersmc.terraform.boat.api.client.TerraformBoatClientHelper;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class TreesplusClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {


        TerraformBoatClientHelper.registerModelLayers(ModBoats.PALM_BOAT_ID, false);


        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.COCONUT_PALM_LEAVES, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.COCONUT, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.COCONUT_PALM_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PALM_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PALM_TRAPDOOR, RenderLayer.getCutout());

    }
}