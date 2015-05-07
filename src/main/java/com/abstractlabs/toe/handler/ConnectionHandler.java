package com.abstractlabs.toe.handler;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

import net.minecraft.entity.player.EntityPlayer;

import com.abstractlabs.toe.reference.Color;
import com.abstractlabs.toe.reference.Reference;
import com.abstractlabs.toe.utility.Helper;
import com.abstractlabs.toe.utility.LogHelper;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
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
}
