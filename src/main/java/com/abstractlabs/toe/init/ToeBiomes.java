package com.abstractlabs.toe.init;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;

import com.abstractlabs.toe.world.biome.BiomeGenMoon;
import com.abstractlabs.toe.world.biome.BiomeGenNeptune;

public class ToeBiomes {
	public static BiomeGenBase biomeMoon = new BiomeGenMoon(170).setBiomeName("Moon").setTemperatureRainfall(1.2F, 0.9F);;
	public static BiomeGenBase biomeHollows = new BiomeGenMoon(170).setBiomeName("Hollows").setTemperatureRainfall(1.2F, 0.9F);;
	public static BiomeGenBase biomeNeptune = new BiomeGenNeptune(172).setBiomeName("Neptune").setTemperatureRainfall(0.0F, 0.5F);;
	
	public static void init(){
		BiomeDictionary.registerBiomeType(biomeMoon, Type.DEAD);
		BiomeManager.addSpawnBiome(biomeMoon);
		
		BiomeDictionary.registerBiomeType(biomeHollows, Type.DEAD);
		BiomeManager.addSpawnBiome(biomeHollows);
		
		BiomeDictionary.registerBiomeType(biomeNeptune, Type.SNOWY);
		BiomeManager.addSpawnBiome(biomeNeptune);
	}
}
