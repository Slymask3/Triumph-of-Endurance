package com.abstractlabs.toe.block;

import com.abstractlabs.toe.Toe;
import com.abstractlabs.toe.blockgui.BlockArmouryGui;
import com.abstractlabs.toe.creativetab.ToeTab;
import com.abstractlabs.toe.reference.Reference;
import com.abstractlabs.toe.tileentity.TileEntityBlockArmoury;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockArmoury extends Block 
{
    private IIcon[] icons = new IIcon[6];

    public BlockArmoury() 
    {
        super(Material.iron);

        this.setBlockName(Reference.MOD_ID + "BlockArmoury");
        setCreativeTab(ToeTab.TOE_TAB);
        this.setBlockTextureName(Reference.MOD_ID + ":BlockArmoury");
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int metadeta, float what, float these, float are)
    {
    	if (world.isRemote)
    	{
    		return true;
    	}
    	else
    	{
    		Minecraft.getMinecraft().displayGuiScreen(new BlockArmouryGui());
    		return true;
    	}
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