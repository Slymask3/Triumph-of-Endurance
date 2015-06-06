package com.abstractlabs.toe.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Facing;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import com.abstractlabs.toe.gui.GuiScreenOverlay;
import com.abstractlabs.toe.reference.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockBeam extends BlockToe {
	public static IIcon top;
	public static IIcon side;
//	public static IIcon side2;
//	public static IIcon side3;
//	public static IIcon side4;
	
	public BlockBeam() {
		super(Material.portal, Block.soundTypeSnow, "beam");
		setHardness(1);
		setBlockBounds(0.1F, 0.0F, 0.1F, 0.9F, 1.0F, 0.9F);
		setLightOpacity(0);
		setLightLevel(0.75F);
	}
	
	public boolean isOpaqueCube() {
        return false;
    }
	
	@Override
	public int getRenderBlockPass() {
		return 1;
	}
	
	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}
    
	public void registerBlockIcons(IIconRegister ir) {
		top = ir.registerIcon(Reference.MOD_ID + ":beam_top");
		side = ir.registerIcon(Reference.MOD_ID + ":beam_side");
//		side2 = ir.registerIcon(Reference.MOD_ID + ":beam_side_2");
//		side3 = ir.registerIcon(Reference.MOD_ID + ":beam_side_3");
//		side4 = ir.registerIcon(Reference.MOD_ID + ":beam_side_4");
	}
	
	@SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        if(side == 0 || side == 1) {
        	return top;
        }/* else if(side == 2) {
        	return this.side;
        } else if(side == 3) {
        	return this.side2;
        } else if(side == 4) {
        	return this.side3;
        } else if(side == 5) {
        	return this.side4;
        }*/ else {
        	return this.side;
        }
    }
	
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
        return null;
    }

    public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {
        //entity.moveEntity(0, 0.00001, 0);
        //LogHelper.info("entity collided.");
        //entity.posY = entity.posY + 0.1;
        
        entity.addVelocity(0, 0.05, 0);
        
        //entity.motionY += 0.05;
        //entity.serverPosY += 0.05;
        //entity.moveFlying(0F, 1F, 0F);
//        if(!world.isRemote && entity instanceof EntityPlayer) {
//        	Toe.packetPipeline.sendTo(new PacketScreenOverlay(5, 1), (EntityPlayerMP) entity);
//        }
        
        if(world.isRemote) {
        	GuiScreenOverlay.showTicks = 5;
    		GuiScreenOverlay.image = 1;
        }
    }
    
    public void onEntityWalking(World world, int x, int y, int z, Entity entity) {
        //entity.addVelocity(0, -0.5, 0);
        //LogHelper.info("entity walking.");
    }

	int bot = 0;    //y-
	int topp = 1;   //y+
	int blue = 2;   //z-
	int purple = 3; //z+
	int green = 4;  //x-
	int red = 5;    //x+
    
//    @SideOnly(Side.CLIENT)
//	public boolean shouldSideBeRendered(IBlockAccess ba, int x, int y, int z, int side) {
//		boolean f1 = ba.getBlock(x, y-1, z) == this && side == 0;
//		boolean f2 = ba.getBlock(x, y+1, z) == this && side == 1;
//		boolean f3 = ba.getBlock(x, y, z-1) == this && side == blue;
//		boolean f4 = ba.getBlock(x, y, z+1) == this && side == purple;
//		boolean f5 = ba.getBlock(x-1, y, z) == this && side == green;
//		boolean f6 = ba.getBlock(x+1, y, z) == this && side == red;
////		boolean f7 = ba.getBlock(x-1, y, z) == this && side == blue;
////		boolean f8 = ba.getBlock(x+1, y, z) == this && side == purple;
////		boolean f9 = ba.getBlock(x, y, z-1) == this && side == green;
////		boolean f10 = ba.getBlock(x, y, z+1) == this && side == red;
////		boolean f3 = ba.getBlock(x+1, y, z) == this && side == blue;
////		boolean f4 = ba.getBlock(x-1, y, z) == this && side == purple;
////		boolean f5 = ba.getBlock(x, y, z+1) == this && side == green;
////		boolean f6 = ba.getBlock(x, y, z-1) == this && side == red;
////		boolean f7 = ba.getBlock(x-1, y, z) == this && side == blue;
////		boolean f8 = ba.getBlock(x+1, y, z) == this && side == purple;
////		boolean f9 = ba.getBlock(x, y, z-1) == this && side == green;
////		boolean f10 = ba.getBlock(x, y, z+1) == this && side == red;
////		
////		if(f1 || f2 || f3 || f4 || f5 || f6){// || f7 || f8 || f9 || f10) {
////			return false;
////		} else {
//			return true;
//		//}
//	}
    
	@SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockAccess ba, int x, int y, int z, int side) {
        Block block = ba.getBlock(x, y, z);

        if (ba.getBlockMetadata(x, y, z) != ba.getBlockMetadata(x - Facing.offsetsXForSide[side], y - Facing.offsetsYForSide[side], z - Facing.offsetsZForSide[side])) {
            return true;
        }

        if (block == this) {
            return false;
        }

        return  block == this ? false : super.shouldSideBeRendered(ba, x, y, z, side);
    }
	
    public void setBlockBoundsBasedOnState(IBlockAccess ba, int x, int y, int z) {
        boolean flag = this.canConnect(ba, x, y, z - 1);
        boolean flag1 = this.canConnect(ba, x, y, z + 1);
        boolean flag2 = this.canConnect(ba, x - 1, y, z);
        boolean flag3 = this.canConnect(ba, x + 1, y, z);
        float f = 0.1F;
        float f1 = 0.9F;
        float f2 = 0.1F;
        float f3 = 0.9F;

        if (flag) {
            f2 = 0.0F;
        }

        if (flag1) {
            f3 = 1.0F;
        }

        if (flag2) {
            f = 0.0F;
        }

        if (flag3) {
            f1 = 1.0F;
        }

        this.setBlockBounds(f, 0.0F, f2, f1, 1.0F, f3);
    }
    
    private boolean canConnect(IBlockAccess ba, int x, int y, int z) {
        Block block = ba.getBlock(x, y, z);
        return block == this;
    }
}