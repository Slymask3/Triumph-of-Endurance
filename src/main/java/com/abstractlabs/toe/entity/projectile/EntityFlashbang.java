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

        //spawnParticlesCube(this.worldObj, this.posX, this.posY, this.posZ, "largesmoke", 3);
        
        spawnParticlesSphere(this.worldObj, (int)this.posX, (int)this.posY, (int)this.posZ, "largesmoke", 3, 3, 3, true);
        
        
        
        if (!this.worldObj.isRemote) {
            this.setDead();
        }
    }
    
    public void spawnParticlesCube(World world, double X, double Y, double Z, String particle, int radius) {
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
    
    public static void spawnParticlesSphere(World world, int x0, int y0, int z0, String particle, double radiusX, double radiusY, double radiusZ, boolean filled) {
    	radiusX += 0.5;
        radiusY += 0.5;
        radiusZ += 0.5;

        final double invRadiusX = 1 / radiusX;
        final double invRadiusY = 1 / radiusY;
        final double invRadiusZ = 1 / radiusZ;

        final int ceilRadiusX = (int) Math.ceil(radiusX);
        final int ceilRadiusY = (int) Math.ceil(radiusY);
        final int ceilRadiusZ = (int) Math.ceil(radiusZ);

        double nextXn = 0;
        forX: for (int x = 0; x <= ceilRadiusX; ++x) {
            final double xn = nextXn;
            nextXn = (x + 1) * invRadiusX;
            double nextYn = 0;
            forY: for (int y = 0; y <= ceilRadiusY; ++y) {
                final double yn = nextYn;
                nextYn = (y + 1) * invRadiusY;
                double nextZn = 0;
                forZ: for (int z = 0; z <= ceilRadiusZ; ++z) {
                    final double zn = nextZn;
                    nextZn = (z + 1) * invRadiusZ;

                    double distanceSq = lengthSq(xn, yn, zn);
                    if (distanceSq > 1) {
                        if (z == 0) {
                            if (y == 0) {
                                break forX;
                            }
                            break forY;
                        }
                        break forZ;
                    }

                    if (!filled) {
                        if (lengthSq(nextXn, yn, zn) <= 1 && lengthSq(xn, nextYn, zn) <= 1 && lengthSq(xn, yn, nextZn) <= 1) {
                            continue;
                        }
                    }

//                    world.spawnParticle(particle, x+x0, y+y0, z+z0, 0.0D, 0.0D, 0.0D);
//                    world.spawnParticle(particle,-x+x0, y+y0, z+z0, 0.0D, 0.0D, 0.0D);
//                    world.spawnParticle(particle, x+x0,-y+y0, z+z0, 0.0D, 0.0D, 0.0D);
//                    world.spawnParticle(particle, x+x0, y+y0,-z+z0, 0.0D, 0.0D, 0.0D);
//                    world.spawnParticle(particle,-x+x0,-y+y0, z+z0, 0.0D, 0.0D, 0.0D);
//                    world.spawnParticle(particle, x+x0,-y+y0,-z+z0, 0.0D, 0.0D, 0.0D);
//                    world.spawnParticle(particle,-x+x0, y+y0,-z+z0, 0.0D, 0.0D, 0.0D);
//                    world.spawnParticle(particle,-x+x0,-y+y0,-z+z0, 0.0D, 0.0D, 0.0D);
                    
                    effectFull(world, particle, x+x0, y+y0, z+z0);
                    effectFull(world, particle,-x+x0, y+y0, z+z0);
                    effectFull(world, particle, x+x0,-y+y0, z+z0);
                    effectFull(world, particle, x+x0, y+y0,-z+z0);
                    effectFull(world, particle,-x+x0,-y+y0, z+z0);
                    effectFull(world, particle, x+x0,-y+y0,-z+z0);
                    effectFull(world, particle,-x+x0, y+y0,-z+z0);
                    effectFull(world, particle,-x+x0,-y+y0,-z+z0);
                }
            }
        }
    }
    
    private static double lengthSq(double x, double y, double z) {
        return (x * x) + (y * y) + (z * z);
    }
    
    public static void effectFull(World world, String particle, int x, int y, int z) {
		for (double i = 0; i <= 1; i = i + 0.5) {
			for (double n = 0; n <= 1; n = n + 0.5) {
				for (double v = 0; v <= 1; v = v + 0.5) {
					world.spawnParticle(particle, x+i, y+v, z+n, 0.0D, 0.0D, 0.0D);
				}
			}
		}
	}
}