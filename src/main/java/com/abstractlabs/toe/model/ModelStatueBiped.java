package com.abstractlabs.toe.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelStatueBiped extends ModelBase {
	public ModelRenderer bipedHead;
    //public ModelRenderer bipedHeadwear;
    public ModelRenderer bipedBody;
    public ModelRenderer bipedRightArm;
    public ModelRenderer bipedLeftArm;
    public ModelRenderer bipedRightLeg;
    public ModelRenderer bipedLeftLeg;
    public ModelRenderer bipedEars;
    public ModelRenderer bipedCloak;
  
  public ModelStatueBiped() {
	  this.textureWidth = 64;
      this.textureHeight = 32;
      this.bipedCloak = new ModelRenderer(this, 0, 0);
      this.bipedCloak.addBox(-5.0F, 0.0F, -1.0F, 10, 16, 1, 1.0F);
      this.bipedEars = new ModelRenderer(this, 24, 0);
      this.bipedEars.addBox(-3.0F, -6.0F, -1.0F, 6, 6, 1, 1.0F);
      this.bipedHead = new ModelRenderer(this, 0, 0);
      this.bipedHead.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 1.0F);
      this.bipedHead.setRotationPoint(0.0F, 0.0F + 0.0F, 0.0F);
//      this.bipedHeadwear = new ModelRenderer(this, 32, 0);
//      this.bipedHeadwear.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 1.0F + 0.5F);
//      this.bipedHeadwear.setRotationPoint(0.0F, 0.0F + 0.0F, 0.0F);
      this.bipedBody = new ModelRenderer(this, 16, 16);
      this.bipedBody.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, 1.0F);
      this.bipedBody.setRotationPoint(0.0F, 0.0F + 0.0F, 0.0F);
      this.bipedRightArm = new ModelRenderer(this, 40, 16);
      this.bipedRightArm.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4, 1.0F);
      this.bipedRightArm.setRotationPoint(-5.0F, 2.0F + 0.0F, 0.0F);
      this.bipedLeftArm = new ModelRenderer(this, 40, 16);
      this.bipedLeftArm.mirror = true;
      this.bipedLeftArm.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4, 1.0F);
      this.bipedLeftArm.setRotationPoint(5.0F, 2.0F + 0.0F, 0.0F);
      this.bipedRightLeg = new ModelRenderer(this, 0, 16);
      this.bipedRightLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 1.0F);
      this.bipedRightLeg.setRotationPoint(-1.9F, 12.0F + 0.0F, 0.0F);
      this.bipedLeftLeg = new ModelRenderer(this, 0, 16);
      this.bipedLeftLeg.mirror = true;
      this.bipedLeftLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 1.0F);
      this.bipedLeftLeg.setRotationPoint(1.9F, 12.0F + 0.0F, 0.0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    bipedHead.render(f5);
    //bipedHeadwear.render(f5);
    bipedBody.render(f5);
    bipedRightArm.render(f5);
    bipedLeftArm.render(f5);
    bipedRightLeg.render(f5);
    bipedLeftLeg.render(f5);
    bipedEars.render(f5);
    bipedCloak.render(f5);
  }
  
  public void renderModel(float f5) {
	bipedHead.render(f5);
    //bipedHeadwear.render(f5);
    bipedBody.render(f5);
    bipedRightArm.render(f5);
    bipedLeftArm.render(f5);
    bipedRightLeg.render(f5);
    bipedLeftLeg.render(f5);
    bipedEars.render(f5);
    bipedCloak.render(f5);
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
