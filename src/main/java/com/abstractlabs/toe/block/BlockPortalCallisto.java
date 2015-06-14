package com.abstractlabs.toe.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockPortal;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import com.abstractlabs.toe.creativetab.ToeTab;
import com.abstractlabs.toe.init.ToeBlocks;
import com.abstractlabs.toe.init.ToeDimensions;
import com.abstractlabs.toe.reference.Reference;
import com.abstractlabs.toe.world.teleporter.TeleporterCallisto;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockPortalCallisto extends BlockPortal {
	public static IIcon side;
	
	public BlockPortalCallisto(){
		super();
		setCreativeTab(ToeTab.TOE_TAB);
		setBlockName(Reference.MOD_ID + ":portalCallisto");
	}
    
	public void registerBlockIcons(IIconRegister ir) {
		side = ir.registerIcon(Reference.MOD_ID + ":portalCallisto");
	}
	
	@SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        return this.side;
    }
	
	/*public void updateTick(World world, int x, int y, int z, Random rand){
		
	}*/
	
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z){
		return null;
	}
	
	public boolean renderAsNormalBlock(){
		return false;
	}
	
	public void onNeighborBlockChange(World world, int x, int y, int z, Block block){
//		
//		byte b0 = 0;
//		byte b1 = 1;
//		
//		if(world.getBlock(x - 1, y, z) == ToeBlocks.rubyBlock || world.getBlock(x + 1, y, z) == ToeBlocks.rubyBlock){
//			b0 = 1;
//			b1 = 0;
//		}
//		
//		int i1;
//		
//		for(i1 = y; world.getBlock(x, i1 - 1, z) == this; --i1){
//			;
//		}
//		if(world.getBlock(x, i1 - 1, z) != ToeBlocks.rubyBlock){
//			world.setBlockToAir(x, y, z);
//		}else{
//			int j1;
//			
//			for(j1 = 1; j1 < 4 && world.getBlock(x, i1 + j1, z) == this; ++j1){
//				;
//			}
//			if(j1 == 3 && world.getBlock(x, i1 + j1, z) == ToeBlocks.rubyBlock){
//				boolean flag = world.getBlock(x - 1, y, z) == this || world.getBlock(x + 1, y, z) == this;
//				boolean flag1 = world.getBlock(x, y, z - 1) == this || world.getBlock(x, y, z - 1) == this;
//				
//				if(flag && flag1){
//					world.setBlockToAir(x, y, z);
//				}else{
//					if((world.getBlock(x+b0, y, z+b1) != ToeBlocks.rubyBlock || world.getBlock(x-b0, y, z-b1) != this) && (world.getBlock(x-b0, y, z-b1) !=ToeBlocks.rubyBlock || world.getBlock(x+b0, y, z+b1) != this)){
//						world.setBlockToAir(x, y, z);
//					}
//				}
//			}else{
//				world.setBlockToAir(x, y, z);
//			}
//		}
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
					
				}else if(thePlayer.dimension != ToeDimensions.callisto){
					thePlayer.timeUntilPortal = 10;
					thePlayer.mcServer.getConfigurationManager().transferPlayerToDimension(thePlayer, ToeDimensions.callisto, new TeleporterCallisto(server.worldServerForDimension(ToeDimensions.callisto)));
					
				}else{
					thePlayer.timeUntilPortal = 10;
					thePlayer.mcServer.getConfigurationManager().transferPlayerToDimension(thePlayer, 0, new TeleporterCallisto(server.worldServerForDimension(0)));
				}
				
			}
			
		}
	}
	
	public boolean tryTroCreatePortal(World world, int x, int y, int z){
		byte b0 = 0;
		byte b1 = 0;
		if(world.getBlock(x - 1 , y, z) == ToeBlocks.rubyBlock || world.getBlock(x + 1, y, z) == ToeBlocks.rubyBlock){
			b0 = 1;
		}
		
		if (world.getBlock(x, y, z - 1) == ToeBlocks.rubyBlock || world.getBlock(x, y, z + 1) == ToeBlocks.rubyBlock){
			b1 = 1;
		}
		
		if(b0 == b1){
			return false;
			
		}
		else{
			if(world.getBlock(x - b0, y, z - b1) == Blocks.air){
				x -= b0;
				z -= b1;
					
			}
			int l;
			int i1;
			for(l = -1; l <= 2; ++l){
				for(i1 = -1; i1 <= 3; ++i1){
					boolean flag = l == -1 || l == 2 || i1 == -1 || i1 == 3;
					if( l != -1 && l != 2 || i1 != -1 && i1 !=3){
						Block j1 = world.getBlock(x + b0 * l, y + i1, z + b1 * l);
								if(flag){
									if(j1 != ToeBlocks.rubyBlock){
										return false;
									}
								}
								else if(j1 != Blocks.air && j1 != Blocks.fire){
									return false;
								}
					}
				}
			}
			for(l = 0; l < 2; ++l){
				for(i1 = 0; i1 < 3; ++i1){
					world.setBlock(x + b0 * l, y + i1, z + b1 * l, ToeBlocks.portalCallisto, 0, 2);
				}
			}
			return true;
		}
	}
	

}