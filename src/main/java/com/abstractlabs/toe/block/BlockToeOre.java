package com.abstractlabs.toe.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockToeOre extends BlockToe {
	public BlockToeOre(String name, int harvest) {
		super(Material.rock, Block.soundTypeStone, name);
		setHardness(3.0F);
		setHarvestLevel("pickaxe", harvest);
	}
}