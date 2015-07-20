package com.abstractlabs.toe.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

import com.abstractlabs.toe.utility.LogHelper;

public class TileEntityStatueBiped extends TileEntity {
	private String username = "";
	
	public TileEntityStatueBiped() {
		
	}
	
	@Override
	public void readFromNBT(NBTTagCompound nbt) {
//		NBTTagCompound tag = nbt.getCompoundTag(NBT);
//		this.username = tag.getString("Username");
//		nbt.setTag(NBT, tag);
		
		super.readFromNBT(nbt);
        this.username = nbt.getString("Username");

        //Toe.packetPipeline.sendToAll(new PacketStatue(this.worldObj, this.xCoord, this.yCoord, this.zCoord, this.username));
        
        LogHelper.info("[TileEntityStatue] readFromNBT() | NBT == " + nbt.getString("Username") + " | var == " + this.username);
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
//		NBTTagCompound tag = nbt.getCompoundTag(NBT);
//		tag.setString("Username", this.username);
//		nbt.setTag(NBT, tag);
		
		super.writeToNBT(nbt);
        nbt.setString("Username", this.username);
        
        //Toe.packetPipeline.sendToAll(new PacketStatue(this.worldObj, this.xCoord, this.yCoord, this.zCoord, this.username));
        
        LogHelper.info("[TileEntityStatue] writeToNBT() | NBT == " + nbt.getString("Username") + " | var == " + this.username);
	}

    @Override
    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
        super.onDataPacket(net, pkt);
        NBTTagCompound tag = pkt.func_148857_g();

        this.username = tag.getString("Username");
    }
	
	@Override
    public Packet getDescriptionPacket() {
		S35PacketUpdateTileEntity packet = (S35PacketUpdateTileEntity) super.getDescriptionPacket();
        NBTTagCompound tag = packet != null ? packet.func_148857_g() : new NBTTagCompound();

        tag.setString("Username", this.username);

        return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 1, tag);
    }
	
	public String getUsername() {
        return this.username;
    }
	
	public void setUsername(String username) {
        this.username = username;
    }
}