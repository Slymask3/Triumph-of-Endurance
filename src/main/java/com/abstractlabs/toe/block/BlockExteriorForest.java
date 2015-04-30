package com.abstractlabs.toe.block;

import com.abstractlabs.toe.reference.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class BlockExteriorForest extends BlockToe {
	public static IIcon side;
	
	public BlockExteriorForest() {
		super(Material.wood, Block.soundTypeWood, "exteriorForest");
		setHardness(-1);
	}
    
	public void registerBlockIcons(IIconRegister ir) {
		side = ir.registerIcon(Reference.MOD_ID + ":exteriorForest");
	}
	
	@SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        return this.side;
    }
}