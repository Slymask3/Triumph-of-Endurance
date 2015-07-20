package com.abstractlabs.toe.block;

import com.abstractlabs.toe.Toe;
import com.abstractlabs.toe.item.ItemBone;
import com.abstractlabs.toe.item.ItemLockpick;
import com.abstractlabs.toe.reference.BoneType;
import com.abstractlabs.toe.reference.Color;
import com.abstractlabs.toe.reference.GuiID;
import com.abstractlabs.toe.reference.Reference;
import com.abstractlabs.toe.skill.prayer.PrayerHelper;
import com.abstractlabs.toe.utility.Helper;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockAltar extends BlockToe
{
	public static IIcon top;
	public static IIcon side;
	private IIcon bottom;

	public BlockAltar() 
	{
		super(Material.rock, Block.soundTypeStone, "altar");
		this.setHardness(1);
	}
	
//	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int metadeta, float what, float these, float are)
//    {
//		
//    	return true;
//    }

	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public int getRenderBlockPass() {
		return 1;
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	public void registerBlockIcons(IIconRegister ir) {
		top = ir.registerIcon(Reference.MOD_ID + ":altar_top");
		side = ir.registerIcon(Reference.MOD_ID + ":altar_side");
		bottom = ir.registerIcon(Reference.MOD_ID + ":altar_bottom");
	}

	public IIcon getIcon(int side, int meta) 
	{
		if (side == 0)
		{
			return bottom;
		} 
		else if (side == 1)
		{
			return top;
		} 
		else
		{
			return this.side;
		}
	}
}
