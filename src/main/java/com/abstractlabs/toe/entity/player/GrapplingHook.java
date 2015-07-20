package com.abstractlabs.toe.entity.player;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

import com.abstractlabs.toe.Toe;
import com.abstractlabs.toe.entity.projectile.EntityGrapplingHook;
import com.abstractlabs.toe.network.PacketGrapplingHook;
import com.abstractlabs.toe.utility.LogHelper;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class GrapplingHook implements IExtendedEntityProperties {
	private final EntityPlayer player;
	private static final String NBT = "GRAPPLINGHOOK";
	private static final String HOOK = "GrapplingHook";
	
	private boolean hook;
	
	private EntityGrapplingHook entity;
	
	public GrapplingHook(EntityPlayer player) {
		this.player = player;
		this.hook = false;
	}
	
	public void saveNBTData(NBTTagCompound n) {
		NBTTagCompound tag = this.player.getEntityData().getCompoundTag(NBT);
		tag.setBoolean(HOOK, this.hook);
		n.setTag(NBT, tag);
		this.player.getEntityData().setTag(NBT, tag);
	}
	
	public static void addProperties(EntityPlayer player) {
		player.registerExtendedProperties(NBT, new GrapplingHook(player));
	}
	
	public static GrapplingHook getProperties(EntityPlayer player) {
		return (GrapplingHook)player.getExtendedProperties(NBT);
	}
	
	public void loadNBTData(NBTTagCompound n) {
		NBTTagCompound tag = this.player.getEntityData().getCompoundTag(NBT);
		if (!tag.hasKey(HOOK)) return;
		this.hook = tag.getBoolean(HOOK);
		this.player.getEntityData().setTag(NBT, tag);
	}

	public boolean hasHookEntity() {
		return this.hook;
	}

	public EntityGrapplingHook getHookEntity() {
		return this.entity;
	}
	
	public void setHook(boolean hasHook) {
		this.hook = hasHook;
		this.sync();
	}
	
	public void setEntity(EntityGrapplingHook hook) {
		this.entity = hook;
	}
	
	@SubscribeEvent
	public void init(Entity entity, World world) {}

	public void sync() {
		Toe.packetPipeline.sendTo(new PacketGrapplingHook(hook), (EntityPlayerMP)this.player); //packet seems to be useless
		LogHelper.info("GrapplingHook.sync() - sent packet with hasHook==" + hook);
	}
}