package com.abstractlabs.toe.block;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSapling;
import net.minecraft.block.IGrowable;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;

import com.abstractlabs.toe.creativetab.ToeTab;
import com.abstractlabs.toe.init.ToeBlocks;
import com.abstractlabs.toe.reference.Reference;
import com.abstractlabs.toe.world.gen.structure.WorldGenEffectTree;
import com.abstractlabs.toe.world.gen.structure.WorldGenForestHollowTree;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockHollowSapling extends BlockSapling implements IGrowable
{
	private static String[] saplings;
	private IIcon[] textures;
	private static final int TYPES = 1;

	private static WorldGenerator tree;
	private static WorldGenerator treeHollow;
	private static WorldGenerator effectTree;

	public BlockHollowSapling(String blockName, String textureName)
	{
		// Set tree size.
		treeHollow = new WorldGenForestHollowTree(true);
		//tree = new WorldGenForestTrees(true);
		effectTree = new WorldGenEffectTree(true);
		this.setHardness(0.0F);
		this.setStepSound(Block.soundTypeGrass);
		this.setCreativeTab(ToeTab.TOE_TAB);
		this.setBlockName(Reference.MOD_ID + ":" + blockName);
		this.setBlockTextureName(textureName);
		saplings = new String[] { textureName + "_Sapling" };
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		textures = new IIcon[saplings.length];
		for (int i = 0; i < saplings.length; ++i)
		{
			textures[i] = iconRegister.registerIcon("tutorial:" + saplings[i]);
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta)
	{
		if (meta < 0 || meta >= saplings.length)
		{
			meta = 0;
		}
		return textures[meta];
	}

	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void getSubBlocks(Item block, CreativeTabs creativeTabs, List list)
	{
		for (int i = 0; i < saplings.length; ++i)
		{
			list.add(new ItemStack(block, 1, i));
		}
	}

	public boolean isValidPosition(World world, int x, int y, int z, int metadata)
	{
		Block block = world.getBlock(x, y - 1, z);
		switch (metadata)
		{
		default:
			return block == ToeBlocks.hollowGrass || block == ToeBlocks.hollowDirt || block.canSustainPlant(world, x, y - 1, z, ForgeDirection.UP, this);
		}
	}

	@Override
	public boolean canPlaceBlockOnSide(World world, int x, int y, int z, int side)
	{
		return isValidPosition(world, x, y, z, -1);
	}

	@Override
	public boolean canBlockStay(World world, int x, int y, int z)
	{
		Block soil = world.getBlock(x, y - 1, z);

		if (world.getBlockMetadata(x, y, z) != 7)
			return (world.getFullBlockLightValue(x, y, z) >= 8 || world.canBlockSeeTheSky(x, y, z)) &&
					(soil != null && soil.canSustainPlant(world, x, y - 1, z, ForgeDirection.UP, this));
		else
			return (world.getFullBlockLightValue(x, y, z) >= 8 || world.canBlockSeeTheSky(x, y, z)) &&
					(soil != null && soil.canSustainPlant(world, x, y - 1, z, ForgeDirection.UP, this));
	}

	@Override
	public void updateTick(World world, int x, int y, int z, Random random)
	{
		if (world.isRemote)
			return;

		if (world.getBlockLightValue(x, y + 1, z) >= 9 && random.nextInt(7) == 0)
		{
			this.func_149878_d(world, x, y, z, random);
		}
	}

	@Override
	public void func_149878_d(World world, int x, int y, int z, Random random)
	{
		int meta = world.getBlockMetadata(x, y, z) & TYPES;
		Object obj = null;
		int rnd = random.nextInt(10);

		if (obj == null) {
			if (rnd < 5) {
				obj = tree;
			}
			if (rnd >= 5) {
				obj = treeHollow;
			}
			if (rnd == 12) {
				obj = effectTree;
			}
		}
		if (obj != null)
		{
			world.setBlockToAir(x, y, z);

			if (!((WorldGenerator) obj).generate(world, random, x, y, z))
			{
				world.setBlock(x, y, z, this, meta, 2);
			}
		}
	}

	@Override
	public boolean canSustainPlant(IBlockAccess world, int x, int y, int z, ForgeDirection direction, IPlantable plantable) {
		if (world.getBlock(x, y, z) == ToeBlocks.hollowDirt) {
			return true;
		}
		if (world.getBlock(x, y, z) == ToeBlocks.hollowGrass) {
			return true;
		}
		else {
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
}
