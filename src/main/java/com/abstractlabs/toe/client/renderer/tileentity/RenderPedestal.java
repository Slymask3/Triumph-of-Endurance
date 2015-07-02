package com.abstractlabs.toe.client.renderer.tileentity;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.IBlockAccess;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import com.abstractlabs.toe.block.BlockPedestal;
import com.abstractlabs.toe.client.model.ModelPedestal;
import com.abstractlabs.toe.reference.Reference;
import com.abstractlabs.toe.reference.RenderID;
import com.abstractlabs.toe.tileentity.TileEntityPedestal;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderPedestal extends TileEntitySpecialRenderer implements ISimpleBlockRenderingHandler {
    private static final ResourceLocation textureStonebrick = new ResourceLocation(Reference.MOD_ID + ":" + "textures/model/pedestalStonebrick.png");
    private static final ResourceLocation texturePlanks = new ResourceLocation(Reference.MOD_ID + ":" + "textures/model/pedestalPlanks.png");
    private static final ResourceLocation textureBrick = new ResourceLocation(Reference.MOD_ID + ":" + "textures/model/pedestalBrick.png");
    private static final ResourceLocation textureQuartz = new ResourceLocation(Reference.MOD_ID + ":" + "textures/model/pedestalQuartz.png");
    private TileEntityPedestal tileStonebrick = new TileEntityPedestal("stonebrick");
    private TileEntityPedestal tilePlanks = new TileEntityPedestal("planks");
    private TileEntityPedestal tileBrick = new TileEntityPedestal("brick");
    private TileEntityPedestal tileQuartz = new TileEntityPedestal("quartz");
    
    private ModelPedestal model;
    
    public RenderPedestal() {
        this.model = new ModelPedestal();
    }
    
    public void renderTileEntityAt(TileEntityPedestal te, double x, double y, double z, float f) {
        GL11.glPushMatrix();
	        GL11.glTranslatef((float)x+0.5F, (float)y+1.5F, (float)z+0.5F);
	        GL11.glRotatef(180, 0F, 0F, 1F);
	        
	        GL11.glPushMatrix();
	        	this.model.renderModel(0.0625F);
	        GL11.glPopMatrix();
        GL11.glPopMatrix();
    }

    public void renderTileEntityAt(TileEntity te, double x, double y, double z, float f) {
    	if(((TileEntityPedestal) te).getType().equalsIgnoreCase("stonebrick")) {
        	this.bindTexture(textureStonebrick);
    	} else if(((TileEntityPedestal) te).getType().equalsIgnoreCase("planks")) {
        	this.bindTexture(texturePlanks);
    	} else if(((TileEntityPedestal) te).getType().equalsIgnoreCase("brick")) {
        	this.bindTexture(textureBrick);
    	} else if(((TileEntityPedestal) te).getType().equalsIgnoreCase("quartz")) {
        	this.bindTexture(textureQuartz);
    	}
        this.renderTileEntityAt((TileEntityPedestal)te, x, y, z, f);
    }

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer) {
		GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
		GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
		
    	if(((BlockPedestal) block).getType().equalsIgnoreCase("stonebrick")) {
    		FMLClientHandler.instance().getClient().getTextureManager().bindTexture(textureStonebrick);
    		renderTileEntityAt(tileStonebrick, 0, 0, 0, 0);
    	} else if(((BlockPedestal) block).getType().equalsIgnoreCase("planks")) {
    		FMLClientHandler.instance().getClient().getTextureManager().bindTexture(texturePlanks);
    		renderTileEntityAt(tilePlanks, 0, 0, 0, 0);
    	} else if(((BlockPedestal) block).getType().equalsIgnoreCase("brick")) {
    		FMLClientHandler.instance().getClient().getTextureManager().bindTexture(textureBrick);
    		renderTileEntityAt(tileBrick, 0, 0, 0, 0);
    	} else if(((BlockPedestal) block).getType().equalsIgnoreCase("quartz")) {
    		FMLClientHandler.instance().getClient().getTextureManager().bindTexture(textureQuartz);
    		renderTileEntityAt(tileQuartz, 0, 0, 0, 0);
    	}
    	
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
		return RenderID.pedestal;
	}
}