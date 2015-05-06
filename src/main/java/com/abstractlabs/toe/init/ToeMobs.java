package com.abstractlabs.toe.init;

import com.abstractlabs.toe.Toe;
import com.abstractlabs.toe.entity.monster.EntityMummy;
import com.abstractlabs.toe.entity.projectile.EntityFlashbang;
import com.abstractlabs.toe.entity.projectile.EntityGrenade;

import cpw.mods.fml.common.registry.EntityRegistry;

public class ToeMobs {
	public static void init() {
		EntityRegistry.registerGlobalEntityID(EntityMummy.class, "Mummy", EntityRegistry.findGlobalUniqueEntityId(), getColor(255, 0, 0), getColor(0, 255, 0));
	}
	
	private static int getColor(int r, int g, int b) {
		return (r << 16) + (g << 8) + b;
	}
}