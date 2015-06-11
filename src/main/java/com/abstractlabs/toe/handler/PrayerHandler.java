package com.abstractlabs.toe.handler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.Action;

import com.abstractlabs.toe.init.ToeItems;
import com.abstractlabs.toe.item.ItemUndeadBatBone;
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
		LogHelper.info("test1");
		if (event.entity instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer) event.entity;
			LogHelper.info("test2");
			if (!event.world.isRemote && (player.getHeldItem().getItem() != null && player.getHeldItem().getItem() instanceof ItemUndeadBatBone))
			{
				if (event.action == Action.RIGHT_CLICK_BLOCK)
				{
					if (event.world.getBlock(event.x, event.y, event.z) == Blocks.grass || event.world.getBlock(event.x, event.y, event.z) == Blocks.sand)
					{
						LogHelper.info("test3");
						PrayerHelper helper = PrayerHelper.getProperties(player);
						ItemStack is = player.getHeldItem();
						ItemUndeadBatBone item = (ItemUndeadBatBone) is.getItem();

						int lvl = item.getLvl();

						if (helper.getLevel() < lvl)
						{
							LogHelper.info("test4");
							Helper.msgClean(player, "You have to have level " + BoneType.boneLvl + " prayer to bury this bone.", Color.red);
							return false;
						}
						else
						{
							LogHelper.info("test5");
							Helper.msgClean(player, "Bone successfully burried.", Color.lime);
							helper.addExperience(BoneType.boneExp);
							is.stackSize -= 1;
						}
					}
					else
					{
						Helper.msgClean(player, "Try burying somewhere else! The ground is too hard...", Color.purple);
					}
				}
			}
		}
		return true;
	}
}
