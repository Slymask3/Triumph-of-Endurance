package com.abstractlabs.toe.tileentity;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

import com.abstractlabs.toe.block.BlockTransmutation;
import com.abstractlabs.toe.reference.Smelting;
import com.abstractlabs.toe.utility.ItemRarity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TileEntityTransmutation extends TileEntity implements ISidedInventory {
	private static final int[] slotsTop = new int[] {0};
    private static final int[] slotsBottom = new int[] {2, 1};
    private static final int[] slotsSides = new int[] {1};
    private ItemStack[] itemstacks = new ItemStack[3]; /** The ItemStacks that hold the items currently being used in the furnace */
    public int burnTime; /** The number of ticks that the furnace will keep burning */
    public int burnTimeCurrent; /** The number of ticks that a fresh copy of the currently-burning item would keep the furnace burning for */
    public int transmuteTime; /** The number of ticks that the current item has been cooking for */
    private String name;
    
    private static double speedModifier = Smelting.furnaceSpeedModifier_Redstone;
	
    public int getSizeInventory() {
        return this.itemstacks.length;
    }

    public ItemStack getStackInSlot(int slot) {
        return this.itemstacks[slot];
    }

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

    public ItemStack getStackInSlotOnClosing(int slot) {
        if (this.itemstacks[slot] != null) {
            ItemStack itemstack = this.itemstacks[slot];
            this.itemstacks[slot] = null;
            return itemstack;
        } else {
            return null;
        }
    }

    public void setInventorySlotContents(int slot, ItemStack is) {
        this.itemstacks[slot] = is;

        if (is != null && is.stackSize > this.getInventoryStackLimit()) {
        	is.stackSize = this.getInventoryStackLimit();
        }
    }

    public String getInventoryName() {
        return this.hasCustomInventoryName() ? this.name : "Transmutation";
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
        this.itemstacks = new ItemStack[this.getSizeInventory()];

        for (int i = 0; i < nbttaglist.tagCount(); ++i) {
            NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
            byte b0 = nbttagcompound1.getByte("Slot");

            if (b0 >= 0 && b0 < this.itemstacks.length) {
                this.itemstacks[b0] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
            }
        }

        this.burnTime = nbt.getShort("BurnTime");
        this.transmuteTime = nbt.getShort("TransmuteTime");
        this.burnTimeCurrent = getItemBurnTime(this.itemstacks[1]);

        if (nbt.hasKey("CustomName", 8)) {
            this.name = nbt.getString("CustomName");
        }
    }

    public void writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);
        nbt.setShort("BurnTime", (short)this.burnTime);
        nbt.setShort("TransmuteTime", (short)this.transmuteTime);
        NBTTagList nbttaglist = new NBTTagList();

        for (int i = 0; i < this.itemstacks.length; ++i) {
            if (this.itemstacks[i] != null) {
                NBTTagCompound nbttagcompound1 = new NBTTagCompound();
                nbttagcompound1.setByte("Slot", (byte)i);
                this.itemstacks[i].writeToNBT(nbttagcompound1);
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
     * Returns an integer between 0 and the passed value representing how close the current item is to being completely
     * cooked
     */
    @SideOnly(Side.CLIENT)
    public int getTransmuteProgressScaled(int par1) {
        return (int) (this.transmuteTime * par1 / (200*speedModifier));
    }

    /**
     * Returns an integer between 0 and the passed value representing how much burn time is left on the current fuel
     * item, where 0 means that the item is exhausted and the passed value means that the item is fresh
     */
    @SideOnly(Side.CLIENT)
    public int getBurnTimeRemainingScaled(int par1) {
        if (this.burnTimeCurrent == 0) {
            this.burnTimeCurrent = (int) (200*speedModifier);
        }

        return this.burnTime * par1 / this.burnTimeCurrent;
    }

    public boolean isBurning() {
        return this.burnTime > 0;
    }

    public void updateEntity() {
        boolean flag = this.burnTime > 0;
        boolean flag1 = false;

        if (this.burnTime > 0) {
            --this.burnTime;
        }

        if (!this.worldObj.isRemote) {
            if (this.burnTime != 0 || this.itemstacks[1] != null && this.itemstacks[0] != null) {
                if (this.burnTime == 0 && this.canTransmute()) {
                    this.burnTimeCurrent = this.burnTime = getItemBurnTime(this.itemstacks[1]);

                    if (this.burnTime > 0) {
                        flag1 = true;

                        if (this.itemstacks[1] != null) {
                            --this.itemstacks[1].stackSize;

                            if (this.itemstacks[1].stackSize == 0) {
                                this.itemstacks[1] = itemstacks[1].getItem().getContainerItem(itemstacks[1]);
                            }
                        }
                    }
                }

                if (this.isBurning() && this.canTransmute()) {
                    ++this.transmuteTime;

                    if (this.transmuteTime == (200*speedModifier)) {
                        this.transmuteTime = 0;
                        this.transmuteItem();
                        flag1 = true;
                    }
                } else {
                    this.transmuteTime = 0;
                }
            }

            if (flag != this.burnTime > 0) {
                flag1 = true;
                BlockTransmutation.updateBlockState(this.burnTime > 0, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
            }
        }

        if (flag1) {
            this.markDirty();
        }
    }

    /**
     * Returns true if the furnace can smelt an item, i.e. has a source item, destination stack isn't full, etc.
     */
    private boolean canTransmute() {
        if (this.itemstacks[0] == null) {
            return false;
        } else if(itemstacks[2] == null && ItemRarity.canTransmute(itemstacks[0])) {
            return true;
        }
        
        return false;
    }

    /**
     * Turn one item from the furnace source stack into the appropriate smelted item in the furnace result stack
     */
    public void transmuteItem() {
        if (this.canTransmute()) {
            //ItemStack itemstack = FurnaceRecipes.smelting().getSmeltingResult(this.itemstacks[0]);
            ItemStack itemstack = ItemRarity.getRandomItemStackWithRarity(ItemRarity.getRarityLevel(itemstacks[0]));

            if (this.itemstacks[2] == null) {
                this.itemstacks[2] = itemstack.copy();
            } else if (this.itemstacks[2].getItem() == itemstack.getItem()) {
                this.itemstacks[2].stackSize += itemstack.stackSize; // Forge BugFix: Results may have multiple items
            }

            --this.itemstacks[0].stackSize;

            if (this.itemstacks[0].stackSize <= 0) {
                this.itemstacks[0] = null;
            }
        }
    }

    /**
     * Returns the number of ticks that the supplied fuel item will keep the furnace burning, or 0 if the item isn't
     * fuel
     */
    public static int getItemBurnTime(ItemStack is) {
        if (is == null) {
            return 0;
        } else {
            Item item = is.getItem();

            if (item instanceof ItemBlock && Block.getBlockFromItem(item) != Blocks.air) {
                Block block = Block.getBlockFromItem(item);

                if (block == Blocks.redstone_block) {
                    return (int) (16000*speedModifier);
                }
            }

            if (item == Items.redstone) return (int) (1600*speedModifier);
            return 0;
        }
    }

    public static boolean isItemFuel(ItemStack is) {
        return getItemBurnTime(is) > 0;
    }

    /**
     * Do not make give this method the name canInteractWith because it clashes with Container
     */
    public boolean isUseableByPlayer(EntityPlayer player) {
        return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : player.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64.0D;
    }

    public void openInventory() {}

    public void closeInventory() {}

    /**
     * Returns true if automation is allowed to insert the given stack (ignoring stack size) into the given slot.
     */
    public boolean isItemValidForSlot(int slot, ItemStack is) {
        return slot == 2 ? false : (slot == 1 ? isItemFuel(is) : true);
    }

    /**
     * Returns an array containing the indices of the slots that can be accessed by automation on the given side of this
     * block.
     */
    public int[] getAccessibleSlotsFromSide(int side) {
        return side == 0 ? slotsBottom : (side == 1 ? slotsTop : slotsSides);
    }

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
}