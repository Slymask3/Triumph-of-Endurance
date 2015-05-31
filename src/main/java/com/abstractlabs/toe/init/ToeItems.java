package com.abstractlabs.toe.init;

import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

import com.abstractlabs.toe.item.ItemArenalismLighter;
import com.abstractlabs.toe.item.ItemCane;
import com.abstractlabs.toe.item.ItemDynamicArmour;
import com.abstractlabs.toe.item.ItemFlashbang;
import com.abstractlabs.toe.item.ItemGrenade;
import com.abstractlabs.toe.item.ItemHollowLighter;
import com.abstractlabs.toe.item.ItemLockpick;
import com.abstractlabs.toe.item.ItemMagmaArmour;
import com.abstractlabs.toe.item.ItemNimbleArmour;
import com.abstractlabs.toe.item.ItemRecall;

import cpw.mods.fml.common.registry.GameRegistry;

public class ToeItems {
	public static Item flashbang = new ItemFlashbang().setUnlocalizedName("flashbang");
	public static Item grenade = new ItemGrenade().setUnlocalizedName("grenade");
	public static Item hollowLighter = new ItemHollowLighter().setUnlocalizedName("hollowLighter");
	public static Item arenalismLighter = new ItemArenalismLighter().setUnlocalizedName("arenalismLighter");
	public static Item recall = new ItemRecall().setUnlocalizedName("recall");
	public static Item lockpick = new ItemLockpick(10).setUnlocalizedName("lockpick");
	
	public static ArmorMaterial magmaMaterial = EnumHelper.addArmorMaterial("Magma Material", 33, new int[]{2, 5, 4, 2}, 10);
	
	public static ArmorMaterial nimbleMaterial = EnumHelper.addArmorMaterial("Nimble Material", 33, new int[]{2,  5, 4, 2}, 10);
	
	public static ArmorMaterial dynamicMaterial = EnumHelper.addArmorMaterial("Dynamic Material", 33, new int[]{2,  5, 4, 2}, 10);
	
	public static ToolMaterial caneMaterial = EnumHelper.addToolMaterial("Cane Material", 0, 300, 2.0F, -4.0F, 30);
	
	// MAGMA ARMOUR
	public static Item magmaHelmet;
	public static Item magmaPlate;
	public static Item magmaPants;
	public static Item magmaBoots;
	
	// NIMBLE ARMOUR
	public static Item nimbleHelmet;
	public static Item nimblePlate;
	public static Item nimblePants;
	public static Item nimbleBoots;
	
	// DYNAMIC ARMOUR
	public static Item dynamicHelmet;
	public static Item dynamicPlate;
	public static Item dynamicPants;
	public static Item dynamicBoots;
	
	// THE CANE
	public static Item cane;
	
	public static void init() {
		GameRegistry.registerItem(flashbang, "flashbang");
		GameRegistry.registerItem(grenade, "grenade");
		GameRegistry.registerItem(hollowLighter, "hollowLighter");
		GameRegistry.registerItem(arenalismLighter, "arenalismLighter");
		GameRegistry.registerItem(recall, "recall");
		GameRegistry.registerItem(lockpick, "lockpick");
		
		// MAGMA ARMOUR
		GameRegistry.registerItem(magmaHelmet = new ItemMagmaArmour("magmaHelmet", magmaMaterial, "magmaHelmet", 0), "magmaHelmet"); //0 for helmet
		GameRegistry.registerItem(magmaPlate = new ItemMagmaArmour("magmaPlate", magmaMaterial, "magmaPlate", 1), "magmaPlate"); // 1 for chestplate
		GameRegistry.registerItem(magmaPants = new ItemMagmaArmour("magmaPants", magmaMaterial, "magmaPants", 2), "magmaPants"); // 2 for leggings
		GameRegistry.registerItem(magmaBoots = new ItemMagmaArmour("magmaBoots", magmaMaterial, "magmaBoots", 3), "magmaBoots"); // 3 for boots
		
		// NIMBLE ARMOUR
		GameRegistry.registerItem(nimbleHelmet = new ItemNimbleArmour("nimbleHelmet", nimbleMaterial, "nimbleHelmet", 0), "nimbleHelmet");
		GameRegistry.registerItem(nimblePlate = new ItemNimbleArmour("nimblePlate", nimbleMaterial, "nimblePlate", 1), "nimblePlate");
		GameRegistry.registerItem(nimblePants = new ItemNimbleArmour("nimblePants", nimbleMaterial, "nimblePants", 2), "nimblePants");
		GameRegistry.registerItem(nimbleBoots = new ItemNimbleArmour("nimbleBoots", nimbleMaterial, "nimbleBoots", 3), "nimbleBoots");
		
		// DYNAMIC ARMOUR
		GameRegistry.registerItem(dynamicHelmet = new ItemDynamicArmour("dynamicHelmet", dynamicMaterial, "dynamicHelmet", 0), "dynamicHelmet");
		GameRegistry.registerItem(dynamicPlate = new ItemDynamicArmour("dynamicPlate", dynamicMaterial, "dynamicPlate", 1), "dynamicPlate");
		GameRegistry.registerItem(dynamicPants = new ItemDynamicArmour("dynamicPants", dynamicMaterial, "dynamicPants", 2), "dynamicPants");
		GameRegistry.registerItem(dynamicBoots = new ItemDynamicArmour("dynamicBoots", dynamicMaterial, "dynamicBoots", 3), "dynamicBoots");
		
		// THE CANE
		GameRegistry.registerItem(cane = new ItemCane("cane", caneMaterial), "cane");
	}
}