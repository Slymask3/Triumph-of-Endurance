package com.abstractlabs.toe.network;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;

import com.abstractlabs.toe.utility.LogHelper;

public class PacketGrapplingHook extends AbstractPacket {
	boolean hook;
	
	public PacketGrapplingHook() {}

	public PacketGrapplingHook(boolean hook) {
		this.hook = hook;
	}

	@Override
	public void encodeInto(ChannelHandlerContext ctx, ByteBuf buffer) {
		buffer.writeBoolean(hook);
	}

	@Override
	public void decodeInto(ChannelHandlerContext ctx, ByteBuf buffer) {
		hook = buffer.readBoolean();
	}

	@Override
	public void handleClientSide(EntityPlayer player) {
		LogHelper.info("[PacketGrappingHook] handleClientSide();");
	}

	@Override
	public void handleServerSide(EntityPlayer player) {
		LogHelper.info("[PacketGrappingHook] handleServerSide();");
	}
}