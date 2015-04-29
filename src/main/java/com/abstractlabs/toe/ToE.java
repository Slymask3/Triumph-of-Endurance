package com.abstractlabs.toe;

import com.abstractlabs.toe.init.ToeBlocks;
import com.abstractlabs.toe.init.ToeItems;
import com.abstractlabs.toe.reference.Reference;
import com.abstractlabs.toe.utility.LogHelper;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid=Reference.MOD_ID, name=Reference.MOD_NAME, version=Reference.VERSION)
public class Toe {
	@Instance(Reference.MOD_ID)
	public static Toe instance = new Toe();
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		ToeBlocks.init();
		ToeItems.init();
		
		LogHelper.info("Pre Initialization Complete!");
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		LogHelper.info("Initialization Complete!");
	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		LogHelper.info("Post Initialization Complete!");
	}
}