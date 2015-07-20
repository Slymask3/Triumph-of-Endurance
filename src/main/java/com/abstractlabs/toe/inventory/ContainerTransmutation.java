package com.abstractlabs.toe.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

import com.abstractlabs.toe.inventory.slot.SlotTransmutation;
import com.abstractlabs.toe.tileentity.TileEntityFurnaceRedstone;
import com.abstractlabs.toe.tileentity.TileEntityTransmutation;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ContainerTransmutation extends Container {
    private TileEntityTransmutation tile;
    private int lastTransmuteTime;
    private int lastBurnTime;
    private int lastItemBurnTime;
    
    public static final int INPUT = 0;
    public static final int FUEL = 1;
    public static final int OUTPUT = 2;

    public ContainerTransmutation(InventoryPlayer inventory, TileEntityTransmutation te) {
        this.tile = te;
        this.addSlotToContainer(new Slot(te, INPUT, 56, 17));
        this.addSlotToContainer(new Slot(te, FUEL, 56, 53));
        this.addSlotToContainer(new SlotTransmutation(inventory.player, te, OUTPUT, 116, 35));
        int i;

        for (i = 0; i < 3; ++i) {
            for (int j = 0; j < 9; ++j) {
                this.addSlotToContainer(new Slot(inventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for (i = 0; i < 9; ++i) {
            this.addSlotToContainer(new Slot(inventory, i, 8 + i * 18, 142));
        }
    }

    public void addCraftingToCrafters(ICrafting crafting) {
        super.addCraftingToCrafters(crafting);
        crafting.sendProgressBarUpdate(this, 0, this.tile.transmuteTime);
        crafting.sendProgressBarUpdate(this, 1, this.tile.burnTime);
        crafting.sendProgressBarUpdate(this, 2, this.tile.burnTimeCurrent);
    }

    /**
     * Looks for changes made in the container, sends them to every listener.
     */
    public void detectAndSendChanges() {
        super.detectAndSendChanges();

        for (int i = 0; i < this.crafters.size(); ++i) {
            ICrafting icrafting = (ICrafting)this.crafters.get(i);

            if (this.lastTransmuteTime != this.tile.transmuteTime) {
                icrafting.sendProgressBarUpdate(this, 0, this.tile.transmuteTime);
            }

            if (this.lastBurnTime != this.tile.burnTime) {
                icrafting.sendProgressBarUpdate(this, 1, this.tile.burnTime);
            }

            if (this.lastItemBurnTime != this.tile.burnTimeCurrent) {
                icrafting.sendProgressBarUpdate(this, 2, this.tile.burnTimeCurrent);
            }
        }

        this.lastTransmuteTime = this.tile.transmuteTime;
        this.lastBurnTime = this.tile.burnTime;
        this.lastItemBurnTime = this.tile.burnTimeCurrent;
    }

    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int id, int value) {
        if (id == 0) {
            this.tile.transmuteTime = value;
        }

        if (id == 1) {
            this.tile.burnTime = value;
        }

        if (id == 2) {
            this.tile.burnTimeCurrent = value;
        }
    }

    public boolean canInteractWith(EntityPlayer player) {
        return this.tile.isUseableByPlayer(player);
    }

    /**
     * Called when a player shift-clicks on a slot. You must override this or you will crash when someone does that.
     * Might clear out this method so people won't lose smelting xp. Or we could see if we could add xp through here.
     */
    public ItemStack transferStackInSlot(EntityPlayer player, int slotPos) {
        ItemStack itemstack = null;
        Slot slot = (Slot)this.inventorySlots.get(slotPos);
        
        if (slot != null && slot.getHasStack()) {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (slotPos == OUTPUT) {
                if (!this.mergeItemStack(itemstack1, 3, 39, true)) {
                    return null;
                }
                slot.onSlotChange(itemstack1, itemstack);
            } else if (slotPos != INPUT && slotPos != FUEL) { //if slot clicked isnt any of the furnace slots
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