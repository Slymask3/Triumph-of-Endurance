package com.abstractlabs.toe.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

import com.abstractlabs.toe.init.ToePotions;

public class ItemBucketGoo extends ItemToe {
    public ItemBucketGoo() {
    	super();
        this.setMaxStackSize(1);
    }

    public ItemStack onEaten(ItemStack is, World world, EntityPlayer player) {
        if (!player.capabilities.isCreativeMode) {
            --is.stackSize;
        }

        player.addPotionEffect(new PotionEffect(ToePotions.moon.id, 600*20)); //10min

        return is.stackSize <= 0 ? new ItemStack(Items.bucket) : is;
    }

    public int getMaxItemUseDuration(ItemStack is) {
        return 32;
    }

    public EnumAction getItemUseAction(ItemStack is) {
        return EnumAction.drink;
    }

    public ItemStack onItemRightClick(ItemStack is, World world, EntityPlayer player) {
        player.setItemInUse(is, this.getMaxItemUseDuration(is));
        return is;
    }
}