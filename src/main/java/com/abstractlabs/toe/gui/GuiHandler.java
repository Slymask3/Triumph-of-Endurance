package com.abstractlabs.toe.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.abstractlabs.toe.reference.GuiID;
import com.abstractlabs.toe.tileentity.TileEntityATM;
import com.abstractlabs.toe.tileentity.TileEntityBlockArmoury;
import com.abstractlabs.toe.tileentity.TileEntityRecall;
import com.abstractlabs.toe.tileentity.TileEntityUtility;
import com.abstractlabs.toe.tileentity.TileEntityWeaponry;
import com.abstractlabs.toe.utility.LogHelper;

import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {
	@Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
    	final TileEntity e = world.getTileEntity(x, y, z);
    	if (e == null) {
    		return null;
    	}
    	
    	//serverside guis (like containers)

        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
    	final TileEntity e = world.getTileEntity(x, y, z);
    	if (e == null) {
    		return null;
    	}
    	
    	if (ID == GuiID.ARMOURY.ordinal()) {
        	return new GuiArmoury(player, (TileEntityBlockArmoury) e, world, x, y, z);
        } else if (ID == GuiID.WEAPONRY.ordinal()) {
        	return new GuiWeaponry(player, (TileEntityWeaponry) e, world, x, y, z);
        } else if (ID == GuiID.UTILITY.ordinal()) {
        	return new GuiUtility(player, (TileEntityUtility) e, world, x, y, z);
        } else if (ID == GuiID.RECALL.ordinal()) {
        	return new GuiRecall(player, (TileEntityRecall) e, world, x, y, z);
        } else if (ID == GuiID.ATM.ordinal()) {
        	LogHelper.info("GuiHandler - isRemote == " + world.isRemote);
//    		GuiATMOverlay.usingATM = true;
        	return new GuiATM(player, (TileEntityATM) e, world, x, y, z);
        }

        return null;
    }
}