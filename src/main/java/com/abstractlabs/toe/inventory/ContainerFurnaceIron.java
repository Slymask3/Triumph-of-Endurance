package com.abstractlabs.toe.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;

import com.abstractlabs.toe.handler.skill.SmeltingHandler;
import com.abstractlabs.toe.tileentity.TileEntityFurnaceIron;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ContainerFurnaceIron extends Container {
    private TileEntityFurnaceIron tileFurnace;
    private int lastCookTime;
    private int lastBurnTime;
    private int lastItemBurnTime;

    public ContainerFurnaceIron(InventoryPlayer inventory, TileEntityFurnaceIron te) {
        this.tileFurnace = te;
        this.addSlotToContainer(new Slot(te, 0, 56, 17));
        this.addSlotToContainer(new Slot(te, 1, 56, 53));
        this.addSlotToContainer(new SlotFurnace(inventory.player, te, 2, 116, 35));
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
        crafting.sendProgressBarUpdate(this, 0, this.tileFurnace.furnaceCookTime);
        crafting.sendProgressBarUpdate(this, 1, this.tileFurnace.furnaceBurnTime);
        crafting.sendProgressBarUpdate(this, 2, this.tileFurnace.currentItemBurnTime);
    }

    /**
     * Looks for changes made in the container, sends them to every listener.
     */
    public void detectAndSendChanges() {
        super.detectAndSendChanges();

        for (int i = 0; i < this.crafters.size(); ++i) {
            ICrafting icrafting = (ICrafting)this.crafters.get(i);

            if (this.lastCookTime != this.tileFurnace.furnaceCookTime) {
                icrafting.sendProgressBarUpdate(this, 0, this.tileFurnace.furnaceCookTime);
            }

            if (this.lastBurnTime != this.tileFurnace.furnaceBurnTime) {
                icrafting.sendProgressBarUpdate(this, 1, this.tileFurnace.furnaceBurnTime);
            }

            if (this.lastItemBurnTime != this.tileFurnace.currentItemBurnTime) {
                icrafting.sendProgressBarUpdate(this, 2, this.tileFurnace.currentItemBurnTime);
            }
        }

        this.lastCookTime = this.tileFurnace.furnaceCookTime;
        this.lastBurnTime = this.tileFurnace.furnaceBurnTime;
        this.lastItemBurnTime = this.tileFurnace.currentItemBurnTime;
    }

    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int id, int value) {
        if (id == 0) {
            this.tileFurnace.furnaceCookTime = value;
        }

        if (id == 1) {
            this.tileFurnace.furnaceBurnTime = value;
        }

        if (id == 2) {
            this.tileFurnace.currentItemBurnTime = value;
        }
    }

    public boolean canInteractWith(EntityPlayer player) {
        return this.tileFurnace.isUseableByPlayer(player);
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

            if (slotPos == 2) {
                if (!this.mergeItemStack(itemstack1, 3, 39, true)) {
                    return null;
                }
            	SmeltingHandler.onSmeltShiftClick(tileFurnace, itemstack, player);
                slot.onSlotChange(itemstack1, itemstack);
            } else if (slotPos != 1 && slotPos != 0) {
                if (FurnaceRecipes.smelting().getSmeltingResult(itemstack1) != null) {
                    if (!this.mergeItemStack(itemstack1, 0, 1, false)) {
                        return null;
                    }
                } else if (TileEntityFurnaceIron.isItemFuel(itemstack1)) {
                    if (!this.mergeItemStack(itemstack1, 1, 2, false)) {
                        return null;
                    }
                } else if (slotPos >= 3 && slotPos < 30) {
                    if (!this.mergeItemStack(itemstack1, 30, 39, false)) {
                        return null;
                    }
                } else if (slotPos >= 30 && slotPos < 39 && !this.mergeItemStack(itemstack1, 3, 30, false)) {
                    return null;
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