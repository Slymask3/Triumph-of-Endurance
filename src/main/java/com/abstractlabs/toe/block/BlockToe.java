package com.abstractlabs.toe.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

import com.abstractlabs.toe.creativetab.ToeTab;
import com.abstractlabs.toe.reference.Reference;
import com.abstractlabs.toe.utility.BlockTexture;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockToe extends Block {
	private String name;
	private int quantityDropped;
	private BlockTexture texture = new BlockTexture("default");
	private IIcon top;
	private IIcon bottom;
	private IIcon left;
	private IIcon right;
	private IIcon front;
	private IIcon back;
	
	public BlockToe(Material material, SoundType sound, String name) {
		super(material);
		setCreativeTab(ToeTab.TOE_TAB);
		setBlockName(Reference.MOD_ID + ":" + name);
		setStepSound(sound);
		setHardness(1.0F);
		setResistance(1.0F);
		this.name = name;
		this.quantityDropped = 1;
	}
	
	public BlockToe(String name, BlockTexture texture, Material material, SoundType sound) {
		super(material);
		setCreativeTab(ToeTab.TOE_TAB);
		setBlockName(Reference.MOD_ID + ":" + name);
		setStepSound(sound);
		setHardness(1.0F);
		setResistance(1.0F);
		this.name = name;
		this.texture = texture;
		this.quantityDropped = 1;
	}
	
	public BlockToe(String name, BlockTexture texture, Material material, SoundType sound, float hardness) {
		super(material);
		setCreativeTab(ToeTab.TOE_TAB);
		setBlockName(Reference.MOD_ID + ":" + name);
		setStepSound(sound);
		setHardness(hardness);
		setResistance(1.0F);
		this.name = name;
		this.texture = texture;
		this.quantityDropped = 1;
	}
	
	public BlockToe(String name, BlockTexture texture, Material material, SoundType sound, float hardness, float resistance) {
		super(material);
		setCreativeTab(ToeTab.TOE_TAB);
		setBlockName(Reference.MOD_ID + ":" + name);
		setStepSound(sound);
		setHardness(hardness);
		setResistance(resistance);
		this.name = name;
		this.texture = texture;
		this.quantityDropped = 1;
	}
	
	public BlockToe(String name, BlockTexture texture, Material material, SoundType sound, float hardness, float resistance, float slipperness) {
		super(material);
		setCreativeTab(ToeTab.TOE_TAB);
		setBlockName(Reference.MOD_ID + ":" + name);
		setStepSound(sound);
		setHardness(hardness);
		setResistance(resistance);
		this.name = name;
		this.texture = texture;
		this.quantityDropped = 1;
		this.slipperiness = slipperness;
	}
	
	public BlockToe(String name, BlockTexture texture, Material material, SoundType sound, float hardness, float resistance, int quantityDropped) {
		super(material);
		setCreativeTab(ToeTab.TOE_TAB);
		setBlockName(Reference.MOD_ID + ":" + name);
		setStepSound(sound);
		setHardness(hardness);
		setResistance(resistance);
		this.name = name;
		this.texture = texture;
		this.quantityDropped = quantityDropped;
	}
	
	public void registerBlockIcons(IIconRegister ir) {
		top = ir.registerIcon(texture.getTop());
		bottom = ir.registerIcon(texture.getBottom());
		left = ir.registerIcon(texture.getLeft());
		right = ir.registerIcon(texture.getRight());
		front = ir.registerIcon(texture.getFront());
		back = ir.registerIcon(texture.getBack());
	}
	
	@SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        if(side == 0) {
        	return bottom;
        } else if(side == 1) {
        	return top;
        } else if(side == 2) {
        	return left;
        } else if(side == 3) {
        	return right;
        } else if(side == 4) {
        	return front;
        } else if(side == 5) {
        	return back;
        } else {
        	return bottom;
        }
    }
	
	public int quantityDropped(Random rand) {
		return quantityDropped;
    }
	
	public BlockToe setSlipperiness(float slipperiness) {
		this.slipperiness = slipperiness;
		return this;
	}
}