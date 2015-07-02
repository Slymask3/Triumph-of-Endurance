package com.abstractlabs.toe.reference;

import net.minecraft.init.Items;
import net.minecraft.item.Item;

import com.abstractlabs.toe.init.ToeItems;

public class Fishing {
	public static Fishing[] fish = {
		//          Item               , A, M,   R,   XP, LVL
		new Fishing(ToeItems.shrimp    , 1, 0, 100,   10,  1),
		new Fishing(Items.fish         , 1, 0, 100,   10,  1), //cod
		new Fishing(ToeItems.sardine   , 1, 0, 100,   20,  5),
		new Fishing(Items.fish         , 1, 1, 100,   30, 10), //salmon
		new Fishing(ToeItems.tuna      , 1, 0, 100,   40, 15),
		new Fishing(ToeItems.trout     , 1, 0, 100,   50, 25),
		new Fishing(ToeItems.pike      , 1, 0,  90,   60, 30),
		new Fishing(ToeItems.catfish   , 1, 0,  90,   75, 40),
		new Fishing(Items.fish         , 1, 2,  90,   90, 45), //clownfish
		new Fishing(Items.fish         , 1, 3,  90,   90, 45), //pufferfish
		new Fishing(ToeItems.bass      , 1, 0,  90,  100, 50),
		new Fishing(ToeItems.swordfish , 1, 0,  80,  120, 60),
		new Fishing(ToeItems.monkfish  , 1, 0,  70,  200, 80),
		new Fishing(ToeItems.shark     , 1, 0,  50,  500, 90),

		new Fishing(ToeItems.coinCopper, 1, 0, 100,    5,  1),
		new Fishing(ToeItems.coinSilver, 1, 0,  50,   50, 25),
		new Fishing(ToeItems.coinGold  , 1, 0,  20, 1000, 80)
	};
	
	private Item item;
	private int amount;
	private int meta;
	private int rarity;
	private int exp;
	private int lvl;
	
	public Fishing(Item item, int amount, int meta, int rarity, int exp, int lvl) {
		this.item = item;
		this.amount = amount;
		this.meta = meta;
		this.rarity = rarity;
		this.exp = exp;
		this.lvl = lvl;
	}
	
	public Fishing(Item item, int rarity, int exp, int lvl) {
		this.item = item;
		this.amount = 1;
		this.meta = 0;
		this.rarity = rarity;
		this.exp = exp;
		this.lvl = lvl;
	}
	
	public Item getItem() {
		return item;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public int getMeta() {
		return meta;
	}
	
	public int getRarity() {
		return rarity;
	}
	
	public int getExp() {
		return exp;
	}
	
	public int getLvl() {
		return lvl;
	}
}