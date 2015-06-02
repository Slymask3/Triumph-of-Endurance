package com.abstractlabs.toe.skill.agility;

import io.netty.buffer.ByteBuf;

import com.abstractlabs.toe.skill.DescriptionGUI;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class AgilityPacket implements IMessage {
	private int lvl;
	private int percent;
	
	public AgilityPacket() {}
	
	public AgilityPacket(int level, int per) {
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
	
	public static class Handler implements IMessageHandler<AgilityPacket, IMessage> {
		public IMessage onMessage(AgilityPacket msg, MessageContext ctx) {
			AgilityGUI.lvl = msg.lvl;
			AgilityGUI.percent = msg.percent;
			DescriptionGUI.lvl_agility = msg.lvl;
			return null;
		}
	}
}