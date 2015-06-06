package com.abstractlabs.toe.worldgen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;

import com.abstractlabs.toe.init.ToeBlocks;

import cpw.mods.fml.common.IWorldGenerator;

public class WorldGeneratorToe implements IWorldGenerator  {
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch (world.provider.dimensionId) {
	    	case -1: generateNether(world, random, chunkX*16, chunkZ*16);
	    	case 0: generateSurface(world, random, chunkX*16, chunkZ*16);
	    	case 1: generateEnd(world, random, chunkX*16, chunkZ*16);
	    	case 8: generateHollows(world, random, chunkX*16, chunkZ*16);
	    	case 9: generateArenalism(world, random, chunkX*16, chunkZ*16);
		}
	}
	
	private void generateNether(World world, Random random, int x, int z) {
		
	}

	private void generateSurface(World world, Random random, int x, int z) {
		generateStructure(world, random, x + random.nextInt(16), random.nextInt(60), z + random.nextInt(16), new WorldGenUFO(), 300);
		generateOre(ToeBlocks.randomOre, world, random, x, z, 16, 16, 4 + random.nextInt(3), 5, 5, 50);
	}
	
	private void generateEnd(World world, Random random, int x, int z) {
		
	}
	
	private void generateHollows(World world, Random random, int x, int z) {
		
	}
	
	private void generateArenalism(World world, Random random, int x, int z) {
		
	}

	/*
	private void generateHollows(World world, Random random, int chunkX, int chunkZ)
	{
		// the 4 below is for how rare it will be
		for(int i = 0; i < 4; i++)
		{
			//this below just tells me if its generating or not
			System.out.println("Generating Leaf in the dimension");

			int xCoord = chunkX + random.nextInt(16);
			int yCoord = random.nextInt(128);// the 128 is the max height the ore/block will generate
			int zCoord = chunkZ + random.nextInt(16);

			//The 230 on the line below is how meny will generate per vain, as an example i think diamond is like 2 or 4
			//and the Block.blockIron is what it will spawn
			(new WorldGenMinableHollows(Blocks.bedrock, 20)).generate(world, random, xCoord, yCoord, zCoord);
		}
	}
	*/
	
	private void generateStructure(World world, Random random, int x, int y, int z, WorldGenerator gen, int rarity) {
		if(random.nextInt(rarity) == 0) {
			gen.generate(world, random, x, y, z);
		}
	}
	
	/**
	* @param The Block to spawn
	* @param The World to spawn in
	* @param A Random object for retrieving random positions within the world to spawn the Block
	* @param An int for passing the X-Coordinate for the Generation method
	* @param An int for passing the Z-Coordinate for the Generation method
	* @param An int for setting the maximum X-Coordinate values for spawning on the X-Axis on a Per-Chunk basis
	* @param An int for setting the maximum Z-Coordinate values for spawning on the Z-Axis on a Per-Chunk basis
	* @param An int for setting the maximum size of a vein
	* @param An int for the Number of chances available for the Block to spawn per-chunk
	* @param An int for the minimum Y-Coordinate height at which this block may spawn
	* @param An int for the maximum Y-Coordinate height at which this block may spawn
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
}