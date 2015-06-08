package com.abstractlabs.toe.handler;

import java.util.Random;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
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
		
		if(event.entityLiving instanceof EntityMob) {
			if(!event.entityLiving.worldObj.isRemote) {
				Random rand = new Random();
				int r = rand.nextInt(100)+1;
				
				if(r==100) { // 1%
					event.entityLiving.entityDropItem(new ItemStack(ToeItems.coinGold, 1, 0), 1.0F);
				} else if(r<=99 && r>=90) { // 10%
					event.entityLiving.entityDropItem(new ItemStack(ToeItems.coinSilver, 1, 0), 1.0F);
				} else if(r<=89 && r>=50) { // 40%
					event.entityLiving.entityDropItem(new ItemStack(ToeItems.coinCopper, 2, 0), 1.0F);
				} else if(r<=49 && r>=20) { // 30%
					event.entityLiving.entityDropItem(new ItemStack(ToeItems.coinCopper, 1, 0), 1.0F);
				} else { // 19%
					//drop no coins
				}
			}
		}
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
