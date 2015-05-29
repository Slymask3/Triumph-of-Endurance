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
		BuildHelper.build(world, x-9, y, z-1, floor, floorMeta, 19, 1, 2);
		BuildHelper.build(world, x+2, y, z+2, floor, floorMeta, 8, 1, 2);
		BuildHelper.build(world, x+2, y, z-3, floor, floorMeta, 8, 1, 2);
		BuildHelper.build(world, x-9, y, z-2, main, mainMeta, 10, 1, 1);
		BuildHelper.build(world, x-9, y, z+2, main, mainMeta, 10, 1, 1);
		BuildHelper.build(world, x+2, y, z+4, main, mainMeta, 8, 1, 1);
		BuildHelper.build(world, x+11, y, z-2, main, mainMeta, 1, 1, 5);
		
		world.setBlock(x-11, y, z, main, mainMeta, 2);
		world.setBlock(x-10, y, z, floor, floorMeta, 2);
		world.setBlock(x-10, y, z+1, main, mainMeta, 2);
		world.setBlock(x-10, y, z-1, main, mainMeta, 2);
		world.setBlock(x-1, y, z+1, main, mainMeta, 2);
		world.setBlock(x-1, y, z-1, main, mainMeta, 2);
		world.setBlock(x+1, y, z+3, main, mainMeta, 2);
		world.setBlock(x+1, y, z+2, floor, floorMeta, 2);
		world.setBlock(x+1, y, z-3, main, mainMeta, 2);
		world.setBlock(x+1, y, z-2, floor, floorMeta, 2);
		world.setBlock(x+2, y, z-4, main, mainMeta, 2);
		world.setBlock(x+3, y, z-5, main, mainMeta, 2);
		world.setBlock(x+1, y, z-4, main, mainMeta, 2);
		world.setBlock(x+4, y, z-4, main, mainMeta, 2);
		world.setBlock(x+5, y, z-4, floor, floorMeta, 2);
		world.setBlock(x+6, y, z-4, floor, floorMeta, 2);
		world.setBlock(x+7, y, z-4, main, mainMeta, 2);
		world.setBlock(x+8, y, z-4, floor, floorMeta, 2);
		world.setBlock(x+8, y, z-5, main, mainMeta, 2);
		world.setBlock(x+9, y, z-4, main, mainMeta, 2);
		world.setBlock(x+10, y, z-3, main, mainMeta, 2);
		world.setBlock(x+10, y, z-2, floor, floorMeta, 2);
		world.setBlock(x+10, y, z+3, main, mainMeta, 2);
		world.setBlock(x+10, y, z+2, floor, floorMeta, 2);
	}
}
