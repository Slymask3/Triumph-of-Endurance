package com.abstractlabs.toe.entity.npc;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.abstractlabs.toe.init.ToeBlocks;
import com.abstractlabs.toe.init.ToeItems;
import com.abstractlabs.toe.item.ItemTopHat;

public class EntityShopTest extends EntityShop {
	public EntityShopTest(World world) {
		super(world, "Shop Test", 14);
	}

	@Override
	public void addItemStacksToShop() {
		ItemStack tophat = new ItemStack(ToeItems.tophat);
		((ItemTopHat) tophat.getItem()).dye(tophat, 0x00FF00);
		
		this.addItemStackToShop(0, BUY, new ItemStack(Blocks.dirt), new ItemStack(ToeItems.coinCopper, 3));
		this.addItemStackToShop(1, SELL, new ItemStack(Blocks.sand), new ItemStack(ToeItems.coinCopper, 3));
		this.addItemStackToShop(2, BUY, new ItemStack(ToeBlocks.pedestalBrick), new ItemStack(ToeItems.coinCopper, 5));
		this.addItemStackToShop(3, BUY, new ItemStack(Items.bone), new ItemStack(ToeItems.coinGold, 1));
		this.addItemStackToShop(4, BUY, new ItemStack(Blocks.end_stone), new ItemStack(ToeItems.coinCopper, 5));
		this.addItemStackToShop(5, BUY, tophat, new ItemStack(ToeItems.coinSilver, 2));

		this.addItemStackToShop(6, BUY, new ItemStack(ToeItems.cane), new ItemStack(ToeItems.coinGold, 5));
		this.addItemStackToShop(7, BUY, new ItemStack(Blocks.tnt), new ItemStack(ToeItems.coinCopper, 10));
		this.addItemStackToShop(8, BUY, new ItemStack(ToeBlocks.moonBrick), new ItemStack(ToeItems.coinCopper, 6));
		this.addItemStackToShop(9, SELL, new ItemStack(Blocks.obsidian), new ItemStack(ToeItems.coinCopper, 5));
		this.addItemStackToShop(10, BUY, new ItemStack(ToeItems.aluminium), new ItemStack(ToeItems.coinSilver, 1));
		this.addItemStackToShop(11, BUY, new ItemStack(ToeItems.bucketGoo), new ItemStack(ToeItems.coinGold, 1));

		this.addItemStackToShop(12, BUY, new ItemStack(ToeItems.bass), new ItemStack(ToeItems.coinCopper, 6));
		this.addItemStackToShop(13, BUY, new ItemStack(ToeItems.diamondClaw), new ItemStack(ToeItems.coinGold, 2));
	}
}