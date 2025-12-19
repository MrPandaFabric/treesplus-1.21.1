package com.mrpanda.net.treesplus.entity;

import com.mrpanda.net.treesplus.Treesplus;
import com.mrpanda.net.treesplus.block.ModBlocks;
import com.mrpanda.net.treesplus.item.ModItems;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import com.terraformersmc.terraform.boat.api.TerraformBoatType;
import com.terraformersmc.terraform.boat.api.TerraformBoatTypeRegistry;

public class ModBoats {

    public static final Identifier PALM_BOAT_ID = Identifier.of(Treesplus.MOD_ID, "palm_boat");
    public static final Identifier PALM_CHEST_BOAT_ID = Identifier.of(Treesplus.MOD_ID, "palm_chest_boat");

    public static final RegistryKey<TerraformBoatType> PALM_BOAT_KEY = TerraformBoatTypeRegistry.createKey(PALM_BOAT_ID);

    public static void registerBoats() {
        TerraformBoatType palmBoat = new TerraformBoatType.Builder()
                .item(ModItems.PALM_BOAT)
                .chestItem(ModItems.PALM_CHEST_BOAT)
                .planks(ModBlocks.PALM_PLANKS.asItem())
                .build();

        Registry.register(TerraformBoatTypeRegistry.INSTANCE, PALM_BOAT_KEY, palmBoat);
    }
}
