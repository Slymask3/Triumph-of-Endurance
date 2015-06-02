package com.abstractlabs.toe.skill;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;

import com.abstractlabs.toe.reference.Skill;
import com.abstractlabs.toe.utility.Helper;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class DescriptionGUI extends Gui {
	Minecraft mc = Minecraft.getMinecraft();
	
	public static boolean isOn = true;
	
	public static int skillSelected = 1;
	
	public static int lvl_swords;
	public static int lvl_ranged;
	public static int lvl_magic;
	public static int lvl_mining;
	public static int lvl_woodcutting;
	public static int lvl_fishing;
	public static int lvl_farming;
	public static int lvl_cooking;
	public static int lvl_smelting;
	public static int lvl_brewing;
	public static int lvl_runemaking;
	public static int lvl_prayer;
	public static int lvl_slayer;
	public static int lvl_agility;
	public static int lvl_thieving;
	public static int lvl_arenalism;
	
	public static int percent_swords;
	public static int percent_ranged;
	public static int percent_magic;
	public static int percent_mining;
	public static int percent_woodcutting;
	public static int percent_fishing;
	public static int percent_farming;
	public static int percent_cooking;
	public static int percent_smelting;
	public static int percent_brewing;
	public static int percent_runemaking;
	public static int percent_prayer;
	public static int percent_slayer;
	public static int percent_agility;
	public static int percent_thieving;
	public static int percent_arenalism;

	private String texture_1 = "toe:textures/gui/desc1.png";
	private String texture_2 = "toe:textures/gui/desc2.png";
	private String texture_3 = "toe:textures/gui/desc3.png";
	private String texture_4 = "toe:textures/gui/desc4.png";
	private String texture_5 = "toe:textures/gui/desc5.png";
	private String texture_6 = "toe:textures/gui/desc6.png";
	private String texture_7 = "toe:textures/gui/desc7.png";
	private String texture_8 = "toe:textures/gui/desc8.png";
	private String texture_9 = "toe:textures/gui/desc9.png";
	private String texture_10 = "toe:textures/gui/desc10.png";
	private String texture_11 = "toe:textures/gui/desc11.png";
	private String texture_12 = "toe:textures/gui/desc12.png";
	private String texture_13 = "toe:textures/gui/desc13.png";
	private String texture_14 = "toe:textures/gui/desc14.png";
	private String texture_15 = "toe:textures/gui/desc15.png";
	private String texture_16 = "toe:textures/gui/desc16.png";

	private String texture_1_gold = "toe:textures/gui/desc1_gold.png";
	private String texture_2_gold = "toe:textures/gui/desc2_gold.png";
	private String texture_3_gold = "toe:textures/gui/desc3_gold.png";
	private String texture_4_gold = "toe:textures/gui/desc4_gold.png";
	private String texture_5_gold = "toe:textures/gui/desc5_gold.png";
	private String texture_6_gold = "toe:textures/gui/desc6_gold.png";
	private String texture_7_gold = "toe:textures/gui/desc7_gold.png";
	private String texture_8_gold = "toe:textures/gui/desc8_gold.png";
	private String texture_9_gold = "toe:textures/gui/desc9_gold.png";
	private String texture_10_gold = "toe:textures/gui/desc10_gold.png";
	private String texture_11_gold = "toe:textures/gui/desc11_gold.png";
	private String texture_12_gold = "toe:textures/gui/desc12_gold.png";
	private String texture_13_gold = "toe:textures/gui/desc13_gold.png";
	private String texture_14_gold = "toe:textures/gui/desc14_gold.png";
	private String texture_15_gold = "toe:textures/gui/desc15_gold.png";
	private String texture_16_gold = "toe:textures/gui/desc16_gold.png";
	
	private int xPos = Skill.guiX_desc;
	private int yPos = Skill.guiY_desc;

	@SubscribeEvent
	public void onRenderExperienceBar(RenderGameOverlayEvent.Post event) {
		if (event.isCanceled() || event.type != ElementType.EXPERIENCE) { 
			return;
		}
		
		if(!isOn) {
			return;
		}
		
		ScaledResolution scaledresolution = new ScaledResolution(this.mc, this.mc.displayWidth, this.mc.displayHeight);
		int width = scaledresolution.getScaledWidth();
		int height = scaledresolution.getScaledHeight();
		
		int y = yPos;
		int x = width - xPos;
		
		if(skillSelected == 1) {
			drawBackground(texture_1, texture_1_gold, lvl_swords);
			Helper.drawStringWithBorder(mc, x+5, y+8, "Skill: Swords", 16777215, 0);
			Helper.drawStringWithBorder(mc, x+5, y+18, "Level: " + lvl_swords, 16777215, 0);
		} else if(skillSelected == 2) {
			drawBackground(texture_2, texture_2_gold, lvl_ranged);
			Helper.drawStringWithBorder(mc, x+5, y+8, "Skill: Ranged", 16777215, 0);
			Helper.drawStringWithBorder(mc, x+5, y+18, "Level: " + lvl_ranged, 16777215, 0);
		} else if(skillSelected == 3) {
			drawBackground(texture_3, texture_3_gold, lvl_magic);
			Helper.drawStringWithBorder(mc, x+5, y+8, "Skill: Magic", 16777215, 0);
			Helper.drawStringWithBorder(mc, x+5, y+18, "Level: " + lvl_magic, 16777215, 0);
		} else if(skillSelected == 4) {
			drawBackground(texture_4, texture_4_gold, lvl_mining);
			Helper.drawStringWithBorder(mc, x+5, y+8, "Skill: Mining", 16777215, 0);
			Helper.drawStringWithBorder(mc, x+5, y+18, "Level: " + lvl_mining, 16777215, 0);
		} else if(skillSelected == 5) {
			drawBackground(texture_5, texture_5_gold, lvl_woodcutting);
			Helper.drawStringWithBorder(mc, x+5, y+8, "Skill: Woodcutting", 16777215, 0);
			Helper.drawStringWithBorder(mc, x+5, y+18, "Level: " + lvl_woodcutting, 16777215, 0);
		} else if(skillSelected == 6) {
			drawBackground(texture_6, texture_6_gold, lvl_fishing);
			Helper.drawStringWithBorder(mc, x+5, y+8, "Skill: Fishing", 16777215, 0);
			Helper.drawStringWithBorder(mc, x+5, y+18, "Level: " + lvl_fishing, 16777215, 0);
		} else if(skillSelected == 7) {
			drawBackground(texture_7, texture_7_gold, lvl_farming);
			Helper.drawStringWithBorder(mc, x+5, y+8, "Skill: Farming", 16777215, 0);
			Helper.drawStringWithBorder(mc, x+5, y+18, "Level: " + lvl_farming, 16777215, 0);
		} else if(skillSelected == 8) {
			drawBackground(texture_8, texture_8_gold, lvl_cooking);
			Helper.drawStringWithBorder(mc, x+5, y+8, "Skill: Cooking", 16777215, 0);
			Helper.drawStringWithBorder(mc, x+5, y+18, "Level: " + lvl_cooking, 16777215, 0);
		} else if(skillSelected == 9) {
			drawBackground(texture_9, texture_9_gold, lvl_smelting);
			Helper.drawStringWithBorder(mc, x+5, y+8, "Skill: Smelting", 16777215, 0);
			Helper.drawStringWithBorder(mc, x+5, y+18, "Level: " + lvl_smelting, 16777215, 0);
		} else if(skillSelected == 10) {
			drawBackground(texture_10, texture_10_gold, lvl_brewing);
			Helper.drawStringWithBorder(mc, x+5, y+8, "Skill: Brewing", 16777215, 0);
			Helper.drawStringWithBorder(mc, x+5, y+18, "Level: " + lvl_brewing, 16777215, 0);
		} else if(skillSelected == 11) {
			drawBackground(texture_11, texture_11_gold, lvl_runemaking);
			Helper.drawStringWithBorder(mc, x+5, y+8, "Skill: Runemaking", 16777215, 0);
			Helper.drawStringWithBorder(mc, x+5, y+18, "Level: " + lvl_runemaking, 16777215, 0);
		} else if(skillSelected == 12) {
			drawBackground(texture_12, texture_12_gold, lvl_prayer);
			Helper.drawStringWithBorder(mc, x+5, y+8, "Skill: Prayer", 16777215, 0);
			Helper.drawStringWithBorder(mc, x+5, y+18, "Level: " + lvl_prayer, 16777215, 0);
		} else if(skillSelected == 13) {
			drawBackground(texture_13, texture_13_gold, lvl_slayer);
			Helper.drawStringWithBorder(mc, x+5, y+8, "Skill: Slayer", 16777215, 0);
			Helper.drawStringWithBorder(mc, x+5, y+18, "Level: " + lvl_slayer, 16777215, 0);
		} else if(skillSelected == 14) {
			drawBackground(texture_14, texture_14_gold, lvl_agility);
			Helper.drawStringWithBorder(mc, x+5, y+8, "Skill: Agility", 16777215, 0);
			Helper.drawStringWithBorder(mc, x+5, y+18, "Level: " + lvl_agility, 16777215, 0);
		} else if(skillSelected == 15) {
			drawBackground(texture_15, texture_15_gold, lvl_thieving);
			Helper.drawStringWithBorder(mc, x+5, y+8, "Skill: Thieving", 16777215, 0);
			Helper.drawStringWithBorder(mc, x+5, y+18, "Level: " + lvl_thieving, 16777215, 0);
		} else if(skillSelected == 16) {
			drawBackground(texture_16, texture_16_gold, lvl_arenalism);
			Helper.drawStringWithBorder(mc, x+5, y+8, "Skill: Arenalism", 16777215, 0);
			Helper.drawStringWithBorder(mc, x+5, y+18, "Level: " + lvl_arenalism, 16777215, 0);
		}
	}
	
	private void drawBackground(String normal, String gold, int lvl) {
		ScaledResolution scaledresolution = new ScaledResolution(this.mc, this.mc.displayWidth, this.mc.displayHeight);
		int width = scaledresolution.getScaledWidth();
		int height = scaledresolution.getScaledHeight();
		
		if(lvl == 100) {
			this.mc.renderEngine.bindTexture(new ResourceLocation(gold));
		} else {
			this.mc.renderEngine.bindTexture(new ResourceLocation(normal));
		}
		
		int y = yPos;
		int x = width - xPos;
		this.drawTexturedModalRect(x, y, 0, 0, 256, 33);
	}
}