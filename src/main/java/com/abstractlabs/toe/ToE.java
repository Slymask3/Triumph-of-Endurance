package com.abstractlabs.toe;

import net.minecraft.tileentity.TileEntity;

import com.abstractlabs.toe.gui.GuiHandler;
import com.abstractlabs.toe.init.ToeBlocks;
import com.abstractlabs.toe.init.ToeItems;
import com.abstractlabs.toe.network.PacketPipeline;
import com.abstractlabs.toe.reference.Reference;
import com.abstractlabs.toe.tileentity.TileEntityWeaponry;
import com.abstractlabs.toe.utility.LogHelper;
import com.abstractlabs.toe.worldgen.WorldGeneratorToe;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid=Reference.MOD_ID, name=Reference.MOD_NAME, version=Reference.VERSION)
public class Toe {
	@Instance(Reference.MOD_ID)
	public static Toe instance = new Toe();
	
	public static final PacketPipeline packetPipeline = new PacketPipeline();
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());
		
		TileEntity.addMapping(TileEntityWeaponry.class, "TileEntityWeaponry");
		
		packetPipeline.initialise();
		
		ToeBlocks.init();
		ToeItems.init();
		
		LogHelper.info("Pre Initialization Complete!");
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		GameRegistry.registerWorldGenerator(new WorldGeneratorToe(), 1);
		
		LogHelper.info("Initialization Complete!");
	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		LogHelper.info("Post Initialization Complete!");
	}
}