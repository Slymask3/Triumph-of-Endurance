package com.abstractlabs.toe.client.renderer.tileentity;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.IBlockAccess;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import com.abstractlabs.toe.client.model.ModelDisplayCase;
import com.abstractlabs.toe.reference.Reference;
import com.abstractlabs.toe.reference.RenderID;
import com.abstractlabs.toe.tileentity.TileEntityDisplayCase;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderDisplayCase extends TileEntitySpecialRenderer implements ISimpleBlockRenderingHandler{
    private static final ResourceLocation texture = new ResourceLocation(Reference.MOD_ID + ":" + "textures/model/displayCase.png");
    private TileEntityDisplayCase tile = new TileEntityDisplayCase();
    
    private ModelDisplayCase model;
    
    EntityItem entItem = null;
    
    public RenderDisplayCase() {
        this.model = new ModelDisplayCase();
    }
    
    public void renderTileEntityAt(TileEntityDisplayCase te, double x, double y, double z, float f) {
        GL11.glPushMatrix();
	        GL11.glTranslatef((float)x+0.5F, (float)y+1.5F, (float)z+0.5F);
	        GL11.glRotatef(180, 0F, 0F, 1F);
	        
	        GL11.glPushMatrix();
	        	this.model.renderModel(0.0625F);
	        GL11.glPopMatrix();
        GL11.glPopMatrix();
        
        if(te.getItemStack() != null) {
        	if(entItem == null || entItem.getEntityItem().getItem() != te.getItemStack().getItem()) {
	        	entItem = new EntityItem(te.getWorldObj(), x, y, z, te.getItemStack());
        	}
        	GL11.glPushMatrix();
		        this.entItem.hoverStart = 0.0F;
		        RenderItem.renderInFrame = true;
		        GL11.glTranslatef((float)x + 0.5F, (float)y + 0.1F, (float)z + 0.5F);
		        GL11.glRotatef(0, 0, 0, 1);
		        RenderManager.instance.renderEntityWithPosYaw(this.entItem, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
		        //RenderItem.renderInFrame = false;
		    GL11.glPopMatrix();
        }
    }

    public void renderTileEntityAt(TileEntity te, double x, double y, double z, float f) {
        this.bindTexture(texture);
        this.renderTileEntityAt((TileEntityDisplayCase)te, x, y, z, f);
    }
    
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
		return RenderID.displayCase;
	}
}