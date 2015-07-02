package com.abstractlabs.toe.init;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import com.abstractlabs.toe.block.BlockATM;
import com.abstractlabs.toe.block.BlockArmoury;
import com.abstractlabs.toe.block.BlockBasic;
import com.abstractlabs.toe.block.BlockBeam;
import com.abstractlabs.toe.block.BlockDisplayCase;
import com.abstractlabs.toe.block.BlockEntranceDesert;
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
import com.abstractlabs.toe.block.BlockPedestal;
import com.abstractlabs.toe.block.BlockPortalCallisto;
import com.abstractlabs.toe.block.BlockPortalNeptune;
import com.abstractlabs.toe.block.BlockQuicksand;
import com.abstractlabs.toe.block.BlockRandomOre;
import com.abstractlabs.toe.block.BlockRecall;
import com.abstractlabs.toe.block.BlockStatueBiped;
import com.abstractlabs.toe.block.BlockTester;
import com.abstractlabs.toe.block.BlockToe;
import com.abstractlabs.toe.block.BlockToeAlpha;
import com.abstractlabs.toe.block.BlockToeFire;
import com.abstractlabs.toe.block.BlockToeOre;
import com.abstractlabs.toe.block.BlockTransmutation;
import com.abstractlabs.toe.block.BlockUtility;
import com.abstractlabs.toe.block.BlockWeaponry;
import com.abstractlabs.toe.utility.BlockTexture;

import cpw.mods.fml.common.registry.GameRegistry;

public class ToeBlocks {
	private static BlockTexture texture_exteriorDesert = new BlockTexture("exteriorDesert");
	private static BlockTexture texture_exteriorForest = new BlockTexture("exteriorForest");
	private static BlockTexture texture_exteriorGlass = new BlockTexture(false, "glass");
	private static BlockTexture texture_cash = new BlockTexture("cash");
	private static BlockTexture texture_rubyBlock = new BlockTexture("rubyBlock");
	private static BlockTexture texture_lapisLamp = new BlockTexture("lapisLamp");
	private static BlockTexture texture_moonRock = new BlockTexture("moonRock");
	private static BlockTexture texture_glassLava = new BlockTexture("glassLava");
	private static BlockTexture texture_glassWater = new BlockTexture("glassWater");
	private static BlockTexture texture_crystalBlock = new BlockTexture("crystalBlock");
	private static BlockTexture texture_crystalIceBlock = new BlockTexture("crystalIceBlock");
	private static BlockTexture texture_hollowBlock = new BlockTexture("hollowBlock");
	private static BlockTexture texture_sapphireBlock = new BlockTexture("sapphireBlock");
	private static BlockTexture texture_moonBrick = new BlockTexture("moonBrick");
	private static BlockTexture texture_glassHard = new BlockTexture("glassHard");
	private static BlockTexture texture_glassHardLava = new BlockTexture("glassHardLava");
	private static BlockTexture texture_glassHardWater = new BlockTexture("glassHardWater");
	private static BlockTexture texture_neptuneRock = new BlockTexture("neptuneRock");
	private static BlockTexture texture_neptuneBrick = new BlockTexture("neptuneBrick");
	private static BlockTexture texture_iceSolid = new BlockTexture("iceSolid");
	
	public static Block armoury = new BlockArmoury();
	public static Block utility = new BlockUtility();
	public static Block weaponry = new BlockWeaponry();
	public static Block exteriorDesert = new BlockToe("exteriorDesert", texture_exteriorDesert, Material.rock, Block.soundTypeSand, -1.0F, 60000000.0F).setLightOpacity(0);
	public static Block exteriorForest = new BlockToe("exteriorForest", texture_exteriorForest, Material.wood, Block.soundTypeWood, -1.0F, 60000000.0F).setLightOpacity(0);
	public static Block exteriorGlass = new BlockToeAlpha("exteriorGlass", texture_exteriorGlass, Material.glass, Block.soundTypeGlass, -1.0F, 60000000.0F).setLightOpacity(0);
	public static Block landmine = new BlockLandmine();
	public static Block quicksand = new BlockQuicksand();
	public static Block entranceDesert = new BlockEntranceDesert();
	public static Block breakableDesert = new BlockToe("breakableDesert", texture_exteriorDesert, Material.rock, Block.soundTypeSand, 3.0F, 60000000.0F);
	public static Block cash = new BlockToe("cash", texture_cash, Material.sponge, Block.soundTypeCloth, 1.0F, 60000000.0F);
	public static BlockHollowsPortal hollowPortal = new BlockHollowsPortal("hollowPortal");
	public static Block blockHollow = new BlockToe("hollowBlock", texture_hollowBlock, Material.rock, Block.soundTypeStone, 3.0F, 10.0F);
	public static BlockToeFire hollowFire = new BlockToeFire("hollowFire");
	public static Block beam = new BlockBeam();
	public static Block tester = new BlockTester();
	public static Block hollowLog = new BlockHollowLog("hollowLog", "log");
	public static Block hollowLeaf = new BlockHollowLeaf("hollowLeaf", "hollow");
	public static Block hollowSapling = new BlockHollowSapling("hollowSapling", "hollow");
	public static Block hollowDirt = new BlockBasic(Material.rock, "hollowDirt", "hollowDirt", Block.soundTypeGrass);
	public static Block hollowGrass = new BlockHollowGrass(Material.rock, "hollowGrass", Block.soundTypeGrass);
	public static Block destination = new BlockRecall();
	public static Block lockedChest = new BlockLockedChest();
	public static Block randomOre = new BlockRandomOre();
	public static Block rubyOre = new BlockToeOre("rubyOre", 3, ToeItems.ruby);
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
	public static Block rubyBlock = new BlockToe("rubyBlock", texture_rubyBlock, Material.iron, Block.soundTypeMetal, 3.0F, 10.0F);
	public static Block portalCallisto = new BlockPortalCallisto();
	public static Block moonRock = new BlockToe("moonRock", texture_moonRock, Material.rock, Block.soundTypeStone, 3.0F, 5.0F);
	public static Block lapisLamp = new BlockToe("lapisLamp", texture_lapisLamp, Material.glass, Block.soundTypeGlass, 1.0F, 5.0F).setLightLevel(1.0F);
	public static Block crystalOre = new BlockToeOre("crystalOre", 2, ToeItems.crystal);
	public static Block crystalIceOre = new BlockToeOre("crystalIceOre", 2, ToeItems.crystalIce).setStepSound(Block.soundTypeGlass);
	public static Block crystalBlock = new BlockToeAlpha("crystalBlock", texture_crystalBlock, Material.glass, Block.soundTypeGlass, 0.5F, 5.0F);
	public static Block crystalIceBlock = new BlockToeAlpha("crystalIceBlock", texture_crystalIceBlock, Material.glass, Block.soundTypeGlass, 0.5F, 5.0F);
	public static Block glassLava = new BlockToe("glassLava", texture_glassLava, Material.glass, Block.soundTypeGlass, 0.2F, 5.0F).setLightLevel(1.0F);
	public static Block glassWater = new BlockToeAlpha("glassWater", texture_glassWater, Material.glass, Block.soundTypeGlass, 0.2F, 5.0F);
	public static Block displayCase = new BlockDisplayCase();
	//public static Block pedestalStonebrick = new BlockPedestalStonebrick();
	public static Block bauxiteOre = new BlockToeOre("bauxiteOre", 1);
	public static Block coinCopperOre = new BlockToeOre("coinCopperOre", 1, ToeItems.coinCopper, 3, true);
	public static Block coinSilverOre = new BlockToeOre("coinSilverOre", 1, ToeItems.coinSilver, 3, true);
	public static Block coinGoldOre = new BlockToeOre("coinGoldOre", 1, ToeItems.coinGold, 3, true);
	public static Block sapphireOre = new BlockToeOre("sapphireOre", 3, ToeItems.sapphire);
	public static Block sapphireBlock = new BlockToe("sapphireBlock", texture_sapphireBlock, Material.iron, Block.soundTypeMetal, 3.0F, 10.0F);
	public static Block moonBrick = new BlockToe("moonBrick", texture_moonBrick, Material.rock, Block.soundTypeStone, 3.0F, 5.0F);
	public static Block glassHard = new BlockToeAlpha("glassHard", texture_glassHard, Material.glass, Block.soundTypeGlass, 0.5F, 60000000.0F);
	public static Block glassHardLava = new BlockToe("glassHardLava", texture_glassHardLava, Material.glass, Block.soundTypeGlass, 0.5F, 60000000.0F).setLightLevel(1.0F);
	public static Block glassHardWater = new BlockToeAlpha("glassHardWater", texture_glassHardWater, Material.glass, Block.soundTypeGlass, 0.5F, 60000000.0F);
	public static Block neptuneRock = new BlockToeAlpha("neptuneRock", texture_neptuneRock, Material.rock, Block.soundTypeStone, 2.0F, 5.0F);
	public static Block neptuneRockSolid = new BlockToe("neptuneRockSolid", texture_neptuneRock, Material.rock, Block.soundTypeStone, 2.0F, 5.0F);
	public static Block neptuneBrick = new BlockToe("neptuneBrick", texture_neptuneBrick, Material.rock, Block.soundTypeStone, 3.0F, 5.0F);
	public static Block portalNeptune = new BlockPortalNeptune();
	public static Block iceSolid = new BlockToe("iceSolid", texture_iceSolid, Material.rock, Block.soundTypeGlass, 3.0F, 5.0F).setSlipperiness(0.98F);
	//public static Block iceSolid = new BlockIceSolid();

	public static Block pedestalStonebrick = new BlockPedestal("stonebrick", Material.rock);
	public static Block pedestalPlanks = new BlockPedestal("planks", Material.wood);
	public static Block pedestalBrick = new BlockPedestal("brick", Material.rock);
	public static Block pedestalQuartz = new BlockPedestal("quartz", Material.rock);

	public static Block transmutation = new BlockTransmutation(false);
	public static Block transmutationLit = new BlockTransmutation(true).setLightLevel(0.875F);
	
	public static void init() {
		//World Generation
		//Overworld
		GameRegistry.registerBlock(quicksand, "quicksand");
		GameRegistry.registerBlock(beam, "beam");
		//Hollows
		GameRegistry.registerBlock(hollowLog, "hollowLog");
		GameRegistry.registerBlock(hollowLeaf, "hollowLeaf");
		GameRegistry.registerBlock(hollowSapling, "hollowSapling");
		GameRegistry.registerBlock(hollowDirt, "hollowDirt");
		GameRegistry.registerBlock(hollowGrass, "hollowGrass");
		//Callisto
		GameRegistry.registerBlock(moonRock, "moonRock");
		//Neptune
		GameRegistry.registerBlock(neptuneRock, "neptuneRock");
		GameRegistry.registerBlock(neptuneRockSolid, "neptuneRockSolid");
		GameRegistry.registerBlock(iceSolid, "iceSolid");
		
		//Ores
		GameRegistry.registerBlock(randomOre, "randomOre");
		GameRegistry.registerBlock(rubyOre, "rubyOre");
		GameRegistry.registerBlock(sapphireOre, "sapphireOre");
		GameRegistry.registerBlock(crystalOre, "crystalOre");
		GameRegistry.registerBlock(crystalIceOre, "crystalIceOre");
		GameRegistry.registerBlock(coinCopperOre, "coinCopperOre");
		GameRegistry.registerBlock(coinSilverOre, "coinSilverOre");
		GameRegistry.registerBlock(coinGoldOre, "coinGoldOre");
		GameRegistry.registerBlock(bauxiteOre, "bauxiteOre");
		//moon ore ideas: lanthanum, noibium, neodymium, bismuth, antimony, lead, silver, tin
		
		//Ore Blocks
		GameRegistry.registerBlock(rubyBlock, "rubyBlock");
		GameRegistry.registerBlock(sapphireBlock, "sapphireBlock");
		GameRegistry.registerBlock(crystalBlock, "crystalBlock");
		GameRegistry.registerBlock(crystalIceBlock, "crystalIceBlock");

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
		GameRegistry.registerBlock(transmutation, "transmutation");
		GameRegistry.registerBlock(transmutationLit, "transmutationLit");
		
		//Other
		GameRegistry.registerBlock(destination, "destination");
		GameRegistry.registerBlock(lockedChest, "lockedChest");
		GameRegistry.registerBlock(landmine, "landmine");
		GameRegistry.registerBlock(blockHollow, "blockHollow");
		GameRegistry.registerBlock(hollowFire, "hollowFire");
		GameRegistry.registerBlock(statueBiped, "statueBiped");
		GameRegistry.registerBlock(atm, "atm");
		GameRegistry.registerBlock(lapisLamp, "lapisLamp");
		GameRegistry.registerBlock(glassWater, "glassWater");
		GameRegistry.registerBlock(glassLava, "glassLava");
		GameRegistry.registerBlock(displayCase, "displayCase");
		GameRegistry.registerBlock(pedestalStonebrick, "pedestalStonebrick");
		GameRegistry.registerBlock(pedestalPlanks, "pedestalPlanks");
		GameRegistry.registerBlock(pedestalBrick, "pedestalBrick");
		GameRegistry.registerBlock(pedestalQuartz, "pedestalQuartz");
		GameRegistry.registerBlock(moonBrick, "moonBrick");
		GameRegistry.registerBlock(glassHard, "glassHard");
		GameRegistry.registerBlock(glassHardWater, "glassHardWater");
		GameRegistry.registerBlock(glassHardLava, "glassHardLava");
		GameRegistry.registerBlock(neptuneBrick, "neptuneBrick");
		
		//Portal
		GameRegistry.registerBlock(hollowPortal, "hollowPortal");
		GameRegistry.registerBlock(portalCallisto, "portalCallisto");
		GameRegistry.registerBlock(portalNeptune, "portalNeptune");
		
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