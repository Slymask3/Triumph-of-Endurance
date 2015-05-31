package com.abstractlabs.toe.handler;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

import com.abstractlabs.toe.init.ToePackets;
import com.abstractlabs.toe.reference.Color;
import com.abstractlabs.toe.reference.Reference;
import com.abstractlabs.toe.skill.arenalism.ArenalismHelper;
import com.abstractlabs.toe.skill.arenalism.ArenalismPacket;
import com.abstractlabs.toe.skill.mining.MiningHelper;
import com.abstractlabs.toe.skill.mining.MiningPacket;
import com.abstractlabs.toe.skill.theiving.ThievingHelper;
import com.abstractlabs.toe.skill.theiving.ThievingPacket;
import com.abstractlabs.toe.skill.woodcutting.WoodcuttingHelper;
import com.abstractlabs.toe.skill.woodcutting.WoodcuttingPacket;
import com.abstractlabs.toe.utility.Helper;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;

public class ConnectionHandler {
	@SubscribeEvent
	public void onClientConnection(PlayerLoggedInEvent event) {
		EntityPlayer player = event.player;
		
		Helper.msgClean(player, "\u00a7aLoaded successfully.", Color.lime);
		
		try {
			URL url = new URL(Reference.CHECK_URL);
			Scanner s = new Scanner(url.openStream());
			
			String ver = s.nextLine();
			String mc = s.nextLine();
			
			if (!ver.equalsIgnoreCase(Reference.VERSION)) {
				Helper.msgBypassClean(player, "\u00a7cUpdate avaliable: v" + ver + " \u00a7c(MC " + mc + ")!", Color.red);
				Helper.msgBypassClean(player, "\u00a7cLink: \u00a7b\u00a7n//todo", Color.red); //todo link
			}
			
			s.close();
		} catch(IOException ex) {
			ex.printStackTrace();
		}
	}
	
//	@SubscribeEvent(priority=EventPriority.HIGHEST)
//	public void onClientDisconnection(PlayerLoggedOutEvent event) {
//		//event.setCanceled(true);
//		LogHelper.info("logged out");
//		
//		
//		EntityPlayer player = event.player;
//		
////		if(Position.playerExists(player)) {
////			Position pos = Position.getPosition(player);
////			player.setPositionAndUpdate(pos.getX(), pos.getY(), pos.getZ());
////			Position.removePlayer(player);
////			Helper.msgClean(player, "\u00a7aYou logged off during an arena. You have been teleported back to the entrance.", Color.red);
////		}
//	}
	
//	@SubscribeEvent(priority=EventPriority.HIGHEST)
//	public void onClientDisconnectionServer(ServerDisconnectionFromClientEvent event) {
//		//event.setCanceled(true);
//		LogHelper.info("logged out (new)");
//		
//		NetHandlerPlayServer handler = (NetHandlerPlayServer)event.handler;
//		EntityPlayer player = handler.playerEntity;
//		
////		if(Position.playerExists(player)) {
////			Position pos = Position.getPosition(player);
////			player.setPositionAndUpdate(pos.getX(), pos.getY(), pos.getZ());
////			Position.removePlayer(player);
////			Helper.msgClean(player, "\u00a7aYou logged off during an arena. You have been teleported back to the entrance.", Color.red);
////		}
//	}

	
	@SubscribeEvent
	public void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent e) {
		if (e.player instanceof EntityPlayer) {
			EntityPlayer p = e.player;
			if (p instanceof EntityPlayerMP) {
		        ToePackets.network.sendTo(new ArenalismPacket(ArenalismHelper.getProperties(p).getLevel(), ArenalismHelper.getProperties(p).progressPercentage(), ArenalismHelper.getProperties(p).inArena(), ArenalismHelper.getProperties(p).getCash()), (EntityPlayerMP)p);
		        ToePackets.network.sendTo(new MiningPacket(MiningHelper.getProperties(p).getLevel(), MiningHelper.getProperties(p).progressPercentage()), (EntityPlayerMP)p);
		        ToePackets.network.sendTo(new WoodcuttingPacket(WoodcuttingHelper.getProperties(p).getLevel(), WoodcuttingHelper.getProperties(p).progressPercentage()), (EntityPlayerMP)p);
		        ToePackets.network.sendTo(new ThievingPacket(ThievingHelper.getProperties(p).getLevel(), ThievingHelper.getProperties(p).progressPercentage()), (EntityPlayerMP)p);
		        //have to update packets (wave, enemiesLeft, maxWaves)
			}
	    } 
	}
}
