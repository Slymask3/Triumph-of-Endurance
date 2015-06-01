package com.abstractlabs.toe.item;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.DimensionManager;

import com.abstractlabs.toe.reference.Color;
import com.abstractlabs.toe.utility.Helper;
import com.abstractlabs.toe.utility.LogHelper;

public class ItemRecall extends ItemToe {
	public ItemRecall() {
		super();
		this.maxStackSize = 1;
		this.setMaxDamage(29);
	}
	
	public ItemStack onItemRightClick(ItemStack is, World world, EntityPlayer player) {
        if(is.stackTagCompound != null) {
    		int dim = is.stackTagCompound.getInteger("dim");
    		World worldNew = DimensionManager.getWorld(dim);
    		int x = is.stackTagCompound.getInteger("x");
    		int y = is.stackTagCompound.getInteger("y");
    		int z = is.stackTagCompound.getInteger("z");
    		String name = is.stackTagCompound.getString("name");

    		if(!world.isRemote) { //have to make sure this code is only running on the server side, because it causes crashes in mp
        		if(worldNew.getTileEntity(x, y, z) != null) {
	    			if(!player.capabilities.isCreativeMode) {
	                	is.damageItem(1, player);
	                }
	        		
	        		if(world != worldNew) {
	        			player.travelToDimension(dim);
	        		}
	        		
	        		player.setPositionAndUpdate(x+0.5, y+0.5, z+0.5);
	        		
	            	Helper.msg(player, "Teleported successfully to " + name + ".", Color.lime);
	    		} else {
	            	Helper.msg(player, "The destination block has been obscructed. Please connect to a new destination.", Color.red);
	            	is.stackTagCompound = null;
	    		}
    		}
        } else {
        	Helper.msg(player, "You have to connect this to a destination before use.", Color.red);
        }
        
        return is;
    }
	
	public void addInformation(ItemStack is, EntityPlayer player, List list, boolean par4) {
		try {
			if(is.stackTagCompound != null) {
				int dim = is.stackTagCompound.getInteger("dim");
				World world = DimensionManager.getWorld(dim);
				int x = is.stackTagCompound.getInteger("x");
				int y = is.stackTagCompound.getInteger("y");
				int z = is.stackTagCompound.getInteger("z");
				String name = is.stackTagCompound.getString("name");
				
				int max = (is.getMaxDamage()) + 1;
				int dmg = (is.getMaxDamage() - is.getItemDamage()) + 1;
		
				list.add(EnumChatFormatting.AQUA + "Destination: " + name);
				list.add(EnumChatFormatting.GOLD + "World: " + world.provider.getDimensionName());
				list.add(EnumChatFormatting.GOLD + "X: " + x);
				list.add(EnumChatFormatting.GOLD + "Y: " + y);
				list.add(EnumChatFormatting.GOLD + "Z: " + z);
				list.add(EnumChatFormatting.GREEN + "Uses: " + dmg + "/" + max);
			}
		} catch(NullPointerException e) {
			LogHelper.info("[TOE|ItemRecall] NullPointerException was caught when trying to run addInformation().");
		}
	}
}