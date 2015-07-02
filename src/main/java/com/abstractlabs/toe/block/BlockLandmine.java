package com.abstractlabs.toe.block;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import com.abstractlabs.toe.reference.Reference;
import com.abstractlabs.toe.reference.RenderID;
import com.abstractlabs.toe.tileentity.TileEntityLandmine;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockLandmine extends BlockToe implements ITileEntityProvider {
	private IIcon side;
	
    public BlockLandmine() {
        super(Material.circuits, Block.soundTypePiston, "landmine");
        setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.1F, 1.0F);
        setBlockTextureName(Reference.MOD_ID + ":landmine");
    }
    
    @SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister ir) {
    	this.side = ir.registerIcon(Reference.MOD_ID + ":landmine");
	}
    
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        return this.side;
    }
    
    public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {
    	world.playSoundEffect(x, y, z, "random.click", 1.0F, 1.0F);
    	
        if (!world.isRemote) {
        	world.setBlock(x, y, z, Blocks.air);
        	world.createExplosion(null, x, y, z, 3.0F, true);
        }
    }
    
    public boolean canPlaceBlockAt(World world, int x, int y, int z) {
        return world.getBlock(x, y-1, z) != Blocks.air;
    }
    
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
        return null;
    }
    
    public boolean isOpaqueCube() {
        return false;
    }
    
    public boolean renderAsNormalBlock() {
        return false;
    }
    
    public int getRenderType() {
        return RenderID.landmine;
    }
    
	@Override
	public TileEntity createNewTileEntity(World world, int par2) {
		return new TileEntityLandmine();
	}
}