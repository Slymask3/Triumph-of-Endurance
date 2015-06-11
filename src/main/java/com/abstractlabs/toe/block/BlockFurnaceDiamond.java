package com.abstractlabs.toe.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import com.abstractlabs.toe.Toe;
import com.abstractlabs.toe.creativetab.ToeTab;
import com.abstractlabs.toe.init.ToeBlocks;
import com.abstractlabs.toe.reference.GuiID;
import com.abstractlabs.toe.reference.Reference;
import com.abstractlabs.toe.reference.Smelting;
import com.abstractlabs.toe.tileentity.TileEntityFurnaceDiamond;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockFurnaceDiamond extends BlockContainer {
	private final Random random = new Random();
    private final boolean isLit;
    private static boolean field_149934_M;
    
    @SideOnly(Side.CLIENT)
    private IIcon top;
    @SideOnly(Side.CLIENT)
    private IIcon front;
    @SideOnly(Side.CLIENT)
    private IIcon side;

    public BlockFurnaceDiamond(boolean lit) {
        super(Material.rock);
        this.isLit = lit;
        if(!lit) {
        	this.setCreativeTab(ToeTab.TOE_TAB);
        }
		this.setBlockName(Reference.MOD_ID + ":" + "furnaceDiamond");
    }
	
    public int getRenderType() {
        return Smelting.furnaceRenderID_Iron;
    }

    public Item getItemDropped(int par1, Random random, int par3) {
        return Item.getItemFromBlock(ToeBlocks.furnaceDiamond);
    }
    
    public void onBlockAdded(World world, int x, int y, int z) {
        super.onBlockAdded(world, x, y, z);
        this.setBlockMetadata(world, x, y, z);
    }

    private void setBlockMetadata(World world, int x, int y, int z) {
        if (!world.isRemote) {
            Block block = world.getBlock(x, y, z - 1);
            Block block1 = world.getBlock(x, y, z + 1);
            Block block2 = world.getBlock(x - 1, y, z);
            Block block3 = world.getBlock(x + 1, y, z);
            byte b0 = 3;

            if (block.func_149730_j() && !block1.func_149730_j()) {
                b0 = 3;
            }

            if (block1.func_149730_j() && !block.func_149730_j()) {
                b0 = 2;
            }

            if (block2.func_149730_j() && !block3.func_149730_j()) {
                b0 = 5;
            }

            if (block3.func_149730_j() && !block2.func_149730_j()) {
                b0 = 4;
            }

            world.setBlockMetadataWithNotify(x, y, z, b0, 2);
        }
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        return side == 1 ? this.top : (side == 0 ? this.top : (side != meta ? this.blockIcon : this.front));
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister ir) {
        this.blockIcon = ir.registerIcon(Reference.MOD_ID+":"+"furnaceDiamond_side");
        this.front = ir.registerIcon(this.isLit ? Reference.MOD_ID+":"+"furnaceDiamond_front_on" : Reference.MOD_ID+":"+"furnaceDiamond_front_off");
        this.top = ir.registerIcon(Reference.MOD_ID+":"+"furnaceDiamond_top");
    }

    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
        if (world.isRemote) {
            return true;
        } else {
            TileEntityFurnaceDiamond tileentityfurnace = (TileEntityFurnaceDiamond)world.getTileEntity(x, y, z);

            if (tileentityfurnace != null) {
            	player.openGui(Toe.instance, GuiID.FURNACE_DIAMOND.ordinal(), world, x, y, z);
            }
            return true;
        }
    }

    public static void updateFurnaceBlockState(boolean lit, World world, int x, int y, int z) {
        int l = world.getBlockMetadata(x, y, z);
        TileEntity tileentity = world.getTileEntity(x, y, z);
        field_149934_M = true;

        if (lit) {
        	world.setBlock(x, y, z, ToeBlocks.furnaceDiamondLit);
        } else {
        	world.setBlock(x, y, z, ToeBlocks.furnaceDiamond);
        }

        field_149934_M = false;
        world.setBlockMetadataWithNotify(x, y, z, l, 2);

        if (tileentity != null) {
            tileentity.validate();
            world.setTileEntity(x, y, z, tileentity);
        }
    }

    public TileEntity createNewTileEntity(World world, int par2) {
        return new TileEntityFurnaceDiamond();
    }

    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack is) {
        int l = MathHelper.floor_double((double)(entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

        if (l == 0) {
            world.setBlockMetadataWithNotify(x, y, z, 2, 2);
        }

        if (l == 1) {
        	world.setBlockMetadataWithNotify(x, y, z, 5, 2);
        }

        if (l == 2) {
        	world.setBlockMetadataWithNotify(x, y, z, 3, 2);
        }

        if (l == 3) {
        	world.setBlockMetadataWithNotify(x, y, z, 4, 2);
        }

        if (is.hasDisplayName()) {
            ((TileEntityFurnaceDiamond)world.getTileEntity(x, y, z)).setCustomName(is.getDisplayName());
        }
    }

    public void breakBlock(World world, int x, int y, int z, Block block, int par6) {
        if (!field_149934_M) {
        	TileEntityFurnaceDiamond tileentityfurnace = (TileEntityFurnaceDiamond)world.getTileEntity(x, y, z);

            if (tileentityfurnace != null) {
                for (int i1 = 0; i1 < tileentityfurnace.getSizeInventory(); ++i1) {
                    ItemStack itemstack = tileentityfurnace.getStackInSlot(i1);

                    if (itemstack != null) {
                        float f = this.random.nextFloat() * 0.8F + 0.1F;
                        float f1 = this.random.nextFloat() * 0.8F + 0.1F;
                        float f2 = this.random.nextFloat() * 0.8F + 0.1F;

                        while (itemstack.stackSize > 0) {
                            int j1 = this.random.nextInt(21) + 10;

                            if (j1 > itemstack.stackSize) {
                                j1 = itemstack.stackSize;
                            }

                            itemstack.stackSize -= j1;
                            EntityItem entityitem = new EntityItem(world, (double)((float)x + f), (double)((float)y + f1), (double)((float)z + f2), new ItemStack(itemstack.getItem(), j1, itemstack.getItemDamage()));

                            if (itemstack.hasTagCompound()) {
                                entityitem.getEntityItem().setTagCompound((NBTTagCompound)itemstack.getTagCompound().copy());
                            }

                            float f3 = 0.05F;
                            entityitem.motionX = (double)((float)this.random.nextGaussian() * f3);
                            entityitem.motionY = (double)((float)this.random.nextGaussian() * f3 + 0.2F);
                            entityitem.motionZ = (double)((float)this.random.nextGaussian() * f3);
                            world.spawnEntityInWorld(entityitem);
                        }
                    }
                }
                world.func_147453_f(x, y, z, block);
            }
        }

        super.breakBlock(world, x, y, z, block, par6);
    }

    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World world, int x, int y, int z, Random random) {
        if (this.isLit) {
            int l = world.getBlockMetadata(x, y, z);
            float f = (float)x + 0.5F;
            float f1 = (float)y + 0.0F + random.nextFloat() * 6.0F / 16.0F;
            float f2 = (float)z + 0.5F;
            float f3 = 0.52F;
            float f4 = random.nextFloat() * 0.6F - 0.3F;

            if (l == 4) {
                world.spawnParticle("smoke", (double)(f - f3), (double)f1, (double)(f2 + f4), 0.0D, 0.0D, 0.0D);
                world.spawnParticle("flame", (double)(f - f3), (double)f1, (double)(f2 + f4), 0.0D, 0.0D, 0.0D);
            } else if (l == 5) {
            	world.spawnParticle("smoke", (double)(f + f3), (double)f1, (double)(f2 + f4), 0.0D, 0.0D, 0.0D);
            	world.spawnParticle("flame", (double)(f + f3), (double)f1, (double)(f2 + f4), 0.0D, 0.0D, 0.0D);
            } else if (l == 2) {
            	world.spawnParticle("smoke", (double)(f + f4), (double)f1, (double)(f2 - f3), 0.0D, 0.0D, 0.0D);
            	world.spawnParticle("flame", (double)(f + f4), (double)f1, (double)(f2 - f3), 0.0D, 0.0D, 0.0D);
            } else if (l == 3) {
            	world.spawnParticle("smoke", (double)(f + f4), (double)f1, (double)(f2 + f3), 0.0D, 0.0D, 0.0D);
            	world.spawnParticle("flame", (double)(f + f4), (double)f1, (double)(f2 + f3), 0.0D, 0.0D, 0.0D);
            }
        }
    }

    public boolean hasComparatorInputOverride() {
        return true;
    }

    public int getComparatorInputOverride(World world, int x, int y, int z, int par5) {
        return Container.calcRedstoneFromInventory((IInventory)world.getTileEntity(x, y, z));
    }

    @SideOnly(Side.CLIENT)
    public Item getItem(World world, int x, int y, int z) {
        return Item.getItemFromBlock(ToeBlocks.furnaceDiamond);
    }
}