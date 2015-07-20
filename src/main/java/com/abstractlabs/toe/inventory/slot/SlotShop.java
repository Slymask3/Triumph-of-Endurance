package com.abstractlabs.toe.inventory.slot;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotShop extends Slot {
    public SlotShop(IInventory inventory, int slot, int x, int y) {
        super(inventory, slot, x, y);
    }

    public boolean isItemValid(ItemStack is) {
        return false;
    }
    
    public boolean canTakeStack(EntityPlayer player) {
        return false;
    }
}