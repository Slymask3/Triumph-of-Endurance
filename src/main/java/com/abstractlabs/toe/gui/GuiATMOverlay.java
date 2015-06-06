package com.abstractlabs.toe.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class GuiATMOverlay extends Gui {
	Minecraft mc = Minecraft.getMinecraft();
	
	public static int copper;
	public static int silver;
	public static int gold;
	
	public static boolean usingATM = false;

	@SubscribeEvent
	public void onRenderExperienceBar(RenderGameOverlayEvent.Post event) {
		if (event.isCanceled() || event.type != ElementType.EXPERIENCE) { 
			return;
		}
		
//		if(!usingATM) {
//			return;
//		}
		
		ScaledResolution scaledresolution = new ScaledResolution(this.mc, this.mc.displayWidth, this.mc.displayHeight);
		int h = scaledresolution.getScaledHeight();
		int w = scaledresolution.getScaledWidth();
		
		this.drawCenteredString(mc.fontRenderer, "ATM | Copper = " + copper + ", Silver = " + silver + ", Gold = " + gold, w/2, h/2 - 100, 0xAA00AA);
	      
		//Helper.drawStringWithBorder(mc, x, y-2, lvl, 16777215, 0);
	}
}