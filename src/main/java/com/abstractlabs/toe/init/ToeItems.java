package com.abstractlabs.toe.init;

import net.minecraft.item.Item;

import com.abstractlabs.toe.item.ItemFlashbang;
import com.abstractlabs.toe.item.ItemGrenade;

import cpw.mods.fml.common.registry.GameRegistry;

public class ToeItems {
	public static Item flashbang = new ItemFlashbang().setUnlocalizedName("flashbang");
	public static Item grenade = new ItemGrenade().setUnlocalizedName("grenade");
	
	public static void init() {
		GameRegistry.registerItem(flashbang, "flashbang");
		GameRegistry.registerItem(grenade, "grenade");
	}
}