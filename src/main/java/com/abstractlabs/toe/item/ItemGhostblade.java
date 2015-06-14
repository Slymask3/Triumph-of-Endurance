package com.abstractlabs.toe.item;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.util.EnumHelper;

import com.abstractlabs.toe.reference.Color;
import com.abstractlabs.toe.utility.Helper;
import com.abstractlabs.toe.utility.LogHelper;

public class ItemGhostblade extends ItemToeSword {
	public ItemGhostblade() {
		super(EnumHelper.addToolMaterial("Ghostblade", 3, 500, 3, 4, 10));
	}
	
	//private int ticks = 0;
	
	public void onUpdate(ItemStack is, World world, Entity entity, int par4, boolean par5) {
		if (is.stackTagCompound == null) {
			is.stackTagCompound = new NBTTagCompound();
		    is.stackTagCompound.setBoolean("activeAvailable", true);
		    is.stackTagCompound.setInteger("ticks", 0);
		} else if(is.stackTagCompound != null) {
			if(!is.stackTagCompound.getBoolean("activeAvailable")) {
				if(is.stackTagCompound.getInteger("ticks") >= 0) {
					//ticks--;
					is.stackTagCompound.setInteger("ticks", is.stackTagCompound.getInteger("ticks")-1);
				} else {
					is.stackTagCompound.setBoolean("activeAvailable", true);
				}
			}
		}
	}

	@Override
	public boolean onItemUse(ItemStack is, EntityPlayer player, World world, int par4, int par5, int par6, int par7, float par8, float par9, float par10) {
		if (is.stackTagCompound != null) {
			if(is.stackTagCompound.getBoolean("activeAvailable")) {
				player.addPotionEffect(new PotionEffect(1, 5*20, 2));
				player.addPotionEffect(new PotionEffect(5, 5*20, 2));
				
				Helper.msg(player, "Ghostblade activated!", Color.magenta);

				//ticks = 2000;
				is.stackTagCompound.setInteger("ticks", 3600); //3min
				is.stackTagCompound.setBoolean("activeAvailable", false);
				
				LogHelper.info("onItemUse Ghostblade");
		        return true;
			} else {
				Helper.msg(player, "Ghostblade is on cooldown.", Color.red);
		        return true;
			}
		}
        return false;
    }

	@Override
	public boolean hitEntity(ItemStack itemStack, EntityLivingBase elb, EntityLivingBase elb2) {
		itemStack.damageItem(1, elb);
		return true;
    }
	
	@Override
	public void addInformation(ItemStack is, EntityPlayer player, List list, boolean boo) {
		if (is.stackTagCompound != null) {
			boolean active = is.stackTagCompound.getBoolean("activeAvailable");
			int ticks = is.stackTagCompound.getInteger("ticks");
			if(active) {
				list.add(EnumChatFormatting.AQUA + "Active Avaliable: Yes");
				list.add(EnumChatFormatting.GOLD + "Active Desccription: User gains");
				list.add(EnumChatFormatting.GOLD + "Speed III and Strength III");
				list.add(EnumChatFormatting.GOLD + "for 5 seconds.");
			} else if(!active) {
				list.add(EnumChatFormatting.RED + "Active Avaliable: No");
				list.add(EnumChatFormatting.RED + "Active Cooldown: " + ticks/20);
			}
		}
	}
	
//	@Override
//	public Multimap getAttributeModifiers(ItemStack stack) {
//		Multimap multimap = HashMultimap.create();
//		
//		if (stack.stackTagCompound != null) {
//			int stacks = stack.stackTagCompound.getInteger("stacks");
//			multimap.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(field_111210_e, "Weapon modifier", 1 + (stacks / 10), 0));
//		}
//		
//		return multimap;
//	}
}
