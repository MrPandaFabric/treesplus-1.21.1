package com.mrpanda.net.treesplus;

import com.mrpanda.net.treesplus.entity.ModBoats;
import com.terraformersmc.terraform.boat.api.client.TerraformBoatClientHelper;
import net.fabricmc.api.ClientModInitializer;

public class TreesplusClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {


        TerraformBoatClientHelper.registerModelLayers(ModBoats.PALM_BOAT_ID, false);

    }
}