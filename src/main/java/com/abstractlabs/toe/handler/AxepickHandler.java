package com.abstractlabs.toe.handler;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.Action;

import com.abstractlabs.toe.init.ToeItems;
import com.abstractlabs.toe.reference.Color;
import com.abstractlabs.toe.utility.Helper;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class AxepickHandler {
	@SubscribeEvent
	public void onLeftClick(PlayerInteractEvent e) {
		if(e.entityPlayer.getHeldItem() != null && e.action == Action.LEFT_CLICK_BLOCK) {
			Block block = e.world.getBlock(e.x, e.y, e.z);
			ItemStack is = e.entityPlayer.inventory.mainInventory[e.entityPlayer.inventory.currentItem];
			
			if(block.getMaterial() == Material.rock) {
				if(is.getItem() == ToeItems.woodAxepick) {
					e.entityPlayer.setCurrentItemOrArmor(0, new ItemStack(ToeItems.woodAxepick_pick, 1, is.getItemDamage()));
					Helper.msgClean(e.entityPlayer, "Switched to Pickaxe Mode.", Color.aqua);
				} else if(is.getItem() == ToeItems.stoneAxepick) {
					e.entityPlayer.setCurrentItemOrArmor(0, new ItemStack(ToeItems.stoneAxepick_pick, 1, is.getItemDamage()));
					Helper.msgClean(e.entityPlayer, "Switched to Pickaxe Mode.", Color.aqua);
				} else if(is.getItem() == ToeItems.ironAxepick) {
					e.entityPlayer.setCurrentItemOrArmor(0, new ItemStack(ToeItems.ironAxepick_pick, 1, is.getItemDamage()));
					Helper.msgClean(e.entityPlayer, "Switched to Pickaxe Mode.", Color.aqua);
				} else if(is.getItem() == ToeItems.goldAxepick) {
					e.entityPlayer.setCurrentItemOrArmor(0, new ItemStack(ToeItems.goldAxepick_pick, 1, is.getItemDamage()));
					Helper.msgClean(e.entityPlayer, "Switched to Pickaxe Mode.", Color.aqua);
				} else if(is.getItem() == ToeItems.diamondAxepick) {
					e.entityPlayer.setCurrentItemOrArmor(0, new ItemStack(ToeItems.diamondAxepick_pick, 1, is.getItemDamage()));
					Helper.msgClean(e.entityPlayer, "Switched to Pickaxe Mode.", Color.aqua);
				} else if(is.getItem() == ToeItems.emeraldAxepick) {
					e.entityPlayer.setCurrentItemOrArmor(0, new ItemStack(ToeItems.emeraldAxepick_pick, 1, is.getItemDamage()));
					Helper.msgClean(e.entityPlayer, "Switched to Pickaxe Mode.", Color.aqua);
				} else if(is.getItem() == ToeItems.rubyAxepick) {
					e.entityPlayer.setCurrentItemOrArmor(0, new ItemStack(ToeItems.rubyAxepick_pick, 1, is.getItemDamage()));
					Helper.msgClean(e.entityPlayer, "Switched to Pickaxe Mode.", Color.aqua);
				} else if(is.getItem() == ToeItems.sapphireAxepick) {
					e.entityPlayer.setCurrentItemOrArmor(0, new ItemStack(ToeItems.sapphireAxepick_pick, 1, is.getItemDamage()));
					Helper.msgClean(e.entityPlayer, "Switched to Pickaxe Mode.", Color.aqua);
				}
			} else if(block.getMaterial() == Material.wood) {
				if(is.getItem() == ToeItems.woodAxepick_pick) {
					e.entityPlayer.setCurrentItemOrArmor(0, new ItemStack(ToeItems.woodAxepick, 1, is.getItemDamage()));
					Helper.msgClean(e.entityPlayer, "Switched to Axe Mode.", Color.aqua);
				} else if(is.getItem() == ToeItems.stoneAxepick_pick) {
					e.entityPlayer.setCurrentItemOrArmor(0, new ItemStack(ToeItems.stoneAxepick, 1, is.getItemDamage()));
					Helper.msgClean(e.entityPlayer, "Switched to Axe Mode.", Color.aqua);
				} else if(is.getItem() == ToeItems.ironAxepick_pick) {
					e.entityPlayer.setCurrentItemOrArmor(0, new ItemStack(ToeItems.ironAxepick, 1, is.getItemDamage()));
					Helper.msgClean(e.entityPlayer, "Switched to Axe Mode.", Color.aqua);
				} else if(is.getItem() == ToeItems.goldAxepick_pick) {
					e.entityPlayer.setCurrentItemOrArmor(0, new ItemStack(ToeItems.goldAxepick, 1, is.getItemDamage()));
					Helper.msgClean(e.entityPlayer, "Switched to Axe Mode.", Color.aqua);
				} else if(is.getItem() == ToeItems.diamondAxepick_pick) {
					e.entityPlayer.setCurrentItemOrArmor(0, new ItemStack(ToeItems.diamondAxepick, 1, is.getItemDamage()));
					Helper.msgClean(e.entityPlayer, "Switched to Axe Mode.", Color.aqua);
				} else if(is.getItem() == ToeItems.emeraldAxepick_pick) {
					e.entityPlayer.setCurrentItemOrArmor(0, new ItemStack(ToeItems.emeraldAxepick, 1, is.getItemDamage()));
					Helper.msgClean(e.entityPlayer, "Switched to Axe Mode.", Color.aqua);
				} else if(is.getItem() == ToeItems.rubyAxepick_pick) {
					e.entityPlayer.setCurrentItemOrArmor(0, new ItemStack(ToeItems.rubyAxepick, 1, is.getItemDamage()));
					Helper.msgClean(e.entityPlayer, "Switched to Axe Mode.", Color.aqua);
				} else if(is.getItem() == ToeItems.sapphireAxepick_pick) {
					e.entityPlayer.setCurrentItemOrArmor(0, new ItemStack(ToeItems.sapphireAxepick, 1, is.getItemDamage()));
					Helper.msgClean(e.entityPlayer, "Switched to Axe Mode.", Color.aqua);
				}
			}
		}
	}
}
