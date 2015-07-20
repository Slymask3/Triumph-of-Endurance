package com.abstractlabs.toe.network;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.DimensionManager;

import com.abstractlabs.toe.entity.npc.EntityDyer;
import com.abstractlabs.toe.utility.LogHelper;

public class PacketDyer extends AbstractPacket {
	int dim, id, r, g, b;
	
	public PacketDyer() {}

	public PacketDyer(World world, int id, int r, int g, int b) {
		this.dim = world.provider.dimensionId;
		this.id = id;
		this.r = r;
		this.g = g;
		this.b = b;
	}

	@Override
	public void encodeInto(ChannelHandlerContext ctx, ByteBuf buffer) {
		buffer.writeInt(dim);
		buffer.writeInt(id);
		buffer.writeInt(r);
		buffer.writeInt(g);
		buffer.writeInt(b);
	}

	@Override
	public void decodeInto(ChannelHandlerContext ctx, ByteBuf buffer) {
		dim = buffer.readInt();
		id = buffer.readInt();
		r = buffer.readInt();
		g = buffer.readInt();
		b = buffer.readInt();
	}

	@Override
	public void handleClientSide(EntityPlayer player) {
		
	}

	@Override
	public void handleServerSide(EntityPlayer player) {
		EntityDyer entity = (EntityDyer)DimensionManager.getWorld(dim).getEntityByID(id);
		
		ItemStack is = entity.getStackInSlot(0);
//		Color c = new Color(r, g, b);
//		LogHelper.info("color == " + c.getRGB());
		is = dye(is, (r << 16 | g << 8 | b));
		entity.setStackInSlot(0, is);

		ItemStack coin = entity.getStackInSlot(1);
		entity.setStackInSlot(1, decr(coin));
		
		LogHelper.info("[PacketDyer] handlerServerSide()");
	}
	
	private ItemStack dye(ItemStack is, int color) {
        NBTTagCompound nbttagcompound = is.getTagCompound();

        if (nbttagcompound == null) {
            nbttagcompound = new NBTTagCompound();
            is.setTagCompound(nbttagcompound);
        }

        NBTTagCompound nbttagcompound1 = nbttagcompound.getCompoundTag("display");

        if (!nbttagcompound.hasKey("display", 10)) {
            nbttagcompound.setTag("display", nbttagcompound1);
        }

        nbttagcompound1.setInteger("color", color);
        
        return is;
    }
	
	private ItemStack decr(ItemStack is) {
		if(is.stackSize <= 1) {
			return null;
		} else {
			is.stackSize--;
			return is;
		}
	}
}