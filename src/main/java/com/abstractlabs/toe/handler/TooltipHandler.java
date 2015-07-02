package com.abstractlabs.toe.handler;

import net.minecraftforge.event.entity.player.ItemTooltipEvent;

import com.abstractlabs.toe.utility.ItemRarity;

import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class TooltipHandler {
	@SubscribeEvent(priority=EventPriority.HIGHEST)
	public void onItemTooltip(ItemTooltipEvent e) {
//		if(ItemRarity.shouldColorName(e.itemStack)) {
//			e.toolTip.clear();
//			e.toolTip.add(ItemRarity.getColoredName(e.itemStack));
//		}
		//e.toolTip.remove(0);
		e.toolTip.set(0, ItemRarity.getColoredName(e.itemStack));
	}
}