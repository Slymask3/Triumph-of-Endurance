package com.abstractlabs.toe.skill.cooking;

import io.netty.buffer.ByteBuf;

import com.abstractlabs.toe.skill.DescriptionGUI;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class CookingPacket implements IMessage {
	private int lvl;
	private int percent;
	
	public CookingPacket() {}
	
	public CookingPacket(int level, int per) {
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
	
	public static class Handler implements IMessageHandler<CookingPacket, IMessage> {
		public IMessage onMessage(CookingPacket msg, MessageContext ctx) {
			CookingGUI.lvl = msg.lvl;
			CookingGUI.percent = msg.percent;
			DescriptionGUI.lvl_cooking = msg.lvl;
			return null;
		}
	}
}