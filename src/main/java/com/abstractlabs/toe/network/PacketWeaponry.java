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

public class PacketWeaponry extends AbstractPacket {
	//int _dim, _x, _y, _z;
	//String _player;
	String _weapon;
	
	public PacketWeaponry() {}

	public PacketWeaponry(/*World world, int x, int y, int z, String player, */String weapon) {
		//_dim = world.provider.dimensionId;
		//_x = x;
		//_y = y;
		//_z = z;
		//_player = player;
		_weapon = weapon;
	}

	@Override
	public void encodeInto(ChannelHandlerContext ctx, ByteBuf buffer) {
		//buffer.writeInt(_dim);
		//buffer.writeInt(_x);
		//buffer.writeInt(_y);
		//buffer.writeInt(_z);
		//ByteBufUtils.writeUTF8String(buffer, _player);
		ByteBufUtils.writeUTF8String(buffer, _weapon);
	}

	@Override
	public void decodeInto(ChannelHandlerContext ctx, ByteBuf buffer) {
		//_dim = buffer.readInt();
		//_x = buffer.readInt();
		//_y = buffer.readInt();
		//_z = buffer.readInt();
		//_player = ByteBufUtils.readUTF8String(buffer);
		_weapon = ByteBufUtils.readUTF8String(buffer);
	}

	@Override
	public void handleClientSide(EntityPlayer player) {
		
	}

	@Override
	public void handleServerSide(EntityPlayer player) {
		//World world = DimensionManager.getWorld(_dim);
		//BlockInstantSchematic block = (BlockInstantSchematic)world.getBlock(_x, _y, _z);
		//block.build(world, _x, _y, _z, world.getTileEntity(_x, _y, _z).getBlockMetadata(), _player, this._schematic, this._center, this._air);
		
		//EntityPlayer play = world.getPlayerEntityByName(_player);
		
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
		
		
		LogHelper.info("PacketWeaponry.handleServerSide();");
	}
}
