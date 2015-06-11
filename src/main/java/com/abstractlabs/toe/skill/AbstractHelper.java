package com.abstractlabs.toe.skill;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

import com.abstractlabs.toe.reference.Skill;

//UNUSED

public abstract class AbstractHelper {
	protected final EntityPlayer player;
	protected static final String NBT = "ToeSkills";
	protected static String SKILL = "AbstractSkill";
	protected static String LEVEL = "AbstractLevel";
	protected static String EXP = "AbstractExp";
	protected float exp;
	protected int level;
	
	protected AbstractHelper(EntityPlayer player, String name) {
		this.player = player;
		this.level = 1;
		this.exp = 0.0F;
		this.SKILL = name+"Skills";
		this.LEVEL = name+"Level";
		this.EXP = name+"Exp";
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
			this.player.worldObj.playSoundAtEntity(this.player, "random.levelup", 3.85F, 1.0F);
			this.level += 1;
		if (this.level == Skill.maxLevel)
			this.player.worldObj.playSoundAtEntity(this.player, "random.levelup", 3.85F, 1.0F);
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
				this.sync();
			}
		}
	}

	public abstract void sync();
}