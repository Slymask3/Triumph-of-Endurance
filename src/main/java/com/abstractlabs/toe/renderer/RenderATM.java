package com.abstractlabs.toe.renderer;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.IBlockAccess;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import com.abstractlabs.toe.model.ModelATM;
import com.abstractlabs.toe.reference.Reference;
import com.abstractlabs.toe.reference.Smelting;
import com.abstractlabs.toe.tileentity.TileEntityATM;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderATM extends TileEntitySpecialRenderer implements ISimpleBlockRenderingHandler {
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
	
	//	        float f1 = 0.6666667F;
	//	        float f3;
	//	        
	//	        f3 = 0.016666668F * f1;
	//	        GL11.glScalef(f3, -f3, f3);
	//
	//	        Helper.drawCenteredStringWithBorder(Minecraft.getMinecraft(), (int)x, (int)z, "ATM", 0xFFFFFF, 0x000000);
		        
		        //fontrenderer.drawString(s, -fontrenderer.getStringWidth(s) / 2, i * 10 - p_147500_1_.signText.length * 5, b0);
		        
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

    /////////////////////////////////////
    
    @Override
	public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer) {
		int meta=3;
		Tessellator tessellator = Tessellator.instance;
		block.setBlockBoundsForItemRender();
		renderer.setRenderBoundsFromBlock(block);
		GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
		GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
		tessellator.startDrawingQuads();
		tessellator.setNormal(0.0F, -1.0F, 0.0F);
		renderer.renderFaceYNeg(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 0, meta));
		tessellator.draw();
		tessellator.startDrawingQuads();
		tessellator.setNormal(0.0F, 1.0F, 0.0F);
		renderer.renderFaceYPos(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 1, meta));
		tessellator.draw();
		tessellator.startDrawingQuads();
		tessellator.setNormal(0.0F, 0.0F, -1.0F);
		renderer.renderFaceZNeg(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 2, meta));
		tessellator.draw();
		tessellator.startDrawingQuads();
		tessellator.setNormal(0.0F, 0.0F, 1.0F);
		renderer.renderFaceZPos(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 3, meta));
		tessellator.draw();
		tessellator.startDrawingQuads();
		tessellator.setNormal(-1.0F, 0.0F, 0.0F);
		renderer.renderFaceXNeg(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 4, meta));
		tessellator.draw();
		tessellator.startDrawingQuads();
		tessellator.setNormal(1.0F, 0.0F, 0.0F);
		renderer.renderFaceXPos(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 5, meta));
		tessellator.draw();
		GL11.glTranslatef(0.5F, 0.5F, 0.5F);
	}
	
	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
		 int direction = renderer.blockAccess.getBlockMetadata(x, y, z) & 3;
		 if(direction>0)
			 renderer.uvRotateTop = direction-1;
		 else
			 renderer.uvRotateTop = 3;
		 boolean flag = renderer.renderStandardBlock(block, x, y, z);
		 renderer.uvRotateTop = 0;
		 return flag;
	}
	
	@Override
	public int getRenderId() {
		return 7356;
	}
	
	@Override
	public boolean shouldRender3DInInventory(int modelId) {
		return true;
	}
}