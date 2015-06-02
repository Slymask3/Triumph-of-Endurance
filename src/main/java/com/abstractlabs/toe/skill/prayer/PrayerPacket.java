package com.abstractlabs.toe.skill.prayer;

import io.netty.buffer.ByteBuf;

import com.abstractlabs.toe.skill.DescriptionGUI;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class PrayerPacket implements IMessage {
	private int lvl;
	private int percent;
	
	public PrayerPacket() {}
	
	public PrayerPacket(int level, int per) {
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
	
	public static class Handler implements IMessageHandler<PrayerPacket, IMessage> {
		public IMessage onMessage(PrayerPacket msg, MessageContext ctx) {
			PrayerGUI.lvl = msg.lvl;
			PrayerGUI.percent = msg.percent;
			DescriptionGUI.lvl_prayer = msg.lvl;
			return null;
		}
	}
}