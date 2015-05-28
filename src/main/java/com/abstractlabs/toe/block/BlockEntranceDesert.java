package com.abstractlabs.toe.block;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

import com.abstractlabs.toe.arena.ArenaDesert;
import com.abstractlabs.toe.reference.Color;
import com.abstractlabs.toe.reference.Reference;
import com.abstractlabs.toe.skill.arenalism.ArenalismHelper;
import com.abstractlabs.toe.utility.Helper;
import com.abstractlabs.toe.utility.LogHelper;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockEntranceDesert extends BlockToe implements ITileEntityProvider {
	public static IIcon side;
	public static IIcon other;
	
	public BlockEntranceDesert() {
		super(Material.sand, Block.soundTypeSand, "entranceDesert");
		setHardness(-1);
		setResistance(6000000.0F);
		setLightOpacity(0);
	}
    
	public void registerBlockIcons(IIconRegister ir) {
		side = ir.registerIcon(Reference.MOD_ID + ":entranceDesert");
		other = ir.registerIcon(Reference.MOD_ID + ":exteriorDesert");
	}
	
	@SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        if(side == 0 || side == 1) {
        	return other;
        } else {
        	return this.side;
        }
    }
	
	@SideOnly(Side.CLIENT)
    public int getRenderBlockPass() {
        return 0;
    }
	
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9) {
		if(ArenalismHelper.getProperties(player).inArena()) {
			Helper.msg(player, "You are already in the arena.", Color.red);
        	LogHelper.info("Player is already in the arena.");
        	//return false;
        }
		
		if (player.capabilities.isCreativeMode) {
			Helper.msg(player, "You must be in survival mode to enter the arena.", Color.red);
        	LogHelper.info("Player is in creative mode.");
        	//return false;
        }
		
		if (world.difficultySetting != EnumDifficulty.PEACEFUL) {
			Helper.msg(player, "You must be on at least easy difficulty to enter the arena.", Color.red);
        	LogHelper.info("Player is in peaceful mode.");
        	//return false;
        }
		
		if(doesPlayerHaveItems(player)) {
			Helper.msg(player, "You are not allowed to enter the arena with items.", Color.red);
        	LogHelper.info("Player has items.");
        	//return false;
        }
		
		startArena(world, x, y, z, player);
		
		return true;
    }
	
	public void startArena(World world, int x, int y, int z, EntityPlayer player) {
		//if(!world.isRemote) {
			LogHelper.info("Arena started...");
			
			//ArenaDesert arena = new ArenaDesert(world, x, y, z, player);
			
			ArenaDesert arena = (ArenaDesert) world.getTileEntity(x, y, z);
			
			arena.start(player);
		//}
	}
	
	private boolean doesPlayerHaveItems(EntityPlayer player) {
		InventoryPlayer inv = player.inventory;
		
		for(int i=0; i<inv.getSizeInventory(); i++) {
			if(inv.getStackInSlot(i) != null) {
				LogHelper.info("Found an item.");
				return true;
			}
		}
		
		for(int i=0; i<4; i++) {
			if(inv.armorInventory[i] != null) {
				LogHelper.info("Found armor.");
				return true;
			}
		}
		
		return false;
	}

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		return new ArenaDesert();
	}
}
