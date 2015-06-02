package com.abstractlabs.toe.skill.mining;

import io.netty.buffer.ByteBuf;

import com.abstractlabs.toe.skill.DescriptionGUI;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class MiningPacket implements IMessage {
	private int lvl;
	private int percent;
	
	public MiningPacket() {}
	
	public MiningPacket(int level, int per) {
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
	
	public static class Handler implements IMessageHandler<MiningPacket, IMessage> {
		public IMessage onMessage(MiningPacket msg, MessageContext ctx) {
			MiningGUI.lvl = msg.lvl;
			MiningGUI.percent = msg.percent;
			DescriptionGUI.lvl_mining = msg.lvl;
			return null;
		}
	}
}