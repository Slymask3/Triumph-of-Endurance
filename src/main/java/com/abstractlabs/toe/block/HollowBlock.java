package com.abstractlabs.toe.block;

import com.abstractlabs.toe.creativetab.ToeTab;
import com.abstractlabs.toe.reference.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class HollowBlock extends Block
{
	public HollowBlock()
	{
		super(Material.rock);
		this.setBlockUnbreakable();
		this.setStepSound(Block.soundTypeStone);
		setCreativeTab(ToeTab.TOE_TAB);
		setBlockName(Reference.MOD_ID + ":hollowBlock");
	}
}
