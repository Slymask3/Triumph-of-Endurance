package com.abstractlabs.toe.client.particle;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import com.abstractlabs.toe.reference.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class EntitySmokeBombFX extends EntityFX
{
	private static final ResourceLocation tex = new ResourceLocation(Reference.MOD_ID+":textures/gui/overlay/beam.png");

    public EntitySmokeBombFX(World p_i1205_1_, double p_i1205_2_, double p_i1205_4_, double p_i1205_6_, double p_i1205_8_, double p_i1205_10_, double p_i1205_12_)
    {
        super(p_i1205_1_, p_i1205_2_, p_i1205_4_, p_i1205_6_, p_i1205_8_, p_i1205_10_, p_i1205_12_);
        this.motionX = p_i1205_8_ + (double)((float)(Math.random() * 2.0D - 1.0D) * 0.05F);
        this.motionY = p_i1205_10_ + (double)((float)(Math.random() * 2.0D - 1.0D) * 0.05F);
        this.motionZ = p_i1205_12_ + (double)((float)(Math.random() * 2.0D - 1.0D) * 0.05F);
        this.particleRed = this.particleGreen = this.particleBlue = this.rand.nextFloat() * 0.3F + 0.7F;
        this.particleScale = this.rand.nextFloat() * this.rand.nextFloat() * 6.0F + 1.0F;
        this.particleMaxAge = (int)(16.0D / ((double)this.rand.nextFloat() * 0.8D + 0.2D)) + 2;
        //this.particleIcon = ToeItems.fishingRodGold.getIconFromDamage(0);
    }

    /**
     * Called to update the entity's position/logic.
     */
    public void onUpdate()
    {
    	this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;

        if (this.particleAge++ >= this.particleMaxAge)
        {
          setDead();
        }

        //setParticleTextureIndex(7 - this.particleAge * 8 / this.particleMaxAge);
        moveEntity(this.motionX, this.motionY, this.motionZ);

        if (this.posY == this.prevPosY)
        {
          this.motionX *= 1.1D;
          this.motionZ *= 1.1D;
        }

        this.motionX *= 0.9599999785423279D;
        this.motionY *= 0.9599999785423279D;
        this.motionZ *= 0.9599999785423279D;

        if (this.onGround)
        {
          this.motionX *= 0.699999988079071D;
          this.motionZ *= 0.699999988079071D;
        }
    }
    
    @Override
	public void renderParticle(Tessellator tessellator, float partialTickTime, float rotX, float rotXZ, float rotZ, float rotYZ, float rotXY){
		Minecraft.getMinecraft().renderEngine.bindTexture(tex);
		super.renderParticle(tessellator, partialTickTime, rotX, rotXZ, rotZ, rotYZ, rotXY);
	}
    
    @Override
	public int getFXLayer(){
		return 3;
	}
}