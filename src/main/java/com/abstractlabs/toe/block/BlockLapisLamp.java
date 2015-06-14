package com.abstractlabs.toe.block;

import com.abstractlabs.toe.reference.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class BlockLapisLamp extends BlockToe {
	public IIcon side;
	
	public BlockLapisLamp() {
		super(Material.glass, Block.soundTypeGlass, "lapisLamp");
		this.setLightLevel(1.0F);
	}
	
	
	public void registerBlockIcons(IIconRegister ir) {
		side = ir.registerIcon(Reference.MOD_ID + ":lapisLamp");
	}
	
	@SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        return this.side;
    }
}