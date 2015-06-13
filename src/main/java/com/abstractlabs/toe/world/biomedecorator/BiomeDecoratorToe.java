package com.abstractlabs.toe.world.biomedecorator;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;

import com.abstractlabs.toe.world.gen.structure.WorldGenEffectTree;
import com.abstractlabs.toe.world.gen.structure.WorldGenForestHollowTree;

public class BiomeDecoratorToe extends BiomeDecorator
{
	/** The world the BiomeDecorator is currently decorating */
	public static World currentWorld;
	/** The Biome Decorator's random number generator. */
	public static Random randomGenerator;
	/** The X-coordinate of the chunk currently being decorated */
	public static int chunk_X;
	/** The Z-coordinate of the chunk currently being decorated */
	public static int chunk_Z;
	/** True if decorator should generate surface lava & water */
	public static boolean generateLakes;
	/** How meny trees per chunk, set in each biome class **/
	public static int howMenyTrees;

	/** Dimension Trees **/
	//public static WorldGenForestTrees smallTree;
	public static WorldGenForestHollowTree hollowTree;
	public static WorldGenEffectTree effectTree;

	@SuppressWarnings("unused")
	private static final String __OBFID = "CL_00000164";

	public BiomeDecoratorToe() 
	{
		// TREES
		//smallTree = new WorldGenForestTrees(true);
		hollowTree = new WorldGenForestHollowTree(true);
		effectTree = new WorldGenEffectTree(true);

		// generates lakes and lava lakes in dimension.
		generateLakes = true;
	}

	public void decorateChunk(World world, Random random, BiomeGenBase biomeGenBase, int chunkX, int chunkZ) 
	{
		if (currentWorld != null) 
		{
			throw new RuntimeException("Already decorating!!");
		} 
		else 
		{
			currentWorld = world;
			randomGenerator = random;
			chunk_X = chunkX;
			chunk_Z = chunkZ;
			genDecorationsForBiome(biomeGenBase);
			currentWorld = null;
			randomGenerator = null;
		}
	}

	/**
	 * Decorate's biome.
	 * 
	 * @param biome
	 */
	protected void genDecorationsForBiome(BiomeGenBase biome) 
	{
		BiomeDecoratorHelper.decorateBiome(biome);
	}
}

