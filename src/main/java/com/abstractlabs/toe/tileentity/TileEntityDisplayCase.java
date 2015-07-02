package com.abstractlabs.toe.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

import com.abstractlabs.toe.reference.Smelting;

public class TileEntityDisplayCase extends TileEntity implements ISidedInventory {
//	private static final int[] slotsTop = new int[] {0};
//    private static final int[] slotsBottom = new int[] {2, 1};
//    private static final int[] slotsSides = new int[] {1};
	private static final int[] slots = new int[] {0};
    private ItemStack[] is = new ItemStack[1]; /** The ItemStacks that hold the items currently being used in the furnace */
//    public int furnaceBurnTime; /** The number of ticks that the furnace will keep burning */
//    public int currentItemBurnTime; /** The number of ticks that a fresh copy of the currently-burning item would keep the furnace burning for */
//    public int furnaceCookTime; /** The number of ticks that the current item has been cooking for */
    private String name;
    
    //private static double speedModifier = Smelting.furnaceSpeedModifier_Diamond;
	
    public int getSizeInventory() {
        return this.is.length;
    }

    public ItemStack getStackInSlot(int slot) {
        return this.is[slot];
    }

    public ItemStack decrStackSize(int slot, int num) {
        if (this.is[slot] != null) {
            ItemStack itemstack;

            if (this.is[slot].stackSize <= num) {
                itemstack = this.is[slot];
                this.is[slot] = null;
                return itemstack;
            } else {
                itemstack = this.is[slot].splitStack(num);

                if (this.is[slot].stackSize == 0) {
                    this.is[slot] = null;
                }

                return itemstack;
            }
        } else {
            return null;
        }
    }

    public ItemStack getStackInSlotOnClosing(int slot) {
        if (this.is[slot] != null) {
            ItemStack itemstack = this.is[slot];
            this.is[slot] = null;
            return itemstack;
        } else {
            return null;
        }
    }

    public void setInventorySlotContents(int slot, ItemStack is) {
        this.is[slot] = is;

        if (is != null && is.stackSize > this.getInventoryStackLimit()) {
        	is.stackSize = this.getInventoryStackLimit();
        }
    }

    public String getInventoryName() {
        return this.hasCustomInventoryName() ? this.name : "Display Case";
    }

    public boolean hasCustomInventoryName() {
        return this.name != null && this.name.length() > 0;
    }

    public void setCustomName(String name) {
        this.name = name;
    }

    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);
        NBTTagList nbttaglist = nbt.getTagList("Items", 10);
        this.is = new ItemStack[this.getSizeInventory()];

        for (int i = 0; i < nbttaglist.tagCount(); ++i) {
            NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
            byte b0 = nbttagcompound1.getByte("Slot");

            if (b0 >= 0 && b0 < this.is.length) {
                this.is[b0] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
            }
        }

//        this.furnaceBurnTime = nbt.getShort("BurnTime");
//        this.furnaceCookTime = nbt.getShort("CookTime");
//        this.currentItemBurnTime = getItemBurnTime(this.is[1]);

        if (nbt.hasKey("CustomName", 8)) {
            this.name = nbt.getString("CustomName");
        }
    }

    public void writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);
//        nbt.setShort("BurnTime", (short)this.furnaceBurnTime);
//        nbt.setShort("CookTime", (short)this.furnaceCookTime);
        NBTTagList nbttaglist = new NBTTagList();

        for (int i = 0; i < this.is.length; ++i) {
            if (this.is[i] != null) {
                NBTTagCompound nbttagcompound1 = new NBTTagCompound();
                nbttagcompound1.setByte("Slot", (byte)i);
                this.is[i].writeToNBT(nbttagcompound1);
                nbttaglist.appendTag(nbttagcompound1);
            }
        }

        nbt.setTag("Items", nbttaglist);

        if (this.hasCustomInventoryName()) {
        	nbt.setString("CustomName", this.name);
        }
    }

    public int getInventoryStackLimit() {
        return 64;
    }
    
    /**
     * Do not make give this method the name canInteractWith because it clashes with Container
     */
    public boolean isUseableByPlayer(EntityPlayer player) {
        return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : player.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64.0D;
    }

    public void openInventory() {}

    public void closeInventory() {}

    
//    public int[] getAccessibleSlotsFromSide(int side) {
//        return side == 0 ? slotsBottom : (side == 1 ? slotsTop : slotsSides);
//    }

    /**
     * Returns true if automation can insert the given item in the given slot from the given side. Args: Slot, item,
     * side
     */
    public boolean canInsertItem(int slot, ItemStack is, int side) {
        return this.isItemValidForSlot(slot, is);
    }

    /**
     * Returns true if automation can extract the given item in the given slot from the given side. Args: Slot, item,
     * side
     */
    public boolean canExtractItem(int slot, ItemStack is, int side) {
        return side != 0 || slot != 1 || is.getItem() == Items.bucket;
    }

	@Override
	public boolean isItemValidForSlot(int p_94041_1_, ItemStack p_94041_2_) {
		return true;
	}

	@Override
	public int[] getAccessibleSlotsFromSide(int p_94128_1_) {
		return slots;
	}
	
	public ItemStack getItemStack() {
		return this.getStackInSlot(0);
	}
}