package com.abstractlabs.toe.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import com.abstractlabs.toe.Toe;
import com.abstractlabs.toe.creativetab.ToeTab;
import com.abstractlabs.toe.reference.Reference;

public class BlockArmoury extends Block 
{
    private IIcon[] icons = new IIcon[6];

    public BlockArmoury() 
    {
        super(Material.iron);

        this.setBlockName(Reference.MOD_ID + "BlockArmoury");
        setCreativeTab(ToeTab.TOE_TAB);
        this.setBlockTextureName(Reference.MOD_ID + ":");
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int metadeta, float what, float these, float are)
    {
    	TileEntity tileEntity = world.getTileEntity(x, y, z);
    	
    	if (tileEntity == null || player.isSneaking())
    	{
    		return false;
    	}
    	
    	player.openGui(Toe.instance, 0, world, x, y, z);
    	
    	return true;
    	/*
        if (!world.isRemote) {
            //System.out.print("block clicked, open gui.\n");
            //System.out.print(Toe.instance != null);
            player.openGui(Toe.instance, BlockArmouryGui.GUI_ID, world, x, y, z);
        }
        return true;
        */
    }

    @Override
    public void registerBlockIcons(IIconRegister reg) 
    {
        for (int i = 0; i < 6; i ++) 
        {
            this.icons[i] = reg.registerIcon(this.textureName + "_" + i);
        }
    }
    
    public TileEntity createNewTileEntity(World world)
    {
    	return new TileEntityBlockArmoury();
    }

    @Override
    public IIcon getIcon(int side, int meta) 
    {
        return this.icons[side];
    }
}