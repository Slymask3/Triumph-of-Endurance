package com.abstractlabs.toe.tileentity;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

import com.abstractlabs.toe.block.BlockFurnaceEmerald;
import com.abstractlabs.toe.reference.Smelting;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TileEntityFurnaceEmerald extends TileEntity implements ISidedInventory {
	private static final int[] slotsTop = new int[] {0};
    private static final int[] slotsBottom = new int[] {2, 1};
    private static final int[] slotsSides = new int[] {1};
    private ItemStack[] furnaceItemStacks = new ItemStack[3]; /** The ItemStacks that hold the items currently being used in the furnace */
    public int furnaceBurnTime; /** The number of ticks that the furnace will keep burning */
    public int currentItemBurnTime; /** The number of ticks that a fresh copy of the currently-burning item would keep the furnace burning for */
    public int furnaceCookTime; /** The number of ticks that the current item has been cooking for */
    private String name;
    
    private static double speedModifier = Smelting.furnaceSpeedModifier_Emerald;
	
    public int getSizeInventory() {
        return this.furnaceItemStacks.length;
    }

    public ItemStack getStackInSlot(int slot) {
        return this.furnaceItemStacks[slot];
    }

    public ItemStack decrStackSize(int slot, int num) {
        if (this.furnaceItemStacks[slot] != null) {
            ItemStack itemstack;

            if (this.furnaceItemStacks[slot].stackSize <= num) {
                itemstack = this.furnaceItemStacks[slot];
                this.furnaceItemStacks[slot] = null;
                return itemstack;
            } else {
                itemstack = this.furnaceItemStacks[slot].splitStack(num);

                if (this.furnaceItemStacks[slot].stackSize == 0) {
                    this.furnaceItemStacks[slot] = null;
                }

                return itemstack;
            }
        } else {
            return null;
        }
    }

    public ItemStack getStackInSlotOnClosing(int slot) {
        if (this.furnaceItemStacks[slot] != null) {
            ItemStack itemstack = this.furnaceItemStacks[slot];
            this.furnaceItemStacks[slot] = null;
            return itemstack;
        } else {
            return null;
        }
    }

    public void setInventorySlotContents(int slot, ItemStack is) {
        this.furnaceItemStacks[slot] = is;

        if (is != null && is.stackSize > this.getInventoryStackLimit()) {
        	is.stackSize = this.getInventoryStackLimit();
        }
    }

    public String getInventoryName() {
        return this.hasCustomInventoryName() ? this.name : "Emerald Furnace";
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
        this.furnaceItemStacks = new ItemStack[this.getSizeInventory()];

        for (int i = 0; i < nbttaglist.tagCount(); ++i) {
            NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
            byte b0 = nbttagcompound1.getByte("Slot");

            if (b0 >= 0 && b0 < this.furnaceItemStacks.length) {
                this.furnaceItemStacks[b0] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
            }
        }

        this.furnaceBurnTime = nbt.getShort("BurnTime");
        this.furnaceCookTime = nbt.getShort("CookTime");
        this.currentItemBurnTime = getItemBurnTime(this.furnaceItemStacks[1]);

        if (nbt.hasKey("CustomName", 8)) {
            this.name = nbt.getString("CustomName");
        }
    }

    public void writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);
        nbt.setShort("BurnTime", (short)this.furnaceBurnTime);
        nbt.setShort("CookTime", (short)this.furnaceCookTime);
        NBTTagList nbttaglist = new NBTTagList();

        for (int i = 0; i < this.furnaceItemStacks.length; ++i) {
            if (this.furnaceItemStacks[i] != null) {
                NBTTagCompound nbttagcompound1 = new NBTTagCompound();
                nbttagcompound1.setByte("Slot", (byte)i);
                this.furnaceItemStacks[i].writeToNBT(nbttagcompound1);
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
    public int getCookProgressScaled(int par1) {
        return (int) (this.furnaceCookTime * par1 / (200*speedModifier));
    }

    /**
     * Returns an integer between 0 and the passed value representing how much burn time is left on the current fuel
     * item, where 0 means that the item is exhausted and the passed value means that the item is fresh
     */
    @SideOnly(Side.CLIENT)
    public int getBurnTimeRemainingScaled(int par1) {
        if (this.currentItemBurnTime == 0) {
            this.currentItemBurnTime = (int) (200*speedModifier);
        }

        return this.furnaceBurnTime * par1 / this.currentItemBurnTime;
    }

    public boolean isBurning() {
        return this.furnaceBurnTime > 0;
    }

    public void updateEntity() {
        boolean flag = this.furnaceBurnTime > 0;
        boolean flag1 = false;

        if (this.furnaceBurnTime > 0) {
            --this.furnaceBurnTime;
        }

        if (!this.worldObj.isRemote) {
            if (this.furnaceBurnTime != 0 || this.furnaceItemStacks[1] != null && this.furnaceItemStacks[0] != null) {
                if (this.furnaceBurnTime == 0 && this.canSmelt()) {
                    this.currentItemBurnTime = this.furnaceBurnTime = getItemBurnTime(this.furnaceItemStacks[1]);

                    if (this.furnaceBurnTime > 0) {
                        flag1 = true;

                        if (this.furnaceItemStacks[1] != null) {
                            --this.furnaceItemStacks[1].stackSize;

                            if (this.furnaceItemStacks[1].stackSize == 0) {
                                this.furnaceItemStacks[1] = furnaceItemStacks[1].getItem().getContainerItem(furnaceItemStacks[1]);
                            }
                        }
                    }
                }

                if (this.isBurning() && this.canSmelt()) {
                    ++this.furnaceCookTime;

                    if (this.furnaceCookTime >= (200*speedModifier)) {
                        this.furnaceCookTime = 0;
                        this.smeltItem();
                        flag1 = true;
                    }
                } else {
                    this.furnaceCookTime = 0;
                }
            }

            if (flag != this.furnaceBurnTime > 0) {
                flag1 = true;
                BlockFurnaceEmerald.updateFurnaceBlockState(this.furnaceBurnTime > 0, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
            }
        }

        if (flag1) {
            this.markDirty();
        }
    }

    /**
     * Returns true if the furnace can smelt an item, i.e. has a source item, destination stack isn't full, etc.
     */
    private boolean canSmelt() {
        if (this.furnaceItemStacks[0] == null) {
            return false;
        } else {
            ItemStack itemstack = FurnaceRecipes.smelting().getSmeltingResult(this.furnaceItemStacks[0]);
            if (itemstack == null) return false;
            if (this.furnaceItemStacks[2] == null) return true;
            if (!this.furnaceItemStacks[2].isItemEqual(itemstack)) return false;
            int result = furnaceItemStacks[2].stackSize + itemstack.stackSize;
            return result <= getInventoryStackLimit() && result <= this.furnaceItemStacks[2].getMaxStackSize(); //Forge BugFix: Make it respect stack sizes properly.
        }
    }

    /**
     * Turn one item from the furnace source stack into the appropriate smelted item in the furnace result stack
     */
    public void smeltItem() {
        if (this.canSmelt()) {
            ItemStack itemstack = FurnaceRecipes.smelting().getSmeltingResult(this.furnaceItemStacks[0]);

            if (this.furnaceItemStacks[2] == null) {
                this.furnaceItemStacks[2] = itemstack.copy();
            } else if (this.furnaceItemStacks[2].getItem() == itemstack.getItem()) {
                this.furnaceItemStacks[2].stackSize += itemstack.stackSize; // Forge BugFix: Results may have multiple items
            }

            --this.furnaceItemStacks[0].stackSize;

            if (this.furnaceItemStacks[0].stackSize <= 0) {
                this.furnaceItemStacks[0] = null;
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

                if (block == Blocks.wooden_slab) {
                    return (int) (150*speedModifier);
                }

                if (block.getMaterial() == Material.wood) {
                    return (int) (300*speedModifier);
                }

                if (block == Blocks.coal_block) {
                    return (int) (16000*speedModifier);
                }
            }

            if (item instanceof ItemTool && ((ItemTool)item).getToolMaterialName().equals("WOOD")) return (int) (200*speedModifier);
            if (item instanceof ItemSword && ((ItemSword)item).getToolMaterialName().equals("WOOD")) return (int) (200*speedModifier);
            if (item instanceof ItemHoe && ((ItemHoe)item).getToolMaterialName().equals("WOOD")) return (int) (200*speedModifier);
            if (item == Items.stick) return (int) (100*speedModifier);
            if (item == Items.coal) return (int) (1600*speedModifier);
            if (item == Items.lava_bucket) return (int) (20000*speedModifier);
            if (item == Item.getItemFromBlock(Blocks.sapling)) return (int) (100*speedModifier);
            if (item == Items.blaze_rod) return (int) (2400*speedModifier);
            return GameRegistry.getFuelValue(is);
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