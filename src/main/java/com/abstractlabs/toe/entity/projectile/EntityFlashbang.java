package com.abstractlabs.toe.entity.projectile;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityFlashbang extends EntityThrowable {
    public EntityFlashbang(World world) {
        super(world);
    }

    public EntityFlashbang(World world, EntityLivingBase entity) {
        super(world, entity);
    }

    public EntityFlashbang(World world, double x, double y, double z) {
        super(world, x, y, z);
    }

    /**
     * Called when this EntityThrowable hits a block or entity.
     */
    protected void onImpact(MovingObjectPosition mop) {
        if (mop.entityHit != null) {
            mop.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 1F);
        }
        
        spawnParticles(this.worldObj, this.posX, this.posY, this.posZ, "largesmoke", 3);
        
        //for (int i = 0; i < 8; ++i) {
        //    this.worldObj.spawnParticle("hugeexplosion", this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
        //}

        //this.worldObj.spawnParticle("largesmoke", this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
        
        if (!this.worldObj.isRemote) {
            this.setDead();
        }
    }
    
    public void spawnParticles(World world, double X, double Y, double Z, String particle, int radius) {
    	double x = (double) (X -radius);
    	double y = (double) (Y +radius);
    	double z = (double) (Z -radius);
   
    	double bx = x;
    	double bz = z;
 
        for (double i=0; i<radius*2+1; i += 0.5) {
            for (double j=0; j<radius*2+1; j += 0.5) {
                for (double k=0; k<radius*2+1; k += 0.5) {
                	
                	world.spawnParticle(particle, x, y, z, 0.0D, 0.0D, 0.0D);
                    
                    x += 0.5;
                }
                z += 0.5;
                x = bx;
            }
            z = bz;
            x = bx;
            y -= 0.5;
        }
    }
}