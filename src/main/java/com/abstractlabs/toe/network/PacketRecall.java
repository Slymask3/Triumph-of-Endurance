package com.abstractlabs.toe.network;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.common.DimensionManager;

import com.abstractlabs.toe.reference.Color;
import com.abstractlabs.toe.tileentity.TileEntityRecall;
import com.abstractlabs.toe.utility.Helper;
import com.abstractlabs.toe.utility.LogHelper;

import cpw.mods.fml.common.network.ByteBufUtils;

public class PacketRecall extends AbstractPacket {
	int _dim, _x, _y, _z;
	String _name;
	
	public PacketRecall() {}

	public PacketRecall(World world, int x, int y, int z, String name) {
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
		
	}

	@Override
	public void handleServerSide(EntityPlayer player) {
		TileEntityRecall te = (TileEntityRecall) DimensionManager.getWorld(_dim).getTileEntity(_x, _y, _z);
		te.setName(_name);
		
		LogHelper.info("[PacketRecall] handlerServerSide()");
	}
}
