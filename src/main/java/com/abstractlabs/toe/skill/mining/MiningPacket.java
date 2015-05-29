package com.abstractlabs.toe.skill.mining;

import io.netty.buffer.ByteBuf;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class MiningPacket implements IMessage {
	private int value;
	private int percent;
	
	public MiningPacket() {}
	
	public MiningPacket(int level, int per) {
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
	
	public static class Handler implements IMessageHandler<MiningPacket, IMessage> {
		public IMessage onMessage(MiningPacket msg, MessageContext ctx) {
			MiningGUI.value = msg.value;
			MiningGUI.percent = msg.percent;
			return null;
		}
	}
}