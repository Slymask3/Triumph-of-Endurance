package com.abstractlabs.toe.block;

import com.abstractlabs.toe.creativetab.ToeTab;
import com.abstractlabs.toe.reference.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.BlockGlass;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.util.Facing;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockExteriorGlass extends BlockGlass {
	public BlockExteriorGlass() {
		super(Material.glass, false);
		setHardness(-1);
		setCreativeTab(ToeTab.TOE_TAB);
		setBlockName(Reference.MOD_ID + ":exteriorGlass");
		setStepSound(Block.soundTypeGlass);
	}
	
	@SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        return Blocks.glass.getIcon(side, meta);
    }
}