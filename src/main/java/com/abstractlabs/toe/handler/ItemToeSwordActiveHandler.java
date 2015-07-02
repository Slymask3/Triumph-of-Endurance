package com.abstractlabs.toe.handler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.event.entity.player.PlayerEvent.NameFormat;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.Action;

import com.abstractlabs.toe.init.ToeItems;
import com.abstractlabs.toe.item.ItemToeSwordActive;
import com.abstractlabs.toe.reference.Color;
import com.abstractlabs.toe.utility.Helper;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class ItemToeSwordActiveHandler {
	@SubscribeEvent
	public void onRightClick(PlayerInteractEvent e) {
		if(e.entityPlayer.getHeldItem() != null && (e.action == Action.RIGHT_CLICK_AIR)) {
			EntityPlayer player = e.entityPlayer;
			ItemStack is = e.entityPlayer.inventory.mainInventory[e.entityPlayer.inventory.currentItem];
			
			if(is.getItem() instanceof ItemToeSwordActive && is.stackTagCompound != null) {
				if(is.getItem() == ToeItems.ghostblade) {
					if(is.stackTagCompound.getBoolean("activeAvailable")) {
						player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 5*20, 2));
						player.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 5*20, 2));
						
						Helper.msg(player, "Ghostblade activated!", Color.magenta);
		
						is.stackTagCompound.setInteger("ticks", 3600); //3min
						is.stackTagCompound.setBoolean("activeAvailable", false);
					} else {
						Helper.msg(player, "Ghostblade is on cooldown.", Color.red);
					}
				}
			}
		}
	}
	
	@SubscribeEvent
	public void onItemTooltip(ItemTooltipEvent e) {
		if(e.entityPlayer.getHeldItem() != null) {
			EntityPlayer player = e.entityPlayer;
			ItemStack is = e.itemStack;
			
			if(is.getItem() instanceof ItemToeSwordActive && is.stackTagCompound != null) {
				boolean active = is.stackTagCompound.getBoolean("activeAvailable");
				int ticks = is.stackTagCompound.getInteger("ticks");
				
				e.toolTip.clear();
				e.toolTip.add(is.getDisplayName());
				
				if(is.getItem() == ToeItems.ghostblade) {
					if(active) {
						e.toolTip.add(EnumChatFormatting.AQUA + "Active Avaliable: " + EnumChatFormatting.GREEN + "Yes");
						e.toolTip.add(EnumChatFormatting.GOLD + "Active Desccription: User gains");
						e.toolTip.add(EnumChatFormatting.GOLD + "Speed III and Strength III");
						e.toolTip.add(EnumChatFormatting.GOLD + "for 5 seconds.");
					} else if(!active) {
						e.toolTip.add(EnumChatFormatting.AQUA + "Active Avaliable: " + EnumChatFormatting.GREEN + "Yes");
						e.toolTip.add(EnumChatFormatting.RED + "Active Cooldown: " + displayTicksAsMinSec(ticks));
					}
				}
				
				e.toolTip.add("");
				e.toolTip.add(EnumChatFormatting.DARK_RED + "+"+(int)(((ItemSword)is.getItem()).func_150931_i()+4.0F)+" Attack Damage");
				e.toolTip.add(EnumChatFormatting.DARK_RED + "Durability: " + ((is.getMaxDamage() - is.getItemDamage()) + 1) + "/" + ((is.getMaxDamage()) + 1));
			}
		}
	}

	private String displayTicksAsMinSec(int ticks) {
		int min = (ticks/20)/60;
		int sec = (ticks/20)%60;

		String minS = Integer.toString(min);
		String secS = Integer.toString(sec);
		
		if(min < 10) {
			minS = "0" + Integer.toString(min);
		}
		
		if(sec < 10) {
			secS = "0" + Integer.toString(sec);
		}
		
		return minS + ":" + secS;
	}
	
//	@SubscribeEvent
//	public void onName(NameFormat e) {
//		e.displayname = e.username + " the Great";
//	}
}