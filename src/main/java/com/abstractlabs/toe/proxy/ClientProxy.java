package com.abstractlabs.toe.proxy;

import java.lang.reflect.Field;
import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelCow;
import net.minecraft.client.model.ModelZombie;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;

import org.lwjgl.input.Keyboard;

import com.abstractlabs.toe.client.gui.screen.GuiArenaOverlay;
import com.abstractlabs.toe.client.gui.screen.GuiScreenOverlay;
import com.abstractlabs.toe.client.model.ModelScorpion;
import com.abstractlabs.toe.client.renderer.entity.RenderFlashbang;
import com.abstractlabs.toe.client.renderer.entity.RenderGrapplingHook;
import com.abstractlabs.toe.client.renderer.entity.RenderGrenade;
import com.abstractlabs.toe.client.renderer.entity.RenderHat;
import com.abstractlabs.toe.client.renderer.entity.mob.RenderAlien;
import com.abstractlabs.toe.client.renderer.entity.mob.RenderAlienCow;
import com.abstractlabs.toe.client.renderer.entity.mob.RenderBoi;
import com.abstractlabs.toe.client.renderer.entity.mob.RenderDyer;
import com.abstractlabs.toe.client.renderer.entity.mob.RenderMummy;
import com.abstractlabs.toe.client.renderer.entity.mob.RenderScorpion;
import com.abstractlabs.toe.client.renderer.entity.mob.RenderShopTest;
import com.abstractlabs.toe.client.renderer.item.ItemRenderAxepick;
import com.abstractlabs.toe.client.renderer.item.ItemRenderClaw;
import com.abstractlabs.toe.client.renderer.item.ItemRenderFishingRod;
import com.abstractlabs.toe.client.renderer.item.ItemRenderLunarBlade;
import com.abstractlabs.toe.client.renderer.item.ItemRenderRecall;
import com.abstractlabs.toe.client.renderer.item.ItemRenderStatueBiped;
import com.abstractlabs.toe.client.renderer.tileentity.RenderATM;
import com.abstractlabs.toe.client.renderer.tileentity.RenderDisplayCase;
import com.abstractlabs.toe.client.renderer.tileentity.RenderFurnaceDiamond;
import com.abstractlabs.toe.client.renderer.tileentity.RenderFurnaceEmerald;
import com.abstractlabs.toe.client.renderer.tileentity.RenderFurnaceGold;
import com.abstractlabs.toe.client.renderer.tileentity.RenderFurnaceIron;
import com.abstractlabs.toe.client.renderer.tileentity.RenderFurnaceRedstone;
import com.abstractlabs.toe.client.renderer.tileentity.RenderLandmine;
import com.abstractlabs.toe.client.renderer.tileentity.RenderLockedChest;
import com.abstractlabs.toe.client.renderer.tileentity.RenderPedestal;
import com.abstractlabs.toe.client.renderer.tileentity.RenderStatueBiped;
import com.abstractlabs.toe.client.renderer.tileentity.RenderTransmutation;
import com.abstractlabs.toe.entity.monster.EntityAlien;
import com.abstractlabs.toe.entity.monster.EntityMummy;
import com.abstractlabs.toe.entity.monster.EntityScorpion;
import com.abstractlabs.toe.entity.npc.EntityDyer;
import com.abstractlabs.toe.entity.npc.EntityShopTest;
import com.abstractlabs.toe.entity.passive.EntityAlienCow;
import com.abstractlabs.toe.entity.passive.EntityBoi;
import com.abstractlabs.toe.entity.player.EntityHat;
import com.abstractlabs.toe.entity.projectile.EntityFlashbang;
import com.abstractlabs.toe.entity.projectile.EntityGrapplingHook;
import com.abstractlabs.toe.entity.projectile.EntityGrenade;
import com.abstractlabs.toe.handler.KeyHandler;
import com.abstractlabs.toe.handler.PlayerRenderHandler;
import com.abstractlabs.toe.handler.ResourceLoc;
import com.abstractlabs.toe.init.ToeItems;
import com.abstractlabs.toe.reference.RenderID;
import com.abstractlabs.toe.reference.Smelting;
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
import com.abstractlabs.toe.tileentity.TileEntityATM;
import com.abstractlabs.toe.tileentity.TileEntityDisplayCase;
import com.abstractlabs.toe.tileentity.TileEntityLandmine;
import com.abstractlabs.toe.tileentity.TileEntityLockedChest;
import com.abstractlabs.toe.tileentity.TileEntityPedestal;
import com.abstractlabs.toe.tileentity.TileEntityStatueBiped;

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
		MinecraftForge.EVENT_BUS.register(new GuiScreenOverlay());
		MinecraftForge.EVENT_BUS.register(new PlayerRenderHandler());
		
		RenderingRegistry.registerEntityRenderingHandler(EntityFlashbang.class, new RenderFlashbang(ToeItems.flashbang));
		RenderingRegistry.registerEntityRenderingHandler(EntityGrenade.class, new RenderGrenade(ToeItems.grenade));

		RenderingRegistry.registerEntityRenderingHandler(EntityMummy.class, new RenderMummy(new ModelZombie(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityScorpion.class, new RenderScorpion(new ModelScorpion(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityBoi.class, new RenderBoi(new ModelBiped(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityAlien.class, new RenderAlien(new ModelBiped(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityAlienCow.class, new RenderAlienCow(new ModelCow(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityDyer.class, new RenderDyer(new ModelBiped(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityShopTest.class, new RenderShopTest(new ModelBiped(), 0.5F));

		RenderingRegistry.registerEntityRenderingHandler(EntityHat.class, new RenderHat());
		RenderingRegistry.registerEntityRenderingHandler(EntityGrapplingHook.class, new RenderGrapplingHook());
		
		RenderingRegistry.registerBlockHandler(Smelting.furnaceRenderID_Iron, new RenderFurnaceIron());
		RenderingRegistry.registerBlockHandler(Smelting.furnaceRenderID_Gold, new RenderFurnaceGold());
		RenderingRegistry.registerBlockHandler(Smelting.furnaceRenderID_Diamond, new RenderFurnaceDiamond());
		RenderingRegistry.registerBlockHandler(Smelting.furnaceRenderID_Emerald, new RenderFurnaceEmerald());
		RenderingRegistry.registerBlockHandler(Smelting.furnaceRenderID_Redstone, new RenderFurnaceRedstone());

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityLockedChest.class, new RenderLockedChest());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityLandmine.class, new RenderLandmine());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityStatueBiped.class, new RenderStatueBiped());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityATM.class, new RenderATM());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDisplayCase.class, new RenderDisplayCase());
		//ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPedestalStonebrick.class, new RenderPedestalStonebrick());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPedestal.class, new RenderPedestal());

		RenderingRegistry.registerBlockHandler(RenderID.landmine, new RenderLandmine());
		RenderingRegistry.registerBlockHandler(RenderID.atm, new RenderATM());
		RenderingRegistry.registerBlockHandler(RenderID.displayCase, new RenderDisplayCase());
        //RenderingRegistry.registerBlockHandler(RenderID.pedestal, new RenderPedestalStonebrick());
        RenderingRegistry.registerBlockHandler(RenderID.pedestal, new RenderPedestal());
        RenderingRegistry.registerBlockHandler(RenderID.statueBiped, new RenderStatueBiped());
		
		MinecraftForgeClient.registerItemRenderer(ToeItems.fishingRodWood, new ItemRenderFishingRod());
		MinecraftForgeClient.registerItemRenderer(ToeItems.fishingRodGold, new ItemRenderFishingRod());

		MinecraftForgeClient.registerItemRenderer(ToeItems.woodAxepick, new ItemRenderAxepick());
		MinecraftForgeClient.registerItemRenderer(ToeItems.goldAxepick, new ItemRenderAxepick());
		MinecraftForgeClient.registerItemRenderer(ToeItems.stoneAxepick, new ItemRenderAxepick());
		MinecraftForgeClient.registerItemRenderer(ToeItems.ironAxepick, new ItemRenderAxepick());
		MinecraftForgeClient.registerItemRenderer(ToeItems.diamondAxepick, new ItemRenderAxepick());
		MinecraftForgeClient.registerItemRenderer(ToeItems.emeraldAxepick, new ItemRenderAxepick());
		MinecraftForgeClient.registerItemRenderer(ToeItems.rubyAxepick, new ItemRenderAxepick());
		MinecraftForgeClient.registerItemRenderer(ToeItems.sapphireAxepick, new ItemRenderAxepick());

		MinecraftForgeClient.registerItemRenderer(ToeItems.recall, new ItemRenderRecall());
		MinecraftForgeClient.registerItemRenderer(ToeItems.lunarBlade, new ItemRenderLunarBlade());

		MinecraftForgeClient.registerItemRenderer(ToeItems.woodClaw, new ItemRenderClaw());
		MinecraftForgeClient.registerItemRenderer(ToeItems.stoneClaw, new ItemRenderClaw());
		MinecraftForgeClient.registerItemRenderer(ToeItems.ironClaw, new ItemRenderClaw());
		MinecraftForgeClient.registerItemRenderer(ToeItems.goldClaw, new ItemRenderClaw());
		MinecraftForgeClient.registerItemRenderer(ToeItems.diamondClaw, new ItemRenderClaw());
		MinecraftForgeClient.registerItemRenderer(ToeItems.emeraldClaw, new ItemRenderClaw());
		MinecraftForgeClient.registerItemRenderer(ToeItems.rubyClaw, new ItemRenderClaw());
		MinecraftForgeClient.registerItemRenderer(ToeItems.sapphireClaw, new ItemRenderClaw());

		MinecraftForgeClient.registerItemRenderer(ToeItems.statueBipedItem, new ItemRenderStatueBiped());
		
		//MinecraftForgeClient.registerItemRenderer(ToeItems.tophat, new ItemRenderTopHat()); //unneeded
		
		RenderingRegistry.registerBlockHandler(RenderID.transmutation, new RenderTransmutation());
		
		registerKeys();
		
		FMLCommonHandler.instance().bus().register(new KeyHandler());
		
		//unused
		registerTexturePacks();
	}
	
	//unused?
	public int addArmor(String armor) {
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
	
	//unused
	private void registerTexturePacks() {
		try {
            Field f = Minecraft.class.getDeclaredField("defaultResourcePacks");
            f.setAccessible(true);
            List list = (List) f.get(Minecraft.getMinecraft());
            list.add(new ResourceLoc());
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}
