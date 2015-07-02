package com.abstractlabs.toe.entity.projectile;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityFishHook;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

import com.abstractlabs.toe.init.ToeItems;
import com.abstractlabs.toe.reference.Fishing;
import com.abstractlabs.toe.skill.fishing.FishingHelper;
import com.abstractlabs.toe.utility.LogHelper;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EntityFishingRodHook extends EntityFishHook {    
	private int field_146037_g;
	private int field_146048_h;
	private int field_146050_i;
	private Block water;
	private boolean inGround;
	private int field_146049_av;
	private int field_146047_aw;
	private int field_146045_ax;
	private int field_146040_ay;
	private int ticksCatchable;
	private float field_146054_aA;
	private int fishPosRotationIncrements;
	private double field_146056_aC;
	private double field_146057_aD;
	private double field_146058_aE;
	private double field_146059_aF;
	private double field_146060_aG;
	@SideOnly(Side.CLIENT)
	private double field_146061_aH;
	@SideOnly(Side.CLIENT)
	private double field_146052_aI;
	@SideOnly(Side.CLIENT)
	private double field_146053_aJ;

	public EntityFishingRodHook(World world, EntityPlayer angler) {
		super(world, angler);
	}
	
	@Override
	public int func_146034_e() {
        if (this.worldObj.isRemote) {
            return 0;
        } else {
            byte b0 = 0;

            if (this.field_146043_c != null) {
                double d0 = this.field_146042_b.posX - this.posX;
                double d2 = this.field_146042_b.posY - this.posY;
                double d4 = this.field_146042_b.posZ - this.posZ;
                double d6 = (double)MathHelper.sqrt_double(d0 * d0 + d2 * d2 + d4 * d4);
                double d8 = 0.1D;
                this.field_146043_c.motionX += d0 * d8;
                this.field_146043_c.motionY += d2 * d8 + (double)MathHelper.sqrt_double(d6) * 0.08D;
                this.field_146043_c.motionZ += d4 * d8;
                b0 = 3;
            } else if (this.field_146045_ax > 0) {
            	ItemStack is = getRandomCatch();
            	
                EntityItem entityitem = new EntityItem(this.field_146042_b.worldObj, this.posX, this.posY, this.posZ, is);
                double d1 = this.field_146042_b.posX - this.posX;
                double d3 = this.field_146042_b.posY - this.posY;
                double d5 = this.field_146042_b.posZ - this.posZ;
                double d7 = (double)MathHelper.sqrt_double(d1 * d1 + d3 * d3 + d5 * d5);
                double d9 = 0.1D;
                entityitem.motionX = d1 * d9;
                entityitem.motionY = d3 * d9 + (double)MathHelper.sqrt_double(d7) * 0.08D;
                entityitem.motionZ = d5 * d9;
                
        		LogHelper.info("[EntityFishingRodHook] successfully spawned == " + entityitem.getEntityItem().getItem().getUnlocalizedName());
        		
                this.field_146042_b.worldObj.spawnEntityInWorld(entityitem);
                this.field_146042_b.worldObj.spawnEntityInWorld(new EntityXPOrb(this.field_146042_b.worldObj, this.field_146042_b.posX, this.field_146042_b.posY + 0.5D, this.field_146042_b.posZ + 0.5D, this.rand.nextInt(6) + 1));
                b0 = 1;
                
                
//                Entity cow = new EntityAlienCow(this.field_146042_b.worldObj);
//                cow.setPosition(this.posX, this.posY, this.posZ);
//                cow.motionX = d1 * d9;
//                cow.motionY = d3 * d9 + (double)MathHelper.sqrt_double(d7) * 0.08D;
//                cow.motionZ = d5 * d9;
//                this.field_146042_b.worldObj.spawnEntityInWorld(cow);
//                
//                EntityItem item2 = new EntityItem(this.field_146042_b.worldObj, this.posX, this.posY, this.posZ, new ItemStack(ToeItems.ruby, 1, 0));
//                item2.motionX = d1 * d9;
//                item2.motionY = d3 * d9 + (double)MathHelper.sqrt_double(d7) * 0.08D;
//                item2.motionZ = d5 * d9;
//                this.field_146042_b.worldObj.spawnEntityInWorld(item2);
            }

            if (this.inWater) {
                b0 = 2;
            }

            this.setDead();
            this.field_146042_b.fishEntity = null;
            return b0;
        }
    }
	
	@Override
	public void onUpdate() {
        if (this.fishPosRotationIncrements > 0) {
            double d7 = this.posX + (this.field_146056_aC - this.posX) / (double)this.fishPosRotationIncrements;
            double d8 = this.posY + (this.field_146057_aD - this.posY) / (double)this.fishPosRotationIncrements;
            double d9 = this.posZ + (this.field_146058_aE - this.posZ) / (double)this.fishPosRotationIncrements;
            double d1 = MathHelper.wrapAngleTo180_double(this.field_146059_aF - (double)this.rotationYaw);
            this.rotationYaw = (float)((double)this.rotationYaw + d1 / (double)this.fishPosRotationIncrements);
            this.rotationPitch = (float)((double)this.rotationPitch + (this.field_146060_aG - (double)this.rotationPitch) / (double)this.fishPosRotationIncrements);
            --this.fishPosRotationIncrements;
            this.setPosition(d7, d8, d9);
            this.setRotation(this.rotationYaw, this.rotationPitch);
        } else {
            if (!this.worldObj.isRemote) {
                ItemStack itemstack = this.field_146042_b.getCurrentEquippedItem();

                boolean isRod = itemstack != null && (itemstack.getItem() == ToeItems.fishingRodWood || itemstack.getItem() == ToeItems.fishingRodIron || itemstack.getItem() == ToeItems.fishingRodGold);
                
                if (this.field_146042_b.isDead || !this.field_146042_b.isEntityAlive() || itemstack == null || !isRod || this.getDistanceSqToEntity(this.field_146042_b) > 1024.0D) {
                    this.setDead();
                    this.field_146042_b.fishEntity = null;
                    return;
                }

                if (this.field_146043_c != null) {
                    if (!this.field_146043_c.isDead) {
                        this.posX = this.field_146043_c.posX;
                        this.posY = this.field_146043_c.boundingBox.minY + (double)this.field_146043_c.height * 0.8D;
                        this.posZ = this.field_146043_c.posZ;
                        return;
                    }
                    this.field_146043_c = null;
                }
            }

            if (this.field_146044_a > 0) {
                --this.field_146044_a;
            }

            if (this.inGround) {
                if (this.worldObj.getBlock(this.field_146037_g, this.field_146048_h, this.field_146050_i) == this.water) {
                    ++this.field_146049_av;

                    if (this.field_146049_av == 1200) {
                        this.setDead();
                    }

                    return;
                }

                this.inGround = false;
                this.motionX *= (double)(this.rand.nextFloat() * 0.2F);
                this.motionY *= (double)(this.rand.nextFloat() * 0.2F);
                this.motionZ *= (double)(this.rand.nextFloat() * 0.2F);
                this.field_146049_av = 0;
                this.field_146047_aw = 0;
            } else {
                ++this.field_146047_aw;
            }

            Vec3 vec31 = Vec3.createVectorHelper(this.posX, this.posY, this.posZ);
            Vec3 vec3 = Vec3.createVectorHelper(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
            MovingObjectPosition movingobjectposition = this.worldObj.rayTraceBlocks(vec31, vec3);
            vec31 = Vec3.createVectorHelper(this.posX, this.posY, this.posZ);
            vec3 = Vec3.createVectorHelper(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);

            if (movingobjectposition != null) {
                vec3 = Vec3.createVectorHelper(movingobjectposition.hitVec.xCoord, movingobjectposition.hitVec.yCoord, movingobjectposition.hitVec.zCoord);
            }

            Entity entity = null;
            List list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.addCoord(this.motionX, this.motionY, this.motionZ).expand(1.0D, 1.0D, 1.0D));
            double d0 = 0.0D;
            double d2;

            for (int i = 0; i < list.size(); ++i) {
                Entity entity1 = (Entity)list.get(i);

                if (entity1.canBeCollidedWith() && (entity1 != this.field_146042_b || this.field_146047_aw >= 5)) {
                    float f = 0.3F;
                    AxisAlignedBB axisalignedbb = entity1.boundingBox.expand((double)f, (double)f, (double)f);
                    MovingObjectPosition movingobjectposition1 = axisalignedbb.calculateIntercept(vec31, vec3);

                    if (movingobjectposition1 != null) {
                        d2 = vec31.distanceTo(movingobjectposition1.hitVec);

                        if (d2 < d0 || d0 == 0.0D) {
                            entity = entity1;
                            d0 = d2;
                        }
                    }
                }
            }

            if (entity != null) {
                movingobjectposition = new MovingObjectPosition(entity);
            }

            if (movingobjectposition != null) {
                if (movingobjectposition.entityHit != null) {
                    if (movingobjectposition.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.field_146042_b), 0.0F)) {
                        this.field_146043_c = movingobjectposition.entityHit;
                    }
                } else {
                    this.inGround = true;
                }
            }

            if (!this.inGround) {
                this.moveEntity(this.motionX, this.motionY, this.motionZ);
                float f5 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
                this.rotationYaw = (float)(Math.atan2(this.motionX, this.motionZ) * 180.0D / Math.PI);

                for (this.rotationPitch = (float)(Math.atan2(this.motionY, (double)f5) * 180.0D / Math.PI); this.rotationPitch - this.prevRotationPitch < -180.0F; this.prevRotationPitch -= 360.0F) {
                    ;
                }

                while (this.rotationPitch - this.prevRotationPitch >= 180.0F) {
                    this.prevRotationPitch += 360.0F;
                }

                while (this.rotationYaw - this.prevRotationYaw < -180.0F) {
                    this.prevRotationYaw -= 360.0F;
                }

                while (this.rotationYaw - this.prevRotationYaw >= 180.0F) {
                    this.prevRotationYaw += 360.0F;
                }

                this.rotationPitch = this.prevRotationPitch + (this.rotationPitch - this.prevRotationPitch) * 0.2F;
                this.rotationYaw = this.prevRotationYaw + (this.rotationYaw - this.prevRotationYaw) * 0.2F;
                float f6 = 0.92F;

                if (this.onGround || this.isCollidedHorizontally) {
                    f6 = 0.5F;
                }

                byte b0 = 5;
                double d10 = 0.0D;

                for (int j = 0; j < b0; ++j) {
                    double d3 = this.boundingBox.minY + (this.boundingBox.maxY - this.boundingBox.minY) * (double)(j + 0) / (double)b0 - 0.125D + 0.125D;
                    double d4 = this.boundingBox.minY + (this.boundingBox.maxY - this.boundingBox.minY) * (double)(j + 1) / (double)b0 - 0.125D + 0.125D;
                    AxisAlignedBB axisalignedbb1 = AxisAlignedBB.getBoundingBox(this.boundingBox.minX, d3, this.boundingBox.minZ, this.boundingBox.maxX, d4, this.boundingBox.maxZ);

                    if (this.worldObj.isAABBInMaterial(axisalignedbb1, Material.water)) {
                        d10 += 1.0D / (double)b0;
                    }
                }

                if (!this.worldObj.isRemote && d10 > 0.0D) {
                    WorldServer worldserver = (WorldServer)this.worldObj;
                    int k = 1;

                    if (this.rand.nextFloat() < 0.25F && this.worldObj.canLightningStrikeAt(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY) + 1, MathHelper.floor_double(this.posZ))) {
                        k = 2;
                    }

                    if (this.rand.nextFloat() < 0.5F && !this.worldObj.canBlockSeeTheSky(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY) + 1, MathHelper.floor_double(this.posZ))) {
                        --k;
                    }

                    if (this.field_146045_ax > 0) {
                        --this.field_146045_ax;
                        
                        ItemStack itemstack = this.field_146042_b.getCurrentEquippedItem();
                        if(itemstack.getItem() == ToeItems.fishingRodGold) {
                        	int i = func_146034_e();
                        	itemstack.damageItem(i, field_146042_b);
                        	field_146042_b.swingItem();
                        }

                        if (this.field_146045_ax <= 0) {
                            this.field_146040_ay = 0;
                            this.ticksCatchable = 0;
                        }
                    } else {
                        float f1;
                        float f2;
                        double d5;
                        double d6;
                        float f7;
                        double d11;

                        if (this.ticksCatchable > 0) {
                            this.ticksCatchable -= k;

                            if (this.ticksCatchable <= 0) {
                                this.motionY -= 0.20000000298023224D;
                                this.playSound("random.splash", 0.25F, 1.0F + (this.rand.nextFloat() - this.rand.nextFloat()) * 0.4F);
                                f1 = (float)MathHelper.floor_double(this.boundingBox.minY);
                                worldserver.func_147487_a("bubble", this.posX, (double)(f1 + 1.0F), this.posZ, (int)(1.0F + this.width * 20.0F), (double)this.width, 0.0D, (double)this.width, 0.20000000298023224D);
                                worldserver.func_147487_a("wake", this.posX, (double)(f1 + 1.0F), this.posZ, (int)(1.0F + this.width * 20.0F), (double)this.width, 0.0D, (double)this.width, 0.20000000298023224D);
                                this.field_146045_ax = MathHelper.getRandomIntegerInRange(this.rand, 10, 30);
                            } else {
                                this.field_146054_aA = (float)((double)this.field_146054_aA + this.rand.nextGaussian() * 4.0D);
                                f1 = this.field_146054_aA * 0.017453292F;
                                f7 = MathHelper.sin(f1);
                                f2 = MathHelper.cos(f1);
                                d11 = this.posX + (double)(f7 * (float)this.ticksCatchable * 0.1F);
                                d5 = (double)((float)MathHelper.floor_double(this.boundingBox.minY) + 1.0F);
                                d6 = this.posZ + (double)(f2 * (float)this.ticksCatchable * 0.1F);

                                if (this.rand.nextFloat() < 0.15F) {
                                    worldserver.func_147487_a("bubble", d11, d5 - 0.10000000149011612D, d6, 1, (double)f7, 0.1D, (double)f2, 0.0D);
                                }

                                float f3 = f7 * 0.04F;
                                float f4 = f2 * 0.04F;
                                worldserver.func_147487_a("wake", d11, d5, d6, 0, (double)f4, 0.01D, (double)(-f3), 1.0D);
                                worldserver.func_147487_a("wake", d11, d5, d6, 0, (double)(-f4), 0.01D, (double)f3, 1.0D);
                            }
                        } else if (this.field_146040_ay > 0) {
                            this.field_146040_ay -= k;
                            f1 = 0.15F;

                            if (this.field_146040_ay < 20) {
                                f1 = (float)((double)f1 + (double)(20 - this.field_146040_ay) * 0.05D);
                            } else if (this.field_146040_ay < 40) {
                                f1 = (float)((double)f1 + (double)(40 - this.field_146040_ay) * 0.02D);
                            } else if (this.field_146040_ay < 60) {
                                f1 = (float)((double)f1 + (double)(60 - this.field_146040_ay) * 0.01D);
                            }

                            if (this.rand.nextFloat() < f1) {
                                f7 = MathHelper.randomFloatClamp(this.rand, 0.0F, 360.0F) * 0.017453292F;
                                f2 = MathHelper.randomFloatClamp(this.rand, 25.0F, 60.0F);
                                d11 = this.posX + (double)(MathHelper.sin(f7) * f2 * 0.1F);
                                d5 = (double)((float)MathHelper.floor_double(this.boundingBox.minY) + 1.0F);
                                d6 = this.posZ + (double)(MathHelper.cos(f7) * f2 * 0.1F);
                                worldserver.func_147487_a("splash", d11, d5, d6, 2 + this.rand.nextInt(2), 0.10000000149011612D, 0.0D, 0.10000000149011612D, 0.0D);
                            }

                            if (this.field_146040_ay <= 0) {
                                this.field_146054_aA = MathHelper.randomFloatClamp(this.rand, 0.0F, 360.0F);
                                this.ticksCatchable = MathHelper.getRandomIntegerInRange(this.rand, 20, 80);
                            }
                        } else {
                            this.field_146040_ay = MathHelper.getRandomIntegerInRange(this.rand, 100, 900);
                            this.field_146040_ay -= EnchantmentHelper.func_151387_h(this.field_146042_b) * 20 * 5;
                        }
                    }

                    if (this.field_146045_ax > 0) {
                        this.motionY -= (double)(this.rand.nextFloat() * this.rand.nextFloat() * this.rand.nextFloat()) * 0.2D;
                    }
                }

                d2 = d10 * 2.0D - 1.0D;
                this.motionY += 0.03999999910593033D * d2;

                if (d10 > 0.0D) {
                    f6 = (float)((double)f6 * 0.9D);
                    this.motionY *= 0.8D;
                }

                this.motionX *= (double)f6;
                this.motionY *= (double)f6;
                this.motionZ *= (double)f6;
                this.setPosition(this.posX, this.posY, this.posZ);
            }
        }
    }

	private ItemStack getRandomCatch() {
		FishingHelper helper = FishingHelper.getProperties(field_146042_b);
		int lvl = helper.getLevel();
		
		ArrayList<ItemStack> fish = new ArrayList<ItemStack>();
		ArrayList<Integer> rarity = new ArrayList<Integer>();
		ArrayList<Integer> exp = new ArrayList<Integer>();
		
		for(int i=0; i<Fishing.fish.length; i++) {
			if(lvl >= Fishing.fish[i].getLvl()) {
				fish.add(new ItemStack(Fishing.fish[i].getItem(), Fishing.fish[i].getAmount(), Fishing.fish[i].getMeta()));
				rarity.add(Fishing.fish[i].getRarity());
				exp.add(Fishing.fish[i].getExp());
			}
		}
		
//		if(lvl >= 1) {
//			fish.add(new ItemStack(ToeItems.coinCopper)); rarity.add(100); exp.add(5);
//			fish.add(new ItemStack(ToeItems.shrimp)); rarity.add(100); exp.add(10);
//			fish.add(new ItemStack(Items.fish, 1, 0)); rarity.add(100); exp.add(10); //regular
//		}
//		
//		if(lvl >= 5) {
//			fish.add(new ItemStack(ToeItems.sardine)); rarity.add(100); exp.add(20);
//		}
//		
//		if(lvl >= 10) {
//			fish.add(new ItemStack(Items.fish, 1, 1)); rarity.add(100); exp.add(30); //salmon
//		}
//		
//		if(lvl >= 15) {
//			fish.add(new ItemStack(ToeItems.tuna)); rarity.add(100); exp.add(40);
//		}
//		
//		if(lvl >= 25) {
//			fish.add(new ItemStack(ToeItems.coinSilver)); rarity.add(50); exp.add(50);
//			fish.add(new ItemStack(ToeItems.trout)); rarity.add(100); exp.add(50);
//		}
//		
//		if(lvl >= 30) {
//			fish.add(new ItemStack(ToeItems.pike)); rarity.add(90); exp.add(60);
//		}
//		
//		if(lvl >= 40) {
//			fish.add(new ItemStack(ToeItems.catfish)); rarity.add(90); exp.add(75);
//		}
//		
//		if(lvl >= 45) {
//			fish.add(new ItemStack(Items.fish, 1, 2)); rarity.add(90); exp.add(90); //clownfish
//			fish.add(new ItemStack(Items.fish, 1, 3)); rarity.add(90); exp.add(90); //pufferfish
//		}
//		
//		if(lvl >= 50) {
//			fish.add(new ItemStack(ToeItems.bass)); rarity.add(90); exp.add(100);
//		}
//		
//		if(lvl >= 60) {
//			fish.add(new ItemStack(ToeItems.swordfish)); rarity.add(80); exp.add(120);
//		}
//		
//		if(lvl >= 80) {
//			fish.add(new ItemStack(ToeItems.monkfish)); rarity.add(70); exp.add(200);
//		}
//		
//		if(lvl >= 90) {
//			fish.add(new ItemStack(ToeItems.coinGold)); rarity.add(20); exp.add(1000);
//			fish.add(new ItemStack(ToeItems.shark)); rarity.add(50); exp.add(500);
//		}
		
        boolean fishSelected = false;
        
        while(!fishSelected) {
        	int r = rand.nextInt(fish.size());
            int r1 = rand.nextInt(100)+1;
        	
	        for(int i=0; i<fish.size(); i++) {
	        	if(r==i) {
	        		LogHelper.info("[EntityFishingRodHook] " + fish.get(i).getUnlocalizedName() + " : " + rarity.get(i) + " | random rarity == " + r1);
	        		
	        		if(r1 <= rarity.get(i)) {
		        		LogHelper.info("[EntityFishingRodHook] successfully returned == " + fish.get(i).getUnlocalizedName());
	        			fishSelected = true;
	        			helper.addExperience(exp.get(i));
	            		return fish.get(i);
	        		}
	        	}
        	}
        }
		
		return new ItemStack(Items.apple); //debugging, this line should technically never be executed.
	}
}