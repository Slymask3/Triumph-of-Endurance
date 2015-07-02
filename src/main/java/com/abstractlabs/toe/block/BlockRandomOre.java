package com.abstractlabs.toe.block;

import java.util.Random;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;

import com.abstractlabs.toe.init.ToeItems;
import com.abstractlabs.toe.reference.Reference;
import com.abstractlabs.toe.utility.LogHelper;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockRandomOre extends BlockToeOre {
	public static IIcon side;
	
	public BlockRandomOre() {
		super("randomOre", 3);
	}
    
	public void registerBlockIcons(IIconRegister ir) {
		side = ir.registerIcon(Reference.MOD_ID + ":randomOre");
	}
	
	@SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        return this.side;
    }
	
	public Item getItemDropped(int par1, Random rand, int par3) {
		Item[] drops = new Item[]{Items.coal, Items.iron_ingot, Items.gold_ingot, Items.diamond, Items.redstone, Items.emerald, ToeItems.ruby, ToeItems.sapphire, ToeItems.aluminium, ToeItems.crystal};
		int[] rarity = new int[]{        100,               80,               70,            30,            100,            20,            20,                20,                 80,               60};

        boolean dropSelected = false;
        
        while(!dropSelected) {
        	int r = rand.nextInt(drops.length);
            int r1 = rand.nextInt(100)+1;
        	
	        for(int i=0; i<drops.length; i++) {
	        	if(r==i) {
	        		LogHelper.info("[RandomOre] " + drops[i].getUnlocalizedName() + " : " + rarity[i] + " | random rarity == " + r1);
	        		
	        		if(r1 <= rarity[i]) {
	        			dropSelected = true;
	            		return drops[i];
	        		}
	        	}
        	}
        }
        
        return Items.apple; //for debugging
    }
}