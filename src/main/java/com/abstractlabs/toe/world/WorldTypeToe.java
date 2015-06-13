package com.abstractlabs.toe.world;

import net.minecraft.world.WorldType;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.GenLayerBiomeEdge;
import net.minecraft.world.gen.layer.GenLayerZoom;

import com.abstractlabs.toe.world.gen.layer.GenLayerMoon;

public class WorldTypeToe extends WorldType {
	public WorldTypeToe(String name){
		super(name);
	}
	
	public GenLayer getBiomeLayer(long worldSeed, GenLayer parentLayer) {
        GenLayer ret = new GenLayerMoon(200L, parentLayer, this);
        ret = GenLayerZoom.magnify(1000L, ret, 2);
        ret = new GenLayerBiomeEdge(1000L, ret);
        return ret;
    }
}