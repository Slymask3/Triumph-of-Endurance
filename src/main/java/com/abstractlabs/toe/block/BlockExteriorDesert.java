package com.abstractlabs.toe.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import com.abstractlabs.toe.reference.Color;
import com.abstractlabs.toe.reference.Reference;
import com.abstractlabs.toe.utility.Helper;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockExteriorDesert extends BlockToe {
	public static IIcon side;
	
	public BlockExteriorDesert() {
		super(Material.sand, Block.soundTypeSand, "exteriorDesert");
		setHardness(-1);
		setResistance(6000000.0F);
		setLightOpacity(0);
	}
    
	public void registerBlockIcons(IIconRegister ir) {
		side = ir.registerIcon(Reference.MOD_ID + ":exteriorDesert");
	}
	
	@SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        return this.side;
    }
	
	@SideOnly(Side.CLIENT)
    public int getRenderBlockPass() {
        return 0;
    }
	
	public void onBlockClicked(World world, int x, int y, int z, EntityPlayer player) {
		Random random = new Random();
		if(world.isRemote && random.nextInt(10) == 0) { //if client world and will only go throguh 1 every 10 times
			Helper.msg(player, "These blocks aren't breaking, maybe there is another way..", Color.lime);
		}
	}
}