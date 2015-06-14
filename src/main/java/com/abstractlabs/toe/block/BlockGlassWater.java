package com.abstractlabs.toe.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockGlass;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

import com.abstractlabs.toe.creativetab.ToeTab;
import com.abstractlabs.toe.reference.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockGlassWater extends BlockGlass {
	public IIcon side;
	
	public BlockGlassWater() {
		super(Material.glass, false);
		setCreativeTab(ToeTab.TOE_TAB);
		setBlockName(Reference.MOD_ID + ":glassWater");
		setStepSound(Block.soundTypeGlass);
		setHardness(0.2F);
	}
	
	public void registerBlockIcons(IIconRegister ir) {
		side = ir.registerIcon(Reference.MOD_ID + ":glassWater");
	}
	
	@SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        return this.side;
    }
	
	@SideOnly(Side.CLIENT)
    public int getRenderBlockPass() {
        return 1;
    }
	
	public int quantityDropped(Random random) {
        return 1;
    }
}