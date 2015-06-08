package com.abstractlabs.toe.handler;

import net.minecraft.world.EnumDifficulty;

import com.abstractlabs.toe.reference.Color;
import com.abstractlabs.toe.skill.arenalism.ArenalismHelper;
import com.abstractlabs.toe.utility.Helper;
import com.abstractlabs.toe.utility.LogHelper;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;

public class TickHandler {
	@SubscribeEvent
	public void onPlayerTick(PlayerTickEvent  e) {
		if(ArenalismHelper.getProperties(e.player) != null) {
			if(ArenalismHelper.getProperties(e.player).inArena() && e.player.worldObj.difficultySetting == EnumDifficulty.PEACEFUL) {
				e.player.worldObj.difficultySetting = EnumDifficulty.EASY;
				Helper.msgClean(e.player, "You are not allowed to change to peaceful mode.", Color.red);
				LogHelper.info("peaceful detected..");
			}
		}
	}
}