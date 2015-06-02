package com.abstractlabs.toe.proxy;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelZombie;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.common.MinecraftForge;

import org.lwjgl.input.Keyboard;

import com.abstractlabs.toe.entity.monster.EntityMummy;
import com.abstractlabs.toe.entity.monster.EntityScorpion;
import com.abstractlabs.toe.entity.passive.EntityBoi;
import com.abstractlabs.toe.entity.projectile.EntityFlashbang;
import com.abstractlabs.toe.entity.projectile.EntityGrenade;
import com.abstractlabs.toe.gui.GuiArenaOverlay;
import com.abstractlabs.toe.handler.KeyHandler;
import com.abstractlabs.toe.init.ToeItems;
import com.abstractlabs.toe.model.ModelScorpion;
import com.abstractlabs.toe.renderer.RenderBoi;
import com.abstractlabs.toe.renderer.RenderFlashbang;
import com.abstractlabs.toe.renderer.RenderGrenade;
import com.abstractlabs.toe.renderer.RenderLandmine;
import com.abstractlabs.toe.renderer.RenderLockedChest;
import com.abstractlabs.toe.renderer.RenderMummy;
import com.abstractlabs.toe.renderer.RenderScorpion;
import com.abstractlabs.toe.skill.DescriptionGUI;
import com.abstractlabs.toe.skill.agility.AgilityGUI;
import com.abstractlabs.toe.skill.arenalism.ArenalismGUI;
import com.abstractlabs.toe.skill.brewing.BrewingGUI;
import com.abstractlabs.toe.skill.cooking.CookingGUI;
import com.abstractlabs.toe.skill.farming.FarmingGUI;
import com.abstractlabs.toe.skill.fishing.FishingGUI;
import com.abstractlabs.toe.skill.magic.MagicGUI;
import com.abstractlabs.toe.skill.mining.MiningGUI;
import com.abstractlabs.toe.skill.prayer.PrayerGUI;
import com.abstractlabs.toe.skill.ranged.RangedGUI;
import com.abstractlabs.toe.skill.runemaking.RunemakingGUI;
import com.abstractlabs.toe.skill.slayer.SlayerGUI;
import com.abstractlabs.toe.skill.smelting.SmeltingGUI;
import com.abstractlabs.toe.skill.swords.SwordsGUI;
import com.abstractlabs.toe.skill.theiving.ThievingGUI;
import com.abstractlabs.toe.skill.woodcutting.WoodcuttingGUI;
import com.abstractlabs.toe.tileentity.TileEntityLandmine;
import com.abstractlabs.toe.tileentity.TileEntityLockedChest;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;

public class ClientProxy extends CommonProxy {
	public static KeyBinding[] keyBindings;
	
	@Override
	public void registerInformation() {
		MinecraftForge.EVENT_BUS.register(new SwordsGUI());
		MinecraftForge.EVENT_BUS.register(new RangedGUI());
		MinecraftForge.EVENT_BUS.register(new MagicGUI());
		MinecraftForge.EVENT_BUS.register(new MiningGUI());
		MinecraftForge.EVENT_BUS.register(new WoodcuttingGUI());
		MinecraftForge.EVENT_BUS.register(new FishingGUI());
		MinecraftForge.EVENT_BUS.register(new FarmingGUI());
		MinecraftForge.EVENT_BUS.register(new CookingGUI());
		MinecraftForge.EVENT_BUS.register(new SmeltingGUI());
		MinecraftForge.EVENT_BUS.register(new BrewingGUI());
		MinecraftForge.EVENT_BUS.register(new RunemakingGUI());
		MinecraftForge.EVENT_BUS.register(new PrayerGUI());
		MinecraftForge.EVENT_BUS.register(new SlayerGUI());
		MinecraftForge.EVENT_BUS.register(new AgilityGUI());
		MinecraftForge.EVENT_BUS.register(new ThievingGUI());
		MinecraftForge.EVENT_BUS.register(new ArenalismGUI());
		
		MinecraftForge.EVENT_BUS.register(new DescriptionGUI());
		MinecraftForge.EVENT_BUS.register(new GuiArenaOverlay());
		
		RenderingRegistry.registerEntityRenderingHandler(EntityFlashbang.class, new RenderFlashbang(ToeItems.flashbang));
		RenderingRegistry.registerEntityRenderingHandler(EntityGrenade.class, new RenderGrenade(ToeItems.grenade));

		RenderingRegistry.registerEntityRenderingHandler(EntityMummy.class, new RenderMummy(new ModelZombie(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityScorpion.class, new RenderScorpion(new ModelScorpion(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityBoi.class, new RenderBoi(new ModelBiped(), 0.5F));

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityLockedChest.class, new RenderLockedChest());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityLandmine.class, new RenderLandmine());
		
		registerKeys();
		
		FMLCommonHandler.instance().bus().register(new KeyHandler());
	}
	
	public int addArmor(String armor){
		return RenderingRegistry.addNewArmourRendererPrefix(armor);
	}
	
	private void registerKeys() {
		keyBindings = new KeyBinding[3]; 

		keyBindings[0] = new KeyBinding("key.hud.desc1", Keyboard.KEY_P, "key.toe.category");
		keyBindings[1] = new KeyBinding("key.hud.desc2", Keyboard.KEY_LEFT, "key.toe.category");
		keyBindings[2] = new KeyBinding("key.hud.desc3", Keyboard.KEY_RIGHT, "key.toe.category");
		
		for (int i = 0; i < keyBindings.length; ++i) {
		    ClientRegistry.registerKeyBinding(keyBindings[i]);
		}
	}
}
