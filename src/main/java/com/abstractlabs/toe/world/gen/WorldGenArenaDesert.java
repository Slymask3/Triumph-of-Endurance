package com.abstractlabs.toe.world.gen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import com.abstractlabs.toe.init.ToeBlocks;
import com.abstractlabs.toe.utility.BuildHelper;
import com.abstractlabs.toe.utility.LogHelper;

public class WorldGenArenaDesert extends WorldGenerator {
	public static int arenaSize = 69;
	
	@Override
	public boolean generate(World world, Random rand, int x, int y, int z) {
		y = BuildHelper.positionYOnTheFloor(world, x, y, z);
		
		//if(/*world.getBlock(x, y-1, z) != Blocks.sand && */world.getBiomeGenForCoords(x, z) != BiomeGenBase.desert) {
			//LogHelper.info("Did not generate in biome: " + world.getBiomeGenForCoords(x, z).toString());
		//	return false;
		//}
		
		if(BuildHelper.isBlockNear(world, x, y, z, arenaSize, ToeBlocks.exteriorDesert)) {
        	LogHelper.info("Generation cancelled because another desert arena is near.");
			return false;
		}
		
		/*if(isBlockNear2(world, x-(arenaSize/2), y-5, z-(arenaSize/2), Blocks.air, arenaSize, 1, arenaSize)) {
        	LogHelper.info("Generation cancelled because found air blocks.");
			return false;
		}
		
		//if(isBlockNear(world, x, y, z, arenaSize/2, Blocks.dirt)) {
        //	LogHelper.info("Generation cancelled because found dirt blocks.");
		//	return false;
		//}
		
		if(isBlockNear(world, x, y, z, arenaSize/2, Blocks.grass)) {
        	LogHelper.info("Generation cancelled because found grass blocks.");
			return false;
		}*/
        
        buildPyramid(world, x, y, z, ToeBlocks.exteriorDesert, arenaSize);
        
        buildPyramidInterior(world, x, y, z, arenaSize);
        
        LogHelper.info("Desert Arena Generated at [" + x + ", " + y + ", " + z + "]");
        
        return true;
	}
	
	public void buildPyramidInterior(World world, int x, int y, int z, int size) {
		BuildHelper.buildR(world, x, y-1, z, Blocks.sand, size-2);
		BuildHelper.buildR(world, x, y-2, z, Blocks.sand, size-2);
		BuildHelper.buildR(world, x, y-3, z, Blocks.sand, size-2);
		BuildHelper.buildR(world, x, y-4, z, Blocks.sand, size-2);
		BuildHelper.buildR(world, x, y-5, z, Blocks.sandstone, size-2);
		
		cleanInsidePyramidFromTop(world, x, y, z, size-2);

		world.setBlock(x, y+34, z, ToeBlocks.entranceDesert);
	}
	
	private void cleanInsidePyramid(World world, int x, int y, int z, int size) {
		while(size > 0) {
			BuildHelper.buildRIfNotAir(world, x, y, z, Blocks.air, size);
			size -= 2;
			y += 1;
		}
	}
	
	private void cleanInsidePyramidFromTop(World world, int x, int y, int z, int size) {
		size = 1;
		y += 33;
		
		while(size != 69) {
			BuildHelper.buildRIfNotAir(world, x, y, z, Blocks.air, size);
			size += 2;
			y -= 1;
		}
	}
	
	private void buildPyramid(World world, int x, int y, int z, Block block, int size) {
		BuildHelper.buildHR(world, x, y-1, z, block, size);
		BuildHelper.buildHR(world, x, y-2, z, block, size);
		BuildHelper.buildHR(world, x, y-3, z, block, size);
		BuildHelper.buildHR(world, x, y-4, z, block, size);
		BuildHelper.buildHR(world, x, y-5, z, block, size);
		
		int newY = y - 6;
		
		while(BuildHelper.canBlocksSeeSkyHR(world, x-1, newY, z-1, size+2)) {
			BuildHelper.buildHR(world, x, newY, z, block, size);
			newY--;
			LogHelper.info("HR blocks can see the sky, adding layer newY = " + newY);
		}
		
		BuildHelper.build(world, x-(size/2), newY, z-(size/2), block, size, 1, size);
		
		while(size >= 1) {
			BuildHelper.buildHR(world, x, y, z, block, size);
			size -= 2;
			y += 1;
		}
	}
}