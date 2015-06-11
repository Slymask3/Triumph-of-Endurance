package com.abstractlabs.toe.init;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import com.abstractlabs.toe.block.BlockATM;
import com.abstractlabs.toe.block.BlockArmoury;
import com.abstractlabs.toe.block.BlockBasic;
import com.abstractlabs.toe.block.BlockBeam;
import com.abstractlabs.toe.block.BlockBreakableDesert;
import com.abstractlabs.toe.block.BlockCash;
import com.abstractlabs.toe.block.BlockEntranceDesert;
import com.abstractlabs.toe.block.BlockExteriorDesert;
import com.abstractlabs.toe.block.BlockExteriorForest;
import com.abstractlabs.toe.block.BlockExteriorGlass;
import com.abstractlabs.toe.block.BlockFlatPortal;
import com.abstractlabs.toe.block.BlockFurnaceDiamond;
import com.abstractlabs.toe.block.BlockFurnaceEmerald;
import com.abstractlabs.toe.block.BlockFurnaceGold;
import com.abstractlabs.toe.block.BlockFurnaceIron;
import com.abstractlabs.toe.block.BlockFurnaceRedstone;
import com.abstractlabs.toe.block.BlockHollowGrass;
import com.abstractlabs.toe.block.BlockHollowLeaf;
import com.abstractlabs.toe.block.BlockHollowLog;
import com.abstractlabs.toe.block.BlockHollowSapling;
import com.abstractlabs.toe.block.BlockHollowsPortal;
import com.abstractlabs.toe.block.BlockLandmine;
import com.abstractlabs.toe.block.BlockLockedChest;
import com.abstractlabs.toe.block.BlockQuicksand;
import com.abstractlabs.toe.block.BlockRandomOre;
import com.abstractlabs.toe.block.BlockRecall;
import com.abstractlabs.toe.block.BlockRuby;
import com.abstractlabs.toe.block.BlockRubyOre;
import com.abstractlabs.toe.block.BlockStatueBiped;
import com.abstractlabs.toe.block.BlockTester;
import com.abstractlabs.toe.block.BlockToeFire;
import com.abstractlabs.toe.block.BlockUtility;
import com.abstractlabs.toe.block.BlockWeaponry;
import com.abstractlabs.toe.block.HollowBlock;

import cpw.mods.fml.common.registry.GameRegistry;

public class ToeBlocks {
	public static Block armoury = new BlockArmoury();
	public static Block utility = new BlockUtility();
	public static Block weaponry = new BlockWeaponry();
	public static Block exteriorDesert = new BlockExteriorDesert();
	public static Block exteriorForest = new BlockExteriorForest();
	public static Block exteriorGlass = new BlockExteriorGlass();
	public static Block landMine = new BlockLandmine("obsidian", Material.rock, BlockLandmine.Sensitivity.everything);
	public static Block quicksand = new BlockQuicksand();
	public static Block entranceDesert = new BlockEntranceDesert();
	public static Block breakableDesert = new BlockBreakableDesert();
	public static Block cash = new BlockCash();
	public static BlockHollowsPortal hollowPortal = new BlockHollowsPortal("hollowPortal");
	public static Block blockHollow = new HollowBlock();
	public static BlockToeFire hollowFire = new BlockToeFire("hollowFire");
	public static Block beam = new BlockBeam();
	public static Block tester = new BlockTester();
	public static Block flatPortal = new BlockFlatPortal("flatPortal");
	public static Block hollowLog = new BlockHollowLog("hollowLog", "log");
	public static Block hollowLeaf = new BlockHollowLeaf("hollowLeaf", "hollow");
	public static Block hollowSapling = new BlockHollowSapling("hollowSapling", "hollow");
	public static Block hollowDirt = new BlockBasic(Material.rock, "hollowDirt", "hollowDirt", Block.soundTypeGrass);
	public static Block hollowGrass = new BlockHollowGrass(Material.rock, "hollowGrass", Block.soundTypeGrass);
	public static Block destination = new BlockRecall();
	public static Block lockedChest = new BlockLockedChest();
	public static Block randomOre = new BlockRandomOre();
	public static Block rubyOre = new BlockRubyOre();
	public static Block statueBiped = new BlockStatueBiped();
	public static Block atm = new BlockATM();
	public static Block furnaceIron = new BlockFurnaceIron(false);
	public static Block furnaceIronLit = new BlockFurnaceIron(true).setLightLevel(0.875F);
	public static Block furnaceGold = new BlockFurnaceGold(false);
	public static Block furnaceGoldLit = new BlockFurnaceGold(true).setLightLevel(0.875F);
	public static Block furnaceDiamond = new BlockFurnaceDiamond(false);
	public static Block furnaceDiamondLit = new BlockFurnaceDiamond(true).setLightLevel(0.875F);
	public static Block furnaceEmerald = new BlockFurnaceEmerald(false);
	public static Block furnaceEmeraldLit = new BlockFurnaceEmerald(true).setLightLevel(0.875F);
	public static Block furnaceRedstone = new BlockFurnaceRedstone(false);
	public static Block furnaceRedstoneLit = new BlockFurnaceRedstone(true).setLightLevel(0.875F);
	public static Block rubyBlock = new BlockRuby();
	
	public static void init() {
		//World Generation
		GameRegistry.registerBlock(quicksand, "quicksand");
		GameRegistry.registerBlock(hollowLog, "hollowLog");
		GameRegistry.registerBlock(hollowLeaf, "hollowLeaf");
		GameRegistry.registerBlock(hollowSapling, "hollowSapling");
		GameRegistry.registerBlock(hollowDirt, "hollowDirt");
		GameRegistry.registerBlock(hollowGrass, "hollowGrass");
		GameRegistry.registerBlock(beam, "beam");
		
		//Ores
		GameRegistry.registerBlock(randomOre, "randomOre");
		GameRegistry.registerBlock(rubyOre, "rubyOre");
		
		//Ore Blocks
		GameRegistry.registerBlock(rubyBlock, "rubyBlock");

		//Furnaces
		GameRegistry.registerBlock(furnaceIron, "furnaceIron");
		GameRegistry.registerBlock(furnaceIronLit, "furnaceIronLit");
		GameRegistry.registerBlock(furnaceGold, "furnaceGold");
		GameRegistry.registerBlock(furnaceGoldLit, "furnaceGoldLit");
		GameRegistry.registerBlock(furnaceDiamond, "furnaceDiamond");
		GameRegistry.registerBlock(furnaceDiamondLit, "furnaceDiamondLit");
		GameRegistry.registerBlock(furnaceEmerald, "furnaceEmerald");
		GameRegistry.registerBlock(furnaceEmeraldLit, "furnaceEmeraldLit");
		GameRegistry.registerBlock(furnaceRedstone, "furnaceRedstone");
		GameRegistry.registerBlock(furnaceRedstoneLit, "furnaceRedstoneLit");
		
		//Other
		GameRegistry.registerBlock(destination, "destination");
		GameRegistry.registerBlock(lockedChest, "lockedChest");
		GameRegistry.registerBlock(landMine, "landmine");
		GameRegistry.registerBlock(blockHollow, "blockHollow");
		GameRegistry.registerBlock(hollowFire, "hollowFire");
		GameRegistry.registerBlock(statueBiped, "statueBiped");
		GameRegistry.registerBlock(atm, "atm");
		
		//Portal
		GameRegistry.registerBlock(hollowPortal, "hollowPortal");
		GameRegistry.registerBlock(flatPortal, "flatPortal");
		
		//Arenalism
		GameRegistry.registerBlock(armoury, "armoury");
		GameRegistry.registerBlock(utility, "utility");
		GameRegistry.registerBlock(weaponry, "weaponry");
		GameRegistry.registerBlock(exteriorDesert, "exteriorDesert");
		GameRegistry.registerBlock(exteriorForest, "exteriorForest");
		GameRegistry.registerBlock(exteriorGlass, "exteriorGlass");
		GameRegistry.registerBlock(entranceDesert, "entranceDesert");
		GameRegistry.registerBlock(breakableDesert, "breakableDesert");
		GameRegistry.registerBlock(cash, "cash");
		
		//To be removed
		GameRegistry.registerBlock(tester, "tester");
	}
}