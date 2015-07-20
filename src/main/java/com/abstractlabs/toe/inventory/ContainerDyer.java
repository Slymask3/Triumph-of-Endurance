package com.abstractlabs.toe.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

import com.abstractlabs.toe.entity.npc.EntityDyer;
import com.abstractlabs.toe.tileentity.TileEntityFurnaceRedstone;

public class ContainerDyer extends Container {
    public static final int INPUT = 0;
    public static final int COIN = 1;
    //public static final int OUTPUT = 2;
    
    private EntityDyer entity;
    
    public ContainerDyer(InventoryPlayer inventory, EntityDyer entity) {
        this.addSlotToContainer(new Slot(entity, INPUT, 122, 17));
        this.addSlotToContainer(new Slot(entity, COIN, 122, 51));
        //this.addSlotToContainer(new SlotTransmutation(inventory.player, entity, OUTPUT, 116, 35));
        int i;

        for (i = 0; i < 3; ++i) {
            for (int j = 0; j < 9; ++j) {
                this.addSlotToContainer(new Slot(inventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for (i = 0; i < 9; ++i) {
            this.addSlotToContainer(new Slot(inventory, i, 8 + i * 18, 142));
        }
        
        this.entity = entity;
    }

    public void addCraftingToCrafters(ICrafting crafting) {
        super.addCraftingToCrafters(crafting);
    }

    public void detectAndSendChanges() {
        super.detectAndSendChanges();

        for (int i = 0; i < this.crafters.size(); ++i) {
            ICrafting icrafting = (ICrafting)this.crafters.get(i);
        }
    }

//    @SideOnly(Side.CLIENT)
//    public void updateProgressBar(int id, int value) {
//        if (id == 0) {
//            this.tile.transmuteTime = value;
//        }
//
//        if (id == 1) {
//            this.tile.burnTime = value;
//        }
//
//        if (id == 2) {
//            this.tile.burnTimeCurrent = value;
//        }
//    }

    public boolean canInteractWith(EntityPlayer player) {
        return true;
    }

    public ItemStack transferStackInSlot(EntityPlayer player, int slotPos) {
        ItemStack itemstack = null;
        Slot slot = (Slot)this.inventorySlots.get(slotPos);
        
        if (slot != null && slot.getHasStack()) {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            /*if (slotPos == OUTPUT) {
                if (!this.mergeItemStack(itemstack1, 3, 39, true)) {
                    return null;
                }
                slot.onSlotChange(itemstack1, itemstack);
            } else */if (slotPos != INPUT && slotPos != COIN) { //if slot clicked isnt any of the furnace slots
                if (TileEntityFurnaceRedstone.isItemFuel(itemstack1)) { //move to fuel slot if its fuel
                    if (!this.mergeItemStack(itemstack1, 1, 2, false)) {
                        return null;
                    }
                } /*else if (slotPos >= 3 && slotPos < 30) { //if slot is in inventory
                    if (!this.mergeItemStack(itemstack1, 30, 39, false)) {
                        return null;
                    }
                } else if (slotPos >= 30 && slotPos < 39 && !this.mergeItemStack(itemstack1, 3, 30, false)) { //if slot is in hotbar
                    return null;
                } */else {
                	if (!this.mergeItemStack(itemstack1, 0, 1, false)) {
                        return null;
                    }
                }
            } else if (!this.mergeItemStack(itemstack1, 3, 39, false)) {
                return null;
            }

            if (itemstack1.stackSize == 0) {
                slot.putStack((ItemStack)null);
            } else {
                slot.onSlotChanged();
            }

            if (itemstack1.stackSize == itemstack.stackSize) {
                return null;
            }

            slot.onPickupFromSlot(player, itemstack1);
        }

        return itemstack;
    }
    
    public void onContainerClosed(EntityPlayer player) {
        super.onContainerClosed(player);

        if (!player.worldObj.isRemote) {
            for (int i = 0; i < this.entity.getSizeInventory(); ++i) {
                ItemStack itemstack = this.entity.getStackInSlotOnClosing(i);

                if (itemstack != null) {
                	player.dropPlayerItemWithRandomChoice(itemstack, false);
                }
                
                this.entity.setInUse(false);
            }
        }
    }
}