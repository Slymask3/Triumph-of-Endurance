package com.abstractlabs.toe.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelATM extends ModelBase {
  //fields
	ModelRenderer Top;
    ModelRenderer Left;
    ModelRenderer Right;
    ModelRenderer Back;
    ModelRenderer Keys;
    ModelRenderer Screen;
    ModelRenderer Bot;
  
  public ModelATM() {
	  textureWidth = 128;
	    textureHeight = 64;
	    
	      Top = new ModelRenderer(this, 0, 0);
	      Top.addBox(0F, 0F, 0F, 16, 1, 16);
	      Top.setRotationPoint(-8F, 8F, -8F);
	      Top.setTextureSize(128, 64);
	      Top.mirror = true;
	      setRotation(Top, 0F, 0F, 0F);
	      Left = new ModelRenderer(this, 0, 34);
	      Left.addBox(0F, 0F, 0F, 1, 14, 16);
	      Left.setRotationPoint(7F, 9F, -8F);
	      Left.setTextureSize(128, 64);
	      Left.mirror = true;
	      setRotation(Left, 0F, 0F, 0F);
	      Right = new ModelRenderer(this, 0, 34);
	      Right.addBox(0F, 0F, 0F, 1, 14, 16);
	      Right.setRotationPoint(-8F, 9F, -8F);
	      Right.setTextureSize(128, 64);
	      Right.mirror = true;
	      setRotation(Right, 0F, 0F, 0F);
	      Back = new ModelRenderer(this, 0, 18);
	      Back.addBox(0F, 0F, 0F, 14, 14, 1);
	      Back.setRotationPoint(-7F, 9F, 7F);
	      Back.setTextureSize(128, 64);
	      Back.mirror = true;
	      setRotation(Back, 0F, 0F, 0F);
	      Keys = new ModelRenderer(this, 88, 12);
	      Keys.addBox(0F, 0F, 0F, 14, 1, 6);
	      Keys.setRotationPoint(-7F, 23F, -8F);
	      Keys.setTextureSize(128, 64);
	      Keys.mirror = true;
	      setRotation(Keys, 0.7853982F, 0F, 0F);
	      Screen = new ModelRenderer(this, 98, 0);
	      Screen.addBox(0F, 0F, 0F, 14, 10, 1);
	      Screen.setRotationPoint(-7F, 9F, -4F);
	      Screen.setTextureSize(128, 64);
	      Screen.mirror = true;
	      setRotation(Screen, 0F, 0F, 0F);
	      Bot = new ModelRenderer(this, 0, 0);
	      Bot.addBox(0F, 0F, 0F, 16, 1, 16);
	      Bot.setRotationPoint(-8F, 23F, -8F);
	      Bot.setTextureSize(128, 64);
	      Bot.mirror = true;
	      setRotation(Bot, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)  {
	  super.render(entity, f, f1, f2, f3, f4, f5);
	    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	    Top.render(f5);
	    Left.render(f5);
	    Right.render(f5);
	    Back.render(f5);
	    Keys.render(f5);
	    Screen.render(f5);
	    Bot.render(f5);
  }
  
  public void renderModel(float f5) {
	  Top.render(f5);
	    Left.render(f5);
	    Right.render(f5);
	    Back.render(f5);
	    Keys.render(f5);
	    Screen.render(f5);
	    Bot.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }

}
