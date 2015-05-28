package com.abstractlabs.toe.handler;

import net.minecraft.world.EnumDifficulty;

import com.abstractlabs.toe.Toe;
import com.abstractlabs.toe.arena.Arena;
import com.abstractlabs.toe.network.PacketArena;
import com.abstractlabs.toe.reference.Color;
import com.abstractlabs.toe.skill.arenalism.ArenalismHelper;
import com.abstractlabs.toe.skill.mining.MiningHelper;
import com.abstractlabs.toe.utility.Helper;
import com.abstractlabs.toe.utility.LogHelper;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;
import cpw.mods.fml.common.gameevent.TickEvent.ServerTickEvent;

public class TickHandler {
	@SubscribeEvent
	public void onPlayerTick(PlayerTickEvent  e) {
		if(ArenalismHelper.getProperties(e.player).inArena() && e.player.worldObj.difficultySetting == EnumDifficulty.PEACEFUL) {
			e.player.worldObj.difficultySetting = EnumDifficulty.EASY;
			Helper.msgClean(e.player, "You are not allowed to change to peaceful mode.", Color.red);
			LogHelper.info("peaceful detected..");
		}
		
		if(MiningHelper.getProperties(e.player) != null) {
//			MiningHelper.getProperties(e.player).addExperience(1);
//	        ArenalismHelper.getProperties(e.player).addExperience(5);
//	        WoodcuttingHelper.getProperties(e.player).addExperience(10);
			//LogHelper.info("1 exp added..");
		}
	}

//	private static Arena arena;
//	
//	private static boolean timerRunning = false;
//	private static int timerSeconds;
//	private static int timer = 0;
//	private static int nextWave;
//	private static int timeRemaining = -1;
//	
//	@SubscribeEvent
//	public void onServerTick(ServerTickEvent e) {
//		if(arena == null) {
//			return;
//		}
//		
//		if(timerRunning) {
//			timer++;
//			if(timer == (timerSeconds*57)) {
//				timer = 0;
//				timerRunning = false;
//				
//				Toe.packetPipeline.sendToServer(new PacketArena(0, arena.getWorldObj(), arena.xCoord, arena.yCoord, arena.zCoord, nextWave));
//			}
//			
//			timeRemaining = timerSeconds-(timer/57);
//			//timeRemaining = timer;
//		} else {
//			if(arena.getEnemiesLeft() == 0) {
//				if(arena.getMaxWaves() == arena.getWave()) {
//					//Arena.getArena(player).endGame();
//					Toe.packetPipeline.sendToServer(new PacketArena(1, arena.getWorldObj(), arena.xCoord, arena.yCoord, arena.zCoord));
//					//Arena.removePlayer(player);
//				} else {
//					arena.intermission(arena.getWave() + 1);
//				}
//				
//				//LogHelper.info("Enemy.getEnemiesRemaining(player) == 0");
//			}
//		}
//	}
//	
//	public static void startTimer(Arena arenaObj, int seconds) {
//		timerRunning = true;
//		timerSeconds = seconds;
//		arena = arenaObj;
//	}
//	
//	public static void updateWave(Arena arenaObj, int wave, int seconds) {
//		timerRunning = true;
//		timerSeconds = seconds;
//		nextWave = wave;
//		arena = arenaObj;
//	}
//	
//	public static int getTimeLeft() {
//		return timeRemaining;
//	}
}