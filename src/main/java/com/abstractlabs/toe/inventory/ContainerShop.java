package com.abstractlabs.toe.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

import com.abstractlabs.toe.entity.npc.EntityShop;
import com.abstractlabs.toe.inventory.slot.SlotShop;
import com.abstractlabs.toe.tileentity.TileEntityFurnaceRedstone;

public class ContainerShop extends Container {
    public static final int ITEM1 = 0;
    public static final int COST1 = 1;
    public static final int ITEM2 = 2;
    public static final int COST2 = 3;
    public static final int ITEM3 = 4;
    public static final int COST3 = 5;
    public static final int ITEM4 = 6;
    public static final int COST4 = 7;
    public static final int ITEM5 = 8;
    public static final int COST5 = 9;
    public static final int ITEM6 = 10;
    public static final int COST6 = 11;
    
    private EntityShop entity;
    
    public ContainerShop(InventoryPlayer inventory, EntityShop entity) {
        if(entity.getSizeInventory() > 0) {
        	this.addSlotToContainer(new SlotShop(entity, COST1, 26, 16));
            this.addSlotToContainer(new SlotShop(entity, ITEM1, 44, 16));
        }
        if(entity.getSizeInventory() > 2) {
        	this.addSlotToContainer(new SlotShop(entity, COST2, 26, 34));
            this.addSlotToContainer(new SlotShop(entity, ITEM2, 44, 34));
        }
        if(entity.getSizeInventory() > 4) {
        	this.addSlotToContainer(new SlotShop(entity, COST3, 26, 52));
            this.addSlotToContainer(new SlotShop(entity, ITEM3, 44, 52));
        }
        if(entity.getSizeInventory() > 6) {
        	this.addSlotToContainer(new SlotShop(entity, ITEM4, 116, 16));
            this.addSlotToContainer(new SlotShop(entity, COST4, 134, 16));
        }
        if(entity.getSizeInventory() > 8) {
        	this.addSlotToContainer(new SlotShop(entity, ITEM5, 116, 34));
            this.addSlotToContainer(new SlotShop(entity, COST5, 134, 34));
        }
        if(entity.getSizeInventory() > 10) {
        	this.addSlotToContainer(new SlotShop(entity, ITEM6, 116, 52));
            this.addSlotToContainer(new SlotShop(entity, COST6, 134, 52));
        }
        
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
    
    public void changePage(int page) {
    	this.entity.setCurrentPage(page);
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
            } else */if (slotPos != 0 && slotPos != 1) { //if slot clicked isnt any of the furnace slots
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
}