package com.abstractlabs.toe.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockPortal;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.Direction;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import com.abstractlabs.toe.client.particle.ParticleEffects;
import com.abstractlabs.toe.creativetab.ToeTab;
import com.abstractlabs.toe.init.ToeBlocks;
import com.abstractlabs.toe.init.ToeDimensions;
import com.abstractlabs.toe.reference.Reference;
import com.abstractlabs.toe.world.teleporter.TeleporterNeptune;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockPortalNeptune extends BlockPortal {
	public static IIcon side;
	
	public BlockPortalNeptune(){
		super();
		setCreativeTab(ToeTab.TOE_TAB);
		setBlockName(Reference.MOD_ID + ":portalNeptune");
	}
    
	public void registerBlockIcons(IIconRegister ir) {
		side = ir.registerIcon(Reference.MOD_ID + ":portalNeptune");
	}
	
	@SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        return this.side;
    }
	
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z){
		return null;
	}
	
	public boolean renderAsNormalBlock(){
		return false;
	}
	
	public void onNeighborBlockChange(World world, int x, int y, int z, Block block){
		
		byte b0 = 0;
		byte b1 = 1;
		
		if(world.getBlock(x - 1, y, z) == ToeBlocks.neptuneBrick || world.getBlock(x + 1, y, z) == ToeBlocks.neptuneBrick){
			b0 = 1;
			b1 = 0;
		}
		
		int i1;
		
		for(i1 = y; world.getBlock(x, i1 - 1, z) == this; --i1){
			;
		}
		if(world.getBlock(x, i1 - 1, z) != ToeBlocks.neptuneBrick){
			world.setBlockToAir(x, y, z);
		}else{
			int j1;
			
			for(j1 = 1; j1 < 4 && world.getBlock(x, i1 + j1, z) == this; ++j1){
				;
			}
			if(j1 == 3 && world.getBlock(x, i1 + j1, z) == ToeBlocks.neptuneBrick){
				boolean flag = world.getBlock(x - 1, y, z) == this || world.getBlock(x + 1, y, z) == this;
				boolean flag1 = world.getBlock(x, y, z - 1) == this || world.getBlock(x, y, z - 1) == this;
				
				if(flag && flag1){
					world.setBlockToAir(x, y, z);
				}else{
					if((world.getBlock(x+b0, y, z+b1) != ToeBlocks.neptuneBrick || world.getBlock(x-b0, y, z-b1) != this) && (world.getBlock(x-b0, y, z-b1) !=ToeBlocks.neptuneBrick || world.getBlock(x+b0, y, z+b1) != this)){
						world.setBlockToAir(x, y, z);
					}
				}
			}else{
				world.setBlockToAir(x, y, z);
			}
		}
	}
	
	public int quantityDropped(Random rand){
		return 0;
	}
	
	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity){
		if(entity.ridingEntity == null && entity.riddenByEntity == null && entity instanceof EntityPlayerMP){
			EntityPlayerMP thePlayer = (EntityPlayerMP) entity;
			
			MinecraftServer server = MinecraftServer.getServer();
			if(entity instanceof EntityPlayerMP){
				if(thePlayer.timeUntilPortal > 0){
					thePlayer.timeUntilPortal = 10;
					
				}else if(thePlayer.dimension != ToeDimensions.neptune){
					thePlayer.timeUntilPortal = 10;
					thePlayer.mcServer.getConfigurationManager().transferPlayerToDimension(thePlayer, ToeDimensions.neptune, new TeleporterNeptune(server.worldServerForDimension(ToeDimensions.neptune)));
					
				}else{
					thePlayer.timeUntilPortal = 10;
					thePlayer.mcServer.getConfigurationManager().transferPlayerToDimension(thePlayer, 0, new TeleporterNeptune(server.worldServerForDimension(0)));
				}
				
			}
			
		}
	}
	
	public boolean tryTroCreatePortal(World world, int x, int y, int z){
		byte b0 = 0;
		byte b1 = 0;
		if(world.getBlock(x - 1 , y, z) == ToeBlocks.neptuneBrick || world.getBlock(x + 1, y, z) == ToeBlocks.neptuneBrick){
			b0 = 1;
		}
		
		if (world.getBlock(x, y, z - 1) == ToeBlocks.neptuneBrick || world.getBlock(x, y, z + 1) == ToeBlocks.neptuneBrick){
			b1 = 1;
		}
		
		if(b0 == b1) {
			return false;
			
		} else {
			if(world.getBlock(x - b0, y, z - b1) == Blocks.air){
				x -= b0;
				z -= b1;
					
			}
			int l;
			int i1;
			for(l = -1; l <= 2; ++l) {
				for(i1 = -1; i1 <= 3; ++i1) {
					boolean flag = l == -1 || l == 2 || i1 == -1 || i1 == 3;
					if( l != -1 && l != 2 || i1 != -1 && i1 !=3) {
						Block j1 = world.getBlock(x + b0 * l, y + i1, z + b1 * l);
								if(flag) {
									if(j1 != ToeBlocks.neptuneBrick) {
										return false;
									}
								}
								else if(j1 != Blocks.air && j1 != Blocks.fire) {
									return false;
								}
					}
				}
			}
			for(l = 0; l < 2; ++l){
				for(i1 = 0; i1 < 3; ++i1){
					world.setBlock(x + b0 * l, y + i1, z + b1 * l, ToeBlocks.portalNeptune, 0, 2);
				}
			}
			return true;
		}
	}
	
	public boolean getPortalSize(World world, int x, int y, int z) {
		BlockPortalNeptune.Size size = new BlockPortalNeptune.Size(world, x, y, z, 1);
		BlockPortalNeptune.Size size1 = new BlockPortalNeptune.Size(world, x, y, z, 2);
		
		if (size.func_150860_b() && size.field_150864_e == 0) {
			size.func_150859_c();
			return true;
		} else if (size1.func_150860_b() && size1.field_150864_e == 0) {
			size1.func_150859_c();
			return true;
		} else {
			return false;
		}
	}
	
	//TODO make particles nicer.
	@SideOnly(Side.CLIENT)
    public void randomDisplayTick(World p_149734_1_, int p_149734_2_, int p_149734_3_, int p_149734_4_, Random p_149734_5_) {
        if (p_149734_5_.nextInt(100) == 0) {
            p_149734_1_.playSound((double)p_149734_2_ + 0.5D, (double)p_149734_3_ + 0.5D, (double)p_149734_4_ + 0.5D, "portal.portal", 0.5F, p_149734_5_.nextFloat() * 0.4F + 0.8F, false);
        }

        for (int l = 0; l < 4; ++l) {
            double d0 = (double)((float)p_149734_2_ + p_149734_5_.nextFloat());
            double d1 = (double)((float)p_149734_3_ + p_149734_5_.nextFloat());
            double d2 = (double)((float)p_149734_4_ + p_149734_5_.nextFloat());
            double d3 = 0.0D;
            double d4 = 0.0D;
            double d5 = 0.0D;
            int i1 = p_149734_5_.nextInt(2) * 2 - 1;
            d3 = ((double)p_149734_5_.nextFloat() - 0.5D) * 0.5D;
            d4 = ((double)p_149734_5_.nextFloat() - 0.5D) * 0.5D;
            d5 = ((double)p_149734_5_.nextFloat() - 0.5D) * 0.5D;

            if (p_149734_1_.getBlock(p_149734_2_ - 1, p_149734_3_, p_149734_4_) != this && p_149734_1_.getBlock(p_149734_2_ + 1, p_149734_3_, p_149734_4_) != this) {
                d0 = (double)p_149734_2_ + 0.5D + 0.25D * (double)i1;
                d3 = (double)(p_149734_5_.nextFloat() * 2.0F * (float)i1);
            } else {
                d2 = (double)p_149734_4_ + 0.5D + 0.25D * (double)i1;
                d5 = (double)(p_149734_5_.nextFloat() * 2.0F * (float)i1);
            }

            //p_149734_1_.spawnParticle("smoke", d0, d1, d2, d3, d4, d5);
            ParticleEffects.spawnParticle("portalNeptune", d0, d1, d2, d3, d4, d5);
        }
    }
	
	public static class Size {
		private final World worldObj;
		private final int field_150865_b;
		private final int field_150866_c;
		private final int field_150863_d;
		private int field_150864_e = 0;
		private ChunkCoordinates field_150861_f;
		private int field_150862_g;
		private int field_150868_h;

		public Size(World p_i45415_1_, int p_i45415_2_, int p_i45415_3_, int p_i45415_4_, int p_i45415_5_) {
			this.worldObj = p_i45415_1_;
			this.field_150865_b = p_i45415_5_;
			this.field_150863_d = BlockHollowsPortal.field_150001_a[p_i45415_5_][0];
			this.field_150866_c = BlockHollowsPortal.field_150001_a[p_i45415_5_][1];

			for (int i1 = p_i45415_3_; p_i45415_3_ > i1 - 21 && p_i45415_3_ > 0 && this.getBlockMaterial(p_i45415_1_.getBlock(p_i45415_2_, p_i45415_3_ - 1, p_i45415_4_)); --p_i45415_3_) {
				;
			}

			int j1 = this.func_150853_a(p_i45415_2_, p_i45415_3_, p_i45415_4_, this.field_150863_d) - 1;

			if (j1 >= 0) {
				this.field_150861_f = new ChunkCoordinates(p_i45415_2_ + j1 * Direction.offsetX[this.field_150863_d], p_i45415_3_, p_i45415_4_ + j1 * Direction.offsetZ[this.field_150863_d]);
				this.field_150868_h = this.func_150853_a(this.field_150861_f.posX, this.field_150861_f.posY, this.field_150861_f.posZ, this.field_150866_c);

				if (this.field_150868_h < 2 || this.field_150868_h > 21) {
					this.field_150861_f = null;
					this.field_150868_h = 0;
				}
			}

			if (this.field_150861_f != null) {
				this.field_150862_g = this.func_150858_a();
			}
		}

		protected int func_150853_a(int x, int y, int z, int p_150853_4_) {
			int j1 = Direction.offsetX[p_150853_4_];
			int k1 = Direction.offsetZ[p_150853_4_];
			int i1;
			Block block;

			for (i1 = 0; i1 < 22; ++i1) {
				block = this.worldObj.getBlock(x + j1 * i1, y, z + k1 * i1);

				if (!this.getBlockMaterial(block)) {
					break;
				}

				Block block1 = this.worldObj.getBlock(x + j1 * i1, y - 1, z + k1 * i1);

				if (block1 != ToeBlocks.neptuneBrick) {
					break;
				}
			}

			block = this.worldObj.getBlock(x + j1 * i1, y, z + k1 * i1);
			return block == ToeBlocks.neptuneBrick ? i1 : 0;
		}

		protected int func_150858_a() {
			int i;
			int j;
			int k;
			int l;
			label56:

				for (this.field_150862_g = 0; this.field_150862_g < 21; ++this.field_150862_g) {
					i = this.field_150861_f.posY + this.field_150862_g;

					for (j = 0; j < this.field_150868_h; ++j) {
						k = this.field_150861_f.posX + j * Direction.offsetX[BlockHollowsPortal.field_150001_a[this.field_150865_b][1]];
						l = this.field_150861_f.posZ + j * Direction.offsetZ[BlockHollowsPortal.field_150001_a[this.field_150865_b][1]];
						Block block = this.worldObj.getBlock(k, i, l);

						if (!this.getBlockMaterial(block)) {
							break label56;
						}

						if (block == ToeBlocks.portalNeptune) {
							++this.field_150864_e;
						}

						if (j == 0) {
							block = this.worldObj.getBlock(k + Direction.offsetX[BlockHollowsPortal.field_150001_a[this.field_150865_b][0]], i, l + Direction.offsetZ[BlockHollowsPortal.field_150001_a[this.field_150865_b][0]]);

							if (block != ToeBlocks.neptuneBrick) {
								break label56;
							}
						} else if (j == this.field_150868_h - 1) {
							block = this.worldObj.getBlock(k + Direction.offsetX[BlockHollowsPortal.field_150001_a[this.field_150865_b][1]], i, l + Direction.offsetZ[BlockHollowsPortal.field_150001_a[this.field_150865_b][1]]);

							if (block != ToeBlocks.neptuneBrick) {
								break label56;
							}
						}
					}
				}

			for (i = 0; i < this.field_150868_h; ++i) {
				j = this.field_150861_f.posX + i * Direction.offsetX[BlockHollowsPortal.field_150001_a[this.field_150865_b][1]];
				k = this.field_150861_f.posY + this.field_150862_g;
				l = this.field_150861_f.posZ + i * Direction.offsetZ[BlockHollowsPortal.field_150001_a[this.field_150865_b][1]];

				if (this.worldObj.getBlock(j, k, l) != ToeBlocks.neptuneBrick) {
					this.field_150862_g = 0;
					break;
				}
			}

			if (this.field_150862_g <= 21 && this.field_150862_g >= 3) {
				return this.field_150862_g;
			} else {
				this.field_150861_f = null;
				this.field_150868_h = 0;
				this.field_150862_g = 0;
				return 0;
			}
		}
		
		protected boolean getBlockMaterial(Block block) {
			return block.getMaterial() == Material.air || block == ToeBlocks.hollowFire || block == Blocks.fire || block == ToeBlocks.portalNeptune;
		}

		public boolean func_150860_b() {
			return this.field_150861_f != null && this.field_150868_h >= 2 && this.field_150868_h <= 21 && this.field_150862_g >= 3 && this.field_150862_g <= 21;
		}

		public void func_150859_c() {
			for (int i = 0; i < this.field_150868_h; ++i) {
				int j = this.field_150861_f.posX + Direction.offsetX[this.field_150866_c] * i;
				int k = this.field_150861_f.posZ + Direction.offsetZ[this.field_150866_c] * i;

				for (int l = 0; l < this.field_150862_g; ++l) {
					int i1 = this.field_150861_f.posY + l;
					this.worldObj.setBlock(j, i1, k, ToeBlocks.portalNeptune, this.field_150865_b, 2);
				}
			}
		}
	}
}