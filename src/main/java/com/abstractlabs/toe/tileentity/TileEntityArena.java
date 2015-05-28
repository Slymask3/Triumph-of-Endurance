package com.abstractlabs.toe.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

import com.abstractlabs.toe.utility.LogHelper;

public class TileEntityArena extends TileEntity {
	private static final String NBT = "Arena";
	
	private int wave;
	private int enemiesLeft;
	private int maxWaves;
	
	public TileEntityArena() {
		this.wave = 0;
		this.enemiesLeft = 0;
		this.maxWaves = 0;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		//super.readFromNBT(nbt);
		//variables to read from client
		
		NBTTagCompound tag = nbt.getCompoundTag(NBT);
		//if (!tag.hasKey(LEVEL)) return;
		this.wave = tag.getInteger("Wave");
		this.enemiesLeft = tag.getInteger("EnemiesLeft");
		this.maxWaves = tag.getInteger("MaxWaves");
		nbt.setTag(NBT, tag);
		
		LogHelper.info("[TileEntityArena] readFromNBT();");
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		//super.writeToNBT(nbt);
		//variables to send to server
		
		NBTTagCompound tag = nbt.getCompoundTag(NBT);
		tag.setInteger("Wave", this.wave);
		tag.setInteger("EnemiesLeft", this.enemiesLeft);
		tag.setInteger("MaxWaves", this.maxWaves);
		//n.setTag(NBT, tag);
		nbt.setTag(NBT, tag);

		LogHelper.info("[TileEntityArena] writeToNBT();");
	}

//	@Override
//	public Packet getDescriptionPacket() {
//		NBTTagCompound tag = new NBTTagCompound();
//		writeToNBT(tag);
//		return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 0, tag);
//	}

	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
		readFromNBT(pkt.func_148857_g());
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
	
	public void updateWave(int wave) {
		this.wave = wave;
	}
	
	public void updateEnemiesLeft(int enemies) {
		this.enemiesLeft = enemies;
	}
	
	public void updateMaxWaves(int maxWaves) {
		this.maxWaves = maxWaves;
	}
}