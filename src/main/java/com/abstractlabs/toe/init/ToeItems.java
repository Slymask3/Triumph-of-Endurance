package com.abstractlabs.toe.init;

import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

import com.abstractlabs.toe.item.ItemBone;
import com.abstractlabs.toe.item.ItemBucketGoo;
import com.abstractlabs.toe.item.ItemCane;
import com.abstractlabs.toe.item.ItemFlashbang;
import com.abstractlabs.toe.item.ItemGhostblade;
import com.abstractlabs.toe.item.ItemGrenade;
import com.abstractlabs.toe.item.ItemHealingTablet;
import com.abstractlabs.toe.item.ItemHollowLighter;
import com.abstractlabs.toe.item.ItemLockpick;
import com.abstractlabs.toe.item.ItemRecall;
import com.abstractlabs.toe.item.ItemTester;
import com.abstractlabs.toe.item.ItemToe;
import com.abstractlabs.toe.item.ItemToeArmor;
import com.abstractlabs.toe.item.ItemToeAxe;
import com.abstractlabs.toe.item.ItemToeAxepick;
import com.abstractlabs.toe.item.ItemToeFood;
import com.abstractlabs.toe.item.ItemToeHoe;
import com.abstractlabs.toe.item.ItemToePickaxe;
import com.abstractlabs.toe.item.ItemToeShovel;
import com.abstractlabs.toe.item.ItemToeSword;
import com.abstractlabs.toe.reference.BoneType;
import com.abstractlabs.toe.reference.Thieving;

import cpw.mods.fml.common.registry.GameRegistry;

public class ToeItems {
	private static ArmorMaterial magmaMaterial = EnumHelper.addArmorMaterial("Magma Material", 33, new int[]{2, 5, 4, 2}, 10);
	private static ArmorMaterial nimbleMaterial = EnumHelper.addArmorMaterial("Nimble Material", 33, new int[]{2, 5, 4, 2}, 10);
	private static ArmorMaterial dynamicMaterial = EnumHelper.addArmorMaterial("Dynamic Material", 33, new int[]{2, 5, 4, 2}, 10);
	private static ArmorMaterial spacesuitMaterial = EnumHelper.addArmorMaterial("Spacesuit Material", 33, new int[]{2, 5, 4, 2}, 10);
	private static ArmorMaterial emeraldMaterial = EnumHelper.addArmorMaterial("Emerald Material", 33, new int[]{3, 8, 6, 3}, 10);
	private static ArmorMaterial rubyMaterial = EnumHelper.addArmorMaterial("Ruby Material", 33, new int[]{3, 8, 6, 3}, 10);
	private static ArmorMaterial sapphireMaterial = EnumHelper.addArmorMaterial("Sapphire Material", 33, new int[]{3, 8, 6, 3}, 10);
	
	private static ToolMaterial caneMaterial = EnumHelper.addToolMaterial("Cane Material", 0, 300, 2.0F, 1.0F, 30);
	private static ToolMaterial specialMaterial = EnumHelper.addToolMaterial("Special", 3, 1561, 8.0F, 3.0F, 10);
	private static ToolMaterial veinMaterial = EnumHelper.addToolMaterial("Vein", 3, 1561, 8.0F, 3.0F, 10);
	private static ToolMaterial smeltingMaterial = EnumHelper.addToolMaterial("Smelting", 0, 1561, 8.0F, 3.0F, 10);
	private static ToolMaterial stripMaterial = EnumHelper.addToolMaterial("Strip", 3, 1561, 16.0F, 3.0F, 10);
	private static ToolMaterial timberMaterial = EnumHelper.addToolMaterial("Timber", 3, 1561, 8.0F, 3.0F, 10);
	private static ToolMaterial emeraldToolMaterial = EnumHelper.addToolMaterial("Emerald", 3, 2500, 8.0F, 3.0F, 10);
	private static ToolMaterial rubyToolMaterial = EnumHelper.addToolMaterial("Ruby", 3, 2500, 8.0F, 3.0F, 10);
	private static ToolMaterial sapphireToolMaterial = EnumHelper.addToolMaterial("Sapphire", 3, 2500, 8.0F, 3.0F, 10);
	
	public static Item flashbang = new ItemFlashbang().setUnlocalizedName("flashbang");
	public static Item grenade = new ItemGrenade().setUnlocalizedName("grenade");
	public static Item hollowLighter = new ItemHollowLighter().setUnlocalizedName("hollowLighter");
	public static Item recall = new ItemRecall().setUnlocalizedName("recall");
	public static Item cane = new ItemCane("cane", caneMaterial);
	public static Item paperclip = new ItemLockpick(Thieving.paperclipUses-1, Thieving.paperclipLvl, Thieving.paperclipChance).setUnlocalizedName("paperclip");
	public static Item lockpick = new ItemLockpick(Thieving.lockpickUses-1, Thieving.lockpickLvl, Thieving.lockpickChance).setUnlocalizedName("lockpick");
	public static Item masterKey = new ItemLockpick(Thieving.masterKeyUses-1, Thieving.masterKeyLvl, Thieving.masterKeyChance).setUnlocalizedName("masterKey");
	public static Item tester = new ItemTester().setUnlocalizedName("testerItem");
	public static Item coinCopper = new ItemToe().setUnlocalizedName("coinCopper");
	public static Item coinSilver = new ItemToe().setUnlocalizedName("coinSilver");
	public static Item coinGold = new ItemToe().setUnlocalizedName("coinGold");
	public static Item specialPickaxe = new ItemToePickaxe(specialMaterial).setUnlocalizedName("specialPickaxe");
	public static Item veinPickaxe = new ItemToePickaxe(veinMaterial).setUnlocalizedName("veinPickaxe");
	public static Item smeltingPickaxe = new ItemToePickaxe(smeltingMaterial).setUnlocalizedName("smeltingPickaxe");
	public static Item stripPickaxe = new ItemToePickaxe(stripMaterial).setUnlocalizedName("stripPickaxe");
	public static Item woodAxepick = new ItemToeAxepick(ToolMaterial.WOOD, true).setUnlocalizedName("woodAxepick");
	public static Item goldAxepick = new ItemToeAxepick(ToolMaterial.GOLD, true).setUnlocalizedName("goldAxepick");
	public static Item stoneAxepick = new ItemToeAxepick(ToolMaterial.STONE, true).setUnlocalizedName("stoneAxepick");
	public static Item ironAxepick = new ItemToeAxepick(ToolMaterial.IRON, true).setUnlocalizedName("ironAxepick");
	public static Item diamondAxepick = new ItemToeAxepick(ToolMaterial.EMERALD, true).setUnlocalizedName("diamondAxepick");
	public static Item woodAxepick_pick = new ItemToeAxepick(ToolMaterial.WOOD, false).setUnlocalizedName("woodAxepick_pick");
	public static Item goldAxepick_pick = new ItemToeAxepick(ToolMaterial.GOLD, false).setUnlocalizedName("goldAxepick_pick");
	public static Item stoneAxepick_pick = new ItemToeAxepick(ToolMaterial.STONE, false).setUnlocalizedName("stoneAxepick_pick");
	public static Item ironAxepick_pick = new ItemToeAxepick(ToolMaterial.IRON, false).setUnlocalizedName("ironAxepick_pick");
	public static Item diamondAxepick_pick = new ItemToeAxepick(ToolMaterial.EMERALD, false).setUnlocalizedName("diamondAxepick_pick");
	public static Item timberAxe = new ItemToeAxe(timberMaterial).setUnlocalizedName("timberAxe");
	public static Item ruby = new ItemToe().setUnlocalizedName("ruby");
	public static Item undeadbatBone = new ItemBone(BoneType.undeadbatBoneLvl).setUnlocalizedName("undeadbatBone");
	public static Item healingTab = new ItemHealingTablet(BoneType.healLvl).setUnlocalizedName("healingTablet");
	public static Item ghostblade = new ItemGhostblade().setUnlocalizedName("ghostblade");
	public static Item crystal = new ItemToe().setUnlocalizedName("crystal");
	public static Item crystalIce = new ItemToe().setUnlocalizedName("crystalIce");
	public static Item aluminium = new ItemToe().setUnlocalizedName("aluminium");
	public static Item aluminiumSheet = new ItemToe().setUnlocalizedName("aluminiumSheet");
	public static Item sapphire = new ItemToe().setUnlocalizedName("sapphire");
	public static Item greenLeather = new ItemToe().setUnlocalizedName("greenLeather");
	public static Item alienBeef = new ItemToeFood(3).setUnlocalizedName("alienBeef");
	public static Item alienSteak = new ItemToeFood(8).setUnlocalizedName("alienSteak");
	public static Item bucketGoo = new ItemBucketGoo().setUnlocalizedName("bucketGoo");
	
	public static Item emeraldSword = new ItemToeSword(emeraldToolMaterial).setUnlocalizedName("emeraldSword");
	public static Item emeraldPickaxe = new ItemToePickaxe(emeraldToolMaterial).setUnlocalizedName("emeraldPickaxe");
	public static Item emeraldShovel = new ItemToeShovel(emeraldToolMaterial).setUnlocalizedName("emeraldShovel");
	public static Item emeraldAxe = new ItemToeAxe(emeraldToolMaterial).setUnlocalizedName("emeraldAxe");
	public static Item emeraldAxepick = new ItemToeAxepick(emeraldToolMaterial, true).setUnlocalizedName("emeraldAxepick");
	public static Item emeraldAxepick_pick = new ItemToeAxepick(emeraldToolMaterial, false).setUnlocalizedName("emeraldAxepick_pick");
	public static Item emeraldHoe = new ItemToeHoe(emeraldToolMaterial).setUnlocalizedName("emeraldHoe");
	
	public static Item rubySword = new ItemToeSword(rubyToolMaterial).setUnlocalizedName("rubySword");
	public static Item rubyPickaxe = new ItemToePickaxe(rubyToolMaterial).setUnlocalizedName("rubyPickaxe");
	public static Item rubyShovel = new ItemToeShovel(rubyToolMaterial).setUnlocalizedName("rubyShovel");
	public static Item rubyAxe = new ItemToeAxe(rubyToolMaterial).setUnlocalizedName("rubyAxe");
	public static Item rubyAxepick = new ItemToeAxepick(rubyToolMaterial, true).setUnlocalizedName("rubyAxepick");
	public static Item rubyAxepick_pick = new ItemToeAxepick(rubyToolMaterial, false).setUnlocalizedName("rubyAxepick_pick");
	public static Item rubyHoe = new ItemToeHoe(rubyToolMaterial).setUnlocalizedName("rubyHoe");
	
	public static Item sapphireSword = new ItemToeSword(sapphireToolMaterial).setUnlocalizedName("sapphireSword");
	public static Item sapphirePickaxe = new ItemToePickaxe(sapphireToolMaterial).setUnlocalizedName("sapphirePickaxe");
	public static Item sapphireShovel = new ItemToeShovel(sapphireToolMaterial).setUnlocalizedName("sapphireShovel");
	public static Item sapphireAxe = new ItemToeAxe(sapphireToolMaterial).setUnlocalizedName("sapphireAxe");
	public static Item sapphireAxepick = new ItemToeAxepick(sapphireToolMaterial, true).setUnlocalizedName("sapphireAxepick");
	public static Item sapphireAxepick_pick = new ItemToeAxepick(sapphireToolMaterial, false).setUnlocalizedName("sapphireAxepick_pick");
	public static Item sapphireHoe = new ItemToeHoe(sapphireToolMaterial).setUnlocalizedName("sapphireHoe");
	
	public static Item magmaHelmet = new ItemToeArmor(magmaMaterial, "magma", 0);
	public static Item magmaPlate = new ItemToeArmor(magmaMaterial, "magma", 1);
	public static Item magmaPants = new ItemToeArmor(magmaMaterial, "magma", 2);
	public static Item magmaBoots = new ItemToeArmor(magmaMaterial, "magma", 3);
	public static Item nimbleHelmet = new ItemToeArmor(nimbleMaterial, "nimble", 0);
	public static Item nimblePlate = new ItemToeArmor(nimbleMaterial, "nimble", 1);
	public static Item nimblePants = new ItemToeArmor(nimbleMaterial, "nimble", 2);
	public static Item nimbleBoots = new ItemToeArmor(nimbleMaterial, "nimble", 3);
	public static Item dynamicHelmet = new ItemToeArmor(dynamicMaterial, "dynamic", 0);
	public static Item dynamicPlate = new ItemToeArmor(dynamicMaterial, "dynamic", 1);
	public static Item dynamicPants = new ItemToeArmor(dynamicMaterial, "dynamic", 2);
	public static Item dynamicBoots = new ItemToeArmor(dynamicMaterial, "dynamic", 3);

	public static Item spacesuitHelmet = new ItemToeArmor(spacesuitMaterial, "spacesuit", 0);
	public static Item spacesuitPlate = new ItemToeArmor(spacesuitMaterial, "spacesuit", 1);
	public static Item spacesuitPants = new ItemToeArmor(spacesuitMaterial, "spacesuit", 2);
	public static Item spacesuitBoots = new ItemToeArmor(spacesuitMaterial, "spacesuit", 3);

	public static Item emeraldHelmet = new ItemToeArmor(emeraldMaterial, "emerald", 0);
	public static Item emeraldPlate = new ItemToeArmor(emeraldMaterial, "emerald", 1);
	public static Item emeraldPants = new ItemToeArmor(emeraldMaterial, "emerald", 2);
	public static Item emeraldBoots = new ItemToeArmor(emeraldMaterial, "emerald", 3);

	public static Item rubyHelmet = new ItemToeArmor(rubyMaterial, "ruby", 0);
	public static Item rubyPlate = new ItemToeArmor(rubyMaterial, "ruby", 1);
	public static Item rubyPants = new ItemToeArmor(rubyMaterial, "ruby", 2);
	public static Item rubyBoots = new ItemToeArmor(rubyMaterial, "ruby", 3);

	public static Item sapphireHelmet = new ItemToeArmor(sapphireMaterial, "sapphire", 0);
	public static Item sapphirePlate = new ItemToeArmor(sapphireMaterial, "sapphire", 1);
	public static Item sapphirePants = new ItemToeArmor(sapphireMaterial, "sapphire", 2);
	public static Item sapphireBoots = new ItemToeArmor(sapphireMaterial, "sapphire", 3);
	
	public static void init() {
		//Weapons
		GameRegistry.registerItem(emeraldSword, "emeraldSword");
		GameRegistry.registerItem(rubySword, "rubySword");
		GameRegistry.registerItem(sapphireSword, "sapphireSword");
		GameRegistry.registerItem(cane, "cane");
		GameRegistry.registerItem(ghostblade, "ghostblade");

		//Pickaxes
		GameRegistry.registerItem(emeraldPickaxe, "emeraldPickaxe");
		GameRegistry.registerItem(rubyPickaxe, "rubyPickaxe");
		GameRegistry.registerItem(sapphirePickaxe, "sapphirePickaxe");
		GameRegistry.registerItem(specialPickaxe, "specialPickaxe");
		GameRegistry.registerItem(veinPickaxe, "veinPickaxe");
		GameRegistry.registerItem(smeltingPickaxe, "smeltingPickaxe");
		GameRegistry.registerItem(stripPickaxe, "stripPickaxe");
		
		//Shovels
		GameRegistry.registerItem(emeraldShovel, "emeraldShovel");
		GameRegistry.registerItem(rubyShovel, "rubyShovel");
		GameRegistry.registerItem(sapphireShovel, "sapphireShovel");
		
		//Axes
		GameRegistry.registerItem(emeraldAxe, "emeraldAxe");
		GameRegistry.registerItem(rubyAxe, "rubyAxe");
		GameRegistry.registerItem(sapphireAxe, "sapphireAxe");
		GameRegistry.registerItem(timberAxe, "timberAxe");
		
		//Axepicks
		GameRegistry.registerItem(woodAxepick, "woodAxepick");
		GameRegistry.registerItem(goldAxepick, "goldAxepick");
		GameRegistry.registerItem(stoneAxepick, "stoneAxepick");
		GameRegistry.registerItem(ironAxepick, "ironAxepick");
		GameRegistry.registerItem(diamondAxepick, "diamondAxepick");
		GameRegistry.registerItem(emeraldAxepick, "emeraldAxepick");
		GameRegistry.registerItem(rubyAxepick, "rubyAxepick");
		GameRegistry.registerItem(sapphireAxepick, "sapphireAxepick");
		GameRegistry.registerItem(woodAxepick_pick, "woodAxepick_pick");
		GameRegistry.registerItem(goldAxepick_pick, "goldAxepick_pick");
		GameRegistry.registerItem(stoneAxepick_pick, "stoneAxepick_pick");
		GameRegistry.registerItem(ironAxepick_pick, "ironAxepick_pick");
		GameRegistry.registerItem(diamondAxepick_pick, "diamondAxepick_pick");
		GameRegistry.registerItem(emeraldAxepick_pick, "emeraldAxepick_pick");
		GameRegistry.registerItem(rubyAxepick_pick, "rubyAxepick_pick");
		GameRegistry.registerItem(sapphireAxepick_pick, "sapphireAxepick_pick");
		
		//Hoes
		GameRegistry.registerItem(emeraldHoe, "emeraldHoe");
		GameRegistry.registerItem(rubyHoe, "rubyHoe");
		GameRegistry.registerItem(sapphireHoe, "sapphireHoe");
		
		//Magic
		GameRegistry.registerItem(recall, "recall");
		
		//Projectiles
		GameRegistry.registerItem(flashbang, "flashbang");
		GameRegistry.registerItem(grenade, "grenade");
		
		//Thieving Lockpicks
		GameRegistry.registerItem(paperclip, "paperclip");
		GameRegistry.registerItem(lockpick, "lockpick");
		GameRegistry.registerItem(masterKey, "masterKey");
		
		//Prayer Bones
		GameRegistry.registerItem(undeadbatBone, "undeadbatBone");
		GameRegistry.registerItem(healingTab, "healingTablet");
		
		//Coins
		GameRegistry.registerItem(coinCopper, "coinCopper");
		GameRegistry.registerItem(coinSilver, "coinSilver");
		GameRegistry.registerItem(coinGold, "coinGold");
		
		//Ore Gems
		GameRegistry.registerItem(ruby, "ruby");
		GameRegistry.registerItem(sapphire, "sapphire");
		GameRegistry.registerItem(crystal, "crystal");
		GameRegistry.registerItem(crystalIce, "crystalIce");
		GameRegistry.registerItem(aluminium, "aluminium");
		
		//Food
		GameRegistry.registerItem(alienBeef, "alienBeef");
		GameRegistry.registerItem(alienSteak, "alienSteak");
		
		//Other
		GameRegistry.registerItem(hollowLighter, "hollowLighter");
		GameRegistry.registerItem(aluminiumSheet, "aluminiumSheet");
		GameRegistry.registerItem(greenLeather, "greenLeather");
		GameRegistry.registerItem(bucketGoo, "bucketGoo");
		
		//Armor
		GameRegistry.registerItem(emeraldHelmet, "emeraldHelmet");
		GameRegistry.registerItem(emeraldPlate, "emeraldPlate");
		GameRegistry.registerItem(emeraldPants, "emeraldPants");
		GameRegistry.registerItem(emeraldBoots, "emeraldBoots");
		GameRegistry.registerItem(rubyHelmet, "rubyHelmet");
		GameRegistry.registerItem(rubyPlate, "rubyPlate");
		GameRegistry.registerItem(rubyPants, "rubyPants");
		GameRegistry.registerItem(rubyBoots, "rubyBoots");
		GameRegistry.registerItem(sapphireHelmet, "sapphireHelmet");
		GameRegistry.registerItem(sapphirePlate, "sapphirePlate");
		GameRegistry.registerItem(sapphirePants, "sapphirePants");
		GameRegistry.registerItem(sapphireBoots, "sapphireBoots");
		
		GameRegistry.registerItem(magmaHelmet, "magmaHelmet");
		GameRegistry.registerItem(magmaPlate, "magmaPlate");
		GameRegistry.registerItem(magmaPants, "magmaPants");
		GameRegistry.registerItem(magmaBoots, "magmaBoots");
		GameRegistry.registerItem(nimbleHelmet, "nimbleHelmet");
		GameRegistry.registerItem(nimblePlate, "nimblePlate");
		GameRegistry.registerItem(nimblePants, "nimblePants");
		GameRegistry.registerItem(nimbleBoots, "nimbleBoots");
		GameRegistry.registerItem(dynamicHelmet, "dynamicHelmet");
		GameRegistry.registerItem(dynamicPlate, "dynamicPlate");
		GameRegistry.registerItem(dynamicPants, "dynamicPants");
		GameRegistry.registerItem(dynamicBoots, "dynamicBoots");
		GameRegistry.registerItem(spacesuitHelmet, "spacesuitHelmet");
		GameRegistry.registerItem(spacesuitPlate, "spacesuitPlate");
		GameRegistry.registerItem(spacesuitPants, "spacesuitPants");
		GameRegistry.registerItem(spacesuitBoots, "spacesuitBoots");

		//To be removed
		GameRegistry.registerItem(tester, "testerItem");
	}
}