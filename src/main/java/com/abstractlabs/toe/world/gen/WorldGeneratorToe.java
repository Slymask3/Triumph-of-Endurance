package com.abstractlabs.toe.world.gen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;

import com.abstractlabs.toe.init.ToeBlocks;
import com.abstractlabs.toe.world.gen.structure.WorldGenUFO;

import cpw.mods.fml.common.IWorldGenerator;

public class WorldGeneratorToe implements IWorldGenerator  {
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch (world.provider.dimensionId) {
	    	case -1: generateNether(world, random, chunkX*16, chunkZ*16);
	    	case 0: generateSurface(world, random, chunkX*16, chunkZ*16);
	    	case 1: generateEnd(world, random, chunkX*16, chunkZ*16);
	    	case 8: generateHollows(world, random, chunkX*16, chunkZ*16);
	    	case 9: generateCallisto(world, random, chunkX*16, chunkZ*16);
		}
	}
	
	private void generateNether(World world, Random random, int x, int z) {
		
	}

	private void generateSurface(World world, Random random, int x, int z) {
		generateStructure(world, random, x + random.nextInt(16), random.nextInt(60), z + random.nextInt(16), new WorldGenUFO(), 300);
		generateOre(ToeBlocks.randomOre, world, random, x, z, 16, 16, randomIntBetween(random, 4, 10), 5, 5, 50);
		generateOre(ToeBlocks.rubyOre, world, random, x, z, 16, 16, randomIntBetween(random, 2, 6), 4, 5, 30);
		generateOre(ToeBlocks.sapphireOre, world, random, x, z, 16, 16, randomIntBetween(random, 2, 6), 4, 5, 30);
		generateOre(ToeBlocks.coinCopperOre, world, random, x, z, 16, 16, randomIntBetween(random, 4, 14), 4, 5, 60);
		generateOre(ToeBlocks.coinSilverOre, world, random, x, z, 16, 16, randomIntBetween(random, 1, 3), 4, 5, 40);
		generateOre(ToeBlocks.coinGoldOre, world, random, x, z, 16, 16, randomIntBetween(random, 1, 2), 4, 5, 20);
	}
	
	private void generateEnd(World world, Random random, int x, int z) {
		
	}
	
	private void generateHollows(World world, Random random, int x, int z) {
		
	}
	
	private void generateCallisto(World world, Random random, int x, int z) {
		
	}

//	private void generateHollows(World world, Random random, int chunkX, int chunkZ)
//	{
//		/*
//		for(int i = 0; i < 20; i++)
//		{
//			int Xcoord1 = chunkX + random.nextInt(16);
//			int Ycoord1 = random.nextInt(90);
//			int Zcoord1 = chunkZ + random.nextInt(16);
//
//			(new WorldGenForestHollowTree(false, 7, 0, 0, false)).generate(world, random, Xcoord1, Ycoord1, Zcoord1);
//		}
//		*/
//	}

	private void generateStructure(World world, Random random, int x, int y, int z, WorldGenerator gen, int rarity) {
		if(random.nextInt(rarity) == 0) {
			gen.generate(world, random, x, y, z);
		}
	}

	private void generateArena(World world, Random random, int x, int y, int z, WorldGenerator gen, int rarity) {
		if(random.nextInt(rarity) == 0) {
			gen.generate(world, random, x, y, z);
		}
	}
	
	/**
	* @param block to spawn
	* @param world to spawn in
	* @param random for retrieving random positions within the world to spawn the Block
	* @param blockXPos for passing the X-Coordinate for the Generation method
	* @param blockZPos for passing the Z-Coordinate for the Generation method
	* @param maxX for setting the maximum X-Coordinate values for spawning on the X-Axis on a Per-Chunk basis
	* @param maxZ for setting the maximum Z-Coordinate values for spawning on the Z-Axis on a Per-Chunk basis
	* @param maxVeinSize for setting the maximum size of a vein
	* @param chancesToSpawn for the Number of chances available for the Block to spawn per-chunk
	* @param minY for the minimum Y-Coordinate height at which this block may spawn
	* @param maxY for the maximum Y-Coordinate height at which this block may spawn
	**/
	private void generateOre(Block block, World world, Random rand, int blockXPos, int blockZPos, int maxX, int maxZ, int maxVeinSize, int chancesToSpawn, int minY, int maxY) {
		assert maxY > minY : "The maximum Y must be greater than the Minimum Y";
		assert maxX > 0 && maxX <= 16 : "addOreSpawn: The Maximum X must be greater than 0 and less than 16";
		assert minY > 0 : "addOreSpawn: The Minimum Y must be greater than 0";
		assert maxY < 256 && maxY > 0 : "addOreSpawn: The Maximum Y must be less than 256 but greater than 0";
		assert maxZ > 0 && maxZ <= 16 : "addOreSpawn: The Maximum Z must be greater than 0 and less than 16";
	 
		int diffBtwnMinMaxY = maxY - minY;
		for (int x = 0; x < chancesToSpawn; x++) {
			int posX = blockXPos + rand.nextInt(maxX);
			int posY = minY + rand.nextInt(diffBtwnMinMaxY);
			int posZ = blockZPos + rand.nextInt(maxZ);
			(new WorldGenMinable(block, maxVeinSize)).generate(world, rand, posX, posY, posZ);
		}
	}
	
	private int randomIntBetween(Random random, int min, int max) {
		return random.nextInt((max-min)+1)+min;
	}
}