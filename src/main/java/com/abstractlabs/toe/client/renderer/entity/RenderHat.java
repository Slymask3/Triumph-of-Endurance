package com.abstractlabs.toe.client.renderer.entity;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.abstractlabs.toe.client.model.ModelTopHat;
import com.abstractlabs.toe.reference.Reference;

public class RenderHat extends Render {
	private ModelTopHat model;
    
    public RenderHat() {
        this.model = new ModelTopHat();
    }
    
	@Override
	public void doRender(Entity entity, double x, double y, double z, float par5, float par6) {
		GL11.glPushMatrix();
			GL11.glRotatef(180, 0F, 0F, 1F);
			
			GL11.glTranslatef(0.0F, -0.5F, 0.0F);
			
			float scale = 0.55F;
			GL11.glScalef(scale, scale, scale);
        	//GL11.glRotatef(entity.rotationPitch, 1F, 0F, 0F);
			
			GL11.glTranslatef(0.0F, 1.3F, 0.0F);
        	GL11.glRotatef(entity.rotationPitch, 1F, 0F, 0F);
	        GL11.glRotatef(entity.rotationYaw, 0F, 1F, 0F);
			GL11.glTranslatef(0.0F, -1.3F, 0.0F);
	        
	        //GL11.glRotatef(entity.rotationPitch, 1F, 0F, 0F);
	        this.bindTexture(new ResourceLocation(Reference.MOD_ID + ":" + "textures/model/hat/tophat.png"));
	        this.model.renderModel(0.0625F);
	    GL11.glPopMatrix();
	    
	    //LogHelper.info("rendering..");
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return new ResourceLocation(Reference.MOD_ID + ":" + "textures/model/hat/tophat.png");
	}
}