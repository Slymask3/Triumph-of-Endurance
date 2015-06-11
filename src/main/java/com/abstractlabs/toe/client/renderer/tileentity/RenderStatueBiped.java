package com.abstractlabs.toe.client.renderer.tileentity;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.abstractlabs.toe.client.model.ModelStatueBiped;
import com.abstractlabs.toe.tileentity.TileEntityStatueBiped;
import com.abstractlabs.toe.utility.Helper;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderStatueBiped extends TileEntitySpecialRenderer {
    //private static final ResourceLocation texture = new ResourceLocation(Reference.MOD_ID + ":" + "textures/entity/mob/boi.png");
    private static final ResourceLocation texture = Helper.getResourceLocation("HotMixtape");
//    private static final ResourceLocation texture = AbstractClientPlayer.getLocationSkin("Slymask3");
//    private static final ResourceLocation texture = AbstractClientPlayer.locationStevePng;
    
    //private static AbstractClientPlayer acp = Minecraft.getMinecraft().thePlayer;
    //private static final ResourceLocation texture = acp.getLocationSkin();
	
//	private static Minecraft mc = Minecraft.getMinecraft();
//	private static EntityPlayer player = Minecraft.getMinecraft().thePlayer;
//    private static Map map = mc.func_152342_ad().func_152788_a(player.getGameProfile());
//	
//	private static final ResourceLocation texture = mc.func_152342_ad().func_152792_a((MinecraftProfileTexture)map.get(Type.SKIN), Type.SKIN);
    //IResourcePack
    
    private ModelStatueBiped model;
    
    public RenderStatueBiped() {
        this.model = new ModelStatueBiped();
    }
    
    public void renderTileEntityAt(TileEntityStatueBiped te, double x, double y, double z, float f) {
        GL11.glPushMatrix();
	        GL11.glTranslatef((float)x+0.5F, (float)y+1.5F, (float)z+0.5F);
	        GL11.glRotatef(180, 0F, 0F, 1F);

//	        MinecraftServer server = MinecraftServer.getServer();
//	        EntityPlayer player2 = server.getConfigurationManager().func_152612_a("HotMixtape");
//	        
//	        Minecraft mc = Minecraft.getMinecraft();
////	    	EntityPlayer player = Minecraft.getMinecraft().thePlayer;
//	        
//	        Map map = mc.func_152342_ad().func_152788_a(te.getGameProfile());
//	        ResourceLocation texture = mc.func_152342_ad().func_152792_a((MinecraftProfileTexture)map.get(Type.SKIN), Type.SKIN);
	        
	        this.bindTexture(texture);
	        
	        GL11.glPushMatrix();
	        	this.model.renderModel(0.0625F);
	        GL11.glPopMatrix();
        GL11.glPopMatrix();
    }

    public void renderTileEntityAt(TileEntity te, double x, double y, double z, float f) {
        this.renderTileEntityAt((TileEntityStatueBiped)te, x, y, z, f);
    }
}