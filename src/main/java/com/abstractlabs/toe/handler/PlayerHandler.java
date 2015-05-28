package com.abstractlabs.toe.handler;

import com.abstractlabs.toe.init.ToeItems;
import com.abstractlabs.toe.item.ItemCane;
import com.abstractlabs.toe.utility.LogHelper;
import com.google.common.eventbus.Subscribe;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;

public class PlayerHandler 
{
	@SubscribeEvent
	public void onAttack(AttackEntityEvent event)
	{
		if (event.entityPlayer.getHeldItem() != null && event.entityPlayer.getHeldItem().getItem() == ToeItems.cane && !ItemCane.playerExists(event.entityPlayer))
		{
			ItemCane.addPlayer(null, event.entityPlayer, 0);
			//LogHelper.info("added player to hashmap");
		}
		//LogHelper.info(event.entityPlayer.getHeldItem());
		//LogHelper.info(event.entityPlayer.getHeldItem().getItem());
		//LogHelper.info(!ItemCane.playerExists(event.entityPlayer));
	}
}
