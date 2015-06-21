package com.abstractlabs.toe.init;

import net.minecraftforge.common.DimensionManager;

import com.abstractlabs.toe.world.dimension.callisto.WorldProviderCallisto;
import com.abstractlabs.toe.world.dimension.hollows.WorldProviderHollows;

public class ToeDimensions {
	public static int hollows = 8;
	public static int callisto = 9;
	
	public static void init() {
		DimensionManager.registerProviderType(hollows, WorldProviderHollows.class, false);
		DimensionManager.registerProviderType(callisto, WorldProviderCallisto.class, false);
		
		DimensionManager.registerDimension(hollows, hollows);
		DimensionManager.registerDimension(callisto, callisto);
	}
}