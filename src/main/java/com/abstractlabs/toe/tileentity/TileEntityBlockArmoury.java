package com.abstractlabs.toe.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TileEntityBlockArmoury extends TileEntity
{
	  private ItemStack[] inv;
    
      public boolean isUseableByPlayer(EntityPlayer player) {
              return worldObj.getTileEntity(xCoord, yCoord, zCoord) == this &&
              player.getDistanceSq(xCoord + 0.5, yCoord + 0.5, zCoord + 0.5) < 64;
      }
		
      @Override
      public void readFromNBT(NBTTagCompound tagCompound)
      {
		super.readFromNBT(tagCompound);
		
		NBTTagList tagList = tagCompound.getTagList("Inventory", 10);
		
		for (int i = 0; i < tagList.tagCount(); i++)
		{
			NBTTagCompound tag = tagList.getCompoundTagAt(i);
			byte slot = tag.getByte("Slot");
			if (slot >= 0 && slot < inv.length)
			{
				inv[slot] = ItemStack.loadItemStackFromNBT(tag);
			}
		}
      }
      
      @Override
      public void writeToNBT(NBTTagCompound tagCompound)
      {
    	  super.writeToNBT(tagCompound);
    	  
    	  NBTTagList itemList = new NBTTagList();
          for (int i = 0; i < inv.length; i++) 
          {
        	  ItemStack stack = inv[i];
              if (stack != null) 
              {
            	  NBTTagCompound tag = new NBTTagCompound();
            	  tag.setByte("Slot", (byte) i);
            	  stack.writeToNBT(tag);
            	  itemList.appendTag(tag);
              }
          }
          tagCompound.setTag("Inventory", itemList);
      }
}
