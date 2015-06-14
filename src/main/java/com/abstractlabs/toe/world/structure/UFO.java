package com.abstractlabs.toe.world.structure;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

import com.abstractlabs.toe.utility.BuildHelper;

public class UFO {
	public static void build(World world, int x, int y, int z, Block main, int mainMeta, Block sec, int secMeta, Block third, int thirdMeta) {
		buildLayer1(world, x, y, z, main, mainMeta, sec, secMeta, third, thirdMeta);
		buildLayer2(world, x, y, z, main, mainMeta, sec, secMeta, third, thirdMeta);
		buildLayer3(world, x, y, z, main, mainMeta, sec, secMeta, third, thirdMeta);
		buildLayer4(world, x, y, z, main, mainMeta, sec, secMeta, third, thirdMeta);
		buildLayer5(world, x, y, z, main, mainMeta, sec, secMeta, third, thirdMeta);
	}
	
	private static void buildLayer1(World world, int x, int y, int z, Block main, int mainMeta, Block sec, int secMeta, Block third, int thirdMeta) {
		world.setBlock(x-2, y, z-1, sec, secMeta, 2);
		world.setBlock(x-2, y, z, sec, secMeta, 2);
		world.setBlock(x-2, y, z+1, sec, secMeta, 2);

		world.setBlock(x-1, y, z-2, sec, secMeta, 2);
		world.setBlock(x-1, y, z-1, sec, secMeta, 2);
		world.setBlock(x-1, y, z, third, thirdMeta, 2);
		world.setBlock(x-1, y, z+1, sec, secMeta, 2);
		world.setBlock(x-1, y, z+2, sec, secMeta, 2);

		world.setBlock(x, y, z-2, sec, secMeta, 2);
		world.setBlock(x, y, z-1, third, thirdMeta, 2);
		world.setBlock(x, y, z+1, third, thirdMeta, 2);
		world.setBlock(x, y, z+2, sec, secMeta, 2);

		world.setBlock(x+1, y, z-2, sec, secMeta, 2);
		world.setBlock(x+1, y, z-1, sec, secMeta, 2);
		world.setBlock(x+1, y, z, third, thirdMeta, 2);
		world.setBlock(x+1, y, z+1, sec, secMeta, 2);
		world.setBlock(x+1, y, z+2, sec, secMeta, 2);

		world.setBlock(x+2, y, z-1, sec, secMeta, 2);
		world.setBlock(x+2, y, z, sec, secMeta, 2);
		world.setBlock(x+2, y, z+1, sec, secMeta, 2);
	}
	
	private static void buildLayer2(World world, int x, int y, int z, Block main, int mainMeta, Block sec, int secMeta, Block third, int thirdMeta) {
		BuildHelper.build(world, x-5, y+1, z-2, main, mainMeta, 5, 1, 1);
		BuildHelper.build(world, x-4, y+1, z-4, main, mainMeta, 9, 1, 2);
		
		BuildHelper.build(world, x+5, y+1, z-2, main, mainMeta, 5, 1, 1);
		BuildHelper.build(world, x+3, y+1, z-4, main, mainMeta, 9, 1, 2);

		BuildHelper.build(world, x-2, y+1, z-5, main, mainMeta, 3, 1, 5);

		BuildHelper.build(world, x-2, y+1, z+3, main, mainMeta, 3, 1, 5);

		world.setBlock(x-2, y+1, z-2, main, mainMeta, 2);
		world.setBlock(x-2, y+1, z+2, main, mainMeta, 2);
		world.setBlock(x+2, y+1, z-2, main, mainMeta, 2);
		world.setBlock(x+2, y+1, z+2, main, mainMeta, 2);

		BuildHelper.build(world, x-6, y+1, z-2, sec, secMeta, 5, 1, 1);
		BuildHelper.build(world, x-5, y+1, z-4, sec, secMeta, 2, 1, 1);
		BuildHelper.build(world, x-5, y+1, z+3, sec, secMeta, 2, 1, 1);

		BuildHelper.build(world, x+6, y+1, z-2, sec, secMeta, 5, 1, 1);
		BuildHelper.build(world, x+5, y+1, z-4, sec, secMeta, 2, 1, 1);
		BuildHelper.build(world, x+5, y+1, z+3, sec, secMeta, 2, 1, 1);

		BuildHelper.build(world, x-2, y+1, z-6, sec, secMeta, 1, 1, 5);
		BuildHelper.build(world, x-4, y+1, z-5, sec, secMeta, 1, 1, 2);
		BuildHelper.build(world, x+3, y+1, z-5, sec, secMeta, 1, 1, 2);

		BuildHelper.build(world, x-2, y+1, z+6, sec, secMeta, 1, 1, 5);
		BuildHelper.build(world, x-4, y+1, z+5, sec, secMeta, 1, 1, 2);
		BuildHelper.build(world, x+3, y+1, z+5, sec, secMeta, 1, 1, 2);
	}
	
	private static void buildLayer3(World world, int x, int y, int z, Block main, int mainMeta, Block sec, int secMeta, Block third, int thirdMeta) {
		BuildHelper.build(world, x-7, y+2, z-2, main, mainMeta, 5, 1, 1);
		BuildHelper.build(world, x-6, y+2, z-4, main, mainMeta, 2, 1, 1);
		BuildHelper.build(world, x-6, y+2, z+3, main, mainMeta, 2, 1, 1);

		BuildHelper.build(world, x+7, y+2, z-2, main, mainMeta, 5, 1, 1);
		BuildHelper.build(world, x+6, y+2, z-4, main, mainMeta, 2, 1, 1);
		BuildHelper.build(world, x+6, y+2, z+3, main, mainMeta, 2, 1, 1);

		BuildHelper.build(world, x-2, y+2, z-7, main, mainMeta, 1, 1, 5);
		BuildHelper.build(world, x-4, y+2, z-6, main, mainMeta, 1, 1, 2);
		BuildHelper.build(world, x+3, y+2, z-6, main, mainMeta, 1, 1, 2);

		BuildHelper.build(world, x-2, y+2, z+7, main, mainMeta, 1, 1, 5);
		BuildHelper.build(world, x-4, y+2, z+6, main, mainMeta, 1, 1, 2);
		BuildHelper.build(world, x+3, y+2, z+6, main, mainMeta, 1, 1, 2);

		world.setBlock(x-5, y+2, z-5, main, mainMeta, 2);
		world.setBlock(x-5, y+2, z+5, main, mainMeta, 2);
		world.setBlock(x+5, y+2, z-5, main, mainMeta, 2);
		world.setBlock(x+5, y+2, z+5, main, mainMeta, 2);

		BuildHelper.build(world, x-8, y+2, z-2, sec, secMeta, 5, 1, 1);
		BuildHelper.build(world, x-7, y+2, z-4, sec, secMeta, 2, 1, 1);
		BuildHelper.build(world, x-7, y+2, z+3, sec, secMeta, 2, 1, 1);

		BuildHelper.build(world, x+8, y+2, z-2, sec, secMeta, 5, 1, 1);
		BuildHelper.build(world, x+7, y+2, z-4, sec, secMeta, 2, 1, 1);
		BuildHelper.build(world, x+7, y+2, z+3, sec, secMeta, 2, 1, 1);

		BuildHelper.build(world, x-2, y+2, z-8, sec, secMeta, 1, 1, 5);
		BuildHelper.build(world, x-4, y+2, z-7, sec, secMeta, 1, 1, 2);
		BuildHelper.build(world, x+3, y+2, z-7, sec, secMeta, 1, 1, 2);

		BuildHelper.build(world, x-2, y+2, z+8, sec, secMeta, 1, 1, 5);
		BuildHelper.build(world, x-4, y+2, z+7, sec, secMeta, 1, 1, 2);
		BuildHelper.build(world, x+3, y+2, z+7, sec, secMeta, 1, 1, 2);

		world.setBlock(x-5, y+2, z-6, sec, secMeta, 2);
		world.setBlock(x-5, y+2, z+6, sec, secMeta, 2);
		world.setBlock(x+5, y+2, z-6, sec, secMeta, 2);
		world.setBlock(x+5, y+2, z+6, sec, secMeta, 2);

		world.setBlock(x-6, y+2, z-5, sec, secMeta, 2);
		world.setBlock(x-6, y+2, z+5, sec, secMeta, 2);
		world.setBlock(x+6, y+2, z-5, sec, secMeta, 2);
		world.setBlock(x+6, y+2, z+5, sec, secMeta, 2);
	}
	
	private static void buildLayer4(World world, int x, int y, int z, Block main, int mainMeta, Block sec, int secMeta, Block third, int thirdMeta) {
		BuildHelper.build(world, x-5, y+3, z-2, main, mainMeta, 5, 1, 1);
		BuildHelper.build(world, x-4, y+3, z-4, main, mainMeta, 9, 1, 2);
		
		BuildHelper.build(world, x+5, y+3, z-2, main, mainMeta, 5, 1, 1);
		BuildHelper.build(world, x+3, y+3, z-4, main, mainMeta, 9, 1, 2);

		BuildHelper.build(world, x-2, y+3, z-5, main, mainMeta, 3, 1, 5);

		BuildHelper.build(world, x-2, y+3, z+3, main, mainMeta, 3, 1, 5);

		world.setBlock(x-2, y+3, z-2, main, mainMeta, 2);
		world.setBlock(x-2, y+3, z+2, main, mainMeta, 2);
		world.setBlock(x+2, y+3, z-2, main, mainMeta, 2);
		world.setBlock(x+2, y+3, z+2, main, mainMeta, 2);

		BuildHelper.build(world, x-6, y+3, z-2, sec, secMeta, 5, 1, 1);
		BuildHelper.build(world, x-5, y+3, z-4, sec, secMeta, 2, 1, 1);
		BuildHelper.build(world, x-5, y+3, z+3, sec, secMeta, 2, 1, 1);

		BuildHelper.build(world, x+6, y+3, z-2, sec, secMeta, 5, 1, 1);
		BuildHelper.build(world, x+5, y+3, z-4, sec, secMeta, 2, 1, 1);
		BuildHelper.build(world, x+5, y+3, z+3, sec, secMeta, 2, 1, 1);

		BuildHelper.build(world, x-2, y+3, z-6, sec, secMeta, 1, 1, 5);
		BuildHelper.build(world, x-4, y+3, z-5, sec, secMeta, 1, 1, 2);
		BuildHelper.build(world, x+3, y+3, z-5, sec, secMeta, 1, 1, 2);

		BuildHelper.build(world, x-2, y+3, z+6, sec, secMeta, 1, 1, 5);
		BuildHelper.build(world, x-4, y+3, z+5, sec, secMeta, 1, 1, 2);
		BuildHelper.build(world, x+3, y+3, z+5, sec, secMeta, 1, 1, 2);
	}
	
	private static void buildLayer5(World world, int x, int y, int z, Block main, int mainMeta, Block sec, int secMeta, Block third, int thirdMeta) {
		world.setBlock(x-2, y+4, z-1, sec, secMeta, 2);
		world.setBlock(x-2, y+4, z, sec, secMeta, 2);
		world.setBlock(x-2, y+4, z+1, sec, secMeta, 2);

		world.setBlock(x-1, y+4, z-2, sec, secMeta, 2);
		world.setBlock(x-1, y+4, z-1, sec, secMeta, 2);
		world.setBlock(x-1, y+4, z, third, thirdMeta, 2);
		world.setBlock(x-1, y+4, z+1, sec, secMeta, 2);
		world.setBlock(x-1, y+4, z+2, sec, secMeta, 2);

		world.setBlock(x, y+4, z-2, sec, secMeta, 2);
		world.setBlock(x, y+4, z-1, third, thirdMeta, 2);
		world.setBlock(x, y+4, z, third, thirdMeta, 2);
		world.setBlock(x, y+4, z+1, third, thirdMeta, 2);
		world.setBlock(x, y+4, z+2, sec, secMeta, 2);

		world.setBlock(x+1, y+4, z-2, sec, secMeta, 2);
		world.setBlock(x+1, y+4, z-1, sec, secMeta, 2);
		world.setBlock(x+1, y+4, z, third, thirdMeta, 2);
		world.setBlock(x+1, y+4, z+1, sec, secMeta, 2);
		world.setBlock(x+1, y+4, z+2, sec, secMeta, 2);

		world.setBlock(x+2, y+4, z-1, sec, secMeta, 2);
		world.setBlock(x+2, y+4, z, sec, secMeta, 2);
		world.setBlock(x+2, y+4, z+1, sec, secMeta, 2);
	}
	
	public static void buildBeamAndPortal(World world, int x, int y, int z, Block beam, int beamMeta, Block portal, int portalMeta) {
		world.setBlock(x, y+3, z, portal, portalMeta, 2);
		y+=2;
		while(world.getBlock(x, y, z) == Blocks.air) {
			world.setBlock(x, y, z, beam, beamMeta, 2);
			y--;
		}
	}
}