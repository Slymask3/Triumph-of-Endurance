package com.abstractlabs.toe.item;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.block.BlockRedstoneOre;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

import com.abstractlabs.toe.creativetab.ToeTab;
import com.abstractlabs.toe.init.ToeBlocks;
import com.abstractlabs.toe.init.ToeItems;
import com.abstractlabs.toe.utility.LogHelper;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemToePickaxe extends ItemPickaxe {
	public ItemToePickaxe(ToolMaterial material) {
		super(material);
        this.setCreativeTab(ToeTab.TOE_TAB);
	}
	
	@Override
    public String getUnlocalizedName() {
        return String.format("item.%s%s", "toe" + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack) {
        return String.format("item.%s%s", "toe" + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        itemIcon = iconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
    }

    protected String getUnwrappedUnlocalizedName(String unlocalizedName) {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }
    
    public boolean onBlockDestroyed(ItemStack is, World world, Block block, int x, int y, int z, EntityLivingBase entity) {
    	if(!world.isRemote && is != null && is.getItem() == ToeItems.specialPickaxe && (block instanceof BlockOre || block instanceof BlockRedstoneOre || block == Blocks.stone || block == ToeBlocks.randomOre)) {
    		Random rand = new Random();
			
    		MovingObjectPosition mop = this.getMovingObjectPositionFromPlayer(world, (EntityPlayer) entity, false);
        	int side = mop.sideHit;
    		LogHelper.info("side == " + side + " (Item) new, isRemote == " + world.isRemote + ", item == " + is.getItem());

    		int x1 = x;
    		int x2 = x;
    		int x3 = x;
    		int x4 = x;
    		int x5 = x;
    		int x6 = x;
    		int x7 = x;
    		int x8 = x;
    		int y1 = y;
    		int y2 = y;
    		int y3 = y;
    		int y4 = y;
    		int y5 = y;
    		int y6 = y;
    		int y7 = y;
    		int y8 = y;
    		int z1 = z;
    		int z2 = z;
    		int z3 = z;
    		int z4 = z;
    		int z5 = z;
    		int z6 = z;
    		int z7 = z;
    		int z8 = z;
    		
    		if(side == 0 || side == 1) {
    			x1 = x-1;
        		x2 = x-1;
        		x3 = x-1;
        		x4 = x;
        		x5 = x;
        		x6 = x+1;
        		x7 = x+1;
        		x8 = x+1;
        		y1 = y;
        		y2 = y;
        		y3 = y;
        		y4 = y;
        		y5 = y;
        		y6 = y;
        		y7 = y;
        		y8 = y;
        		z1 = z-1;
        		z2 = z;
        		z3 = z+1;
        		z4 = z-1;
        		z5 = z+1;
        		z6 = z-1;
        		z7 = z;
        		z8 = z+1;
    		} else if(side == 2 || side == 3) {
    			x1 = x-1;
        		x2 = x;
        		x3 = x+1;
        		x4 = x-1;
        		x5 = x+1;
        		x6 = x-1;
        		x7 = x;
        		x8 = x+1;
        		y1 = y-1;
        		y2 = y-1;
        		y3 = y-1;
        		y4 = y;
        		y5 = y;
        		y6 = y+1;
        		y7 = y+1;
        		y8 = y+1;
    			z1 = z;
        		z2 = z;
        		z3 = z;
        		z4 = z;
        		z5 = z;
        		z6 = z;
        		z7 = z;
        		z8 = z;
    		} else if(side == 4 || side == 5) {
    			x1 = x;
        		x2 = x;
        		x3 = x;
        		x4 = x;
        		x5 = x;
        		x6 = x;
        		x7 = x;
        		x8 = x;
        		y1 = y-1;
        		y2 = y-1;
        		y3 = y-1;
        		y4 = y;
        		y5 = y;
        		y6 = y+1;
        		y7 = y+1;
        		y8 = y+1;
        		z1 = z-1;
        		z2 = z;
        		z3 = z+1;
        		z4 = z-1;
        		z5 = z+1;
        		z6 = z-1;
        		z7 = z;
        		z8 = z+1;
    		}
    		
    		Block b1 = world.getBlock(x1, y1, z1);
    		Block b2 = world.getBlock(x2, y2, z2);
    		Block b3 = world.getBlock(x3, y3, z3);
    		Block b4 = world.getBlock(x4, y4, z4);
    		Block b5 = world.getBlock(x5, y5, z5);
    		Block b6 = world.getBlock(x6, y6, z6);
			Block b7 = world.getBlock(x7, y7, z7);
			Block b8 = world.getBlock(x8, y8, z8);
			int m1 = world.getBlockMetadata(x1, y1, z1);
			int m2 = world.getBlockMetadata(x2, y2, z2);
			int m3 = world.getBlockMetadata(x3, y3, z3);
			int m4 = world.getBlockMetadata(x4, y4, z4);
			int m5 = world.getBlockMetadata(x5, y5, z5);
			int m6 = world.getBlockMetadata(x6, y6, z6);
			int m7 = world.getBlockMetadata(x7, y7, z7);
			int m8 = world.getBlockMetadata(x8, y8, z8);
    		
			if(b1 instanceof BlockOre || b1 instanceof BlockRedstoneOre || b1 == Blocks.stone || b1 == ToeBlocks.randomOre) {
				world.spawnEntityInWorld(new EntityItem(world, x1, y1, z1, new ItemStack(b1.getItemDropped(m1, rand, 0))));
				world.setBlock(x1, y1, z1, Blocks.air);
			}
			
			if(b2 instanceof BlockOre || b2 instanceof BlockRedstoneOre || b2 == Blocks.stone || b2 == ToeBlocks.randomOre) {
				world.spawnEntityInWorld(new EntityItem(world, x2, y2, z2, new ItemStack(b2.getItemDropped(m2, rand, 0))));
				world.setBlock(x2, y2, z2, Blocks.air);
			}
			
			if(b3 instanceof BlockOre || b3 instanceof BlockRedstoneOre || b3 == Blocks.stone || b3 == ToeBlocks.randomOre) {
				world.spawnEntityInWorld(new EntityItem(world, x3, y3, z3, new ItemStack(b3.getItemDropped(m3, rand, 0))));
				world.setBlock(x3, y3, z3, Blocks.air);
			}
			
			if(b4 instanceof BlockOre || b4 instanceof BlockRedstoneOre || b4 == Blocks.stone || b4 == ToeBlocks.randomOre) {
				world.spawnEntityInWorld(new EntityItem(world, x4, y4, z4, new ItemStack(b4.getItemDropped(m4, rand, 0))));
				world.setBlock(x4, y4, z4, Blocks.air);
			}
			
			if(b5 instanceof BlockOre || b5 instanceof BlockRedstoneOre || b5 == Blocks.stone || b5 == ToeBlocks.randomOre) {
				world.spawnEntityInWorld(new EntityItem(world, x5, y5, z5, new ItemStack(b5.getItemDropped(m5, rand, 0))));
				world.setBlock(x5, y5, z5, Blocks.air);
			}
			
			if(b6 instanceof BlockOre || b6 instanceof BlockRedstoneOre || b6 == Blocks.stone || b6 == ToeBlocks.randomOre) {
				world.spawnEntityInWorld(new EntityItem(world, x6, y6, z6, new ItemStack(b6.getItemDropped(m6, rand, 0))));
				world.setBlock(x6, y6, z6, Blocks.air);
			}
			
			if(b7 instanceof BlockOre || b7 instanceof BlockRedstoneOre || b7 == Blocks.stone || b7 == ToeBlocks.randomOre) {
				world.spawnEntityInWorld(new EntityItem(world, x7, y7, z7, new ItemStack(b7.getItemDropped(m7, rand, 0))));
				world.setBlock(x7, y7, z7, Blocks.air);
			}
			
			if(b8 instanceof BlockOre || b8 instanceof BlockRedstoneOre || b8 == Blocks.stone || b8 == ToeBlocks.randomOre) {
				world.spawnEntityInWorld(new EntityItem(world, x8, y8, z8, new ItemStack(b8.getItemDropped(m8, rand, 0))));
				world.setBlock(x8, y8, z8, Blocks.air);
			}
    	}
    	
        return true;
    }
}
