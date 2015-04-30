package com.abstractlabs.toe.worldgen;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;

import com.abstractlabs.toe.init.ToeBlocks;
import com.abstractlabs.toe.utility.LogHelper;

public class WorldGenDomeDesert extends WorldGenerator {
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

        world.setBlock(x, y, z, ToeBlocks.exteriorDesert);
        world.setBlock(x, y+1, z, ToeBlocks.exteriorDesert);
        world.setBlock(x, y+2, z, ToeBlocks.exteriorDesert);
        world.setBlock(x, y+3, z, ToeBlocks.exteriorDesert);
        world.setBlock(x, y+4, z, ToeBlocks.exteriorDesert);
        world.setBlock(x, y+5, z, ToeBlocks.exteriorDesert);
        world.setBlock(x, y+6, z, Blocks.glowstone);
        
        LogHelper.info("Generated at [" + x + ", " + y + ", " + z + "]");
        
        return true;
	}
}