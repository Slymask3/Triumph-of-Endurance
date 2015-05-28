package com.abstractlabs.toe.init;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import com.abstractlabs.toe.block.BlockArmoury;
import com.abstractlabs.toe.block.BlockBreakableDesert;
import com.abstractlabs.toe.block.BlockCash;
import com.abstractlabs.toe.block.BlockEntranceDesert;
import com.abstractlabs.toe.block.BlockExteriorDesert;
import com.abstractlabs.toe.block.BlockExteriorForest;
import com.abstractlabs.toe.block.BlockExteriorGlass;
import com.abstractlabs.toe.block.BlockLandmine;
import com.abstractlabs.toe.block.BlockQuicksand;
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
	public static Block quicksand = new BlockQuicksand();
	public static Block entranceDesert = new BlockEntranceDesert();
	public static Block breakableDesert = new BlockBreakableDesert();
	public static Block cash = new BlockCash();
	
	public static void init() {
		GameRegistry.registerBlock(blockArmoury, "blockArmoury");
		GameRegistry.registerBlock(blockutility, "blockUtility");
		GameRegistry.registerBlock(weaponry, "weaponry");
		GameRegistry.registerBlock(exteriorDesert, "exteriorDesert");
		GameRegistry.registerBlock(exteriorForest, "exteriorForest");
		GameRegistry.registerBlock(exteriorGlass, "exteriorGlass");
		GameRegistry.registerBlock(landMine, "landmine");
		GameRegistry.registerBlock(quicksand, "quicksand");
		GameRegistry.registerBlock(entranceDesert, "entranceDesert");
		GameRegistry.registerBlock(breakableDesert, "breakableDesert");
		GameRegistry.registerBlock(cash, "cash");
	}
}