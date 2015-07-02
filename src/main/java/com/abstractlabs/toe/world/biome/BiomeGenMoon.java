package com.abstractlabs.toe.world.biome;

import java.awt.Color;

import net.minecraft.world.biome.BiomeGenBase;

import com.abstractlabs.toe.entity.monster.EntityAlien;
import com.abstractlabs.toe.entity.passive.EntityAlienCow;
import com.abstractlabs.toe.init.ToeBlocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BiomeGenMoon extends BiomeGenBase {
	public BiomeGenMoon(int id) {
		super(id);
		
		this.spawnableMonsterList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
        this.spawnableCaveCreatureList.clear();

		this.spawnableCreatureList.add(new SpawnListEntry(EntityAlienCow.class, 8, 3, 6));
		this.spawnableCreatureList.add(new SpawnListEntry(EntityAlien.class, 5, 3, 4));
		//this.spawnableCaveCreatureList.add(new SpawnListEntry(EntityAlien.class, 100, 1, 2));
		
		this.theBiomeDecorator = new BiomeDecoratorMoon();
		
		this.topBlock = ToeBlocks.moonRock;
		this.fillerBlock = ToeBlocks.moonRock;
		
		this.setDisableRain();
		this.setColor(Color.DARK_GRAY.getRGB());
	}
	
	@SideOnly(Side.CLIENT)
    public int getSkyColorByTemp(float par1) {
        return Color.DARK_GRAY.getRGB();
    }
	
//	@Override
//	public void genTerrainBlocks(World world, Random rand, Block[] blocks, byte[] bytes, int par5, int par6, double par7) {
//		boolean flag = true;
//        Block block = ToeBlocks.moonRock;
//        byte b0 = (byte)(this.field_150604_aj & 255);
//        //Block block1 = this.fillerBlock;
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
//                    if (block2 == this.fillerBlock)
//                    {
//                        if (k == -1)
//                        {
//                            if (l <= 0)
//                            {
//                                block = null;
//                                b0 = 0;
//                                block = ToeBlocks.moonRock;
//                            }
//                            else if (l1 >= 59 && l1 <= 64)
//                            {
//                                block = this.topBlock;
//                                b0 = (byte)(this.field_150604_aj & 255);
//                                block = ToeBlocks.moonRock;
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
//                                    block = Blocks.water;
//                                    b0 = 0;
//                                }
//                            }
//
//                            k = l;
//
//                            if (l1 >= 62)
//                            {
//                                blocks[i2] = block;
//                                bytes[i2] = b0;
//                            }
//                            else if (l1 < 56 - l)
//                            {
//                                block = null;
//                                block = ToeBlocks.moonRock;
//                                blocks[i2] = Blocks.gravel;
//                            }
//                            else
//                            {
//                                blocks[i2] = block;
//                            }
//                        }
//                        else if (k > 0)
//                        {
//                            --k;
//                            blocks[i2] = block;
//
//                            if (k == 0 && block == Blocks.sand)
//                            {
//                                k = rand.nextInt(4) + Math.max(0, l1 - 63);
//                                block = Blocks.sandstone;
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
//    }
}