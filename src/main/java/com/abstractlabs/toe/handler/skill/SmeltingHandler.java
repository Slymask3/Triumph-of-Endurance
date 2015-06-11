package com.abstractlabs.toe.handler.skill;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

import com.abstractlabs.toe.skill.smelting.SmeltingHelper;
import com.abstractlabs.toe.utility.LogHelper;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.ItemSmeltedEvent;

public class SmeltingHandler {
	@SubscribeEvent
	public void onSmelt(ItemSmeltedEvent e) {
		if(!e.player.worldObj.isRemote) {
			LogHelper.info("smelting == " + e.smelting);
			
			EntityPlayer player = e.player;
			Item item = e.smelting.getItem();
			int amount = e.smelting.stackSize;
			int meta = e.smelting.getItemDamage();
			
			SmeltingHelper smelting = SmeltingHelper.getProperties(player);
			
			if(item == Items.cooked_porkchop || item == Items.cooked_beef || item == Items.cooked_chicken || item == Items.cooked_fished || item == Items.baked_potato) {
				smelting.addExperience(30*amount);
			} else if(item == Items.iron_ingot) {
				smelting.addExperience(20*amount);
			} else if(item == Items.gold_ingot) {
				smelting.addExperience(40*amount);
			} else if(item == Items.diamond) {
				smelting.addExperience(50*amount);
			} else if(item == Items.dye && meta == 4) {
				smelting.addExperience(30*amount);
			} else if(item == Items.redstone) {
				smelting.addExperience(20*amount);
			} else if(item == Items.coal) {
				smelting.addExperience(10*amount);
			} else if(item == Items.emerald) {
				smelting.addExperience(50*amount);
			} else if(item == Items.quartz) {
				smelting.addExperience(20*amount);
			} else if(item == Item.getItemFromBlock(Blocks.stone) || item == Items.netherbrick) {
				smelting.addExperience(1*amount);
			} else if(item == Item.getItemFromBlock(Blocks.glass)) {
				smelting.addExperience(2*amount);
			} else if(item == Item.getItemFromBlock(Blocks.stonebrick) && meta == 2) {
				smelting.addExperience(3*amount);
			} else if(item == Items.brick) {
				smelting.addExperience(10*amount);
			} else if(item == Item.getItemFromBlock(Blocks.hardened_clay)) {
				smelting.addExperience(40*amount);
			} else if(item == Item.getItemFromBlock(Blocks.sponge)) {
				smelting.addExperience(10*amount);
			} else if(item == Items.coal) {
				smelting.addExperience(5*amount);
			} else if(item == Items.dye && meta == 2) {
				smelting.addExperience(10*amount);
			}
			
			//when shift clicking from the furnace, it seems to go through this event with an amount of 0, and run twice.
			//so when this happens, add a little bit of xp instead of not adding any.
			//this is not needed anymore, since i found a fix, but it will only work with our custom furnaces.
//			if(amount == 0) {
//				smelting.addExperience(1);
//			}
		}
	}

	public static void onSmeltShiftClick(TileEntity type, ItemStack is, EntityPlayer player) {
		if(!player.worldObj.isRemote) {
			LogHelper.info("isRemote == " + player.worldObj.isRemote + ", type == " + type + ", is == " + is);
			
			//i passed through the tileentity aswell, so we can maybe have bonus xp modifiers when using different furnaces.
			
			Item item = is.getItem();
			int amount = is.stackSize;
			int meta = is.getItemDamage();
			
			SmeltingHelper smelting = SmeltingHelper.getProperties(player);
			
			if(item == Items.cooked_porkchop || item == Items.cooked_beef || item == Items.cooked_chicken || item == Items.cooked_fished || item == Items.baked_potato) {
				smelting.addExperience(30*amount);
			} else if(item == Items.iron_ingot) {
				smelting.addExperience(20*amount);
			} else if(item == Items.gold_ingot) {
				smelting.addExperience(40*amount);
			} else if(item == Items.diamond) {
				smelting.addExperience(50*amount);
			} else if(item == Items.dye && meta == 4) {
				smelting.addExperience(30*amount);
			} else if(item == Items.redstone) {
				smelting.addExperience(20*amount);
			} else if(item == Items.coal) {
				smelting.addExperience(10*amount);
			} else if(item == Items.emerald) {
				smelting.addExperience(50*amount);
			} else if(item == Items.quartz) {
				smelting.addExperience(20*amount);
			} else if(item == Item.getItemFromBlock(Blocks.stone) || item == Items.netherbrick) {
				smelting.addExperience(1*amount);
			} else if(item == Item.getItemFromBlock(Blocks.glass)) {
				smelting.addExperience(2*amount);
			} else if(item == Item.getItemFromBlock(Blocks.stonebrick) && meta == 2) {
				smelting.addExperience(3*amount);
			} else if(item == Items.brick) {
				smelting.addExperience(10*amount);
			} else if(item == Item.getItemFromBlock(Blocks.hardened_clay)) {
				smelting.addExperience(40*amount);
			} else if(item == Item.getItemFromBlock(Blocks.sponge)) {
				smelting.addExperience(10*amount);
			} else if(item == Items.coal) {
				smelting.addExperience(5*amount);
			} else if(item == Items.dye && meta == 2) {
				smelting.addExperience(10*amount);
			}
		}
	}
}
