package com.abstractlabs.toe.arena;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class ArenaDesert extends Arena {
	public ArenaDesert(World world, int x, int y, int z, EntityPlayer player) {
		super(world, x, y, z, player);
	}
	
	public void start() {
		super.start();
		player.setPositionAndUpdate(x, y-34, z);
	}
}