package com.abstractlabs.toe.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import com.abstractlabs.toe.creativetab.ToeTab;
import com.abstractlabs.toe.reference.Reference;
import com.abstractlabs.toe.tileentity.TileEntityPedestalStonebrick;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockPedestalStonebrick extends BlockContainer implements ITileEntityProvider {
	public BlockPedestalStonebrick() {
		super(Material.rock);
		setCreativeTab(ToeTab.TOE_TAB);
		setBlockName(Reference.MOD_ID + ":pedestalStonebrick");
		setStepSound(Block.soundTypeStone);
		setHardness(3.0F);
		setBlockBounds(0.1F, 0.0F, 0.1F, 0.9F, 1.0F, 0.9F);
	}
	
	@SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        return Blocks.stonebrick.getIcon(side, meta);
    }
	
	public boolean isOpaqueCube() {
        return false;
    }

	public boolean renderAsNormalBlock() {
        return false;
    }

    public int getRenderType() {
        return 9130;
    }
	
	@Override
	public TileEntity createNewTileEntity(World world, int par2) {
		return new TileEntityPedestalStonebrick();
	}
}