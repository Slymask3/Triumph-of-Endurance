package com.abstractlabs.toe.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockExteriorForest extends BlockToe {
	
	public BlockExteriorForest() {
		super(Material.wood, Block.soundTypeWood, "exteriorForest");
		setHardness(-1);
	}
}