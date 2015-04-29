package com.abstractlabs.toe.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockExteriorDesert extends BlockToe {
	
	public BlockExteriorDesert() {
		super(Material.sand, Block.soundTypeSand, "exteriorDesert");
		setHardness(-1);
	}
}