package com.abstractlabs.toe.creativetab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import com.abstractlabs.toe.init.ToeItems;

public class ToeTab {
	public static final CreativeTabs TOE_TAB = new CreativeTabs("toe") {
		@Override
		public Item getTabIconItem() {
			return ToeItems.cane;
		}
	};
}