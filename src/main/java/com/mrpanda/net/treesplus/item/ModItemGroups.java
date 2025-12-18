package com.mrpanda.net.treesplus.item;

import com.mrpanda.net.treesplus.Treesplus;
import com.mrpanda.net.treesplus.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup TREESPLUS_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Treesplus.MOD_ID, "treesplus_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(Items.APPLE))
                    .displayName(Text.translatable("itemgroup.treesplus.treesplus_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.COCONUT.asItem());
                    }).build());

    public static final ItemGroup TREESPLUS_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Treesplus.MOD_ID, "treesplus_blocks"),
            FabricItemGroup.builder().icon(() -> new ItemStack(Blocks.OAK_SAPLING))
                    .displayName(Text.translatable("itemgroup.treesplus.treesplus_blocks"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.COCONUT);
                        entries.add(ModBlocks.COCONUT_PALM_LEAVES);
                        entries.add(ModBlocks.PALM_PLANKS);
                        entries.add(ModBlocks.PALM_WOOD);
                        entries.add(ModBlocks.STRIPPED_PALM_WOOD);
                        entries.add(ModBlocks.PALM_LOG);
                        entries.add(ModBlocks.STRIPPED_PALM_LOG);
                        entries.add(ModBlocks.PALM_STAIRS);
                        entries.add(ModBlocks.PALM_SLAB);
                        entries.add(ModBlocks.PALM_FENCE);
                        entries.add(ModBlocks.PALM_FENCE_GATE);
                        entries.add(ModBlocks.PALM_BUTTON);
                        entries.add(ModBlocks.PALM_PRESSURE_PLATE);
                        entries.add(ModBlocks.PALM_DOOR);
                        entries.add(ModBlocks.PALM_TRAPDOOR);


                        }).build());


    public static void registerItemGroups() {
        Treesplus.LOGGER.info("Registering Item Groups for " + Treesplus.MOD_ID);
    }
}