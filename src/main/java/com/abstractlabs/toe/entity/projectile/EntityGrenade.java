package com.abstractlabs.toe.entity.projectile;

import com.abstractlabs.toe.utility.LogHelper;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityGrenade extends EntityThrowable {
    public EntityGrenade(World world) {
        super(world);
    }

    public EntityGrenade(World world, EntityLivingBase entity) {
        super(world, entity);
    }

    public EntityGrenade(World world, double x, double y, double z) {
        super(world, x, y, z);
    }

    /**
     * Called when this EntityThrowable hits a block or entity.
     */
    protected void onImpact(MovingObjectPosition mop) {
        //if (mop.entityHit != null) {
        //    mop.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 4F);
        //}

        this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, 3F, true);

        //for (int i = 0; i < 8; ++i) {
        //    this.worldObj.spawnParticle("hugeexplosion", this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
        //}
        
        
        if (!this.worldObj.isRemote) {
            this.setDead();
        }
    }
}