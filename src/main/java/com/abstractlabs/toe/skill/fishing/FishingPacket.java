package com.abstractlabs.toe.skill.fishing;

import io.netty.buffer.ByteBuf;

import com.abstractlabs.toe.skill.DescriptionGUI;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class FishingPacket implements IMessage {
	private int lvl;
	private int percent;
	
	public FishingPacket() {}
	
	public FishingPacket(int level, int per) {
		this.lvl = level;
		this.percent = per;
	}
	
	public void fromBytes(ByteBuf buf) {
		this.lvl = buf.readInt();
		this.percent = buf.readInt();
	}
	
	public void toBytes(ByteBuf buf) {
		buf.writeInt(this.lvl);
		buf.writeInt(this.percent);
	}
	
	public static class Handler implements IMessageHandler<FishingPacket, IMessage> {
		public IMessage onMessage(FishingPacket msg, MessageContext ctx) {
			FishingGUI.lvl = msg.lvl;
			FishingGUI.percent = msg.percent;
			DescriptionGUI.lvl_fishing = msg.lvl;
			return null;
		}
	}
}