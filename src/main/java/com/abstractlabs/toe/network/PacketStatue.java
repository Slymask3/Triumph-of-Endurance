package com.abstractlabs.toe.network;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.common.DimensionManager;

import com.abstractlabs.toe.tileentity.TileEntityStatueBiped;
import com.abstractlabs.toe.utility.LogHelper;

import cpw.mods.fml.common.network.ByteBufUtils;

public class PacketStatue extends AbstractPacket {
	int _dim, _x, _y, _z;
	String _name;
	
	public PacketStatue() {}

	public PacketStatue(World world, int x, int y, int z, String name) {
		_dim = world.provider.dimensionId;
		_x = x;
		_y = y;
		_z = z;
		_name = name;
	}

	@Override
	public void encodeInto(ChannelHandlerContext ctx, ByteBuf buffer) {
		buffer.writeInt(_dim);
		buffer.writeInt(_x);
		buffer.writeInt(_y);
		buffer.writeInt(_z);
		ByteBufUtils.writeUTF8String(buffer, _name);
	}

	@Override
	public void decodeInto(ChannelHandlerContext ctx, ByteBuf buffer) {
		_dim = buffer.readInt();
		_x = buffer.readInt();
		_y = buffer.readInt();
		_z = buffer.readInt();
		_name = ByteBufUtils.readUTF8String(buffer);
	}

	@Override
	public void handleClientSide(EntityPlayer player) {
		TileEntityStatueBiped te = (TileEntityStatueBiped) DimensionManager.getWorld(_dim).getTileEntity(_x, _y, _z);
		te.setUsername(_name);
		
		LogHelper.info("[PacketStatue] handleClientSide() - set username to == " + _name);
	}

	@Override
	public void handleServerSide(EntityPlayer player) {
		TileEntityStatueBiped te = (TileEntityStatueBiped) DimensionManager.getWorld(_dim).getTileEntity(_x, _y, _z);
		te.setUsername(_name);
		
		LogHelper.info("[PacketStatue] handlerServerSide()- set username to == " + _name);
	}
}
