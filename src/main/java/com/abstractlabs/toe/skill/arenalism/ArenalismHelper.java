package com.abstractlabs.toe.skill.arenalism;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

import com.abstractlabs.toe.init.ToePackets;
import com.abstractlabs.toe.reference.Skill;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class ArenalismHelper implements IExtendedEntityProperties {
	private final EntityPlayer player;
	private static final String NBT = "ToeSkills";
	private static final String SKILL = "ArenalismSkill";
	private static final String LEVEL = "ArenalismLevel";
	private static final String EXP = "ArenalismExp";
	private float exp;
	private int level;
	
	private boolean inArena;
	private int cash;
//	private int wave;
//	private int enemiesLeft;
//	private int maxWaves;
	
	public ArenalismHelper(EntityPlayer player) {
		this.player = player;
		this.level = 1;
		this.exp = 0.0F;
		this.inArena = false;
		this.cash = 0;
//		this.wave = 0;
//		this.enemiesLeft = 0;
//		this.maxWaves = 0;
	}
	
	public void startArena(int cash, int maxWaves) {
		this.inArena = true;
		this.cash = cash;
//		this.maxWaves = maxWaves;
		this.sync();
	}
	
	public void endArena(float xp) {
		this.inArena = false;
		this.cash = 0;
//		this.wave = 0;
//		this.enemiesLeft = 0;
//		this.maxWaves = 0;
		//give xp here?
		addExperience(xp);
		
		this.sync();
	}
	
	public void saveNBTData(NBTTagCompound n) {
		NBTTagCompound tag = this.player.getEntityData().getCompoundTag(NBT);
		tag.setInteger(LEVEL, this.level);
		tag.setFloat(EXP, this.exp);
		tag.setBoolean("InArena", this.inArena);
		tag.setInteger("Cash", this.cash);
//		tag.setInteger("Wave", this.wave);
//		tag.setInteger("EnemiesLeft", this.enemiesLeft);
//		tag.setInteger("MaxWaves", this.maxWaves);
		n.setTag(NBT, tag);
		this.player.getEntityData().setTag(NBT, tag);
	}
	
	public static void addProperties(EntityPlayer player) {
		player.registerExtendedProperties("ArenalismSkill", new ArenalismHelper(player));
	}
	
	public static ArenalismHelper getProperties(EntityPlayer player) {
		return (ArenalismHelper)player.getExtendedProperties("ArenalismSkill");
	}
	
	public void loadNBTData(NBTTagCompound n) {
		NBTTagCompound tag = this.player.getEntityData().getCompoundTag(NBT);
		if (!tag.hasKey(LEVEL)) return;
		this.level = tag.getInteger(LEVEL);
		this.exp = tag.getFloat(EXP);
		this.inArena = tag.getBoolean("InArena");
		this.cash = tag.getInteger("Cash");
//		this.wave = tag.getInteger("Wave");
//		this.enemiesLeft = tag.getInteger("EnemiesLeft");
//		this.maxWaves = tag.getInteger("MaxWaves");
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
			this.sync();
	}
	
	public void setLevel(int i) {
		this.level = i;
		if ((this.player instanceof EntityPlayerMP))
			this.sync();
	}
	
	public int progressPercentage() {
		return (int)Math.floor(this.exp / getExpRequired() * 100.0F);
	}
	
	public void levelUp() {
		if (this.level != Skill.maxLevel)
			//this.player.field_70170_p.func_72956_a(this.player, "nevermine:LevelUp", 3.85F, 1.0F);
			this.level += 1;
		if (this.level == Skill.maxLevel)
			//this.player.field_70170_p.func_72956_a(this.player, "nevermine:Level100", 3.85F, 1.0F);
		if (this.level == Skill.maxLevel+1)
			this.level = Skill.maxLevel;
		this.exp = 0.0F;
		if (this.player instanceof EntityPlayerMP)
			this.sync();
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
						this.sync();
				}
			}
		} else {
			this.exp += i;
			if (this.exp >= getExpRequired()) {
				levelUp();
			} else if ((this.player instanceof EntityPlayerMP)) {
				//ToePackets.network.sendTo(new ArenalismPacket(this.level, progressPercentage()), (EntityPlayerMP)this.player);
				this.sync();
			}
		}
	}
	
	//arena stuff
	public int getCash() {
		return this.cash;
	}

//	public int getWave() {
//		return this.wave;
//	}
//	
//	public int getEnemiesRemaining() {
//		return this.enemiesLeft;
//	}
//	
//	public int getMaxWaves() {
//		return this.maxWaves;
//	}
	
	public void updateCash(int cash) {
		this.cash = cash;
		this.sync();
	}
	
//	public void updateWave(int wave) {
//		this.wave = wave;
//		this.sync();
//	}
//	
//	public void updateEnemies(int enemies) {
//		this.enemiesLeft = enemies;
//		this.sync();
//	}
	
	public void buyItem(int price) {
		//LogHelper.info("cash: " + cash.get(player));
		//cash.put(player, cash.get(player) - price);
		//LogHelper.info("player: " + player.getDisplayName());
		//LogHelper.info("price: " + price);
		//LogHelper.info("cash: " + cash.get(player));
		
		updateCash(getCash() - price);
	}
	
	public boolean doesPlayerHaveEnough(int price) {
		if(getCash() >= price) {
			return true;
		}
		
		return false;
	}
	
	public boolean inArena() {
		return this.inArena;
	}
	
	
	@SubscribeEvent
	public void init(Entity entity, World world) {
		
	}

	public void sync() {
		ToePackets.network.sendTo(new ArenalismPacket(this.level, progressPercentage(), this.inArena, this.cash), (EntityPlayerMP)this.player);
	}
}