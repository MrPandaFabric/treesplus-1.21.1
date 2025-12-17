package com.mrpanda.net.treesplus.block;

import com.mrpanda.net.treesplus.Treesplus;
import com.mrpanda.net.treesplus.block.custom.CoconutBlock;
import com.mrpanda.net.treesplus.block.custom.CoconutPalmLeavesBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block COCONUT = registerBlock("coconut",
            new CoconutBlock(AbstractBlock.Settings.copy(Blocks.OAK_WOOD)
                    .strength(0.5f)
                    .sounds(BlockSoundGroup.WOOD)
                    .nonOpaque()
            ));

    public static final Block COCONUT_PALM_LEAVES = registerBlock("coconut_palm_leaves",
            new CoconutPalmLeavesBlock(AbstractBlock.Settings.copy(Blocks.OAK_LEAVES)
                    .ticksRandomly()
                    .nonOpaque()
                    .strength(0.2f)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(Treesplus.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(Treesplus.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        Treesplus.LOGGER.info("Registering Mod Blocks for " + Treesplus.MOD_ID);


    }
}