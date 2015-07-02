package com.abstractlabs.toe.handler;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.Action;

import com.abstractlabs.toe.item.ItemToeAxepick;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class AxepickHandler {
	@SubscribeEvent
	public void onLeftClick(PlayerInteractEvent e) {
		if(e.entityPlayer.getHeldItem() != null && e.action == Action.LEFT_CLICK_BLOCK) {
			Block block = e.world.getBlock(e.x, e.y, e.z);
			ItemStack is = e.entityPlayer.inventory.mainInventory[e.entityPlayer.inventory.currentItem];
			
			if(is.getItem() instanceof ItemToeAxepick) {
				if(block.getMaterial() == Material.rock && block.getMaterial() == Material.ice && block.getMaterial() == Material.iron) {
					if(is.stackTagCompound != null && is.stackTagCompound.getBoolean("axe")) {
						is.stackTagCompound.setBoolean("axe", false);
						//((ItemToeAxepick)is.getItem()).setAxe(false);
						//Helper.msgClean(e.entityPlayer, "Switched to Pickaxe Mode.", Color.aqua);
					}
				} else if(block.getMaterial() == Material.wood) {
					if(is.stackTagCompound != null && !is.stackTagCompound.getBoolean("axe")) {
						is.stackTagCompound.setBoolean("axe", true);
						//((ItemToeAxepick)is.getItem()).setAxe(true);
						//Helper.msgClean(e.entityPlayer, "Switched to Axe Mode.", Color.aqua);
					}
				}
			}
		}
	}
}
