package com.abstractlabs.toe.client.renderer.entity.mob;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import com.abstractlabs.toe.entity.npc.EntityDyer;
import com.abstractlabs.toe.reference.Reference;

public class RenderDyer extends RenderLiving {
    protected ResourceLocation texture;

    public RenderDyer(ModelBase par1ModelBase, float parShadowSize) {
        super(par1ModelBase, parShadowSize);
        setEntityTexture();   
    }
 
    @Override
    protected void preRenderCallback(EntityLivingBase entity, float f) {
        preRenderCallbackDyer((EntityDyer) entity, f);
    }
  
    protected void preRenderCallbackDyer(EntityDyer entity, float f) {
    	
    }

    protected void setEntityTexture() {
        texture = new ResourceLocation(Reference.MOD_ID + ":textures/entity/mob/dyer.png");
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity entity) {
        return texture;
    }
}