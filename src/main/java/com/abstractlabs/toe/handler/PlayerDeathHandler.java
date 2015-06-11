package com.abstractlabs.toe.handler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

import com.abstractlabs.toe.player.ATM;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;


public class PlayerDeathHandler {
	@SubscribeEvent
	public void onDeath(LivingDeathEvent event) {
		if ((event.entity instanceof EntityPlayer)) {
			EntityPlayer player = (EntityPlayer)event.entity;
			NBTTagCompound tag = player.getEntityData().getCompoundTag("ATM");
			 
			tag.setInteger("CopperCoins", ATM.getProperties(player).getCopperCoins());
			tag.setInteger("SilverCoins", ATM.getProperties(player).getSilverCoins());
			tag.setInteger("GoldCoins", ATM.getProperties(player).getGoldCoins());
			
			player.getEntityData().setTag("ATM", tag);
		}
	}
}