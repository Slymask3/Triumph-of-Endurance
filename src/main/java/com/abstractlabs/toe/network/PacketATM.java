package com.abstractlabs.toe.network;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;

import com.abstractlabs.toe.client.gui.GuiATM;
import com.abstractlabs.toe.entity.player.ATM;
import com.abstractlabs.toe.init.ToeItems;
import com.abstractlabs.toe.reference.Color;
import com.abstractlabs.toe.utility.Helper;
import com.abstractlabs.toe.utility.LogHelper;

public class PacketATM extends AbstractPacket {
	int packet; //0 = Deposit, 1 = Withdraw, 2 = Client Update
	//int dim, x, y, z;
	int coin;
	int amount;
	int c, s, g;
	
	public PacketATM() {}

	public PacketATM(int packet, int coin, int amount) {
		this.packet = packet;
		this.coin = coin;
		this.amount = amount;
	}

	public PacketATM(int packet, int c, int s, int g) {
		this.packet = packet;
		this.c = c;
		this.s = s;
		this.g = g;
	}

	@Override
	public void encodeInto(ChannelHandlerContext ctx, ByteBuf buffer) {
		buffer.writeInt(packet);
		buffer.writeInt(coin);
		buffer.writeInt(amount);
		buffer.writeInt(c);
		buffer.writeInt(s);
		buffer.writeInt(g);
	}

	@Override
	public void decodeInto(ChannelHandlerContext ctx, ByteBuf buffer) {
		packet = buffer.readInt();
		coin = buffer.readInt();
		amount = buffer.readInt();
		c = buffer.readInt();
		s = buffer.readInt();
		g = buffer.readInt();
	}

	@Override
	public void handleClientSide(EntityPlayer player) {
		LogHelper.info("[Packet ATM] handleClientSide();");
		
		ATM atm = ATM.getProperties(player);
		
		if(packet == 2) { //update
			GuiATM.copper = c;
			GuiATM.silver = s;
			GuiATM.gold = g;
			
			LogHelper.info("PacketATM.handleClientSide() - recieved packet with c" + c + " s" + s + " g" + g);
//
//			atm.setCopperCoins(c);
//			atm.setSilverCoins(s);
//			atm.setGoldCoins(g);

//			GuiATMOverlay.copper = c;
//			GuiATMOverlay.silver = s;
//			GuiATMOverlay.gold = g;
		}
	}

	@Override
	public void handleServerSide(EntityPlayer player) {
		LogHelper.info("[Packet ATM] handleServerSide();");
		
		ATM atm = ATM.getProperties(player);
		
		if(packet == 0) { //deposit
			if(coin == -1 && amount == -1) { //depositAll
				int amountC = Helper.getItemAmountInInventory(player, ToeItems.coinCopper);
				int amountS = Helper.getItemAmountInInventory(player, ToeItems.coinSilver);
				int amountG = Helper.getItemAmountInInventory(player, ToeItems.coinGold);
				atm.addCopperCoins(amountC);
				atm.addSilverCoins(amountS);
				atm.addGoldCoins(amountG);
				Helper.removeItemsFromInventory(player, ToeItems.coinCopper);
				Helper.removeItemsFromInventory(player, ToeItems.coinSilver);
				Helper.removeItemsFromInventory(player, ToeItems.coinGold);
				Helper.msgClean(player, "Deposited " + amountC + " copper coins, " + amountS + " silver coins, and " + amountG + " gold coins.", Color.gold);
			} else if(coin == 1) {
				if(amount <= Helper.getItemAmountInInventory(player, ToeItems.coinCopper)) {
					//int amount = Helper.getItemAmountInInventory(player, ToeItems.coinCopper);
					atm.addCopperCoins(amount);
					Helper.removeItemsFromInventory(player, ToeItems.coinCopper, amount);
					Helper.msgClean(player, "Deposited " + amount + " copper coins.", Color.gold);
				} else {
					Helper.msgClean(player, "You do not have enough copper coins.", Color.red);
				}
			} else if(coin == 2) {
				if(amount <= Helper.getItemAmountInInventory(player, ToeItems.coinSilver)) {
					//int amount = Helper.getItemAmountInInventory(player, ToeItems.coinSilver);
					atm.addSilverCoins(amount);
					Helper.removeItemsFromInventory(player, ToeItems.coinSilver, amount);
					Helper.msgClean(player, "Deposited " + amount + " silver coins.", Color.gold);
				} else {
					Helper.msgClean(player, "You do not have enough silver coins.", Color.red);
				}
			} else if(coin == 3) {
				if(amount <= Helper.getItemAmountInInventory(player, ToeItems.coinGold)) {
					//int amount = Helper.getItemAmountInInventory(player, ToeItems.coinGold);
					atm.addGoldCoins(amount);
					Helper.removeItemsFromInventory(player, ToeItems.coinGold, amount);
					Helper.msgClean(player, "Deposited " + amount + " gold coins.", Color.gold);
				} else {
					Helper.msgClean(player, "You do not have enough gold coins.", Color.red);
				}
			}
		} else if(packet == 1) { //withdraw
			if(coin == -1 && amount == -1) { //withdrawAll
				if(Helper.doesPlayerHaveEnoughSpace(player, atm.getCopperCoins()+atm.getSilverCoins()+atm.getGoldCoins())) {
					Helper.addItemsToInventory(player, ToeItems.coinCopper, atm.getCopperCoins());
					Helper.addItemsToInventory(player, ToeItems.coinSilver, atm.getSilverCoins());
					Helper.addItemsToInventory(player, ToeItems.coinGold, atm.getGoldCoins());
					Helper.msgClean(player, "Withdrew " + atm.getCopperCoins() + " copper coins, " + atm.getSilverCoins() + " silver coins, and " + atm.getGoldCoins() + " gold coins.", Color.gold);
					atm.removeCopperCoins(atm.getCopperCoins());
					atm.removeSilverCoins(atm.getSilverCoins());
					atm.removeGoldCoins(atm.getGoldCoins());
				} else {
					Helper.msgClean(player, "You do not have enough space to hold the withdrawal amount.", Color.red);
				}
			} else if(coin == 1) {
				if(atm.getCopperCoins() >= amount) {
					if(Helper.doesPlayerHaveEnoughSpace(player, amount)) {
						atm.removeCopperCoins(amount);
						Helper.addItemsToInventory(player, ToeItems.coinCopper, amount);
						Helper.msgClean(player, "Withdrew " + amount + " copper coins.", Color.gold);
					} else {
						Helper.msgClean(player, "You do not have enough space to hold the withdrawal amount.", Color.red);
					}
				} else {
					Helper.msgClean(player, "You do not have enough copper coins in your account.", Color.red);
				}
			} else if(coin == 2) {
				if(atm.getSilverCoins() >= amount) {
					if(Helper.doesPlayerHaveEnoughSpace(player, amount)) {
						atm.removeSilverCoins(amount);
						Helper.addItemsToInventory(player, ToeItems.coinSilver, amount);
						Helper.msgClean(player, "Withdrew " + amount + " silver coins.", Color.gold);
					} else {
						Helper.msgClean(player, "You do not have enough space to hold the withdrawal amount.", Color.red);
					}
				} else {
					Helper.msgClean(player, "You do not have enough silver coins in your account.", Color.red);
				}
			} else if(coin == 3) {
				if(atm.getGoldCoins() >= amount) {
					if(Helper.doesPlayerHaveEnoughSpace(player, amount)) {
						atm.removeGoldCoins(amount);
						Helper.addItemsToInventory(player, ToeItems.coinGold, amount);
						Helper.msgClean(player, "Withdrew " + amount + " gold coins.", Color.gold);
					} else {
						Helper.msgClean(player, "You do not have enough space to hold the withdrawal amount.", Color.red);
					}
				} else {
					Helper.msgClean(player, "You do not have enough gold coins in your account.", Color.red);
				}
			}
		} else {
			LogHelper.error("[Packet ATM] Unknown Packet = " + packet);
		}
		
		NBTTagCompound atmTag = player.getEntityData().getCompoundTag("ATM");
		
		LogHelper.info("[PacketATM] handleServerSide() - Copper == " + atmTag.getInteger("CopperCoins") + " (atmTag)");
		LogHelper.info("[PacketATM] handleServerSide() - Silver == " + atmTag.getInteger("SilverCoins") + " (atmTag)");
		LogHelper.info("[PacketATM] handleServerSide() - Gold == " + atmTag.getInteger("GoldCoins") + " (atmTag)");
	}
}
