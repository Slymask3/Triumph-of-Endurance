package com.abstractlabs.toe.skill.theiving;

import io.netty.buffer.ByteBuf;

import com.abstractlabs.toe.skill.DescriptionGUI;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class ThievingPacket implements IMessage {
	private int lvl;
	private int percent;
	
	public ThievingPacket() {}
	
	public ThievingPacket(int level, int per) {
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
	
	public static class Handler implements IMessageHandler<ThievingPacket, IMessage> {
		public IMessage onMessage(ThievingPacket msg, MessageContext ctx) {
			ThievingGUI.lvl = msg.lvl;
			ThievingGUI.percent = msg.percent;
			DescriptionGUI.lvl_thieving = msg.lvl;
			return null;
		}
	}
}