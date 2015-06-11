package com.abstractlabs.toe.block;

import java.util.Random;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;

import com.abstractlabs.toe.reference.Reference;

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
        int r = rand.nextInt(6);
        
        if(r==0) {
        	return Items.coal;
        } else if(r==1) {
        	return Items.iron_ingot;
        } else if(r==2) {
        	return Items.gold_ingot;
        } else if(r==3) {
        	return Items.diamond;
        } else if(r==4) {
        	return Items.redstone;
        } else if(r==5) {
        	return Items.emerald;
        }
        return Items.coal;
    }
}