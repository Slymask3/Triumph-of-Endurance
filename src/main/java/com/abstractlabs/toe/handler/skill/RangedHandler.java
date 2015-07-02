package com.abstractlabs.toe.handler.skill;

import net.minecraft.entity.monster.EntityCaveSpider;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;

import com.abstractlabs.toe.reference.Color;
import com.abstractlabs.toe.reference.RngItems;
import com.abstractlabs.toe.skill.ranged.RangedHelper;
import com.abstractlabs.toe.utility.Helper;
import com.abstractlabs.toe.utility.LogHelper;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class RangedHandler
{
	@SubscribeEvent
	public boolean onDeath(LivingDeathEvent event)
	{
		if (event.source.getEntity() instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer) event.source.getEntity();
			LogHelper.info("test2");
			if (!event.entityLiving.worldObj.isRemote && (player.getHeldItem() != null && player.getHeldItem().getItem() == Items.bow))
			{
				RangedHelper helper = RangedHelper.getProperties(player);
				ItemStack is = player.getHeldItem();

				int lvl = RngItems.bowLvl;

				if (helper.getLevel() < lvl)
				{
					LogHelper.info("test4");
					//Helper.msgClean(player, "You have to have level " + BoneType.boneLvl + " prayer to bury this bone.", Color.red);
					Helper.msgClean(player, "You have to have level " + RngItems.bowLvl + " ranged to use this bow.", Color.red);
					return false;
				}
				else if (event.entityLiving instanceof EntityZombie)
				{
					//LogHelper.info("test5");
					Helper.msgClean(player, "You have slain a zombie!", Color.lime);
					helper.addExperience(RngItems.zombieExp);
				}
				else if (event.entityLiving instanceof EntityChicken)
				{
					//LogHelper.info("test6");
					Helper.msgClean(player, "You have slain a chicken!", Color.lime);
					helper.addExperience(RngItems.chickenExp);
				}
				else if (event.entityLiving instanceof EntityPig)
				{
					//LogHelper.info("test7");
					Helper.msgClean(player, "You have slain a pig!", Color.lime);
					helper.addExperience(RngItems.pigExp);
				}
				else if (event.entityLiving instanceof EntitySheep)
				{
					//LogHelper.info("test8");
					Helper.msgClean(player, "You have slain a sheep!", Color.lime);
					helper.addExperience(RngItems.sheepExp);
				}
				else if (event.entityLiving instanceof EntitySpider)
				{
					//LogHelper.info("test9");
					Helper.msgClean(player, "You have slain a spider!", Color.lime);
					helper.addExperience(RngItems.spiderExp);
				}
				else if (event.entityLiving instanceof EntityEnderman)
				{
					//LogHelper.info("test10");
					Helper.msgClean(player, "You have slain a enderman!", Color.lime);
					helper.addExperience(RngItems.enderExp);
				}
				else if (event.entityLiving instanceof EntitySkeleton)
				{
					//LogHelper.info("test11");
					Helper.msgClean(player, "You have slain a skeleton!", Color.lime);
					helper.addExperience(RngItems.skeletonExp);
				}
				else if (event.entityLiving instanceof EntityCow)
				{
					//LogHelper.info("test12");
					Helper.msgClean(player, "You have slain a cow!", Color.lime);
					helper.addExperience(RngItems.cowExp);
				}
				else if (event.entityLiving instanceof EntityVillager)
				{
					//LogHelper.info("test13");
					Helper.msgClean(player, "You have slain a villager!", Color.lime);
					helper.addExperience(RngItems.villagerExp);
				}
				else if (event.entityLiving instanceof EntityPigZombie)
				{
					//LogHelper.info("test14");
					Helper.msgClean(player, "You have slain a pig zombie!", Color.lime);
					helper.addExperience(RngItems.zombiepigExp);
				}
				else if (event.entityLiving instanceof EntityCaveSpider)
				{
					//LogHelper.info("test15");
					Helper.msgClean(player, "You have slain a cave spider!", Color.lime);
					helper.addExperience(RngItems.cavespiderExp);
				}
				else if (event.entityLiving instanceof EntityCreeper)
				{
					//LogHelper.info("test16");
					Helper.msgClean(player, "You have slain a creeper!", Color.lime);
					helper.addExperience(RngItems.creeperExp);
				}
			}
		}
		return true;
	}

	@SubscribeEvent
	public void onToolTip(ItemTooltipEvent event)
	{
		if (event.showAdvancedItemTooltips && event.itemStack.getItem() == Items.bow && (event.entity instanceof EntityPlayer))
		{
			EntityPlayer player = (EntityPlayer) event.entity;
			if (RangedHelper.getProperties(player).getLevel() >= RngItems.bowLvl)
			{
				event.toolTip.add(EnumChatFormatting.GREEN + "Level Required: " + RngItems.bowLvl);
			}
			else
			{
				event.toolTip.add(EnumChatFormatting.RED + "Level Required: " + RngItems.bowLvl);
			}

		}
	}
}
