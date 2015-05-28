package com.abstractlabs.toe.handler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.player.AttackEntityEvent;

import com.abstractlabs.toe.init.ToeItems;
import com.abstractlabs.toe.item.ItemCane;
import com.abstractlabs.toe.skill.arenalism.ArenalismHelper;
import com.abstractlabs.toe.skill.mining.MiningHelper;
import com.abstractlabs.toe.skill.woodcutting.WoodcuttingHelper;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class PlayerHandler {
	@SubscribeEvent
	public void onEntityConstructing(EntityConstructing event) {
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
	}
	
	@SubscribeEvent
	public void onAttack(AttackEntityEvent event) {
		if (event.entityPlayer.getHeldItem() != null && event.entityPlayer.getHeldItem().getItem() == ToeItems.cane && !ItemCane.playerExists(event.entityPlayer)) {
			ItemCane.addPlayer(null, event.entityPlayer, 0);
			//LogHelper.info("added player to hashmap");
		}
		//LogHelper.info(event.entityPlayer.getHeldItem());
		//LogHelper.info(event.entityPlayer.getHeldItem().getItem());
		//LogHelper.info(!ItemCane.playerExists(event.entityPlayer));
	}
}