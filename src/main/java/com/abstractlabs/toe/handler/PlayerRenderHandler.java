package com.abstractlabs.toe.handler;

import java.awt.Color;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderPlayerEvent;

import org.lwjgl.opengl.GL11;

import com.abstractlabs.toe.client.model.ModelTopHat;
import com.abstractlabs.toe.init.ToeItems;
import com.abstractlabs.toe.item.ItemTopHat;
import com.abstractlabs.toe.reference.Reference;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class PlayerRenderHandler {
	private ModelTopHat tophat = new ModelTopHat();
	
	@SubscribeEvent
	public void onRenderPost(RenderPlayerEvent.Post e) {
		if(e.entityPlayer.getCurrentArmor(3) != null && e.entityPlayer.getCurrentArmor(3).getItem() == ToeItems.tophat) {
			//LogHelper.info("[Post] e.entityPlayer.rotationYaw == " + e.entityPlayer.rotationYaw + " | e.entityPlayer.rotationYawHead == " + e.entityPlayer.rotationYawHead);
//			GL11.glPushMatrix();
//				GL11.glRotatef(180, 0F, 0F, 1F);
//				GL11.glTranslatef(0.0F, -0.4F, 0.0F);
//				float scale = 0.55F;
//				GL11.glScalef(scale, scale, scale);
//				
//				GL11.glRotatef(e.entityPlayer.rotationYaw, 0, 1, 0);
//				GL11.glTranslatef(0.0F, 1.2F, 0.0F);
//				GL11.glRotatef(-e.entityPlayer.rotationPitch, 1, 0, 0);
//				GL11.glTranslatef(0.0F, -1.2F, 0.0F);
//				Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Reference.MOD_ID + ":" + "textures/model/hat/tophat.png"));
//				
//				Color c = new Color(((ItemTopHat) ToeItems.tophat).getColor(e.entityPlayer.getCurrentArmor(3)));
//				GL11.glColor3f(c.getRed()/255.0F, c.getGreen()/255.0F, c.getBlue()/255.0F);
//				
//				tophat.renderModel(0.0625F);
//			GL11.glPopMatrix();
		}
	}
	
	@SubscribeEvent
	public void onRenderSpecialsPost(RenderPlayerEvent.Specials.Pre e) {
		if(e.entityPlayer.getCurrentArmor(3) != null && e.entityPlayer.getCurrentArmor(3).getItem() == ToeItems.tophat) {
			//e.renderHelmet = false;
			//e.renderer.
			e.renderHelmet = false;
			GL11.glPushMatrix();
				e.renderer.modelBipedMain.bipedHead.postRender(0.0625f);
				
				//GL11.glRotatef(180, 0F, 0F, 1F);
				GL11.glTranslatef(0.0F, -0.7F, 0.0F);
				float scale = 0.55F;
				GL11.glScalef(scale, scale, scale);

				
				//LogHelper.info("[Specials.Post] e.entityPlayer.rotationYaw == " + e.entityPlayer.rotationYaw + " | e.entityPlayer.rotationYawHead == " + e.entityPlayer.rotationYawHead);

//				GL11.glRotatef(-e.entityPlayer.rotationYaw, 0, 1, 0);
//				GL11.glRotatef(e.entityPlayer.rotationYawHead, 0, 1, 0);
				
//				GL11.glRotatef(e.entityPlayer.rotationYaw, 0, 1, 0);
//				GL11.glRotatef(-e.entityPlayer.rotationYaw*2, 0, 1, 0);
				//GL11.glRotatef(e.entityPlayer.rotationYaw-e.entityPlayer.getRotationYawHead().rotationYawHead, 0, 1, 0);
				//GL11.glRotatef(45, 1, 0, 0);
				//GL11.glTranslatef(0.0F, 1.2F, 0.0F);
				//GL11.glRotatef(e.entityPlayer.rotationPitch/4, 1, 0, 0);
				//GL11.glRotatef(e.entityPlayer.rotationPitch, 0, 1, 0);
				//GL11.glRotatef(e.entityPlayer.rotationPitch, 1, 0, 0);
				//GL11.glTranslatef(0.0F, -1.2F, 0.0F);
				Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Reference.MOD_ID + ":" + "textures/model/hat/tophat.png"));
				
				Color c = new Color(((ItemTopHat) ToeItems.tophat).getColor(e.entityPlayer.getCurrentArmor(3)));
				GL11.glColor3f(c.getRed()/255.0F, c.getGreen()/255.0F, c.getBlue()/255.0F);
				
				tophat.renderModel(0.0625F);
			GL11.glPopMatrix();
		}
	}
	
	@SubscribeEvent
	public void onRenderSetArmorModel(RenderPlayerEvent.SetArmorModel e) {
		if(e.entityPlayer.getCurrentArmor(3) != null && e.entityPlayer.getCurrentArmor(3).getItem() == ToeItems.tophat) {
//			GL11.glPushMatrix();
//				//GL11.glRotatef(180, 0F, 0F, 1F);
//				GL11.glTranslatef(0.0F, -0.4F, 0.0F);
//				float scale = 0.55F;
//				GL11.glScalef(scale, scale, scale);
//				
//				GL11.glRotatef(e.entityPlayer.rotationYaw, 0, 1, 0);
//				GL11.glTranslatef(0.0F, 1.2F, 0.0F);
//				GL11.glRotatef(-e.entityPlayer.rotationPitch, 1, 0, 0);
//				GL11.glTranslatef(0.0F, -1.2F, 0.0F);
//				Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Reference.MOD_ID + ":" + "textures/model/hat/tophat.png"));
//				tophat.renderModel(0.0625F);
//			GL11.glPopMatrix();
		}
	}
}