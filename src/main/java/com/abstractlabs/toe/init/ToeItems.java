package com.abstractlabs.toe.init;

import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

import com.abstractlabs.toe.item.ItemArenalismLighter;
import com.abstractlabs.toe.item.ItemUndeadBatBone;
import com.abstractlabs.toe.item.ItemCane;
import com.abstractlabs.toe.item.ItemDynamicArmour;
import com.abstractlabs.toe.item.ItemFlashbang;
import com.abstractlabs.toe.item.ItemGrenade;
import com.abstractlabs.toe.item.ItemHollowLighter;
import com.abstractlabs.toe.item.ItemLockpick;
import com.abstractlabs.toe.item.ItemMagmaArmour;
import com.abstractlabs.toe.item.ItemNimbleArmour;
import com.abstractlabs.toe.item.ItemRecall;
import com.abstractlabs.toe.item.ItemTester;
import com.abstractlabs.toe.item.ItemToe;
import com.abstractlabs.toe.reference.BoneType;
import com.abstractlabs.toe.reference.Thieving;

import cpw.mods.fml.common.registry.GameRegistry;

public class ToeItems {
	public static ArmorMaterial magmaMaterial = EnumHelper.addArmorMaterial("Magma Material", 33, new int[]{2, 5, 4, 2}, 10);
	public static ArmorMaterial nimbleMaterial = EnumHelper.addArmorMaterial("Nimble Material", 33, new int[]{2, 5, 4, 2}, 10);
	public static ArmorMaterial dynamicMaterial = EnumHelper.addArmorMaterial("Dynamic Material", 33, new int[]{2, 5, 4, 2}, 10);
	public static ToolMaterial caneMaterial = EnumHelper.addToolMaterial("Cane Material", 0, 300, 2.0F, 1.0F, 30);
	
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
	public static Item undeadbatBone = new ItemUndeadBatBone(BoneType.boneLvl).setUnlocalizedName("undeadbatBone");
	
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
		GameRegistry.registerItem(flashbang, "flashbang");
		GameRegistry.registerItem(grenade, "grenade");
		GameRegistry.registerItem(hollowLighter, "hollowLighter");
		GameRegistry.registerItem(arenalismLighter, "arenalismLighter");
		GameRegistry.registerItem(recall, "recall");
		GameRegistry.registerItem(paperclip, "paperclip");
		GameRegistry.registerItem(lockpick, "lockpick");
		GameRegistry.registerItem(masterKey, "masterKey");
		GameRegistry.registerItem(tester, "testerItem");
		GameRegistry.registerItem(cane, "cane");
		GameRegistry.registerItem(coinCopper, "coinCopper");
		GameRegistry.registerItem(coinSilver, "coinSilver");
		GameRegistry.registerItem(coinGold, "coinGold");
		GameRegistry.registerItem(undeadbatBone, "undeadbatBone");
		
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
	}
}