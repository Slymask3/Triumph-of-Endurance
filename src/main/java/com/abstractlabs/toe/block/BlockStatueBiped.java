package com.abstractlabs.toe.block;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import com.abstractlabs.toe.reference.Reference;
import com.abstractlabs.toe.tileentity.TileEntityStatueBiped;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockStatueBiped extends BlockToe implements ITileEntityProvider {
	public static IIcon side;
	
	public BlockStatueBiped() {
		super(Material.rock, Block.soundTypeStone, "statueBiped");
		setHardness(1);
        setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 1.0F);
	}
    
	public void registerBlockIcons(IIconRegister ir) {
		side = ir.registerIcon(Reference.MOD_ID + ":statueBiped");
	}
	
	@SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        return Blocks.air.getIcon(side, meta);
    }

	public boolean isOpaqueCube() {
        return false;
    }
	
    public boolean renderAsNormalBlock() {
        return false;
    }
	
    public int getRenderType() {
        return -1;
    }

	@Override
	public TileEntity createNewTileEntity(World world, int par2) {
		return new TileEntityStatueBiped();
	}
	
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9) {
		((TileEntityStatueBiped)world.getTileEntity(x, y, z)).setGameProfile(player.getGameProfile());
		return true;
	}
}