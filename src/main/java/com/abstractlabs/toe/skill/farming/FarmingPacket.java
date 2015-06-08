package com.abstractlabs.toe.skill.farming;

import io.netty.buffer.ByteBuf;

import com.abstractlabs.toe.skill.DescriptionGUI;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class FarmingPacket implements IMessage {
	private int lvl;
	private int percent;
	
	public FarmingPacket() {}
	
	public FarmingPacket(int level, int per) {
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
	
	public static class Handler implements IMessageHandler<FarmingPacket, IMessage> {
		public IMessage onMessage(FarmingPacket msg, MessageContext ctx) {
			FarmingGUI.lvl = msg.lvl;
			FarmingGUI.percent = msg.percent;
			DescriptionGUI.lvl_farming = msg.lvl;
			return null;
		}
	}
}