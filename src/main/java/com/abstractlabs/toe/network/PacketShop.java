package com.abstractlabs.toe.network;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.common.DimensionManager;

import com.abstractlabs.toe.entity.npc.EntityShop;
import com.abstractlabs.toe.utility.LogHelper;

public class PacketShop extends AbstractPacket {
	int packet, dim, id, item;
	
	public PacketShop() {}

	public PacketShop(int packet, World world, int id, int item) {
		this.packet = packet;
		this.dim = world.provider.dimensionId;
		this.id = id;
		this.item = item;
	}

	@Override
	public void encodeInto(ChannelHandlerContext ctx, ByteBuf buffer) {
		buffer.writeInt(packet);
		buffer.writeInt(dim);
		buffer.writeInt(id);
		buffer.writeInt(item);
	}

	@Override
	public void decodeInto(ChannelHandlerContext ctx, ByteBuf buffer) {
		packet = buffer.readInt();
		dim = buffer.readInt();
		id = buffer.readInt();
		item = buffer.readInt();
	}

	@Override
	public void handleClientSide(EntityPlayer player) {
		if(packet == 1) {
			EntityShop entity = (EntityShop)DimensionManager.getWorld(dim).getEntityByID(id);
			entity.setCurrentPage(item);
		}
	}

	@Override
	public void handleServerSide(EntityPlayer player) {
		
		if(packet == 0) {
			EntityShop entity = (EntityShop)DimensionManager.getWorld(dim).getEntityByID(id);
			entity.operateItem(item, player);
		} else if(packet == 1) {
			EntityShop entity = (EntityShop)DimensionManager.getWorld(dim).getEntityByID(id);
			entity.setCurrentPage(item);
		}
		
		LogHelper.info("[PacketShop] handlerServerSide()");
	}
}