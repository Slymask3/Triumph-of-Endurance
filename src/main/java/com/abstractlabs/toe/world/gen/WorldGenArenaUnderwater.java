package com.abstractlabs.toe.world.gen;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;

import com.abstractlabs.toe.init.ToeBlocks;
import com.abstractlabs.toe.utility.BuildHelper;
import com.abstractlabs.toe.utility.LogHelper;

public class WorldGenArenaUnderwater extends WorldGenerator {
	public static int arenaSize = 69;
	
	@Override
	public boolean generate(World world, Random rand, int x, int y, int z) {
		y = BuildHelper.positionYOnTheFloor(world, x, y, z);
		
		if(world.getBiomeGenForCoords(x, z) != BiomeGenBase.deepOcean && world.getBiomeGenForCoords(x, z) != BiomeGenBase.ocean) {
			//return false;
		}
		
		if(BuildHelper.isBlockNear(world, x, y, z, arenaSize, ToeBlocks.exteriorGlass)) {
        	LogHelper.info("Generation cancelled because another underwater arena is near.");
			return false;
		}

        BuildHelper.buildSphere(world, x, y, z, Blocks.air, arenaSize/2, true);
        BuildHelper.buildSphere(world, x, y, z, ToeBlocks.exteriorGlass, arenaSize/2, false);
        
        LogHelper.info("Underwater Arena Generated at [" + x + ", " + y + ", " + z + "]");
        
        return true;
	}
}