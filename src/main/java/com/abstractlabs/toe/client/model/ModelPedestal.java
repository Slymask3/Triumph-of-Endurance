package com.abstractlabs.toe.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelPedestal extends ModelBase
{
  //fields
    ModelRenderer Top1;
    ModelRenderer Top2;
    ModelRenderer Top3;
    ModelRenderer Middle;
    ModelRenderer Bot3;
    ModelRenderer Bot2;
    ModelRenderer Bot1;
  
  public ModelPedestal()
  {
    textureWidth = 64;
    textureHeight = 64;
    
      Top1 = new ModelRenderer(this, 0, 0);
      Top1.addBox(0F, 0F, 0F, 14, 1, 14);
      Top1.setRotationPoint(-7F, 8F, -7F);
      Top1.setTextureSize(64, 64);
      Top1.mirror = true;
      setRotation(Top1, 0F, 0F, 0F);
      Top2 = new ModelRenderer(this, 0, 16);
      Top2.addBox(0F, 0F, 0F, 12, 1, 12);
      Top2.setRotationPoint(-6F, 9F, -6F);
      Top2.setTextureSize(64, 64);
      Top2.mirror = true;
      setRotation(Top2, 0F, 0F, 0F);
      Top3 = new ModelRenderer(this, 0, 30);
      Top3.addBox(0F, 0F, 0F, 10, 1, 10);
      Top3.setRotationPoint(-5F, 10F, -5F);
      Top3.setTextureSize(64, 64);
      Top3.mirror = true;
      setRotation(Top3, 0F, 0F, 0F);
      Middle = new ModelRenderer(this, 0, 42);
      Middle.addBox(0F, 0F, 0F, 6, 10, 6);
      Middle.setRotationPoint(-3F, 11F, -3F);
      Middle.setTextureSize(64, 64);
      Middle.mirror = true;
      setRotation(Middle, 0F, 0F, 0F);
      Bot3 = new ModelRenderer(this, 0, 30);
      Bot3.addBox(0F, 0F, 0F, 10, 1, 10);
      Bot3.setRotationPoint(-5F, 21F, -5F);
      Bot3.setTextureSize(64, 64);
      Bot3.mirror = true;
      setRotation(Bot3, 0F, 0F, 0F);
      Bot2 = new ModelRenderer(this, 0, 16);
      Bot2.addBox(0F, 0F, 0F, 12, 1, 12);
      Bot2.setRotationPoint(-6F, 22F, -6F);
      Bot2.setTextureSize(64, 64);
      Bot2.mirror = true;
      setRotation(Bot2, 0F, 0F, 0F);
      Bot1 = new ModelRenderer(this, 0, 0);
      Bot1.addBox(0F, 0F, 0F, 14, 1, 14);
      Bot1.setRotationPoint(-7F, 23F, -7F);
      Bot1.setTextureSize(64, 64);
      Bot1.mirror = true;
      setRotation(Bot1, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(entity, f, f1, f2, f3, f4, f5);
    Top1.render(f5);
    Top2.render(f5);
    Top3.render(f5);
    Middle.render(f5);
    Bot3.render(f5);
    Bot2.render(f5);
    Bot1.render(f5);
  }
  
  public void renderModel(float f5) {
	  Top1.render(f5);
	    Top2.render(f5);
	    Top3.render(f5);
	    Middle.render(f5);
	    Bot3.render(f5);
	    Bot2.render(f5);
	    Bot1.render(f5);
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
