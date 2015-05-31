package com.abstractlabs.toe.utility;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

import com.abstractlabs.toe.arena.Arena;
import com.abstractlabs.toe.arena.ArenaDesert;
import com.abstractlabs.toe.handler.ConfigurationHandler;
import com.abstractlabs.toe.reference.Reference;

public class Helper {
	public static void msg(EntityPlayer player, String msg, String color) {
		if (ConfigurationHandler.msg == true) {
			if (player.worldObj.isRemote) { //IF CLIENT	
				msgBypassClean(player, msg, color);
			}
		}
	}
	
	public static void msgBypass(EntityPlayer player, String msg, String color) {
		if (player.worldObj.isRemote) { //IF CLIENT	
			msgBypassClean(player, msg, color);
		}
	}
	
	public static void msgClean(EntityPlayer player, String msg, String color) {
		if (ConfigurationHandler.msg == true) {
			msgBypassClean(player, msg, color);
		}
	}
	
	public static void msgBypassClean(EntityPlayer player, String msg, String color) {
		player.addChatMessage(new ChatComponentText("\u00a78[\u00a73" + Reference.MOD_ACRONYM + " v" + Reference.VERSION + "\u00a78] \u00a7" + color + colorEveryWord(msg, color)));
	}
	
	public static String colorEveryWord(String msg, String color) {
	    StringBuilder builder = new StringBuilder(msg.length());

	    for (int i = 0; i < msg.length(); i++) {
	        char c = msg.charAt(i);
	        switch (c) {
	            case ' ': builder.append(" \u00a7" + color); break;
	            default: builder.append(c); break;
	        }
	    }
	    return builder.toString();
	}
	
	public static void sound(World world, String sound, int x, int y, int z) {
		world.playSoundEffect((double)((float)x + 0.5F), (double)((float)y + 0.5F), (double)((float)z + 0.5F), sound, 2.0F, 1.0F);
	}
	
	public static Entity createEntity(Entity entity, int x, int y, int z) {
		entity.setPosition(x, y, z);
		entity.setCurrentItemOrArmor(0, new ItemStack(Items.apple));
		entity.setCurrentItemOrArmor(4, new ItemStack(Items.chainmail_boots)); //i believe it lets the mob drop it, but doesnt show it on the mob
		return entity;
	}

	public static void addItemToChest(TileEntityChest chest, Block block, int amount, int meta) {
		addItemToChest(chest, Item.getItemFromBlock(block), amount, meta);
	}
	
	public static void addItemToChest(TileEntityChest chest, Item item, int amount, int meta) {
		for (int i=0; i<chest.getSizeInventory(); i++) {
			ItemStack is = new ItemStack(item, amount, meta);
			
			//LogHelper.info("is == " + is + " || " + "stackInSlot["+i+"] " + chest.getStackInSlot(i));
			
			if (chest.getStackInSlot(i) != null && chest.getStackInSlot(i).getItem() == is.getItem() && chest.getStackInSlot(i).getItemDamage() == is.getItemDamage() && chest.getStackInSlot(i).stackSize < 64) {
				chest.setInventorySlotContents(i, new ItemStack(item, amount + chest.getStackInSlot(i).stackSize, meta));
				//LogHelper.info("Added to existing stack. == " + is);
				break;
			} else if (chest.getStackInSlot(i) != null && chest.getStackInSlot(i).getItem() == is.getItem() && chest.getStackInSlot(i).getItemDamage() == is.getItemDamage() && chest.getStackInSlot(i).stackSize > 64) {
				chest.setInventorySlotContents(i+1, new ItemStack(item, amount, meta));
				//LogHelper.info("Created new stack because old stack full. == " + is);
				break;
			} else if (chest.getStackInSlot(i) == null) {
				chest.setInventorySlotContents(i, new ItemStack(item, amount, meta));
				//LogHelper.info("Created new stack because no similar stacks. == " + is);
				break;
			} else {
				//LogHelper.info("Chest full. == " + is);
			}
		}
	}
	
	public static void addRewardToChest(Arena arena, TileEntityChest chest) {
		if(arena instanceof ArenaDesert) {
			LogHelper.info("adding reward for desert arena..");

			addRandomAmount(chest, Items.diamond, 0, 10);
			addRandomAmount(chest, Items.emerald, 0, 10);
		}
	}

	public static void addRandomAmount(TileEntityChest chest, Item item, int min, int max) {
		addRandomAmount(chest, item, 0, min, max);
	}

	public static void addRandomAmount(TileEntityChest chest, Item item, int meta, int min, int max) {
		Random rand = new Random();
		int amount = rand.nextInt(max-min) + min;
		
		if(amount > 0) {
			addItemToChest(chest, item, amount, meta);
		}
	}
	
	
	
	
	public static void clearInventory(EntityPlayer player) {
        ItemStack itemstack;

        for (int i = 0; i < player.inventory.mainInventory.length; i++) {
            itemstack = player.inventory.mainInventory[i];

            if (itemstack != null) {
                player.inventory.mainInventory[i] = null;
            }
        }

        for (int i = 0; i < player.inventory.armorInventory.length; i++) {
            itemstack = player.inventory.armorInventory[i];

            if (itemstack != null) {
            	player.inventory.armorInventory[i] = null;
            }
        }
    }
}
