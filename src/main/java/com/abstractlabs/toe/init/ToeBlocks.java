package com.abstractlabs.toe.init;

import net.minecraft.block.Block;

import com.abstractlabs.toe.block.BlockArmoury;
import com.abstractlabs.toe.block.BlockExteriorDesert;
import com.abstractlabs.toe.block.BlockExteriorForest;
import com.abstractlabs.toe.block.BlockExteriorGlass;

import cpw.mods.fml.common.registry.GameRegistry;

public class ToeBlocks {
	public static Block blockArmoury = new BlockArmoury();
	public static Block exteriorDesert = new BlockExteriorDesert();
	public static Block exteriorForest = new BlockExteriorForest();
	public static Block exteriorGlass = new BlockExteriorGlass();
	
	public static void init() {
		GameRegistry.registerBlock(blockArmoury, "blockArmoury");
		GameRegistry.registerBlock(exteriorDesert, "exteriorDesert");
		GameRegistry.registerBlock(exteriorForest, "exteriorForest");
		GameRegistry.registerBlock(exteriorGlass, "exteriorGlass");
		GameRegistry.registerBlock(blockArmoury, "blockArmoury");
	}
}