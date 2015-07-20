package com.abstractlabs.toe.client.renderer.tileentity;

import net.minecraft.block.Block;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import com.abstractlabs.toe.client.model.ModelStatueBiped;
import com.abstractlabs.toe.reference.RenderID;
import com.abstractlabs.toe.tileentity.TileEntityStatueBiped;
import com.abstractlabs.toe.utility.Helper;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderStatueBiped extends TileEntitySpecialRenderer implements ISimpleBlockRenderingHandler {
    private ModelStatueBiped model;
    private TileEntityStatueBiped tile = new TileEntityStatueBiped();
    
    public RenderStatueBiped() {
        this.model = new ModelStatueBiped();
    }
    
    public void renderTileEntityAt(TileEntityStatueBiped te, double x, double y, double z, float f) {
        GL11.glPushMatrix();
	        GL11.glTranslatef((float)x+0.5F, (float)y+1.5F, (float)z+0.5F);
	        GL11.glRotatef(180, 0F, 0F, 1F);
	        
	        int meta;
	        short degrees = 0;

	        if (!te.hasWorldObj()) {
	            meta = 3;
	        } else {
	            Block block = te.getBlockType();
	            meta = te.getBlockMetadata();
	        }
	        
	        if (meta == 0) {
	        	degrees = 180;
	        } else if (meta == 1) {
	        	degrees = -90;
	        } else if (meta == 2) {
	        	degrees = 0;
	        } else if (meta == 3) {
	        	degrees = 90;
	        }

	        GL11.glRotatef((float)degrees, 0.0F, 1.0F, 0.0F);
	        
//	        this.bindTexture(Helper.getResourceLocationFromName(te.getUsername()));
	        
//	        LogHelper.info("[RenderStatue] te.getUsername() == " + te.getUsername());
	        
	        //GL11.glColor3f(0.5F, 0.5F, 0.5F);
	        //GL11.glColor3f(127, 127, 127);
	        
//	        GL11.glEnable(GL11.GL_BLEND);
//	        GL11.glBlendFunc(GL11.GL_DST_COLOR, GL11.GL_SRC_COLOR);
	        
	        //GL20.glCreateShader(GL20.GL_VERTEX_SHADER);
	        //GL11.glColorMask(true, false, true, true);
	        //GL11.glShadeModel(GL11.GL_FLAT);
	        
	        //GL11.glEnable(GL11.GL_DEPTH_TEST);
	        
//	        GL11.glEnable(GL11.GL_BLEND);
//	        GL11.glColor4f(0.1F, 0.1F, 0.1F, 0.5F);
//	        
//	        GL11.glColorMaterial(face, mode);
	        
//	        GL11.glEnable(GL11.GL_COLOR_MATERIAL);          
//	        GL11.glColorMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE);

	        //GL11.glColor3f(100000.0F, 100000.0F, 100000.0F);
//	        GL11.glDisable(GL11.GL_LIGHTING);
//	        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240f, 240f);
	        
	        //GL11.glTexImage2D(GL11.GL_TEXTURE_2D, 0, GL11.GL_RGBA, 10, 10, 0, GL11.GL_LUMINANCE, GL11.GL_UNSIGNED_BYTE, );
	        
//	        //GL11.glViewport(0, 0, w, h);
//	        GL11.glMatrixMode(GL11.GL_PROJECTION);
//	        GL11.glLoadIdentity();
//	        //GLU.gluPerspective(45.0f, ((float) w / (float) h), 0.1f, 100.0f);
//	        GL11.glMatrixMode(GL11.GL_MODELVIEW);
//	        GL11.glLoadIdentity();
//	        GL11.glShadeModel(GL11.GL_SMOOTH);
//	        GL11.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
//	        GL11.glClearDepth(1.0f);
//	        GL11.glEnable(GL11.GL_DEPTH_TEST);
//	        GL11.glDepthFunc(GL11.GL_LEQUAL);
//	        GL11.glHint(GL11.GL_PERSPECTIVE_CORRECTION_HINT, GL11.GL_NICEST);
	        
	        //GL20.glAttachShader(GL20.GL_INT_VEC2, GL20.GL_SHADER_TYPE);
	        
//	        EntityCow cow = new EntityCow(null);
//	        cow.setAIMoveSpeed(p_70659_1_);
	        
	        GL11.glPushMatrix();
	        	this.model.renderModel(0.0625F);
	        GL11.glPopMatrix();
	        
//	        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glPopMatrix();
    }

    public void renderTileEntityAt(TileEntity te, double x, double y, double z, float f) {
        this.bindTexture(Helper.getResourceLocationFromName(((TileEntityStatueBiped) te).getUsername()));
        this.renderTileEntityAt((TileEntityStatueBiped)te, x, y, z, f);
    }

    @Override
	public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer) {
		//GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
		//GL11.glTranslatef(-0.5F, -0.725F, -0.25F);
		GL11.glTranslatef(-0.5F, -0.9F, -0.5F);
		GL11.glScalef(0.8F, 0.8F, 0.8F);
		
		FMLClientHandler.instance().getClient().getTextureManager().bindTexture(AbstractClientPlayer.locationStevePng);
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
		return RenderID.statueBiped;
	}
}