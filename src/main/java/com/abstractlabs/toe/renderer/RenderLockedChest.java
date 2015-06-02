package com.abstractlabs.toe.renderer;

import net.minecraft.block.Block;
import net.minecraft.client.model.ModelChest;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import com.abstractlabs.toe.reference.Reference;
import com.abstractlabs.toe.tileentity.TileEntityLockedChest;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderLockedChest extends TileEntitySpecialRenderer {
    private static final ResourceLocation texture = new ResourceLocation(Reference.MOD_ID + ":" + "textures/model/lockedChest.png");

    private ModelChest model;
    
    public RenderLockedChest() {
        this.model = new ModelChest();
    }

    public void renderTileEntityAt(TileEntityLockedChest te, double x, double y, double z, float f) {
//        GL11.glPushMatrix();
//	        GL11.glTranslatef((float)x, (float)y+1F, (float)z);
//	        GL11.glRotatef(180, 0F, 0F, 1F);
//	        
//	        this.bindTexture(texture);
//	        
//	        GL11.glPushMatrix();
//	        	this.model.renderAll();
//	        GL11.glPopMatrix();
//        GL11.glPopMatrix();
        
        int meta;

        if (!te.hasWorldObj()) {
            meta = 0;
        } else {
            Block block = te.getBlockType();
            meta = te.getBlockMetadata();
        }
        
        this.bindTexture(texture);

        GL11.glPushMatrix();
	        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
	        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	        GL11.glTranslatef((float)x, (float)y + 1.0F, (float)z + 1.0F);
	        GL11.glScalef(1.0F, -1.0F, -1.0F);
	        GL11.glTranslatef(0.5F, 0.5F, 0.5F);
	        short short1 = 0;
	
	        if (meta == 0) {
	            short1 = 0;
	        }
	
	        if (meta == 1) {
	            short1 = 90;
	        }
	
	        if (meta == 2) {
	            short1 = 180;
	        }
	
	        if (meta == 3) {
	            short1 = -90;
	        }
	
	        GL11.glRotatef((float)short1, 0.0F, 1.0F, 0.0F);
	        GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
	
	        model.renderAll();
	        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        GL11.glPopMatrix();
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    }

    public void renderTileEntityAt(TileEntity te, double x, double y, double z, float f) {
        this.renderTileEntityAt((TileEntityLockedChest)te, x, y, z, f);
    }
}