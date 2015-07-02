package com.abstractlabs.toe.item;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class ItemToeSwordActive extends ItemToeSword {
	public ItemToeSwordActive(ToolMaterial material) {
		super(material);
	}
	
	public void onUpdate(ItemStack is, World world, Entity entity, int par4, boolean par5) {
		if (is.stackTagCompound == null) {
			is.stackTagCompound = new NBTTagCompound();
		    is.stackTagCompound.setBoolean("activeAvailable", true);
		    is.stackTagCompound.setInteger("ticks", 0);
		} else if(is.stackTagCompound != null) {
			if(!is.stackTagCompound.getBoolean("activeAvailable")) {
				if(is.stackTagCompound.getInteger("ticks") >= 0) {
					is.stackTagCompound.setInteger("ticks", is.stackTagCompound.getInteger("ticks")-1);
				} else {
					is.stackTagCompound.setBoolean("activeAvailable", true);
				}
			}
		}
	}
}