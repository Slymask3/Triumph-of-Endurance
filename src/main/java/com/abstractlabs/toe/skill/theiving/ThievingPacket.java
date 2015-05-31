package com.abstractlabs.toe.skill.theiving;

import io.netty.buffer.ByteBuf;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class ThievingPacket implements IMessage {
	private int value;
	private int percent;
	
	public ThievingPacket() {}
	
	public ThievingPacket(int level, int per) {
		this.value = level;
		this.percent = per;
	}
	
	public void fromBytes(ByteBuf buf) {
		this.value = buf.readInt();
		this.percent = buf.readInt();
	}
	
	public void toBytes(ByteBuf buf) {
		buf.writeInt(this.value);
		buf.writeInt(this.percent);
	}
	
	public static class Handler implements IMessageHandler<ThievingPacket, IMessage> {
		public IMessage onMessage(ThievingPacket msg, MessageContext ctx) {
			ThievingGUI.value = msg.value;
			ThievingGUI.percent = msg.percent;
			return null;
		}
	}
}