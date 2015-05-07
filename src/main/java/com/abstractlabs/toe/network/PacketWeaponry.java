package com.abstractlabs.toe.network;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import com.abstractlabs.toe.player.Cash;
import com.abstractlabs.toe.utility.LogHelper;

import cpw.mods.fml.common.network.ByteBufUtils;

public class PacketWeaponry extends AbstractPacket {
	String _weapon;
	int _price;
	
	public PacketWeaponry() {}

	public PacketWeaponry(String weapon, int price) {
		_weapon = weapon;
		_price = price;
	}

	@Override
	public void encodeInto(ChannelHandlerContext ctx, ByteBuf buffer) {
		ByteBufUtils.writeUTF8String(buffer, _weapon);
		buffer.writeInt(_price);
		LogHelper.info("encoded..");
		LogHelper.info("encoded.. price: " + _price);
	}

	@Override
	public void decodeInto(ChannelHandlerContext ctx, ByteBuf buffer) {
		_weapon = ByteBufUtils.readUTF8String(buffer);
		_price = buffer.readInt();
		LogHelper.info("decoded.. price: " + _price);
	}

	@Override
	public void handleClientSide(EntityPlayer player) {
		
	}

	@Override
	public void handleServerSide(EntityPlayer player) {
		LogHelper.info("packet.price: " + _price);
		
		
		if(Cash.doesPlayerHaveEnough(player, _price)) {
			Cash.buyItem(player, _price);
			
			if(_weapon.equalsIgnoreCase("woodSword")) {
				player.inventory.addItemStackToInventory(new ItemStack(Items.wooden_sword));
			} else if(_weapon.equalsIgnoreCase("stoneSword")) {
				player.inventory.addItemStackToInventory(new ItemStack(Items.stone_sword));
			} else if(_weapon.equalsIgnoreCase("ironSword")) {
				player.inventory.addItemStackToInventory(new ItemStack(Items.iron_sword));
			} else if(_weapon.equalsIgnoreCase("goldSword")) {
				player.inventory.addItemStackToInventory(new ItemStack(Items.golden_sword));
			} else if(_weapon.equalsIgnoreCase("diamondSword")) {
				player.inventory.addItemStackToInventory(new ItemStack(Items.diamond_sword));
			}
		} else {
			LogHelper.info(player.getDisplayName() + " does not have enough cash.");
		}
		
		//LogHelper.info("PacketWeaponry.handleServerSide();");
	}
}
