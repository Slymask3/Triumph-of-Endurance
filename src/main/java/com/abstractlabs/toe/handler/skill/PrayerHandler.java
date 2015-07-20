package com.abstractlabs.toe.handler.skill;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.Action;

import com.abstractlabs.toe.init.ToeBlocks;
import com.abstractlabs.toe.item.ItemBone;
import com.abstractlabs.toe.item.ItemHealingTablet;
import com.abstractlabs.toe.reference.BoneType;
import com.abstractlabs.toe.reference.Color;
import com.abstractlabs.toe.skill.prayer.PrayerHelper;
import com.abstractlabs.toe.utility.Helper;
import com.abstractlabs.toe.utility.LogHelper;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class PrayerHandler 
{
	@SubscribeEvent
	public boolean onPlayerUse(PlayerInteractEvent event)
	{
		//LogHelper.info("test1");
		if (event.entity instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer) event.entity;
			//LogHelper.info("test2");
			if (!event.world.isRemote && (player.getHeldItem() != null && player.getHeldItem().getItem() instanceof ItemBone))
			{
				//LogHelper.info("test2");
				if (event.action == Action.RIGHT_CLICK_BLOCK)
				{
					if (event.world.getBlock(event.x, event.y, event.z) == Blocks.grass || event.world.getBlock(event.x, event.y, event.z) == Blocks.sand)
					{
						//LogHelper.info("test3");
						PrayerHelper helper = PrayerHelper.getProperties(player);
						ItemStack is = player.getHeldItem();
						ItemBone item = (ItemBone) is.getItem();

						int lvl = item.getLvl();

						if (helper.getLevel() < lvl)
						{
							//LogHelper.info("test4");
							//Helper.msgClean(player, "You have to have level " + BoneType.boneLvl + " prayer to bury this bone.", Color.red);
							Helper.msgClean(player, "You have to have level " + BoneType.undeadbatBoneLvl + " prayer to bury this bone.", Color.red);
							return false;
						}
						else
						{
							//LogHelper.info("test5");
							Helper.msgClean(player, "Bone successfully burried.", Color.lime);
							helper.addExperience(BoneType.undeadbatBoneExp);
							is.stackSize -= 1;
						}
					}
					else if (event.world.getBlock(event.x, event.y, event.z) ==  ToeBlocks.altar)
					{
						//LogHelper.info("test3");
						PrayerHelper helper = PrayerHelper.getProperties(player);
						ItemStack is = player.getHeldItem();
						ItemBone item = (ItemBone) is.getItem();

						int lvl = item.getLvl();

						if (helper.getLevel() < lvl)
						{
							//LogHelper.info("test4");
							//Helper.msgClean(player, "You have to have level " + BoneType.boneLvl + " prayer to bury this bone.", Color.red);
							Helper.msgClean(player, "You have to have level " + BoneType.undeadbatBoneLvl + " prayer to offer this bone.", Color.red);
							return false;
						}
						else
						{
							//LogHelper.info("test5");
							Helper.msgClean(player, "Bone successfully burried.", Color.lime);
							helper.addExperience(BoneType.undeadbatBoneExp_altar);
							is.stackSize -= 1;
						}
					}
					else
					{
						Helper.msgClean(player, "Try burying somewhere else! The ground is too hard...", Color.purple);
					}
				}
			}
//			else if (!event.world.isRemote && (player.getHeldItem() != null && player.getHeldItem().getItem() instanceof ItemBone))
//			{
//				//LogHelper.info("test2");
//				if (event.action == Action.RIGHT_CLICK_BLOCK)
//				{
//					if (event.world.getBlock(event.x, event.y, event.z) == ToeBlocks.altar)
//					{
//						//LogHelper.info("test3");
//						PrayerHelper helper = PrayerHelper.getProperties(player);
//						ItemStack is = player.getHeldItem();
//						ItemBone item = (ItemBone) is.getItem();
//
//						int lvl = item.getLvl();
//
//						if (helper.getLevel() < lvl)
//						{
//							Helper.msgClean(player, "You have to have level " + BoneType.undeadbatBoneLvl + " prayer to offer this bone.", Color.red);
//							return false;
//						}
//						else
//						{
//							//LogHelper.info("test5");
//							Helper.msgClean(player, "Bone offered.", Color.lime);
//							helper.addExperience(BoneType.undeadbatBoneExp_altar);
//							is.stackSize -= 1;
//						}
//					}
//					else
//					{
//						Helper.msgClean(player, "Hmmmm...", Color.purple);
//					}
//				}
//			}
		}
		return true;
	}
}
