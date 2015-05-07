package com.abstractlabs.toe.init;

import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

import com.abstractlabs.toe.item.ItemFlashbang;
import com.abstractlabs.toe.item.ItemGrenade;
import com.abstractlabs.toe.item.ItemMagmaArmour;
import com.abstractlabs.toe.item.ItemNimbleArmour;

import cpw.mods.fml.common.registry.GameRegistry;

public class ToeItems {
	public static Item flashbang = new ItemFlashbang().setUnlocalizedName("flashbang");
	public static Item grenade = new ItemGrenade().setUnlocalizedName("grenade");
	
	public static ArmorMaterial magmaMaterial = EnumHelper.addArmorMaterial("Magma Material", 33, new int[]{2, 5, 4, 2}, 10);
	
	public static ArmorMaterial nimbleMaterial = EnumHelper.addArmorMaterial("Nimble Material", 33, new int[]{2,  5, 4, 2}, 10);
	
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
	
	public static void init() {
		GameRegistry.registerItem(flashbang, "flashbang");
		GameRegistry.registerItem(grenade, "grenade");
		
		// MAGMA ARMOUR
		GameRegistry.registerItem(magmaHelmet = new ItemMagmaArmour("magmaHelmet", magmaMaterial, "Magma Armour", 0), "magmaHelmet"); //0 for helmet
		GameRegistry.registerItem(magmaPlate = new ItemMagmaArmour("magmaPlate", magmaMaterial, "Magma Armour", 1), "magmaPlate"); // 1 for chestplate
		GameRegistry.registerItem(magmaPants = new ItemMagmaArmour("magmaPants", magmaMaterial, "Magma Armour", 2), "magmaPants"); // 2 for leggings
		GameRegistry.registerItem(magmaBoots = new ItemMagmaArmour("magmaBoots", magmaMaterial, "Magma Armour", 3), "magmaBoots"); // 3 for boots
		
		// NIMBLE ARMOUR
		GameRegistry.registerItem(nimbleHelmet = new ItemNimbleArmour("nimbleHelmet", nimbleMaterial, "Nimble Armour", 0), "nimbleHelmet");
		GameRegistry.registerItem(nimblePlate = new ItemNimbleArmour("nimblePlate", nimbleMaterial, "Nimble Armour", 1), "nimblePlate");
		GameRegistry.registerItem(nimblePants = new ItemNimbleArmour("nimblePants", nimbleMaterial, "Nimble Armour", 2), "nimblePants");
		GameRegistry.registerItem(nimbleBoots = new ItemNimbleArmour("nimbleBoots", nimbleMaterial, "Nimble Armour", 3), "nimbleBoots");
	}
}