package com.abstractlabs.toe.arena;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import com.abstractlabs.toe.player.Cash;

public class Arena {
	protected World world;
	protected int x;
	protected int y;
	protected int z;
	protected EntityPlayer player;
	protected int wave;
	
	public Arena(World world, int x, int y, int z, EntityPlayer player) {
		this.world = world;
		this.x = x;
		this.y = y;
		this.z = z;
		this.player = player;
	}
	
	public void start() {
		Cash.addPlayer(player, 1000);
		this.wave = 1;
	}
	
	public World getWorld() {
		return this.world;
	}
	
	public EntityPlayer getPlayer() {
		return this.player;
	}
	
	public int getWave() {
		return this.wave;
	}
}