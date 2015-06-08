package com.abstractlabs.toe.structures;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

import com.abstractlabs.toe.init.ToeBlocks;
import com.abstractlabs.toe.utility.BuildHelper;

public class WizardTower 
{
	public static void build(World world, int x, int y, int z, Block main, int mainMeta, Block secondary, int secondaryMeta, Block third, int thirdMeta, Block floor, int floorMeta, Block pane, int paneMeta, Block stairs, int stairsMeta, Block slab, int slabMeta, Block wall, int wallMeta, Block roof, int roofMeta) 
	{
		buildLayer1(world, x, y, z, main, mainMeta, secondary, secondaryMeta, third, thirdMeta, floor, floorMeta, pane, paneMeta, stairs, stairsMeta, slab, slabMeta, wall, wallMeta, roof, roofMeta);
		buildLayer2(world, x, y, z, main, mainMeta, secondary, secondaryMeta, third, thirdMeta, floor, floorMeta, pane, paneMeta, stairs, stairsMeta, slab, slabMeta, wall, wallMeta, roof, roofMeta);
		buildLayer3(world, x, y, z, main, mainMeta, secondary, secondaryMeta, third, thirdMeta, floor, floorMeta, pane, paneMeta, stairs, stairsMeta, slab, slabMeta, wall, wallMeta, roof, roofMeta);
		buildLayer4(world, x, y, z, main, mainMeta, secondary, secondaryMeta, third, thirdMeta, floor, floorMeta, pane, paneMeta, stairs, stairsMeta, slab, slabMeta, wall, wallMeta, roof, roofMeta);
		buildLayer5(world, x, y, z, main, mainMeta, secondary, secondaryMeta, third, thirdMeta, floor, floorMeta, pane, paneMeta, stairs, stairsMeta, slab, slabMeta, wall, wallMeta, roof, roofMeta);
		buildLayer6(world, x, y, z, main, mainMeta, secondary, secondaryMeta, third, thirdMeta, floor, floorMeta, pane, paneMeta, stairs, stairsMeta, slab, slabMeta, wall, wallMeta, roof, roofMeta);
		buildLayer7(world, x, y, z, main, mainMeta, secondary, secondaryMeta, third, thirdMeta, floor, floorMeta, pane, paneMeta, stairs, stairsMeta, slab, slabMeta, wall, wallMeta, roof, roofMeta);
		buildLayer8(world, x, y, z, main, mainMeta, secondary, secondaryMeta, third, thirdMeta, floor, floorMeta, pane, paneMeta, stairs, stairsMeta, slab, slabMeta, wall, wallMeta, roof, roofMeta);
		buildLayer9(world, x, y, z, main, mainMeta, secondary, secondaryMeta, third, thirdMeta, floor, floorMeta, pane, paneMeta, stairs, stairsMeta, slab, slabMeta, wall, wallMeta, roof, roofMeta);
		buildLayer10(world, x, y, z, main, mainMeta, secondary, secondaryMeta, third, thirdMeta, floor, floorMeta, pane, paneMeta, stairs, stairsMeta, slab, slabMeta, wall, wallMeta, roof, roofMeta);
		buildLayer11(world, x, y, z, main, mainMeta, secondary, secondaryMeta, third, thirdMeta, floor, floorMeta, pane, paneMeta, stairs, stairsMeta, slab, slabMeta, wall, wallMeta, roof, roofMeta);
		buildSecondTowerLayer(world, x, y, z, main, mainMeta, secondary, secondaryMeta, third, thirdMeta, floor, floorMeta, pane, paneMeta, stairs, stairsMeta, slab, slabMeta, wall, wallMeta, roof, roofMeta);
		buildLayer12(world, x, y, z, main, mainMeta, secondary, secondaryMeta, third, thirdMeta, floor, floorMeta, pane, paneMeta, stairs, stairsMeta, slab, slabMeta, wall, wallMeta, roof, roofMeta);
		buildLayer13(world, x, y, z, main, mainMeta, secondary, secondaryMeta, third, thirdMeta, floor, floorMeta, pane, paneMeta, stairs, stairsMeta, slab, slabMeta, wall, wallMeta, roof, roofMeta);
		buildLayer14(world, x, y, z, main, mainMeta, secondary, secondaryMeta, third, thirdMeta, floor, floorMeta, pane, paneMeta, stairs, stairsMeta, slab, slabMeta, wall, wallMeta, roof, roofMeta);
		buildLayer15(world, x, y, z, main, mainMeta, secondary, secondaryMeta, third, thirdMeta, floor, floorMeta, pane, paneMeta, stairs, stairsMeta, slab, slabMeta, wall, wallMeta, roof, roofMeta);
		buildLayer16(world, x, y, z, main, mainMeta, secondary, secondaryMeta, third, thirdMeta, floor, floorMeta, pane, paneMeta, stairs, stairsMeta, slab, slabMeta, wall, wallMeta, roof, roofMeta);
		buildLayer17(world, x, y, z, main, mainMeta, secondary, secondaryMeta, third, thirdMeta, floor, floorMeta, pane, paneMeta, stairs, stairsMeta, slab, slabMeta, wall, wallMeta, roof, roofMeta);
		buildLayer18(world, x, y, z, main, mainMeta, secondary, secondaryMeta, third, thirdMeta, floor, floorMeta, pane, paneMeta, stairs, stairsMeta, slab, slabMeta, wall, wallMeta, roof, roofMeta);
		buildLayer19(world, x, y, z, main, mainMeta, secondary, secondaryMeta, third, thirdMeta, floor, floorMeta, pane, paneMeta, stairs, stairsMeta, slab, slabMeta, wall, wallMeta, roof, roofMeta);
		buildLayer20(world, x, y, z, main, mainMeta, secondary, secondaryMeta, third, thirdMeta, floor, floorMeta, pane, paneMeta, stairs, stairsMeta, slab, slabMeta, wall, wallMeta, roof, roofMeta);
		buildLayer21(world, x, y, z, main, mainMeta, secondary, secondaryMeta, third, thirdMeta, floor, floorMeta, pane, paneMeta, stairs, stairsMeta, slab, slabMeta, wall, wallMeta, roof, roofMeta);
		buildLayer22(world, x, y, z, main, mainMeta, secondary, secondaryMeta, third, thirdMeta, floor, floorMeta, pane, paneMeta, stairs, stairsMeta, slab, slabMeta, wall, wallMeta, roof, roofMeta);
		buildLayer23(world, x, y, z, main, mainMeta, secondary, secondaryMeta, third, thirdMeta, floor, floorMeta, pane, paneMeta, stairs, stairsMeta, slab, slabMeta, wall, wallMeta, roof, roofMeta);
		buildLayer24(world, x, y, z, main, mainMeta, secondary, secondaryMeta, third, thirdMeta, floor, floorMeta, pane, paneMeta, stairs, stairsMeta, slab, slabMeta, wall, wallMeta, roof, roofMeta);
		buildLayer25(world, x, y, z, main, mainMeta, secondary, secondaryMeta, third, thirdMeta, floor, floorMeta, pane, paneMeta, stairs, stairsMeta, slab, slabMeta, wall, wallMeta, roof, roofMeta);
		roof(world, x, y, z, main, mainMeta, secondary, secondaryMeta, third, thirdMeta, floor, floorMeta, pane, paneMeta, stairs, stairsMeta, slab, slabMeta, wall, wallMeta, roof, roofMeta);
		//buildLayer22(world, x, y, z, main, mainMeta, secondary, secondaryMeta, third, thirdMeta, floor, floorMeta, pane, paneMeta, stairs, stairsMeta, slab, slabMeta, wall, wallMeta, roof, roofMeta);
		//buildLayer22(world, x, y, z, main, mainMeta, secondary, secondaryMeta, third, thirdMeta, floor, floorMeta, pane, paneMeta, stairs, stairsMeta, slab, slabMeta, wall, wallMeta, roof, roofMeta);
		//buildLayer22(world, x, y, z, main, mainMeta, secondary, secondaryMeta, third, thirdMeta, floor, floorMeta, pane, paneMeta, stairs, stairsMeta, slab, slabMeta, wall, wallMeta, roof, roofMeta);
		//buildLayer22(world, x, y, z, main, mainMeta, secondary, secondaryMeta, third, thirdMeta, floor, floorMeta, pane, paneMeta, stairs, stairsMeta, slab, slabMeta, wall, wallMeta, roof, roofMeta);

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
		//		world.setBlock(x-10, y+2, z-6, stairs, 0, 2);
		//		world.setBlock(x-8, y+2, z-6, stairs, 1, 2);
		//		world.setBlock(x-6, y+2, z-6, stairs, 2, 2);
		//		world.setBlock(x-4, y+2, z-6, stairs, 3, 2);
		//		world.setBlock(x-2, y+2, z-6, stairs, 4, 2);
		//		world.setBlock(x, y+2, z-6, stairs, 5, 2);
		//		world.setBlock(x+2, y+2, z-6, stairs, 6, 2);
		//		world.setBlock(x+4, y+2, z-6, stairs, 7, 2);
		//		world.setBlock(x+6, y+2, z-6, stairs, 8, 2);
		//		world.setBlock(x+8, y+2, z-6, stairs, 9, 2);
		//		world.setBlock(x+10, y+2, z-6, stairs, 10, 2);
		//		world.setBlock(x+12, y+2, z-6, stairs, 11, 2);
		//		world.setBlock(x+14, y+2, z-6, stairs, 12, 2);
		//		world.setBlock(x+16, y+2, z-6, stairs, 13, 2);
		//		world.setBlock(x+18, y+2, z-6, stairs, 14, 2);
		//		world.setBlock(x+20, y+2, z-6, stairs, 15, 2);
	}

	private static void buildLayer2(World world, int x, int y, int z, Block main, int mainMeta, Block secondary, int secondaryMeta, Block third, int thirdMeta, Block floor, int floorMeta, Block pane, int paneMeta, Block stairs, int stairsMeta, Block slab, int slabMeta, Block wall, int wallMeta, Block roof, int roofMeta)
	{
		BuildHelper.build(world, x-9, y+1, z+2, main, mainMeta, 1, 1, 11);
		BuildHelper.build(world, x-9, y+1, z-2, main, mainMeta, 1, 1, 11);
		BuildHelper.build(world, x+2, y+1, z-4, main, mainMeta, 1, 1, 8);
		BuildHelper.build(world, x+11, y+1, z-2, main, mainMeta, 5, 1, 1);
		BuildHelper.build(world, x+2, y+1, z+4, main, mainMeta, 1, 1, 3);
		BuildHelper.build(world, x+7, y+1, z+4, main, mainMeta, 1, 1, 3);
		BuildHelper.build(world, x+1, y+1, z+3, main, mainMeta, 1, 1, 2);
		BuildHelper.build(world, x+9, y+1, z+3, main, mainMeta, 1, 1, 2);
		BuildHelper.build(world, x+1, y+1, z-3, main, mainMeta, 1, 1, 2);
		BuildHelper.build(world, x+9, y+1, z-3, main, mainMeta, 1, 1, 2);


		world.setBlock(x-11, y+1, z, main, mainMeta, 2);
		world.setBlock(x-10, y+1, z+1, main, mainMeta, 2);
		world.setBlock(x-10, y+1, z, Blocks.torch, 0, 2);
		world.setBlock(x-10, y+1, z-1, main, mainMeta, 2);

		world.setBlock(x-9, y+1, z+1, Blocks.torch, 0, 2);
		world.setBlock(x-9, y+1, z, ToeBlocks.beam, 0, 2);
		world.setBlock(x-9, y+1, z-1, Blocks.torch, 0, 2);

		world.setBlock(x-8, y+1, z+1, main, mainMeta, 2);
		world.setBlock(x-8, y+1, z-1, main, mainMeta, 2);

		world.setBlock(x+3, y+1, z+5, main, mainMeta, 2);
		world.setBlock(x+8, y+1, z+5, main, mainMeta, 2);

		world.setBlock(x+10, y+1, z+2, main, mainMeta, 2);
		world.setBlock(x+10, y+1, z-2, main, mainMeta, 2);

		world.setBlock(x, y+1, z-1, main, mainMeta, 2);
		world.setBlock(x, y+1, z+1, main, mainMeta, 2);
	}

	private static void buildLayer3(World world, int x, int y, int z, Block main, int mainMeta, Block secondary, int secondaryMeta, Block third, int thirdMeta, Block floor, int floorMeta, Block pane, int paneMeta, Block stairs, int stairsMeta, Block slab, int slabMeta, Block wall, int wallMeta, Block roof, int roofMeta)
	{
		BuildHelper.build(world, x-9, y+2, z+2, main, mainMeta, 1, 1, 11);
		BuildHelper.build(world, x-9, y+2, z-2, main, mainMeta, 1, 1, 11);
		BuildHelper.build(world, x+2, y+2, z-4, main, mainMeta, 1, 1, 8);
		BuildHelper.build(world, x+11, y+2, z-2, main, mainMeta, 5, 1, 1);
		BuildHelper.build(world, x+2, y+2, z+4, main, mainMeta, 1, 1, 3);
		BuildHelper.build(world, x+7, y+2, z+4, main, mainMeta, 1, 1, 3);
		BuildHelper.build(world, x+1, y+2, z+3, main, mainMeta, 1, 1, 2);
		BuildHelper.build(world, x+9, y+2, z+3, main, mainMeta, 1, 1, 2);
		BuildHelper.build(world, x+1, y+2, z-3, main, mainMeta, 1, 1, 2);
		BuildHelper.build(world, x+9, y+2, z-3, main, mainMeta, 1, 1, 2);

		world.setBlock(x-11, y+2, z, main, mainMeta, 2);
		world.setBlock(x-10, y+2, z+1, main, mainMeta, 2);
		world.setBlock(x-10, y+2, z-1, main, mainMeta, 2);

		world.setBlock(x-9, y+2, z, ToeBlocks.beam, 0, 2);

		world.setBlock(x-8, y+2, z+1, main, mainMeta, 2);
		world.setBlock(x-8, y+2, z-1, main, mainMeta, 2);

		world.setBlock(x+3, y+2, z+5, main, mainMeta, 2);
		world.setBlock(x+8, y+2, z+5, main, mainMeta, 2);

		world.setBlock(x+10, y+2, z+2, main, mainMeta, 2);
		world.setBlock(x+10, y+2, z-2, main, mainMeta, 2);

		world.setBlock(x, y+2, z-1, main, mainMeta, 2);
		world.setBlock(x, y+2, z+1, main, mainMeta, 2);

		//Panes
		BuildHelper.build(world, x-5, y+2, z+2, pane, paneMeta, 1, 1, 3);
		BuildHelper.build(world, x+5, y+2, z-4, pane, paneMeta, 1, 1, 2);
		world.setBlock(x+11, y+2, z, pane, paneMeta, 2);
	}

	private static void buildLayer4(World world, int x, int y, int z, Block main, int mainMeta, Block secondary, int secondaryMeta, Block third, int thirdMeta, Block floor, int floorMeta, Block pane, int paneMeta, Block stairs, int stairsMeta, Block slab, int slabMeta, Block wall, int wallMeta, Block roof, int roofMeta)
	{
		BuildHelper.build(world, x-9, y+3, z+2, main, mainMeta, 1, 1, 11);
		BuildHelper.build(world, x-9, y+3, z-2, main, mainMeta, 1, 1, 11);
		BuildHelper.build(world, x+2, y+3, z-4, main, mainMeta, 1, 1, 8);
		BuildHelper.build(world, x+11, y+3, z-2, main, mainMeta, 5, 1, 1);
		BuildHelper.build(world, x+2, y+3, z+4, main, mainMeta, 1, 1, 3);
		BuildHelper.build(world, x+7, y+3, z+4, main, mainMeta, 1, 1, 3);
		BuildHelper.build(world, x+1, y+3, z+3, main, mainMeta, 1, 1, 2);
		BuildHelper.build(world, x+9, y+3, z+3, main, mainMeta, 1, 1, 2);
		BuildHelper.build(world, x+1, y+3, z-3, main, mainMeta, 1, 1, 2);
		BuildHelper.build(world, x+9, y+3, z-3, main, mainMeta, 1, 1, 2);

		world.setBlock(x-11, y+3, z, main, mainMeta, 2);
		world.setBlock(x-10, y+3, z+1, main, mainMeta, 2);
		world.setBlock(x-10, y+3, z-1, main, mainMeta, 2);

		world.setBlock(x-9, y+3, z, ToeBlocks.beam, 0, 2);

		world.setBlock(x-8, y+3, z+1, main, mainMeta, 2);
		world.setBlock(x-8, y+3, z-1, main, mainMeta, 2);

		world.setBlock(x+3, y+3, z+5, main, mainMeta, 2);
		world.setBlock(x+8, y+3, z+5, main, mainMeta, 2);

		world.setBlock(x+10, y+3, z+2, main, mainMeta, 2);
		world.setBlock(x+10, y+3, z-2, main, mainMeta, 2);

		world.setBlock(x, y+3, z-1, main, mainMeta, 2);
		world.setBlock(x, y+3, z+1, main, mainMeta, 2);

		world.setBlock(x, y+3, z, main, mainMeta, 2);

		world.setBlock(x-7, y+3, z, main, mainMeta, 2);

		//Torch
		world.setBlock(x-6, y+3, z, Blocks.torch, 0, 2);

		//Panes
		BuildHelper.build(world, x-5, y+3, z+2, pane, paneMeta, 1, 1, 3);
		BuildHelper.build(world, x+5, y+3, z-4, pane, paneMeta, 1, 1, 2);
		world.setBlock(x+11, y+3, z, pane, paneMeta, 2);
	}

	private static void buildLayer5(World world, int x, int y, int z, Block main, int mainMeta, Block secondary, int secondaryMeta, Block third, int thirdMeta, Block floor, int floorMeta, Block pane, int paneMeta, Block stairs, int stairsMeta, Block slab, int slabMeta, Block wall, int wallMeta, Block roof, int roofMeta)
	{
		BuildHelper.build(world, x-9, y+4, z+2, main, mainMeta, 1, 1, 11);
		BuildHelper.build(world, x-9, y+4, z-2, main, mainMeta, 1, 1, 11);
		BuildHelper.build(world, x+2, y+4, z-4, main, mainMeta, 1, 1, 8);
		BuildHelper.build(world, x+11, y+4, z-2, main, mainMeta, 5, 1, 1);
		BuildHelper.build(world, x+2, y+4, z+4, main, mainMeta, 1, 1, 3);
		BuildHelper.build(world, x+7, y+4, z+4, main, mainMeta, 1, 1, 3);
		BuildHelper.build(world, x+1, y+4, z+3, main, mainMeta, 1, 1, 2);
		BuildHelper.build(world, x+9, y+4, z+3, main, mainMeta, 1, 1, 2);
		BuildHelper.build(world, x+1, y+4, z-3, main, mainMeta, 1, 1, 2);
		BuildHelper.build(world, x+9, y+4, z-3, main, mainMeta, 1, 1, 2);

		world.setBlock(x-11, y+4, z, main, mainMeta, 2);
		world.setBlock(x-10, y+4, z+1, main, mainMeta, 2);
		world.setBlock(x-10, y+4, z-1, main, mainMeta, 2);

		world.setBlock(x-9, y+4, z, ToeBlocks.beam, 0, 2);

		world.setBlock(x-8, y+4, z+1, main, mainMeta, 2);
		world.setBlock(x-8, y+4, z-1, main, mainMeta, 2);

		world.setBlock(x+3, y+4, z+5, main, mainMeta, 2);
		world.setBlock(x+8, y+4, z+5, main, mainMeta, 2);

		world.setBlock(x+10, y+4, z+2, main, mainMeta, 2);
		world.setBlock(x+10, y+4, z-2, main, mainMeta, 2);

		world.setBlock(x, y+4, z-1, main, mainMeta, 2);
		world.setBlock(x, y+4, z+1, main, mainMeta, 2);

		world.setBlock(x, y+4, z, main, mainMeta, 2);

		world.setBlock(x-7, y+4, z, main, mainMeta, 2);

		//Panes
		BuildHelper.build(world, x-5, y+4, z+2, pane, paneMeta, 1, 1, 3);
		BuildHelper.build(world, x+5, y+4, z-4, pane, paneMeta, 1, 1, 2);
		world.setBlock(x+11, y+4, z, pane, paneMeta, 2);
	}

	private static void buildLayer6(World world, int x, int y, int z, Block main, int mainMeta, Block secondary, int secondaryMeta, Block third, int thirdMeta, Block floor, int floorMeta, Block pane, int paneMeta, Block stairs, int stairsMeta, Block slab, int slabMeta, Block wall, int wallMeta, Block roof, int roofMeta)
	{
		BuildHelper.build(world, x-9, y+5, z+2, main, mainMeta, 1, 1, 11);
		BuildHelper.build(world, x-9, y+5, z-2, main, mainMeta, 1, 1, 11);
		BuildHelper.build(world, x+2, y+5, z-4, main, mainMeta, 1, 1, 8);
		BuildHelper.build(world, x+11, y+5, z-2, main, mainMeta, 5, 1, 1);
		BuildHelper.build(world, x+2, y+5, z+4, main, mainMeta, 1, 1, 3);
		BuildHelper.build(world, x+7, y+5, z+4, main, mainMeta, 1, 1, 3);
		BuildHelper.build(world, x+1, y+5, z+3, main, mainMeta, 1, 1, 2);
		BuildHelper.build(world, x+9, y+5, z+3, main, mainMeta, 1, 1, 2);
		BuildHelper.build(world, x+1, y+5, z-3, main, mainMeta, 1, 1, 2);
		BuildHelper.build(world, x+9, y+5, z-3, main, mainMeta, 1, 1, 2);

		BuildHelper.build(world, x+5, y+5, z+4, main, mainMeta, 1, 1, 2);

		world.setBlock(x-11, y+5, z, main, mainMeta, 2);
		world.setBlock(x-10, y+5, z+1, main, mainMeta, 2);
		world.setBlock(x-10, y+5, z-1, main, mainMeta, 2);

		world.setBlock(x-9, y+5, z, ToeBlocks.beam, 0, 2);

		world.setBlock(x-8, y+5, z+1, main, mainMeta, 2);
		world.setBlock(x-8, y+5, z-1, main, mainMeta, 2);

		//Entrance Torch
		world.setBlock(x+3, y+5, z+5, Blocks.torch, 0, 2);
		world.setBlock(x+8, y+5, z+5, Blocks.torch, 0, 2);

		world.setBlock(x+10, y+5, z+2, main, mainMeta, 2);
		world.setBlock(x+10, y+5, z-2, main, mainMeta, 2);

		world.setBlock(x, y+5, z-1, main, mainMeta, 2);
		world.setBlock(x, y+5, z+1, main, mainMeta, 2);

		world.setBlock(x, y+5, z, main, mainMeta, 2);

		world.setBlock(x-7, y+5, z, main, mainMeta, 2);

		world.setBlock(x, y+5, z+2, third, thirdMeta, 2);
		world.setBlock(x, y+5, z-2, third, thirdMeta, 2);

		//Inside Torch
		world.setBlock(x+2, y+5, z-2, Blocks.torch, 0, 2);
		world.setBlock(x+2, y+5, z+2, Blocks.torch, 0, 2);
		world.setBlock(x+9, y+5, z-2, Blocks.torch, 0, 2);
		world.setBlock(x+9, y+5, z+2, Blocks.torch, 0, 2);

		//Panes
		BuildHelper.build(world, x-5, y+5, z+2, pane, paneMeta, 1, 1, 3);
	}

	private static void buildLayer7(World world, int x, int y, int z, Block main, int mainMeta, Block secondary, int secondaryMeta, Block third, int thirdMeta, Block floor, int floorMeta, Block pane, int paneMeta, Block stairs, int stairsMeta, Block slab, int slabMeta, Block wall, int wallMeta, Block roof, int roofMeta)
	{
		BuildHelper.build(world, x-9, y+6, z+2, main, mainMeta, 1, 1, 11);
		BuildHelper.build(world, x-9, y+6, z-2, main, mainMeta, 1, 1, 11);
		BuildHelper.build(world, x+2, y+6, z-4, main, mainMeta, 1, 1, 8);
		BuildHelper.build(world, x+11, y+6, z-2, main, mainMeta, 5, 1, 1);
		BuildHelper.build(world, x+2, y+6, z+4, main, mainMeta, 1, 1, 3);
		BuildHelper.build(world, x+7, y+6, z+4, main, mainMeta, 1, 1, 3);
		BuildHelper.build(world, x+1, y+6, z+3, main, mainMeta, 1, 1, 2);
		BuildHelper.build(world, x+9, y+6, z+3, main, mainMeta, 1, 1, 2);
		BuildHelper.build(world, x+1, y+6, z-3, main, mainMeta, 1, 1, 2);
		BuildHelper.build(world, x+9, y+6, z-3, main, mainMeta, 1, 1, 2);
		BuildHelper.build(world, x+5, y+6, z+4, main, mainMeta, 1, 1, 2);

		BuildHelper.build(world, x+1, y+6, z-1, floor, floorMeta, 3, 1, 1);
		BuildHelper.build(world, x+2, y+6, z-2, floor, floorMeta, 5, 1, 1);
		BuildHelper.build(world, x+3, y+6, z-3, floor, floorMeta, 7, 1, 6);
		BuildHelper.build(world, x+10, y+6, z-1, floor, floorMeta, 3, 1, 1);
		BuildHelper.build(world, x+9, y+6, z-2, floor, floorMeta, 5, 1, 1);

		BuildHelper.build(world, x+2, y+6, z+5, main, mainMeta, 1, 1, 8);
		BuildHelper.build(world, x+2, y+6, z-5, main, mainMeta, 1, 1, 8);

		BuildHelper.build(world, x+12, y+6, z-2, main, mainMeta, 5, 1, 1);

		//Stairs
		BuildHelper.build(world, x+2, y+6, z+6, stairs, 7, 1, 1, 8);
		BuildHelper.build(world, x+2, y+6, z-6, stairs, 6, 1, 1, 8);
		BuildHelper.build(world, x+13, y+6, z-2, stairs, 5, 5, 1, 1);

		BuildHelper.build(world, x, y+6, z+3, stairs, 4, 2, 1, 1);
		BuildHelper.build(world, x+1, y+6, z+4, stairs, 4, 2, 1, 1);

		BuildHelper.build(world, x, y+6, z-4, stairs, 4, 2, 1, 1);
		BuildHelper.build(world, x+1, y+6, z-5, stairs, 4, 2, 1, 1);

		BuildHelper.build(world, x+10, y+6, z+4, stairs, 5, 2, 1, 1);
		BuildHelper.build(world, x+11, y+6, z+3, stairs, 5, 2, 1, 1);

		BuildHelper.build(world, x+10, y+6, z-5, stairs, 5, 2, 1, 1);
		BuildHelper.build(world, x+11, y+6, z-4, stairs, 5, 2, 1, 1);

		world.setBlock(x-11, y+6, z, main, mainMeta, 2);
		world.setBlock(x-10, y+6, z+1, main, mainMeta, 2);
		world.setBlock(x-10, y+6, z-1, main, mainMeta, 2);

		world.setBlock(x-9, y+6, z, ToeBlocks.beam, 0, 2);

		world.setBlock(x-8, y+6, z+1, main, mainMeta, 2);
		world.setBlock(x-8, y+6, z-1, main, mainMeta, 2);

		world.setBlock(x+10, y+6, z+2, main, mainMeta, 2);
		world.setBlock(x+10, y+6, z-2, main, mainMeta, 2);

		world.setBlock(x, y+6, z-1, main, mainMeta, 2);
		world.setBlock(x, y+6, z+1, main, mainMeta, 2);

		world.setBlock(x, y+6, z, main, mainMeta, 2);

		world.setBlock(x-7, y+6, z, main, mainMeta, 2);

		world.setBlock(x-1, y+6, z+2, third, thirdMeta, 2);
		world.setBlock(x-1, y+6, z-2, third, thirdMeta, 2);

		world.setBlock(x-1, y+6, z-1, stairs, 4, 2);
		world.setBlock(x-1, y+6, z, third, thirdMeta, 2);
		world.setBlock(x-1, y+6, z+1, stairs, 4, 2);

		world.setBlock(x+12, y+6, z+3, stairs, 7 , 2);
		world.setBlock(x+12, y+6, z-3, stairs, 6 , 2);

		//Panes
		BuildHelper.build(world, x-5, y+6, z+2, pane, paneMeta, 1, 1, 3);
	}

	private static void buildLayer8(World world, int x, int y, int z, Block main, int mainMeta, Block secondary, int secondaryMeta, Block third, int thirdMeta, Block floor, int floorMeta, Block pane, int paneMeta, Block stairs, int stairsMeta, Block slab, int slabMeta, Block wall, int wallMeta, Block roof, int roofMeta)
	{
		BuildHelper.build(world, x-9, y+7, z+2, main, mainMeta, 1, 1, 9);
		BuildHelper.build(world, x-9, y+7, z-2, main, mainMeta, 1, 1, 9);

		BuildHelper.build(world, x-1, y+7, z-2, secondary, secondaryMeta, 5, 1, 1);

		//Main Tower
		BuildHelper.build(world, x+2, y+7, z-5, secondary, secondaryMeta, 1, 1, 8);
		BuildHelper.build(world, x+2, y+7, z+5, secondary, secondaryMeta, 1, 1, 8);
		BuildHelper.build(world, x+12, y+7, z-2, secondary, secondaryMeta, 5, 1, 1);
		
		BuildHelper.build(world, x+5, y+7, z-4, main, mainMeta, 1, 17, 1);
		BuildHelper.build(world, x+6, y+7, z-4, main, mainMeta, 1, 17, 1);
		
		BuildHelper.build(world, x+5, y+7, z-3, Blocks.ladder, 3, 1, 18, 1);
		BuildHelper.build(world, x+6, y+7, z-3, Blocks.ladder, 3, 1, 18, 1);

		//BuildHelper.build(world, x+1, y+7, z+3, main, mainMeta, 1, 1, 2);
		//BuildHelper.build(world, x+9, y+7, z+3, main, mainMeta, 1, 1, 2);
		//BuildHelper.build(world, x+1, y+7, z-3, main, mainMeta, 1, 1, 2);
		//BuildHelper.build(world, x+9, y+7, z-3, main, mainMeta, 1, 1, 2);
		//BuildHelper.build(world, x+5, y+7, z+4, main, mainMeta, 1, 1, 2);

		//

		world.setBlock(x-11, y+7, z, main, mainMeta, 2);
		world.setBlock(x-10, y+7, z+1, main, mainMeta, 2);
		world.setBlock(x-10, y+7, z-1, main, mainMeta, 2);

		world.setBlock(x-9, y+7, z, ToeBlocks.beam, 0, 2);

		world.setBlock(x-8, y+7, z+1, main, mainMeta, 2);
		world.setBlock(x-8, y+7, z-1, main, mainMeta, 2);

		//world.setBlock(x, y+7, z-1, main, mainMeta, 2);
		//world.setBlock(x, y+7, z+1, main, mainMeta, 2);

		//world.setBlock(x, y+7, z, main, mainMeta, 2);

		world.setBlock(x-7, y+7, z, main, mainMeta, 2);

		//world.setBlock(x, y+7, z+2, third, thirdMeta, 2);
		//world.setBlock(x, y+7, z-2, third, thirdMeta, 2);

		world.setBlock(x-2, y+7, z-1, stairs, 4, 2);
		world.setBlock(x-2, y+7, z, third, thirdMeta, 2);
		world.setBlock(x-2, y+7, z+1, stairs, 4, 2);
		//
		world.setBlock(x-1, y+7, z, stairs, 1, 2);

		//
		world.setBlock(x, y+7, z-3, secondary, secondaryMeta, 2);
		world.setBlock(x, y+7, z+3, secondary, secondaryMeta, 2);
		world.setBlock(x+1, y+7, z-4, secondary, secondaryMeta, 2);
		world.setBlock(x+1, y+7, z+4, secondary, secondaryMeta, 2);

		world.setBlock(x+11, y+7, z-3, secondary, secondaryMeta, 2);
		world.setBlock(x+11, y+7, z+3, secondary, secondaryMeta, 2);
		world.setBlock(x+10, y+7, z-4, secondary, secondaryMeta, 2);
		world.setBlock(x+10, y+7, z+4, secondary, secondaryMeta, 2);

		world.setBlock(x-2, y+7, z-2, third, thirdMeta, 2);
		world.setBlock(x-2, y+7, z+2, third, thirdMeta, 2);

		//Side Stairs
		world.setBlock(x-1, y+7, z-3, stairs, 4, 2);
		world.setBlock(x-1, y+7, z+3, stairs, 4, 2);

		//Panes
		BuildHelper.build(world, x-5, y+7, z+2, pane, paneMeta, 1, 1, 3);
		
		//Sofa
		world.setBlock(x+3, y+7, z+3, Blocks.log, 1, 2);
		world.setBlock(x+3, y+8, z+3, Blocks.wooden_slab, 5, 2);
		
		BuildHelper.build(world, x+4, y+7, z+3, Blocks.dark_oak_stairs, 2, 1, 1, 4);
		
		world.setBlock(x+8, y+7, z+3, Blocks.log, 1, 2);
		world.setBlock(x+8, y+8, z+3, Blocks.wooden_slab, 5, 2);
	}

	private static void buildLayer9(World world, int x, int y, int z, Block main, int mainMeta, Block secondary, int secondaryMeta, Block third, int thirdMeta, Block floor, int floorMeta, Block pane, int paneMeta, Block stairs, int stairsMeta, Block slab, int slabMeta, Block wall, int wallMeta, Block roof, int roofMeta)
	{
		BuildHelper.build(world, x-9, y+8, z+2, main, mainMeta, 1, 1, 6);
		BuildHelper.build(world, x-9, y+8, z-2, main, mainMeta, 1, 1, 6);

		BuildHelper.build(world, x-1, y+8, z-3, main, mainMeta, 7, 1, 1);

		BuildHelper.build(world, x-2, y+8, z-2, main, mainMeta, 5, 1, 1);

		world.setBlock(x-1, y+8, z, Blocks.air, 0, 2);

		//BuildHelper.build(world, x-1, y+8, z-1, secondary, secondaryMeta, 3, 1, 1);

		//Main Tower
		BuildHelper.build(world, x+2, y+8, z-5, main, mainMeta, 1, 1, 8);
		BuildHelper.build(world, x+2, y+8, z+5, main, mainMeta, 1, 1, 8);
		BuildHelper.build(world, x+12, y+8, z-2, main, mainMeta, 5, 1, 1);

		//BuildHelper.build(world, x+1, y+8, z+3, main, mainMeta, 1, 1, 2);
		//BuildHelper.build(world, x+9, y+8, z+3, main, mainMeta, 1, 1, 2);
		//BuildHelper.build(world, x+1, y+8, z-3, main, mainMeta, 1, 1, 2);
		//BuildHelper.build(world, x+9, y+8, z-3, main, mainMeta, 1, 1, 2);
		//BuildHelper.build(world, x+5, y+8, z+4, main, mainMeta, 1, 1, 2);

		//
		world.setBlock(x-7, y+8, z, main, mainMeta, 2);

		world.setBlock(x-11, y+8, z, main, mainMeta, 2);
		world.setBlock(x-10, y+8, z+1, main, mainMeta, 2);
		world.setBlock(x-10, y+8, z-1, main, mainMeta, 2);

		world.setBlock(x-9, y+8, z, ToeBlocks.beam, 0, 2);

		world.setBlock(x-8, y+8, z+1, main, mainMeta, 2);
		world.setBlock(x-8, y+8, z-1, main, mainMeta, 2);

		//world.setBlock(x, y+8, z-1, main, mainMeta, 2);
		//world.setBlock(x, y+8, z+1, main, mainMeta, 2);

		//world.setBlock(x, y+8, z, main, mainMeta, 2);

		//world.setBlock(x-8, y+8, z, main, mainMeta, 2);

		//world.setBlock(x, y+8, z+2, third, thirdMeta, 2);
		//world.setBlock(x, y+8, z-2, third, thirdMeta, 2);

		//world.setBlock(x-2, y+8, z-1, stairs, 4, 2);
		//world.setBlock(x-2, y+8, z, third, thirdMeta, 2);
		//world.setBlock(x-2, y+8, z+1, stairs, 4, 2);

		world.setBlock(x-3, y+8, z-1, stairs, 4, 2);
		world.setBlock(x-3, y+8, z, third, thirdMeta, 2);
		world.setBlock(x-3, y+8, z+1, stairs, 4, 2);

		//
		world.setBlock(x-2, y+8, z, stairs, 1, 2);

		//
		world.setBlock(x, y+8, z-3, main, mainMeta, 2);
		world.setBlock(x, y+8, z+3, main, mainMeta, 2);
		world.setBlock(x+1, y+8, z-4, main, mainMeta, 2);
		world.setBlock(x+1, y+8, z+4, main, mainMeta, 2);

		world.setBlock(x+11, y+8, z-3, main, mainMeta, 2);
		world.setBlock(x+11, y+8, z+3, main, mainMeta, 2);
		world.setBlock(x+10, y+8, z-4, main, mainMeta, 2);
		world.setBlock(x+10, y+8, z+4, main, mainMeta, 2);

		//Side Stairs
		world.setBlock(x-2, y+8, z-3, stairs, 4, 2);
		world.setBlock(x-2, y+8, z+3, stairs, 4, 2);


		//
		world.setBlock(x-3, y+8, z-2, third, thirdMeta, 2);
		world.setBlock(x-3, y+8, z+2, third, thirdMeta, 2);

		//Panes
		BuildHelper.build(world, x-5, y+8, z+2, pane, paneMeta, 1, 1, 2);
		
		BuildHelper.build(world, x+5, y+8, z+5, pane, paneMeta, 1, 1, 2);
		
		world.setBlock(x+12, y+8, z, pane, paneMeta, 2);
	}

	private static void buildLayer10(World world, int x, int y, int z, Block main, int mainMeta, Block secondary, int secondaryMeta, Block third, int thirdMeta, Block floor, int floorMeta, Block pane, int paneMeta, Block stairs, int stairsMeta, Block slab, int slabMeta, Block wall, int wallMeta, Block roof, int roofMeta)
	{
		BuildHelper.build(world, x-9, y+9, z+2, main, mainMeta, 1, 1, 5);
		BuildHelper.build(world, x-9, y+9, z-2, main, mainMeta, 1, 1, 5);

		BuildHelper.build(world, x-1, y+9, z-3, main, mainMeta, 7, 1, 1);

		BuildHelper.build(world, x-2, y+9, z-2, main, mainMeta, 5, 1, 1);

		BuildHelper.build(world, x-3, y+9, z-2, main, mainMeta, 5, 1, 1);

		world.setBlock(x-1, y+9, z, Blocks.air, 0, 2);
		world.setBlock(x-2, y+9, z, Blocks.air, 0, 2);

		//BuildHelper.build(world, x-1, y+9, z-1, secondary, secondaryMeta, 3, 1, 1);

		//Main Tower
		BuildHelper.build(world, x+2, y+9, z-5, main, mainMeta, 1, 1, 8);
		BuildHelper.build(world, x+2, y+9, z+5, main, mainMeta, 1, 1, 8);
		BuildHelper.build(world, x+12, y+9, z-2, main, mainMeta, 5, 1, 1);

		//BuildHelper.build(world, x+1, y+9, z+3, main, mainMeta, 1, 1, 2);
		//BuildHelper.build(world, x+9, y+9, z+3, main, mainMeta, 1, 1, 2);
		//BuildHelper.build(world, x+1, y+9, z-3, main, mainMeta, 1, 1, 2);
		//BuildHelper.build(world, x+9, y+9, z-3, main, mainMeta, 1, 1, 2);
		//BuildHelper.build(world, x+5, y+9, z+4, main, mainMeta, 1, 1, 2);

		//
		world.setBlock(x-7, y+9, z, main, mainMeta, 2);

		world.setBlock(x-11, y+9, z, main, mainMeta, 2);
		world.setBlock(x-10, y+9, z+1, main, mainMeta, 2);
		world.setBlock(x-10, y+9, z-1, main, mainMeta, 2);

		world.setBlock(x-9, y+9, z, ToeBlocks.beam, 0, 2);

		world.setBlock(x-8, y+9, z+1, main, mainMeta, 2);
		world.setBlock(x-8, y+9, z-1, main, mainMeta, 2);

		//world.setBlock(x, y+9, z-1, main, mainMeta, 2);
		//world.setBlock(x, y+9, z+1, main, mainMeta, 2);

		//world.setBlock(x, y+9, z, main, mainMeta, 2);

		//world.setBlock(x-8, y+9, z, main, mainMeta, 2);

		//world.setBlock(x, y+9, z+2, third, thirdMeta, 2);
		//world.setBlock(x, y+9, z-2, third, thirdMeta, 2);

		//world.setBlock(x-2, y+9, z-1, stairs, 4, 2);
		//world.setBlock(x-2, y+9, z, third, thirdMeta, 2);
		//world.setBlock(x-2, y+9, z+1, stairs, 4, 2);

		world.setBlock(x-4, y+9, z-1, stairs, 4, 2);
		world.setBlock(x-4, y+9, z, third, thirdMeta, 2);
		world.setBlock(x-4, y+9, z+1, stairs, 4, 2);

		//
		world.setBlock(x-3, y+9, z, stairs, 1, 2);

		//
		world.setBlock(x, y+9, z-3, main, mainMeta, 2);
		world.setBlock(x, y+9, z+3, main, mainMeta, 2);
		world.setBlock(x+1, y+9, z-4, main, mainMeta, 2);
		world.setBlock(x+1, y+9, z+4, main, mainMeta, 2);

		world.setBlock(x+11, y+9, z-3, main, mainMeta, 2);
		world.setBlock(x+11, y+9, z+3, main, mainMeta, 2);
		world.setBlock(x+10, y+9, z-4, main, mainMeta, 2);
		world.setBlock(x+10, y+9, z+4, main, mainMeta, 2);

		//Side Stairs
		world.setBlock(x-3, y+9, z-3, stairs, 4, 2);
		world.setBlock(x-3, y+9, z+3, stairs, 4, 2);


		//
		world.setBlock(x-4, y+9, z-2, third, thirdMeta, 2);
		world.setBlock(x-4, y+9, z+2, third, thirdMeta, 2);

		world.setBlock(x-2, y+9, z-3, main, mainMeta, 2);
		world.setBlock(x-2, y+9, z+3, main, mainMeta, 2);

		//Panes
		BuildHelper.build(world, x-5, y+9, z+2, pane, paneMeta, 1, 1, 1);
		
		BuildHelper.build(world, x+5, y+9, z+5, pane, paneMeta, 1, 1, 2);
		
		world.setBlock(x+12, y+9, z, pane, paneMeta, 2);
	}

	private static void buildLayer11(World world, int x, int y, int z, Block main, int mainMeta, Block secondary, int secondaryMeta, Block third, int thirdMeta, Block floor, int floorMeta, Block pane, int paneMeta, Block stairs, int stairsMeta, Block slab, int slabMeta, Block wall, int wallMeta, Block roof, int roofMeta)
	{
		BuildHelper.build(world, x-9, y+10, z+2, main, mainMeta, 1, 1, 5);
		BuildHelper.build(world, x-9, y+10, z-2, main, mainMeta, 1, 1, 5);

		BuildHelper.build(world, x-1, y+10, z-3, main, mainMeta, 7, 1, 1);

		BuildHelper.build(world, x-2, y+10, z-2, main, mainMeta, 5, 1, 1);

		BuildHelper.build(world, x-3, y+10, z-2, main, mainMeta, 5, 1, 1);

		BuildHelper.build(world, x-4, y+10, z-2, main, mainMeta, 5, 1, 1);

		BuildHelper.build(world, x-7, y+10, z-1, main, mainMeta, 3, 1, 1);
		BuildHelper.build(world, x-6, y+10, z-1, main, mainMeta, 3, 1, 1);

		//Three chiseled stone brick lines
		BuildHelper.build(world, x-8, y+10, z, third, thirdMeta, 1, 1, 4);
		BuildHelper.build(world, x-8, y+10, z-2, third, thirdMeta, 1, 1, 4);
		BuildHelper.build(world, x-8, y+10, z+2, third, thirdMeta, 1, 1, 4);

		BuildHelper.build(world, x-9, y+10, z-3, stairs, 6, 1, 1, 5);
		BuildHelper.build(world, x-9, y+10, z+3, stairs, 7, 1, 1, 5);

		world.setBlock(x-1, y+10, z, Blocks.air, 0, 2);
		world.setBlock(x-2, y+10, z, Blocks.air, 0, 2);
		world.setBlock(x-3, y+10, z, Blocks.air, 0, 2);

		//BuildHelper.build(world, x-1, y+10, z-1, secondary, secondaryMeta, 3, 1, 1);

		//Main Tower
		BuildHelper.build(world, x+2, y+10, z-5, main, mainMeta, 1, 1, 8);
		BuildHelper.build(world, x+2, y+10, z+5, main, mainMeta, 1, 1, 8);
		BuildHelper.build(world, x+12, y+10, z-2, main, mainMeta, 5, 1, 1);

		//BuildHelper.build(world, x+1, y+10, z+3, main, mainMeta, 1, 1, 2);
		//BuildHelper.build(world, x+9, y+10, z+3, main, mainMeta, 1, 1, 2);
		//BuildHelper.build(world, x+1, y+10, z-3, main, mainMeta, 1, 1, 2);
		//BuildHelper.build(world, x+9, y+10, z-3, main, mainMeta, 1, 1, 2);
		//BuildHelper.build(world, x+5, y+10, z+4, main, mainMeta, 1, 1, 2);

		//
		world.setBlock(x-7, y+10, z, third, thirdMeta, 2);

		world.setBlock(x-11, y+10, z, main, mainMeta, 2);
		world.setBlock(x-10, y+10, z+1, main, mainMeta, 2);
		world.setBlock(x-10, y+10, z-1, main, mainMeta, 2);

		world.setBlock(x-9, y+10, z, ToeBlocks.beam, 0, 2);

		//Chiseled Blocks around beam
		world.setBlock(x-9, y+10, z-1, third, thirdMeta, 2);
		world.setBlock(x-9, y+10, z+1, third, thirdMeta, 2);
		world.setBlock(x-10, y+10, z, third, thirdMeta, 2);


		world.setBlock(x-8, y+10, z+1, main, mainMeta, 2);
		world.setBlock(x-8, y+10, z-1, main, mainMeta, 2);

		//world.setBlock(x, y+10, z-1, main, mainMeta, 2);
		//world.setBlock(x, y+10, z+1, main, mainMeta, 2);

		//world.setBlock(x, y+10, z, main, mainMeta, 2);

		world.setBlock(x-8, y+10, z, third, thirdMeta, 2);

		//world.setBlock(x, y+10, z+2, third, thirdMeta, 2);
		//world.setBlock(x, y+10, z-2, third, thirdMeta, 2);

		//world.setBlock(x-2, y+10, z-1, stairs, 4, 2);
		//world.setBlock(x-2, y+10, z, third, thirdMeta, 2);
		//world.setBlock(x-2, y+10, z+1, stairs, 4, 2);

		world.setBlock(x-5, y+10, z-1, stairs, 4, 2);
		world.setBlock(x-5, y+10, z, third, thirdMeta, 2);
		world.setBlock(x-5, y+10, z+1, stairs, 4, 2);

		//
		world.setBlock(x-4, y+10, z, stairs, 1, 2);

		//
		world.setBlock(x, y+10, z-3, main, mainMeta, 2);
		world.setBlock(x, y+10, z+3, main, mainMeta, 2);
		world.setBlock(x+1, y+10, z-4, main, mainMeta, 2);
		world.setBlock(x+1, y+10, z+4, main, mainMeta, 2);

		world.setBlock(x+11, y+10, z-3, main, mainMeta, 2);
		world.setBlock(x+11, y+10, z+3, main, mainMeta, 2);
		world.setBlock(x+10, y+10, z-4, main, mainMeta, 2);
		world.setBlock(x+10, y+10, z+4, main, mainMeta, 2);

		//Side Stairs
		world.setBlock(x-4, y+10, z-3, stairs, 4, 2);
		world.setBlock(x-4, y+10, z+3, stairs, 4, 2);


		//Entrance to second tower base
		world.setBlock(x-5, y+10, z-2, third, thirdMeta, 2);
		world.setBlock(x-5, y+10, z+2, third, thirdMeta, 2);

		world.setBlock(x-3, y+10, z-3, main, mainMeta, 2);
		world.setBlock(x-3, y+10, z+3, main, mainMeta, 2);

		world.setBlock(x-2, y+10, z-3, main, mainMeta, 2);
		world.setBlock(x-2, y+10, z+3, main, mainMeta, 2);

		//Stairs on side of second tower
		world.setBlock(x-10, y+10, z-2, stairs, 4, 2);
		world.setBlock(x-10, y+10, z+2, stairs, 4, 2);
		world.setBlock(x-11, y+10, z-1, stairs, 4, 2);
		world.setBlock(x-11, y+10, z+1, stairs, 4, 2);
		world.setBlock(x-12, y+10, z, stairs, 4, 2);
		
		//Panes
		world.setBlock(x+12, y+10, z, pane, paneMeta, 2);
		
		BuildHelper.build(world, x+5, y+10, z+5, pane, paneMeta, 1, 1, 2);
	}

	private static void buildSecondTowerLayer(World world, int x, int y, int z, Block main, int mainMeta, Block secondary, int secondaryMeta, Block third, int thirdMeta, Block floor, int floorMeta, Block pane, int paneMeta, Block stairs, int stairsMeta, Block slab, int slabMeta, Block wall, int wallMeta, Block roof, int roofMeta)
	{
		//Second Tower
		BuildHelper.build(world, x-8, y+11, z-1, main, mainMeta, 1, 7, 1);
		BuildHelper.build(world, x-8, y+11, z+1, main, mainMeta, 1, 7, 1);
		BuildHelper.build(world, x-9, y+11, z-2, main, mainMeta, 1, 7, 1);
		BuildHelper.build(world, x-9, y+11, z+2, main, mainMeta, 1, 7, 1);
		BuildHelper.build(world, x-10, y+11, z-1, main, mainMeta, 1, 7, 1);
		BuildHelper.build(world, x-10, y+11, z+1, main, mainMeta, 1, 7, 1);
		BuildHelper.build(world, x-11, y+11, z, main, mainMeta, 1, 7, 1);
		BuildHelper.build(world, x-7, y+13, z, main, mainMeta, 1, 5, 1);

		BuildHelper.build(world, x-10, y+18, z-1, main, mainMeta, 3, 1, 3);

		//Second Tower roof
		BuildHelper.build(world, x-11, y+18, z-2, stairs, 0, 5, 1, 1);
		BuildHelper.build(world, x-7, y+18, z-2, stairs, 1, 5, 1, 1);
		BuildHelper.build(world, x-10, y+18, z-2, stairs, 2, 1, 1, 3);
		BuildHelper.build(world, x-10, y+18, z+2, stairs, 3, 1, 1, 3);

		BuildHelper.build(world, x-8, y+19, z-1, stairs, 1, 3, 1, 1);
		BuildHelper.build(world, x-10, y+19, z-1, stairs, 0, 3, 1, 1);

		world.setBlock(x-9, y+19, z-1, stairs, 2, 2);
		world.setBlock(x-9, y+19, z+1, stairs, 3, 2);

		world.setBlock(x-9, y+19, z, main, mainMeta, 2);

		world.setBlock(x-9, y+20, z, slab, slabMeta, 2);
		//-------------------------------------------------------------------------

		world.setBlock(x-7, y+12, z, Blocks.wooden_door, 0, 2);
	}

	private static void buildLayer12(World world, int x, int y, int z, Block main, int mainMeta, Block secondary, int secondaryMeta, Block third, int thirdMeta, Block floor, int floorMeta, Block pane, int paneMeta, Block stairs, int stairsMeta, Block slab, int slabMeta, Block wall, int wallMeta, Block roof, int roofMeta)
	{
		//Main Tower
		BuildHelper.build(world, x+2, y+11, z-5, main, mainMeta, 1, 1, 8);
		BuildHelper.build(world, x+2, y+11, z+5, main, mainMeta, 1, 1, 8);
		BuildHelper.build(world, x+12, y+11, z-2, main, mainMeta, 5, 1, 1);

		BuildHelper.build(world, x-9, y+11, z-3, wall, wallMeta, 1, 1, 9);
		BuildHelper.build(world, x-9, y+11, z+3, wall, wallMeta, 1, 1, 9);

		//
		BuildHelper.build(world, x-1, y+11, z-2, main, mainMeta, 5, 1, 1);

		//
		world.setBlock(x, y+11, z-3, main, mainMeta, 2);
		world.setBlock(x, y+11, z+3, main, mainMeta, 2);
		world.setBlock(x+1, y+11, z-4, main, mainMeta, 2);
		world.setBlock(x+1, y+11, z+4, main, mainMeta, 2);

		world.setBlock(x+11, y+11, z-3, main, mainMeta, 2);
		world.setBlock(x+11, y+11, z+3, main, mainMeta, 2);
		world.setBlock(x+10, y+11, z-4, main, mainMeta, 2);
		world.setBlock(x+10, y+11, z+4, main, mainMeta, 2);

		//Inside Torches
		world.setBlock(x+1, y+11, z-3, Blocks.torch, 0, 2);
		world.setBlock(x+1, y+11, z+3, Blocks.torch, 0, 2);
		world.setBlock(x+10, y+11, z-3, Blocks.torch, 0, 2);
		world.setBlock(x+10, y+11, z+3, Blocks.torch, 0, 2);

		world.setBlock(x+5, y+11, z+4, Blocks.torch, 0, 2);
		world.setBlock(x+4, y+11, z-4, Blocks.torch, 0, 2);
		world.setBlock(x+6, y+11, z+4, Blocks.torch, 0, 2);
		world.setBlock(x+7, y+11, z-4, Blocks.torch, 0, 2);
	}

	private static void buildLayer13(World world, int x, int y, int z, Block main, int mainMeta, Block secondary, int secondaryMeta, Block third, int thirdMeta, Block floor, int floorMeta, Block pane, int paneMeta, Block stairs, int stairsMeta, Block slab, int slabMeta, Block wall, int wallMeta, Block roof, int roofMeta)
	{
		//Main Tower
		BuildHelper.build(world, x+2, y+12, z-5, main, mainMeta, 1, 1, 8);
		BuildHelper.build(world, x+2, y+12, z+5, main, mainMeta, 1, 1, 8);
		BuildHelper.build(world, x+12, y+12, z-2, main, mainMeta, 5, 1, 1);

		//
		BuildHelper.build(world, x-1, y+12, z-2, main, mainMeta, 5, 1, 1);

		//Stairs
		BuildHelper.build(world, x+2, y+12, z+6, stairs, 7, 1, 1, 8);
		BuildHelper.build(world, x+2, y+12, z-6, stairs, 6, 1, 1, 8);
		BuildHelper.build(world, x+13, y+12, z-2, stairs, 5, 5, 1, 1);

		BuildHelper.build(world, x, y+12, z+3, stairs, 4, 2, 1, 1);
		BuildHelper.build(world, x+1, y+12, z+4, stairs, 4, 2, 1, 1);

		BuildHelper.build(world, x, y+12, z-4, stairs, 4, 2, 1, 1);
		BuildHelper.build(world, x+1, y+12, z-5, stairs, 4, 2, 1, 1);

		BuildHelper.build(world, x+10, y+12, z+4, stairs, 5, 2, 1, 1);
		BuildHelper.build(world, x+11, y+12, z+3, stairs, 5, 2, 1, 1);

		BuildHelper.build(world, x+10, y+12, z-5, stairs, 5, 2, 1, 1);
		BuildHelper.build(world, x+11, y+12, z-4, stairs, 5, 2, 1, 1);

		BuildHelper.build(world, x-1, y+12, z-2, main, mainMeta, 5, 1, 1);

		BuildHelper.build(world, x-2, y+12, z-2, stairs, 4, 5, 1, 1);

		//Third Floor
		BuildHelper.build(world, x+1, y+12, z-1, floor, floorMeta, 3, 1, 1);
		BuildHelper.build(world, x+2, y+12, z-2, floor, floorMeta, 5, 1, 1);
		BuildHelper.build(world, x+3, y+12, z-2, floor, floorMeta, 5, 1, 6);
		BuildHelper.build(world, x+10, y+12, z-1, floor, floorMeta, 3, 1, 1);
		BuildHelper.build(world, x+9, y+12, z-2, floor, floorMeta, 5, 1, 1);
		
		BuildHelper.build(world, x+3, y+12, z-3, floor, floorMeta, 1, 1, 2);
		BuildHelper.build(world, x+7, y+12, z-3, floor, floorMeta, 1, 1, 2);
		
		BuildHelper.build(world, x+3, y+12, z+3, floor, floorMeta, 1, 1, 6);

		//Third Floor border
		BuildHelper.build(world, x+2, y+12, z+4, main, mainMeta, 1, 1, 8);
		BuildHelper.build(world, x+2, y+12, z-4, main, mainMeta, 1, 1, 8);
		BuildHelper.build(world, x+11, y+12, z-2, main, mainMeta, 5, 1, 1);
		BuildHelper.build(world, x, y+12, z-2, main, mainMeta, 5, 1, 1);
		BuildHelper.build(world, x+1, y+12, z+3, main, mainMeta, 1, 1, 2);
		BuildHelper.build(world, x+9, y+12, z+3, main, mainMeta, 1, 1, 2);
		BuildHelper.build(world, x+1, y+12, z-3, main, mainMeta, 1, 1, 2);
		BuildHelper.build(world, x+9, y+12, z-3, main, mainMeta, 1, 1, 2);

		world.setBlock(x+1, y+12, z-2, main, mainMeta, 2);
		world.setBlock(x+1, y+12, z+2, main, mainMeta, 2);
		world.setBlock(x+10, y+12, z-2, main, mainMeta, 2);
		world.setBlock(x+10, y+12, z+2, main, mainMeta, 2);

		//
		world.setBlock(x, y+12, z-3, main, mainMeta, 2);
		world.setBlock(x, y+12, z+3, main, mainMeta, 2);
		world.setBlock(x+1, y+12, z-4, main, mainMeta, 2);
		world.setBlock(x+1, y+12, z+4, main, mainMeta, 2);

		world.setBlock(x+11, y+12, z-3, main, mainMeta, 2);
		world.setBlock(x+11, y+12, z+3, main, mainMeta, 2);
		world.setBlock(x+10, y+12, z-4, main, mainMeta, 2);
		world.setBlock(x+10, y+12, z+4, main, mainMeta, 2);

		world.setBlock(x-1, y+12, z-3, stairs, 4, 2);
		world.setBlock(x-1, y+12, z+3, stairs, 4, 2);

		world.setBlock(x+12, y+12, z-3, stairs, 5, 2);
		world.setBlock(x+12, y+12, z+3, stairs, 5, 2);
		
		//Echantment room
		//Layer 1
		BuildHelper.build(world, x+1, y+13, z-1, Blocks.bookshelf, 0, 3, 1, 1);
		BuildHelper.build(world, x+10, y+13, z-1, Blocks.bookshelf, 0, 3, 1, 1);
		BuildHelper.build(world, x+3, y+13, z+3, Blocks.bookshelf, 0, 1, 1, 6);
		
		BuildHelper.build(world, x+3, y+13, z-3, Blocks.bookshelf, 0, 1, 1, 2);
		BuildHelper.build(world, x+7, y+13, z-3, Blocks.bookshelf, 0, 1, 1, 2);
		
		world.setBlock(x+2, y+13, z-2, Blocks.bookshelf, 0, 2);
		world.setBlock(x+2, y+13, z+2, Blocks.bookshelf, 0, 2);
		
		world.setBlock(x+9, y+13, z-2, Blocks.bookshelf, 0, 2);
		world.setBlock(x+9, y+13, z+2, Blocks.bookshelf, 0, 2);
		
		BuildHelper.build(world, x+3, y+13, z-2, Blocks.bookshelf, 0, 1, 2, 1);
		BuildHelper.build(world, x+3, y+13, z+2, Blocks.bookshelf, 0, 1, 2, 1);
		
		BuildHelper.build(world, x+8, y+13, z-2, Blocks.bookshelf, 0, 1, 2, 1);
		BuildHelper.build(world, x+8, y+13, z+2, Blocks.bookshelf, 0, 1, 2, 1);
		
		world.setBlock(x+1, y+13, z-2, Blocks.bookshelf, 0, 2);
		world.setBlock(x+10, y+13, z-2, Blocks.bookshelf, 0, 2);
		
		world.setBlock(x+3, y+13, z, Blocks.enchanting_table, 0, 2);
		world.setBlock(x+8, y+13, z, Blocks.enchanting_table, 0, 2);
		
		//Layer 2
		BuildHelper.build(world, x+1, y+14, z-1, Blocks.bookshelf, 0, 3, 1, 1);
		BuildHelper.build(world, x+10, y+14, z-1, Blocks.bookshelf, 0, 3, 1, 1);
		BuildHelper.build(world, x+3, y+14, z+3, Blocks.bookshelf, 0, 1, 1, 6);

		BuildHelper.build(world, x+3, y+14, z-3, Blocks.bookshelf, 0, 1, 1, 2);
		BuildHelper.build(world, x+7, y+14, z-3, Blocks.bookshelf, 0, 1, 1, 2);

		world.setBlock(x+2, y+14, z-2, Blocks.bookshelf, 0, 2);
		world.setBlock(x+2, y+14, z+2, Blocks.bookshelf, 0, 2);

		world.setBlock(x+9, y+14, z-2, Blocks.bookshelf, 0, 2);
		world.setBlock(x+9, y+14, z+2, Blocks.bookshelf, 0, 2);
		
		//Layer 3
		BuildHelper.build(world, x+1, y+15, z-1, Blocks.bookshelf, 0, 3, 1, 1);
		BuildHelper.build(world, x+10, y+15, z-1, Blocks.bookshelf, 0, 3, 1, 1);
		BuildHelper.build(world, x+3, y+15, z+3, Blocks.bookshelf, 0, 1, 1, 6);

		BuildHelper.build(world, x+3, y+15, z-3, Blocks.bookshelf, 0, 1, 1, 2);
		BuildHelper.build(world, x+7, y+15, z-3, Blocks.bookshelf, 0, 1, 1, 2);

		world.setBlock(x+2, y+15, z-2, Blocks.bookshelf, 0, 2);
		world.setBlock(x+2, y+15, z+2, Blocks.bookshelf, 0, 2);

		world.setBlock(x+9, y+15, z-2, Blocks.bookshelf, 0, 2);
		world.setBlock(x+9, y+15, z+2, Blocks.bookshelf, 0, 2);
		
		//Layer 4
		BuildHelper.build(world, x+1, y+16, z-1, Blocks.bookshelf, 0, 3, 1, 1);
		BuildHelper.build(world, x+10, y+16, z-1, Blocks.bookshelf, 0, 3, 1, 1);
		BuildHelper.build(world, x+3, y+16, z+3, Blocks.bookshelf, 0, 1, 1, 6);

		BuildHelper.build(world, x+3, y+16, z-3, Blocks.bookshelf, 0, 1, 1, 2);
		BuildHelper.build(world, x+7, y+16, z-3, Blocks.bookshelf, 0, 1, 1, 2);

		world.setBlock(x+2, y+16, z-2, Blocks.bookshelf, 0, 2);
		world.setBlock(x+2, y+16, z+2, Blocks.bookshelf, 0, 2);

		world.setBlock(x+9, y+16, z-2, Blocks.bookshelf, 0, 2);
		world.setBlock(x+9, y+16, z+2, Blocks.bookshelf, 0, 2);
		
		//Layer 5
		BuildHelper.build(world, x+1, y+17, z-1, Blocks.bookshelf, 0, 3, 1, 1);
		BuildHelper.build(world, x+10, y+17, z-1, Blocks.bookshelf, 0, 3, 1, 1);
		BuildHelper.build(world, x+3, y+17, z+3, Blocks.bookshelf, 0, 1, 1, 6);

		BuildHelper.build(world, x+3, y+17, z-3, Blocks.bookshelf, 0, 1, 1, 2);
		BuildHelper.build(world, x+7, y+17, z-3, Blocks.bookshelf, 0, 1, 1, 2);

		world.setBlock(x+2, y+17, z-2, Blocks.bookshelf, 0, 2);
		world.setBlock(x+2, y+17, z+2, Blocks.bookshelf, 0, 2);

		world.setBlock(x+9, y+17, z-2, Blocks.bookshelf, 0, 2);
		world.setBlock(x+9, y+17, z+2, Blocks.bookshelf, 0, 2);
		
		//Torches
		world.setBlock(x+2, y+17, z, Blocks.torch, 0, 2);
		world.setBlock(x+9, y+17, z, Blocks.torch, 0, 2);
		
		BuildHelper.build(world, x+5, y+17, z+2, Blocks.torch, 0, 1, 1, 2);
	}

	private static void buildLayer14(World world, int x, int y, int z, Block main, int mainMeta, Block secondary, int secondaryMeta, Block third, int thirdMeta, Block floor, int floorMeta, Block pane, int paneMeta, Block stairs, int stairsMeta, Block slab, int slabMeta, Block wall, int wallMeta, Block roof, int roofMeta)
	{
		//Main Tower
		BuildHelper.build(world, x+2, y+13, z-5, secondary, secondaryMeta, 1, 1, 8);
		BuildHelper.build(world, x+2, y+13, z+5, secondary, secondaryMeta, 1, 1, 8);
		BuildHelper.build(world, x+12, y+13, z-2, secondary, secondaryMeta, 5, 1, 1);

		//
		BuildHelper.build(world, x-1, y+13, z-2, secondary, secondaryMeta, 5, 1, 1);

		//
		world.setBlock(x, y+13, z-3, secondary, secondaryMeta, 2);
		world.setBlock(x, y+13, z+3, secondary, secondaryMeta, 2);
		world.setBlock(x+1, y+13, z-4, secondary, secondaryMeta, 2);
		world.setBlock(x+1, y+13, z+4, secondary, secondaryMeta, 2);

		world.setBlock(x+11, y+13, z-3, secondary, secondaryMeta, 2);
		world.setBlock(x+11, y+13, z+3, secondary, secondaryMeta, 2);
		world.setBlock(x+10, y+13, z-4, secondary, secondaryMeta, 2);
		world.setBlock(x+10, y+13, z+4, secondary, secondaryMeta, 2);
	}

	private static void buildLayer15(World world, int x, int y, int z, Block main, int mainMeta, Block secondary, int secondaryMeta, Block third, int thirdMeta, Block floor, int floorMeta, Block pane, int paneMeta, Block stairs, int stairsMeta, Block slab, int slabMeta, Block wall, int wallMeta, Block roof, int roofMeta)
	{
		//Main Tower
		BuildHelper.build(world, x+2, y+14, z-5, main, mainMeta, 1, 1, 8);
		BuildHelper.build(world, x+2, y+14, z+5, main, mainMeta, 1, 1, 8);
		BuildHelper.build(world, x+12, y+14, z-2, main, mainMeta, 5, 1, 1);

		//
		BuildHelper.build(world, x-1, y+14, z-2, main, mainMeta, 5, 1, 1);

		//
		world.setBlock(x, y+14, z-3, main, mainMeta, 2);
		world.setBlock(x, y+14, z+3, main, mainMeta, 2);
		world.setBlock(x+1, y+14, z-4, main, mainMeta, 2);
		world.setBlock(x+1, y+14, z+4, main, mainMeta, 2);

		world.setBlock(x+11, y+14, z-3, main, mainMeta, 2);
		world.setBlock(x+11, y+14, z+3, main, mainMeta, 2);
		world.setBlock(x+10, y+14, z-4, main, mainMeta, 2);
		world.setBlock(x+10, y+14, z+4, main, mainMeta, 2);
		
		//Panes
		world.setBlock(x+12, y+14, z, pane, paneMeta, 2);
		
		world.setBlock(x-1, y+14, z, pane, paneMeta, 2);
		
		BuildHelper.build(world, x+5, y+14, z+5, pane, paneMeta, 1, 1, 2);
	}

	private static void buildLayer16(World world, int x, int y, int z, Block main, int mainMeta, Block secondary, int secondaryMeta, Block third, int thirdMeta, Block floor, int floorMeta, Block pane, int paneMeta, Block stairs, int stairsMeta, Block slab, int slabMeta, Block wall, int wallMeta, Block roof, int roofMeta)
	{
		//Main Tower
		BuildHelper.build(world, x+2, y+15, z-5, main, mainMeta, 1, 1, 8);
		BuildHelper.build(world, x+2, y+15, z+5, main, mainMeta, 1, 1, 8);
		BuildHelper.build(world, x+12, y+15, z-2, main, mainMeta, 5, 1, 1);

		//
		BuildHelper.build(world, x-1, y+15, z-2, main, mainMeta, 5, 1, 1);

		//
		world.setBlock(x, y+15, z-3, main, mainMeta, 2);
		world.setBlock(x, y+15, z+3, main, mainMeta, 2);
		world.setBlock(x+1, y+15, z-4, main, mainMeta, 2);
		world.setBlock(x+1, y+15, z+4, main, mainMeta, 2);

		world.setBlock(x+11, y+15, z-3, main, mainMeta, 2);
		world.setBlock(x+11, y+15, z+3, main, mainMeta, 2);
		world.setBlock(x+10, y+15, z-4, main, mainMeta, 2);
		world.setBlock(x+10, y+15, z+4, main, mainMeta, 2);
		
		//Panes
		world.setBlock(x+12, y+15, z, pane, paneMeta, 2);
		
		world.setBlock(x-1, y+15, z, pane, paneMeta, 2);
		
		BuildHelper.build(world, x+5, y+15, z+5, pane, paneMeta, 1, 1, 2);
	}

	private static void buildLayer17(World world, int x, int y, int z, Block main, int mainMeta, Block secondary, int secondaryMeta, Block third, int thirdMeta, Block floor, int floorMeta, Block pane, int paneMeta, Block stairs, int stairsMeta, Block slab, int slabMeta, Block wall, int wallMeta, Block roof, int roofMeta)
	{
		//Main Tower
		BuildHelper.build(world, x+2, y+16, z-5, main, mainMeta, 1, 1, 8);
		BuildHelper.build(world, x+2, y+16, z+5, main, mainMeta, 1, 1, 8);
		BuildHelper.build(world, x+12, y+16, z-2, main, mainMeta, 5, 1, 1);

		//
		BuildHelper.build(world, x-1, y+16, z-2, main, mainMeta, 5, 1, 1);

		//
		world.setBlock(x, y+16, z-3, main, mainMeta, 2);
		world.setBlock(x, y+16, z+3, main, mainMeta, 2);
		world.setBlock(x+1, y+16, z-4, main, mainMeta, 2);
		world.setBlock(x+1, y+16, z+4, main, mainMeta, 2);

		world.setBlock(x+11, y+16, z-3, main, mainMeta, 2);
		world.setBlock(x+11, y+16, z+3, main, mainMeta, 2);
		world.setBlock(x+10, y+16, z-4, main, mainMeta, 2);
		world.setBlock(x+10, y+16, z+4, main, mainMeta, 2);
		
		//Panes
		world.setBlock(x+12, y+16, z, pane, paneMeta, 2);
		
		world.setBlock(x-1, y+16, z, pane, paneMeta, 2);
		
		BuildHelper.build(world, x+5, y+16, z+5, pane, paneMeta, 1, 1, 2);
	}

	private static void buildLayer18(World world, int x, int y, int z, Block main, int mainMeta, Block secondary, int secondaryMeta, Block third, int thirdMeta, Block floor, int floorMeta, Block pane, int paneMeta, Block stairs, int stairsMeta, Block slab, int slabMeta, Block wall, int wallMeta, Block roof, int roofMeta)
	{
		//Main Tower
		BuildHelper.build(world, x+2, y+17, z-5, main, mainMeta, 1, 1, 8);
		BuildHelper.build(world, x+2, y+17, z+5, main, mainMeta, 1, 1, 8);
		BuildHelper.build(world, x+12, y+17, z-2, main, mainMeta, 5, 1, 1);

		//
		BuildHelper.build(world, x-1, y+17, z-2, main, mainMeta, 5, 1, 1);

		//
		world.setBlock(x, y+17, z-3, main, mainMeta, 2);
		world.setBlock(x, y+17, z+3, main, mainMeta, 2);
		world.setBlock(x+1, y+17, z-4, main, mainMeta, 2);
		world.setBlock(x+1, y+17, z+4, main, mainMeta, 2);

		world.setBlock(x+11, y+17, z-3, main, mainMeta, 2);
		world.setBlock(x+11, y+17, z+3, main, mainMeta, 2);
		world.setBlock(x+10, y+17, z-4, main, mainMeta, 2);
		world.setBlock(x+10, y+17, z+4, main, mainMeta, 2);

		//Inside Torches
		world.setBlock(x+1, y+17, z-3, Blocks.torch, 0, 2);
		world.setBlock(x+1, y+17, z+3, Blocks.torch, 0, 2);
		world.setBlock(x+10, y+17, z-3, Blocks.torch, 0, 2);
		world.setBlock(x+10, y+17, z+3, Blocks.torch, 0, 2);

		world.setBlock(x+5, y+17, z+4, Blocks.torch, 0, 2);
		world.setBlock(x+4, y+17, z-4, Blocks.torch, 0, 2);
		world.setBlock(x+6, y+17, z+4, Blocks.torch, 0, 2);
		world.setBlock(x+7, y+17, z-4, Blocks.torch, 0, 2);
	}

	private static void buildLayer19(World world, int x, int y, int z, Block main, int mainMeta, Block secondary, int secondaryMeta, Block third, int thirdMeta, Block floor, int floorMeta, Block pane, int paneMeta, Block stairs, int stairsMeta, Block slab, int slabMeta, Block wall, int wallMeta, Block roof, int roofMeta)
	{
		//Main Tower
		BuildHelper.build(world, x+2, y+18, z-5, main, mainMeta, 1, 1, 8);
		BuildHelper.build(world, x+2, y+18, z+5, main, mainMeta, 1, 1, 8);
		BuildHelper.build(world, x+12, y+18, z-2, main, mainMeta, 5, 1, 1);

		//
		BuildHelper.build(world, x-1, y+18, z-2, main, mainMeta, 5, 1, 1);

		//Stairs
		BuildHelper.build(world, x+2, y+18, z+6, stairs, 7, 1, 1, 8);
		BuildHelper.build(world, x+2, y+18, z-6, stairs, 6, 1, 1, 8);
		BuildHelper.build(world, x+13, y+18, z-2, stairs, 5, 5, 1, 1);

		BuildHelper.build(world, x, y+18, z+3, stairs, 4, 2, 1, 1);
		BuildHelper.build(world, x+1, y+18, z+4, stairs, 4, 2, 1, 1);

		BuildHelper.build(world, x, y+18, z-4, stairs, 4, 2, 1, 1);
		BuildHelper.build(world, x+1, y+18, z-5, stairs, 4, 2, 1, 1);

		BuildHelper.build(world, x+10, y+18, z+4, stairs, 5, 2, 1, 1);
		BuildHelper.build(world, x+11, y+18, z+3, stairs, 5, 2, 1, 1);

		BuildHelper.build(world, x+10, y+18, z-5, stairs, 5, 2, 1, 1);
		BuildHelper.build(world, x+11, y+18, z-4, stairs, 5, 2, 1, 1);

		BuildHelper.build(world, x-1, y+18, z-2, main, mainMeta, 5, 1, 1);

		BuildHelper.build(world, x-2, y+18, z-2, stairs, 4, 5, 1, 1);

		//Fourth Floor
		BuildHelper.build(world, x+1, y+18, z-1, floor, floorMeta, 3, 1, 1);
		BuildHelper.build(world, x+2, y+18, z-2, floor, floorMeta, 5, 1, 1);
		BuildHelper.build(world, x+3, y+18, z-2, floor, floorMeta, 5, 1, 6);
		BuildHelper.build(world, x+10, y+18, z-1, floor, floorMeta, 3, 1, 1);
		BuildHelper.build(world, x+9, y+18, z-2, floor, floorMeta, 5, 1, 1);
		
		BuildHelper.build(world, x+3, y+18, z-3, floor, floorMeta, 1, 1, 2);
		BuildHelper.build(world, x+7, y+18, z-3, floor, floorMeta, 1, 1, 2);
		
		BuildHelper.build(world, x+3, y+18, z+3, floor, floorMeta, 1, 1, 6);

		//Fourth Floor border
		BuildHelper.build(world, x+2, y+18, z+4, main, mainMeta, 1, 1, 8);
		BuildHelper.build(world, x+2, y+18, z-4, main, mainMeta, 1, 1, 8);
		BuildHelper.build(world, x+11, y+18, z-2, main, mainMeta, 5, 1, 1);
		BuildHelper.build(world, x, y+18, z-2, main, mainMeta, 5, 1, 1);
		BuildHelper.build(world, x+1, y+18, z+3, main, mainMeta, 1, 1, 2);
		BuildHelper.build(world, x+9, y+18, z+3, main, mainMeta, 1, 1, 2);
		BuildHelper.build(world, x+1, y+18, z-3, main, mainMeta, 1, 1, 2);
		BuildHelper.build(world, x+9, y+18, z-3, main, mainMeta, 1, 1, 2);

		world.setBlock(x+1, y+18, z-2, main, mainMeta, 2);
		world.setBlock(x+1, y+18, z+2, main, mainMeta, 2);
		world.setBlock(x+10, y+18, z-2, main, mainMeta, 2);
		world.setBlock(x+10, y+18, z+2, main, mainMeta, 2);

		//
		world.setBlock(x, y+18, z-3, main, mainMeta, 2);
		world.setBlock(x, y+18, z+3, main, mainMeta, 2);
		world.setBlock(x+1, y+18, z-4, main, mainMeta, 2);
		world.setBlock(x+1, y+18, z+4, main, mainMeta, 2);

		world.setBlock(x+11, y+18, z-3, main, mainMeta, 2);
		world.setBlock(x+11, y+18, z+3, main, mainMeta, 2);
		world.setBlock(x+10, y+18, z-4, main, mainMeta, 2);
		world.setBlock(x+10, y+18, z+4, main, mainMeta, 2);

		//
		world.setBlock(x-1, y+18, z-3, stairs, 4, 2);
		world.setBlock(x-1, y+18, z+3, stairs, 4, 2);

		world.setBlock(x+12, y+18, z-3, stairs, 5, 2);
		world.setBlock(x+12, y+18, z+3, stairs, 5, 2);
	}

	private static void buildLayer20(World world, int x, int y, int z, Block main, int mainMeta, Block secondary, int secondaryMeta, Block third, int thirdMeta, Block floor, int floorMeta, Block pane, int paneMeta, Block stairs, int stairsMeta, Block slab, int slabMeta, Block wall, int wallMeta, Block roof, int roofMeta)
	{
		//Main Tower
		BuildHelper.build(world, x+2, y+19, z-5, secondary, secondaryMeta, 1, 1, 8);
		BuildHelper.build(world, x+2, y+19, z+5, secondary, secondaryMeta, 1, 1, 8);
		BuildHelper.build(world, x+12, y+19, z-2, secondary, secondaryMeta, 5, 1, 1);

		//
		BuildHelper.build(world, x-1, y+19, z-2, secondary, secondaryMeta, 5, 1, 1);

		//
		world.setBlock(x, y+19, z-3, secondary, secondaryMeta, 2);
		world.setBlock(x, y+19, z+3, secondary, secondaryMeta, 2);
		world.setBlock(x+1, y+19, z-4, secondary, secondaryMeta, 2);
		world.setBlock(x+1, y+19, z+4, secondary, secondaryMeta, 2);

		world.setBlock(x+11, y+19, z-3, secondary, secondaryMeta, 2);
		world.setBlock(x+11, y+19, z+3, secondary, secondaryMeta, 2);
		world.setBlock(x+10, y+19, z-4, secondary, secondaryMeta, 2);
		world.setBlock(x+10, y+19, z+4, secondary, secondaryMeta, 2);
	}

	private static void buildLayer21(World world, int x, int y, int z, Block main, int mainMeta, Block secondary, int secondaryMeta, Block third, int thirdMeta, Block floor, int floorMeta, Block pane, int paneMeta, Block stairs, int stairsMeta, Block slab, int slabMeta, Block wall, int wallMeta, Block roof, int roofMeta)
	{
		//Main Tower
		BuildHelper.build(world, x+2, y+20, z-5, main, mainMeta, 1, 1, 8);
		BuildHelper.build(world, x+2, y+20, z+5, main, mainMeta, 1, 1, 8);
		BuildHelper.build(world, x+12, y+20, z-2, main, mainMeta, 5, 1, 1);

		//
		BuildHelper.build(world, x-1, y+20, z-2, main, mainMeta, 5, 1, 1);

		//
		world.setBlock(x, y+20, z-3, main, mainMeta, 2);
		world.setBlock(x, y+20, z+3, main, mainMeta, 2);
		world.setBlock(x+1, y+20, z-4, main, mainMeta, 2);
		world.setBlock(x+1, y+20, z+4, main, mainMeta, 2);

		world.setBlock(x+11, y+20, z-3, main, mainMeta, 2);
		world.setBlock(x+11, y+20, z+3, main, mainMeta, 2);
		world.setBlock(x+10, y+20, z-4, main, mainMeta, 2);
		world.setBlock(x+10, y+20, z+4, main, mainMeta, 2);
		
		//Panes
		world.setBlock(x+12, y+20, z, pane, paneMeta, 2);
		
		world.setBlock(x-1, y+20, z, pane, paneMeta, 2);
		
		BuildHelper.build(world, x+5, y+20, z+5, pane, paneMeta, 1, 1, 2);
	}

	private static void buildLayer22(World world, int x, int y, int z, Block main, int mainMeta, Block secondary, int secondaryMeta, Block third, int thirdMeta, Block floor, int floorMeta, Block pane, int paneMeta, Block stairs, int stairsMeta, Block slab, int slabMeta, Block wall, int wallMeta, Block roof, int roofMeta)
	{
		//Main Tower
		BuildHelper.build(world, x+2, y+21, z-5, main, mainMeta, 1, 1, 8);
		BuildHelper.build(world, x+2, y+21, z+5, main, mainMeta, 1, 1, 8);
		BuildHelper.build(world, x+12, y+21, z-2, main, mainMeta, 5, 1, 1);

		//
		BuildHelper.build(world, x-1, y+21, z-2, main, mainMeta, 5, 1, 1);

		//
		world.setBlock(x, y+21, z-3, main, mainMeta, 2);
		world.setBlock(x, y+21, z+3, main, mainMeta, 2);
		world.setBlock(x+1, y+21, z-4, main, mainMeta, 2);
		world.setBlock(x+1, y+21, z+4, main, mainMeta, 2);

		world.setBlock(x+11, y+21, z-3, main, mainMeta, 2);
		world.setBlock(x+11, y+21, z+3, main, mainMeta, 2);
		world.setBlock(x+10, y+21, z-4, main, mainMeta, 2);
		world.setBlock(x+10, y+21, z+4, main, mainMeta, 2);
		
		//Panes
		world.setBlock(x+12, y+21, z, pane, paneMeta, 2);
		
		world.setBlock(x-1, y+21, z, pane, paneMeta, 2);
		
		BuildHelper.build(world, x+5, y+21, z+5, pane, paneMeta, 1, 1, 2);
	}

	private static void buildLayer23(World world, int x, int y, int z, Block main, int mainMeta, Block secondary, int secondaryMeta, Block third, int thirdMeta, Block floor, int floorMeta, Block pane, int paneMeta, Block stairs, int stairsMeta, Block slab, int slabMeta, Block wall, int wallMeta, Block roof, int roofMeta)
	{
		//Main Tower
		BuildHelper.build(world, x+2, y+22, z-5, main, mainMeta, 1, 1, 8);
		BuildHelper.build(world, x+2, y+22, z+5, main, mainMeta, 1, 1, 8);
		BuildHelper.build(world, x+12, y+22, z-2, main, mainMeta, 5, 1, 1);

		//
		BuildHelper.build(world, x-1, y+22, z-2, main, mainMeta, 5, 1, 1);

		//
		world.setBlock(x, y+22, z-3, main, mainMeta, 2);
		world.setBlock(x, y+22, z+3, main, mainMeta, 2);
		world.setBlock(x+1, y+22, z-4, main, mainMeta, 2);
		world.setBlock(x+1, y+22, z+4, main, mainMeta, 2);

		world.setBlock(x+11, y+22, z-3, main, mainMeta, 2);
		world.setBlock(x+11, y+22, z+3, main, mainMeta, 2);
		world.setBlock(x+10, y+22, z-4, main, mainMeta, 2);
		world.setBlock(x+10, y+22, z+4, main, mainMeta, 2);
		
		//Panes
		world.setBlock(x+12, y+22, z, pane, paneMeta, 2);
		
		world.setBlock(x-1, y+22, z, pane, paneMeta, 2);
		
		BuildHelper.build(world, x+5, y+22, z+5, pane, paneMeta, 1, 1, 2);
	}

	private static void buildLayer24(World world, int x, int y, int z, Block main, int mainMeta, Block secondary, int secondaryMeta, Block third, int thirdMeta, Block floor, int floorMeta, Block pane, int paneMeta, Block stairs, int stairsMeta, Block slab, int slabMeta, Block wall, int wallMeta, Block roof, int roofMeta)
	{
		//Main Tower
		BuildHelper.build(world, x+2, y+23, z-5, main, mainMeta, 1, 1, 8);
		BuildHelper.build(world, x+2, y+23, z+5, main, mainMeta, 1, 1, 8);
		BuildHelper.build(world, x+12, y+23, z-2, main, mainMeta, 5, 1, 1);

		//
		BuildHelper.build(world, x-1, y+23, z-2, main, mainMeta, 5, 1, 1);

		//
		world.setBlock(x, y+23, z-3, main, mainMeta, 2);
		world.setBlock(x, y+23, z+3, main, mainMeta, 2);
		world.setBlock(x+1, y+23, z-4, main, mainMeta, 2);
		world.setBlock(x+1, y+23, z+4, main, mainMeta, 2);

		world.setBlock(x+11, y+23, z-3, main, mainMeta, 2);
		world.setBlock(x+11, y+23, z+3, main, mainMeta, 2);
		world.setBlock(x+10, y+23, z-4, main, mainMeta, 2);
		world.setBlock(x+10, y+23, z+4, main, mainMeta, 2);

		//Inside Torches
		world.setBlock(x+1, y+23, z-3, Blocks.torch, 0, 2);
		world.setBlock(x+1, y+23, z+3, Blocks.torch, 0, 2);
		world.setBlock(x+10, y+23, z-3, Blocks.torch, 0, 2);
		world.setBlock(x+10, y+23, z+3, Blocks.torch, 0, 2);

		world.setBlock(x+5, y+23, z+4, Blocks.torch, 0, 2);
		world.setBlock(x+4, y+23, z-4, Blocks.torch, 0, 2);
		world.setBlock(x+6, y+23, z+4, Blocks.torch, 0, 2);
		world.setBlock(x+7, y+23, z-4, Blocks.torch, 0, 2);
	}

	private static void buildLayer25(World world, int x, int y, int z, Block main, int mainMeta, Block secondary, int secondaryMeta, Block third, int thirdMeta, Block floor, int floorMeta, Block pane, int paneMeta, Block stairs, int stairsMeta, Block slab, int slabMeta, Block wall, int wallMeta, Block roof, int roofMeta)
	{
		//Main Tower
		BuildHelper.build(world, x+2, y+24, z-5, main, mainMeta, 1, 1, 8);
		BuildHelper.build(world, x+2, y+24, z+5, main, mainMeta, 1, 1, 8);
		BuildHelper.build(world, x+12, y+24, z-2, main, mainMeta, 5, 1, 1);

		//
		BuildHelper.build(world, x-1, y+24, z-2, main, mainMeta, 5, 1, 1);

		//Stairs
		BuildHelper.build(world, x+2, y+24, z+6, stairs, 7, 1, 1, 8);
		BuildHelper.build(world, x+2, y+24, z-6, stairs, 6, 1, 1, 8);
		BuildHelper.build(world, x+13, y+24, z-2, stairs, 5, 5, 1, 1);

		BuildHelper.build(world, x, y+24, z+3, stairs, 4, 2, 1, 1);
		BuildHelper.build(world, x+1, y+24, z+4, stairs, 4, 2, 1, 1);

		BuildHelper.build(world, x, y+24, z-4, stairs, 4, 2, 1, 1);
		BuildHelper.build(world, x+1, y+24, z-5, stairs, 4, 2, 1, 1);

		BuildHelper.build(world, x+10, y+24, z+4, stairs, 5, 2, 1, 1);
		BuildHelper.build(world, x+11, y+24, z+3, stairs, 5, 2, 1, 1);

		BuildHelper.build(world, x+10, y+24, z-5, stairs, 5, 2, 1, 1);
		BuildHelper.build(world, x+11, y+24, z-4, stairs, 5, 2, 1, 1);

		BuildHelper.build(world, x-1, y+24, z-2, main, mainMeta, 5, 1, 1);

		BuildHelper.build(world, x-2, y+24, z-2, stairs, 4, 5, 1, 1);

		//Fifth Floor
		BuildHelper.build(world, x+1, y+24, z-1, floor, floorMeta, 3, 1, 1);
		BuildHelper.build(world, x+2, y+24, z-2, floor, floorMeta, 5, 1, 1);
		BuildHelper.build(world, x+3, y+24, z-2, floor, floorMeta, 5, 1, 6);
		BuildHelper.build(world, x+10, y+24, z-1, floor, floorMeta, 3, 1, 1);
		BuildHelper.build(world, x+9, y+24, z-2, floor, floorMeta, 5, 1, 1);
		
		BuildHelper.build(world, x+3, y+24, z-3, floor, floorMeta, 1, 1, 2);
		BuildHelper.build(world, x+7, y+24, z-3, floor, floorMeta, 1, 1, 2);
		
		BuildHelper.build(world, x+3, y+24, z+3, floor, floorMeta, 1, 1, 6);

		//Fifth Floor border
		BuildHelper.build(world, x+2, y+24, z+4, main, mainMeta, 1, 1, 8);
		BuildHelper.build(world, x+2, y+24, z-4, main, mainMeta, 1, 1, 8);
		BuildHelper.build(world, x+11, y+24, z-2, main, mainMeta, 5, 1, 1);
		BuildHelper.build(world, x, y+24, z-2, main, mainMeta, 5, 1, 1);
		BuildHelper.build(world, x+1, y+24, z+3, main, mainMeta, 1, 1, 2);
		BuildHelper.build(world, x+9, y+24, z+3, main, mainMeta, 1, 1, 2);
		BuildHelper.build(world, x+1, y+24, z-3, main, mainMeta, 1, 1, 2);
		BuildHelper.build(world, x+9, y+24, z-3, main, mainMeta, 1, 1, 2);

		world.setBlock(x+1, y+24, z-2, main, mainMeta, 2);
		world.setBlock(x+1, y+24, z+2, main, mainMeta, 2);
		world.setBlock(x+10, y+24, z-2, main, mainMeta, 2);
		world.setBlock(x+10, y+24, z+2, main, mainMeta, 2);

		//
		world.setBlock(x, y+24, z-3, main, mainMeta, 2);
		world.setBlock(x, y+24, z+3, main, mainMeta, 2);
		world.setBlock(x+1, y+24, z-4, main, mainMeta, 2);
		world.setBlock(x+1, y+24, z+4, main, mainMeta, 2);

		world.setBlock(x+11, y+24, z-3, main, mainMeta, 2);
		world.setBlock(x+11, y+24, z+3, main, mainMeta, 2);
		world.setBlock(x+10, y+24, z-4, main, mainMeta, 2);
		world.setBlock(x+10, y+24, z+4, main, mainMeta, 2);

		//
		world.setBlock(x-1, y+24, z-3, stairs, 4, 2);
		world.setBlock(x-1, y+24, z+3, stairs, 4, 2);

		world.setBlock(x+12, y+24, z-3, stairs, 5, 2);
		world.setBlock(x+12, y+24, z+3, stairs, 5, 2);
	}

	//Roof
	private static void roof(World world, int x, int y, int z, Block main, int mainMeta, Block secondary, int secondaryMeta, Block third, int thirdMeta, Block floor, int floorMeta, Block pane, int paneMeta, Block stairs, int stairsMeta, Block slab, int slabMeta, Block wall, int wallMeta, Block roof, int roofMeta)
	{
		//Roof
		//Layer 1
		BuildHelper.build(world, x-1, y+25, z-2, roof, roofMeta, 5, 1, 1);
		BuildHelper.build(world, x+12, y+25, z-2, roof, roofMeta, 5, 1, 1);

		BuildHelper.build(world, x+2, y+25, z-5, roof, roofMeta, 1, 1, 8);
		BuildHelper.build(world, x+2, y+25, z+5, roof, roofMeta, 1, 1, 8);

		//
		world.setBlock(x, y+25, z-3, roof, roofMeta, 2);
		world.setBlock(x, y+25, z+3, roof, roofMeta, 2);
		world.setBlock(x+1, y+25, z-4, roof, roofMeta, 2);
		world.setBlock(x+1, y+25, z+4, roof, roofMeta, 2);

		//
		world.setBlock(x+11, y+25, z-3, roof, roofMeta, 2);
		world.setBlock(x+11, y+25, z+3, roof, roofMeta, 2);
		world.setBlock(x+10, y+25, z-4, roof, roofMeta, 2);
		world.setBlock(x+10, y+25, z+4, roof, roofMeta, 2);
		
		world.setBlock(x+10, y+25, z-3, Blocks.air, 0, 2);
		world.setBlock(x+10, y+25, z+3, Blocks.air, 0, 2);

		//Layer 2
		BuildHelper.build(world, x, y+26, z-2, roof, roofMeta, 5, 1, 1);
		BuildHelper.build(world, x+11, y+26, z-2, roof, roofMeta, 5, 1, 1);

		BuildHelper.build(world, x+2, y+26, z-4, roof, roofMeta, 1, 1, 8);
		BuildHelper.build(world, x+2, y+26, z+4, roof, roofMeta, 1, 1, 8);

		world.setBlock(x+1, y+26, z-3, roof, roofMeta, 2);
		world.setBlock(x+1, y+26, z+3, roof, roofMeta, 2);

		world.setBlock(x+10, y+26, z-3, roof, roofMeta, 2);
		world.setBlock(x+10, y+26, z+3, roof, roofMeta, 2);

		//Layer 3
		BuildHelper.build(world, x+1, y+27, z-2, roof, roofMeta, 5, 1, 1);
		BuildHelper.build(world, x+10, y+27, z-2, roof, roofMeta, 5, 1, 1);

		BuildHelper.build(world, x+2, y+27, z-3, roof, roofMeta, 1, 1, 8);
		BuildHelper.build(world, x+2, y+27, z+3, roof, roofMeta, 1, 1, 8);

		//Layer 4
		BuildHelper.build(world, x+2, y+28, z-1, roof, roofMeta, 3, 1, 1);
		BuildHelper.build(world, x+9, y+28, z-1, roof, roofMeta, 3, 1, 1);

		BuildHelper.build(world, x+2, y+28, z-2, roof, roofMeta, 1, 1, 8);
		BuildHelper.build(world, x+2, y+28, z+2, roof, roofMeta, 1, 1, 8);
		
		world.setBlock(x+3, y+28, z-1, Blocks.torch, 0, 2);
		world.setBlock(x+3, y+28, z+1, Blocks.torch, 0, 2);
		world.setBlock(x+8, y+28, z-1, Blocks.torch, 0, 2);
		world.setBlock(x+8, y+28, z+1, Blocks.torch, 0, 2);

		//Layer 5
		world.setBlock(x+3, y+29, z, roof, roofMeta, 2);
		world.setBlock(x+8, y+29, z, roof, roofMeta, 2);

		BuildHelper.build(world, x+3, y+29, z-1, roof, roofMeta, 1, 1, 6);
		BuildHelper.build(world, x+3, y+29, z+1, roof, roofMeta, 1, 1, 6);
		
		//Layer 6
		BuildHelper.build(world, x+4, y+30, z, roof, roofMeta, 1, 1, 4);
		
		//Layer 7
		BuildHelper.build(world, x+4, y+31, z, roof, roofMeta, 1, 1, 2);
	}
}
