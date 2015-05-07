package com.abstractlabs.toe.item;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

import com.abstractlabs.toe.creativetab.ToeTab;
import com.abstractlabs.toe.init.ToeItems;
import com.abstractlabs.toe.reference.Reference;

public class ItemMagmaArmour extends ItemArmor
{
	public String textureName;

	public ItemMagmaArmour(String unlocalizedName, ArmorMaterial material, String textureName, int type) 
	{
		super(material, 0, type);
		this.textureName = textureName;
		this.setUnlocalizedName(unlocalizedName);
		this.setTextureName(Reference.MOD_ID + ":" + unlocalizedName);
		this.setCreativeTab(ToeTab.TOE_TAB);
	}

	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) 
	{

		if (stack.getItem() == ToeItems.magmaHelmet || stack.getItem() == ToeItems.magmaPlate || stack.getItem() == ToeItems.magmaBoots) 
		{
			return Reference.MOD_ID + ":textures/armour/magmaArmour1.png";
		}
		else if(stack.getItem() == ToeItems.magmaPants)
		{
			return Reference.MOD_ID + ":textures/armour/magmaArmour2.png";
		}
		else
		{
			return null;
		}
	}
}
