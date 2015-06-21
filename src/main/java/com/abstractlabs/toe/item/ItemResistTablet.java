package com.abstractlabs.toe.item;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

import com.abstractlabs.toe.reference.Color;
import com.abstractlabs.toe.skill.prayer.PrayerHelper;
import com.abstractlabs.toe.utility.Helper;
import com.abstractlabs.toe.utility.LogHelper;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemResistTablet extends ItemToe
{
	private int lvl;

	public ItemResistTablet(int lvl)
	{
		super();
		this.maxStackSize = 1;
		this.lvl = lvl;
	}

	public void onUpdate(ItemStack is, World world, Entity entity, int par4, boolean par5)
	{
		if (is.stackTagCompound == null)
		{
			is.stackTagCompound = new NBTTagCompound();
			is.stackTagCompound.setBoolean("activeAvailable", true);
			is.stackTagCompound.setInteger("ticks", 0);
		}
		else if (is.stackTagCompound != null)
		{
			if (!is.stackTagCompound.getBoolean("activeAvailable"))
			{
				if (is.stackTagCompound.getInteger("ticks") >= 0)
				{
					is.stackTagCompound.setInteger("ticks", is.stackTagCompound.getInteger("ticks") - 1);
				}
				else
				{
					is.stackTagCompound.setBoolean("activeAvailable", true);
				}
			}
		}
	}

	@Override
	public boolean onItemUse(ItemStack is, EntityPlayer player, World world, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
	{
		if (is.stackTagCompound != null)
		{
			if (is.stackTagCompound.getBoolean("activeAvailable"))
			{
				player.addPotionEffect(new PotionEffect(12, 5*20, 2));

				Helper.msg(player, "Tablet activated!", Color.magenta);

				//ticks = 2000
				is.stackTagCompound.setInteger("ticks", 4800); //4min
				is.stackTagCompound.setBoolean("activeAvailable", false);

				LogHelper.info("onItemUse resistTab");

				return true;
			}
			else 
			{
				Helper.msg(player, "Fire Resistance Tablet is on cooldown.", Color.red);
				return true;
			}
		}
		return false;
	}

	@SideOnly(Side.CLIENT)
	public boolean isFull3D()
	{
		return true;
	}

	public int getLvl()
	{
		return this.lvl;
	}

	public void addInformation(ItemStack is, EntityPlayer player, List list, boolean par4)
	{
		if (is.stackTagCompound != null) 
		{
			boolean active = is.stackTagCompound.getBoolean("activeAvailable");

			int ticks = is.stackTagCompound.getInteger("ticks");

			if (active) 
			{
				list.add(EnumChatFormatting.AQUA + "Active Available: Yes");
				list.add(EnumChatFormatting.GOLD + "Active Desccription: User is");
				list.add(EnumChatFormatting.GOLD + "given fire resistance for 5.");
				list.add(EnumChatFormatting.GOLD + "seconds.");
			} 
			else if(!active) 
			{
				list.add(EnumChatFormatting.RED + "Active Available: No");
				list.add(EnumChatFormatting.RED + "Active Cooldown: " + ticks/20);
			}
		}

		if (PrayerHelper.getProperties(player).getLevel() >= this.lvl)
		{
			list.add(EnumChatFormatting.GREEN + "Level Required: " + this.lvl);
		}
		else
		{
			list.add(EnumChatFormatting.RED + "Level Required: " + this.lvl);
		}
	}
}

