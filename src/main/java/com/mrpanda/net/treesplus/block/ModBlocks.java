package com.mrpanda.net.treesplus.block;

import com.mrpanda.net.treesplus.Treesplus;
import com.mrpanda.net.treesplus.block.custom.CoconutBlock;
import com.mrpanda.net.treesplus.block.custom.CoconutPalmLeavesBlock;
import com.mrpanda.net.treesplus.block.custom.ModSaplingBlock;
import com.mrpanda.net.treesplus.world.tree.ModSaplingGenerators;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block COCONUT = registerBlock("coconut",
            new CoconutBlock(AbstractBlock.Settings.copy(Blocks.OAK_WOOD).strength(0.5f).sounds(BlockSoundGroup.WOOD).nonOpaque()));

    public static final Block COCONUT_PALM_LEAVES = registerBlock("coconut_palm_leaves",
            new CoconutPalmLeavesBlock(AbstractBlock.Settings.create()
                    .mapColor(MapColor.DARK_GREEN)
                    .strength(0.2F)
                    .ticksRandomly()
                    .nonOpaque()
                    .sounds(BlockSoundGroup.GRASS)
                    .allowsSpawning((state, world, pos, type) -> false)
                    .suffocates((state, world, pos) -> false)
                    .blockVision((state, world, pos) -> false)
            ));


    public static final Block PALM_PLANKS = registerBlock("palm_planks",
            new Block(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS)));

    public static final Block PALM_WOOD = registerBlock("palm_wood",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_WOOD)));

    public static final Block STRIPPED_PALM_WOOD = registerBlock("stripped_palm_wood",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_WOOD)));

    public static final Block PALM_LOG = registerBlock("palm_log",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_LOG)));

    public static final Block STRIPPED_PALM_LOG = registerBlock("stripped_palm_log",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_LOG)));

     public static final Block PALM_STAIRS = registerBlock("palm_stairs",
            new StairsBlock(ModBlocks.PALM_PLANKS.getDefaultState(),AbstractBlock.Settings.copy(Blocks.OAK_STAIRS)));

     public static final Block PALM_SLAB = registerBlock("palm_slab",
             new SlabBlock(AbstractBlock.Settings.copy(Blocks.OAK_SLAB)));

     public static final Block PALM_FENCE = registerBlock("palm_fence",
             new FenceBlock(AbstractBlock.Settings.copy(Blocks.OAK_FENCE)));

     public static final Block PALM_FENCE_GATE = registerBlock("palm_fence_gate",
             new FenceGateBlock(WoodType.OAK, AbstractBlock.Settings.copy(Blocks.OAK_FENCE_GATE)));

     public static final Block PALM_BUTTON = registerBlock("palm_button",
             new ButtonBlock(BlockSetType.OAK, 30, AbstractBlock.Settings.copy(Blocks.OAK_BUTTON)));

     public static final Block PALM_PRESSURE_PLATE = registerBlock("palm_pressure_plate",
             new PressurePlateBlock(BlockSetType.OAK, AbstractBlock.Settings.copy(Blocks.OAK_PRESSURE_PLATE)));

    public static final Block PALM_DOOR = registerBlock("palm_door",
            new DoorBlock(BlockSetType.OAK, AbstractBlock.Settings.copy(Blocks.OAK_DOOR)));

    public static final Block PALM_TRAPDOOR = registerBlock("palm_trapdoor",
            new TrapdoorBlock(BlockSetType.OAK, AbstractBlock.Settings.copy(Blocks.OAK_TRAPDOOR)));

    public static final Block COCONUT_PALM_SAPLING = registerBlock("coconut_palm_sapling",
            new SaplingBlock(ModSaplingGenerators.COCONUT_PALM, AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)));


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