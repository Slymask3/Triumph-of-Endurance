package com.abstractlabs.toe.skill.magic;

import io.netty.buffer.ByteBuf;

import com.abstractlabs.toe.skill.DescriptionGUI;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class MagicPacket implements IMessage {
	private int lvl;
	private int percent;
	
	public MagicPacket() {}
	
	public MagicPacket(int level, int per) {
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
	
	public static class Handler implements IMessageHandler<MagicPacket, IMessage> {
		public IMessage onMessage(MagicPacket msg, MessageContext ctx) {
			MagicGUI.lvl = msg.lvl;
			MagicGUI.percent = msg.percent;
			DescriptionGUI.lvl_magic = msg.lvl;
			return null;
		}
	}
}