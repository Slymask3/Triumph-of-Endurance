package com.abstractlabs.toe.arena;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;

import com.abstractlabs.toe.Toe;
import com.abstractlabs.toe.network.PacketArena;
import com.abstractlabs.toe.reference.Color;
import com.abstractlabs.toe.skill.arenalism.ArenalismHelper;
import com.abstractlabs.toe.utility.Helper;
import com.abstractlabs.toe.utility.LogHelper;

public abstract class Arena extends TileEntity {
	protected static String NBT = "Arena";
	
	protected EntityPlayer player;
	protected int wave;
	protected int enemiesLeft;
	protected int maxWaves;
	protected int intermissionTime;

	protected boolean timer;
	protected int tick;
	
	public Arena() {
		this.timer = false;
		this.tick = 0;
		this.enemiesLeft = -1;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		NBTTagCompound tag = nbt.getCompoundTag(NBT);
		if (!tag.hasKey("Wave")) return;
		this.wave = tag.getInteger("Wave");
		this.enemiesLeft = tag.getInteger("EnemiesLeft");
		this.maxWaves = tag.getInteger("MaxWaves");
		this.timer = tag.getBoolean("Timer");
		this.tick = tag.getInteger("Tick");
		nbt.setTag(NBT, tag);
		
		LogHelper.info("[TileEntityArena] readFromNBT();");
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		NBTTagCompound tag = nbt.getCompoundTag(NBT);
		tag.setInteger("Wave", this.wave);
		tag.setInteger("EnemiesLeft", this.enemiesLeft);
		tag.setInteger("MaxWaves", this.maxWaves);
		tag.setBoolean("Timer", this.timer);
		tag.setInteger("Tick", this.tick);
		nbt.setTag(NBT, tag);

		LogHelper.info("[TileEntityArena] writeToNBT();");
	}

	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
		readFromNBT(pkt.func_148857_g());
    }
	
	public EntityPlayer getPlayer() {
		return this.player;
	}
	
	public int getWave() {
		return this.wave;
	}
	
	public int getEnemiesLeft() {
		return this.enemiesLeft;
	}
	
	public int getMaxWaves() {
		return this.maxWaves;
	}
	
	public int getIntermissionTime() {
		return this.intermissionTime;
	}
	
	public void updateWave(int wave) {
		this.wave = wave;
		this.sync();
	}
	
	public void updateEnemiesLeft(int enemies) {
		int enemiesLeftOld = this.enemiesLeft;
		this.enemiesLeft = enemies;
		
		if(this.enemiesLeft == 0) { //enemies left are 0, arena should start an intermission.
			if(this.wave == this.maxWaves) {
				endGame();
			} else {
				intermission(this.wave+1);
			}
		}
		
		if(enemiesLeftOld != this.enemiesLeft) {
			this.sync();
		}
	}
	
	public void updateMaxWaves(int maxWaves) {
		this.maxWaves = maxWaves;
		this.sync();
	}
	
	public void start(EntityPlayer player) {
		if(worldObj.isRemote) {
			startClient();
		}
		if(!worldObj.isRemote) {
			this.player = player;
			startServer();
		}
		
		this.sync();
	}

	public void startClient() {
		//nothing needs to be sent to the client in the abstract class.
	}

	public void startServer() {
		ArenalismHelper.getProperties(player).startArena(999, maxWaves);
		removeEntities();
		intermission(1);
	}
	
	public void intermission(int wave) {
		//Enemy.update(player, -1);
		//ArenalismHelper.getProperties(player).updateEnemies(-1);
		
		//set wait to true so the timer will start.
		this.timer = true;
		
		this.enemiesLeft = -1;
		Helper.msgClean(player, "Wave " + wave + "/" +maxWaves+ " is starting in " + intermissionTime + " seconds...", Color.lime);
		//TickHandler.updateWave(this, wave, intermissionTime);
		LogHelper.info("intermission(" +wave+ ")");
		this.sync();
	}
	
	public void removeEntities() {
		List<Entity> entities = worldObj.getEntitiesWithinAABBExcludingEntity(player, AxisAlignedBB.getBoundingBox(xCoord-50, yCoord-50, zCoord-50, xCoord+50, yCoord+50, zCoord+50));
		
		for(int i=0; i<entities.size(); i++) {
			worldObj.removeEntity(entities.get(i));
			LogHelper.info("removed " + entities.get(i).toString());
		}
	}
	
	public void sync() {
		Toe.packetPipeline.sendTo(new PacketArena(2, this.worldObj, this.xCoord, this.yCoord, this.zCoord, this.wave, this.enemiesLeft, this.maxWaves), (EntityPlayerMP) this.player);
	}
	
//	public void syncTimer() {
//		Toe.packetPipeline.sendTo(new PacketArena(3, this.timer, this.tick/20), (EntityPlayerMP) this.player);
//	}
	
	public void updateEntity() { //runs 20 ticks per second
		if(this.timer) { //if timer should run
			if(this.tick == (this.intermissionTime*20)) {
				this.tick = 0;
				this.timer = false;
				
				if(this.wave > this.maxWaves) {
					this.wave = 0;
				} else {
					updateWave(this.wave+1);
					spawnWave(this.wave);
				}
			}
			
			this.tick++;
			
			if(tick%20 == 0 && tick/20 != intermissionTime && tick/20 > 20) { //sync every second (from 9 to 1)
				//this.syncTimer();
				Helper.msgClean(player, "" + (intermissionTime-(tick/20)), Color.red);
				LogHelper.info((intermissionTime-(tick/20)));
				Helper.sound(worldObj, "nevermine:Pop", player.serverPosX, player.serverPosY, player.serverPosZ);
			} else if (tick%20 == 0 && tick/20 != intermissionTime && tick/20 <= 20) { //sync every second (from 30 to 10)
				Helper.msgClean(player, "" + (intermissionTime-(tick/20)), Color.gold);
				LogHelper.info((intermissionTime-(tick/20)));
			}
		}
		
		if(this.enemiesLeft >= 0) {
			updateEnemiesLeft(getEnemiesAround().size());
		}
	}
	
	public List<Entity> getEnemiesAround() {
		List<Entity> entities = worldObj.getEntitiesWithinAABBExcludingEntity(player, AxisAlignedBB.getBoundingBox(xCoord-50, yCoord-50, zCoord-50, xCoord+50, yCoord+50, zCoord+50));
		//List<Entity> entitiesNew;
		
		for(int i=0; i < entities.size(); i++) {
			if(!(entities.get(i) instanceof EntityMob)) {
				entities.remove(i);
			}
		}
		
		return entities;
	}

	public abstract void spawnWave(int wave);
	public abstract void endGame();
}