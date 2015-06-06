package com.abstractlabs.toe.renderer;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import com.abstractlabs.toe.model.ModelATM;
import com.abstractlabs.toe.reference.Reference;
import com.abstractlabs.toe.tileentity.TileEntityATM;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderATM extends TileEntitySpecialRenderer {
	//static RenderATM instance = new RenderATM();
	
    //private static final ResourceLocation texture = new ResourceLocation(Reference.MOD_ID + ":" + "textures/model/atm.png");
    
    private ModelATM model;
    
    public RenderATM() {
        this.model = new ModelATM();
    }
    
    public void renderTileEntityAt(TileEntityATM te, double x, double y, double z, float f) {
    	int meta;

        if (!te.hasWorldObj()) {
            meta = 0;
        } else {
            Block block = te.getBlockType();
            meta = te.getBlockMetadata();
        }

        GL11.glPushMatrix();
        GL11.glPushMatrix();
	        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
	        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	        GL11.glTranslatef((float)x+0.5F, (float)y + 1.5F, (float)z+0.5F);
	        GL11.glScalef(1.0F, -1.0F, -1.0F);
	        //GL11.glTranslatef(0.5F, 0.5F, 0.5F);
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

	        this.bindTexture(new ResourceLocation(Reference.MOD_ID + ":" + "textures/model/atm.png"));
	        
	        GL11.glRotatef((float)short1, 0.0F, 1.0F, 0.0F);
	       // GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
	
	        this.model.renderModel(0.0625F);
	        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
	        GL11.glPopMatrix();
        GL11.glPopMatrix();
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    }

    public void renderTileEntityAt(TileEntity te, double x, double y, double z, float f) {
        this.renderTileEntityAt((TileEntityATM)te, x, y, z, f);
    }
}