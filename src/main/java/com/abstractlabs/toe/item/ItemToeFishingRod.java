package com.abstractlabs.toe.item;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import com.abstractlabs.toe.entity.projectile.EntityFishingRodHook;
import com.abstractlabs.toe.reference.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemToeFishingRod extends ItemToe {
    @SideOnly(Side.CLIENT)
    private IIcon castIcon;

    private boolean wooden;
    
    public ItemToeFishingRod(String name, int dmg) {
    	this.setUnlocalizedName(name);
        this.setTextureName(Reference.MOD_ID+":"+name);
        this.setMaxDamage(dmg);
        this.setMaxStackSize(1);
        
        if(name.equalsIgnoreCase("fishingRodWood")) {
        	wooden = true;
        } else {
        	wooden = false;
        }
    }

    @SideOnly(Side.CLIENT)
    public boolean isFull3D() {
        return true;
    }

    @SideOnly(Side.CLIENT)
    public boolean shouldRotateAroundWhenRendering() {
        return true;
    }

    public ItemStack onItemRightClick(ItemStack is, World world, EntityPlayer player) {
        if (player.fishEntity != null) {
            int i = player.fishEntity.func_146034_e();
            is.damageItem(i, player);
            player.swingItem();
        } else {
        	world.playSoundAtEntity(player, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

            if (!world.isRemote) {
            	world.spawnEntityInWorld(new EntityFishingRodHook(world, player));
            }

            player.swingItem();
        }
        
        return is;
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister ir) {
    	if(wooden) {
    		this.itemIcon = ir.registerIcon("fishing_rod_uncast");
            this.castIcon = ir.registerIcon("fishing_rod_cast");
    	} else {
            this.itemIcon = ir.registerIcon(this.getIconString()+"_uncast");
            this.castIcon = ir.registerIcon(this.getIconString()+"_cast");
    	}
    }
    
    @SideOnly(Side.CLIENT)
    public IIcon getCastIcon() {
        return this.castIcon;
    }
    
    @SideOnly(Side.CLIENT)
    public IIcon getUncastIcon() {
        return this.itemIcon;
    }

    public boolean isItemTool(ItemStack is) {
        return super.isItemTool(is);
    }

    public int getItemEnchantability() {
        return 1;
    }
}