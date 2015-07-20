package com.abstractlabs.toe.inventory.slot;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotTransmutation extends Slot {
    private EntityPlayer thePlayer;
    private int stacksize;

    public SlotTransmutation(EntityPlayer player, IInventory inventory, int slot, int x, int y) {
        super(inventory, slot, x, y);
        this.thePlayer = player;
    }

    public boolean isItemValid(ItemStack is) {
        return false;
    }

    public ItemStack decrStackSize(int amount) {
        if (this.getHasStack()) {
            this.stacksize += Math.min(amount, this.getStack().stackSize);
        }

        return super.decrStackSize(amount);
    }

    public void onPickupFromSlot(EntityPlayer player, ItemStack is) {
        this.onCrafting(is);
        super.onPickupFromSlot(player, is);
    }

    protected void onCrafting(ItemStack is, int amount) {
        this.stacksize += amount;
        this.onCrafting(is);
    }

    protected void onCrafting(ItemStack is) {
    	is.onCrafting(this.thePlayer.worldObj, this.thePlayer, this.stacksize);

//        if(!this.thePlayer.worldObj.isRemote) {
//            int i = this.stacksize;
//            float f = FurnaceRecipes.smelting().func_151398_b(is);
//            int j;
//
//            if (f == 0.0F) {
//                i = 0;
//            } else if (f < 1.0F) {
//                j = MathHelper.floor_float((float)i * f);
//
//                if (j < MathHelper.ceiling_float_int((float)i * f) && (float)Math.random() < (float)i * f - (float)j) {
//                    ++j;
//                }
//
//                i = j;
//            }
//
//            while (i > 0) {
//                j = EntityXPOrb.getXPSplit(i);
//                i -= j;
//                this.thePlayer.worldObj.spawnEntityInWorld(new EntityXPOrb(this.thePlayer.worldObj, this.thePlayer.posX, this.thePlayer.posY + 0.5D, this.thePlayer.posZ + 0.5D, j));
//            }
//        }

        this.stacksize = 0;
    }
}