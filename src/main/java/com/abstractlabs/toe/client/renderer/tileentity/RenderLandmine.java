package com.abstractlabs.toe.client.renderer.tileentity;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.abstractlabs.toe.client.model.ModelLandmine;
import com.abstractlabs.toe.init.ToeItems;
import com.abstractlabs.toe.reference.Reference;
import com.abstractlabs.toe.tileentity.TileEntityLandmine;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderLandmine extends TileEntitySpecialRenderer {
    private static final ResourceLocation texture = new ResourceLocation(Reference.MOD_ID + ":" + "textures/model/landmine.png");
    
    private ModelLandmine model;
    
    public RenderLandmine() {
        this.model = new ModelLandmine();
    }
    
    public void renderTileEntityAt(TileEntityLandmine te, double x, double y, double z, float f) {
        GL11.glPushMatrix();
	        GL11.glTranslatef((float)x+0.5F, (float)y+2.5F, (float)z+0.5F);
	        GL11.glRotatef(180, 0F, 0F, 1F);
	        
	        
	        
	        this.bindTexture(texture);
	        
	        GL11.glPushMatrix();
	        	this.model.renderModel(0.0625F);
	        	
//	        	Tessellator tessellator = Tessellator.instance;
//	        	
//	        	
//                    GL11.glDepthFunc(GL11.GL_EQUAL);
//                    GL11.glDisable(GL11.GL_LIGHTING);
//                    this.renderManager.renderEngine.bindTexture(RES_ITEM_GLINT);
//                    GL11.glEnable(GL11.GL_BLEND);
//                    GL11.glBlendFunc(GL11.GL_SRC_COLOR, GL11.GL_ONE);
//                    float f11 = 0.76F;
//                    GL11.glColor4f(0.5F * f11, 0.25F * f11, 0.8F * f11, 1.0F);
//                    GL11.glMatrixMode(GL11.GL_TEXTURE);
//                    GL11.glPushMatrix();
//                    float f12 = 0.125F;
//                    GL11.glScalef(f12, f12, f12);
//                    float f13 = (float)(Minecraft.getSystemTime() % 3000L) / 3000.0F * 8.0F;
//                    GL11.glTranslatef(f13, 0.0F, 0.0F);
//                    GL11.glRotatef(-50.0F, 0.0F, 0.0F, 1.0F);
//                    ItemRenderer.renderItemIn2D(tessellator, 0.0F, 0.0F, 1.0F, 1.0F, 255, 255, f9);
//                    GL11.glPopMatrix();
//                    GL11.glPushMatrix();
//                    GL11.glScalef(f12, f12, f12);
//                    f13 = (float)(Minecraft.getSystemTime() % 4873L) / 4873.0F * 8.0F;
//                    GL11.glTranslatef(-f13, 0.0F, 0.0F);
//                    GL11.glRotatef(10.0F, 0.0F, 0.0F, 1.0F);
//                    ItemRenderer.renderItemIn2D(tessellator, 0.0F, 0.0F, 1.0F, 1.0F, 255, 255, f9);
//                    GL11.glPopMatrix();
//                    GL11.glMatrixMode(GL11.GL_MODELVIEW);
//                    GL11.glDisable(GL11.GL_BLEND);
//                    GL11.glEnable(GL11.GL_LIGHTING);
//                    GL11.glDepthFunc(GL11.GL_LEQUAL);
	        	
	        	
	        GL11.glPopMatrix();
	        
        Entity entity = new EntityItem(te.getWorldObj(), x, y, z, new ItemStack(ToeItems.ghostblade));

        if (entity != null)
        {
            entity.setWorld(te.getWorldObj());
            //float f1 = 0.4375F;
            //GL11.glTranslatef(0.0F, 0.4F, 0.0F);
            GL11.glRotatef(10.0F, 0.0F, 1.0F, 0.0F);
            //GL11.glRotatef((float)(p_147517_0_.field_98284_d + (p_147517_0_.field_98287_c - p_147517_0_.field_98284_d) * (double)p_147517_7_) * 10.0F, 0.0F, 1.0F, 0.0F);
            //GL11.glRotatef(-30.0F, 1.0F, 0.0F, 0.0F);
            //GL11.glTranslatef(0.0F, +0.4F, 0.0F);
            //GL11.glScalef(f1, f1, f1);
            entity.setLocationAndAngles(x, y, z, 0.0F, 0.0F);
            RenderManager.instance.renderEntityWithPosYaw(entity, 0.0D, 1.0D, 0.0D, f, f);
            //RenderManager.instance.renderEntitySimple(entity, f);
            //RenderManager.instance.renderEntityStatic(entity, f, true);
            //RenderManager.instance.render
        }
        
        
        
        GL11.glPopMatrix();
    }

    public void renderTileEntityAt(TileEntity te, double x, double y, double z, float f) {
        this.renderTileEntityAt((TileEntityLandmine)te, x, y, z, f);
    }
}