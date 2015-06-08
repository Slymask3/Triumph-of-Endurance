package com.abstractlabs.toe.block;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import com.abstractlabs.toe.item.ItemLockpick;
import com.abstractlabs.toe.reference.ChestType;
import com.abstractlabs.toe.reference.Color;
import com.abstractlabs.toe.skill.theiving.ThievingHelper;
import com.abstractlabs.toe.tileentity.TileEntityLockedChest;
import com.abstractlabs.toe.utility.Helper;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockLockedChest extends BlockToe implements ITileEntityProvider {
	public BlockLockedChest() {
		super(Material.wood, Block.soundTypeWood, "lockedChest");
		setHardness(-1);
        setBlockBounds(0.0625F, 0.0F, 0.0625F, 0.9375F, 0.875F, 0.9375F);
	}
	
	@SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
		return Blocks.planks.getIcon(side, meta);
    }
	
	public static int getDirection(int meta) {
        return meta & 3;
    }
	
	public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLivingBase par5EntityLiving, ItemStack par6ItemStack) {
        int meta = MathHelper.floor_double((double)(par5EntityLiving.rotationYaw * 4.0F / 360.0F) + 2.5D) & 3;
        par1World.setBlockMetadataWithNotify(par2, par3, par4, meta, 2);
        
        //LogHelper.info("meta == " + meta);
    }
	
	public boolean isOpaqueCube() {
        return false;
    }

	public boolean renderAsNormalBlock() {
        return false;
    }

    public int getRenderType() {
        return 22;
    }
	
    @SideOnly(Side.CLIENT)
	public boolean shouldSideBeRendered(IBlockAccess ba, int x, int y, int z, int side) {
		return true;
	}
    
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9) {
		if(!world.isRemote && player.getHeldItem() != null && player.getHeldItem().getItem() instanceof ItemLockpick) {
			TileEntityLockedChest te = (TileEntityLockedChest) world.getTileEntity(x, y, z);
			String type = te.getName();
			ThievingHelper helper = ThievingHelper.getProperties(player);
			ItemStack is = player.getHeldItem();
			
			ItemLockpick item = (ItemLockpick) is.getItem();
			int lvl = item.getLvl();
			double chance = item.getChance();
			
			//Item level check.
			if(helper.getLevel() < lvl) {
				Helper.msgClean(player, "You have to have level " + ChestType.wizardLvl + " thieving to use this item to unlock chests.", Color.red);
				return false;
			}
			
			//Chance check.
			if(Math.random() > chance) {
				if(!player.capabilities.isCreativeMode) {
		        	is.damageItem(1, player);
		        }
				Helper.msgClean(player, "Failed attempt.", Color.red);
				return false;
			}
			
			if(type.equalsIgnoreCase(ChestType.wizard)) {
				if(helper.getLevel() >= ChestType.wizardLvl) {
					unlockChest(world, x, y, z, player, is, ChestType.wizard, helper.getLevel());
					helper.addExperience(ChestType.wizardXP);
					Helper.msgClean(player, "Chest successfully unlocked.", Color.lime);
				} else {
					Helper.msgClean(player, "You have to have level " + ChestType.wizardLvl + " thieving to unlock this chest.", Color.red);
				}
			}
		}
		
		return true;
	}

	private void unlockChest(World world, int x, int y, int z, EntityPlayer player, ItemStack is, String type, int lvl) {
		if(!player.capabilities.isCreativeMode) {
        	is.damageItem(1, player);
        }
		
		int meta = world.getBlockMetadata(x, y, z);
		//LogHelper.info("meta == " + meta);

		if(meta == 0) {
			world.setBlock(x, y, z, Blocks.chest, 0, 2);
			world.setBlockMetadataWithNotify(x, y, z, 0, 2);
		} else if(meta == 1) {
			world.setBlock(x, y, z, Blocks.chest, 4, 2);
			world.setBlockMetadataWithNotify(x, y, z, 4, 2);
		} else if(meta == 2) {
			world.setBlock(x, y, z, Blocks.chest, 2, 2);
			world.setBlockMetadataWithNotify(x, y, z, 2, 2);
		} else if(meta == 3) {
			world.setBlock(x, y, z, Blocks.chest, 5, 2);
			world.setBlockMetadataWithNotify(x, y, z, 5, 2);
		}
		
		TileEntityChest chest = (TileEntityChest)world.getTileEntity(x, y, z);

//	    meta = world.getBlockMetadata(x, y, z);
//		LogHelper.info("meta == " + meta);
		
		addChestContents(chest, type, lvl);
	}
	
	private void addChestContents(TileEntityChest chest, String type, int lvl) {
		if(type.equalsIgnoreCase(ChestType.wizard)) {
			//add contents for wizard randomly depending on level
			Helper.addRandomAmount(chest, Items.diamond, 0, 1*lvl);
			//TODO more items and shit
		}
	}

	@Override
	public TileEntity createNewTileEntity(World world, int par2) {
		return new TileEntityLockedChest();
	}
}