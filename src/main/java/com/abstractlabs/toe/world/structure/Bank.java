package com.abstractlabs.toe.world.structure;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

import com.abstractlabs.toe.utility.BuildHelper;

public class Bank {
	public static void build(World world, int x, int y, int z, Block main, int mainMeta, Block floor, int floorMeta, Block stairs, int stairsMeta, Block slab, int slabMeta, Block wall, int wallMeta, Block fence, int fenceMeta, Block lamp, int lampMeta, Block roof, int roofMeta) {
		buildLayer1(world, x, y, z, main, mainMeta, floor, floorMeta, stairs, stairsMeta, slab, slabMeta, wall, wallMeta, fence, fenceMeta, lamp, lampMeta, roof, roofMeta);
		buildLayer2(world, x, y, z, main, mainMeta, floor, floorMeta, stairs, stairsMeta, slab, slabMeta, wall, wallMeta, fence, fenceMeta, lamp, lampMeta, roof, roofMeta);
		buildLayer3(world, x, y, z, main, mainMeta, floor, floorMeta, stairs, stairsMeta, slab, slabMeta, wall, wallMeta, fence, fenceMeta, lamp, lampMeta, roof, roofMeta);
		buildLayer4(world, x, y, z, main, mainMeta, floor, floorMeta, stairs, stairsMeta, slab, slabMeta, wall, wallMeta, fence, fenceMeta, lamp, lampMeta, roof, roofMeta);
		buildLayer5(world, x, y, z, main, mainMeta, floor, floorMeta, stairs, stairsMeta, slab, slabMeta, wall, wallMeta, fence, fenceMeta, lamp, lampMeta, roof, roofMeta);
		buildLayer6(world, x, y, z, main, mainMeta, floor, floorMeta, stairs, stairsMeta, slab, slabMeta, wall, wallMeta, fence, fenceMeta, lamp, lampMeta, roof, roofMeta);
		buildLayer7(world, x, y, z, main, mainMeta, floor, floorMeta, stairs, stairsMeta, slab, slabMeta, wall, wallMeta, fence, fenceMeta, lamp, lampMeta, roof, roofMeta);
	}
	
	private static void buildLayer1(World world, int x, int y, int z, Block main, int mainMeta, Block floor, int floorMeta, Block stairs, int stairsMeta, Block slab, int slabMeta, Block wall, int wallMeta, Block fence, int fenceMeta, Block lamp, int lampMeta, Block roof, int roofMeta) {
		BuildHelper.build(world, x-6, y+1, z-2, main, mainMeta, 5, 1, 1);
		BuildHelper.build(world, x-5, y+1, z-4, main, mainMeta, 3, 1, 1);
		BuildHelper.build(world, x-5, y+1, z+2, main, mainMeta, 3, 1, 1);
		
		BuildHelper.build(world, x+6, y+1, z-2, main, mainMeta, 5, 1, 1);
		BuildHelper.build(world, x+5, y+1, z-4, main, mainMeta, 3, 1, 1);
		BuildHelper.build(world, x+5, y+1, z+2, main, mainMeta, 3, 1, 1);
		
		BuildHelper.build(world, x-2, y+1, z-6, main, mainMeta, 1, 1, 5);
		BuildHelper.build(world, x-4, y+1, z-5, main, mainMeta, 1, 1, 3);
		BuildHelper.build(world, x+2, y+1, z-5, main, mainMeta, 1, 1, 3);
		
		BuildHelper.build(world, x-2, y+1, z+6, main, mainMeta, 1, 1, 5);
		BuildHelper.build(world, x-4, y+1, z+5, main, mainMeta, 1, 1, 3);
		BuildHelper.build(world, x+2, y+1, z+5, main, mainMeta, 1, 1, 3);
		
		BuildHelper.build(world, x-4, y+1, z-4, floor, floorMeta, 9, 1, 9);
		BuildHelper.build(world, x-1, y+1, z-1, main, mainMeta, 3, 1, 3);
		
		BuildHelper.build(world, x-5, y+1, z-1, floor, floorMeta, 3, 1, 1);
		BuildHelper.build(world, x+5, y+1, z-1, floor, floorMeta, 3, 1, 1);
		BuildHelper.build(world, x-1, y+1, z-5, floor, floorMeta, 1, 1, 3);
		BuildHelper.build(world, x-1, y+1, z+5, floor, floorMeta, 1, 1, 3);

		world.setBlock(x-4, y+1, z-4, main, mainMeta, 2);
		world.setBlock(x-4, y+1, z+4, main, mainMeta, 2);
		world.setBlock(x+4, y+1, z-4, main, mainMeta, 2);
		world.setBlock(x+4, y+1, z+4, main, mainMeta, 2);
		
		BuildHelper.build(world, x-7, y+1, z-1, stairs, 0, 3, 1, 1);
		BuildHelper.build(world, x+7, y+1, z-1, stairs, 1, 3, 1, 1);
		BuildHelper.build(world, x-1, y+1, z-7, stairs, 2, 1, 1, 3);
		BuildHelper.build(world, x-1, y+1, z+7, stairs, 3, 1, 1, 3);
	}
	
	private static void buildLayer2(World world, int x, int y, int z, Block main, int mainMeta, Block floor, int floorMeta, Block stairs, int stairsMeta, Block slab, int slabMeta, Block wall, int wallMeta, Block fence, int fenceMeta, Block lamp, int lampMeta, Block roof, int roofMeta) {
		BuildHelper.build(world, x-5, y+2, z-4, wall, wallMeta, 3, 1, 1);
		BuildHelper.build(world, x-5, y+2, z+2, wall, wallMeta, 3, 1, 1);
		
		BuildHelper.build(world, x+5, y+2, z-4, wall, wallMeta, 3, 1, 1);
		BuildHelper.build(world, x+5, y+2, z+2, wall, wallMeta, 3, 1, 1);

		BuildHelper.build(world, x-4, y+2, z-5, wall, wallMeta, 1, 1, 3);
		BuildHelper.build(world, x+2, y+2, z-5, wall, wallMeta, 1, 1, 3);

		BuildHelper.build(world, x-4, y+2, z+5, wall, wallMeta, 1, 1, 3);
		BuildHelper.build(world, x+2, y+2, z+5, wall, wallMeta, 1, 1, 3);

		world.setBlock(x-6, y+2, z-2, wall, wallMeta, 2);
		world.setBlock(x-6, y+2, z+2, wall, wallMeta, 2);
		world.setBlock(x-4, y+2, z-4, wall, wallMeta, 2);
		world.setBlock(x-4, y+2, z+4, wall, wallMeta, 2);
		world.setBlock(x-2, y+2, z-6, wall, wallMeta, 2);
		world.setBlock(x-2, y+2, z+6, wall, wallMeta, 2);
		world.setBlock(x+6, y+2, z-2, wall, wallMeta, 2);
		world.setBlock(x+6, y+2, z+2, wall, wallMeta, 2);
		world.setBlock(x+4, y+2, z-4, wall, wallMeta, 2);
		world.setBlock(x+4, y+2, z+4, wall, wallMeta, 2);
		world.setBlock(x+2, y+2, z-6, wall, wallMeta, 2);
		world.setBlock(x+2, y+2, z+6, wall, wallMeta, 2);

		world.setBlock(x-1, y+2, z-1, main, mainMeta, 2);
		world.setBlock(x-1, y+2, z, slab, slabMeta, 2);
		world.setBlock(x-1, y+2, z+1, main, mainMeta, 2);
		world.setBlock(x, y+2, z-1, slab, slabMeta, 2);
		world.setBlock(x, y+2, z+1, slab, slabMeta, 2);
		world.setBlock(x+1, y+2, z-1, main, mainMeta, 2);
		world.setBlock(x+1, y+2, z, slab, slabMeta, 2);
		world.setBlock(x+1, y+2, z+1, main, mainMeta, 2);
	}
	
	private static void buildLayer3(World world, int x, int y, int z, Block main, int mainMeta, Block floor, int floorMeta, Block stairs, int stairsMeta, Block slab, int slabMeta, Block wall, int wallMeta, Block fence, int fenceMeta, Block lamp, int lampMeta, Block roof, int roofMeta) {
		world.setBlock(x-5, y+3, z-2, wall, wallMeta, 2);
		world.setBlock(x-5, y+3, z+2, wall, wallMeta, 2);
		world.setBlock(x-4, y+3, z-4, wall, wallMeta, 2);
		world.setBlock(x-4, y+3, z+4, wall, wallMeta, 2);
		world.setBlock(x-2, y+3, z-5, wall, wallMeta, 2);
		world.setBlock(x-2, y+3, z+5, wall, wallMeta, 2);
		world.setBlock(x+5, y+3, z-2, wall, wallMeta, 2);
		world.setBlock(x+5, y+3, z+2, wall, wallMeta, 2);
		world.setBlock(x+4, y+3, z-4, wall, wallMeta, 2);
		world.setBlock(x+4, y+3, z+4, wall, wallMeta, 2);
		world.setBlock(x+2, y+3, z-5, wall, wallMeta, 2);
		world.setBlock(x+2, y+3, z+5, wall, wallMeta, 2);

		world.setBlock(x-6, y+3, z-2, Blocks.torch, 0, 2);
		world.setBlock(x-6, y+3, z+2, Blocks.torch, 0, 2);
		world.setBlock(x-2, y+3, z-6, Blocks.torch, 0, 2);
		world.setBlock(x-2, y+3, z+6, Blocks.torch, 0, 2);
		world.setBlock(x+6, y+3, z-2, Blocks.torch, 0, 2);
		world.setBlock(x+6, y+3, z+2, Blocks.torch, 0, 2);
		world.setBlock(x+2, y+3, z-6, Blocks.torch, 0, 2);
		world.setBlock(x+2, y+3, z+6, Blocks.torch, 0, 2);

		world.setBlock(x-1, y+3, z-1, fence, fenceMeta, 2);
		world.setBlock(x-1, y+3, z+1, fence, fenceMeta, 2);
		world.setBlock(x+1, y+3, z-1, fence, fenceMeta, 2);
		world.setBlock(x+1, y+3, z+1, fence, fenceMeta, 2);
	}
	
	private static void buildLayer4(World world, int x, int y, int z, Block main, int mainMeta, Block floor, int floorMeta, Block stairs, int stairsMeta, Block slab, int slabMeta, Block wall, int wallMeta, Block fence, int fenceMeta, Block lamp, int lampMeta, Block roof, int roofMeta) {
		world.setBlock(x-5, y+4, z-2, wall, wallMeta, 2);
		world.setBlock(x-5, y+4, z+2, wall, wallMeta, 2);
		world.setBlock(x-4, y+4, z-4, wall, wallMeta, 2);
		world.setBlock(x-4, y+4, z+4, wall, wallMeta, 2);
		world.setBlock(x-2, y+4, z-5, wall, wallMeta, 2);
		world.setBlock(x-2, y+4, z+5, wall, wallMeta, 2);
		world.setBlock(x+5, y+4, z-2, wall, wallMeta, 2);
		world.setBlock(x+5, y+4, z+2, wall, wallMeta, 2);
		world.setBlock(x+4, y+4, z-4, wall, wallMeta, 2);
		world.setBlock(x+4, y+4, z+4, wall, wallMeta, 2);
		world.setBlock(x+2, y+4, z-5, wall, wallMeta, 2);
		world.setBlock(x+2, y+4, z+5, wall, wallMeta, 2);

		world.setBlock(x-1, y+4, z-1, slab, slabMeta, 2);
		world.setBlock(x-1, y+4, z, slab, slabMeta, 2);
		world.setBlock(x-1, y+4, z+1, slab, slabMeta, 2);
		world.setBlock(x, y+4, z-1, slab, slabMeta, 2);
		world.setBlock(x, y+4, z, main, mainMeta, 2);
		world.setBlock(x, y+4, z+1, slab, slabMeta, 2);
		world.setBlock(x+1, y+4, z-1, slab, slabMeta, 2);
		world.setBlock(x+1, y+4, z, slab, slabMeta, 2);
		world.setBlock(x+1, y+4, z+1, slab, slabMeta, 2);
	}
	
	private static void buildLayer5(World world, int x, int y, int z, Block main, int mainMeta, Block floor, int floorMeta, Block stairs, int stairsMeta, Block slab, int slabMeta, Block wall, int wallMeta, Block fence, int fenceMeta, Block lamp, int lampMeta, Block roof, int roofMeta) {
		world.setBlock(x-5, y+5, z-2, wall, wallMeta, 2);
		world.setBlock(x-5, y+5, z+2, wall, wallMeta, 2);
		world.setBlock(x-4, y+5, z-4, wall, wallMeta, 2);
		world.setBlock(x-4, y+5, z+4, wall, wallMeta, 2);
		world.setBlock(x-2, y+5, z-5, wall, wallMeta, 2);
		world.setBlock(x-2, y+5, z+5, wall, wallMeta, 2);
		world.setBlock(x+5, y+5, z-2, wall, wallMeta, 2);
		world.setBlock(x+5, y+5, z+2, wall, wallMeta, 2);
		world.setBlock(x+4, y+5, z-4, wall, wallMeta, 2);
		world.setBlock(x+4, y+5, z+4, wall, wallMeta, 2);
		world.setBlock(x+2, y+5, z-5, wall, wallMeta, 2);
		world.setBlock(x+2, y+5, z+5, wall, wallMeta, 2);

		world.setBlock(x-2, y+5, z-2, lamp, lampMeta, 2);
		world.setBlock(x-2, y+5, z+2, lamp, lampMeta, 2);
		world.setBlock(x+2, y+5, z-2, lamp, lampMeta, 2);
		world.setBlock(x+2, y+5, z+2, lamp, lampMeta, 2);
	}
	
	private static void buildLayer6(World world, int x, int y, int z, Block main, int mainMeta, Block floor, int floorMeta, Block stairs, int stairsMeta, Block slab, int slabMeta, Block wall, int wallMeta, Block fence, int fenceMeta, Block lamp, int lampMeta, Block roof, int roofMeta) {
		BuildHelper.build(world, x-5, y+6, z-4, roof, roofMeta, 9, 1, 1);
		BuildHelper.build(world, x+5, y+6, z-4, roof, roofMeta, 9, 1, 1);
		BuildHelper.build(world, x-4, y+6, z-5, roof, roofMeta, 1, 1, 9);
		BuildHelper.build(world, x-4, y+6, z+5, roof, roofMeta, 1, 1, 9);
		
		BuildHelper.build(world, x-4, y+6, z-3, roof, roofMeta+8, 7, 1, 1);
		BuildHelper.build(world, x+4, y+6, z-3, roof, roofMeta+8, 7, 1, 1);
		BuildHelper.build(world, x-3, y+6, z-4, roof, roofMeta+8, 1, 1, 7);
		BuildHelper.build(world, x-3, y+6, z+4, roof, roofMeta+8, 1, 1, 7);

		world.setBlock(x-4, y+6, z-4, roof, roofMeta, 2);
		world.setBlock(x-4, y+6, z+4, roof, roofMeta, 2);
		world.setBlock(x+4, y+6, z-4, roof, roofMeta, 2);
		world.setBlock(x+4, y+6, z+4, roof, roofMeta, 2);

		world.setBlock(x-3, y+6, z-3, roof, roofMeta+8, 2);
		world.setBlock(x-3, y+6, z+3, roof, roofMeta+8, 2);
		world.setBlock(x+3, y+6, z-3, roof, roofMeta+8, 2);
		world.setBlock(x+3, y+6, z+3, roof, roofMeta+8, 2);

		world.setBlock(x-2, y+6, z-2, fence, fenceMeta, 2);
		world.setBlock(x-2, y+6, z+2, fence, fenceMeta, 2);
		world.setBlock(x+2, y+6, z-2, fence, fenceMeta, 2);
		world.setBlock(x+2, y+6, z+2, fence, fenceMeta, 2);
	}
	
	private static void buildLayer7(World world, int x, int y, int z, Block main, int mainMeta, Block floor, int floorMeta, Block stairs, int stairsMeta, Block slab, int slabMeta, Block wall, int wallMeta, Block fence, int fenceMeta, Block lamp, int lampMeta, Block roof, int roofMeta) {
		BuildHelper.build(world, x-3, y+7, z-2, roof, roofMeta, 5, 1, 1);
		BuildHelper.build(world, x+3, y+7, z-2, roof, roofMeta, 5, 1, 1);
		BuildHelper.build(world, x-2, y+7, z-3, roof, roofMeta, 1, 1, 5);
		BuildHelper.build(world, x-2, y+7, z+3, roof, roofMeta, 1, 1, 5);
		
		BuildHelper.build(world, x-2, y+7, z-1, roof, roofMeta+8, 3, 1, 1);
		BuildHelper.build(world, x+2, y+7, z-1, roof, roofMeta+8, 3, 1, 1);
		BuildHelper.build(world, x-1, y+7, z-2, roof, roofMeta+8, 1, 1, 3);
		BuildHelper.build(world, x-1, y+7, z+2, roof, roofMeta+8, 1, 1, 3);

		world.setBlock(x-2, y+7, z-2, roof, roofMeta, 2);
		world.setBlock(x-2, y+7, z+2, roof, roofMeta, 2);
		world.setBlock(x+2, y+7, z-2, roof, roofMeta, 2);
		world.setBlock(x+2, y+7, z+2, roof, roofMeta, 2);

		BuildHelper.build(world, x-1, y+7, z-1, roof, roofMeta+8, 3, 1, 3);
	}
}