package com.abstractlabs.toe.client.renderer.tileentity;

import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.abstractlabs.toe.client.model.ModelLandmine;
import com.abstractlabs.toe.init.ToeItems;
import com.abstractlabs.toe.reference.Reference;
import com.abstractlabs.toe.tileentity.TileEntityLandmine;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderLandmine extends TileEntitySpecialRenderer {
    private static final ResourceLocation texture = new ResourceLocation(Reference.MOD_ID + ":" + "textures/model/landmine.png");
    private static final ResourceLocation RES_ITEM_GLINT = new ResourceLocation("textures/misc/enchanted_item_glint.png");
    
    private ModelLandmine model;
    //protected RenderManager renderManager = Minecraft.getMinecraft().entityRenderer;
    private Random random = new Random();
    ItemStack stack = new ItemStack(ToeItems.ghostblade, 1, 0);
    EntityItem entItem = new EntityItem(Minecraft.getMinecraft().theWorld, 0D, 0D, 0D, stack);
    
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
//	        	
//	        	EntityItem item = new EntityItem(te.getWorldObj(), x, y, z, new ItemStack(ToeItems.ghostblade));
//	            RenderItem ritem = new RenderItem();
	            //ritem.doRender(item, x, y, z, f, 0.0F);
	            //renderDroppedItem(ritem, item, item.getEntityItem().getIconIndex(), 0, 0, 0, 0, 0, 0);
	            
//	        	Tessellator tessellator = Tessellator.instance;
//	        	
//	        	
//                    GL11.glDepthFunc(GL11.GL_EQUAL);
//                    GL11.glDisable(GL11.GL_LIGHTING);
//                    this.renderManager.renderEngine.bindTexture(RES_ITEM_GLINT);
//                    GL11.glEnable(GL11.GL_BLEND);
//                    GL11.glBlendFunc(GL11.GL_SRC_COLOR, GL11.GL_ONE);
//                    float f11 = 0.76F;
//                    GL11.glColor4f(0.5F * f11, 0.25F * f11, 0.8F * f11, 1.0F);
//                    GL11.glMatrixMode(GL11.GL_TEXTURE);
//                    GL11.glPushMatrix();
//                    float f12 = 0.125F;
//                    GL11.glScalef(f12, f12, f12);
//                    float f13 = (float)(Minecraft.getSystemTime() % 3000L) / 3000.0F * 8.0F;
//                    GL11.glTranslatef(f13, 0.0F, 0.0F);
//                    GL11.glRotatef(-50.0F, 0.0F, 0.0F, 1.0F);
//                    ItemRenderer.renderItemIn2D(tessellator, 0.0F, 0.0F, 1.0F, 1.0F, 255, 255, f9);
//                    GL11.glPopMatrix();
//                    GL11.glPushMatrix();
//                    GL11.glScalef(f12, f12, f12);
//                    f13 = (float)(Minecraft.getSystemTime() % 4873L) / 4873.0F * 8.0F;
//                    GL11.glTranslatef(-f13, 0.0F, 0.0F);
//                    GL11.glRotatef(10.0F, 0.0F, 0.0F, 1.0F);
//                    ItemRenderer.renderItemIn2D(tessellator, 0.0F, 0.0F, 1.0F, 1.0F, 255, 255, f9);
//                    GL11.glPopMatrix();
//                    GL11.glMatrixMode(GL11.GL_MODELVIEW);
//                    GL11.glDisable(GL11.GL_BLEND);
//                    GL11.glEnable(GL11.GL_LIGHTING);
//                    GL11.glDepthFunc(GL11.GL_LEQUAL);
	        	
	        	
	        GL11.glPopMatrix();
	        
//        Entity entity = new EntityItem(te.getWorldObj(), x, y, z, new ItemStack(ToeItems.ghostblade));
//
//        if (entity != null)
//        {
//            entity.setWorld(te.getWorldObj());
//            //float f1 = 0.4375F;
//            //GL11.glTranslatef(0.0F, 0.4F, 0.0F);
//            GL11.glRotatef(10.0F, 0.0F, 1.0F, 0.0F);
//            //GL11.glRotatef((float)(p_147517_0_.field_98284_d + (p_147517_0_.field_98287_c - p_147517_0_.field_98284_d) * (double)p_147517_7_) * 10.0F, 0.0F, 1.0F, 0.0F);
//            //GL11.glRotatef(-30.0F, 1.0F, 0.0F, 0.0F);
//            //GL11.glTranslatef(0.0F, +0.4F, 0.0F);
//            //GL11.glScalef(f1, f1, f1);
//            entity.setLocationAndAngles(x, y, z, 0.0F, 0.0F);
//            RenderManager.instance.renderEntityWithPosYaw(entity, 0.0D, 1.0D, 0.0D, f, f);
//            //RenderManager.instance.renderEntitySimple(entity, f);
//            //RenderManager.instance.renderEntityStatic(entity, f, true);
//            //RenderManager.instance.render
//        }
//        
        
        
        
        
        GL11.glPopMatrix();
        
        
        GL11.glPushMatrix();
	    	//Without the below line, the item will spazz out
		    this.entItem.hoverStart = 0.0F;
		    //RenderItem.renderInFrame = true;
		    GL11.glTranslatef((float)x + 0.5F, (float)y + 1.02F, (float)z + 0.3F);
		    GL11.glRotatef(0, 0, 0, 1);
		    RenderManager.instance.renderEntityWithPosYaw(this.entItem, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
		    //RenderItem.renderInFrame = false;
	    GL11.glPopMatrix();
    }

    public void renderTileEntityAt(TileEntity te, double x, double y, double z, float f) {
        this.renderTileEntityAt((TileEntityLandmine)te, x, y, z, f);
    }
    
    
    
    
//    private void renderDroppedItem(RenderItem ritem, EntityItem p_77020_1_, IIcon p_77020_2_, int p_77020_3_, float p_77020_4_, float p_77020_5_, float p_77020_6_, float p_77020_7_, int pass)
//    {
//        Tessellator tessellator = Tessellator.instance;
//
//        if (p_77020_2_ == null)
//        {
//            TextureManager texturemanager = Minecraft.getMinecraft().getTextureManager();
//            ResourceLocation resourcelocation = texturemanager.getResourceLocation(p_77020_1_.getEntityItem().getItemSpriteNumber());
//            p_77020_2_ = ((TextureMap)texturemanager.getTexture(resourcelocation)).getAtlasSprite("missingno");
//        }
//
//        float f14 = ((IIcon)p_77020_2_).getMinU();
//        float f15 = ((IIcon)p_77020_2_).getMaxU();
//        float f4 = ((IIcon)p_77020_2_).getMinV();
//        float f5 = ((IIcon)p_77020_2_).getMaxV();
//        float f6 = 1.0F;
//        float f7 = 0.5F;
//        float f8 = 0.25F;
//        float f10;
//
//        if (this.renderManager.options.fancyGraphics)
//        {
//            GL11.glPushMatrix();
//
////            if (renderInFrame)
////            {
////                GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
////            }
////            else
////            {
//                GL11.glRotatef((((float)p_77020_1_.age + p_77020_4_) / 20.0F + p_77020_1_.hoverStart) * (180F / (float)Math.PI), 0.0F, 1.0F, 0.0F);
////            }
//
//            float f9 = 0.0625F;
//            f10 = 0.021875F;
//            ItemStack itemstack = p_77020_1_.getEntityItem();
//            int j = itemstack.stackSize;
//            byte b0;
//
//            if (j < 2)
//            {
//                b0 = 1;
//            }
//            else if (j < 16)
//            {
//                b0 = 2;
//            }
//            else if (j < 32)
//            {
//                b0 = 3;
//            }
//            else
//            {
//                b0 = 4;
//            }
//
//            //b0 = getMiniItemCount(itemstack, b0);
//
//            GL11.glTranslatef(-f7, -f8, -((f9 + f10) * (float)b0 / 2.0F));
//
//            for (int k = 0; k < b0; ++k)
//            {
//                // Makes items offset when in 3D, like when in 2D, looks much better. Considered a vanilla bug...
//                if (k > 0/* && shouldSpreadItems()*/)
//                {
//                    float x = (random.nextFloat() * 2.0F - 1.0F) * 0.3F / 0.5F;
//                    float y = (random.nextFloat() * 2.0F - 1.0F) * 0.3F / 0.5F;
//                    float z = (random.nextFloat() * 2.0F - 1.0F) * 0.3F / 0.5F;
//                    GL11.glTranslatef(x, y, f9 + f10);
//                }
//                else
//                {
//                    GL11.glTranslatef(0f, 0f, f9 + f10);
//                }
//
//                if (itemstack.getItemSpriteNumber() == 0)
//                {
//                    this.bindTexture(TextureMap.locationBlocksTexture);
//                }
//                else
//                {
//                    this.bindTexture(TextureMap.locationItemsTexture);
//                }
//
//                GL11.glColor4f(p_77020_5_, p_77020_6_, p_77020_7_, 1.0F);
//                ItemRenderer.renderItemIn2D(tessellator, f15, f4, f14, f5, ((IIcon)p_77020_2_).getIconWidth(), ((IIcon)p_77020_2_).getIconHeight(), f9);
//
//                if (itemstack.hasEffect(pass))
//                {
//                    GL11.glDepthFunc(GL11.GL_EQUAL);
//                    GL11.glDisable(GL11.GL_LIGHTING);
//                    this.renderManager.renderEngine.bindTexture(RES_ITEM_GLINT);
//                    GL11.glEnable(GL11.GL_BLEND);
//                    GL11.glBlendFunc(GL11.GL_SRC_COLOR, GL11.GL_ONE);
//                    float f11 = 0.76F;
//                    GL11.glColor4f(0.5F * f11, 0.25F * f11, 0.8F * f11, 1.0F);
//                    GL11.glMatrixMode(GL11.GL_TEXTURE);
//                    GL11.glPushMatrix();
//                    float f12 = 0.125F;
//                    GL11.glScalef(f12, f12, f12);
//                    float f13 = (float)(Minecraft.getSystemTime() % 3000L) / 3000.0F * 8.0F;
//                    GL11.glTranslatef(f13, 0.0F, 0.0F);
//                    GL11.glRotatef(-50.0F, 0.0F, 0.0F, 1.0F);
//                    ItemRenderer.renderItemIn2D(tessellator, 0.0F, 0.0F, 1.0F, 1.0F, 255, 255, f9);
//                    GL11.glPopMatrix();
//                    GL11.glPushMatrix();
//                    GL11.glScalef(f12, f12, f12);
//                    f13 = (float)(Minecraft.getSystemTime() % 4873L) / 4873.0F * 8.0F;
//                    GL11.glTranslatef(-f13, 0.0F, 0.0F);
//                    GL11.glRotatef(10.0F, 0.0F, 0.0F, 1.0F);
//                    ItemRenderer.renderItemIn2D(tessellator, 0.0F, 0.0F, 1.0F, 1.0F, 255, 255, f9);
//                    GL11.glPopMatrix();
//                    GL11.glMatrixMode(GL11.GL_MODELVIEW);
//                    GL11.glDisable(GL11.GL_BLEND);
//                    GL11.glEnable(GL11.GL_LIGHTING);
//                    GL11.glDepthFunc(GL11.GL_LEQUAL);
//                }
//            }
//
//            GL11.glPopMatrix();
//        }
//        else
//        {
//            for (int l = 0; l < p_77020_3_; ++l)
//            {
//                GL11.glPushMatrix();
//
//                if (l > 0)
//                {
//                    f10 = (this.random.nextFloat() * 2.0F - 1.0F) * 0.3F;
//                    float f16 = (this.random.nextFloat() * 2.0F - 1.0F) * 0.3F;
//                    float f17 = (this.random.nextFloat() * 2.0F - 1.0F) * 0.3F;
//                    GL11.glTranslatef(f10, f16, f17);
//                }
//
////                if (!renderInFrame)
////                {
//                    GL11.glRotatef(180.0F - this.renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
////                }
//
//                GL11.glColor4f(p_77020_5_, p_77020_6_, p_77020_7_, 1.0F);
//                tessellator.startDrawingQuads();
//                tessellator.setNormal(0.0F, 1.0F, 0.0F);
//                tessellator.addVertexWithUV((double)(0.0F - f7), (double)(0.0F - f8), 0.0D, (double)f14, (double)f5);
//                tessellator.addVertexWithUV((double)(f6 - f7), (double)(0.0F - f8), 0.0D, (double)f15, (double)f5);
//                tessellator.addVertexWithUV((double)(f6 - f7), (double)(1.0F - f8), 0.0D, (double)f15, (double)f4);
//                tessellator.addVertexWithUV((double)(0.0F - f7), (double)(1.0F - f8), 0.0D, (double)f14, (double)f4);
//                tessellator.draw();
//                GL11.glPopMatrix();
//            }
//        }
//    }
}