package com.abstractlabs.toe.world.biome;

import java.awt.Color;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.monster.EntitySnowman;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BiomeGenNeptune extends BiomeGenBase {
	public BiomeGenNeptune(int id) {
		super(id);
		
		this.spawnableMonsterList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
        this.spawnableCaveCreatureList.clear();

		this.spawnableCreatureList.add(new SpawnListEntry(EntitySnowman.class, 8, 3, 6));
		//this.spawnableCreatureList.add(new SpawnListEntry(EntityAlien.class, 5, 3, 4));
		//this.spawnableCaveCreatureList.add(new SpawnListEntry(EntityAlien.class, 100, 1, 2));
		
		this.theBiomeDecorator = new BiomeDecoratorNeptune();
		
		this.topBlock = Blocks.ice;
		this.fillerBlock = Blocks.ice;
		
		this.setEnableSnow();
		
		//this.setDisableRain();
		this.setColor(Color.BLUE.getRGB());
	}
	
	@SideOnly(Side.CLIENT)
    public int getSkyColorByTemp(float par1) {
        return Color.BLUE.getRGB();
    }
	
	public void genTerrainBlocks(World world, Random random, Block[] blocks, byte[] bytes, int par5, int par6, double par7) {
		boolean flag = true;
        Block block = this.topBlock;
        byte b0 = (byte)(this.field_150604_aj & 255);
        Block block1 = this.fillerBlock;
        int k = -1;
        int l = (int)(par7 / 3.0D + 3.0D + random.nextDouble() * 0.25D);
        int i1 = par5 & 15;
        int j1 = par6 & 15;
        int k1 = blocks.length / 256;

        for (int l1 = 255; l1 >= 0; --l1)
        {
            int i2 = (j1 * 16 + i1) * k1 + l1;

            if (l1 <= 0 + random.nextInt(5))
            {
                blocks[i2] = Blocks.bedrock;
            }
            else
            {
                Block block2 = blocks[i2];

                if (block2 != null && block2.getMaterial() != Material.air)
                {
                    if (block2 == Blocks.packed_ice)
                    {
                        if (k == -1)
                        {
                            if (l <= 0)
                            {
                                block = null;
                                b0 = 0;
                                block1 = Blocks.packed_ice;
                            }
                            else if (l1 >= 59 && l1 <= 64)
                            {
                                block = this.topBlock;
                                b0 = (byte)(this.field_150604_aj & 255);
                                block1 = this.fillerBlock;
                            }

                            if (l1 < 63 && (block == null || block.getMaterial() == Material.air))
                            {
                                if (this.getFloatTemperature(par5, l1, par6) < 0.15F)
                                {
                                    block = Blocks.packed_ice;
                                    b0 = 0;
                                }
                                else
                                {
                                    block = Blocks.water;
                                    b0 = 0;
                                }
                            }

                            k = l;

                            if (l1 >= 62)
                            {
                                blocks[i2] = block;
                                bytes[i2] = b0;
                            }
                            else if (l1 < 56 - l)
                            {
                                block = null;
                                block1 = Blocks.packed_ice;
                                blocks[i2] = Blocks.gravel;
                            }
                            else
                            {
                                blocks[i2] = block1;
                            }
                        }
                        else if (k > 0)
                        {
                            --k;
                            blocks[i2] = block1;

                            if (k == 0 && block1 == Blocks.sand)
                            {
                                k = random.nextInt(4) + Math.max(0, l1 - 63);
                                block1 = Blocks.sandstone;
                            }
                        }
                    }
                }
                else
                {
                    k = -1;
                }
            }
        }
    }
}