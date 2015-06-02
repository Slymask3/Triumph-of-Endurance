package com.abstractlabs.toe.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

import com.abstractlabs.toe.utility.LogHelper;

public class TileEntityLandmine extends TileEntity {
	public TileEntityLandmine() {
		
	}
	
	@Override
	public void readFromNBT(NBTTagCompound nbt) {
//		NBTTagCompound tag = nbt.getCompoundTag(NBT);
//		this.name = tag.getString("Name");
//		nbt.setTag(NBT, tag);
//		
		//LogHelper.info("[TileEntityRecall] readFromNBT();");
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
//		NBTTagCompound tag = nbt.getCompoundTag(NBT);
//		tag.setString("Name", this.name);
//		nbt.setTag(NBT, tag);

		//LogHelper.info("[TileEntityRecall] writeToNBT();");
	}

	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
		readFromNBT(pkt.func_148857_g());
    }
}