package com.abstractlabs.toe.item;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

import com.abstractlabs.toe.skill.theiving.ThievingHelper;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemLockpick extends ItemToe {
	private int lvl;
	private double chance;
	
	public ItemLockpick(int maxdmg, int lvl, double chance) {
		super();
		this.maxStackSize = 1;
		this.setMaxDamage(maxdmg);
		this.lvl = lvl;
		this.chance = chance;
	}
	
	public ItemStack onItemRightClick(ItemStack is, World world, EntityPlayer player) {
		//unlocking chest code in locked chest class
        return is;
    }
	
	@SideOnly(Side.CLIENT)
    public boolean isFull3D() {
        return true;
    }
	
	public int getLvl() {
		return this.lvl;
	}
	
	public double getChance() {
		return this.chance;
	}
	
	public void addInformation(ItemStack is, EntityPlayer player, List list, boolean par4) {
		if(!player.worldObj.isRemote) {
			int max = (is.getMaxDamage()) + 1;
			int dmg = (is.getMaxDamage() - is.getItemDamage()) + 1;
	
			if(ThievingHelper.getProperties(player).getLevel() >= this.lvl) {
				list.add(EnumChatFormatting.GREEN + "Level Required: " + this.lvl);
			} else {
				list.add(EnumChatFormatting.RED + "Level Required: " + this.lvl);
			}
			
			list.add(EnumChatFormatting.AQUA + "Chance: " + this.chance*100 + "%");
			list.add(EnumChatFormatting.GREEN + "Uses: " + dmg + "/" + max);
		}
	}
}