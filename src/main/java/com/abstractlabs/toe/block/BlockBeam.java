package com.abstractlabs.toe.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.util.Vec3;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import com.abstractlabs.toe.reference.Color;
import com.abstractlabs.toe.reference.Reference;
import com.abstractlabs.toe.skill.arenalism.ArenalismHelper;
import com.abstractlabs.toe.utility.Helper;
import com.abstractlabs.toe.utility.LogHelper;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockBeam extends BlockToe {
	public static IIcon side;
	
	public BlockBeam() {
		super(Material.portal, Block.soundTypeSnow, "beam");
		setHardness(1);
	}
    
	public void registerBlockIcons(IIconRegister ir) {
		side = ir.registerIcon(Reference.MOD_ID + ":beam");
	}
	
	@SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        return Blocks.portal.getIcon(side, meta);
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
    }
    
    public void onEntityWalking(World world, int x, int y, int z, Entity entity) {
        //entity.addVelocity(0, -0.5, 0);
        //LogHelper.info("entity walking.");
    }
    
//    public void velocityToAddToEntity(World p_149640_1_, int p_149640_2_, int p_149640_3_, int p_149640_4_, Entity p_149640_5_, Vec3 p_149640_6_)
//    {
//        Vec3 vec31 = this.getFlowVector(p_149640_1_, p_149640_2_, p_149640_3_, p_149640_4_);
//        p_149640_6_.xCoord += vec31.xCoord;
//        p_149640_6_.yCoord += vec31.yCoord;
//        p_149640_6_.zCoord += vec31.zCoord;
//    }
    
//    private Vec3 getFlowVector(IBlockAccess p_149800_1_, int p_149800_2_, int p_149800_3_, int p_149800_4_)
//    {
//        Vec3 vec3 = Vec3.createVectorHelper(0.0D, 0.0D, 0.0D);
//        int l = this.getEffectiveFlowDecay(p_149800_1_, p_149800_2_, p_149800_3_, p_149800_4_);
//
//        for (int i1 = 0; i1 < 4; ++i1)
//        {
//            int j1 = p_149800_2_;
//            int k1 = p_149800_4_;
//
//            if (i1 == 0)
//            {
//                j1 = p_149800_2_ - 1;
//            }
//
//            if (i1 == 1)
//            {
//                k1 = p_149800_4_ - 1;
//            }
//
//            if (i1 == 2)
//            {
//                ++j1;
//            }
//
//            if (i1 == 3)
//            {
//                ++k1;
//            }
//
//            int l1 = this.getEffectiveFlowDecay(p_149800_1_, j1, p_149800_3_, k1);
//            int i2;
//
//            if (l1 < 0)
//            {
//                if (!p_149800_1_.getBlock(j1, p_149800_3_, k1).getMaterial().blocksMovement())
//                {
//                    l1 = this.getEffectiveFlowDecay(p_149800_1_, j1, p_149800_3_ - 1, k1);
//
//                    if (l1 >= 0)
//                    {
//                        i2 = l1 - (l - 8);
//                        vec3 = vec3.addVector((double)((j1 - p_149800_2_) * i2), (double)((p_149800_3_ - p_149800_3_) * i2), (double)((k1 - p_149800_4_) * i2));
//                    }
//                }
//            }
//            else if (l1 >= 0)
//            {
//                i2 = l1 - l;
//                vec3 = vec3.addVector((double)((j1 - p_149800_2_) * i2), (double)((p_149800_3_ - p_149800_3_) * i2), (double)((k1 - p_149800_4_) * i2));
//            }
//        }
//
//        if (p_149800_1_.getBlockMetadata(p_149800_2_, p_149800_3_, p_149800_4_) >= 8)
//        {
//            boolean flag = false;
//
//            if (flag || this.isBlockSolid(p_149800_1_, p_149800_2_, p_149800_3_, p_149800_4_ - 1, 2))
//            {
//                flag = true;
//            }
//
//            if (flag || this.isBlockSolid(p_149800_1_, p_149800_2_, p_149800_3_, p_149800_4_ + 1, 3))
//            {
//                flag = true;
//            }
//
//            if (flag || this.isBlockSolid(p_149800_1_, p_149800_2_ - 1, p_149800_3_, p_149800_4_, 4))
//            {
//                flag = true;
//            }
//
//            if (flag || this.isBlockSolid(p_149800_1_, p_149800_2_ + 1, p_149800_3_, p_149800_4_, 5))
//            {
//                flag = true;
//            }
//
//            if (flag || this.isBlockSolid(p_149800_1_, p_149800_2_, p_149800_3_ + 1, p_149800_4_ - 1, 2))
//            {
//                flag = true;
//            }
//
//            if (flag || this.isBlockSolid(p_149800_1_, p_149800_2_, p_149800_3_ + 1, p_149800_4_ + 1, 3))
//            {
//                flag = true;
//            }
//
//            if (flag || this.isBlockSolid(p_149800_1_, p_149800_2_ - 1, p_149800_3_ + 1, p_149800_4_, 4))
//            {
//                flag = true;
//            }
//
//            if (flag || this.isBlockSolid(p_149800_1_, p_149800_2_ + 1, p_149800_3_ + 1, p_149800_4_, 5))
//            {
//                flag = true;
//            }
//
//            if (flag)
//            {
//                vec3 = vec3.normalize().addVector(0.0D, -6.0D, 0.0D);
//            }
//        }
//
//        vec3 = vec3.normalize();
//        return vec3;
//    }
//    
//    protected int getEffectiveFlowDecay(IBlockAccess p_149798_1_, int p_149798_2_, int p_149798_3_, int p_149798_4_)
//    {
//        if (p_149798_1_.getBlock(p_149798_2_, p_149798_3_, p_149798_4_).getMaterial() != this.blockMaterial)
//        {
//            return -1;
//        }
//        else
//        {
//            int l = p_149798_1_.getBlockMetadata(p_149798_2_, p_149798_3_, p_149798_4_);
//
//            if (l >= 8)
//            {
//                l = 0;
//            }
//
//            return l;
//        }
//    }
}