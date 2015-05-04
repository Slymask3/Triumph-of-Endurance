package com.abstractlabs.toe.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import com.abstractlabs.toe.Toe;
import com.abstractlabs.toe.creativetab.ToeTab;
import com.abstractlabs.toe.gui.BlockArmouryGui;
import com.abstractlabs.toe.reference.GuiID;
import com.abstractlabs.toe.reference.Reference;
import com.abstractlabs.toe.tileentity.TileEntityBlockArmoury;
import com.abstractlabs.toe.tileentity.TileEntityUtility;

public class BlockUtility extends BlockContainer implements ITileEntityProvider
{
	private IIcon top;
	private IIcon bottom;
	private IIcon side;

    public BlockUtility() 
    {
    	super(Material.anvil);
		setCreativeTab(ToeTab.TOE_TAB);
		setBlockName(Reference.MOD_ID + ":utility");
		setStepSound(Block.soundTypeAnvil);
		setHardness(-1);
		setResistance(6000000.0F);
    }

    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int metadeta, float what, float these, float are)
    {
    	player.openGui(Toe.instance, GuiID.UTILITY.ordinal(), world, x, y, z);
    	
    	return true;
    }

    public void registerBlockIcons(IIconRegister ir) 
    {
		top = ir.registerIcon(Reference.MOD_ID + ":utility_top");
		bottom = ir.registerIcon(Reference.MOD_ID + ":shop_bottom");
		side = ir.registerIcon(Reference.MOD_ID + ":shop_side");
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

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_)
	{
		return new TileEntityUtility();
	}
}