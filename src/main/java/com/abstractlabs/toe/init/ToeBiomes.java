package com.abstractlabs.toe.init;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;

import com.abstractlabs.toe.world.biome.BiomeGenMoon;

public class ToeBiomes {
	public static BiomeGenBase biomeMoon = new BiomeGenMoon(170).setBiomeName("Moon").setTemperatureRainfall(1.2F, 0.9F);;
	
	public static void init(){
		BiomeDictionary.registerBiomeType(biomeMoon, Type.DEAD);
		BiomeManager.addSpawnBiome(biomeMoon);
	}
}
