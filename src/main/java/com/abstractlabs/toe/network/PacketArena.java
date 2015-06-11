package com.abstractlabs.toe.network;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.common.DimensionManager;

import com.abstractlabs.toe.client.gui.GuiArenaOverlay;
import com.abstractlabs.toe.utility.LogHelper;
import com.abstractlabs.toe.world.arena.Arena;

public class PacketArena extends AbstractPacket {
	int _packet; //0 = Wave Update, 1 = End Game, 2 = Update, 3 = Timer and Seconds
	int _dim, _x, _y, _z;
	int _wave;
	int _enemiesLeft;
	int _maxWaves;
	boolean _timer;
	int _second;
	
	public PacketArena() {}

	//Packet 0
	public PacketArena(int packet, World world, int x, int y, int z) {
		_packet = packet;
		_dim = world.provider.dimensionId;
		_x = x;
		_y = y;
		_z = z;
	}

	//Packet 1
	public PacketArena(int packet, World world, int x, int y, int z, int wave) {
		_packet = packet;
		_dim = world.provider.dimensionId;
		_x = x;
		_y = y;
		_z = z;
		_wave = wave;
	}

	//Packet 2
	public PacketArena(int packet, World world, int x, int y, int z, int wave, int enemies, int maxWaves) {
		_packet = packet;
		_dim = world.provider.dimensionId;
		_x = x;
		_y = y;
		_z = z;
		_wave = wave;
		_enemiesLeft = enemies;
		_maxWaves = maxWaves;
	}

	//Packet 3
	public PacketArena(int packet, boolean timerRunning, int second) {
		_packet = packet;
		_timer = timerRunning;
		_second = second;
	}

	@Override
	public void encodeInto(ChannelHandlerContext ctx, ByteBuf buffer) {
		buffer.writeInt(_packet);
		buffer.writeInt(_dim);
		buffer.writeInt(_x);
		buffer.writeInt(_y);
		buffer.writeInt(_z);
		buffer.writeInt(_wave);
		buffer.writeInt(_enemiesLeft);
		buffer.writeInt(_maxWaves);
		buffer.writeBoolean(_timer);
		buffer.writeInt(_second);
	}

	@Override
	public void decodeInto(ChannelHandlerContext ctx, ByteBuf buffer) {
		_packet = buffer.readInt();
		_dim = buffer.readInt();
		_x = buffer.readInt();
		_y = buffer.readInt();
		_z = buffer.readInt();
		_wave = buffer.readInt();
		_enemiesLeft = buffer.readInt();
		_maxWaves = buffer.readInt();
		_timer = buffer.readBoolean();
		_second = buffer.readInt();
	}

	@Override
	public void handleClientSide(EntityPlayer player) {
		LogHelper.info("[Packet Arena] handleClientSide();");
		
		//Arena arena = (Arena) DimensionManager.getWorld(_dim).getTileEntity(_x, _y, _z);
		
		//Arena.getArena(player).spawnWave(_wave);
		
		if(_packet == 2) {
			//insert gui vars.
			GuiArenaOverlay.wave = this._wave;
			GuiArenaOverlay.enemiesLeft = this._enemiesLeft;
			GuiArenaOverlay.maxWaves = this._maxWaves;

			LogHelper.info("[Packet Arena] sent variabels to client gui.");
		} else if(_packet == 3) {
			//GuiArenaOverlay.timer = _timer;
			//GuiArenaOverlay.second = _second;
		}
		
		LogHelper.info("handleServerSide() ~ _packet = " + _packet);
	}

	@Override
	public void handleServerSide(EntityPlayer player) {
		LogHelper.info("[Packet Arena] handleServerSide();");
		
		Arena arena = (Arena) DimensionManager.getWorld(_dim).getTileEntity(_x, _y, _z);
		
		//try {
			if(_packet == 0) {
				//Arena.getArena(player).spawnWave(_wave);
				//ArenalismHelper.getProperties(player).updateWave(_wave);
				arena.spawnWave(_wave);
				arena.updateWave(_wave);
				LogHelper.info("handleServerSide.spawnWave(" +_wave+ ")");
			} else if(_packet == 1) {
				arena.endGame();
				//Arena.removePlayer(player);
			}
//		} catch(NullPointerException e) {
//			LogHelper.info("handleServerSide() ~ NullPointerException caught.");
//		}
		
		LogHelper.info("handleServerSide() ~ _packet = " + _packet);
	}
}
