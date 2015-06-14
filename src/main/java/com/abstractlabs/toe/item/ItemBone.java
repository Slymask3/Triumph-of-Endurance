package com.abstractlabs.toe.item;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
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

public class ItemBone extends ItemToe
{
	private int lvl;

	public ItemBone(int lvl)
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
		if (PrayerHelper.getProperties(player).getLevel() >= this.lvl)
		{
			list.add(EnumChatFormatting.GREEN + "Level Required: " + this.lvl);
		}
		else
		{
			list.add(EnumChatFormatting.RED + "Level Required: " + this.lvl);
		}
		//ToeItems.bone.addInformation(is, player, list, par4);
	}
}
