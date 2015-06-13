package com.abstractlabs.toe.world.structure;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

import com.abstractlabs.toe.init.ToeBlocks;
import com.abstractlabs.toe.utility.BuildHelper;

public class ArenaPyramid {
	public static void build(World world, int x, int y, int z, Block main, int mainMeta, Block floor, int floorMeta, Block bedrock, int bedrockMeta, int size) {
		buildPyramid(world, x, y, z, main, mainMeta, size);
        buildPyramidInterior(world, x, y, z, floor, floorMeta, bedrock, bedrockMeta, size);
	}
	
	private static void buildPyramid(World world, int x, int y, int z, Block block, int meta, int size) {
		BuildHelper.buildHR(world, x, y-1, z, block, meta, size);
		BuildHelper.buildHR(world, x, y-2, z, block, meta, size);
		BuildHelper.buildHR(world, x, y-3, z, block, meta, size);
		BuildHelper.buildHR(world, x, y-4, z, block, meta, size);
		BuildHelper.buildHR(world, x, y-5, z, block, meta, size);
		
		BuildHelper.build(world, x-(size/2), y-6, z-(size/2), block, meta, size, 1, size);
		
		while(size >= 1) {
			BuildHelper.buildHR(world, x, y, z, block, size);
			size -= 2;
			y += 1;
		}
	}
	
	private static void buildPyramidInterior(World world, int x, int y, int z, Block floor, int floorMeta, Block bedrock, int bedrockMeta, int size) {
		BuildHelper.buildR(world, x, y-1, z, floor, floorMeta, size-2);
		BuildHelper.buildR(world, x, y-2, z, floor, floorMeta, size-2);
		BuildHelper.buildR(world, x, y-3, z, floor, floorMeta, size-2);
		BuildHelper.buildR(world, x, y-4, z, floor, floorMeta, size-2);
		BuildHelper.buildR(world, x, y-5, z, bedrock, bedrockMeta, size-2);
		
		//cleanInsidePyramidFromTop(world, x, y, z, size-2);

		world.setBlock(x, y+34, z, ToeBlocks.entranceDesert);
	}
	
	private static void cleanInsidePyramid(World world, int x, int y, int z, int size) {
		while(size > 0) {
			BuildHelper.buildRIfNotAir(world, x, y, z, Blocks.air, size);
			size -= 2;
			y += 1;
		}
	}
	
	private static void cleanInsidePyramidFromTop(World world, int x, int y, int z, int size) {
		size = 1;
		y += 33;
		
		while(size != 69) {
			BuildHelper.buildRIfNotAir(world, x, y, z, Blocks.air, size);
			size += 2;
			y -= 1;
		}
	}
}