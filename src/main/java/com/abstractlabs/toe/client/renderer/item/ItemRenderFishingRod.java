package com.abstractlabs.toe.client.renderer.item;

import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

import com.abstractlabs.toe.item.ItemToeFishingRod;

public class ItemRenderFishingRod implements IItemRenderer {

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		return type == IItemRenderer.ItemRenderType.EQUIPPED_FIRST_PERSON || type == IItemRenderer.ItemRenderType.EQUIPPED;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
		return false;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		if(data[1] instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) data[1];
			
			if(player.fishEntity != null) {
				IIcon icon = ((ItemToeFishingRod) item.getItem()).getCastIcon();
				
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
				IIcon icon = ((ItemToeFishingRod) item.getItem()).getUncastIcon();
				
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