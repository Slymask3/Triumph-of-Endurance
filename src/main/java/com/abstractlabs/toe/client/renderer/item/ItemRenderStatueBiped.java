package com.abstractlabs.toe.client.renderer.item;

import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import com.abstractlabs.toe.client.model.ModelStatueBiped;
import com.abstractlabs.toe.client.renderer.tileentity.RenderStatueBiped;
import com.abstractlabs.toe.tileentity.TileEntityStatueBiped;
import com.abstractlabs.toe.utility.Helper;

import cpw.mods.fml.client.FMLClientHandler;

public class ItemRenderStatueBiped implements IItemRenderer {
	private static RenderItem renderItem = new RenderItem();
    private ModelStatueBiped model = new ModelStatueBiped();
    private TileEntityStatueBiped tile = new TileEntityStatueBiped();
    private RenderStatueBiped statue = new RenderStatueBiped();
	
	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
//		return type == ItemRenderType.EQUIPPED_FIRST_PERSON || type == ItemRenderType.EQUIPPED || type == ItemRenderType.INVENTORY;
		return true;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
		return true;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		if(type == ItemRenderType.INVENTORY || type == ItemRenderType.ENTITY) {
			if(item.stackTagCompound == null) {
				GL11.glTranslatef(-0.5F, -0.9F, -0.5F);
				GL11.glScalef(0.8F, 0.8F, 0.8F);
				
				FMLClientHandler.instance().getClient().getTextureManager().bindTexture(AbstractClientPlayer.locationStevePng);    
				statue.renderTileEntityAt(tile, 0, 0, 0, 0);
		    	
				GL11.glEnable(GL12.GL_RESCALE_NORMAL);
			} else if(item.stackTagCompound != null) {
				GL11.glTranslatef(-0.5F, -0.9F, -0.5F);
				GL11.glScalef(0.8F, 0.8F, 0.8F);
				
				FMLClientHandler.instance().getClient().getTextureManager().bindTexture(Helper.getResourceLocationFromName(item.stackTagCompound.getString("Username")));    
				statue.renderTileEntityAt(tile, 0, 0, 0, 0);
		    	
				GL11.glEnable(GL12.GL_RESCALE_NORMAL);
			}
		} else {
			if(item.stackTagCompound == null) {
				GL11.glPushMatrix();
					GL11.glRotatef(180, 0F, 0F, 1F);
					GL11.glTranslatef(-0.5F, -0.9F, 0.5F);
					//GL11.glScalef(0.8F, 0.8F, 0.8F);
			        GL11.glRotatef(180F, 0.0F, 1.0F, 0.0F);
	            	FMLClientHandler.instance().getClient().getTextureManager().bindTexture(AbstractClientPlayer.locationStevePng);       
		            this.model.render((Entity)data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
		        GL11.glPopMatrix();
			} else if(item.stackTagCompound != null) {
				GL11.glPushMatrix();
					GL11.glRotatef(180, 0F, 0F, 1F);
					GL11.glTranslatef(-0.5F, -0.9F, 0.5F);
					//GL11.glScalef(0.8F, 0.8F, 0.8F);
			        GL11.glRotatef(-90F, 0.0F, 1.0F, 0.0F);
            		FMLClientHandler.instance().getClient().getTextureManager().bindTexture(Helper.getResourceLocationFromName(item.stackTagCompound.getString("Username")));       
	            	this.model.render((Entity)data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
	            GL11.glPopMatrix();
			}
		}
	}
}