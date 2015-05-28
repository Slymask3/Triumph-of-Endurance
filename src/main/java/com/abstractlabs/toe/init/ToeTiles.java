package com.abstractlabs.toe.init;

import net.minecraft.tileentity.TileEntity;

import com.abstractlabs.toe.tileentity.TileEntityBlockArmoury;
import com.abstractlabs.toe.tileentity.TileEntityUtility;
import com.abstractlabs.toe.tileentity.TileEntityWeaponry;

public class ToeTiles {
	public static void init() {
		TileEntity.addMapping(TileEntityWeaponry.class, "TileEntityWeaponry");
		TileEntity.addMapping(TileEntityUtility.class, "TileEntityUtility");
		TileEntity.addMapping(TileEntityBlockArmoury.class, "TileEntityBlockArmoury");
	}
}