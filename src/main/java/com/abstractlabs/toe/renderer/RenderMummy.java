package com.abstractlabs.toe.renderer;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import com.abstractlabs.toe.entity.monster.EntityMummy;
import com.abstractlabs.toe.reference.Reference;

public class RenderMummy extends RenderLiving {
    protected ResourceLocation texture;

    public RenderMummy(ModelBase par1ModelBase, float parShadowSize) {
        super(par1ModelBase, parShadowSize);
        setEntityTexture();        
    }
 
    @Override
    protected void preRenderCallback(EntityLivingBase entity, float f) {
        preRenderCallbackMummy((EntityMummy) entity, f);
    }
  
    protected void preRenderCallbackMummy(EntityMummy entity, float f) {
        // some people do some G11 transformations or blends here, like you can do
        // GL11.glScalef(2F, 2F, 2F); to scale up the entity
        // which is used for Slime entities.  I suggest having the entity cast to
        // your custom type to make it easier to access fields from your 
        // custom entity, eg. GL11.glScalef(entity.scaleFactor, entity.scaleFactor, 
        // entity.scaleFactor); 
    }

    protected void setEntityTexture() {
        texture = new ResourceLocation(Reference.MOD_ID + ":textures/entity/mob/mummy.png");
    }

    /**
    * Returns the location of an entity's texture. Doesn't seem to be called 
    * unless you call Render.bindEntityTexture.
    */
    @Override
    protected ResourceLocation getEntityTexture(Entity entity) {
        return texture;
    }
}