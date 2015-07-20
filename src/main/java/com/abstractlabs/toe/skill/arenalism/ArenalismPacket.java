package com.abstractlabs.toe.skill.arenalism;

import io.netty.buffer.ByteBuf;

import com.abstractlabs.toe.client.gui.screen.GuiArenaOverlay;
import com.abstractlabs.toe.skill.DescriptionGUI;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class ArenalismPacket implements IMessage {
	private int lvl;
	private int percent;
	private boolean inArena;
	private int cash;
//	private int wave;
//	private int enemiesLeft;
//	private int maxWaves;
	
	public ArenalismPacket() {}
	
	public ArenalismPacket(int level, int per, boolean inArena, int cash) {
		this.lvl = level;
		this.percent = per;
		this.inArena = inArena;
		this.cash = cash;
	}
	
	public void fromBytes(ByteBuf buf) {
		this.lvl = buf.readInt();
		this.percent = buf.readInt();
		this.inArena = buf.readBoolean();
		this.cash = buf.readInt();
	}
	
	public void toBytes(ByteBuf buf) {
		buf.writeInt(this.lvl);
		buf.writeInt(this.percent);
		buf.writeBoolean(this.inArena);
		buf.writeInt(this.cash);
	}
	
	public static class Handler implements IMessageHandler<ArenalismPacket, IMessage> {
		public IMessage onMessage(ArenalismPacket msg, MessageContext ctx) {
			ArenalismGUI.lvl = msg.lvl;
			ArenalismGUI.percent = msg.percent;
			GuiArenaOverlay.inArena = msg.inArena;
			GuiArenaOverlay.cash = msg.cash;
			DescriptionGUI.lvl_arenalism = msg.lvl;
			return null;
		}
	}
}