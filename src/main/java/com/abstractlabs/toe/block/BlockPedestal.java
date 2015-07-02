package com.abstractlabs.toe.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import com.abstractlabs.toe.creativetab.ToeTab;
import com.abstractlabs.toe.reference.Reference;
import com.abstractlabs.toe.reference.RenderID;
import com.abstractlabs.toe.tileentity.TileEntityPedestal;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockPedestal extends BlockContainer implements ITileEntityProvider {
	private String type;
	
	public BlockPedestal(String type, Material material) {
		super(material);
		this.setCreativeTab(ToeTab.TOE_TAB);
		this.setHardness(3.0F);
		this.setBlockBounds(0.075F, 0.0F, 0.075F, 0.925F, 1.0F, 0.925F);

		if(type.equalsIgnoreCase("stonebrick")) {
			this.setBlockName(Reference.MOD_ID + ":pedestalStonebrick");
			this.setStepSound(Block.soundTypeStone);
		} else if(type.equalsIgnoreCase("planks")) {
			this.setBlockName(Reference.MOD_ID + ":pedestalPlanks");
			this.setStepSound(Block.soundTypeWood);
		} else if(type.equalsIgnoreCase("brick")) {
			this.setBlockName(Reference.MOD_ID + ":pedestalBrick");
			this.setStepSound(Block.soundTypeStone);
		} else if(type.equalsIgnoreCase("quartz")) {
			this.setBlockName(Reference.MOD_ID + ":pedestalQuartz");
			this.setStepSound(Block.soundTypeStone);
		}

		this.type = type;
	}
	
	@SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
		if(type.equalsIgnoreCase("stonebrick")) {
			return Blocks.stonebrick.getIcon(side, 0);
		} else if(type.equalsIgnoreCase("planks")) {
			return Blocks.planks.getIcon(side, 0);
		} else if(type.equalsIgnoreCase("brick")) {
			return Blocks.brick_block.getIcon(side, 0);
		} else if(type.equalsIgnoreCase("quartz")) {
			return Blocks.quartz_block.getIcon(side, 0);
		}
		
		return blockIcon;
    }
	
	public boolean isOpaqueCube() {
        return false;
    }

	public boolean renderAsNormalBlock() {
        return false;
    }

    public int getRenderType() {
        return RenderID.pedestal;
    }
	
	@Override
	public TileEntity createNewTileEntity(World world, int par2) {
		return new TileEntityPedestal(type);
	}
	
	public String getType() {
		return this.type;
	}
}