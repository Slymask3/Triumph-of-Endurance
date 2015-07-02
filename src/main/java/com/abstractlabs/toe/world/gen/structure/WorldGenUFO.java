package com.abstractlabs.toe.world.gen.structure;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import com.abstractlabs.toe.init.ToeBlocks;
import com.abstractlabs.toe.utility.BuildHelper;
import com.abstractlabs.toe.utility.LogHelper;
import com.abstractlabs.toe.world.structure.UFO;

public class WorldGenUFO extends WorldGenerator {
	@Override
	public boolean generate(World world, Random rand, int x, int y, int z) {
		y = BuildHelper.positionYOnTheFloor(world, x, y, z);
		y+= rand.nextInt(30)+30; // generate from 30-60 blocks from the ground
		
//		if(BuildHelper.isBlockNear(world, x, y, z, arenaSize, ToeBlocks.exteriorDesert)) {
//        	LogHelper.info("Generation cancelled because another desert arena is near.");
//			return false;
//		}
        
        UFO.build(world, x, y, z, Blocks.quartz_block, 0, Blocks.obsidian, 0, Blocks.glowstone, 0);
        UFO.buildBeamAndPortal(world, x, y, z, ToeBlocks.beam, 0, ToeBlocks.portalCallisto, 0);
        
        LogHelper.info("UFO Generated at [" + x + ", " + y + ", " + z + "]");
        
        return true;
	}
}