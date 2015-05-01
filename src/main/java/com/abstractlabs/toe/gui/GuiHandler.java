package com.abstractlabs.toe.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.abstractlabs.toe.reference.GuiID;
import com.abstractlabs.toe.tileentity.TileEntityBlockArmoury;
import com.abstractlabs.toe.tileentity.TileEntityWeaponry;

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
        	return new BlockArmouryGui(player, (TileEntityBlockArmoury) e, world, x, y, z);
        } else if (ID == GuiID.WEAPONRY.ordinal()) {
        	return new GuiWeaponry(player, (TileEntityWeaponry) e, world, x, y, z);
        }

        return null;
    }
}