package com.abstractlabs.toe.utility;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

import com.abstractlabs.toe.handler.ConfigurationHandler;
import com.abstractlabs.toe.reference.Reference;

public class Helper {
	public static void msg(EntityPlayer player, String msg, String color) {
		if (ConfigurationHandler.msg == true) {
			if (player.worldObj.isRemote) { //IF CLIENT	
				msgBypassClean(player, msg, color);
			}
		}
	}
	
	public static void msgBypass(EntityPlayer player, String msg, String color) {
		if (player.worldObj.isRemote) { //IF CLIENT	
			msgBypassClean(player, msg, color);
		}
	}
	
	public static void msgClean(EntityPlayer player, String msg, String color) {
		if (ConfigurationHandler.msg == true) {
			msgBypassClean(player, msg, color);
		}
	}
	
	public static void msgBypassClean(EntityPlayer player, String msg, String color) {
		player.addChatMessage(new ChatComponentText("\u00a78[\u00a73" + Reference.MOD_ACRONYM + " v" + Reference.VERSION + "\u00a78] \u00a7" + color + colorEveryWord(msg, color)));
	}
	
	public static String colorEveryWord(String msg, String color) {
	    StringBuilder builder = new StringBuilder(msg.length());

	    for (int i = 0; i < msg.length(); i++) {
	        char c = msg.charAt(i);
	        switch (c) {
	            case ' ': builder.append(" \u00a7" + color); break;
	            default: builder.append(c); break;
	        }
	    }
	    return builder.toString();
	}
	
	public static void sound(World world, String sound, int x, int y, int z) {
		world.playSoundEffect((double)((float)x + 0.5F), (double)((float)y + 0.5F), (double)((float)z + 0.5F), sound, 2.0F, 1.0F);
	}
}
