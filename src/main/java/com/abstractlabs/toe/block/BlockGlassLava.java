package com.abstractlabs.toe.block;

import com.abstractlabs.toe.reference.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class BlockGlassLava extends BlockToe {
	public IIcon side;
	
	public BlockGlassLava() {
		super(Material.glass, Block.soundTypeGlass, "glassLava");
		this.setLightLevel(1.0F);
		setHardness(0.2F);
	}
	
	public void registerBlockIcons(IIconRegister ir) {
		side = ir.registerIcon(Reference.MOD_ID + ":glassLava");
	}
	
	@SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        return this.side;
    }
}