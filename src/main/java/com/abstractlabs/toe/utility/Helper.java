package com.abstractlabs.toe.utility;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

import javax.imageio.ImageIO;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import com.abstractlabs.toe.handler.ConfigHandler;
import com.abstractlabs.toe.reference.Reference;
import com.abstractlabs.toe.world.arena.Arena;
import com.abstractlabs.toe.world.arena.ArenaDesert;

public class Helper {
	public static void msg(EntityPlayer player, String msg, String color) {
		if (ConfigHandler.msg == true) {
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
		if (ConfigHandler.msg == true) {
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
	

	public static void drawStringWithBorder(Minecraft mc, int x, int y, Object o, int textColor, int borderColor) {
		mc.fontRenderer.drawString(o+"", x, y+1, borderColor);
		mc.fontRenderer.drawString(o+"", x, y-1, borderColor);
		mc.fontRenderer.drawString(o+"", x+1, y, borderColor);
		mc.fontRenderer.drawString(o+"", x-1, y, borderColor);
		mc.fontRenderer.drawString(o+"", x, y, textColor);
	}
	
	public static void drawCenteredStringWithBorder(Minecraft mc, int x, int y, Object o, int textColor, int borderColor) {
		drawStringWithBorder(mc, x-mc.fontRenderer.getStringWidth(o+"")/2, y, o, textColor, borderColor);
	}
	
	public static void drawStringWithBorderAndShadow(Minecraft mc, int x, int y, Object o, int textColor, int borderColor) {
		mc.fontRenderer.drawStringWithShadow(o+"", x, y+1, borderColor);
		mc.fontRenderer.drawStringWithShadow(o+"", x, y-1, borderColor);
		mc.fontRenderer.drawStringWithShadow(o+"", x+1, y, borderColor);
		mc.fontRenderer.drawStringWithShadow(o+"", x-1, y, borderColor);
		mc.fontRenderer.drawStringWithShadow(o+"", x, y, textColor);
	}
	
	public static void drawCenteredStringWithBorderWithShadow(Minecraft mc, int x, int y, Object o, int textColor, int borderColor) {
		drawStringWithBorderAndShadow(mc, x-mc.fontRenderer.getStringWidth(o+"")/2, y, o, textColor, borderColor);
	}

	public static ResourceLocation getResourceLocation(String username) {
		try {
			URL url = new URL("http://skins.minecraft.net/MinecraftSkins/"+username+".png");
			BufferedImage imageColored = ImageIO.read(url);
			BufferedImage image = new BufferedImage(64, 32, BufferedImage.TYPE_BYTE_GRAY);
			Graphics g = image.getGraphics();
			g.drawImage(imageColored, 0, 0, null);
			g.dispose();

//			createFolder("mods");
//			createFolder("mods\\ToE.jar");
//			createFolder("mods\\ToE.jar\\assets");
//			createFolder("mods\\ToE.jar\\assets\\textures");
//			createFolder("mods\\ToE.jar\\assets\\textures\\statues");

			createFolder("resourcepacks");
			createFolder("resourcepacks\\toe_statues");
			createFolder("resourcepacks\\toe_statues\\assets");
			createFolder("resourcepacks\\toe_statues\\assets\\toe_statues");
			
			//File file = new File(System.getProperty("user.dir")+"\\assets\\toe\\textures\\statues\\"+username+".png");
			File file = new File(System.getProperty("user.dir")+"\\resourcepacks\\toe_statues\\assets\\toe_statues\\"+username+".png");
			
//			FileOutputStream fos = new FileOutputStream("mods\\ToE.jar");
//			ZipOutputStream zos = new ZipOutputStream(fos);
			
			//AbstractClientPlayer.getDownloadImageSkin(new ResourceLocation(Reference.MOD_ID + ":" + "textures/statues"), username);
			
			ImageIO.write(image, "png", file);
			
			//((SimpleReloadableResourceManager)Minecraft.getMinecraft().getResourceManager()).reloadResourcePack(new ResourceLoc());
			
			return new ResourceLocation("toe" + ":" + username+".png");
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
    public static ResourceLocation getResourceLocationFromName(String name){
    	ResourceLocation resourcelocation = AbstractClientPlayer.locationStevePng;
    	resourcelocation = AbstractClientPlayer.getLocationSkin(name);
    	AbstractClientPlayer.getDownloadImageSkin(resourcelocation, name);
    	return resourcelocation;
    }
	
	private static void createFolder(String folder) {
		File theDir = new File(folder);

		if (!theDir.exists()) {
		    LogHelper.info("Creating /"+folder+"/ directory.");
		    boolean result = false;

		    try{
		    	theDir.mkdir();
		        result = true;
		    } catch(SecurityException se){}  
		    
		    if(result) { 
		    	LogHelper.info("/"+folder+"/ directory created.");
		    }
		}
	}

	
	
//	public static void addItemToInventory(EntityPlayer player, Item item, int amount, int meta) {
//		for (int i=0; i<player.inventory.mainInventory.length; i++) {
//			ItemStack is = new ItemStack(item, amount, meta);
//			
//			if (player.inventory.mainInventory[i] != null && player.inventory.mainInventory[i].getItem() == is.getItem() && player.inventory.mainInventory[i].getItemDamage() == is.getItemDamage() && player.inventory.mainInventory[i].stackSize < 64) {
//				player.inventory.mainInventory[i] = new ItemStack(item, amount + player.inventory.mainInventory[i].stackSize, meta);
//				break;
//			} else if (player.inventory.mainInventory[i] != null && player.inventory.mainInventory[i].getItem() == is.getItem() && player.inventory.mainInventory[i].getItemDamage() == is.getItemDamage() && player.inventory.mainInventory[i].stackSize > 64) {
//				chest.setInventorySlotContents(i+1, new ItemStack(item, amount, meta));
//				break;
//			} else if (player.inventory.mainInventory[i] == null) {
//				chest.setInventorySlotContents(i, new ItemStack(item, amount, meta));
//				break;
//			} else {
//			}
//		}
//	}
	
	public static void addItemToInventory(EntityPlayer player, Item item) {
		for (int i=0; i<player.inventory.mainInventory.length; i++) {
			if (player.inventory.mainInventory[i] != null && player.inventory.mainInventory[i].getItem() == item && player.inventory.mainInventory[i].stackSize < 64) {
				player.inventory.mainInventory[i] = new ItemStack(item, player.inventory.mainInventory[i].stackSize + 1, 0);
				break;
			} else if (player.inventory.mainInventory[i] == null) {
				player.inventory.mainInventory[i] = new ItemStack(item, 1, 0);
				break;
			}
		}
	}
	
	public static void removeItemFromInventory(EntityPlayer player, Item item) {
		for (int i=0; i<player.inventory.mainInventory.length; i++) {
			if (player.inventory.mainInventory[i] != null && player.inventory.mainInventory[i].getItem() == item && player.inventory.mainInventory[i].stackSize > 1) {
				player.inventory.mainInventory[i] = new ItemStack(item, player.inventory.mainInventory[i].stackSize - 1, 0);
				break;
			} else if (player.inventory.mainInventory[i] != null && player.inventory.mainInventory[i].getItem() == item && player.inventory.mainInventory[i].stackSize == 1) {
				player.inventory.mainInventory[i] = null;
				break;
			}
		}
	}
	
	
	public static int getItemAmountInInventory(EntityPlayer player, Item item) {
		ItemStack is;
		int amount = 0;
		
		for (int i = 0; i < player.inventory.mainInventory.length; i++) {
            is = player.inventory.mainInventory[i];

            if (is != null && is.getItem() == item) {
                amount += is.stackSize;
            }
        }
		
		return amount;
	}

	public static void removeItemsFromInventory(EntityPlayer player, Item item) {
		ItemStack is;
		
		for (int i = 0; i < player.inventory.mainInventory.length; i++) {
            is = player.inventory.mainInventory[i];

            if (is != null && is.getItem() == item) {
            	player.inventory.mainInventory[i] = null;
            }
        }
	}
	
//	public static void removeItemsFromInventory(EntityPlayer player, Item item, int amount) {
//		ItemStack is;
//		int amnt = 0;
//		
//		while(amnt < amount) {
//			for (int i = 0; i < player.inventory.mainInventory.length; i++) {
//		        is = player.inventory.mainInventory[i];
//		
//		        if (is != null && is.getItem() == item) {
//		        	player.inventory.mainInventory[i].stackSize--;
//		        	amnt++;
//		        	
//		        	if(amnt == amount) {
//		        		break;
//		        	}
//		        }
//		    }
//		}
//	}

//	public static boolean doesPlayerHaveEnoughSpace(EntityPlayer player, int amount) {
//		int slots = (int) Math.ceil(amount/64);
//		ItemStack is;
//		
//		LogHelper.info(slots);
//		
//		for (int i = 0; i < player.inventory.mainInventory.length; i++) {
//	        is = player.inventory.mainInventory[i];
//	
//	        if (is == null) {
//	        	slots--;
//	        	
//	        	if(slots == -1) {
//	        		return true;
//	        	}
//	        }
//	    }
//		
//		return false;
//	}
	
	public static boolean doesPlayerHaveEnoughSpace(EntityPlayer player, int amount) {
		ItemStack is;
		int slots = 0;
		
		for (int i = 0; i < player.inventory.mainInventory.length; i++) {
	        is = player.inventory.mainInventory[i];
	
	        if (is == null) {
	        	slots++;
	        }
	    }
		
		return amount <= (slots*64);
	}

	public static void addItemsToInventory(EntityPlayer player, Item item, int amount) {
		for(int i=0; i<amount; i++) {
			addItemToInventory(player, item);
		}
	}

	public static void removeItemsFromInventory(EntityPlayer player, Item item, int amount) {
		for(int i=0; i<amount; i++) {
			removeItemFromInventory(player, item);
		}
	}
	
	public static boolean isNight(World world) {
		long time = world.getWorldTime();
		long day = (time/24000L)+1; //unused atm
		long current = time%24000L;

		if(current >= 12500 && current <= 23750) {
			return true;
		}
		
		return false;
	}
	
	public static boolean isDay(World world) {
		return !isNight(world);
	}
	
	public static void addItemStacktoInventory(EntityPlayer player, ItemStack is) {
		for (int i=0; i<player.inventory.mainInventory.length; i++) {
			if (player.inventory.mainInventory[i] != null && player.inventory.mainInventory[i].getItem() == is.getItem() && player.inventory.mainInventory[i].stackSize < is.getItem().getItemStackLimit() /*deprecated, might cause problems later*/) {
				player.inventory.mainInventory[i] = new ItemStack(is.getItem(), player.inventory.mainInventory[i].stackSize + 1, 0);
				break;
			} else if (player.inventory.mainInventory[i] == null) {
				player.inventory.mainInventory[i] = is;
				break;
			}
		}
	}
	
	public static void addItemStackstoInventory(EntityPlayer player, ItemStack is) {
		int times = is.stackSize;
		is.stackSize = 1;
		
		for (int i=0; i<times; i++) {
			addItemStacktoInventory(player, is);
		}
	}

	public static boolean doesPlayerHaveItem(EntityPlayer player, Item item) {
		for (int i=0; i<player.inventory.mainInventory.length; i++) {
			if (player.inventory.mainInventory[i] != null && player.inventory.mainInventory[i].getItem() == item) {
				return true;
			}
		}
		return false;
	}

	//dirty code
//	public static ItemStack getPlayerFirstItem(EntityPlayer player, Item item) {
//		for (int i=0; i<player.inventory.mainInventory.length; i++) {
//			if (player.inventory.mainInventory[i] != null && player.inventory.mainInventory[i].getItem() == item) {
//				return player.inventory.mainInventory[i].copy();
//			}
//		}
//		return null;
//	}

	//dirty
//	public static boolean doesPlayerHaveItemStacks(EntityPlayer player, ItemStack is) {
//		if(is == null) {
//			return false;
//		}
//		
//		Item item = is.getItem();
//		int amount = is.stackSize;
//		
//		if(doesPlayerHaveItem(player, item)) {
//			ItemStack is2 = getPlayerFirstItem(player, item);
//		} else {
//			
//		}
//	}
	
	//coded for entity shop
	public static boolean doesPlayerHaveEnoughItemAmount(EntityPlayer player, ItemStack is) {
		if(is == null) {
			return false;
		}
		return doesPlayerHaveEnoughItemAmount(player, is.getItem(), is.stackSize);
	}

	//coded for entity shop
	public static boolean doesPlayerHaveEnoughItemAmount(EntityPlayer player, Item item, int amount) {
		int newAmount = 0;
		
		for (int i=0; i<player.inventory.mainInventory.length; i++) {
			if (player.inventory.mainInventory[i] != null && player.inventory.mainInventory[i].getItem() == item) {
				newAmount = newAmount + player.inventory.mainInventory[i].stackSize;
			}
		}
		
		return newAmount >= amount;
	}

	//coded for entity shop
	public static boolean doesPlayerHaveEnoughSpaceForItemStacks(EntityPlayer player, ItemStack is) {
		if(is == null) {
			return false;
		}
		
		if(doesPlayerHaveEnoughSpace(player, 1)) {
			return true;
		} else if(doesPlayerHaveItem(player, is.getItem())) {
			int lowest = getLowestAmountOfItem(player, is.getItem());
			if(lowest + is.stackSize <= is.getItem().getItemStackLimit()) {
				return true;
			}
		}
		return false;
	}

	//coded for entity shop
	public static int getLowestAmountOfItem(EntityPlayer player, Item item) {
		int lowestStackSize = 552;
		
		for (int i=0; i<player.inventory.mainInventory.length; i++) {
			if (player.inventory.mainInventory[i] != null && player.inventory.mainInventory[i].getItem() == item) {
				if(player.inventory.mainInventory[i].stackSize < lowestStackSize) {
					lowestStackSize = player.inventory.mainInventory[i].stackSize;
				}
			}
		}
		
		return lowestStackSize;
	}
}