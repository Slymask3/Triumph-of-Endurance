package com.abstractlabs.toe.block;

import org.lwjgl.opengl.GL11;

import com.abstractlabs.toe.Toe;
import com.abstractlabs.toe.reference.Reference;
import com.google.common.base.Strings;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class BlockArmoury extends BlockContainer
{
	protected BlockArmoury()
	{
		super(Material.rock);
	}

	@SideOnly(Side.CLIENT)
	private IIcon top;
	@SideOnly(Side.CLIENT)
	private IIcon front;
	@SideOnly(Side.CLIENT)
	private IIcon bottom;
	
	int guiWidth = 148;
	int guiHeight = 80;
	
	public void registerBlockIcons(IIconRegister ir)
	{
		this.front = ir.registerIcon(Reference.MOD_ID + ":ArmouryFront");
		this.top = ir.registerIcon(Reference.MOD_ID + ":ArmouryTop");
		this.blockIcon = ir.registerIcon(Reference.MOD_ID + ":ArmourySide");
	}
	
	public IIcon getIcon(int side, int meta)
	{
		if (side == 1)
		{
			return top;
		}
		else if (side == 3)
		{
			return front;
		}
		else
		{
			return this.blockIcon;
		}
	}
	
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9) 
	{
		player.openGui(Toe.instance, 0, world, x, y, z);
		return true;
	}

	public TileEntity createNewTileEntity(World world, int par2)
	{
		return new TileEntity();
	}
	
	@SideOnly(Side.CLIENT)
	public void onBlockAdded(World world, int x, int y, int z)
	{
		super.onBlockAdded(world, x, y, z);
		this.direction(world, x, y, z);
	}
	
	private void direction(World world, int x, int y, int z) 
	{
		
	}
}
