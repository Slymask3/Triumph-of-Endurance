package com.abstractlabs.toe.worldgen;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenerator;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldGeneratorToe implements IWorldGenerator  {
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch (world.provider.dimensionId) {
	    	case -1: generateNether(world, random, chunkX*16, chunkZ*16);
	    	case 0: generateSurface(world, random, chunkX*16, chunkZ*16);
		}
	}

	private void generateSurface(World world, Random random, int blockX, int blockZ) {
		generateArena(world, random, blockX + random.nextInt(16), random.nextInt(60), blockZ + random.nextInt(16), new WorldGenArenaDesert(), 200); //500
		//generateArena(world, random, blockX + random.nextInt(16), random.nextInt(60), blockZ + random.nextInt(16), new WorldGenArenaUnderwater(), 300);
	}
	
	private void generateNether(World world, Random random, int blockX, int blockZ) {
		//todo nether domes
	}
	
	private void generateArena(World world, Random random, int x, int y, int z, WorldGenerator gen, int rarity) {
		if(random.nextInt(rarity) == 0) {
			gen.generate(world, random, x, y, z);
		}
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
}