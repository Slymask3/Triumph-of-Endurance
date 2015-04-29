package com.abstractlabs.toe.init;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import com.abstractlabs.toe.block.BlockExterior;
import com.abstractlabs.toe.reference.Reference;

import cpw.mods.fml.common.registry.GameRegistry;

public class ToeBlocks {
	public static Block exteriorDesert = new BlockExterior(Material.rock, Block.soundTypeSand, "exteriorDesert");
	
	public static void init() {
		GameRegistry.registerBlock(exteriorDesert, Reference.MOD_ID + ":exteriorDesert");
	}
}