package com.abstractlabs.toe.entity.player;

public class Coins {
	int copper, silver, gold;
	
	public Coins(int c, int s, int g) {
		this.copper = c;
		this.silver = s;
		this.gold = g;
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
}
