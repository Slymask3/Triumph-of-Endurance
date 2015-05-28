package com.abstractlabs.toe.skill.arenalism;

import io.netty.buffer.ByteBuf;

import com.abstractlabs.toe.gui.GuiArenaOverlay;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class ArenalismPacket implements IMessage {
	private int value;
	private int percent;
	private boolean inArena;
	private int cash;
//	private int wave;
//	private int enemiesLeft;
//	private int maxWaves;
	
	public ArenalismPacket() {}
	
	public ArenalismPacket(int level, int per, boolean inArena, int cash) {
		this.value = level;
		this.percent = per;
		this.inArena = inArena;
		this.cash = cash;
//		this.wave = wave;
//		this.enemiesLeft = enemiesLeft;
//		this.maxWaves = maxWaves;
	}
	
	public void fromBytes(ByteBuf buf) {
		this.value = buf.readInt();
		this.percent = buf.readInt();
		this.inArena = buf.readBoolean();
		this.cash = buf.readInt();
//		this.wave = buf.readInt();
//		this.enemiesLeft = buf.readInt();
//		this.maxWaves = buf.readInt();
	}
	
	public void toBytes(ByteBuf buf) {
		buf.writeInt(this.value);
		buf.writeInt(this.percent);
		buf.writeBoolean(this.inArena);
		buf.writeInt(this.cash);
//		buf.writeInt(this.wave);
//		buf.writeInt(this.enemiesLeft);
//		buf.writeInt(this.maxWaves);
	}
	
	public static class Handler implements IMessageHandler<ArenalismPacket, IMessage> {
		public IMessage onMessage(ArenalismPacket msg, MessageContext ctx) {
			ArenalismGUI.value = msg.value;
			ArenalismGUI.percent = msg.percent;
			GuiArenaOverlay.inArena = msg.inArena;
			GuiArenaOverlay.cash = msg.cash;
//			GuiArenaOverlay.wave = msg.wave;
//			GuiArenaOverlay.enemiesLeft = msg.enemiesLeft;
//			GuiArenaOverlay.maxWaves = msg.maxWaves;
			return null;
		}
	}
}