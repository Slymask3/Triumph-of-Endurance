package com.abstractlabs.toe.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelLandmine extends ModelBase {
  //fields
    ModelRenderer Main;
    ModelRenderer TopIn;
    ModelRenderer TopOut;
    ModelRenderer BotIn;
    ModelRenderer BotOut;
    ModelRenderer RightIn;
    ModelRenderer RightOut;
    ModelRenderer LeftIn;
    ModelRenderer LeftOut;
  
  public ModelLandmine() {
    textureWidth = 64;
    textureHeight = 32;
    
      Main = new ModelRenderer(this, 0, 0);
      Main.addBox(0F, 0F, 0F, 10, 1, 10);
      Main.setRotationPoint(-5F, 23F, -5F);
      Main.setTextureSize(64, 32);
      Main.mirror = true;
      setRotation(Main, 0F, 0F, 0F);
      TopIn = new ModelRenderer(this, 0, 15);
      TopIn.addBox(0F, 0F, 0F, 8, 1, 1);
      TopIn.setRotationPoint(-4F, 23F, 5F);
      TopIn.setTextureSize(64, 32);
      TopIn.mirror = true;
      setRotation(TopIn, 0F, 0F, 0F);
      TopOut = new ModelRenderer(this, 0, 12);
      TopOut.addBox(0F, 0F, 0F, 4, 1, 1);
      TopOut.setRotationPoint(-2F, 23F, 6F);
      TopOut.setTextureSize(64, 32);
      TopOut.mirror = true;
      setRotation(TopOut, 0F, 0F, 0F);
      BotIn = new ModelRenderer(this, 0, 15);
      BotIn.addBox(0F, 0F, 0F, 8, 1, 1);
      BotIn.setRotationPoint(-4F, 23F, -6F);
      BotIn.setTextureSize(64, 32);
      BotIn.mirror = true;
      setRotation(BotIn, 0F, 0F, 0F);
      BotOut = new ModelRenderer(this, 0, 12);
      BotOut.addBox(0F, 0F, 0F, 4, 1, 1);
      BotOut.setRotationPoint(-2F, 23F, -7F);
      BotOut.setTextureSize(64, 32);
      BotOut.mirror = true;
      setRotation(BotOut, 0F, 0F, 0F);
      RightIn = new ModelRenderer(this, 0, 18);
      RightIn.addBox(0F, 0F, 0F, 1, 1, 8);
      RightIn.setRotationPoint(5F, 23F, -4F);
      RightIn.setTextureSize(64, 32);
      RightIn.mirror = true;
      setRotation(RightIn, 0F, 0F, 0F);
      RightOut = new ModelRenderer(this, 0, 27);
      RightOut.addBox(0F, 0F, 0F, 1, 1, 4);
      RightOut.setRotationPoint(6F, 23F, -2F);
      RightOut.setTextureSize(64, 32);
      RightOut.mirror = true;
      setRotation(RightOut, 0F, 0F, 0F);
      LeftIn = new ModelRenderer(this, 0, 18);
      LeftIn.addBox(0F, 0F, 0F, 1, 1, 8);
      LeftIn.setRotationPoint(-6F, 23F, -4F);
      LeftIn.setTextureSize(64, 32);
      LeftIn.mirror = true;
      setRotation(LeftIn, 0F, 0F, 0F);
      LeftOut = new ModelRenderer(this, 0, 27);
      LeftOut.addBox(0F, 0F, 0F, 1, 1, 4);
      LeftOut.setRotationPoint(-7F, 23F, -2F);
      LeftOut.setTextureSize(64, 32);
      LeftOut.mirror = true;
      setRotation(LeftOut, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Main.render(f5);
    TopIn.render(f5);
    TopOut.render(f5);
    BotIn.render(f5);
    BotOut.render(f5);
    RightIn.render(f5);
    RightOut.render(f5);
    LeftIn.render(f5);
    LeftOut.render(f5);
  }
  
  public void renderModel(float f5) {
	Main.render(f5);
	TopIn.render(f5);
	TopOut.render(f5);
	BotIn.render(f5);
	BotOut.render(f5);
	RightIn.render(f5);
	RightOut.render(f5);
	LeftIn.render(f5);
	LeftOut.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z) {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }

}
