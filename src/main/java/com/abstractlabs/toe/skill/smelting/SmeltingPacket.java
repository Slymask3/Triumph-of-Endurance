package com.abstractlabs.toe.skill.smelting;

import io.netty.buffer.ByteBuf;

import com.abstractlabs.toe.skill.DescriptionGUI;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class SmeltingPacket implements IMessage {
	private int lvl;
	private int percent;
	
	public SmeltingPacket() {}
	
	public SmeltingPacket(int level, int per) {
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
	
	public static class Handler implements IMessageHandler<SmeltingPacket, IMessage> {
		public IMessage onMessage(SmeltingPacket msg, MessageContext ctx) {
			SmeltingGUI.lvl = msg.lvl;
			SmeltingGUI.percent = msg.percent;
			DescriptionGUI.lvl_smelting = msg.lvl;
			return null;
		}
	}
}