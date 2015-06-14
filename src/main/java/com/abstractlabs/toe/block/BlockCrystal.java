package com.abstractlabs.toe.block;

import java.util.Random;

import com.abstractlabs.toe.creativetab.ToeTab;
import com.abstractlabs.toe.init.ToeBlocks;
import com.abstractlabs.toe.reference.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.BlockGlass;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.Facing;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockCrystal extends BlockGlass {
	private IIcon side;
	
	public BlockCrystal() {
		super(Material.glass, false);
		setCreativeTab(ToeTab.TOE_TAB);
		setBlockName(Reference.MOD_ID + ":crystalBlock");
		setStepSound(Block.soundTypeGlass);
		setHardness(0.3F);
	}
	
	public void registerBlockIcons(IIconRegister ir) {
		side = ir.registerIcon(Reference.MOD_ID + ":crystalBlock");
	}
	
	@SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        return this.side;
    }
	
	@SideOnly(Side.CLIENT)
    public int getRenderBlockPass() {
        return 1;
    }
	
	public int quantityDropped(Random random) {
        return 1;
    }
}