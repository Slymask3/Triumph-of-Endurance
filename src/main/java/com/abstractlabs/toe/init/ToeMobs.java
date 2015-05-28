package com.abstractlabs.toe.init;

import com.abstractlabs.toe.entity.monster.EntityMummy;
import com.abstractlabs.toe.entity.monster.EntityScorpion;
import com.abstractlabs.toe.entity.passive.EntityBoi;

import cpw.mods.fml.common.registry.EntityRegistry;

public class ToeMobs {
	public static void init() {
		EntityRegistry.registerGlobalEntityID(EntityMummy.class, "Mummy", EntityRegistry.findGlobalUniqueEntityId(), getColor(255, 0, 0), getColor(0, 255, 0));
		EntityRegistry.registerGlobalEntityID(EntityScorpion.class, "Scorpion", EntityRegistry.findGlobalUniqueEntityId(), getColor(255, 255, 0), getColor(0, 0, 255));
		EntityRegistry.registerGlobalEntityID(EntityBoi.class, "Boi", EntityRegistry.findGlobalUniqueEntityId(), getColor(0, 255, 0), getColor(255, 0, 255));
	}
	
	private static int getColor(int r, int g, int b) {
		return (r << 16) + (g << 8) + b;
	}
}