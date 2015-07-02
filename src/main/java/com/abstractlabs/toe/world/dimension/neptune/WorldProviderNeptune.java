package com.abstractlabs.toe.world.dimension.neptune;

import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;

import com.abstractlabs.toe.init.ToeBiomes;
import com.abstractlabs.toe.init.ToeDimensions;

public class WorldProviderNeptune extends WorldProvider {
	public void registerWorldChunkManager(){
		this.worldChunkMgr = new WorldChunkManagerHell(ToeBiomes.biomeNeptune, 0.5F);
		this.dimensionId = ToeDimensions.neptune;
		//this.hasNoSky = true;
		//this.setSkyRenderer(new SkyRendererMoon());
	}
	
	public IChunkProvider createChunkGenerator() {
		return new ChunkProviderNeptune(worldObj, worldObj.getSeed(), true);
	}
	
	@Override
	public String getDimensionName() {
		return "Neptune";
	}
	
//	@SideOnly(Side.CLIENT)
//    public float getCloudHeight() {
//        return -2000.0F;
//    }
}