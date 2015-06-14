package com.abstractlabs.toe.init;

import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

import com.abstractlabs.toe.item.ItemArenalismLighter;
import com.abstractlabs.toe.item.ItemCane;
import com.abstractlabs.toe.item.ItemDynamicArmour;
import com.abstractlabs.toe.item.ItemFlashbang;
import com.abstractlabs.toe.item.ItemGhostblade;
import com.abstractlabs.toe.item.ItemGrenade;
import com.abstractlabs.toe.item.ItemHollowLighter;
import com.abstractlabs.toe.item.ItemLockpick;
import com.abstractlabs.toe.item.ItemMagmaArmour;
import com.abstractlabs.toe.item.ItemNimbleArmour;
import com.abstractlabs.toe.item.ItemRecall;
import com.abstractlabs.toe.item.ItemTester;
import com.abstractlabs.toe.item.ItemToe;
import com.abstractlabs.toe.item.ItemToeAxe;
import com.abstractlabs.toe.item.ItemToeAxepick;
import com.abstractlabs.toe.item.ItemToePickaxe;
import com.abstractlabs.toe.item.ItemUndeadBatBone;
import com.abstractlabs.toe.reference.BoneType;
import com.abstractlabs.toe.reference.Thieving;

import cpw.mods.fml.common.registry.GameRegistry;

public class ToeItems {
	private static ArmorMaterial magmaMaterial = EnumHelper.addArmorMaterial("Magma Material", 33, new int[]{2, 5, 4, 2}, 10);
	private static ArmorMaterial nimbleMaterial = EnumHelper.addArmorMaterial("Nimble Material", 33, new int[]{2, 5, 4, 2}, 10);
	private static ArmorMaterial dynamicMaterial = EnumHelper.addArmorMaterial("Dynamic Material", 33, new int[]{2, 5, 4, 2}, 10);
	private static ToolMaterial caneMaterial = EnumHelper.addToolMaterial("Cane Material", 0, 300, 2.0F, 1.0F, 30);
	private static ToolMaterial specialMaterial = EnumHelper.addToolMaterial("Special", 3, 1561, 8.0F, 3.0F, 10);
	private static ToolMaterial veinMaterial = EnumHelper.addToolMaterial("Vein", 3, 1561, 8.0F, 3.0F, 10);
	private static ToolMaterial smeltingMaterial = EnumHelper.addToolMaterial("Smelting", 0, 1561, 8.0F, 3.0F, 10);
	private static ToolMaterial stripMaterial = EnumHelper.addToolMaterial("Strip", 3, 1561, 16.0F, 3.0F, 10);
	private static ToolMaterial timberMaterial = EnumHelper.addToolMaterial("Timber", 3, 1561, 8.0F, 3.0F, 10);
	
	public static Item flashbang = new ItemFlashbang().setUnlocalizedName("flashbang");
	public static Item grenade = new ItemGrenade().setUnlocalizedName("grenade");
	public static Item hollowLighter = new ItemHollowLighter().setUnlocalizedName("hollowLighter");
	public static Item arenalismLighter = new ItemArenalismLighter().setUnlocalizedName("arenalismLighter");
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
	public static Item undeadbatBone = new ItemUndeadBatBone(BoneType.boneLvl).setUnlocalizedName("undeadbatBone");
	public static Item ghostblade = new ItemGhostblade().setUnlocalizedName("ghostblade");
	public static Item crystal = new ItemToe().setUnlocalizedName("crystal");
	public static Item crystalIce = new ItemToe().setUnlocalizedName("crystalIce");
	
	public static Item magmaHelmet = new ItemMagmaArmour("magmaHelmet", magmaMaterial, "magmaHelmet", 0);
	public static Item magmaPlate = new ItemMagmaArmour("magmaPlate", magmaMaterial, "magmaPlate", 1);
	public static Item magmaPants = new ItemMagmaArmour("magmaPants", magmaMaterial, "magmaPants", 2);
	public static Item magmaBoots = new ItemMagmaArmour("magmaBoots", magmaMaterial, "magmaBoots", 3);
	public static Item nimbleHelmet = new ItemNimbleArmour("nimbleHelmet", nimbleMaterial, "nimbleHelmet", 0);
	public static Item nimblePlate = new ItemNimbleArmour("nimblePlate", nimbleMaterial, "nimblePlate", 1);
	public static Item nimblePants = new ItemNimbleArmour("nimblePants", nimbleMaterial, "nimblePants", 2);
	public static Item nimbleBoots = new ItemNimbleArmour("nimbleBoots", nimbleMaterial, "nimbleBoots", 3);
	public static Item dynamicHelmet = new ItemDynamicArmour("dynamicHelmet", dynamicMaterial, "dynamicHelmet", 0);
	public static Item dynamicPlate = new ItemDynamicArmour("dynamicPlate", dynamicMaterial, "dynamicPlate", 1);
	public static Item dynamicPants = new ItemDynamicArmour("dynamicPants", dynamicMaterial, "dynamicPants", 2);
	public static Item dynamicBoots = new ItemDynamicArmour("dynamicBoots", dynamicMaterial, "dynamicBoots", 3);
	
	public static void init() {
		//Weapons
		GameRegistry.registerItem(cane, "cane");
		GameRegistry.registerItem(ghostblade, "ghostblade");

		//Tools
		GameRegistry.registerItem(woodAxepick, "woodAxepick");
		GameRegistry.registerItem(goldAxepick, "goldAxepick");
		GameRegistry.registerItem(stoneAxepick, "stoneAxepick");
		GameRegistry.registerItem(ironAxepick, "ironAxepick");
		GameRegistry.registerItem(diamondAxepick, "diamondAxepick");
		GameRegistry.registerItem(woodAxepick_pick, "woodAxepick_pick");
		GameRegistry.registerItem(goldAxepick_pick, "goldAxepick_pick");
		GameRegistry.registerItem(stoneAxepick_pick, "stoneAxepick_pick");
		GameRegistry.registerItem(ironAxepick_pick, "ironAxepick_pick");
		GameRegistry.registerItem(diamondAxepick_pick, "diamondAxepick_pick");
		GameRegistry.registerItem(specialPickaxe, "specialPickaxe");
		GameRegistry.registerItem(veinPickaxe, "veinPickaxe");
		GameRegistry.registerItem(smeltingPickaxe, "smeltingPickaxe");
		GameRegistry.registerItem(stripPickaxe, "stripPickaxe");
		GameRegistry.registerItem(timberAxe, "timberAxe");
		
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
		
		//Coins
		GameRegistry.registerItem(coinCopper, "coinCopper");
		GameRegistry.registerItem(coinSilver, "coinSilver");
		GameRegistry.registerItem(coinGold, "coinGold");
		
		//Other
		GameRegistry.registerItem(hollowLighter, "hollowLighter");
		GameRegistry.registerItem(arenalismLighter, "arenalismLighter");
		GameRegistry.registerItem(ruby, "ruby");
		GameRegistry.registerItem(crystal, "crystal");
		GameRegistry.registerItem(crystalIce, "crystalIce");
		
		//Armor
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

		//To be removed
		GameRegistry.registerItem(tester, "testerItem");
	}
}