package com.abstractlabs.toe.client.renderer.tileentity;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.IBlockAccess;

import org.lwjgl.opengl.GL11;

import com.abstractlabs.toe.client.model.ModelPedestal;
import com.abstractlabs.toe.reference.Reference;
import com.abstractlabs.toe.tileentity.TileEntityPedestalStonebrick;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderPedestalStonebrick extends TileEntitySpecialRenderer implements ISimpleBlockRenderingHandler {
    private static final ResourceLocation texture = new ResourceLocation(Reference.MOD_ID + ":" + "textures/model/pedestalStonebrick.png");
    public static int pedestalID = 9130;
    
    private ModelPedestal model;
    private TileEntityPedestalStonebrick tile = new TileEntityPedestalStonebrick();
    
    public RenderPedestalStonebrick() {
        this.model = new ModelPedestal();
    }
    
    public void renderTileEntityAt(TileEntityPedestalStonebrick te, double x, double y, double z, float f) {
        GL11.glPushMatrix();
	        GL11.glTranslatef((float)x+0.5F, (float)y+1.5F, (float)z+0.5F);
	        GL11.glRotatef(180, 0F, 0F, 1F);
	        
	        this.bindTexture(new ResourceLocation(Reference.MOD_ID + ":" + "textures/model/pedestalStonebrick.png"));
	        
	        GL11.glPushMatrix();
	        	this.model.renderModel(0.0625F);
	        GL11.glPopMatrix();
        GL11.glPopMatrix();
    }

    public void renderTileEntityAt(TileEntity te, double x, double y, double z, float f) {
        this.renderTileEntityAt((TileEntityPedestalStonebrick)te, x, y, z, f);
    }

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer) {
//		//this.renderTileEntityAt(tile, 0D, -0D, 0D, 0F);
//		//GL11.glPushMatrix();
//	        //GL11.glTranslatef((float)0.5F, (float)1.5F, (float)0.5F);
//	        //GL11.glRotatef(180, 0F, 0F, 1F);
//	        
//	        this.bindTexture(new ResourceLocation(Reference.MOD_ID + ":" + "textures/model/pedestalStonebrick.png"));
//	        
//	        GL11.glPushMatrix();
//	        	this.model.renderModel(0.0625F);
//	        GL11.glPopMatrix();
//        //GL11.glPopMatrix();
		
		Tessellator tessellator = Tessellator.instance;
	    GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
	    tessellator.startDrawingQuads();
	    tessellator.setNormal(0.0F, -1.0F, 0.0F);
	    tessellator.addVertex(1, 1, 1);
	    renderer.renderFaceYNeg(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 0, metadata));
	    tessellator.draw();
	    tessellator.startDrawingQuads();
	    tessellator.setNormal(0.0F, 1.0F, 0.0F);
	    renderer.renderFaceYPos(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 1, metadata));
	    tessellator.draw();
	    tessellator.startDrawingQuads();
	    tessellator.setNormal(0.0F, 0.0F, -1.0F);
	    renderer.renderFaceZNeg(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 2, metadata));
	    tessellator.draw();
	    tessellator.startDrawingQuads();
	    tessellator.setNormal(0.0F, 0.0F, 1.0F);
	    renderer.renderFaceZPos(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 3, metadata));
	    tessellator.draw();
	    tessellator.startDrawingQuads();
	    tessellator.setNormal(-1.0F, 0.0F, 0.0F);
	    renderer.renderFaceXNeg(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 4, metadata));
	    tessellator.draw();
	    tessellator.startDrawingQuads();
	    tessellator.setNormal(1.0F, 0.0F, 0.0F);
	    renderer.renderFaceXPos(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 5, metadata));
	    tessellator.draw();
	    GL11.glTranslatef(0.5F, 0.5F, 0.5F);
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
		return pedestalID;
	}
}

/*package com.abstractlabs.toe.client.renderer.tileentity;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.IBlockAccess;

import org.lwjgl.opengl.GL11;

import com.abstractlabs.toe.client.model.ModelPedestal;
import com.abstractlabs.toe.reference.Reference;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;

*//**
 * Created with IntelliJ IDEA.
 * User: Ari
 * Date: 3/8/13
 * Time: 10:48 AM
 *//*
public class RenderPedestalStonebrick extends TileEntitySpecialRenderer implements ISimpleBlockRenderingHandler {
    private static final ResourceLocation texture = new ResourceLocation(Reference.MOD_ID + ":" + "textures/model/pedestalStonebrick.png");
    ModelPedestal model;
    public static int pedestalID = RenderingRegistry.getNextAvailableRenderId();

    public RenderPedestalStonebrick() {
        model = new ModelPedestal();
    }

    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float f) {
        GL11.glPushMatrix();
        GL11.glTranslatef((float) x, (float) y, (float) z);
        this.renderPedestal();
        GL11.glPopMatrix();
    }
    
    private void renderPedestal() {
    	GL11.glPushMatrix();

        //GL11.glTranslatef(0.5F, 0.5F, 0.5F);
        GL11.glRotatef((float) (360) + 180, 0.0F, 1.0F, 0.0F);
        //GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
        //GL11.glBindTexture(GL11.GL_TEXTURE_2D, FMLClientHandler.instance().getClient().renderEngine.getTexture(texture));
        this.bindTexture(texture);
        
        model.renderModel(0.0625F);

        GL11.glPopMatrix();
    }

    @Override
    public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer) {
        GL11.glPushMatrix();
        this.renderPedestal();
        GL11.glPopMatrix();
    }

    @Override
    public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
        return false; //TESR Overridden
    }

	@Override
	public boolean shouldRender3DInInventory(int modelId) {
		return true;
	}

    @Override
    public int getRenderId() {
        return pedestalID;
    }
}*/