package com.abstractlabs.toe.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelTopHat extends ModelBase
{
  //fields
	ModelRenderer head;
    ModelRenderer side;
    ModelRenderer top;
  
  public ModelTopHat()
  {
	  textureWidth = 128;
	    textureHeight = 128;
	    
	      head = new ModelRenderer(this, 0, 96);
	      head.addBox(0F, 0F, 0F, 16, 16, 16);
	      head.setRotationPoint(-8F, 8F, -8F);
	      head.setTextureSize(128, 128);
	      head.mirror = true;
	      setRotation(head, 0F, 0F, 0F);
	      side = new ModelRenderer(this, 0, 30);
	      side.addBox(0F, 0F, 0F, 18, 2, 18);
	      side.setRotationPoint(-9F, 6F, -9F);
	      side.setTextureSize(128, 128);
	      side.mirror = true;
	      setRotation(side, 0F, 0F, 0F);
	      top = new ModelRenderer(this, 0, 0);
	      top.addBox(0F, 0F, 0F, 14, 15, 14);
	      top.setRotationPoint(-7F, -9F, -7F);
	      top.setTextureSize(128, 128);
	      top.mirror = true;
	      setRotation(top, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
	  super.render(entity, f, f1, f2, f3, f4, f5);
	    setRotationAngles(entity, f, f1, f2, f3, f4, f5);
	    head.render(f5);
	    side.render(f5);
	    top.render(f5);
  }
  
  public void renderModel(float f5) {
	  head.render(f5);
	    side.render(f5);
	    top.render(f5);
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