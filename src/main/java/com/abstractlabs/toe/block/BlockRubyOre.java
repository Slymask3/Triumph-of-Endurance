package com.abstractlabs.toe.block;

import java.util.Random;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;

import com.abstractlabs.toe.init.ToeItems;
import com.abstractlabs.toe.reference.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockRubyOre extends BlockToeOre {
	public static IIcon side;
	
	public BlockRubyOre() {
		super("rubyOre", 3);
	}
    
	public void registerBlockIcons(IIconRegister ir) {
		side = ir.registerIcon(Reference.MOD_ID + ":rubyOre");
	}
	
	@SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        return this.side;
    }
	
	public Item getItemDropped(int par1, Random rand, int par3) {
        return ToeItems.ruby;
    }
}