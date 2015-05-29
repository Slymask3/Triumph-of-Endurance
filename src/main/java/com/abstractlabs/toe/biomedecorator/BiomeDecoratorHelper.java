package com.abstractlabs.toe.biomedecorator;

import com.abstractlabs.toe.biome.BiomeHollows;
import com.abstractlabs.toe.init.ToeBiomes;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;

public class BiomeDecoratorHelper 
{
	private static WorldGenerator bedRock;

	public BiomeDecoratorHelper()
	{
		//bedRock = new WorldGenMinable(Blocks.glowstone, 30, Blockss.lightStone);
	}

	protected static void decorateBiome(BiomeGenBase biome) 
	{
		MinecraftForge.EVENT_BUS.post(new DecorateBiomeEvent.Pre(BiomeDecoratorToe.currentWorld, BiomeDecoratorToe.randomGenerator, BiomeDecoratorToe.chunk_X, BiomeDecoratorToe.chunk_Z));
		//perpere ores for generation
		initOres();
		//GenerateOres
		generateOreInBiome(biome);

		if (biome == ToeBiomes.biomeHollows)
		{
			BiomeDecoratorToe.howMenyTrees = BiomeHollows.treesPerChunk;
			int i = BiomeDecoratorToe.howMenyTrees;
			/** Chunk Postions **/
			int chunkX;
			int chunkZ;
			int y;
			/** get blocks at the given locations **/
			Block block;
			Block blockA;
			/** Generates Small tree **/
			for (int a = 0; a < i; ++a)
			{
				if (i == BiomeDecoratorToe.randomGenerator.nextInt(8))
				{
					chunkX = BiomeDecoratorToe.chunk_X + BiomeDecoratorToe.randomGenerator.nextInt(16) + 8;
					chunkZ = BiomeDecoratorToe.chunk_Z + BiomeDecoratorToe.randomGenerator.nextInt(16) + 8;
					y = BiomeDecoratorToe.currentWorld.getTopSolidOrLiquidBlock(chunkX, chunkZ);
					block = BiomeDecoratorToe.currentWorld.getBlock(chunkX, y, chunkZ);
					blockA = BiomeDecoratorToe.currentWorld.getBlock(chunkX, y - 1, chunkZ);
					if (block != Blocks.air || block != Blocks.water)
					{
						if(blockA != Blocks.air || blockA != Blocks.water)
						{
							//BiomeDecoratorToe.smallTree.generate(BiomeDecoratorToe.currentWorld, BiomeDecoratorToe.randomGenerator, chunkX, y, chunkZ);
						}
					}
				}
				/** Generates Big tree **/
				if (i == BiomeDecoratorToe.randomGenerator.nextInt(15))
				{
					chunkX = BiomeDecoratorToe.chunk_X + BiomeDecoratorToe.randomGenerator.nextInt(16) + 8;
					chunkZ = BiomeDecoratorToe.chunk_Z + BiomeDecoratorToe.randomGenerator.nextInt(16) + 8;
					y = BiomeDecoratorToe.currentWorld.getTopSolidOrLiquidBlock(chunkX, chunkZ);
					block = BiomeDecoratorToe.currentWorld.getBlock(chunkX, y, chunkZ);
					blockA = BiomeDecoratorToe.currentWorld.getBlock(chunkX, y - 1, chunkZ);
					if (block != Blocks.air || block != Blocks.water)
					{
						if (blockA != Blocks.air || blockA != Blocks.water)
						{
							//BiomeDecoratorToe.bigTree.generate(BiomeDecoratorToe.currentWorld, BiomeDecoratorToe.randomGenerator, chunkX, y, chunkZ);
						}
					}
				}
			}
			// if(biome == ToeBiomes.something){
			//GENERARTE DARK FOREST STUFF HERE 
			//}
		}
	}

	/**
	 * Prepare ores for generation
	 */
	private static void initOres() 
	{
		//glowstone used for testing generation
		bedRock = new WorldGenMinable(Blocks.redstone_ore, 30, Blocks.redstone_ore);
	}

	/**
	 * Geberate Ores In a Biome
	 * @param biome
	 */
	private static void generateOreInBiome(BiomeGenBase biome)
	{
		if(biome == ToeBiomes.biomeHollows)
		{
			genStandardOre(20, bedRock, 0, 128);
		}
	}

	/**
	 * Generate ores in chunks.
	 * @param spawnWeight
	 * @param generatorToSpawn
	 * @param minSpawnHeight
	 * @param maxYSpawnHeight
	 */
	private static void genStandardOre(int spawnWeight, WorldGenerator generatorToSpawn, int minSpawnHeight, int maxYSpawnHeight) 
	{
		for (int l = 0; l < spawnWeight; ++l) 
		{
			int i1 = BiomeDecoratorToe.chunk_X + BiomeDecoratorToe.randomGenerator.nextInt(16);
			int j1 = BiomeDecoratorToe.randomGenerator.nextInt(maxYSpawnHeight - minSpawnHeight) + minSpawnHeight;
			int k1 = BiomeDecoratorToe.chunk_Z + BiomeDecoratorToe.randomGenerator.nextInt(16);
			generatorToSpawn.generate(BiomeDecoratorToe.currentWorld, BiomeDecoratorToe.randomGenerator, i1, j1, k1);
		}
	}
}
