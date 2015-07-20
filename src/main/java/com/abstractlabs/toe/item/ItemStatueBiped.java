package com.abstractlabs.toe.item;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import com.abstractlabs.toe.Toe;
import com.abstractlabs.toe.init.ToeBlocks;
import com.abstractlabs.toe.reference.GuiID;
import com.abstractlabs.toe.tileentity.TileEntityStatueBiped;

public class ItemStatueBiped extends ItemToe {
	public ItemStatueBiped() {
		super();
		this.setMaxStackSize(1);
	}
	
	public boolean onItemUse(ItemStack is, EntityPlayer player, World world, int x, int y, int z, int side, float par8, float par9, float par10) {
		if(side == 0) {
			return false;
		} else if (!world.isSideSolid(x, y, z, ForgeDirection.getOrientation(side))) {
            return false;
        } else {
            if (side == 1) {
                ++y;
            } else if (side == 2) {
                --z;
            } else if (side == 3) {
                ++z;
            } else if (side == 4) {
                --x;
            } else if (side == 5) {
                ++x;
            }
        }
		
		int meta = MathHelper.floor_double((double)(player.rotationYaw * 4.0F / 360.0F) + 2.5D) & 3;
		
		world.setBlock(x, y, z, ToeBlocks.statueBiped, meta, 2);
		
        if(world.getTileEntity(x, y, z) != null && world.getTileEntity(x, y, z) instanceof TileEntityStatueBiped) {
        	if(is.stackTagCompound == null) {
            	player.openGui(Toe.instance, GuiID.STATUE.ordinal(), world, x, y, z);
            } else {
            	((TileEntityStatueBiped) world.getTileEntity(x, y, z)).setUsername(is.stackTagCompound.getString("Username"));
            }
            --is.stackSize;
        }
        return true;
    }
	
	public void addInformation(ItemStack is, EntityPlayer player, List list, boolean par4) {
		if(is.stackTagCompound != null) {
			String user = is.stackTagCompound.getString("Username");
			list.add(EnumChatFormatting.AQUA + "Player: " + user);
		} else {
//			list.add(EnumChatFormatting.GRAY + "Place this statue to ??");
		}
	}
}