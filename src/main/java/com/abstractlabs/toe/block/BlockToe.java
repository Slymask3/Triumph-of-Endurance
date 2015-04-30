package com.abstractlabs.toe.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import com.abstractlabs.toe.creativetab.ToeTab;
import com.abstractlabs.toe.reference.Reference;

public class BlockToe extends Block {
	public BlockToe(Material material, SoundType sound, String name) {
		super(material);
		setCreativeTab(ToeTab.TOE_TAB);
		setBlockName(Reference.MOD_ID + ":" + name);
		setStepSound(sound);
		//setBlockTextureName(Reference.MOD_ID + ":" + name);
	}
}