package com.abstractlabs.toe.proxy;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelZombie;
import net.minecraftforge.common.MinecraftForge;

import com.abstractlabs.toe.entity.monster.EntityMummy;
import com.abstractlabs.toe.entity.monster.EntityScorpion;
import com.abstractlabs.toe.entity.passive.EntityBoi;
import com.abstractlabs.toe.entity.projectile.EntityFlashbang;
import com.abstractlabs.toe.entity.projectile.EntityGrenade;
import com.abstractlabs.toe.gui.GuiArenaOverlay;
import com.abstractlabs.toe.init.ToeItems;
import com.abstractlabs.toe.model.ModelScorpion;
import com.abstractlabs.toe.renderer.RenderBoi;
import com.abstractlabs.toe.renderer.RenderFlashbang;
import com.abstractlabs.toe.renderer.RenderGrenade;
import com.abstractlabs.toe.renderer.RenderLandmine;
import com.abstractlabs.toe.renderer.RenderLockedChest;
import com.abstractlabs.toe.renderer.RenderMummy;
import com.abstractlabs.toe.renderer.RenderScorpion;
import com.abstractlabs.toe.skill.arenalism.ArenalismGUI;
import com.abstractlabs.toe.skill.mining.MiningGUI;
import com.abstractlabs.toe.skill.theiving.ThievingGUI;
import com.abstractlabs.toe.skill.woodcutting.WoodcuttingGUI;
import com.abstractlabs.toe.tileentity.TileEntityLandmine;
import com.abstractlabs.toe.tileentity.TileEntityLockedChest;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {
	@Override
	public void registerInformation() {
		MinecraftForge.EVENT_BUS.register(new ArenalismGUI());
		MinecraftForge.EVENT_BUS.register(new MiningGUI());
		MinecraftForge.EVENT_BUS.register(new WoodcuttingGUI());
		MinecraftForge.EVENT_BUS.register(new ThievingGUI());
		MinecraftForge.EVENT_BUS.register(new GuiArenaOverlay());
		
		RenderingRegistry.registerEntityRenderingHandler(EntityFlashbang.class, new RenderFlashbang(ToeItems.flashbang));
		RenderingRegistry.registerEntityRenderingHandler(EntityGrenade.class, new RenderGrenade(ToeItems.grenade));

		RenderingRegistry.registerEntityRenderingHandler(EntityMummy.class, new RenderMummy(new ModelZombie(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityScorpion.class, new RenderScorpion(new ModelScorpion(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityBoi.class, new RenderBoi(new ModelBiped(), 0.5F));

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityLockedChest.class, new RenderLockedChest());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityLandmine.class, new RenderLandmine());
	}
	
	public int addArmor(String armor){
		return RenderingRegistry.addNewArmourRendererPrefix(armor);
	}
}
