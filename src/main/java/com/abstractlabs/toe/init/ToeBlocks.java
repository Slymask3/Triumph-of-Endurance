package com.abstractlabs.toe.init;

import net.minecraft.block.Block;
import net.minecraft.block.BlockPressurePlate;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EnumCreatureType;

import com.abstractlabs.toe.block.BlockArmoury;
import com.abstractlabs.toe.block.BlockExteriorDesert;
import com.abstractlabs.toe.block.BlockExteriorForest;
import com.abstractlabs.toe.block.BlockExteriorGlass;
import com.abstractlabs.toe.block.BlockLandmine;
import com.abstractlabs.toe.block.BlockUtility;
import com.abstractlabs.toe.block.BlockWeaponry;

import cpw.mods.fml.common.registry.GameRegistry;

public class ToeBlocks {
	public static Block blockArmoury = new BlockArmoury();
	public static Block blockutility = new BlockUtility();
	public static Block weaponry = new BlockWeaponry();
	public static Block exteriorDesert = new BlockExteriorDesert();
	public static Block exteriorForest = new BlockExteriorForest();
	public static Block exteriorGlass = new BlockExteriorGlass();
	public static Block landMine = new BlockLandmine("obsidian", Material.rock, BlockLandmine.Sensitivity.everything);
	
	public static void init() {
		GameRegistry.registerBlock(blockArmoury, "blockArmoury");
		GameRegistry.registerBlock(blockutility, "blockUtility");
		GameRegistry.registerBlock(landMine, "landmine");
		GameRegistry.registerBlock(weaponry, "weaponry");
		GameRegistry.registerBlock(exteriorDesert, "exteriorDesert");
		GameRegistry.registerBlock(exteriorForest, "exteriorForest");
		GameRegistry.registerBlock(exteriorGlass, "exteriorGlass");
	}
}