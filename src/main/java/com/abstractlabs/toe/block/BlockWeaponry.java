package com.abstractlabs.toe.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import com.abstractlabs.toe.Toe;
import com.abstractlabs.toe.creativetab.ToeTab;
import com.abstractlabs.toe.reference.GuiID;
import com.abstractlabs.toe.reference.Reference;
import com.abstractlabs.toe.tileentity.TileEntityWeaponry;

public class BlockWeaponry extends BlockContainer implements ITileEntityProvider {
	private IIcon top;
	private IIcon side;
	
	public BlockWeaponry() {
		super(Material.anvil);
		setCreativeTab(ToeTab.TOE_TAB);
		setBlockName(Reference.MOD_ID + ":weaponry");
		setStepSound(Block.soundTypeAnvil);
		setHardness(-1);
	}
    
	public void registerBlockIcons(IIconRegister ir) {
		top = ir.registerIcon(Reference.MOD_ID + ":weaponry_top");
		side = ir.registerIcon(Reference.MOD_ID + ":weaponry_side");
	}
    
	public IIcon getIcon(int side, int meta) {
		if (side == 0) {
			return Blocks.iron_block.getIcon(side, meta);
		} else if (side == 1) {
			return top;
		} else {
			return this.side;
		}
	}
	
	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		return new TileEntityWeaponry();
	}
	
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9) {
		player.openGui(Toe.instance, GuiID.WEAPONRY.ordinal(), world, x, y, z);
		
		return true;
	}
	
}