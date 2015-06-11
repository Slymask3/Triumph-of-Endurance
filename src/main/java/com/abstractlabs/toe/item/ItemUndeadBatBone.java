package com.abstractlabs.toe.item;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

import com.abstractlabs.toe.init.ToeItems;
import com.abstractlabs.toe.reference.BoneType;
import com.abstractlabs.toe.reference.Color;
import com.abstractlabs.toe.skill.prayer.PrayerHelper;
import com.abstractlabs.toe.utility.Helper;
import com.abstractlabs.toe.utility.LogHelper;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemUndeadBatBone extends ItemToe
{
	private int lvl;

	public ItemUndeadBatBone(int lvl)
	{
		super();
		this.maxStackSize = 1;
		this.lvl = lvl;
	}

	public ItemStack onItemRightClick(ItemStack is, World world, EntityPlayer player)
	{
		return is;
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
		//		int max = (is.getMaxDamage()) + 1;
		//		int dmg = (is.getMaxDamage() - is.getItemDamage()) + 1;

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
