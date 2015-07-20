package com.abstractlabs.toe.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import com.abstractlabs.toe.reference.RenderID;
import com.abstractlabs.toe.tileentity.TileEntityStatueBiped;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockStatueBiped extends BlockToe implements ITileEntityProvider {
	public static IIcon side;
	
	public BlockStatueBiped() {
		super(Material.rock, Block.soundTypeStone, "statueBiped");
		setHardness(3.0F);
	}
    
	public void setBlockBoundsBasedOnState(IBlockAccess block, int x, int y, int z) {
        int meta = block.getBlockMetadata(x, y, z);
        
        if(meta == 1 || meta == 3) {
        	setBlockBounds(0.25F, 0.0F, 0.0F, 0.75F, 2.0F, 1.0F);
        } else if(meta == 0 || meta == 2) {
        	setBlockBounds(0.0F, 0.0F, 0.25F, 1.0F, 2.0F, 0.75F);
        }
    }
	
//	public void registerBlockIcons(IIconRegister ir) {
//		side = ir.registerIcon(Reference.MOD_ID + ":statueBiped");
//	}
	
	@SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        return Blocks.stone.getIcon(side, meta);
    }

	public boolean isOpaqueCube() {
        return false;
    }
	
    public boolean renderAsNormalBlock() {
        return false;
    }
	
    public int getRenderType() {
        return RenderID.statueBiped;
    }
	
//	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack is) {
//		int meta = MathHelper.floor_double((double)(entity.rotationYaw * 4.0F / 360.0F) + 2.5D) & 3;
//        world.setBlockMetadataWithNotify(x, y, z, meta, 2);
//		
//		EntityPlayer player = (EntityPlayer) entity;
//		player.openGui(Toe.instance, GuiID.STATUE.ordinal(), world, x, y, z);
//	}
	
//	public static int getDirection(int meta) {
//        return meta & 3;
//    }
	
//	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9) {
//		((TileEntityStatueBiped)world.getTileEntity(x, y, z)).setGameProfile(player.getGameProfile());
//		return true;
//	}

	@Override
	public TileEntity createNewTileEntity(World world, int par2) {
		return new TileEntityStatueBiped();
	}
	
	public int quantityDropped(Random rand) {
		return 0;
    }
}