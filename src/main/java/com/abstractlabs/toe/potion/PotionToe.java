package com.abstractlabs.toe.potion;

import net.minecraft.potion.Potion;

import com.abstractlabs.toe.reference.Reference;

public class PotionToe extends Potion {
	public PotionToe(int id, boolean isBadEffect, int liquidColor) {
		super(id, isBadEffect, liquidColor);
	}

	public Potion setIconIndex(int x, int y) {
		super.setIconIndex(x, y);
	    return this;
	}
	
	public Potion setPotionName(String name) {
        return super.setPotionName(Reference.MOD_ID + ":" + name);
    }
}