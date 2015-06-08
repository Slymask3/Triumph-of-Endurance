package com.abstractlabs.toe.renderer;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.abstractlabs.toe.model.ModelLandmine;
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
	        GL11.glTranslatef((float)x+0.5F, (float)y+1.5F, (float)z+0.5F);
	        GL11.glRotatef(180, 0F, 0F, 1F);
	        
	        this.bindTexture(texture);
	        
	        GL11.glPushMatrix();
	        	this.model.renderModel(0.0625F);
	        GL11.glPopMatrix();
        GL11.glPopMatrix();
    }

    public void renderTileEntityAt(TileEntity te, double x, double y, double z, float f) {
        this.renderTileEntityAt((TileEntityLandmine)te, x, y, z, f);
    }
}