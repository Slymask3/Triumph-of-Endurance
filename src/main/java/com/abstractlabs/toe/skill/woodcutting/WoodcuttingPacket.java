package com.abstractlabs.toe.skill.woodcutting;

import io.netty.buffer.ByteBuf;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class WoodcuttingPacket implements IMessage {
	private int value;
	private int percent;
	
	public WoodcuttingPacket() {}
	
	public WoodcuttingPacket(int level, int per) {
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
	
	public static class Handler implements IMessageHandler<WoodcuttingPacket, IMessage> {
		public IMessage onMessage(WoodcuttingPacket msg, MessageContext ctx) {
			WoodcuttingGUI.value = msg.value;
			WoodcuttingGUI.percent = msg.percent;
			return null;
		}
	}
}