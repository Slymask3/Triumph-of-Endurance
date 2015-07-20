package com.abstractlabs.toe.client.renderer.entity.mob;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.abstractlabs.toe.entity.npc.EntityShop;
import com.abstractlabs.toe.reference.Reference;

public class RenderShopTest extends RenderLiving {
    protected ResourceLocation texture;

    public RenderShopTest(ModelBase par1ModelBase, float parShadowSize) {
        super(par1ModelBase, parShadowSize);
        setEntityTexture();
    }
 
    @Override
    protected void preRenderCallback(EntityLivingBase entity, float f) {
        preRenderCallbackShop((EntityShop) entity, f);
    }
  
    protected void preRenderCallbackShop(EntityShop entity, float f) {
    	GL11.glScalef(0.5F, 0.5F, 0.5F);
    }

    protected void setEntityTexture() {
        texture = new ResourceLocation(Reference.MOD_ID + ":textures/entity/mob/shopTest.png");
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity entity) {
        return texture;
    }
}