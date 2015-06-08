package com.abstractlabs.toe.player;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

import com.abstractlabs.toe.Toe;
import com.abstractlabs.toe.network.PacketATM;
import com.abstractlabs.toe.utility.LogHelper;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class ATM implements IExtendedEntityProperties {
	private final EntityPlayer player;
	private static final String NBT = "ATM";
	private static final String COPPER = "CopperCoins";
	private static final String SILVER = "SilverCoins";
	private static final String GOLD = "GoldCoins";

	private int copper;
	private int silver;
	private int gold;
	
	public ATM(EntityPlayer player) {
		this.player = player;
		this.copper = 0;
		this.silver = 0;
		this.gold = 0;
	}
	
	public void saveNBTData(NBTTagCompound n) {
		NBTTagCompound tag = this.player.getEntityData().getCompoundTag(NBT);
		tag.setInteger(COPPER, this.copper);
		tag.setInteger(SILVER, this.silver);
		tag.setInteger(GOLD, this.gold);
		n.setTag(NBT, tag);
		this.player.getEntityData().setTag(NBT, tag);
	}
	
	public static void addProperties(EntityPlayer player) {
		player.registerExtendedProperties(NBT, new ATM(player));
	}
	
	public static ATM getProperties(EntityPlayer player) {
		return (ATM)player.getExtendedProperties(NBT);
	}
	
	public void loadNBTData(NBTTagCompound n) {
		NBTTagCompound tag = this.player.getEntityData().getCompoundTag(NBT);
		if (!tag.hasKey(COPPER)) return;
		this.copper = tag.getInteger(COPPER);
		this.silver = tag.getInteger(SILVER);
		this.gold = tag.getInteger(GOLD);
		this.player.getEntityData().setTag(NBT, tag);
	}
	
	public int getCopperCoins() {
		return this.copper;
	}
	
	public int getSilverCoins() {
		return this.silver;
	}
	
	public int getGoldCoins() {
		return this.gold;
	}
	
	public void setCopperCoins(int amount) {
		this.copper = amount;
		//this.sync();
	}
	
	public void setSilverCoins(int amount) {
		this.silver = amount;
		//this.sync();
	}
	
	public void setGoldCoins(int amount) {
		this.gold = amount;
		//this.sync();
	}
	
	public void addCopperCoins(int amount) {
		this.copper += amount;
		this.sync();
	}
	
	public void addSilverCoins(int amount) {
		this.silver += amount;
		this.sync();
	}
	
	public void addGoldCoins(int amount) {
		this.gold += amount;
		this.sync();
	}
	
	public void removeCopperCoins(int amount) {
		this.copper -= amount;
		this.sync();
	}
	
	public void removeSilverCoins(int amount) {
		this.silver -= amount;
		this.sync();
	}
	
	public void removeGoldCoins(int amount) {
		this.gold -= amount;
		this.sync();
	}
	
	
	
	@SubscribeEvent
	public void init(Entity entity, World world) {}

	public void sync() {
		Toe.packetPipeline.sendTo(new PacketATM(2, copper, silver, gold), (EntityPlayerMP)this.player);
		LogHelper.info("ATM.sync() - sent packet with c" + copper + " s" + silver + " g" + gold);
	}
}