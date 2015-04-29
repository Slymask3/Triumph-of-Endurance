package com.abstractlabs.toe.block;

import com.abstractlabs.toe.reference.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class BlockExterior extends Block {

	public static IIcon side;
	private String name = "default";
	
	public BlockExterior(Material material, SoundType stepSound, String name) {
		super(material);
		setBlockName(Reference.MOD_ID + ":" + name);
		setStepSound(stepSound);
		setHardness(-1);
		setBlockTextureName(Reference.MOD_ID + ":" + name);
		this.name = name;
	}
    
	public void registerBlockIcons(IIconRegister ir) {
		side = ir.registerIcon(Reference.MOD_ID + ":" + name);
	}
	
	@SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        return this.side;
    }
	
}