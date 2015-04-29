package com.abstractlabs.toe.creativetab;

import com.abstractlabs.toe.init.ToeBlocks;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ToeTab {
	
	public static final CreativeTabs TOE_TAB = new CreativeTabs("toe") {
		@Override
		public Item getTabIconItem() {
			return Item.getItemFromBlock(ToeBlocks.exteriorDesert);
		}
	};
}