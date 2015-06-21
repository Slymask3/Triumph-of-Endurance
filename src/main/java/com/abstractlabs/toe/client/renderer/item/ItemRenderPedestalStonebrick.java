package com.abstractlabs.toe.client.renderer.item;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

import com.abstractlabs.toe.client.model.ModelPedestal;
import com.abstractlabs.toe.reference.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ItemRenderPedestalStonebrick implements IItemRenderer
{
 private static final ResourceLocation texture = new ResourceLocation(Reference.MOD_ID, "textures/model/pedestalStonebrick.png");

private final ModelPedestal model = new ModelPedestal();

private final Minecraft mc;

public ItemRenderPedestalStonebrick() {
 mc = Minecraft.getMinecraft();
 }

@Override
 public boolean handleRenderType(ItemStack item, ItemRenderType type) {
 return type != ItemRenderType.FIRST_PERSON_MAP && type != ItemRenderType.INVENTORY;
 }

@Override
 public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
 return type == ItemRenderType.ENTITY && (helper == ItemRendererHelper.ENTITY_BOBBING || helper == ItemRendererHelper.ENTITY_ROTATION);
 }

@Override
 public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
 GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
 GL11.glPushMatrix();
 mc.renderEngine.bindTexture(texture);
 if(data[1] instanceof EntityPlayer) {
 if (type == ItemRenderType.EQUIPPED) {
 //TODO add gltranslate/rotate 
 } 
 else {
 //TODO add gltranslate/rotate
 }
 } else {
 if (type == ItemRenderType.ENTITY) {
 //TODO add gltranslate/rotate
 }
 }
 model.render((Entity) data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
 GL11.glPopMatrix();
 }
}
