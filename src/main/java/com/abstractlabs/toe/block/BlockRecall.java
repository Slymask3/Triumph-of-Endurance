package com.abstractlabs.toe.block;


import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import com.abstractlabs.toe.Toe;
import com.abstractlabs.toe.init.ToeItems;
import com.abstractlabs.toe.reference.Color;
import com.abstractlabs.toe.reference.GuiID;
import com.abstractlabs.toe.reference.Reference;
import com.abstractlabs.toe.tileentity.TileEntityRecall;
import com.abstractlabs.toe.utility.Helper;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockRecall extends BlockToe implements ITileEntityProvider {
	public static IIcon side;
	
	public BlockRecall() {
		super(Material.circuits, Block.soundTypeMetal, "recall");
		setHardness(3);
		setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
	}
    
	public void registerBlockIcons(IIconRegister ir) {
		side = ir.registerIcon(Reference.MOD_ID + ":recall");
	}
	
	@SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        return Blocks.beacon.getIcon(side, meta);
    }
	
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack is) {
		EntityPlayer player = (EntityPlayer) entity;
		player.openGui(Toe.instance, GuiID.RECALL.ordinal(), world, x, y, z);
	}
	
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9) {
		if(player.getHeldItem() != null && player.getHeldItem().getItem() == ToeItems.recall) {
			ItemStack is = player.getHeldItem();
			TileEntityRecall te = (TileEntityRecall) world.getTileEntity(x, y, z);
			if (is.stackTagCompound == null) {
				is.stackTagCompound = new NBTTagCompound();
			    is.stackTagCompound.setInteger("dim", world.provider.dimensionId);
			    is.stackTagCompound.setInteger("x", x);
			    is.stackTagCompound.setInteger("y", y);
			    is.stackTagCompound.setInteger("z", z);;
			    is.stackTagCompound.setString("name", te.getName());
			    
			    Helper.msg(player, "Connected this teleporter to the destination: " + te.getName() + ".", Color.lime);
			}
		}
		
		return true;
	}

	@Override
	public TileEntity createNewTileEntity(World world, int par2) {
		return new TileEntityRecall();
	}
}