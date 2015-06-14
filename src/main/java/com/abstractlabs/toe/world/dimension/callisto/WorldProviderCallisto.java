package com.abstractlabs.toe.world.dimension.callisto;

import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;

import com.abstractlabs.toe.init.ToeBiomes;
import com.abstractlabs.toe.init.ToeDimensions;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class WorldProviderCallisto extends WorldProvider {
	public void registerWorldChunkManager(){
		this.worldChunkMgr = new WorldChunkManagerHell(ToeBiomes.biomeMoon, 1.2F);
		this.dimensionId = ToeDimensions.callisto;
		//this.hasNoSky = true;
		//this.setSkyRenderer(new SkyRendererMoon());
	}
	
	public IChunkProvider createChunkGenerator() {
		return new ChunkProviderCallisto(worldObj, worldObj.getSeed(), true);
	}
	
	@Override
	public String getDimensionName() {
		return "Callisto";
	}
	
	@SideOnly(Side.CLIENT)
    public float getCloudHeight() {
        return -2000.0F;
    }
}