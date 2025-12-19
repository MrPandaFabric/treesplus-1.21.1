package com.mrpanda.net.treesplus;

import com.mrpanda.net.treesplus.block.ModBlocks;
import com.mrpanda.net.treesplus.entity.ModBoats;
import com.mrpanda.net.treesplus.item.ModItemGroups;
import com.mrpanda.net.treesplus.item.ModItems;
import com.mrpanda.net.treesplus.world.ModBiomeModifications;
import com.mrpanda.net.treesplus.world.gen.ModWorldGeneration;
import com.mrpanda.net.treesplus.world.tree.ModFoliagePlacerTypes;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Treesplus implements ModInitializer {
	public static final String MOD_ID = "treesplus";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModFoliagePlacerTypes.register();
		ModWorldGeneration.generateModWorldGen();
		ModBiomeModifications.registerRemovals();
		ModBoats.registerBoats();
		}
	}