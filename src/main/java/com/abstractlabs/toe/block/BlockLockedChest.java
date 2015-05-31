package com.abstractlabs.toe.block;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import com.abstractlabs.toe.init.ToeItems;
import com.abstractlabs.toe.reference.ChestType;
import com.abstractlabs.toe.reference.Color;
import com.abstractlabs.toe.reference.Reference;
import com.abstractlabs.toe.skill.theiving.ThievingHelper;
import com.abstractlabs.toe.tileentity.TileEntityLockedChest;
import com.abstractlabs.toe.utility.Helper;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockLockedChest extends BlockToe implements ITileEntityProvider {
	public static IIcon side;
	
	public BlockLockedChest() {
		super(Material.wood, Block.soundTypeWood, "lockedChest");
		setHardness(2);
        setBlockBounds(0.0625F, 0.0F, 0.0625F, 0.9375F, 0.875F, 0.9375F);
	}
    
	public void registerBlockIcons(IIconRegister ir) {
		side = ir.registerIcon(Reference.MOD_ID + ":lockedChest");
	}
	
	@SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        return Blocks.chest.getIcon(side, meta);
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
	
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9) {
		if(player.getHeldItem() != null && player.getHeldItem().getItem() == ToeItems.lockpick) {
			TileEntityLockedChest te = (TileEntityLockedChest) world.getTileEntity(x, y, z);
			String type = te.getName();
			ThievingHelper helper = ThievingHelper.getProperties(player);
			ItemStack is = player.getHeldItem();
			
			if(type.equalsIgnoreCase(ChestType.wizard)) {
				if(helper.getLevel() >= ChestType.wizardLvl) {
					unlockChest(world, x, y, z, is, ChestType.wizard, helper.getLevel());
					helper.addExperience(ChestType.wizardXP);
					Helper.msg(player, "Chest successfully unlocked.", Color.lime);
				} else {
					Helper.msg(player, "You have to have level " + ChestType.wizardLvl + " theiving to unlock this chest.", Color.red);
				}
			}
		}
		
		return true;
	}

	private void unlockChest(World world, int x, int y, int z, ItemStack is, String type, int lvl) {
		world.setBlock(x, y, z, Blocks.chest);
		TileEntityChest chest = (TileEntityChest)world.getTileEntity(x, y, z);
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