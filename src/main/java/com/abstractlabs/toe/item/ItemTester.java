package com.abstractlabs.toe.item;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Random;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

import com.abstractlabs.toe.init.ToeItems;
import com.abstractlabs.toe.reference.Color;
import com.abstractlabs.toe.reference.Reference;
import com.abstractlabs.toe.utility.Helper;
import com.abstractlabs.toe.utility.LogHelper;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemTester extends ItemToe {
	public IIcon[] icons = new IIcon[2];
	
	public ItemTester() {
		super();
	}
	
	@Override
	public void registerIcons(IIconRegister reg) {
	    for (int i = 0; i < 2; i ++) {
	        this.icons[i] = reg.registerIcon(Reference.MOD_ID + ":testerItem_" + i);
	    }
	}
	
	@SideOnly(Side.CLIENT)
	public boolean isFull3D() {
		return true;
	}
	
	
	@Override
	public IIcon getIconFromDamage(int meta) {
	    if (meta > 1)
	        meta = 0;

	    return this.icons[meta];
	}

	@Override
	public String getUnlocalizedName(ItemStack stack) {
		return this.getUnlocalizedName();// + "_" + state[stack.getItemDamage()];
	}
	
	public ItemStack onItemRightClick(ItemStack is, World world, EntityPlayer player) {
		if(is.stackTagCompound == null){
			is.stackTagCompound = new NBTTagCompound();
		    //LogHelper.info("Wand created. on right click");
		}

        MovingObjectPosition mop = this.getMovingObjectPositionFromPlayer(world, player, true);

        if (mop == null) {
            return is;
        }
        else {
			if (is.getItemDamage() == 0) { //POS 1 SELECTED
	        	ItemStack isn = new ItemStack(ToeItems.tester, 1, 1);
	        	isn.stackTagCompound = new NBTTagCompound();
	        	
//	        	isn.stackTagCompound.setInteger("xc", is.stackTagCompound.getInteger("xc"));
//	        	isn.stackTagCompound.setInteger("yc", is.stackTagCompound.getInteger("yc"));
//	        	isn.stackTagCompound.setInteger("yc", is.stackTagCompound.getInteger("zc"));
	        	isn.stackTagCompound.setInteger("x1", mop.blockX);
	        	isn.stackTagCompound.setInteger("y1", mop.blockY);
	        	isn.stackTagCompound.setInteger("z1", mop.blockZ);
	        	
	        	Helper.msg(player, "Position 1 selected: " + isn.stackTagCompound.getInteger("x1") + ", " + isn.stackTagCompound.getInteger("y1") + ", " + isn.stackTagCompound.getInteger("z1"), Color.lime);
	        	
	        	return isn;
	        } else if (is.getItemDamage() == 1) { //POS 2 SELECTED
	        	ItemStack isn = new ItemStack(ToeItems.tester, 1, 0);
	        	isn.stackTagCompound = new NBTTagCompound();
	        	
//	        	isn.stackTagCompound.setInteger("xc", is.stackTagCompound.getInteger("xc"));
//	        	isn.stackTagCompound.setInteger("yc", is.stackTagCompound.getInteger("yc"));
//	        	isn.stackTagCompound.setInteger("yc", is.stackTagCompound.getInteger("zc"));
	        	isn.stackTagCompound.setInteger("x1", is.stackTagCompound.getInteger("x1"));
	        	isn.stackTagCompound.setInteger("y1", is.stackTagCompound.getInteger("y1"));
	        	isn.stackTagCompound.setInteger("z1", is.stackTagCompound.getInteger("z1"));
	        	isn.stackTagCompound.setInteger("x2", mop.blockX);
	        	isn.stackTagCompound.setInteger("y2", mop.blockY);
	        	isn.stackTagCompound.setInteger("z2", mop.blockZ);
	        	
	        	Helper.msg(player, "Position 2 selected: " + isn.stackTagCompound.getInteger("x2") + ", " + isn.stackTagCompound.getInteger("y2") + ", " + isn.stackTagCompound.getInteger("z2"), Color.lime);

//	        	int xc = isn.stackTagCompound.getInteger("xc");
//	            int yc = isn.stackTagCompound.getInteger("yc");
//	            int zc = isn.stackTagCompound.getInteger("zc");
	        	int x1 = isn.stackTagCompound.getInteger("x1");
	            int y1 = isn.stackTagCompound.getInteger("y1");
	            int z1 = isn.stackTagCompound.getInteger("z1");
	        	int x2 = isn.stackTagCompound.getInteger("x2");
	            int y2 = isn.stackTagCompound.getInteger("y2");
	            int z2 = isn.stackTagCompound.getInteger("z2");
	       
	            
	            if (!world.isRemote) {
	            	createJavaFile(world, player, x1, y1, z1, x2, y2, z2);
	            }
	        	
	            return isn;
	        }
			return is;
        }
    }

	private int toPositive(int i) {
		if (i<0) {
			return -i;
		} else {
			return i;
		}
	}

	private boolean isPositive(int i) {
		if (i<0) {
			return false;
		} else {
			return true;
		}
	}
	
	private void createJavaFile(World world, EntityPlayer player, int x1, int y1, int z1, int x2, int y2, int z2) {
		PrintWriter writer;
		Random rand = new Random();
		try {
			int r = rand.nextInt(1000);
			writer = new PrintWriter("structure_" + r + ".java", "UTF-8");

			//writer.println("generation code:");
			
			int width = toPositive(x2-x1)+1;
			int height = toPositive(y2-y1)+1;
			int length = toPositive(z2-z1)+1;
			
			LogHelper.info(width + ", " + height + ", " + length + " | r == " + r);
			
			for (int x = 0; x < width; x++) {
		        for (int y = 0; y < height; y++) {
		            for (int z = 0; z < length; z++) {
		            	int xn = x1+x;
		            	int yn = y1+y;
		            	int zn = z1+z;
		            	
		            	if(world.getBlock(xn, yn, zn) != Blocks.air) {
		            		writer.println("world.setBlock(x+"+ x +", y+"+ y +", z+"+ z +", "+ world.getBlock(xn, yn, zn).getUnlocalizedName() +", "+ world.getBlockMetadata(xn, yn, zn) +", 2);");
				        }
		            }
		        }
			}
			
			Helper.msgClean(player, "Created java file: 'structure_" + r + ".java'", Color.aqua);
			
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
	}
}
