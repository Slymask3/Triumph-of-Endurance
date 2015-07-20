package com.abstractlabs.toe.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

import com.abstractlabs.toe.utility.LogHelper;

public class TileEntityRecall extends TileEntity {
	private String name;
	
	public TileEntityRecall() {
		this.name = "";
	}
	
	@Override
	public void readFromNBT(NBTTagCompound nbt) {
//		NBTTagCompound tag = nbt.getCompoundTag(NBT);
//		this.name = tag.getString("Name");
//		nbt.setTag(NBT, tag);
		
		super.readFromNBT(nbt);
        this.name = nbt.getString("Name");
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
//		NBTTagCompound tag = nbt.getCompoundTag(NBT);
//		tag.setString("Name", this.name);
//		nbt.setTag(NBT, tag);
		
		super.writeToNBT(nbt);
        nbt.setString("Name", this.name);
	}

//	@Override
//	public Packet getDescriptionPacket() {
//		NBTTagCompound tag = new NBTTagCompound();
//		writeToNBT(tag);
//		return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 0, tag);
//	}

//	@Override
//	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
//		readFromNBT(pkt.func_148857_g());
//    }
	
	@Override
    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
        super.onDataPacket(net, pkt);
        NBTTagCompound tag = pkt.func_148857_g();

        this.name = tag.getString("Name");
    }
	
	@Override
    public Packet getDescriptionPacket() {
		S35PacketUpdateTileEntity packet = (S35PacketUpdateTileEntity) super.getDescriptionPacket();
        NBTTagCompound tag = packet != null ? packet.func_148857_g() : new NBTTagCompound();

        tag.setString("Name", this.name);

        return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 1, tag);
    }
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
		LogHelper.info("[TileEntityRecall] set name to " + name);
	}
}