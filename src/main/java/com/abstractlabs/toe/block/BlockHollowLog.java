package com.abstractlabs.toe.block;

import java.util.List;

import com.abstractlabs.toe.creativetab.ToeTab;
import com.abstractlabs.toe.reference.Reference;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockHollowLog extends BlockLogBase
{
	public static final String[] field_150169_M = new String[] {":log_hollow"};
	@SuppressWarnings("unused")
	private static final String __OBFID = "CL_00000277";

	public BlockHollowLog(String name, String blockTextureName){
		this.setBlockName(Reference.MOD_ID + ":" + name);
		this.setBlockTextureName(blockTextureName);
		this.setCreativeTab(ToeTab.TOE_TAB);
	}

	/**
	 * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item p_149666_1_, CreativeTabs p_149666_2_, List p_149666_3_)
	{
		p_149666_3_.add(new ItemStack(p_149666_1_, 1, 0));
		//p_149666_3_.add(new ItemStack(p_149666_1_, 1, 1));
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister p_149651_1_)
	{
		this.field_150167_a = new IIcon[field_150169_M.length];
		this.field_150166_b = new IIcon[field_150169_M.length];

		for (int i = 0; i < this.field_150167_a.length; ++i)
		{
			this.field_150167_a[i] = p_149651_1_.registerIcon(Reference.MOD_ID + field_150169_M[i]);
			this.field_150166_b[i] = p_149651_1_.registerIcon(Reference.MOD_ID + field_150169_M[i] + "_top");
		}
	}
}
