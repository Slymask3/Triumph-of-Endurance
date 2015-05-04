package com.abstractlabs.toe.block;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBasePressurePlate;
import net.minecraft.block.BlockFence;
import net.minecraft.block.BlockPressurePlate;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;

import com.abstractlabs.toe.creativetab.ToeTab;
import com.abstractlabs.toe.entity.projectile.EntityGrenade;
import com.abstractlabs.toe.reference.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public abstract class BlockBaseLandmine extends Block
{
	private String field_150067_a;
    private static final String __OBFID = "CL_00000194";

	protected BlockBaseLandmine(String p_i45387_1_, Material p_i45387_2_)
    {
        super(p_i45387_2_);
        this.field_150067_a = p_i45387_1_;
        this.setCreativeTab(ToeTab.TOE_TAB);
        this.setTickRandomly(true);
        this.func_150063_b(this.func_150066_d(15));
    }
	
	 /**
     * Updates the blocks bounds based on its current state. Args: world, x, y, z
     */
    public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z)
    {
        this.func_150063_b(world.getBlockMetadata(x, y, z));
    }
    
    protected void func_150063_b(int x)
    {
        boolean flag = this.func_150060_c(x) > 0;
        float f = 0.0625F;

        if (flag)
        {
            this.setBlockBounds(f, 0.0F, f, 1.0F - f, 0.03125F, 1.0F - f);
        }
        else
        {
            this.setBlockBounds(f, 0.0F, f, 1.0F - f, 0.0625F, 1.0F - f);
        }
    }
    
    /**
     * How many world ticks before ticking
     */
    public int tickRate(World p_149738_1_)
    {
        return 20;
    }
    
    /**
     * Returns a bounding box from the pool of bounding boxes (this means this box can change after the pool has been
     * cleared to be reused)
     */
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z)
    {
        return null;
    }
    
    /**
     * Is this block (a) opaque and (b) a full 1m cube?  This determines whether or not to render the shared face of two
     * adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
     */
    public boolean isOpaqueCube()
    {
        return false;
    }
    
    /**
     * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
     */
    public boolean renderAsNormalBlock()
    {
        return false;
    }

    public boolean getBlocksMovement(IBlockAccess world, int x, int y, int z)
    {
        return true;
    }
    
    /**
     * Checks to see if its valid to put this block at the specified coordinates. Args: world, x, y, z
     */
    public boolean canPlaceBlockAt(World world, int x, int y, int z)
    {
        return World.doesBlockHaveSolidTopSurface(world, x, y - 1, z) || BlockFence.func_149825_a(world.getBlock(x, y - 1, z));
    }

    /**
     * Lets the block know when one of its neighbor changes. Doesn't know which neighbor changed (coordinates passed are
     * their own) Args: x, y, z, neighbor Block
     */
    public void onNeighborBlockChange(World world, int x, int y, int z, Block block)
    {
        boolean flag = false;

        if (!World.doesBlockHaveSolidTopSurface(world, x, y - 1, z) && !BlockFence.func_149825_a(world.getBlock(x, y - 1, z)))
        {
            flag = true;
        }

        if (flag)
        {
            this.dropBlockAsItem(world, x, y, z, world.getBlockMetadata(x, y, z), 0);
            world.setBlockToAir(x, y, z);
        }
    }
    
    /**
     * Ticks the block if it's been scheduled
     */
    public void updateTick(World world, int x, int y, int z, Random random)
    {
        if (!world.isRemote)
        {
            int l = this.func_150060_c(world.getBlockMetadata(x, y, z));

            if (l > 0)
            {
                this.func_150062_a(world, x, y, z, l);
            }
        }
    }
    
    /**
     * Triggered whenever an entity collides with this block (enters into the block). Args: world, x, y, z, entity
     */
    public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity)
    {
        if (!world.isRemote)
        {
            int l = this.func_150060_c(world.getBlockMetadata(x, y, z));

            if (l == 0)
            {
                this.func_150062_a(world, x, y, z, l);
            }
        }
    }
    
    protected void func_150062_a(World world, int a, int b, int c, int d)
    {
        int i1 = this.func_150065_e(world, a, b, c);
        boolean flag = d > 0;
        boolean flag1 = i1 > 0;

        if (d != i1)
        {
            world.setBlockMetadataWithNotify(a, b, c, this.func_150066_d(i1), 2);
            this.func_150064_a_(world, a, b, c);
            world.markBlockRangeForRenderUpdate(a, b, c, a, b, c);
        }

        if (!flag1 && flag)
        {
            world.playSoundEffect((double)a + 0.5D, (double)b + 0.1D, (double)c + 0.5D, "random.click", 0.3F, 0.5F);
        }
        else if (flag1 && !flag)
        {
            world.playSoundEffect((double)a + 0.5D, (double)b + 0.1D, (double)c + 0.5D, "random.click", 0.3F, 0.6F);
        }

        if (flag1)
        {
            world.scheduleBlockUpdate(a, b, c, this, this.tickRate(world));
        }
    }
    
    protected AxisAlignedBB func_150061_a(int x, int y, int z)
    {
        float f = 0.125F;
        return AxisAlignedBB.getBoundingBox((double)((float)x + f), (double)y, (double)((float)z + f), (double)((float)(x + 1) - f), (double)y + 0.25D, (double)((float)(z + 1) - f));
    }

    public void breakBlock(World world, int x, int y, int z, Block block, int a)
    {
        if (this.func_150060_c(a) > 0)
        {
            this.func_150064_a_(world, x, y, z);
        }

        super.breakBlock(world, x, y, z, block, a);
    }
    
    protected void func_150064_a_(World world, int x, int y, int z)
    {
        world.notifyBlocksOfNeighborChange(x, y, z, this);
        world.notifyBlocksOfNeighborChange(x, y - 1, z, this);
    }
    
    public int isProvidingWeakPower(IBlockAccess world, int a, int b, int c, int d)
    {
        return this.func_150060_c(world.getBlockMetadata(a, b, c));
    }

    public int isProvidingStrongPower(IBlockAccess world, int a, int b, int c_, int d)
    {
        return d == 1 ? this.func_150060_c(world.getBlockMetadata(a, b, c_)) : 0;
    }
    
    /**
     * Can this block provide power. Only wire currently seems to have this change based on its state.
     */
    public boolean canProvidePower()
    {
        return true;
    }

    /**
     * Sets the block's bounds for rendering it as an item
     */
    public void setBlockBoundsForItemRender()
    {
        float f = 0.5F;
        float f1 = 0.125F;
        float f2 = 0.5F;
        this.setBlockBounds(0.5F - f, 0.5F - f1, 0.5F - f2, 0.5F + f, 0.5F + f1, 0.5F + f2);
    }
    
    /**
     * Returns the mobility information of the block, 0 = free, 1 = can't push but can move over, 2 = total immobility
     * and stop pistons
     */
    public int getMobilityFlag()
    {
        return 1;
    }

    protected abstract int func_150065_e(World p_150065_1_, int p_150065_2_, int p_150065_3_, int p_150065_4_);

    protected abstract int func_150060_c(int p_150060_1_);

    protected abstract int func_150066_d(int p_150066_1_);

	/**
	  * Triggered whenever an entity collides with this block (enters into the block). Args: world, x, y, z, entity
	  */
	 /*
	 public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity)
	 {
		 if (entity.isCollided)
		 {
			 this.setStateIfMobInteractsWithPlate(world, x, y, z);
		 }
	 }
	*/

	 @SideOnly(Side.CLIENT)
	 public void registerBlockIcons(IIconRegister ir)
	 {
		 this.blockIcon = ir.registerIcon(Reference.MOD_ID + ":landmine");
	 }
}
