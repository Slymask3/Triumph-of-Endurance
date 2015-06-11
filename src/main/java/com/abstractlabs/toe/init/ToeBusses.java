package com.abstractlabs.toe.init;

import net.minecraftforge.common.MinecraftForge;

import com.abstractlabs.toe.handler.BlockHandler;
import com.abstractlabs.toe.handler.ConfigHandler;
import com.abstractlabs.toe.handler.ConnectionHandler;
import com.abstractlabs.toe.handler.EntityHandler;
import com.abstractlabs.toe.handler.MobHandler;
import com.abstractlabs.toe.handler.PlayerHandler;
import com.abstractlabs.toe.handler.PrayerHandler;
import com.abstractlabs.toe.handler.TickHandler;
import com.abstractlabs.toe.utility.LogHelper;

import cpw.mods.fml.common.FMLCommonHandler;

public class ToeBusses {
	public static void init() {
		addEventBus(new PlayerHandler());
		addEventBus(new MobHandler());
		addEventBus(new BlockHandler());
		addEventBus(new EntityHandler());
		addEventBus(new PrayerHandler());
		
		addSpecialEventBus(new ConfigHandler());
		addSpecialEventBus(new ConnectionHandler());
		addSpecialEventBus(new TickHandler());
	}
	
	private static void addEventBus(Object o) {
		MinecraftForge.EVENT_BUS.register(o);
		LogHelper.info("[ToeBusses] Registered event handler: " + o.getClass());
	}
	
	private static void addSpecialEventBus(Object o) {
		FMLCommonHandler.instance().bus().register(o);
		LogHelper.info("[ToeBusses] Registered event handler: " + o.getClass());
	}
	
	private static void addTerrainEventBus(Object o) {
		MinecraftForge.TERRAIN_GEN_BUS.register(o);
		LogHelper.info("[ToeBusses] Registered event handler: " + o.getClass());
	}
}