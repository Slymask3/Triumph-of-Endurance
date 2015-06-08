package com.abstractlabs.toe.network;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import com.abstractlabs.toe.gui.GuiScreenOverlay;
import com.abstractlabs.toe.skill.arenalism.ArenalismHelper;
import com.abstractlabs.toe.utility.LogHelper;

import cpw.mods.fml.common.network.ByteBufUtils;

public class PacketScreenOverlay extends AbstractPacket {
	int ticks;
	int screen;
	
	public PacketScreenOverlay() {}

	public PacketScreenOverlay(int ticks, int screen) {
		this.ticks = ticks;
		this.screen = screen;
	}

	@Override
	public void encodeInto(ChannelHandlerContext ctx, ByteBuf buffer) {
		buffer.writeInt(ticks);
		buffer.writeInt(screen);
	}

	@Override
	public void decodeInto(ChannelHandlerContext ctx, ByteBuf buffer) {
		ticks = buffer.readInt();
		screen = buffer.readInt();
	}

	@Override
	public void handleClientSide(EntityPlayer player) {
		GuiScreenOverlay.showTicks = ticks;
		GuiScreenOverlay.image = screen;
		
		LogHelper.info("handleclient");
	}

	@Override
	public void handleServerSide(EntityPlayer player) {
		//nothign needs to be sent to the server
		LogHelper.info("handleserver");
	}
}
