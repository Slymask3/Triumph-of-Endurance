package com.abstractlabs.toe.skill.woodcutting;

import io.netty.buffer.ByteBuf;

import com.abstractlabs.toe.skill.DescriptionGUI;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class WoodcuttingPacket implements IMessage {
	private int lvl;
	private int percent;
	
	public WoodcuttingPacket() {}
	
	public WoodcuttingPacket(int level, int per) {
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
	
	public static class Handler implements IMessageHandler<WoodcuttingPacket, IMessage> {
		public IMessage onMessage(WoodcuttingPacket msg, MessageContext ctx) {
			WoodcuttingGUI.lvl = msg.lvl;
			WoodcuttingGUI.percent = msg.percent;
			DescriptionGUI.lvl_woodcutting = msg.lvl;
			return null;
		}
	}
}