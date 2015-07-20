package com.abstractlabs.toe.client.gui;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.abstractlabs.toe.client.gui.container.GuiDisplayCase;
import com.abstractlabs.toe.client.gui.container.GuiDyer;
import com.abstractlabs.toe.client.gui.container.GuiFurnaceDiamond;
import com.abstractlabs.toe.client.gui.container.GuiFurnaceEmerald;
import com.abstractlabs.toe.client.gui.container.GuiFurnaceGold;
import com.abstractlabs.toe.client.gui.container.GuiFurnaceIron;
import com.abstractlabs.toe.client.gui.container.GuiFurnaceRedstone;
import com.abstractlabs.toe.client.gui.container.GuiShop;
import com.abstractlabs.toe.client.gui.container.GuiTransmutation;
import com.abstractlabs.toe.client.gui.screen.GuiATM;
import com.abstractlabs.toe.client.gui.screen.GuiArmoury;
import com.abstractlabs.toe.client.gui.screen.GuiRecall;
import com.abstractlabs.toe.client.gui.screen.GuiStatue;
import com.abstractlabs.toe.client.gui.screen.GuiUtility;
import com.abstractlabs.toe.client.gui.screen.GuiWeaponry;
import com.abstractlabs.toe.entity.npc.EntityDyer;
import com.abstractlabs.toe.entity.npc.EntityShop;
import com.abstractlabs.toe.inventory.ContainerDisplayCase;
import com.abstractlabs.toe.inventory.ContainerDyer;
import com.abstractlabs.toe.inventory.ContainerFurnaceDiamond;
import com.abstractlabs.toe.inventory.ContainerFurnaceEmerald;
import com.abstractlabs.toe.inventory.ContainerFurnaceGold;
import com.abstractlabs.toe.inventory.ContainerFurnaceIron;
import com.abstractlabs.toe.inventory.ContainerFurnaceRedstone;
import com.abstractlabs.toe.inventory.ContainerShop;
import com.abstractlabs.toe.inventory.ContainerTransmutation;
import com.abstractlabs.toe.reference.GuiID;
import com.abstractlabs.toe.tileentity.TileEntityATM;
import com.abstractlabs.toe.tileentity.TileEntityBlockArmoury;
import com.abstractlabs.toe.tileentity.TileEntityDisplayCase;
import com.abstractlabs.toe.tileentity.TileEntityFurnaceDiamond;
import com.abstractlabs.toe.tileentity.TileEntityFurnaceEmerald;
import com.abstractlabs.toe.tileentity.TileEntityFurnaceGold;
import com.abstractlabs.toe.tileentity.TileEntityFurnaceIron;
import com.abstractlabs.toe.tileentity.TileEntityFurnaceRedstone;
import com.abstractlabs.toe.tileentity.TileEntityRecall;
import com.abstractlabs.toe.tileentity.TileEntityStatueBiped;
import com.abstractlabs.toe.tileentity.TileEntityTransmutation;
import com.abstractlabs.toe.tileentity.TileEntityUtility;
import com.abstractlabs.toe.tileentity.TileEntityWeaponry;

import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {
	@Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
    	final TileEntity e = world.getTileEntity(x, y, z);
//    	if (e == null) {
//    		return null;
//    	}
    	
    	//serverside guis (like containers)

    	if (ID == GuiID.FURNACE_IRON.ordinal()) {
        	return new ContainerFurnaceIron(player.inventory, (TileEntityFurnaceIron) e);
        } else if (ID == GuiID.FURNACE_GOLD.ordinal()) {
        	return new ContainerFurnaceGold(player.inventory, (TileEntityFurnaceGold) e);
        } else if (ID == GuiID.FURNACE_DIAMOND.ordinal()) {
        	return new ContainerFurnaceDiamond(player.inventory, (TileEntityFurnaceDiamond) e);
        } else if (ID == GuiID.FURNACE_EMERALD.ordinal()) {
        	return new ContainerFurnaceEmerald(player.inventory, (TileEntityFurnaceEmerald) e);
        } else if (ID == GuiID.FURNACE_REDSTONE.ordinal()) {
        	return new ContainerFurnaceRedstone(player.inventory, (TileEntityFurnaceRedstone) e);
        } else if (ID == GuiID.DISPLAY_CASE.ordinal()) {
        	return new ContainerDisplayCase(player.inventory, (TileEntityDisplayCase) e);
        } else if (ID == GuiID.TRANSMUTATION.ordinal()) {
        	return new ContainerTransmutation(player.inventory, (TileEntityTransmutation) e);
        } else if (ID == GuiID.DYER.ordinal()) {
        	return new ContainerDyer(player.inventory, (EntityDyer) world.getEntityByID(x));
        } else if (ID == GuiID.SHOP.ordinal()) {
        	return new ContainerShop(player.inventory, (EntityShop) world.getEntityByID(x));
        }
    	
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
    	final TileEntity e = world.getTileEntity(x, y, z);
//    	if (e == null) {
//    		return null;
//    	}
    	
    	if (ID == GuiID.ARMOURY.ordinal()) {
        	return new GuiArmoury(player, (TileEntityBlockArmoury) e, world, x, y, z);
        } else if (ID == GuiID.WEAPONRY.ordinal()) {
        	return new GuiWeaponry(player, (TileEntityWeaponry) e, world, x, y, z);
        } else if (ID == GuiID.UTILITY.ordinal()) {
        	return new GuiUtility(player, (TileEntityUtility) e, world, x, y, z);
        } else if (ID == GuiID.RECALL.ordinal()) {
        	return new GuiRecall(player, (TileEntityRecall) e, world, x, y, z);
        } else if (ID == GuiID.ATM.ordinal()) {
        	return new GuiATM(player, (TileEntityATM) e, world, x, y, z);
        } else if (ID == GuiID.FURNACE_IRON.ordinal()) {
        	return new GuiFurnaceIron(player.inventory, (TileEntityFurnaceIron) e);
        } else if (ID == GuiID.FURNACE_GOLD.ordinal()) {
        	return new GuiFurnaceGold(player.inventory, (TileEntityFurnaceGold) e);
        } else if (ID == GuiID.FURNACE_DIAMOND.ordinal()) {
        	return new GuiFurnaceDiamond(player.inventory, (TileEntityFurnaceDiamond) e);
        } else if (ID == GuiID.FURNACE_EMERALD.ordinal()) {
        	return new GuiFurnaceEmerald(player.inventory, (TileEntityFurnaceEmerald) e);
        } else if (ID == GuiID.FURNACE_REDSTONE.ordinal()) {
        	return new GuiFurnaceRedstone(player.inventory, (TileEntityFurnaceRedstone) e);
        } else if (ID == GuiID.DISPLAY_CASE.ordinal()) {
        	return new GuiDisplayCase(player.inventory, (TileEntityDisplayCase) e);
        } else if (ID == GuiID.TRANSMUTATION.ordinal()) {
        	return new GuiTransmutation(player.inventory, (TileEntityTransmutation) e);
        } else if (ID == GuiID.STATUE.ordinal()) {
        	return new GuiStatue(player, (TileEntityStatueBiped) e, world, x, y, z);
        } else if (ID == GuiID.DYER.ordinal()) {
        	return new GuiDyer(player.inventory, (EntityDyer) world.getEntityByID(x));
        } else if (ID == GuiID.SHOP.ordinal()) {
        	return new GuiShop(player.inventory, (EntityShop) world.getEntityByID(x));
        }

        return null;
    }
    
    private Entity getEntityByID(int id, World world) {
//    	for (int i = 0; i < world.getE.size(); i++) {
//    		if (((Entity)world.field_72996_f.get(i)).func_145782_y() == entityID) {
//    			return (Entity)world.field_72996_f.get(i);
//    		}
//    	}
//    	return null;
    	return world.getEntityByID(id);
    }
}