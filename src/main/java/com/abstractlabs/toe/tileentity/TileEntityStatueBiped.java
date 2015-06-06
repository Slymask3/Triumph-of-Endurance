package com.abstractlabs.toe.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

import com.mojang.authlib.GameProfile;

public class TileEntityStatueBiped extends TileEntity {
	private GameProfile gameprofile = null;
	
	public TileEntityStatueBiped() {
		
	}
	
	@Override
	public void readFromNBT(NBTTagCompound nbt) {
//		NBTTagCompound tag = nbt.getCompoundTag(NBT);
//		this.name = tag.getString("Name");
//		nbt.setTag(NBT, tag);
//		
		//LogHelper.info("[TileEntityRecall] readFromNBT();");
		
		if (nbt.hasKey("Owner", 10))
        {
            this.gameprofile = NBTUtil.func_152459_a(nbt.getCompoundTag("Owner"));
        }
//        else if (nbt.hasKey("ExtraType", 8) && !StringUtils.isNullOrEmpty(nbt.getString("ExtraType")))
//        {
//            this.gameprofile = new GameProfile((UUID)null, nbt.getString("ExtraType"));
//            //this.func_152109_d();
//        }
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
//		NBTTagCompound tag = nbt.getCompoundTag(NBT);
//		tag.setString("Name", this.name);
//		nbt.setTag(NBT, tag);

		//LogHelper.info("[TileEntityRecall] writeToNBT();");
		
		if (this.gameprofile != null) {
            NBTTagCompound nbttagcompound1 = new NBTTagCompound();
            NBTUtil.func_152460_a(nbttagcompound1, this.gameprofile);
            nbt.setTag("Owner", nbttagcompound1);
        }
	}

	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
		readFromNBT(pkt.func_148857_g());
    }
	
	public GameProfile getGameProfile() {
        return this.gameprofile;
    }
	
	public void setGameProfile(GameProfile gameprofile) {
        this.gameprofile = gameprofile;
    }
}