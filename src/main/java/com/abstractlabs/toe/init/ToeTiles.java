package com.abstractlabs.toe.init;

import net.minecraft.tileentity.TileEntity;

import com.abstractlabs.toe.arena.Arena;
import com.abstractlabs.toe.tileentity.TileEntityATM;
import com.abstractlabs.toe.tileentity.TileEntityBlockArmoury;
import com.abstractlabs.toe.tileentity.TileEntityLandmine;
import com.abstractlabs.toe.tileentity.TileEntityLockedChest;
import com.abstractlabs.toe.tileentity.TileEntityRecall;
import com.abstractlabs.toe.tileentity.TileEntityStatueBiped;
import com.abstractlabs.toe.tileentity.TileEntityUtility;
import com.abstractlabs.toe.tileentity.TileEntityWeaponry;

public class ToeTiles {
	public static void init() {
		TileEntity.addMapping(TileEntityWeaponry.class, "TileEntityWeaponry");
		TileEntity.addMapping(TileEntityUtility.class, "TileEntityUtility");
		TileEntity.addMapping(TileEntityBlockArmoury.class, "TileEntityBlockArmoury");
		TileEntity.addMapping(TileEntityRecall.class, "TileEntityRecall");
		TileEntity.addMapping(TileEntityLockedChest.class, "TileEntityLockedChest");
		TileEntity.addMapping(TileEntityLandmine.class, "TileEntityLandmine");
		TileEntity.addMapping(TileEntityStatueBiped.class, "TileEntityStatueBiped");
		TileEntity.addMapping(TileEntityATM.class, "TileEntityATM");
		TileEntity.addMapping(Arena.class, "TileEntityArena");
	}
}