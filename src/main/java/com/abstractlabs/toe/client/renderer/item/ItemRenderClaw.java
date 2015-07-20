package com.abstractlabs.toe.client.renderer.item;

import java.awt.Color;

import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

import com.abstractlabs.toe.client.model.ModelClaw;
import com.abstractlabs.toe.init.ToeItems;
import com.abstractlabs.toe.item.ItemToeClaw;
import com.abstractlabs.toe.reference.Reference;

import cpw.mods.fml.client.FMLClientHandler;

public class ItemRenderClaw implements IItemRenderer {
	private static final ResourceLocation texture = new ResourceLocation(Reference.MOD_ID + ":" + "textures/model/claw.png");
	private static final ResourceLocation textureWood = new ResourceLocation(Reference.MOD_ID + ":" + "textures/model/clawWood_overlay.png");
	private static final ResourceLocation textureStone = new ResourceLocation(Reference.MOD_ID + ":" + "textures/model/clawStone_overlay.png");
	private static final ResourceLocation textureIron = new ResourceLocation(Reference.MOD_ID + ":" + "textures/model/clawIron_overlay.png");
	private static final ResourceLocation textureGold = new ResourceLocation(Reference.MOD_ID + ":" + "textures/model/clawGold_overlay.png");
	private static final ResourceLocation textureDiamond = new ResourceLocation(Reference.MOD_ID + ":" + "textures/model/clawDiamond_overlay.png");
	private static final ResourceLocation textureEmerald = new ResourceLocation(Reference.MOD_ID + ":" + "textures/model/clawEmerald_overlay.png");
	private static final ResourceLocation textureRuby = new ResourceLocation(Reference.MOD_ID + ":" + "textures/model/clawRuby_overlay.png");
	private static final ResourceLocation textureSapphire = new ResourceLocation(Reference.MOD_ID + ":" + "textures/model/clawSapphire_overlay.png");
	
    private ModelClaw model = new ModelClaw();
    private static RenderItem renderItem = new RenderItem();

    public boolean handleRenderType(ItemStack is, ItemRenderType type) {
        return type == ItemRenderType.EQUIPPED_FIRST_PERSON || type == ItemRenderType.EQUIPPED || type == ItemRenderType.INVENTORY;
    }

    public boolean shouldUseRenderHelper(ItemRenderType var1, ItemStack var2, ItemRendererHelper var3) {
    	return false;
    }

    public void renderItem(ItemRenderType type, ItemStack is, Object ... par3) {
    	if(type == ItemRenderType.INVENTORY) {
			IIcon icon = is.getItem().getIconFromDamageForRenderPass(0, 0);
			IIcon overlay = is.getItem().getIconFromDamageForRenderPass(0, 1);
			GL11.glEnable(GL11.GL_BLEND);
            //renderItem.renderWithColor = true;
            Color c = new Color(((ItemToeClaw) is.getItem()).getColor(is));
            GL11.glColor3f(getRedF(c.getRed()), getGreenF(c.getGreen()), getBlueF(c.getBlue()));
            renderItem.renderIcon(0, 0, icon, 16, 16);
            //renderItem.renderWithColor = false;
            GL11.glColor3f(1.0F, 1.0F, 1.0F);
            renderItem.renderIcon(0, 0, overlay, 16, 16);
		} else {
            GL11.glPushMatrix();
            	//render leather glove
            	FMLClientHandler.instance().getClient().getTextureManager().bindTexture(texture);
	
	            float scale = 0.33F;
	            GL11.glTranslatef(0.5F, 0.5F, -0.02F);
	            GL11.glScalef(scale, scale, scale);
	            GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
	            GL11.glRotatef(94.0F, 0.0F, 1.0F, 0.0F);
	            GL11.glRotatef(-35.0F, 1.0F, 0.0F, 0.0F);
	            
	            //GL11.glEnable(GL11.GL_COLOR);
	            //GL11.glEnable(GL11.GL_BLEND);

	            Color c = new Color(((ItemToeClaw) is.getItem()).getColor(is));
	            GL11.glColor3f(getRedF(c.getRed()), getGreenF(c.getGreen()), getBlueF(c.getBlue()));
	            //GL11.glColor3f(c.getRed()/255, c.getGreen()/255, c.getBlue()/255);
	            //GL11.glColor3f(c.getRed(), c.getGreen(), c.getBlue());
	            //GL11.glColor3f(1, 255, 1);

//	            LogHelper.info("[ItemRenderClaw] red == " + c.getRed() + " | green == " + c.getGreen() + " | blue == " + c.getBlue());
//	            LogHelper.info("[ItemRenderClaw] red == " + getRedF(c.getRed()) + " | green == " + getGreenF(c.getGreen()) + " | blue == " + getBlueF(c.getBlue()));
	            
	            this.model.render((Entity)par3[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
	        GL11.glPopMatrix();
	        GL11.glPushMatrix();
	            //render claw overlay
	            if(is.getItem() == ToeItems.woodClaw) {
    	            FMLClientHandler.instance().getClient().getTextureManager().bindTexture(textureWood);
            	} else if(is.getItem() == ToeItems.stoneClaw) {
    	            FMLClientHandler.instance().getClient().getTextureManager().bindTexture(textureStone);
            	} else if(is.getItem() == ToeItems.ironClaw) {
    	            FMLClientHandler.instance().getClient().getTextureManager().bindTexture(textureIron);
            	} else if(is.getItem() == ToeItems.goldClaw) {
    	            FMLClientHandler.instance().getClient().getTextureManager().bindTexture(textureGold);
            	} else if(is.getItem() == ToeItems.diamondClaw) {
    	            FMLClientHandler.instance().getClient().getTextureManager().bindTexture(textureDiamond);
            	} else if(is.getItem() == ToeItems.emeraldClaw) {
    	            FMLClientHandler.instance().getClient().getTextureManager().bindTexture(textureEmerald);
            	} else if(is.getItem() == ToeItems.rubyClaw) {
    	            FMLClientHandler.instance().getClient().getTextureManager().bindTexture(textureRuby);
            	} else if(is.getItem() == ToeItems.sapphireClaw) {
    	            FMLClientHandler.instance().getClient().getTextureManager().bindTexture(textureSapphire);
            	}
	            
	            GL11.glTranslatef(0.5F, 0.5F, -0.02F);
	            GL11.glScalef(scale, scale, scale);
	            GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
	            GL11.glRotatef(94.0F, 0.0F, 1.0F, 0.0F);
	            GL11.glRotatef(-35.0F, 1.0F, 0.0F, 0.0F);
	            
	            GL11.glColor3f(1.0F, 1.0F, 1.0F);
	            
	            this.model.render((Entity)par3[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
            GL11.glPopMatrix();
        }
    }
    
    private float getRedF(int red) {
    	return red/255.0F;
    }
    
    private float getGreenF(int green) {
    	return green/255.0F;
    }
    
    private float getBlueF(int blue) {
    	return blue/255.0F;
    }
}