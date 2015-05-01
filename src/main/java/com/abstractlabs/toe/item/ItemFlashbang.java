package com.abstractlabs.toe.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.abstractlabs.toe.entity.projectile.EntityFlashbang;

public class ItemFlashbang extends ItemToe {
	public ItemStack onItemRightClick(ItemStack is, World world, EntityPlayer player) {
        if(!player.capabilities.isCreativeMode) {
            --is.stackSize;
        }

        world.playSoundAtEntity(player, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

        if(!world.isRemote) {
            world.spawnEntityInWorld(new EntityFlashbang(world, player));
        }

        return is;
    }
}