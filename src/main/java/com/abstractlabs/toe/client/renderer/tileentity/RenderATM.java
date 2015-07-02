package com.abstractlabs.toe.client.renderer.tileentity;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.IBlockAccess;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import com.abstractlabs.toe.client.model.ModelATM;
import com.abstractlabs.toe.reference.Reference;
import com.abstractlabs.toe.reference.RenderID;
import com.abstractlabs.toe.tileentity.TileEntityATM;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderATM extends TileEntitySpecialRenderer implements ISimpleBlockRenderingHandler {
    private static final ResourceLocation texture = new ResourceLocation(Reference.MOD_ID + ":" + "textures/model/atm.png");
    private TileEntityATM tile = new TileEntityATM();
    
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
		
		        this.model.renderModel(0.0625F);
		        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
	        GL11.glPopMatrix();
        GL11.glPopMatrix();
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    }

    public void renderTileEntityAt(TileEntity te, double x, double y, double z, float f) {
    	this.bindTexture(texture);
        this.renderTileEntityAt((TileEntityATM)te, x, y, z, f);
    }

    /////////////////////////////////////
    
    @Override
	public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer) {
		GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
		GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
		FMLClientHandler.instance().getClient().getTextureManager().bindTexture(texture);
		renderTileEntityAt(tile, 0, 0, 0, 0);
		GL11.glEnable(GL12.GL_RESCALE_NORMAL);
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
		return false;
	}

	@Override
	public boolean shouldRender3DInInventory(int modelId) {
		return true;
	}

	@Override
	public int getRenderId() {
		return RenderID.atm;
	}
}