package com.abstractlabs.toe.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import com.abstractlabs.toe.Toe;
import com.abstractlabs.toe.creativetab.ToeTab;
import com.abstractlabs.toe.reference.GuiID;
import com.abstractlabs.toe.reference.Reference;
import com.abstractlabs.toe.tileentity.TileEntityATM;

public class BlockATM extends BlockContainer implements ITileEntityProvider {
	public BlockATM() {
		super(Material.anvil);
		setCreativeTab(ToeTab.TOE_TAB);
		setBlockName(Reference.MOD_ID + ":atm");
		setStepSound(Block.soundTypeAnvil);
		setHardness(3.0F);
		setResistance(5.0F);
	}
	
	public boolean isOpaqueCube() {
        return false;
    }

	public boolean renderAsNormalBlock() {
        return false;
    }

    public int getRenderType() {
        return 7356;
    }
	
	public static int getDirection(int meta) {
        return meta & 3;
    }
	
	public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLivingBase par5EntityLiving, ItemStack par6ItemStack) {
        int meta = MathHelper.floor_double((double)(par5EntityLiving.rotationYaw * 4.0F / 360.0F) + 2.5D) & 3;
        par1World.setBlockMetadataWithNotify(par2, par3, par4, meta, 2);
    }
	
	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		return new TileEntityATM();
	}
	
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9) {
		player.openGui(Toe.instance, GuiID.ATM.ordinal(), world, x, y, z);
		
		return true;
	}
	
//	public void setBlockBoundsForItemRender() {
//        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
//    }
	
}