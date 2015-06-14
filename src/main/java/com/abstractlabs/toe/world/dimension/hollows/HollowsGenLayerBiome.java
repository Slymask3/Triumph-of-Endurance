package com.abstractlabs.toe.world.dimension.hollows;

import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

import com.abstractlabs.toe.init.ToeGenBiome;

public class HollowsGenLayerBiome extends GenLayer 
{
	private BiomeGenBase[] field_151623_c;
	// TODO: spawning with temperatures
	protected BiomeGenBase[] allowedBiomes = {ToeGenBiome.biomeHollows,};

	public HollowsGenLayerBiome(long seed) 
	{
		super(seed);
	}

	public HollowsGenLayerBiome(long seed, GenLayer genlayer, WorldType type) 
	{
		super(seed);
		this.parent = genlayer;
		if (type == WorldType.DEFAULT_1_1)
		{
			this.field_151623_c = new BiomeGenBase[] {BiomeGenBase.desert, BiomeGenBase.forest, BiomeGenBase.extremeHills, BiomeGenBase.swampland, BiomeGenBase.plains, BiomeGenBase.taiga, ToeGenBiome.biomeHollows};
		}
	}

	@Override
	public int[] getInts(int x, int z, int width, int depth) 
	{
		int[] dest = IntCache.getIntCache(width * depth);
		for (int dz = 0; dz < depth; dz++)
		{
			for (int dx = 0; dx < width; dx++) 
			{
				this.initChunkSeed(dx + x, dz + z);
				dest[(dx + dz * width)] = this.allowedBiomes[nextInt(this.allowedBiomes.length)].biomeID;
			}
		}
		return dest;
	}
}
