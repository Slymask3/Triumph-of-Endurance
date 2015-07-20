package com.abstractlabs.toe.init;

import com.abstractlabs.toe.entity.monster.EntityAlien;
import com.abstractlabs.toe.entity.monster.EntityMummy;
import com.abstractlabs.toe.entity.monster.EntityScorpion;
import com.abstractlabs.toe.entity.npc.EntityDyer;
import com.abstractlabs.toe.entity.npc.EntityShopTest;
import com.abstractlabs.toe.entity.passive.EntityAlienCow;
import com.abstractlabs.toe.entity.passive.EntityBoi;

import cpw.mods.fml.common.registry.EntityRegistry;

public class ToeMobs {
	public static void init() {
		EntityRegistry.registerGlobalEntityID(EntityMummy.class, "Mummy", EntityRegistry.findGlobalUniqueEntityId(), getColor(255, 0, 0), getColor(0, 255, 0));
		EntityRegistry.registerGlobalEntityID(EntityScorpion.class, "Scorpion", EntityRegistry.findGlobalUniqueEntityId(), getColor(255, 255, 0), getColor(0, 0, 255));
		EntityRegistry.registerGlobalEntityID(EntityBoi.class, "Boi", EntityRegistry.findGlobalUniqueEntityId(), getColor(0, 255, 0), getColor(255, 0, 255));
		EntityRegistry.registerGlobalEntityID(EntityAlien.class, "Alien", EntityRegistry.findGlobalUniqueEntityId(), getColor(0, 255, 0), getColor(0, 100, 100));
		EntityRegistry.registerGlobalEntityID(EntityAlienCow.class, "AlienCow", EntityRegistry.findGlobalUniqueEntityId(), getColor(0, 255, 0), getColor(100, 0, 100));
		EntityRegistry.registerGlobalEntityID(EntityDyer.class, "Dyer", EntityRegistry.findGlobalUniqueEntityId(), 0x333333, 0x00FF00);
		EntityRegistry.registerGlobalEntityID(EntityShopTest.class, "ShopTest", EntityRegistry.findGlobalUniqueEntityId(), 0xFFFF00, 0x0000FF);
	}
	
	private static int getColor(int r, int g, int b) {
		return (r << 16) + (g << 8) + b;
	}
}