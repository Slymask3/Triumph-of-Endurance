package com.abstractlabs.toe.init;

import net.minecraftforge.common.MinecraftForge;

import com.abstractlabs.toe.handler.AxepickHandler;
import com.abstractlabs.toe.handler.BlockHandler;
import com.abstractlabs.toe.handler.ConfigHandler;
import com.abstractlabs.toe.handler.ConnectionHandler;
import com.abstractlabs.toe.handler.EntityHandler;
import com.abstractlabs.toe.handler.ItemToeSwordActiveHandler;
import com.abstractlabs.toe.handler.NBTRespawnHandler;
import com.abstractlabs.toe.handler.PlayerHandler;
import com.abstractlabs.toe.handler.PortalHandler;
import com.abstractlabs.toe.handler.TickHandler;
import com.abstractlabs.toe.handler.TooltipHandler;
import com.abstractlabs.toe.handler.skill.MiningHandler;
import com.abstractlabs.toe.handler.skill.PrayerHandler;
import com.abstractlabs.toe.handler.skill.RangedHandler;
import com.abstractlabs.toe.handler.skill.SmeltingHandler;
import com.abstractlabs.toe.handler.skill.WoodcuttingHandler;
import com.abstractlabs.toe.utility.LogHelper;

import cpw.mods.fml.common.FMLCommonHandler;

public class ToeBusses {
	public static void init() {
		addEventBus(new PlayerHandler());
		addEventBus(new BlockHandler());
		addEventBus(new EntityHandler());
		addEventBus(new MiningHandler());
		addEventBus(new WoodcuttingHandler());
		addEventBus(new PrayerHandler());
		addEventBus(new RangedHandler());
		addEventBus(new AxepickHandler());
		addEventBus(new PortalHandler());
		addEventBus(new ItemToeSwordActiveHandler());
		addEventBus(new TooltipHandler());
		
		addSpecialEventBus(new ConfigHandler());
		addSpecialEventBus(new ConnectionHandler());
		addSpecialEventBus(new TickHandler());
		addSpecialEventBus(new SmeltingHandler());
		
		addEventAndSpecialEventBus(new NBTRespawnHandler());
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
	
	private static void addEventAndSpecialEventBus(Object o) {
		MinecraftForge.EVENT_BUS.register(o);
		FMLCommonHandler.instance().bus().register(o);
		LogHelper.info("[ToeBusses] Registered event handler: " + o.getClass());
	}
}