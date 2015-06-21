package com.abstractlabs.toe.world.biome;

import java.awt.Color;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenTallGrass;
import net.minecraft.world.gen.feature.WorldGenerator;

import com.abstractlabs.toe.init.ToeGenBiome;
import com.abstractlabs.toe.init.ToeBlocks;
import com.abstractlabs.toe.world.biomedecorator.BiomeDecoratorHollows;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BiomeHollows extends ToeGenBiome
{
	public static int treesPerChunk;

	protected BiomeDecoratorHollows decorator;

	public BiomeHollows(int biomeId) 
	{
		super(biomeId);
		this.topBlock = ToeBlocks.hollowGrass;
		this.fillerBlock = ToeBlocks.hollowDirt;
		this.waterColorMultiplier = 0x990000;
		
		this.spawnableMonsterList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
        this.spawnableCaveCreatureList.clear();
	}
	
	@SideOnly(Side.CLIENT)
    public int getSkyColorByTemp(float par1) 
	{
        return Color.DARK_GRAY.getRGB();
    }

//	/**
//	 * Gets a WorldGen appropriate for this biome.
//	 */
//	public WorldGenerator getRandomWorldGenForGrass(Random random)
//	{
//		return random.nextInt(2) == 0 ? new WorldGenTallGrass(Blocks.tallgrass, 1) : new WorldGenTallGrass(Blocks.tallgrass, 2);
//	}
//	
//	public final void generateTerrainForBiome(World p_150560_1_, Random p_150560_2_, Block[] p_150560_3_, byte[] p_150560_4_, int p_150560_5_, int p_150560_6_, double p_150560_7_)
//	{
//		boolean flag = true;
//		Block block = this.topBlock;
//		byte b0 = (byte)(this.field_150604_aj & 255);
//		Block block1 = this.fillerBlock;
//		int k = -1;
//		int l = (int)(p_150560_7_ / 3.0D + 3.0D + p_150560_2_.nextDouble() * 0.25D);
//		int i1 = p_150560_5_ & 15;
//		int j1 = p_150560_6_ & 15;
//		int k1 = p_150560_3_.length / 256;
//
//		for (int l1 = 255; l1 >= 0; --l1)
//		{
//			int i2 = (j1 * 16 + i1) * k1 + l1;
//
//			if (l1 <= 0 + p_150560_2_.nextInt(5))
//			{
//				p_150560_3_[i2] = Blocks.bedrock;
//			}
//			else
//			{
//				Block block2 = p_150560_3_[i2];
//
//				if (block2 != null && block2.getMaterial() != Material.air)
//				{
//					if (block2 == ToeBlocks.hollowGrass)
//					{
//						if (k == -1)
//						{
//							if (l <= 0)
//							{
//								block = null;
//								b0 = 0;
//								block1 = ToeBlocks.hollowDirt;
//							}
//							else if (l1 >= 59 && l1 <= 64)
//							{
//								block = this.topBlock;
//								b0 = (byte)(this.field_150604_aj & 255);
//								block1 = this.fillerBlock;
//							}
//
//							if (l1 < 63 && (block == null || block.getMaterial() == Material.air))
//							{
//								if (this.getFloatTemperature(p_150560_5_, l1, p_150560_6_) < 0.15F)
//								{
//									block = Blocks.ice;
//									b0 = 0;
//								}
//								else
//								{
//									block = Blocks.ice;
//									b0 = 0;
//								}
//							}
//
//							k = l;
//
//							if (l1 >= 62)
//							{
//								p_150560_3_[i2] = block;
//								p_150560_4_[i2] = b0;
//							}
//							else if (l1 < 56 - l)
//							{
//								block = null;
//								block1 = ToeBlocks.hollowDirt;
//								p_150560_3_[i2] = Blocks.gravel;
//							}
//							else
//							{
//								p_150560_3_[i2] = block1;
//							}
//						}
//						else if (k > 0)
//						{
//							--k;
//							p_150560_3_[i2] = block1;
//
//							if (k == 0 && block1 == Blocks.sand)
//							{
//								k = p_150560_2_.nextInt(4) + Math.max(0, l1 - 63);
//								block1 = Blocks.sandstone;
//							}
//						}
//					}
//				}
//				else
//				{
//					k = -1;
//				}
//			}
//		}
//	}
	
	
	
	 /**
     * Provides the basic grass color based on the biome temperature and rainfall
     */
	/*
	@Override
    @SideOnly(Side.CLIENT)
    public int getBiomeGrassColor(int p_150558_1_, int p_150558_2_, int p_150558_3_)
    {
        double d0 = (double)MathHelper.clamp_float(this.getFloatTemperature(p_150558_1_, p_150558_2_, p_150558_3_), 0.0F, 1.0F);
        double d1 = (double)MathHelper.clamp_float(this.getFloatRainfall(), 0.0F, 1.0F);
        return getModdedBiomeGrassColor(ColorizerGrass.getGrassColor(d0, d1));
    }
	*/
}
