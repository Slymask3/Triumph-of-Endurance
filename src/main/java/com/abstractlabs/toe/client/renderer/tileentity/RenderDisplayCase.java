package com.abstractlabs.toe.client.renderer.tileentity;

import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.abstractlabs.toe.client.model.ModelDisplayCase;
import com.abstractlabs.toe.reference.Reference;
import com.abstractlabs.toe.tileentity.TileEntityDisplayCase;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderDisplayCase extends TileEntitySpecialRenderer {
    private static final ResourceLocation texture = new ResourceLocation(Reference.MOD_ID + ":" + "textures/model/displayCase.png");
    
    private ModelDisplayCase model;
    
//    ItemStack stack = new ItemStack(ToeItems.ghostblade, 1, 0);
//    EntityItem entItem = new EntityItem(Minecraft.getMinecraft().theWorld, 0D, 0D, 0D, stack);
    EntityItem entItem = null;
    
    public RenderDisplayCase() {
        this.model = new ModelDisplayCase();
    }
    
    public void renderTileEntityAt(TileEntityDisplayCase te, double x, double y, double z, float f) {
        GL11.glPushMatrix();
	        GL11.glTranslatef((float)x+0.5F, (float)y+1.5F, (float)z+0.5F);
	        GL11.glRotatef(180, 0F, 0F, 1F);
	        
	        this.bindTexture(texture);
	        
	        GL11.glPushMatrix();
	        	this.model.renderModel(0.0625F);
	        GL11.glPopMatrix();
        
//        GL11.glPushMatrix();
//	    	//Without the below line, the item will spazz out
//		    this.entItem.hoverStart = 0.0F;
//		    //RenderItem.renderInFrame = true;
//		    GL11.glTranslatef((float)x + 0.5F, (float)y + 1.02F, (float)z + 0.3F);
//		    GL11.glRotatef(0, 0, 0, 1);
//		    RenderManager.instance.renderEntityWithPosYaw(this.entItem, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
//		    //RenderItem.renderInFrame = false;
//	    GL11.glPopMatrix();
        
        //int slot = 0; //Example: int slot = 1;
        //TileEntityMyBlock tileEntity = (TileEntityMyBlock)tile;
	        
	        
	        
//		    if(te.getItemStack() != null && ((entItem == null) || entItem.getEntityItem().getItem() != te.getItemStack().getItem()))
//		    	entItem = new EntityItem(te.getWorldObj(), x, y, z, te.getItemStack());
//		    GL11.glPushMatrix();
//		        this.entItem.hoverStart = 0.0F;
//		        RenderItem.renderInFrame = true;
//		        GL11.glTranslatef((float)x + 0.5F, (float)y + 0.6F, (float)z + 0.5F);
//		        GL11.glRotatef(0, 0, 0, 1);
//		        RenderManager.instance.renderEntityWithPosYaw(this.entItem, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
//		        RenderItem.renderInFrame = false;
//		    GL11.glPopMatrix();
		    
		    
		    
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
		        RenderItem.renderInFrame = false;
		    GL11.glPopMatrix();
        }
    }

    public void renderTileEntityAt(TileEntity te, double x, double y, double z, float f) {
        this.renderTileEntityAt((TileEntityDisplayCase)te, x, y, z, f);
    }
}