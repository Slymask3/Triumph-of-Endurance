package com.abstractlabs.toe.worldgen;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldGeneratorToe implements IWorldGenerator  {
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		int gen = random.nextInt(100);
		
		if (gen == 0) {
			switch (world.provider.dimensionId) {
		    	case -1: generateNether(world, random, chunkX*16, chunkZ*16);
		    	case 0: generateSurface(world, random, chunkX*16, chunkZ*16);
			}
		}
	}

	private void generateSurface(World world, Random random, int blockX, int blockZ) {
		int x = blockX + random.nextInt(16);
		int y = random.nextInt(60);
		int z = blockZ + random.nextInt(16);
		  
		(new WorldGenArenaDesert()).generate(world, random, x, y, z);
	}
	
	private void generateNether(World world, Random random, int blockX, int blockZ) {
		//todo nether domes
	}

}