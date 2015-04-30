package com.abstractlabs.toe.init;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import com.abstractlabs.toe.block.BlockArmoury;
import com.abstractlabs.toe.block.BlockExteriorDesert;
import com.abstractlabs.toe.block.BlockExteriorForest;
import com.abstractlabs.toe.reference.Reference;

import cpw.mods.fml.common.registry.GameRegistry;

public class ToeBlocks {
	public static Block exteriorDesert = new BlockExteriorDesert();
	public static Block blockArmoury = new BlockArmoury();
	//public static Block exteriorForest = new BlockExteriorForest();
	
	public static void init() {
		GameRegistry.registerBlock(exteriorDesert, "exteriorDesert");
		GameRegistry.registerBlock(blockArmoury, "blockArmoury");
		//GameRegistry.registerBlock(exteriorForest, "exteriorForest");
	}
}