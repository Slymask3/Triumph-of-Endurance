package com.abstractlabs.toe.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;

import com.abstractlabs.toe.creativetab.ToeTab;
import com.abstractlabs.toe.init.ToeBlocks;
import com.abstractlabs.toe.reference.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockBasic extends Block {

	String blockName;
	String blockTexture;
	SoundType blockSound;

	/**
	 * Create a block with the material.
	 * @param material
	 */
	protected BlockBasic(Material p_i45394_1_) {
		super(p_i45394_1_);
	}

	/**
	 * Creates a basic block.
	 * @param material
	 * @param name
	 * @param textureName
	 * @param sound
	 */
	public BlockBasic(Material material, String name, String textureName, SoundType sound){
		super(material);
		this.blockName = name;
		this.blockTexture = textureName;
		this.blockSound = sound;

		this.setBlockName(Reference.MOD_ID + ":" + name);
		this.setCreativeTab(ToeTab.TOE_TAB);
		this.setBlockTextureName(Reference.MOD_ID + textureName);
		this.setStepSound(blockSound);
	}

	@Override
	public boolean canSustainPlant(IBlockAccess world, int x, int y, int z, ForgeDirection direction, IPlantable plantable) {
		if(world.getBlock(x, y, z) == ToeBlocks.hollowDirt){
			return true;
		}
		if(world.getBlock(x, y, z) == ToeBlocks.hollowGrass){
			return true;
		}
		else{
			return false;
		}
	}



	@Override
	public void onPlantGrow(World world, int x, int y, int z, int sourceX, int sourceY, int sourceZ) {
		if (this == ToeBlocks.hollowDirt || this == ToeBlocks.hollowGrass)
		{
			world.setBlock(x, y, z, ToeBlocks.hollowDirt, 0, 2);
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	/**
	 * Registers the Blocks icon in the player GUI inventory.
	 */
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.blockIcon = iconRegister.registerIcon(Reference.MOD_ID + blockTexture);
	}

	@Override
	@SideOnly(Side.CLIENT)
	/**
	 * Gets the Blocks icon in the player GUI inventory.
	 */
	public IIcon getIcon(int side, int meta)
	{
		return blockIcon;
	}

	@Override
	/**
	 * Is block see through.
	 */
	public boolean isOpaqueCube()
	{
		return false;
	}

	@Override
	/**
	 * Returns the items to drop on destruction.
	 */
	public Item getItemDropped(int metadata, Random random, int fortune)
	{
		return Item.getItemFromBlock(ToeBlocks.hollowDirt);
	}

	@Override
	/**
	 * Returns the quantity of items to drop on block destruction.
	 */
	public int quantityDropped(Random random)
	{
		return 1;
	}

	@Override
	@SuppressWarnings("static-access")
	/**
	 * Checks to see if its valid to put this block at the specified coordinates. Args: world, x, y, z
	 */
	public boolean canPlaceBlockAt(World world, int x, int y, int z)
	{
		return world.doesBlockHaveSolidTopSurface(world, x, y - 1, z);
	}
}
