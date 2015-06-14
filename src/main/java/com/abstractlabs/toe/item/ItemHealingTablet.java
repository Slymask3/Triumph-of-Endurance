package com.abstractlabs.toe.item;

import java.util.List;

import com.abstractlabs.toe.skill.prayer.PrayerHelper;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

public class ItemHealingTablet extends ItemToe
{
	private int lvl;

	public ItemHealingTablet(int lvl)
	{
		super();
		this.maxStackSize = 1;
		this.lvl = lvl;
	}



	public void onUpdate(ItemStack is, World world, Entity entity, int par4, boolean par5)
	{

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
