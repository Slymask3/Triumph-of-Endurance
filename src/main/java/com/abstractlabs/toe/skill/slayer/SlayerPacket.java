package com.abstractlabs.toe.skill.slayer;

import io.netty.buffer.ByteBuf;

import com.abstractlabs.toe.skill.DescriptionGUI;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class SlayerPacket implements IMessage {
	private int lvl;
	private int percent;
	
	public SlayerPacket() {}
	
	public SlayerPacket(int level, int per) {
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
	
	public static class Handler implements IMessageHandler<SlayerPacket, IMessage> {
		public IMessage onMessage(SlayerPacket msg, MessageContext ctx) {
			SlayerGUI.lvl = msg.lvl;
			SlayerGUI.percent = msg.percent;
			DescriptionGUI.lvl_slayer = msg.lvl;
			return null;
		}
	}
}