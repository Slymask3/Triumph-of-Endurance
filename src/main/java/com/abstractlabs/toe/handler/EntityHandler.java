package com.abstractlabs.toe.handler;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

import com.abstractlabs.toe.init.ToeItems;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EntityHandler 
{
	@SubscribeEvent
	public void onDeath(LivingDeathEvent event)
	{
		if (event.source.getEntity() instanceof EntityPlayer)
		{
			//LogHelper.info("instanceof a player");
			EntityPlayer player = (EntityPlayer) event.source.getEntity();
			if (player.getHeldItem().getItem() != null && player.getHeldItem().getItem() == ToeItems.cane)
			{
				//ItemCane.update(player, ItemCane.getStacks(player) + 1);
				ItemStack stack = player.getHeldItem();
				
				if (stack.stackTagCompound != null) {
					int stacks = stack.stackTagCompound.getInteger("stacks");
					stack.stackTagCompound.setInteger("stacks", stacks+1);
				}
				
			}
		}
		//LogHelper.info("onDeath");
	}
	
	@SubscribeEvent
	public void onAttack(LivingAttackEvent event)
	{
		if (event.entityLiving instanceof EntityPlayer && event.source.getEntity() instanceof EntityLiving)
		{
			//LogHelper.info("instanceof a player");
			EntityPlayer player = (EntityPlayer) event.entityLiving;
			
			if (player.getCurrentArmor(0) != null && player.getCurrentArmor(0).getItem().equals(ToeItems.magmaBoots) && 
					player.getCurrentArmor(1) != null && player.getCurrentArmor(1).getItem().equals(ToeItems.magmaPants) &&
					player.getCurrentArmor(2) != null && player.getCurrentArmor(2).getItem().equals(ToeItems.magmaPlate) &&
					player.getCurrentArmor(3) != null && player.getCurrentArmor(3).getItem().equals(ToeItems.magmaHelmet))
			{
					event.source.getEntity().setFire(10);
			}
		}
	}
}
