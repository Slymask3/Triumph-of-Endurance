package com.abstractlabs.toe.init;

import com.abstractlabs.toe.Toe;
import com.abstractlabs.toe.entity.player.EntityHat;
import com.abstractlabs.toe.entity.projectile.EntityFlashbang;
import com.abstractlabs.toe.entity.projectile.EntityGrapplingHook;
import com.abstractlabs.toe.entity.projectile.EntityGrenade;
import com.abstractlabs.toe.entity.projectile.EntityToeArrow;

import cpw.mods.fml.common.registry.EntityRegistry;

public class ToeRenders {
	public static void init() {
		EntityRegistry.registerModEntity(EntityFlashbang.class, "Flashbang", 1, Toe.instance, 64, 10, true);
		EntityRegistry.registerModEntity(EntityGrenade.class, "Grenade", 2, Toe.instance, 64, 10, true);
		EntityRegistry.registerModEntity(EntityToeArrow.class, "Arrow", 3, Toe.instance, 64, 10, true);
		//EntityRegistry.registerModEntity(EntityFishingHook.class, "Better Fishhook", 216, Toe.instance, 75, 1, true);
		EntityRegistry.registerModEntity(EntityHat.class, "ToeHat", 67, Toe.instance, 64, 10, true);
		EntityRegistry.registerModEntity(EntityGrapplingHook.class, "GrapplingHook", 321, Toe.instance, 64, 10, true);
	}
}