package com.abstractlabs.toe.structures;

import net.minecraft.block.Block;
import net.minecraft.world.World;

import com.abstractlabs.toe.utility.BuildHelper;

public class WizardTower 
{
	public static void build(World world, int x, int y, int z, Block main, int mainMeta, Block secondary, int secondaryMeta, Block third, int thirdMeta, Block floor, int floorMeta, Block pane, int paneMeta, Block stairs, int stairsMeta, Block slab, int slabMeta, Block wall, int wallMeta, Block roof, int roofMeta) 
	{
		buildLayer1(world, x, y, z, main, mainMeta, secondary, secondaryMeta, third, thirdMeta, floor, floorMeta, pane, paneMeta, stairs, stairsMeta, slab, slabMeta, wall, wallMeta, roof, roofMeta);
	
	}
	
	private static void buildLayer1(World world, int x, int y, int z, Block main, int mainMeta, Block secondary, int secondaryMeta, Block third, int thirdMeta, Block floor, int floorMeta, Block pane, int paneMeta, Block stairs, int stairsMeta, Block slab, int slabMeta, Block wall, int wallMeta, Block roof, int roofMeta) 
	{
		BuildHelper.build(world, x-9, y, z-1, floor, floorMeta, 3, 1, 20);
		BuildHelper.build(world, x+2, y, z+2, floor, floorMeta, 2, 1, 8);
		BuildHelper.build(world, x+2, y, z-3, floor, floorMeta, 2, 1, 8);
		BuildHelper.build(world, x-9, y, z-2, main, mainMeta, 1, 1, 10);
		BuildHelper.build(world, x-9, y, z+2, main, mainMeta, 1, 1, 10);
		BuildHelper.build(world, x+2, y, z-4, main, mainMeta, 1, 1, 8);
		BuildHelper.build(world, x+11, y, z-2, main, mainMeta, 5, 1, 1);
		
		world.setBlock(x-11, y, z, main, mainMeta, 2);
		//world.setBlock(x-10, y, z, floor, floorMeta, 2);
		world.setBlock(x-10, y, z+1, main, mainMeta, 2); //good
		world.setBlock(x-10, y, z-1, main, mainMeta, 2);
		
		world.setBlock(x, y, z+1, main, mainMeta, 2); //good
		world.setBlock(x, y, z-1, main, mainMeta, 2);
		
		world.setBlock(x+1, y, z+3, main, mainMeta, 2);
		world.setBlock(x+1, y, z+2, floor, floorMeta, 2);
		world.setBlock(x+1, y, z-3, main, mainMeta, 2);
		world.setBlock(x+1, y, z-2, floor, floorMeta, 2);
		
		world.setBlock(x+2, y, z+4, main, mainMeta, 2);
		world.setBlock(x+3, y, z+5, main, mainMeta, 2);
		world.setBlock(x+3, y, z+4, floor, floorMeta, 2);
		world.setBlock(x+4, y, z+4, main, mainMeta, 2);
		world.setBlock(x+5, y, z+4, floor, floorMeta, 2);
		world.setBlock(x+6, y, z+4, floor, floorMeta, 2);
		world.setBlock(x+7, y, z+4, main, mainMeta, 2);
		world.setBlock(x+8, y, z+4, floor, floorMeta, 2);
		world.setBlock(x+8, y, z+5, main, mainMeta, 2);
		world.setBlock(x+9, y, z+4, main, mainMeta, 2);
		
		world.setBlock(x+10, y, z-3, main, mainMeta, 2);
		world.setBlock(x+10, y, z-2, floor, floorMeta, 2);
		world.setBlock(x+10, y, z+3, main, mainMeta, 2);
		world.setBlock(x+10, y, z+2, floor, floorMeta, 2);
		
		//new inner main blocks
		world.setBlock(x+1, y, z-2, main, mainMeta, 2);
		world.setBlock(x+2, y, z-3, main, mainMeta, 2);

		world.setBlock(x+1, y, z+2, main, mainMeta, 2);
		world.setBlock(x+2, y, z+3, main, mainMeta, 2);
		world.setBlock(x+3, y, z+4, main, mainMeta, 2);

		world.setBlock(x+10, y, z-2, main, mainMeta, 2);
		world.setBlock(x+9, y, z-3, main, mainMeta, 2);

		world.setBlock(x+10, y, z+2, main, mainMeta, 2);
		world.setBlock(x+9, y, z+3, main, mainMeta, 2);
		world.setBlock(x+8, y, z+4, main, mainMeta, 2);
		
		//beam room
		world.setBlock(x-10, y, z, third, thirdMeta, 2);
		world.setBlock(x-9, y, z+1, third, thirdMeta, 2);
		world.setBlock(x-9, y, z, third, thirdMeta, 2);
		world.setBlock(x-9, y, z-1, third, thirdMeta, 2);
		world.setBlock(x-8, y, z+1, main, mainMeta, 2);
		world.setBlock(x-8, y, z, third, thirdMeta, 2);
		world.setBlock(x-8, y, z-1, main, mainMeta, 2);
		
		
		
		
		//testing
//		world.setBlock(x-10, y+1, z-6, stairs, 0, 2);
//		world.setBlock(x-8, y+1, z-6, stairs, 1, 2);
//		world.setBlock(x-6, y+1, z-6, stairs, 2, 2);
//		world.setBlock(x-4, y+1, z-6, stairs, 3, 2);
//		world.setBlock(x-2, y+1, z-6, stairs, 4, 2);
//		world.setBlock(x, y+1, z-6, stairs, 5, 2);
//		world.setBlock(x+2, y+1, z-6, stairs, 6, 2);
//		world.setBlock(x+4, y+1, z-6, stairs, 7, 2);
//		world.setBlock(x+6, y+1, z-6, stairs, 8, 2);
//		world.setBlock(x+8, y+1, z-6, stairs, 9, 2);
//		world.setBlock(x+10, y+1, z-6, stairs, 10, 2);
//		world.setBlock(x+12, y+1, z-6, stairs, 11, 2);
//		world.setBlock(x+14, y+1, z-6, stairs, 12, 2);
//		world.setBlock(x+16, y+1, z-6, stairs, 13, 2);
//		world.setBlock(x+18, y+1, z-6, stairs, 14, 2);
//		world.setBlock(x+20, y+1, z-6, stairs, 15, 2);
	}
}
