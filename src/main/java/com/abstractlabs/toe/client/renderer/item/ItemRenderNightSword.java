package com.abstractlabs.toe.client.renderer.item;

import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

import com.abstractlabs.toe.item.ItemLunarBlade;

public class ItemRenderNightSword implements IItemRenderer {
	 private static RenderItem renderItem = new RenderItem();
	
	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		return type == ItemRenderType.EQUIPPED_FIRST_PERSON || type == ItemRenderType.EQUIPPED || type == ItemRenderType.INVENTORY;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
		return false;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		if(type == ItemRenderType.INVENTORY) {
			if(item.stackTagCompound == null) {
				IIcon icon = ((ItemLunarBlade) item.getItem()).getInactiveIcon();
				GL11.glEnable(GL11.GL_BLEND);
	            renderItem.renderIcon(0, 0, icon, 16, 16);
			} else if(item.stackTagCompound != null) {
				if(item.stackTagCompound.getBoolean("nighttime")) {
					IIcon icon = ((ItemLunarBlade) item.getItem()).getActiveIcon();
					GL11.glEnable(GL11.GL_BLEND);
		            renderItem.renderIcon(0, 0, icon, 16, 16);
				} else {
					IIcon icon = ((ItemLunarBlade) item.getItem()).getInactiveIcon();
					GL11.glEnable(GL11.GL_BLEND);
		            renderItem.renderIcon(0, 0, icon, 16, 16);
				}
			}
		} else {
			if(item.stackTagCompound != null) {
				if(!item.stackTagCompound.getBoolean("nighttime")) {
					IIcon icon = ((ItemLunarBlade) item.getItem()).getInactiveIcon();
					
					float f = icon.getMinU();
					float f1 = icon.getMaxU();
					float f2 = icon.getMinV();
					float f3 = icon.getMaxV();
					float scale = 1F / 16F;
		
					GL11.glPushMatrix();
						GL11.glEnable(GL11.GL_BLEND);
						GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
						GL11.glColor4f(1F, 1F, 1F, 1F);
						ItemRenderer.renderItemIn2D(Tessellator.instance, f1, f2, f, f3, icon.getIconWidth(), icon.getIconHeight(), scale);
		
						GL11.glDisable(GL11.GL_BLEND);
					GL11.glPopMatrix();
		
					GL11.glColor4f(1F, 1F, 1F, 1F);
				} else {
					IIcon icon = ((ItemLunarBlade) item.getItem()).getActiveIcon();
					
					float f = icon.getMinU();
					float f1 = icon.getMaxU();
					float f2 = icon.getMinV();
					float f3 = icon.getMaxV();
					float scale = 1F / 16F;
		
					GL11.glPushMatrix();
						GL11.glEnable(GL11.GL_BLEND);
						GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
						GL11.glColor4f(1F, 1F, 1F, 1F);
						ItemRenderer.renderItemIn2D(Tessellator.instance, f1, f2, f, f3, icon.getIconWidth(), icon.getIconHeight(), scale);
		
						GL11.glDisable(GL11.GL_BLEND);
					GL11.glPopMatrix();
		
					GL11.glColor4f(1F, 1F, 1F, 1F);
				}
			}
		}
	}
}