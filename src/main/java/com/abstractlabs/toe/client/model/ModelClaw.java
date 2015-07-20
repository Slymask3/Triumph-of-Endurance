package com.abstractlabs.toe.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelClaw extends ModelBase
{
  //fields
	ModelRenderer top;
    ModelRenderer bot;
    ModelRenderer side1;
    ModelRenderer side2;
    ModelRenderer front;
    ModelRenderer finger1;
    ModelRenderer finger2;
    ModelRenderer finger3;
    ModelRenderer finger4;
    ModelRenderer thumb;
  
  public ModelClaw()
  {
	  textureWidth = 64;
	    textureHeight = 64;
	    
	      top = new ModelRenderer(this, 0, 0);
	      top.addBox(0F, 0F, 0F, 16, 1, 16);
	      top.setRotationPoint(-8F, 8F, -8F);
	      top.setTextureSize(64, 64);
	      top.mirror = true;
	      setRotation(top, 0F, 0F, 0F);
	      bot = new ModelRenderer(this, 0, 18);
	      bot.addBox(0F, 0F, 0F, 1, 14, 16);
	      bot.setRotationPoint(-8F, 9F, -8F);
	      bot.setTextureSize(64, 64);
	      bot.mirror = true;
	      setRotation(bot, 0F, 0F, 0F);
	      side1 = new ModelRenderer(this, 0, 0);
	      side1.addBox(0F, 0F, 0F, 16, 1, 16);
	      side1.setRotationPoint(-8F, 23F, -8F);
	      side1.setTextureSize(64, 64);
	      side1.mirror = true;
	      setRotation(side1, 0F, 0F, 0F);
	      side2 = new ModelRenderer(this, 0, 18);
	      side2.addBox(0F, 0F, 0F, 1, 14, 16);
	      side2.setRotationPoint(7F, 9F, -8F);
	      side2.setTextureSize(64, 64);
	      side2.mirror = true;
	      setRotation(side2, 0F, 0F, 0F);
	      front = new ModelRenderer(this, 0, 49);
	      front.addBox(0F, 0F, 0F, 14, 14, 1);
	      front.setRotationPoint(-7F, 9F, -8F);
	      front.setTextureSize(64, 64);
	      front.mirror = true;
	      setRotation(front, 0F, 0F, 0F);
	      finger1 = new ModelRenderer(this, 47, 25);
	      finger1.addBox(0F, 0F, 0F, 2, 1, 6);
	      finger1.setRotationPoint(-8F, 8F, -14F);
	      finger1.setTextureSize(64, 64);
	      finger1.mirror = true;
	      setRotation(finger1, 0F, 0F, 0F);
	      finger2 = new ModelRenderer(this, 46, 33);
	      finger2.addBox(0F, 0F, 0F, 2, 1, 7);
	      finger2.setRotationPoint(-3F, 8F, -15F);
	      finger2.setTextureSize(64, 64);
	      finger2.mirror = true;
	      setRotation(finger2, 0F, 0F, 0F);
	      finger3 = new ModelRenderer(this, 46, 33);
	      finger3.addBox(0F, 0F, 0F, 2, 1, 7);
	      finger3.setRotationPoint(1F, 8F, -15F);
	      finger3.setTextureSize(64, 64);
	      finger3.mirror = true;
	      setRotation(finger3, 0F, 0F, 0F);
	      finger4 = new ModelRenderer(this, 47, 25);
	      finger4.addBox(0F, 0F, 0F, 2, 1, 6);
	      finger4.setRotationPoint(6F, 8F, -14F);
	      finger4.setTextureSize(64, 64);
	      finger4.mirror = true;
	      setRotation(finger4, 0F, 0F, 0F);
	      thumb = new ModelRenderer(this, 48, 18);
	      thumb.addBox(0F, 0F, 0F, 2, 1, 5);
	      thumb.setRotationPoint(-8F, 23F, -13F);
	      thumb.setTextureSize(64, 64);
	      thumb.mirror = true;
	      setRotation(thumb, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
	  super.render(entity, f, f1, f2, f3, f4, f5);
	    setRotationAngles(entity, f, f1, f2, f3, f4, f5);
	    top.render(f5);
	    bot.render(f5);
	    side1.render(f5);
	    side2.render(f5);
	    front.render(f5);
	    finger1.render(f5);
	    finger2.render(f5);
	    finger3.render(f5);
	    finger4.render(f5);
	    thumb.render(f5);
  }
  
  public void renderModel(float f5) {
	  top.render(f5);
	    bot.render(f5);
	    side1.render(f5);
	    side2.render(f5);
	    front.render(f5);
	    finger1.render(f5);
	    finger2.render(f5);
	    finger3.render(f5);
	    finger4.render(f5);
	    thumb.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }

}
