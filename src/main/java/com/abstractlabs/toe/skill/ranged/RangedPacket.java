package com.abstractlabs.toe.skill.ranged;

import io.netty.buffer.ByteBuf;

import com.abstractlabs.toe.skill.DescriptionGUI;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class RangedPacket implements IMessage {
	private int lvl;
	private int percent;
	
	public RangedPacket() {}
	
	public RangedPacket(int level, int per) {
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
	
	public static class Handler implements IMessageHandler<RangedPacket, IMessage> {
		public IMessage onMessage(RangedPacket msg, MessageContext ctx) {
			RangedGUI.lvl = msg.lvl;
			RangedGUI.percent = msg.percent;
			DescriptionGUI.lvl_ranged = msg.lvl;
			return null;
		}
	}
}