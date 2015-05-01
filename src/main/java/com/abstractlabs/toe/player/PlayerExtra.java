package com.abstractlabs.toe.player;

import net.minecraft.entity.player.EntityPlayer;

public class PlayerExtra {
	private int money;
	private EntityPlayer player;
	
	public PlayerExtra(EntityPlayer player) {
		this.player = player;
		this.money = 0;
	}
	
	public int getMoney() {
		return money;
	}
	
	public void setMoney(int newMoney) {
		this.money = newMoney;
	}
	
	public void addMoney(int newMoney) {
		this.money += newMoney;
	}
	
	public void removeMoney(int newMoney) {
		this.money -= newMoney;
	}
	
	public EntityPlayer getPlayer() {
		return player;
	}
}