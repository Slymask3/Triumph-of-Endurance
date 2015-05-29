package com.abstractlabs.toe.biome;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenOcean;

import com.abstractlabs.toe.biomedecorator.BiomeDecoratorToe;

public class BiomeFlat extends BiomeGenOcean
{
	//public static int treesPerChunk;

	//protected BiomeDecoratorToe decorator;

	public BiomeFlat(int biomeId) 
	{
		super(biomeId);
		//BiomeFlat.treesPerChunk = 2;
		this.topBlock = Blocks.air;
		this.fillerBlock = Blocks.air;
	}

//	/**
//	* Gets a WorldGen appropriate for this biome.
//	*/
//	public WorldGenerator getRandomWorldGenForGrass(Random random)
//	{
//		return new WorldGenTallGrass(Blocks.tallgrass, 1);
//	}
	
	//public void genTerrainBlocks(World world, Random rand, Block[] blocks, byte[] par4, int par5, int par6, double par7)
	//public final void genBiomeTerrain(World p_150560_1_, Random p_150560_2_, Block[] p_150560_3_, byte[] p_150560_4_, int p_150560_5_, int p_150560_6_, double p_150560_7_)
	//public final void generateTerrainForBiome(World p_150560_1_, Random p_150560_2_, Block[] p_150560_3_, byte[] p_150560_4_, int p_150560_5_, int p_150560_6_, double p_150560_7_)
    //{
		//LogHelper.info("genTerrainBlocks");

//		for(int i=0; i<10; i++) {
//			blocks[i] = Blocks.iron_block;
//			blocks[i+20] = Blocks.gold_block;
//			blocks[i+40] = Blocks.diamond_block;
//			blocks[i+60] = Blocks.redstone_block;
//			blocks[i+80] = Blocks.lapis_block;
//			blocks[i+100] = Blocks.brick_block;
//			blocks[i+120] = Blocks.cobblestone;
//			blocks[i+140] = Blocks.coal_block;
//			blocks[i+160] = Blocks.bookshelf;
//			blocks[i+180] = Blocks.melon_block;
//			blocks[i+200] = Blocks.crafting_table;
//			blocks[i+220] = Blocks.diamond_ore;
//			blocks[i+240] = Blocks.emerald_block;
//			blocks[i+260] = Blocks.hay_block;
//			blocks[i+280] = Blocks.gold_ore;
//		}
		
//		for(int i=0; i<blocks.length; i+=256) {
//			blocks[i] = Blocks.bedrock;
//			for(int k=1; k<60; k++) {
//				blocks[i+k] = Blocks.gold_block;
//			}
//			for(int j=60; j<256; j++) {
//				blocks[i+j] = Blocks.air;
//			}
//		}
		
		//LogHelper.info("par5 == " + par5 + " | par6 == " + par6 + " | par7 == " + par7);
		
		//for(int i=0; i<blocks.length; i=i+2) {
		//	blocks[i] = Blocks.brick_block;
			//LogHelper.info("blocks.length == " + blocks.length + " | i == " + i);
		//}
		
//        boolean flag = true;
//        Block block = this.topBlock;
//        byte b0 = (byte)(this.field_150604_aj & 255);
//        Block block1 = this.fillerBlock;
//        int k = -1;
//        int l = (int)(par7 / 3.0D + 3.0D + rand.nextDouble() * 0.25D);
//        int i1 = par5 & 15;
//        int j1 = par6 & 15;
//        int k1 = blocks.length / 256;
//
//        for (int l1 = 255; l1 >= 0; --l1)
//        {
//            int i2 = (j1 * 16 + i1) * k1 + l1;
//
//            if (l1 <= 0 + rand.nextInt(5))
//            {
//                blocks[i2] = Blocks.bedrock;
//            }
//            else
//            {
//                Block block2 = blocks[i2];
//
//                if (block2 != null && block2.getMaterial() != Material.air)
//                {
//                    if (block2 == Blocks.grass)
//                    {
//                        if (k == -1)
//                        {
//                            if (l <= 0)
//                            {
//                                block = null;
//                                b0 = 0;
//                                block1 = Blocks.grass;
//                            }
//                            else if (l1 >= 59 && l1 <= 64)
//                            {
//                                block = this.topBlock;
//                                b0 = (byte)(this.field_150604_aj & 255);
//                                block1 = this.fillerBlock;
//                            }
//
//                            if (l1 < 63 && (block == null || block.getMaterial() == Material.air))
//                            {
//                                if (this.getFloatTemperature(par5, l1, par6) < 0.15F)
//                                {
//                                    block = Blocks.ice;
//                                    b0 = 0;
//                                }
//                                else
//                                {
//                                    block = Blocks.ice;
//                                    b0 = 0;
//                                }
//                            }
//
//                            k = l;
//
//                            if (l1 >= 62)
//                            {
//                                blocks[i2] = block;
//                                par4[i2] = b0;
//                            }
//                            else if (l1 < 56 - l)
//                            {
//                                block = null;
//                                block1 = Blocks.grass;
//                                blocks[i2] = Blocks.gravel;
//                            }
//                            else
//                            {
//                                blocks[i2] = block1;
//                            }
//                        }
//                        else if (k > 0)
//                        {
//                            --k;
//                            blocks[i2] = block1;
//
//                            if (k == 0 && block1 == Blocks.sand)
//                            {
//                                k = rand.nextInt(4) + Math.max(0, l1 - 63);
//                                block1 = Blocks.sandstone;
//                            }
//                        }
//                    }
//                }
//                else
//                {
//                    k = -1;
//                }
//            }
//        }
   // }
}
