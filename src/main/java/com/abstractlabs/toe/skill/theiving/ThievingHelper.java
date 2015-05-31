package com.abstractlabs.toe.skill.theiving;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

import com.abstractlabs.toe.init.ToePackets;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class ThievingHelper implements IExtendedEntityProperties {
	private final EntityPlayer player;
	private static final String NBT = "ToeSkills";
	private static final String SKILL = "ThievingSkill";
	private static final String LEVEL = "ThievingLevel";
	private static final String EXP = "ThievingExp";
	private float exp;
	private int level;
	
	public ThievingHelper(EntityPlayer player) {
		this.player = player;
		this.level = 1;
		this.exp = 0.0F;
	}
	
	public void saveNBTData(NBTTagCompound n) {
		NBTTagCompound tag = this.player.getEntityData().getCompoundTag(NBT);
		tag.setInteger(LEVEL, this.level);
		tag.setFloat(EXP, this.exp);
		n.setTag(NBT, tag);
		this.player.getEntityData().setTag(NBT, tag);
	}
	
	public static void addProperties(EntityPlayer player) {
		player.registerExtendedProperties(SKILL, new ThievingHelper(player));
	}
	
	public static ThievingHelper getProperties(EntityPlayer player) {
		return (ThievingHelper)player.getExtendedProperties(SKILL);
	}
	
	public void loadNBTData(NBTTagCompound n) {
		NBTTagCompound tag = this.player.getEntityData().getCompoundTag(NBT);
		if (!tag.hasKey(LEVEL)) return;
		this.level = tag.getInteger(LEVEL);
		this.exp = tag.getFloat(EXP);
		this.player.getEntityData().setTag(NBT, tag);
	}
	
	public int getLevel() {
		return this.level;
	}
	
	public float getExperience() {
		return this.exp;
	}
	
	public float getExpRequired() {
		return (float)(Math.pow(1.1D, this.level - 1) * 50.0D);
	}
	
	public void setExperience(float i) {
		this.exp = i;
		if ((this.player instanceof EntityPlayerMP))
			ToePackets.network.sendTo(new ThievingPacket(this.level, progressPercentage()), (EntityPlayerMP)this.player);
	}
	
	public void setLevel(int i) {
		this.level = i;
		if ((this.player instanceof EntityPlayerMP))
			ToePackets.network.sendTo(new ThievingPacket(this.level, progressPercentage()), (EntityPlayerMP)this.player);
	}
	
	public int progressPercentage() {
		return (int)Math.floor(this.exp / getExpRequired() * 100.0F);
	}
	
	public void levelUp() {
		if (this.level != 100)
			//this.player.field_70170_p.func_72956_a(this.player, "nevermine:LevelUp", 3.85F, 1.0F);
			this.level += 1;
		if (this.level == 100)
			//this.player.field_70170_p.func_72956_a(this.player, "nevermine:Level100", 3.85F, 1.0F);
		if (this.level == 101)
			this.level = 100;
		this.exp = 0.0F;
		if (this.player instanceof EntityPlayerMP)
			ToePackets.network.sendTo(new ThievingPacket(this.level, progressPercentage()), (EntityPlayerMP)this.player);
	}
	
	public float getExpLeft() {
		return (float)(Math.pow(1.1D, this.level - 1) * 50.0D) - this.exp;
	}
	
	public void addExperience(float i) {
		if (i > getExpLeft()) {
			float x = i;
			boolean run = true;
			while (run) {
				if (x > getExpLeft()) {
					x -= getExpLeft();
					levelUp();
				} else {
					this.exp += x;
					run = false;
					if ((this.player instanceof EntityPlayerMP))
						ToePackets.network.sendTo(new ThievingPacket(this.level, progressPercentage()), (EntityPlayerMP)this.player);
				}
			}
		} else {
			this.exp += i;
			if (this.exp >= getExpRequired()) {
				levelUp();
			} else if ((this.player instanceof EntityPlayerMP)) {
				ToePackets.network.sendTo(new ThievingPacket(this.level, progressPercentage()), (EntityPlayerMP)this.player);
			}
		}
	}
	
	@SubscribeEvent
	public void init(Entity entity, World world) {
		
	}

	public void sync() {
		ToePackets.network.sendTo(new ThievingPacket(this.level, progressPercentage()), (EntityPlayerMP)this.player);
	}
}