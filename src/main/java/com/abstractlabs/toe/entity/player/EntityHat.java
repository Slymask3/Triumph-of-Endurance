package com.abstractlabs.toe.entity.player;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

import com.abstractlabs.toe.utility.LogHelper;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EntityHat extends Entity {
	private EntityPlayer player;
	
	public EntityHat(World world) {
		super(world);
	}
	
	public EntityHat(EntityPlayer player) {
		super(player.worldObj);
		this.player = player;
		LogHelper.info(this + " : created?");
	}

	@Override
	public void entityInit() {
		
	}

	@Override
	public void onUpdate() {
//		this.posX = player.posX;
//		this.posY = player.posY+5;
//		this.posZ = player.posZ;
		if(this.player != null) {
			this.setLocationAndAngles(player.posX, player.posY + 1.5D - (double)player.yOffset, player.posZ, player.rotationYawHead, player.rotationPitch);
		}
		
		//LogHelper.info(this + " : entity alive");
	}
	
	@SideOnly(Side.CLIENT)
    public float getShadowSize() {
        return 0.0F;
    }
	
	@Override
	public void readEntityFromNBT(NBTTagCompound nbt) {
		
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound nbt) {
		
	}
}