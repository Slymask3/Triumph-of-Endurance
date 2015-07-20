package com.abstractlabs.toe.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

public class InventoryDyer implements IInventory {
    private ItemStack[] itemstacks = new ItemStack[3];
	
	@Override
	public int getSizeInventory() {
		return this.itemstacks.length;
	}

	@Override
	public ItemStack getStackInSlot(int slot) {
		return this.itemstacks[slot];
	}

	@Override
	public ItemStack decrStackSize(int slot, int num) {
        if (this.itemstacks[slot] != null) {
            ItemStack itemstack;

            if (this.itemstacks[slot].stackSize <= num) {
                itemstack = this.itemstacks[slot];
                this.itemstacks[slot] = null;
                return itemstack;
            } else {
                itemstack = this.itemstacks[slot].splitStack(num);

                if (this.itemstacks[slot].stackSize == 0) {
                    this.itemstacks[slot] = null;
                }

                return itemstack;
            }
        } else {
            return null;
        }
    }

	@Override
	public ItemStack getStackInSlotOnClosing(int slot) {
        if (this.itemstacks[slot] != null) {
            ItemStack itemstack = this.itemstacks[slot];
            this.itemstacks[slot] = null;
            return itemstack;
        } else {
            return null;
        }
    }

	@Override
    public void setInventorySlotContents(int slot, ItemStack is) {
        this.itemstacks[slot] = is;

        if (is != null && is.stackSize > this.getInventoryStackLimit()) {
        	is.stackSize = this.getInventoryStackLimit();
        }
    }

	@Override
	public String getInventoryName() {
		return "Dyer";
	}

	@Override
	public boolean hasCustomInventoryName() {
		return false;
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public void markDirty() {
		
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		return true;
	}

	@Override
	public void openInventory() {
		
	}

	@Override
	public void closeInventory() {
		
	}

	@Override
	public boolean isItemValidForSlot(int slot, ItemStack is) {
		return true;
	}
}