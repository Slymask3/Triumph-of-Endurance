package com.abstractlabs.toe.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

import com.abstractlabs.toe.tileentity.TileEntityDisplayCase;

public class ContainerDisplayCase extends Container {
    private TileEntityDisplayCase te;
    
    public static final int SLOT = 0;

    public ContainerDisplayCase(InventoryPlayer inventory, TileEntityDisplayCase te) {
        this.te = te;
        this.addSlotToContainer(new Slot(te, SLOT, 80, 20));
        
        byte b0 = 51;
        int i;

        for (i = 0; i < 3; ++i) {
            for (int j = 0; j < 9; ++j) {
                this.addSlotToContainer(new Slot(inventory, j + i * 9 + 9, 8 + j * 18, i * 18 + b0));
            }
        }

        for (i = 0; i < 9; ++i) {
            this.addSlotToContainer(new Slot(inventory, i, 8 + i * 18, 58 + b0));
        }
    }

//    public void addCraftingToCrafters(ICrafting crafting) {
//        super.addCraftingToCrafters(crafting);
////        crafting.sendProgressBarUpdate(this, 0, this.tileFurnace.furnaceCookTime);
////        crafting.sendProgressBarUpdate(this, 1, this.tileFurnace.furnaceBurnTime);
////        crafting.sendProgressBarUpdate(this, 2, this.tileFurnace.currentItemBurnTime);
//    }
//
//    /**
//     * Looks for changes made in the container, sends them to every listener.
//     */
//    public void detectAndSendChanges() {
//        super.detectAndSendChanges();
//
//        for (int i = 0; i < this.crafters.size(); ++i) {
//            ICrafting icrafting = (ICrafting)this.crafters.get(i);
//
//            if (this.lastCookTime != this.tileFurnace.furnaceCookTime) {
//                icrafting.sendProgressBarUpdate(this, 0, this.tileFurnace.furnaceCookTime);
//            }
//
//            if (this.lastBurnTime != this.tileFurnace.furnaceBurnTime) {
//                icrafting.sendProgressBarUpdate(this, 1, this.tileFurnace.furnaceBurnTime);
//            }
//
//            if (this.lastItemBurnTime != this.tileFurnace.currentItemBurnTime) {
//                icrafting.sendProgressBarUpdate(this, 2, this.tileFurnace.currentItemBurnTime);
//            }
//        }
//
//        this.lastCookTime = this.tileFurnace.furnaceCookTime;
//        this.lastBurnTime = this.tileFurnace.furnaceBurnTime;
//        this.lastItemBurnTime = this.tileFurnace.currentItemBurnTime;
//    }

//    @SideOnly(Side.CLIENT)
//    public void updateProgressBar(int id, int value) {
//        if (id == 0) {
//            this.tileFurnace.furnaceCookTime = value;
//        }
//
//        if (id == 1) {
//            this.tileFurnace.furnaceBurnTime = value;
//        }
//
//        if (id == 2) {
//            this.tileFurnace.currentItemBurnTime = value;
//        }
//    }

    public boolean canInteractWith(EntityPlayer player) {
        return this.te.isUseableByPlayer(player);
    }

    /**
     * Called when a player shift-clicks on a slot. You must override this or you will crash when someone does that.
     */
    public ItemStack transferStackInSlot(EntityPlayer player, int slotPos) {
        ItemStack itemstack = null;
        Slot slot = (Slot)this.inventorySlots.get(slotPos);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (slotPos == SLOT)
            {
                if (!this.mergeItemStack(itemstack1, this.te.getSizeInventory(), this.inventorySlots.size(), true))
                {
                    return null;
                }
            }
            else if (!this.mergeItemStack(itemstack1, 0, this.te.getSizeInventory(), false))
            {
                return null;
            }

            if (itemstack1.stackSize == 0)
            {
                slot.putStack((ItemStack)null);
            }
            else
            {
                slot.onSlotChanged();
            }
        }

        return itemstack;
    }
}