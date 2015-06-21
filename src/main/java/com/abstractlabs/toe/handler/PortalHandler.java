package com.abstractlabs.toe.handler;

import net.minecraft.block.BlockFire;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraftforge.event.world.BlockEvent;

import com.abstractlabs.toe.block.BlockPortalCallisto;
import com.abstractlabs.toe.init.ToeBlocks;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class PortalHandler {
	@SubscribeEvent
	public void onBlockPlace(BlockEvent.PlaceEvent e) {
		if(e.block == Blocks.fire) {
			World world = e.world;
			int x = e.x;
			int y = e.y;
			int z = e.z;
			BlockFire block = (BlockFire) e.block;
			
			if (world.provider.dimensionId > 0 || !((BlockPortalCallisto) ToeBlocks.portalCallisto).getPortalSize(world, x, y, z)){
	            if (!World.doesBlockHaveSolidTopSurface(world, x, y - 1, z) /*&& !block.canNeighborBurn(world, x, y, z)*/) {
	                world.setBlockToAir(x, y, z);
	            } else {
	                if(world.provider.dimensionId != 0) {
	                    world.scheduleBlockUpdate(x, y, z, block, block.tickRate(world) + world.rand.nextInt(10));
	                }
	                world.scheduleBlockUpdate(x, y, z, block, block.tickRate(world) + world.rand.nextInt(10));
	            }
	        }
		}
		
		//LogHelper.info("[PortalHandler] block == " + e.block);
	}
}
