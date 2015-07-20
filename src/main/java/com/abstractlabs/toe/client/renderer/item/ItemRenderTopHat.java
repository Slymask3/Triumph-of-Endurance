package com.abstractlabs.toe.client.renderer.item;

import java.awt.Color;

import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

import com.abstractlabs.toe.item.ItemTopHat;

public class ItemRenderTopHat implements IItemRenderer {
    private static RenderItem renderItem = new RenderItem();

    public boolean handleRenderType(ItemStack is, ItemRenderType type) {
		//return type == ItemRenderType.EQUIPPED || type == ItemRenderType.EQUIPPED_FIRST_PERSON || type == ItemRenderType.INVENTORY || type == ItemRenderType.ENTITY;
		return type == ItemRenderType.INVENTORY;
//        return true;
    }

    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack is, ItemRendererHelper helper) {
    	return type == ItemRenderType.EQUIPPED || type == ItemRenderType.EQUIPPED_FIRST_PERSON || type == ItemRenderType.ENTITY;
    }

    public void renderItem(ItemRenderType type, ItemStack is, Object ... par3) {
    	if(type == ItemRenderType.INVENTORY) {
			IIcon icon = is.getItem().getIconFromDamageForRenderPass(0, 0);
			IIcon overlay = is.getItem().getIconFromDamageForRenderPass(0, 1);
			GL11.glEnable(GL11.GL_BLEND);
		    Color c = new Color(((ItemTopHat) is.getItem()).getColor(is));
		
		    GL11.glColor3f(1.0F, 1.0F, 1.0F);
		    renderItem.renderIcon(0, 0, icon, 16, 16);
		    GL11.glColor3f(getRedF(c.getRed()), getGreenF(c.getGreen()), getBlueF(c.getBlue()));
		    renderItem.renderIcon(0, 0, overlay, 16, 16);
    	} else if(type == ItemRenderType.EQUIPPED || type == ItemRenderType.EQUIPPED_FIRST_PERSON || type == ItemRenderType.ENTITY) {
//    		Tessellator t = Tessellator.instance;
//    		t.startDrawingQuads();
//    		t.setNormal(0.0F,1.0F,0.0F);
//    	    t.addVertexWithUV(0,0,0.0D,2,6);
//    	    t.addVertexWithUV(0,0,0.0D,3,7);
//    	    t.addVertexWithUV(0,0,0.0D,4,8);
//    	    t.addVertexWithUV(0,0,0.0D,5,9);
//    	    t.draw();
    		
    		GL11.glPushMatrix();
    			GL11.glRotatef(180, 0, 0, 1);
    		
				IIcon icon = is.getItem().getIconFromDamageForRenderPass(0, 0);
				IIcon overlay = is.getItem().getIconFromDamageForRenderPass(0, 1);
				GL11.glEnable(GL11.GL_BLEND);
			    Color c = new Color(((ItemTopHat) is.getItem()).getColor(is));
			
			    GL11.glColor3f(1.0F, 1.0F, 1.0F);
			    renderItem.renderIcon(0, 0, icon, 16, 16);
			    GL11.glColor3f(getRedF(c.getRed()), getGreenF(c.getGreen()), getBlueF(c.getBlue()));
			    renderItem.renderIcon(0, 0, overlay, 16, 16);
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