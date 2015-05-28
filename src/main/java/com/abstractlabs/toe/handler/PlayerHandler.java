package com.abstractlabs.toe.handler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;

import com.abstractlabs.toe.skill.arenalism.ArenalismHelper;
import com.abstractlabs.toe.skill.mining.MiningHelper;
import com.abstractlabs.toe.skill.woodcutting.WoodcuttingHelper;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class PlayerHandler {
	@SubscribeEvent//(priority=EventPriority.LOWEST)
	public void onEntityConstructing(EntityConstructing event) {
		/*
		Be sure to check if the entity being constructed is the correct type for the extended properties you're about to add! The null check may not be necessary - I only use it to make sure properties are only registered once per entity
		*/
//		if (event.entity instanceof EntityPlayer && ExtendedPlayer.get((EntityPlayer) event.entity) == null) {
//			// This is how extended properties are registered using our convenient method from earlier
//			ExtendedPlayer.register((EntityPlayer) event.entity);
//			LogHelper.info("[Tutorial] Created player. Current Mana: " + ExtendedPlayer.get((EntityPlayer)event.entity).getCurrentMana() + " |  Max Mana: " + ExtendedPlayer.get((EntityPlayer)event.entity).getCurrentMana());
//		}
		
		if (event.entity instanceof EntityPlayer) {
			if(MiningHelper.getProperties((EntityPlayer)event.entity) == null) {
				MiningHelper.addProperties((EntityPlayer)event.entity);
			} else {
				MiningHelper.getProperties((EntityPlayer)event.entity).sync();
			}
			
			if(ArenalismHelper.getProperties((EntityPlayer)event.entity) == null) {
			    ArenalismHelper.addProperties((EntityPlayer)event.entity);
			} else {
				ArenalismHelper.getProperties((EntityPlayer)event.entity).sync();
			}
			
			if(WoodcuttingHelper.getProperties((EntityPlayer)event.entity) == null) {
				WoodcuttingHelper.addProperties((EntityPlayer)event.entity);
			} else {
				WoodcuttingHelper.getProperties((EntityPlayer)event.entity).sync();
			}
		}

		
		
//		if (event.entity instanceof EntityPlayer) {
//			LogHelper.info("Arenalism.get() == " + Arenalism.get((EntityPlayer) event.entity));
//		}
//		
//		
//		if (event.entity instanceof EntityPlayer && Arenalism.get((EntityPlayer) event.entity) == null) {
//			// This is how extended properties are registered using our convenient method from earlier
//			Arenalism.register((EntityPlayer) event.entity);
//			LogHelper.info("[Arena] Created player. Level: " + Arenalism.get((EntityPlayer)event.entity).getLevel() + " |  Cash: " + Arenalism.get((EntityPlayer)event.entity).getCash() + " |  Wave: " + Arenalism.get((EntityPlayer)event.entity).getWave() + " |  Enemies Remaining: " + Arenalism.get((EntityPlayer)event.entity).getEnemiesRemaining());
//		}
//		
//		if (event.entity instanceof EntityPlayer) {
//			LogHelper.info("Arenalism.get() == " + Arenalism.get((EntityPlayer) event.entity));
//		}
		
		// That will call the constructor as well as cause the init() method
		// to be called automatically
		
		// If you didn't make the two convenient methods from earlier, your code would be
		// much uglier:
//		if (event.entity instanceof EntityPlayer && event.entity.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME) == null)
//		event.entity.registerExtendedProperties(ExtendedPlayer.EXT_PROP_NAME, new ExtendedPlayer((EntityPlayer) event.entity));
	}
	
}