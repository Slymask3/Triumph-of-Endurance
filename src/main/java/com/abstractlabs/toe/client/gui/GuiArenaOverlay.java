package com.abstractlabs.toe.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;

import org.lwjgl.opengl.GL11;

import com.abstractlabs.toe.reference.Reference;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class GuiArenaOverlay extends Gui {
	private Minecraft mc = Minecraft.getMinecraft();
	
	public static boolean inArena;
	public static int cash;
	public static int wave;
	public static int enemiesLeft;
	public static int maxWaves;
	
//	public static boolean timer;
//	public static int second;

	public GuiArenaOverlay() {
	    super();
	}

	@SubscribeEvent
	public void onRenderExperienceBar(RenderGameOverlayEvent.Post event) {
		if (event.isCanceled() || event.type != ElementType.EXPERIENCE) { 
			return;
		}

		EntityPlayer player = Minecraft.getMinecraft().thePlayer;
		
		//LogHelper.info("inArena() == " + Arenalism.get(player).inArena());
		
		if(this.inArena) {
			GL11.glColor4f(1F, 1F, 1F, 1F);
			GL11.glDisable(GL11.GL_LIGHTING);
			mc.renderEngine.bindTexture(new ResourceLocation(Reference.MOD_ID, "textures/gui/arenaOverlay.png"));
			ScaledResolution scaled = new ScaledResolution(mc, mc.displayWidth, mc.displayHeight);

			drawNonStandardTexturedRect(1, 1, 0, 0, 120, 31, 120, 31);
			
			mc.fontRenderer.drawString("Wave: " + this.wave, 5, 5, 0x000000);
			mc.fontRenderer.drawString("Cash: $" + this.cash, 5, 13, 0x000000);
			
			if(this.enemiesLeft > 0) {
				mc.fontRenderer.drawString("Enemies Remaining: " + this.enemiesLeft, 5, 21, 0x000000);
			}
			
//			if(timer) {
//				mc.fontRenderer.drawString("Next Wave In: " + (30-this.second), 5, 21, 0x000000);
//			} else {
//				mc.fontRenderer.drawString("Enemies Remaining: " + this.enemiesLeft, 5, 21, 0x000000);
//			}

			//mc.fontRenderer.drawString("Foraging Lvl: " + MiningHelper.getProperties(player).getLevel(), 5, 40, 0x000000);
		}
	}
	
	protected void drawNonStandardTexturedRect(int x, int y, int u, int v, int width, int height, int textureWidth, int textureHeight) {
		double f = 1F / (double) textureWidth;
		double f1 = 1F / (double) textureHeight;
		Tessellator tessellator = Tessellator.instance;
		tessellator.startDrawingQuads();
		tessellator.addVertexWithUV(x, y + height, 0, u * f, (v + height) * f1);
		tessellator.addVertexWithUV(x + width, y + height, 0, (u + width) * f, (v + height) * f1);
		tessellator.addVertexWithUV(x + width, y, 0, (u + width) * f, v * f1);
		tessellator.addVertexWithUV(x, y, 0, u * f, v * f1);
		tessellator.draw();
	}
}