package com.abstractlabs.toe.worldgen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;

import com.abstractlabs.toe.init.ToeBlocks;
import com.abstractlabs.toe.utility.LogHelper;

public class WorldGenArenaDesert extends WorldGenerator {
	public static int arenaSize = 69;
	
	@Override
	public boolean generate(World world, Random rand, int x, int y, int z) {
		while (!world.isAirBlock(x, y, z)) {
			y++;
        }
		
		while (world.isAirBlock(x, y-1, z)) {
			y--;
        }
		
		if(/*world.getBlock(x, y-1, z) != Blocks.sand && */world.getBiomeGenForCoords(x, z) != BiomeGenBase.desert) {
			//LogHelper.info("Did not generate in biome: " + world.getBiomeGenForCoords(x, z).toString());
			return false;
		}
		
		if(isBlockNear(world, x, y, z, arenaSize/2, ToeBlocks.exteriorDesert)) {
        	LogHelper.info("Generation cancelled because block is near.");
			return false;
		}
		
		if(isBlockNear2(world, x-(arenaSize/2), y-5, z-(arenaSize/2), Blocks.air, arenaSize, 1, arenaSize)) {
        	LogHelper.info("Generation cancelled because found air blocks.");
			return false;
		}

        world.setBlock(x, y, z, ToeBlocks.exteriorDesert);
        world.setBlock(x, y+1, z, ToeBlocks.exteriorDesert);
        world.setBlock(x, y+2, z, ToeBlocks.exteriorDesert);
        world.setBlock(x, y+3, z, ToeBlocks.exteriorDesert);
        world.setBlock(x, y+4, z, ToeBlocks.exteriorDesert);
        world.setBlock(x, y+5, z, ToeBlocks.exteriorDesert);
        world.setBlock(x, y+6, z, Blocks.glowstone);

        //buildHR(world, x, y, z, ToeBlocks.exteriorForest, 11);
        //buildHR(world, x, y, z, ToeBlocks.exteriorDesert, 15);
        
        buildPyramid(world, x, y, z, ToeBlocks.exteriorDesert, arenaSize);
        
        LogHelper.info("Generated at [" + x + ", " + y + ", " + z + "]");
        
        return true;
	}
	
	public void buildPyramid(World world, int x, int y, int z, Block block, int size) {
		buildHR(world, x, y-1, z, block, size);
		buildHR(world, x, y-2, z, block, size);
		buildHR(world, x, y-3, z, block, size);
		buildHR(world, x, y-4, z, block, size);
		buildHR(world, x, y-5, z, block, size);
		build(world, x-(size/2), y-6, z-(size/2), block, size, 1, size);
		
		while(size >= 1) {
			buildHR(world, x, y, z, block, size);
			size -= 2;
			y += 1;
		}
	}
	
	public void buildHR(World world, int x, int y, int z, Block block, int size) {
		int x2 = x - (size/2);
		int z2 = z - (size/2);

		build(world, x2, y, z2, block, size, 1, 1);
		build(world, x2, y, z2, block, 1, 1, size);
		
		build(world, x2+(size-1), y, z2, block, size, 1, 1);
		build(world, x2, y, z2+(size-1), block, 1, 1, size);
	}
	
	public void build(World world, int x, int y, int z, Block block, int xTimesTotal, int yTimesTotal, int zTimesTotal) {
		int z2 = z;
		int x2 = x;
		for (int yTimes = 0; yTimes < yTimesTotal; yTimes++) {
			for (int zTimes = 0; zTimes < zTimesTotal; zTimes++) {
				for (int xTimes = 0; xTimes < xTimesTotal; xTimes++) {
					world.setBlock(x2, y, z2, block);
					z2++;
				}
				z2 = z;
				x2++;
			}
			x2 = x;
			y++;
		}
	}
	
	public boolean isBlockNear(World world, int X, int Y, int Z, int radius, Block block) {
        int x = (int) (X -radius);
        int y = (int) (Y +radius);
        int z = (int) (Z -radius);
   
        int bx = x;
        int bz = z;
 
        for (int i=0; i<radius*2+1; i++) {
            for (int j=0; j<radius*2+1; j++) {
                for (int k=0; k<radius*2+1; k++) {
                    Block curBlock = world.getBlock(x, y, z);
                    
                    if(curBlock == block) {
                    	return true;
                    }
                    
                    x++;
                }
                z++;
                x = bx;
            }
            z = bz;
            x = bx;
            y--;
        }
        return false;
    }
	
	public boolean isBlockNear2(World world, int x, int y, int z, Block block, int xTimesTotal, int yTimesTotal, int zTimesTotal) {
		int z2 = z;
		int x2 = x;
		for (int yTimes = 0; yTimes < yTimesTotal; yTimes++) {
			for (int zTimes = 0; zTimes < zTimesTotal; zTimes++) {
				for (int xTimes = 0; xTimes < xTimesTotal; xTimes++) {
					Block curBlock = world.getBlock(x, y, z);
					
					if(curBlock == block) {
                    	return true;
                    }
					
					z2++;
				}
				z2 = z;
				x2++;
			}
			x2 = x;
			y++;
		}
		return false;
	}
}