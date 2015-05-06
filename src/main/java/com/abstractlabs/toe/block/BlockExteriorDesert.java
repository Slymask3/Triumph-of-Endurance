package com.abstractlabs.toe.block;

import com.abstractlabs.toe.reference.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class BlockExteriorDesert extends BlockToe {
	public static IIcon side;
	
	public BlockExteriorDesert() {
		super(Material.sand, Block.soundTypeSand, "exteriorDesert");
		setHardness(-1);
		setResistance(6000000.0F);
		setLightOpacity(0);
	}
    
	public void registerBlockIcons(IIconRegister ir) {
		side = ir.registerIcon(Reference.MOD_ID + ":exteriorDesert");
	}
	
	@SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        return this.side;
    }
	
	@SideOnly(Side.CLIENT)
    public int getRenderBlockPass() {
        return 0;
    }
}