package com.abstractlabs.toe.init;

import com.abstractlabs.toe.spookydimension.WorldProviderHollows;

import net.minecraftforge.common.DimensionManager;

public class ToeDimensions 
{
	public static void mainRegistry()
	{
		registerDimension();
	}
	
	public static final int hollowsID = 8;
	
	public static void registerDimension()
	{
		DimensionManager.registerProviderType(hollowsID, WorldProviderHollows.class, false);
		DimensionManager.registerDimension(hollowsID, hollowsID);
	}
}
