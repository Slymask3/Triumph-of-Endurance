package com.abstractlabs.toe.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import com.abstractlabs.toe.reference.Color;
import com.abstractlabs.toe.reference.Reference;
import com.abstractlabs.toe.skill.arenalism.ArenalismHelper;
import com.abstractlabs.toe.utility.Helper;
import com.abstractlabs.toe.utility.LogHelper;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockCash extends BlockToe {
	public static IIcon side;
	
	public BlockCash() {
		super(Material.sponge, Block.soundTypeCloth, "cash");
		setHardness(1);
	}
    
	public void registerBlockIcons(IIconRegister ir) {
		side = ir.registerIcon(Reference.MOD_ID + ":cash");
	}
	
	@SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        return this.side;
    }
	
	public int quantityDropped(Random random) {
        return 0;
    }
	
	//clientsided. need to find a work around for serverside. will probably just use an event.
//	public void onBlockDestroyedByPlayer(World world, int x, int y, int z, int meta) {
//		EntityPlayer player = Minecraft.getMinecraft().thePlayer;
//		
//		if(ArenalismHelper.getProperties(player).inArena() && !world.isRemote) {
//			Random rand = new Random();
//			int amount = rand.nextInt(20)+1;
//			
//			ArenalismHelper.getProperties(player).updateCash(ArenalismHelper.getProperties(player).getCash() + amount);
//			Helper.msgClean(player, "You gained $" + amount + " from breaking the cash block.", Color.lime);
//			LogHelper.info("added $10");
//		}
//	}
}