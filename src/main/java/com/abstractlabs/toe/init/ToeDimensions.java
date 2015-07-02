package com.abstractlabs.toe.init;

import net.minecraftforge.common.DimensionManager;

import com.abstractlabs.toe.world.dimension.callisto.WorldProviderCallisto;
import com.abstractlabs.toe.world.dimension.hollows.WorldProviderHollows;
import com.abstractlabs.toe.world.dimension.neptune.WorldProviderNeptune;

public class ToeDimensions {
	public static int hollows = 8;
	public static int callisto = 9;
	public static int neptune = 10;
	
	public static void init() {
		DimensionManager.registerProviderType(hollows, WorldProviderHollows.class, false);
		DimensionManager.registerProviderType(callisto, WorldProviderCallisto.class, false);
		DimensionManager.registerProviderType(neptune, WorldProviderNeptune.class, false);
		
		DimensionManager.registerDimension(hollows, hollows);
		DimensionManager.registerDimension(callisto, callisto);
		DimensionManager.registerDimension(neptune, neptune);
	}
}