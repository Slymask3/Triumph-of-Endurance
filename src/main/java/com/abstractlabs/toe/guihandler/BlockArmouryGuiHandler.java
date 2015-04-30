package com.abstractlabs.toe.guihandler;

import com.abstractlabs.toe.blockgui.BlockArmouryGui;
import com.abstractlabs.toe.tileentity.TileEntityBlockArmoury;

import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.client.gui.Gui;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockArmouryGuiHandler implements IGuiHandler 
{
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
    {
    	//TileEntity tileEntity = world.getTileEntity(x, y, z);
    	
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
    {
    	 TileEntity tileEntity = world.getTileEntity(x, y, z);
    	
    	if(tileEntity instanceof TileEntityBlockArmoury)
    	{
    		 return new BlockArmouryGui();
    	}
        return null;
    }
}