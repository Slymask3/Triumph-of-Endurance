package com.abstractlabs.toe.handler;

import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;

import com.abstractlabs.toe.init.ToePotions;
import com.abstractlabs.toe.utility.LogHelper;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class PotionHandler {
	@SubscribeEvent
	public void onEntityTick(LivingUpdateEvent e) {
		if(e.entityLiving.isPotionActive(ToePotions.stun)) {
			//e.entityLiving.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.0D);
			//e.entityLiving.setAIMoveSpeed(0.0F);
			//e.entityLiving.is
			//e.entityLiving.setJumping(true);
			//e.entityLiving.motionY = -100D; //works a bit
			//e.entityLiving.addVelocity(0, -100, 0);
			e.entityLiving.addPotionEffect(new PotionEffect(Potion.jump.id, 2, -5)); //works better, but ofc adds a potion effect aswell, doesnt seeem professional
			
			LogHelper.info("[PotionHandler] onEntityTick() : stunned");
		}
	}
	
	@SubscribeEvent
	public void onEntityJump(LivingJumpEvent e) { //this event is triggered in EntityLivingBase#jump();
		if(e.entityLiving.isPotionActive(ToePotions.stun)) {
			//e.setCanceled(true);
			//e.entityLiving.setJumping(false);
			//e.entityLiving.addVelocity(0, -100, 0);
			//e.entityLiving.motionY =- -100D;
			LogHelper.info("[PotionHandler] onEntityJump() : jumped");
		}
	}
}