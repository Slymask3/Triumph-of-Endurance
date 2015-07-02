package com.abstractlabs.toe.handler;

import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.EnumDifficulty;

import com.abstractlabs.toe.init.ToeDimensions;
import com.abstractlabs.toe.init.ToeItems;
import com.abstractlabs.toe.reference.Color;
import com.abstractlabs.toe.skill.arenalism.ArenalismHelper;
import com.abstractlabs.toe.utility.Helper;
import com.abstractlabs.toe.utility.LogHelper;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;

public class TickHandler {
	private int ticks = 0;
	
	@SubscribeEvent
	public void onPlayerTick(PlayerTickEvent  e) {
		if(ArenalismHelper.getProperties(e.player) != null) {
			if(ArenalismHelper.getProperties(e.player).inArena() && e.player.worldObj.difficultySetting == EnumDifficulty.PEACEFUL) {
				e.player.worldObj.difficultySetting = EnumDifficulty.EASY;
				Helper.msgClean(e.player, "You are not allowed to change to peaceful mode.", Color.red);
				LogHelper.info("peaceful detected..");
			}
		}
		
		//Give Jump 3 while in callisto dimension.
		if(e.player.worldObj.provider.dimensionId == ToeDimensions.callisto) {
			e.player.addPotionEffect(new PotionEffect(Potion.jump.id, 20, 2));
		}
		
		//Give Speed 1 while wearing nimble armor.
		if(e.player.getCurrentArmor(0) != null && e.player.getCurrentArmor(0).getItem() == ToeItems.nimbleBoots &&
		   e.player.getCurrentArmor(1) != null && e.player.getCurrentArmor(1).getItem() == ToeItems.nimblePants &&
		   e.player.getCurrentArmor(2) != null && e.player.getCurrentArmor(2).getItem() == ToeItems.nimblePlate &&
		   e.player.getCurrentArmor(3) != null && e.player.getCurrentArmor(3).getItem() == ToeItems.nimbleHelmet) {
			e.player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 20));
		}
		
		//Give Jump 1 while wearing dynamic armor.
		if(e.player.getCurrentArmor(0) != null && e.player.getCurrentArmor(0).getItem() == ToeItems.dynamicBoots &&
		   e.player.getCurrentArmor(1) != null && e.player.getCurrentArmor(1).getItem() == ToeItems.dynamicPants &&
		   e.player.getCurrentArmor(2) != null && e.player.getCurrentArmor(2).getItem() == ToeItems.dynamicPlate &&
		   e.player.getCurrentArmor(3) != null && e.player.getCurrentArmor(3).getItem() == ToeItems.dynamicHelmet) {
			e.player.addPotionEffect(new PotionEffect(Potion.jump.id, 20));
		}
		
		ticks++;
		if(ticks >= 100) {
			ticks = 0;
			onPlayerSecond(e);
		}
	}

	private void onPlayerSecond(PlayerTickEvent e) {
		if(!e.player.capabilities.isCreativeMode) {
			if(e.player.worldObj.provider.dimensionId == ToeDimensions.callisto) {
				if(e.player.getCurrentArmor(0) != null && e.player.getCurrentArmor(0).getItem() == ToeItems.spacesuitBoots &&
				   e.player.getCurrentArmor(1) != null && e.player.getCurrentArmor(1).getItem() == ToeItems.spacesuitPants &&
				   e.player.getCurrentArmor(2) != null && e.player.getCurrentArmor(2).getItem() == ToeItems.spacesuitPlate &&
				   e.player.getCurrentArmor(3) != null && e.player.getCurrentArmor(3).getItem() == ToeItems.spacesuitHelmet) {
					//do nothing
				} else {
					e.player.setHealth(e.player.getHealth()-2);
					//e.player.attackEntityFrom(DamageSource.generic, 1);
					//LogHelper.info("0 == " + e.player.getCurrentArmor(0) + ", 1 == " + e.player.getCurrentArmor(1) + ", 2 == " + e.player.getCurrentArmor(2) + ", 3 == " + e.player.getCurrentArmor(3));
					Helper.msg(e.player, "Quickly put on a spacesuit to stop getting damaged.", Color.red);
				}
			}
		}
	}
}