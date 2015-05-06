package com.abstractlabs.toe.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import com.abstractlabs.toe.creativetab.ToeTab;
import com.abstractlabs.toe.reference.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockQuicksand extends BlockFalling {
	public IIcon side;
	
	public BlockQuicksand() {
		super(Material.sand);
		setCreativeTab(ToeTab.TOE_TAB);
		setBlockName(Reference.MOD_ID + ":quicksand");
		setStepSound(Block.soundTypeSand);
		setHardness(0.5F);
	}
	
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
        float depth = 0.5F;
        return AxisAlignedBB.getBoundingBox((double)x, (double)y, (double)z, (double)(x + 1), (double)((float)(y + 1) - depth), (double)(z + 1));
    }

    public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {
        //entity.motionX *= 0.3D;
        //entity.motionZ *= 0.3D;
        entity.setInWeb();
    }
    
    public void registerBlockIcons(IIconRegister ir) {
		side = ir.registerIcon(Reference.MOD_ID + ":quicksand");
	}
	
	@SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        return this.side;
    }
}
