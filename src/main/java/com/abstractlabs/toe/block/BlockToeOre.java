package com.abstractlabs.toe.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;

import com.abstractlabs.toe.reference.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockToeOre extends BlockToe {
	private IIcon side;
	private String name;
	private Item itemDrop;
	private int amountDrop;
	private boolean random;
	
	public BlockToeOre(String name, int harvest) {
		super(Material.rock, Block.soundTypeStone, name);
		setHardness(3.0F);
		setHarvestLevel("pickaxe", harvest);
		this.name = name;
		this.itemDrop = null;
		this.amountDrop = 1;
		this.random = false;
	}
	
	public BlockToeOre(String name, int harvest, Item item) {
		super(Material.rock, Block.soundTypeStone, name);
		setHardness(3.0F);
		setHarvestLevel("pickaxe", harvest);
		this.name = name;
		this.itemDrop = item;
		this.amountDrop = 1;
		this.random = false;
	}
	
	public BlockToeOre(String name, int harvest, Item item, int amount) {
		super(Material.rock, Block.soundTypeStone, name);
		setHardness(3.0F);
		setHarvestLevel("pickaxe", harvest);
		this.name = name;
		this.itemDrop = item;
		this.amountDrop = amount;
		this.random = false;
	}
	
	public BlockToeOre(String name, int harvest, Item item, int amount, boolean random) {
		super(Material.rock, Block.soundTypeStone, name);
		setHardness(3.0F);
		setHarvestLevel("pickaxe", harvest);
		this.name = name;
		this.itemDrop = item;
		this.amountDrop = amount;
		this.random = random;
	}
	
	public void registerBlockIcons(IIconRegister ir) {
		side = ir.registerIcon(Reference.MOD_ID + ":" + name);
	}
	
	@SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        return this.side;
    }
	
	public Item getItemDropped(int par1, Random rand, int par3) {
		return itemDrop;
    }
	
	public int quantityDropped(Random rand) {
		if(random) {
	        return rand.nextInt(amountDrop)+1;
		} else {
			return amountDrop;
		}
    }
}