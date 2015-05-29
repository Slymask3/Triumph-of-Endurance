package com.abstractlabs.toe.structures;

import net.minecraft.block.Block;
import net.minecraft.world.World;

import com.abstractlabs.toe.init.ToeBlocks;
import com.abstractlabs.toe.utility.BuildHelper;

public class Shrine {
	public static void build(World world, int x, int y, int z, Block main, int mainMeta, Block slab, int slabMeta, Block glass, int glassMeta, Block pane, int paneMeta, Block liquid, int liquidMeta) {
		buildLayer1(world, x, y, z, main, mainMeta, slab, slabMeta, glass, glassMeta, pane, paneMeta, liquid, liquidMeta);
		buildLayer2(world, x, y, z, main, mainMeta, slab, slabMeta, glass, glassMeta, pane, paneMeta, liquid, liquidMeta);
		buildLayer3(world, x, y, z, main, mainMeta, slab, slabMeta, glass, glassMeta, pane, paneMeta, liquid, liquidMeta);
		buildLayer4(world, x, y, z, main, mainMeta, slab, slabMeta, glass, glassMeta, pane, paneMeta, liquid, liquidMeta);
		buildLayer5(world, x, y, z, main, mainMeta, slab, slabMeta, glass, glassMeta, pane, paneMeta, liquid, liquidMeta);
		buildLayer6(world, x, y, z, main, mainMeta, slab, slabMeta, glass, glassMeta, pane, paneMeta, liquid, liquidMeta);
		buildLayer7(world, x, y, z, main, mainMeta, slab, slabMeta, glass, glassMeta, pane, paneMeta, liquid, liquidMeta);
		buildLayer8(world, x, y, z, main, mainMeta, slab, slabMeta, glass, glassMeta, pane, paneMeta, liquid, liquidMeta);
	}
	
	private static void buildLayer1(World world, int x, int y, int z, Block main, int mainMeta, Block slab, int slabMeta, Block glass, int glassMeta, Block pane, int paneMeta, Block liquid, int liquidMeta) {
		BuildHelper.build(world, x-3, y-2, z-3, main, mainMeta, 7, 1, 7);

		world.setBlock(x-6, y-2, z  , main, mainMeta, 2);
		world.setBlock(x-5, y-2, z-1, main, mainMeta, 2);
		world.setBlock(x-5, y-2, z  , main, mainMeta, 2);
		world.setBlock(x-5, y-2, z+1, main, mainMeta, 2);
		world.setBlock(x-4, y-2, z-2, main, mainMeta, 2);
		world.setBlock(x-4, y-2, z-1, main, mainMeta, 2);
		world.setBlock(x-4, y-2, z  , main, mainMeta, 2);
		world.setBlock(x-4, y-2, z+1, main, mainMeta, 2);
		world.setBlock(x-4, y-2, z+2, main, mainMeta, 2);

		world.setBlock(x+6, y-2, z  , main, mainMeta, 2);
		world.setBlock(x+5, y-2, z-1, main, mainMeta, 2);
		world.setBlock(x+5, y-2, z  , main, mainMeta, 2);
		world.setBlock(x+5, y-2, z+1, main, mainMeta, 2);
		world.setBlock(x+4, y-2, z-2, main, mainMeta, 2);
		world.setBlock(x+4, y-2, z-1, main, mainMeta, 2);
		world.setBlock(x+4, y-2, z  , main, mainMeta, 2);
		world.setBlock(x+4, y-2, z+1, main, mainMeta, 2);
		world.setBlock(x+4, y-2, z+2, main, mainMeta, 2);

		world.setBlock(x  , y-2, z-6, main, mainMeta, 2);
		world.setBlock(x-1, y-2, z-5, main, mainMeta, 2);
		world.setBlock(x  , y-2, z-5, main, mainMeta, 2);
		world.setBlock(x+1, y-2, z-5, main, mainMeta, 2);
		world.setBlock(x-2, y-2, z-4, main, mainMeta, 2);
		world.setBlock(x-1, y-2, z-4, main, mainMeta, 2);
		world.setBlock(x  , y-2, z-4, main, mainMeta, 2);
		world.setBlock(x+1, y-2, z-4, main, mainMeta, 2);
		world.setBlock(x+2, y-2, z-4, main, mainMeta, 2);

		world.setBlock(x  , y-2, z+6, main, mainMeta, 2);
		world.setBlock(x-1, y-2, z+5, main, mainMeta, 2);
		world.setBlock(x  , y-2, z+5, main, mainMeta, 2);
		world.setBlock(x+1, y-2, z+5, main, mainMeta, 2);
		world.setBlock(x-2, y-2, z+4, main, mainMeta, 2);
		world.setBlock(x-1, y-2, z+4, main, mainMeta, 2);
		world.setBlock(x  , y-2, z+4, main, mainMeta, 2);
		world.setBlock(x+1, y-2, z+4, main, mainMeta, 2);
		world.setBlock(x+2, y-2, z+4, main, mainMeta, 2);
	}
	
	private static void buildLayer2(World world, int x, int y, int z, Block main, int mainMeta, Block slab, int slabMeta, Block glass, int glassMeta, Block pane, int paneMeta, Block liquid, int liquidMeta) {
		BuildHelper.build(world, x-3, y-1, z-3, liquid, liquidMeta, 7, 1, 7);

		world.setBlock(x-3, y-1, z-3, main, mainMeta, 2);
		world.setBlock(x+3, y-1, z+3, main, mainMeta, 2);
		world.setBlock(x+3, y-1, z-3, main, mainMeta, 2);
		world.setBlock(x-3, y-1, z+3, main, mainMeta, 2);
		
		world.setBlock(x-6, y-1, z  , main, mainMeta, 2);
		world.setBlock(x-5, y-1, z-1, main, mainMeta, 2);
		world.setBlock(x-5, y-1, z  , main, mainMeta, 2);
		world.setBlock(x-5, y-1, z+1, main, mainMeta, 2);
		world.setBlock(x-4, y-1, z-2, main, mainMeta, 2);
		world.setBlock(x-4, y-1, z-1, main, mainMeta, 2);
		world.setBlock(x-4, y-1, z  , main, mainMeta, 2);
		world.setBlock(x-4, y-1, z+1, main, mainMeta, 2);
		world.setBlock(x-4, y-1, z+2, main, mainMeta, 2);

		world.setBlock(x+6, y-1, z  , main, mainMeta, 2);
		world.setBlock(x+5, y-1, z-1, main, mainMeta, 2);
		world.setBlock(x+5, y-1, z  , main, mainMeta, 2);
		world.setBlock(x+5, y-1, z+1, main, mainMeta, 2);
		world.setBlock(x+4, y-1, z-2, main, mainMeta, 2);
		world.setBlock(x+4, y-1, z-1, main, mainMeta, 2);
		world.setBlock(x+4, y-1, z  , main, mainMeta, 2);
		world.setBlock(x+4, y-1, z+1, main, mainMeta, 2);
		world.setBlock(x+4, y-1, z+2, main, mainMeta, 2);

		world.setBlock(x  , y-1, z-6, main, mainMeta, 2);
		world.setBlock(x-1, y-1, z-5, main, mainMeta, 2);
		world.setBlock(x  , y-1, z-5, main, mainMeta, 2);
		world.setBlock(x+1, y-1, z-5, main, mainMeta, 2);
		world.setBlock(x-2, y-1, z-4, main, mainMeta, 2);
		world.setBlock(x-1, y-1, z-4, main, mainMeta, 2);
		world.setBlock(x  , y-1, z-4, main, mainMeta, 2);
		world.setBlock(x+1, y-1, z-4, main, mainMeta, 2);
		world.setBlock(x+2, y-1, z-4, main, mainMeta, 2);

		world.setBlock(x  , y-1, z+6, main, mainMeta, 2);
		world.setBlock(x-1, y-1, z+5, main, mainMeta, 2);
		world.setBlock(x  , y-1, z+5, main, mainMeta, 2);
		world.setBlock(x+1, y-1, z+5, main, mainMeta, 2);
		world.setBlock(x-2, y-1, z+4, main, mainMeta, 2);
		world.setBlock(x-1, y-1, z+4, main, mainMeta, 2);
		world.setBlock(x  , y-1, z+4, main, mainMeta, 2);
		world.setBlock(x+1, y-1, z+4, main, mainMeta, 2);
		world.setBlock(x+2, y-1, z+4, main, mainMeta, 2);
	}
	
	private static void buildLayer3(World world, int x, int y, int z, Block main, int mainMeta, Block slab, int slabMeta, Block glass, int glassMeta, Block pane, int paneMeta, Block liquid, int liquidMeta) {
		BuildHelper.build(world, x-3, y, z-3, glass, glassMeta, 7, 1, 7);
		
		BuildHelper.build(world, x-1, y, z-1, main, mainMeta, 3, 1, 3);

		world.setBlock(x-3, y, z-3, main, mainMeta, 2);
		world.setBlock(x+3, y, z+3, main, mainMeta, 2);
		world.setBlock(x+3, y, z-3, main, mainMeta, 2);
		world.setBlock(x-3, y, z+3, main, mainMeta, 2);
		
		world.setBlock(x-6, y, z  , main, mainMeta, 2);
		world.setBlock(x-5, y, z-1, main, mainMeta, 2);
		world.setBlock(x-5, y, z  , main, mainMeta, 2);
		world.setBlock(x-5, y, z+1, main, mainMeta, 2);
		world.setBlock(x-4, y, z-2, main, mainMeta, 2);
		world.setBlock(x-4, y, z-1, main, mainMeta, 2);
		world.setBlock(x-4, y, z  , main, mainMeta, 2);
		world.setBlock(x-4, y, z+1, main, mainMeta, 2);
		world.setBlock(x-4, y, z+2, main, mainMeta, 2);

		world.setBlock(x+6, y, z  , main, mainMeta, 2);
		world.setBlock(x+5, y, z-1, main, mainMeta, 2);
		world.setBlock(x+5, y, z  , main, mainMeta, 2);
		world.setBlock(x+5, y, z+1, main, mainMeta, 2);
		world.setBlock(x+4, y, z-2, main, mainMeta, 2);
		world.setBlock(x+4, y, z-1, main, mainMeta, 2);
		world.setBlock(x+4, y, z  , main, mainMeta, 2);
		world.setBlock(x+4, y, z+1, main, mainMeta, 2);
		world.setBlock(x+4, y, z+2, main, mainMeta, 2);

		world.setBlock(x  , y, z-6, main, mainMeta, 2);
		world.setBlock(x-1, y, z-5, main, mainMeta, 2);
		world.setBlock(x  , y, z-5, main, mainMeta, 2);
		world.setBlock(x+1, y, z-5, main, mainMeta, 2);
		world.setBlock(x-2, y, z-4, main, mainMeta, 2);
		world.setBlock(x-1, y, z-4, main, mainMeta, 2);
		world.setBlock(x  , y, z-4, main, mainMeta, 2);
		world.setBlock(x+1, y, z-4, main, mainMeta, 2);
		world.setBlock(x+2, y, z-4, main, mainMeta, 2);

		world.setBlock(x  , y, z+6, main, mainMeta, 2);
		world.setBlock(x-1, y, z+5, main, mainMeta, 2);
		world.setBlock(x  , y, z+5, main, mainMeta, 2);
		world.setBlock(x+1, y, z+5, main, mainMeta, 2);
		world.setBlock(x-2, y, z+4, main, mainMeta, 2);
		world.setBlock(x-1, y, z+4, main, mainMeta, 2);
		world.setBlock(x  , y, z+4, main, mainMeta, 2);
		world.setBlock(x+1, y, z+4, main, mainMeta, 2);
		world.setBlock(x+2, y, z+4, main, mainMeta, 2);
	}
	
	private static void buildLayer4(World world, int x, int y, int z, Block main, int mainMeta, Block slab, int slabMeta, Block glass, int glassMeta, Block pane, int paneMeta, Block liquid, int liquidMeta) {
		BuildHelper.build(world, x-1, y+1, z-1, slab, slabMeta, 3, 1, 3);

		world.setBlock(x, y+1, z, main, mainMeta, 2);

		world.setBlock(x-3, y+1, z-3, slab, slabMeta, 2);
		world.setBlock(x+3, y+1, z+3, slab, slabMeta, 2);
		world.setBlock(x+3, y+1, z-3, slab, slabMeta, 2);
		world.setBlock(x-3, y+1, z+3, slab, slabMeta, 2);
		
		world.setBlock(x-6, y+1, z  , main, mainMeta, 2);
		world.setBlock(x-5, y+1, z-1, main, mainMeta, 2);
		world.setBlock(x-5, y+1, z+1, main, mainMeta, 2);
		world.setBlock(x-4, y+1, z-2, slab, slabMeta, 2);
		world.setBlock(x-4, y+1, z-1, pane, paneMeta, 2);
		world.setBlock(x-4, y+1, z  , pane, paneMeta, 2);
		world.setBlock(x-4, y+1, z+1, pane, paneMeta, 2);
		world.setBlock(x-4, y+1, z+2, slab, slabMeta, 2);

		world.setBlock(x+6, y+1, z  , main, mainMeta, 2);
		world.setBlock(x+5, y+1, z-1, main, mainMeta, 2);
		world.setBlock(x+5, y+1, z+1, main, mainMeta, 2);
		world.setBlock(x+4, y+1, z-2, slab, slabMeta, 2);
		world.setBlock(x+4, y+1, z-1, pane, paneMeta, 2);
		world.setBlock(x+4, y+1, z  , pane, paneMeta, 2);
		world.setBlock(x+4, y+1, z+1, pane, paneMeta, 2);
		world.setBlock(x+4, y+1, z+2, slab, slabMeta, 2);

		world.setBlock(x  , y+1, z-6, main, mainMeta, 2);
		world.setBlock(x-1, y+1, z-5, main, mainMeta, 2);
		world.setBlock(x+1, y+1, z-5, main, mainMeta, 2);
		world.setBlock(x-2, y+1, z-4, slab, slabMeta, 2);
		world.setBlock(x-1, y+1, z-4, pane, paneMeta, 2);
		world.setBlock(x  , y+1, z-4, pane, paneMeta, 2);
		world.setBlock(x+1, y+1, z-4, pane, paneMeta, 2);
		world.setBlock(x+2, y+1, z-4, slab, slabMeta, 2);

		world.setBlock(x  , y+1, z+6, main, mainMeta, 2);
		world.setBlock(x-1, y+1, z+5, main, mainMeta, 2);
		world.setBlock(x+1, y+1, z+5, main, mainMeta, 2);
		world.setBlock(x-2, y+1, z+4, slab, slabMeta, 2);
		world.setBlock(x-1, y+1, z+4, pane, paneMeta, 2);
		world.setBlock(x  , y+1, z+4, pane, paneMeta, 2);
		world.setBlock(x+1, y+1, z+4, pane, paneMeta, 2);
		world.setBlock(x+2, y+1, z+4, slab, slabMeta, 2);
	}
	
	private static void buildLayer5(World world, int x, int y, int z, Block main, int mainMeta, Block slab, int slabMeta, Block glass, int glassMeta, Block pane, int paneMeta, Block liquid, int liquidMeta) {
		world.setBlock(x, y+2, z, ToeBlocks.cash); //gonna be the shrine block once added
		
		world.setBlock(x-6, y+2, z  , main, mainMeta, 2);
		world.setBlock(x-5, y+2, z-1, main, mainMeta, 2);
		world.setBlock(x-5, y+2, z+1, main, mainMeta, 2);
		world.setBlock(x-4, y+2, z-1, pane, paneMeta, 2);
		world.setBlock(x-4, y+2, z  , pane, paneMeta, 2);
		world.setBlock(x-4, y+2, z+1, pane, paneMeta, 2);

		world.setBlock(x+6, y+2, z  , main, mainMeta, 2);
		world.setBlock(x+5, y+2, z-1, main, mainMeta, 2);
		world.setBlock(x+5, y+2, z+1, main, mainMeta, 2);
		world.setBlock(x+4, y+2, z-1, pane, paneMeta, 2);
		world.setBlock(x+4, y+2, z  , pane, paneMeta, 2);
		world.setBlock(x+4, y+2, z+1, pane, paneMeta, 2);

		world.setBlock(x  , y+2, z-6, main, mainMeta, 2);
		world.setBlock(x-1, y+2, z-5, main, mainMeta, 2);
		world.setBlock(x+1, y+2, z-5, main, mainMeta, 2);
		world.setBlock(x-1, y+2, z-4, pane, paneMeta, 2);
		world.setBlock(x  , y+2, z-4, pane, paneMeta, 2);
		world.setBlock(x+1, y+2, z-4, pane, paneMeta, 2);

		world.setBlock(x  , y+2, z+6, main, mainMeta, 2);
		world.setBlock(x-1, y+2, z+5, main, mainMeta, 2);
		world.setBlock(x+1, y+2, z+5, main, mainMeta, 2);
		world.setBlock(x-1, y+2, z+4, pane, paneMeta, 2);
		world.setBlock(x  , y+2, z+4, pane, paneMeta, 2);
		world.setBlock(x+1, y+2, z+4, pane, paneMeta, 2);
	}
	
	private static void buildLayer6(World world, int x, int y, int z, Block main, int mainMeta, Block slab, int slabMeta, Block glass, int glassMeta, Block pane, int paneMeta, Block liquid, int liquidMeta) {
		world.setBlock(x-6, y+3, z  , main, mainMeta, 2);
		world.setBlock(x-5, y+3, z-1, main, mainMeta, 2);
		world.setBlock(x-5, y+3, z+1, main, mainMeta, 2);
		world.setBlock(x-4, y+3, z-1, pane, paneMeta, 2);
		world.setBlock(x-4, y+3, z  , pane, paneMeta, 2);
		world.setBlock(x-4, y+3, z+1, pane, paneMeta, 2);

		world.setBlock(x+6, y+3, z  , main, mainMeta, 2);
		world.setBlock(x+5, y+3, z-1, main, mainMeta, 2);
		world.setBlock(x+5, y+3, z+1, main, mainMeta, 2);
		world.setBlock(x+4, y+3, z-1, pane, paneMeta, 2);
		world.setBlock(x+4, y+3, z  , pane, paneMeta, 2);
		world.setBlock(x+4, y+3, z+1, pane, paneMeta, 2);

		world.setBlock(x  , y+3, z-6, main, mainMeta, 2);
		world.setBlock(x-1, y+3, z-5, main, mainMeta, 2);
		world.setBlock(x+1, y+3, z-5, main, mainMeta, 2);
		world.setBlock(x-1, y+3, z-4, pane, paneMeta, 2);
		world.setBlock(x  , y+3, z-4, pane, paneMeta, 2);
		world.setBlock(x+1, y+3, z-4, pane, paneMeta, 2);

		world.setBlock(x  , y+3, z+6, main, mainMeta, 2);
		world.setBlock(x-1, y+3, z+5, main, mainMeta, 2);
		world.setBlock(x+1, y+3, z+5, main, mainMeta, 2);
		world.setBlock(x-1, y+3, z+4, pane, paneMeta, 2);
		world.setBlock(x  , y+3, z+4, pane, paneMeta, 2);
		world.setBlock(x+1, y+3, z+4, pane, paneMeta, 2);
	}
	
	private static void buildLayer7(World world, int x, int y, int z, Block main, int mainMeta, Block slab, int slabMeta, Block glass, int glassMeta, Block pane, int paneMeta, Block liquid, int liquidMeta) {
		world.setBlock(x-6, y+4, z  , main, mainMeta, 2);
		world.setBlock(x-5, y+4, z-1, main, mainMeta, 2);
		world.setBlock(x-5, y+4, z  , liquid, liquidMeta, 2);
		world.setBlock(x-5, y+4, z+1, main, mainMeta, 2);
		world.setBlock(x-4, y+4, z-1, pane, paneMeta, 2);
		world.setBlock(x-4, y+4, z  , pane, paneMeta, 2);
		world.setBlock(x-4, y+4, z+1, pane, paneMeta, 2);

		world.setBlock(x+6, y+4, z  , main, mainMeta, 2);
		world.setBlock(x+5, y+4, z-1, main, mainMeta, 2);
		world.setBlock(x+5, y+4, z  , liquid, liquidMeta, 2);
		world.setBlock(x+5, y+4, z+1, main, mainMeta, 2);
		world.setBlock(x+4, y+4, z-1, pane, paneMeta, 2);
		world.setBlock(x+4, y+4, z  , pane, paneMeta, 2);
		world.setBlock(x+4, y+4, z+1, pane, paneMeta, 2);

		world.setBlock(x  , y+4, z-6, main, mainMeta, 2);
		world.setBlock(x-1, y+4, z-5, main, mainMeta, 2);
		world.setBlock(x  , y+4, z-5, liquid, liquidMeta, 2);
		world.setBlock(x+1, y+4, z-5, main, mainMeta, 2);
		world.setBlock(x-1, y+4, z-4, pane, paneMeta, 2);
		world.setBlock(x  , y+4, z-4, pane, paneMeta, 2);
		world.setBlock(x+1, y+4, z-4, pane, paneMeta, 2);

		world.setBlock(x  , y+4, z+6, main, mainMeta, 2);
		world.setBlock(x-1, y+4, z+5, main, mainMeta, 2);
		world.setBlock(x  , y+4, z+5, liquid, liquidMeta, 2);
		world.setBlock(x+1, y+4, z+5, main, mainMeta, 2);
		world.setBlock(x-1, y+4, z+4, pane, paneMeta, 2);
		world.setBlock(x  , y+4, z+4, pane, paneMeta, 2);
		world.setBlock(x+1, y+4, z+4, pane, paneMeta, 2);
		
		world.setBlock(x-7, y+4, z  , slab, slabMeta, 2);
		world.setBlock(x-6, y+4, z-1, slab, slabMeta, 2);
		world.setBlock(x-6, y+4, z+1, slab, slabMeta, 2);
		world.setBlock(x-5, y+4, z-2, slab, slabMeta, 2);
		world.setBlock(x-5, y+4, z+2, slab, slabMeta, 2);
		world.setBlock(x-4, y+4, z-3, slab, slabMeta, 2);
		world.setBlock(x-4, y+4, z+3, slab, slabMeta, 2);
		world.setBlock(x-3, y+4, z-4, slab, slabMeta, 2);
		world.setBlock(x-3, y+4, z+4, slab, slabMeta, 2);
		world.setBlock(x-2, y+4, z-5, slab, slabMeta, 2);
		world.setBlock(x-2, y+4, z+5, slab, slabMeta, 2);
		world.setBlock(x-1, y+4, z-6, slab, slabMeta, 2);
		world.setBlock(x-1, y+4, z+6, slab, slabMeta, 2);
		world.setBlock(x  , y+4, z-7, slab, slabMeta, 2);
		world.setBlock(x  , y+4, z+7, slab, slabMeta, 2);
		world.setBlock(x+1, y+4, z-6, slab, slabMeta, 2);
		world.setBlock(x+1, y+4, z+6, slab, slabMeta, 2);
		world.setBlock(x+2, y+4, z-5, slab, slabMeta, 2);
		world.setBlock(x+2, y+4, z+5, slab, slabMeta, 2);
		world.setBlock(x+3, y+4, z-4, slab, slabMeta, 2);
		world.setBlock(x+3, y+4, z+4, slab, slabMeta, 2);
		world.setBlock(x+4, y+4, z-3, slab, slabMeta, 2);
		world.setBlock(x+4, y+4, z+3, slab, slabMeta, 2);
		world.setBlock(x+5, y+4, z-2, slab, slabMeta, 2);
		world.setBlock(x+5, y+4, z+2, slab, slabMeta, 2);
		world.setBlock(x+6, y+4, z-1, slab, slabMeta, 2);
		world.setBlock(x+6, y+4, z+1, slab, slabMeta, 2);
		world.setBlock(x+7, y+4, z  , slab, slabMeta, 2);

		world.setBlock(x-4, y+4, z-2, slab, slabMeta+8, 2);
		world.setBlock(x-4, y+4, z+2, slab, slabMeta+8, 2);
		world.setBlock(x-3, y+4, z-3, slab, slabMeta+8, 2);
		world.setBlock(x-3, y+4, z+3, slab, slabMeta+8, 2);
		world.setBlock(x-2, y+4, z-4, slab, slabMeta+8, 2);
		world.setBlock(x-2, y+4, z+4, slab, slabMeta+8, 2);
		world.setBlock(x+4, y+4, z-2, slab, slabMeta+8, 2);
		world.setBlock(x+4, y+4, z+2, slab, slabMeta+8, 2);
		world.setBlock(x+3, y+4, z-3, slab, slabMeta+8, 2);
		world.setBlock(x+3, y+4, z+3, slab, slabMeta+8, 2);
		world.setBlock(x+2, y+4, z-4, slab, slabMeta+8, 2);
		world.setBlock(x+2, y+4, z+4, slab, slabMeta+8, 2);
	}
	
	private static void buildLayer8(World world, int x, int y, int z, Block main, int mainMeta, Block slab, int slabMeta, Block glass, int glassMeta, Block pane, int paneMeta, Block liquid, int liquidMeta) {
		world.setBlock(x-5, y+5, z  , slab, slabMeta, 2);
		
		world.setBlock(x-4, y+5, z-1, slab, slabMeta, 2);
		world.setBlock(x-4, y+5, z  , slab, slabMeta, 2);
		world.setBlock(x-4, y+5, z+1, slab, slabMeta, 2);

		world.setBlock(x-3, y+5, z-2, slab, slabMeta, 2);
		world.setBlock(x-3, y+5, z-1, main, mainMeta, 2);
		world.setBlock(x-3, y+5, z  , main, mainMeta, 2);
		world.setBlock(x-3, y+5, z+1, main, mainMeta, 2);
		world.setBlock(x-3, y+5, z+2, slab, slabMeta, 2);

		world.setBlock(x-2, y+5, z-3, slab, slabMeta, 2);
		world.setBlock(x-2, y+5, z-2, main, mainMeta, 2);
		world.setBlock(x-2, y+5, z-1, main, mainMeta, 2);
		world.setBlock(x-2, y+5, z  , glass, glassMeta, 2);
		world.setBlock(x-2, y+5, z+1, main, mainMeta, 2);
		world.setBlock(x-2, y+5, z+2, main, mainMeta, 2);
		world.setBlock(x-2, y+5, z+3, slab, slabMeta, 2);

		world.setBlock(x-1, y+5, z-4, slab, slabMeta, 2);
		world.setBlock(x-1, y+5, z-3, main, mainMeta, 2);
		world.setBlock(x-1, y+5, z-2, main, mainMeta, 2);
		world.setBlock(x-1, y+5, z-1, glass, glassMeta, 2);
		world.setBlock(x-1, y+5, z  , glass, glassMeta, 2);
		world.setBlock(x-1, y+5, z+1, glass, glassMeta, 2);
		world.setBlock(x-1, y+5, z+2, main, mainMeta, 2);
		world.setBlock(x-1, y+5, z+3, main, mainMeta, 2);
		world.setBlock(x-1, y+5, z+4, slab, slabMeta, 2);

		world.setBlock(x  , y+5, z-5, slab, slabMeta, 2);
		world.setBlock(x  , y+5, z-4, slab, slabMeta, 2);
		world.setBlock(x  , y+5, z-3, main, mainMeta, 2);
		world.setBlock(x  , y+5, z-2, glass, glassMeta, 2);
		world.setBlock(x  , y+5, z-1, glass, glassMeta, 2);
		world.setBlock(x  , y+5, z  , glass, glassMeta, 2);
		world.setBlock(x  , y+5, z+1, glass, glassMeta, 2);
		world.setBlock(x  , y+5, z+2, glass, glassMeta, 2);
		world.setBlock(x  , y+5, z+3, main, mainMeta, 2);
		world.setBlock(x  , y+5, z+4, slab, slabMeta, 2);
		world.setBlock(x  , y+5, z+5, slab, slabMeta, 2);

		world.setBlock(x+1, y+5, z-4, slab, slabMeta, 2);
		world.setBlock(x+1, y+5, z-3, main, mainMeta, 2);
		world.setBlock(x+1, y+5, z-2, main, mainMeta, 2);
		world.setBlock(x+1, y+5, z-1, glass, glassMeta, 2);
		world.setBlock(x+1, y+5, z  , glass, glassMeta, 2);
		world.setBlock(x+1, y+5, z+1, glass, glassMeta, 2);
		world.setBlock(x+1, y+5, z+2, main, mainMeta, 2);
		world.setBlock(x+1, y+5, z+3, main, mainMeta, 2);
		world.setBlock(x+1, y+5, z+4, slab, slabMeta, 2);

		world.setBlock(x+2, y+5, z-3, slab, slabMeta, 2);
		world.setBlock(x+2, y+5, z-2, main, mainMeta, 2);
		world.setBlock(x+2, y+5, z-1, main, mainMeta, 2);
		world.setBlock(x+2, y+5, z  , glass, glassMeta, 2);
		world.setBlock(x+2, y+5, z+1, main, mainMeta, 2);
		world.setBlock(x+2, y+5, z+2, main, mainMeta, 2);
		world.setBlock(x+2, y+5, z+3, slab, slabMeta, 2);

		world.setBlock(x+3, y+5, z-2, slab, slabMeta, 2);
		world.setBlock(x+3, y+5, z-1, main, mainMeta, 2);
		world.setBlock(x+3, y+5, z  , main, mainMeta, 2);
		world.setBlock(x+3, y+5, z+1, main, mainMeta, 2);
		world.setBlock(x+3, y+5, z+2, slab, slabMeta, 2);
		
		world.setBlock(x+4, y+5, z-1, slab, slabMeta, 2);
		world.setBlock(x+4, y+5, z  , slab, slabMeta, 2);
		world.setBlock(x+4, y+5, z+1, slab, slabMeta, 2);
		
		world.setBlock(x+5, y+5, z  , slab, slabMeta, 2);
	}
}