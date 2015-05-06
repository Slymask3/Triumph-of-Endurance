package com.abstractlabs.toe.init;

import net.minecraft.client.model.ModelZombie;

import com.abstractlabs.toe.Toe;
import com.abstractlabs.toe.entity.monster.EntityMummy;
import com.abstractlabs.toe.entity.projectile.EntityFlashbang;
import com.abstractlabs.toe.entity.projectile.EntityGrenade;
import com.abstractlabs.toe.render.RenderMummy;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;

public class ToeRenders {
	public static void init() {
		EntityRegistry.registerModEntity(EntityFlashbang.class, "Flashbang", 1, Toe.instance, 64, 10, true);
		EntityRegistry.registerModEntity(EntityGrenade.class, "Grenade", 2, Toe.instance, 64, 10, true);
		
		RenderingRegistry.registerEntityRenderingHandler(EntityMummy.class, new RenderMummy(new ModelZombie(), 0.5F));
	}
}
