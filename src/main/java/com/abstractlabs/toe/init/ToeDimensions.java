package com.abstractlabs.toe.init;

import net.minecraftforge.common.DimensionManager;

import com.abstractlabs.toe.world.dimension.arenalism.WorldProviderFlat;
import com.abstractlabs.toe.world.dimension.hollows.WorldProviderHollows;

public class ToeDimensions {
	public static int hollows = 8;
	public static int flat = 9;
	
	public static void init() {
		DimensionManager.registerProviderType(hollows, WorldProviderHollows.class, false);
		DimensionManager.registerProviderType(flat, WorldProviderFlat.class, false);
		
		DimensionManager.registerDimension(hollows, hollows);
		DimensionManager.registerDimension(flat, flat);
	}
}
