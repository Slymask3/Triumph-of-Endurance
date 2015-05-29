package com.abstractlabs.toe.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import com.abstractlabs.toe.Toe;
import com.abstractlabs.toe.init.ToeBlocks;
import com.abstractlabs.toe.reference.Color;
import com.abstractlabs.toe.reference.GuiID;
import com.abstractlabs.toe.reference.Reference;
import com.abstractlabs.toe.skill.arenalism.ArenalismHelper;
import com.abstractlabs.toe.structures.ArenaPyramid;
import com.abstractlabs.toe.structures.Shrine;
import com.abstractlabs.toe.utility.Helper;
import com.abstractlabs.toe.utility.LogHelper;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockTester extends BlockToe {
	public static IIcon side;
	
	public BlockTester() {
		super(Material.sponge, Block.soundTypeCloth, "tester");
		setHardness(1);
	}
    
	public void registerBlockIcons(IIconRegister ir) {
		side = ir.registerIcon(Reference.MOD_ID + ":tester");
	}
	
	@SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        return Blocks.brick_block.getIcon(side, meta);
    }
	
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9) {
		Shrine.build(world, x, y, z, Blocks.stonebrick, 0, Blocks.stone_slab, 5, Blocks.stained_glass, 15, Blocks.stained_glass_pane, 15, Blocks.flowing_lava, 0);
		//ArenaPyramid.build(world, x, y, z, Blocks.emerald_block, 0, ToeBlocks.quicksand, 0, Blocks.bedrock, 0, 30);
		
		return true;
	}
}