package com.abstractlabs.toe.player;

import java.util.HashMap;

import net.minecraft.entity.player.EntityPlayer;

import com.abstractlabs.toe.utility.LogHelper;

public class Cash {
	private static HashMap<EntityPlayer, Integer> cash = new HashMap<EntityPlayer, Integer>();
	
	public static void addPlayer(EntityPlayer player, int amount) {
		if(!cash.containsKey(player)) {
			cash.put(player, amount);
		} else {
			LogHelper.info(player.getDisplayName() + " already exists.");
		}
	}
	
	public static int getCash(EntityPlayer player) {
		if(cash.containsKey(player)) {
			return cash.get(player);
		} else {
			return -1;
		}
	}
	
	public static void setScore(EntityPlayer player, int score) {
		if(cash.containsKey(player)) {
			cash.put(player, score);
		} else {
			LogHelper.info(player.getDisplayName() + " does not exist.");
		}
	}
	
	public static void buyItem(EntityPlayer player, int price) {
		if(cash.containsKey(player)) {
			LogHelper.info("cash: " + cash.get(player));
			cash.put(player, cash.get(player) - price);
			LogHelper.info("player: " + player.getDisplayName());
			LogHelper.info("price: " + price);
			LogHelper.info("cash: " + cash.get(player));
		} else {
			LogHelper.info(player.getDisplayName() + " does not exist.");
		}
	}
	
	public static void removePlayer(EntityPlayer player) {
		if(cash.containsKey(player)) {
			cash.remove(player);
		} else {
			LogHelper.info(player.getDisplayName() + " does not exist.");
		}
	}

	public static boolean doesPlayerHaveEnough(EntityPlayer player, int price) {
		if(cash.containsKey(player)) {
			if(cash.get(player) >= price) {
				return true;
			}
		} else {
			LogHelper.info(player.getDisplayName() + " does not exist.");
		}
		
		return false;
	}
}