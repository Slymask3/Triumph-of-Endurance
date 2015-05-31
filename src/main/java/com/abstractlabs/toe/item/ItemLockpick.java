package com.abstractlabs.toe.item;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.common.DimensionManager;

import com.abstractlabs.toe.reference.Color;
import com.abstractlabs.toe.reference.Reference;
import com.abstractlabs.toe.utility.Helper;

public class ItemLockpick extends ItemToe {
	public ItemLockpick(int maxdmg) {
		super();
		this.maxStackSize = 1;
		this.setMaxDamage(maxdmg);
	}
	
	public ItemStack onItemRightClick(ItemStack is, World world, EntityPlayer player) {
        
        
        return is;
    }
	
	public void addInformation(ItemStack is, EntityPlayer player, List list, boolean par4) {
		//might add some info later
	}
}