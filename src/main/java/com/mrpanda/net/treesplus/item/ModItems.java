package com.mrpanda.net.treesplus.item;

import com.mrpanda.net.treesplus.Treesplus;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item HALF_COCONUT = registerItem("half_coconut",
            new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Treesplus.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Treesplus.LOGGER.info("Registering Mod Items for " + Treesplus.MOD_ID);


    }
}