package com.abstractlabs.toe.item;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.common.util.EnumHelper;

import com.abstractlabs.toe.creativetab.ToeTab;
import com.abstractlabs.toe.reference.Reference;
import com.abstractlabs.toe.utility.Helper;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemLunarBlade extends ItemToeSword {
	private IIcon activeIcon;
	
	public ItemLunarBlade() {
		super(EnumHelper.addToolMaterial("Lunar", 3, 500, 3, 4, 10));
		this.setCreativeTab(ToeTab.TOE_TAB);
		this.setTextureName(Reference.MOD_ID+":lunarBlade");
	}
	
	public void onUpdate(ItemStack is, World world, Entity entity, int par4, boolean par5) {
		if (is.stackTagCompound == null) {
			is.stackTagCompound = new NBTTagCompound();
		    is.stackTagCompound.setBoolean("nighttime", false);
		} else if(is.stackTagCompound != null) {
			if(!is.stackTagCompound.getBoolean("nighttime") && Helper.isNight(world)) {
				is.stackTagCompound.setBoolean("nighttime", true);
			} else if(is.stackTagCompound.getBoolean("nighttime") && Helper.isDay(world)) {
			    is.stackTagCompound.setBoolean("nighttime", false);
			}
		}
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean boo) {
		if (stack.stackTagCompound != null) {
			boolean isNight = stack.stackTagCompound.getBoolean("nighttime");
			String secret = isNight ? EnumChatFormatting.GREEN + "On" : EnumChatFormatting.RED + "Off";

			list.add(EnumChatFormatting.GOLD + "Passive Description: Gains +6");
			list.add(EnumChatFormatting.GOLD + "damage during the night.");
			list.add(EnumChatFormatting.AQUA + "Passive: " + secret);
		}
	}
	
	@Override
	public Multimap getAttributeModifiers(ItemStack stack) {
		Multimap multimap = HashMultimap.create();
		
		if (stack.stackTagCompound != null) {
			boolean nighttime = stack.stackTagCompound.getBoolean("nighttime");
			int dmg = 4;
			if(nighttime) {
				dmg = 10;
			}
			multimap.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(field_111210_e, "Weapon modifier", dmg, 0));
		}
		
		return multimap;
	}
	
	@SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister ir) {
        this.itemIcon = ir.registerIcon(this.getIconString());
        this.activeIcon = ir.registerIcon(this.getIconString()+"_active");
    }
    
    @SideOnly(Side.CLIENT)
    public IIcon getInactiveIcon() {
        return this.itemIcon;
    }
    
    @SideOnly(Side.CLIENT)
    public IIcon getActiveIcon() {
        return this.activeIcon;
    }
}