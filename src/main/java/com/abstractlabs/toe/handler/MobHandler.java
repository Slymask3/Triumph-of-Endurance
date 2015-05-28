package com.abstractlabs.toe.handler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

import com.abstractlabs.toe.entity.monster.EntityMummy;
import com.abstractlabs.toe.entity.monster.EntityScorpion;
import com.abstractlabs.toe.skill.arenalism.ArenalismHelper;
import com.abstractlabs.toe.utility.LogHelper;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class MobHandler {
	@SubscribeEvent
	public void onDeath(LivingDeathEvent event) {
//		LogHelper.info("[MobHandler] event is called.");
//		if(event.source.getEntity() instanceof EntityPlayer) {
//			LogHelper.info("[MobHandler] source is entityplayer.");
//			EntityPlayer player = (EntityPlayer) event.source.getEntity();
//			if(event.entityLiving instanceof EntityMummy || event.entityLiving instanceof EntityScorpion) {
//				//ArenalismHelper helper = ArenalismHelper.getProperties(player);
//				//helper.updateEnemies(helper.getEnemiesRemaining() - 1);
//				//BIG TODO HERE
//				LogHelper.info("[MobHandler] updated enemies.");
//			}
//		}
	}
}
