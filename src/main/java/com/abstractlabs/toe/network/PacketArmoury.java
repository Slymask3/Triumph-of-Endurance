package com.abstractlabs.toe.network;

import com.abstractlabs.toe.utility.LogHelper;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.DimensionManager;
import cpw.mods.fml.common.network.ByteBufUtils;

public class PacketArmoury extends AbstractPacket 
{
	String _armour;
	
	public PacketArmoury() {}

	public PacketArmoury(/*World world, int x, int y, int z, String player, */String armour) 
	{
		//_dim = world.provider.dimensionId;
		//_x = x;
		//_y = y;
		//_z = z;
		//_player = player;
		_armour = armour;
	}

	@Override
	public void encodeInto(ChannelHandlerContext ctx, ByteBuf buffer) 
	{
		//buffer.writeInt(_dim);
		//buffer.writeInt(_x);
		//buffer.writeInt(_y);
		//buffer.writeInt(_z);
		//ByteBufUtils.writeUTF8String(buffer, _player);
		ByteBufUtils.writeUTF8String(buffer, _armour);
	}

	@Override
	public void decodeInto(ChannelHandlerContext ctx, ByteBuf buffer) 
	{
		//_dim = buffer.readInt();
		//_x = buffer.readInt();
		//_y = buffer.readInt();
		//_z = buffer.readInt();
		//_player = ByteBufUtils.readUTF8String(buffer);
		_armour = ByteBufUtils.readUTF8String(buffer);
	}

	@Override
	public void handleClientSide(EntityPlayer player) 
	{
		
	}

	@Override
	public void handleServerSide(EntityPlayer player) 
	{
		//World world = DimensionManager.getWorld(_dim);
		//BlockInstantSchematic block = (BlockInstantSchematic)world.getBlock(_x, _y, _z);
		//block.build(world, _x, _y, _z, world.getTileEntity(_x, _y, _z).getBlockMetadata(), _player, this._schematic, this._center, this._air);
		
		//EntityPlayer play = world.getPlayerEntityByName(_player);
		
		if(_armour.equalsIgnoreCase("leatherArmour")) 
		{
			player.inventory.addItemStackToInventory(new ItemStack(Items.wooden_sword));
		} 
		else if(_armour.equalsIgnoreCase("goldArmour")) 
		{
			player.inventory.addItemStackToInventory(new ItemStack(Items.stone_sword));
		} 
		else if(_armour.equalsIgnoreCase("chainArmour")) 
		{
			player.inventory.addItemStackToInventory(new ItemStack(Items.iron_sword));
		} 
		else if(_armour.equalsIgnoreCase("ironArmour")) 
		{
			player.inventory.addItemStackToInventory(new ItemStack(Items.golden_sword));
		} 
		else if(_armour.equalsIgnoreCase("diamondArmour")) 
		{
			player.inventory.addItemStackToInventory(new ItemStack(Items.diamond_sword));
		}
		
		LogHelper.info("PacketArmoury.handleServerSide();");
	}
}
