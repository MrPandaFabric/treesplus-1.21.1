package com.mrpanda.net.treesplus.item;

import com.mrpanda.net.treesplus.Treesplus;
import com.mrpanda.net.treesplus.entity.ModBoats;
import com.terraformersmc.terraform.boat.api.item.TerraformBoatItemHelper;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item HALF_COCONUT = registerItem("half_coconut",
            new Item(new Item.Settings().food(ModFoodComponents.HALF_COCONUT)));


    public static final Item PALM_BOAT = TerraformBoatItemHelper.registerBoatItem(ModBoats.PALM_BOAT_ID, ModBoats.PALM_BOAT_KEY, false);

    public static final Item PALM_CHEST_BOAT = TerraformBoatItemHelper.registerBoatItem(ModBoats.PALM_CHEST_BOAT_ID, ModBoats.PALM_BOAT_KEY, true);

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Treesplus.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Treesplus.LOGGER.info("Registering Mod Items for " + Treesplus.MOD_ID);


    }
}