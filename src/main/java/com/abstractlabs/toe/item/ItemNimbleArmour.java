package com.abstractlabs.toe.item;

import java.util.HashMap;
import java.util.Iterator;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

import com.abstractlabs.toe.creativetab.ToeTab;
import com.abstractlabs.toe.init.ToeItems;
import com.abstractlabs.toe.reference.Reference;

public class ItemNimbleArmour extends ItemArmor
{
	public String textureName;
	
	public PotionEffect pf;

	public ItemNimbleArmour(String unlocalizedName, ArmorMaterial material, String textureName, int type) 
	{
		super(material, 0, type);
		this.textureName = textureName;
		this.setUnlocalizedName(unlocalizedName);
		this.setTextureName(Reference.MOD_ID + ":" + unlocalizedName);
		this.setCreativeTab(ToeTab.TOE_TAB);
	}

	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) 
	{
		if (stack.getItem() == ToeItems.nimbleHelmet || stack.getItem() == ToeItems.nimblePlate || stack.getItem() == ToeItems.nimbleBoots) 
		{
			return Reference.MOD_ID + ":textures/armour/nimbleArmour1.png";
		}
		else if(stack.getItem() == ToeItems.nimblePants)
		{
			return Reference.MOD_ID + ":textures/armour/nimbleArmour2.png";
		}
		else
		{
			return null;
		}
	}
	
	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) 
	{	
		if (player.getCurrentArmor(0) != null && player.getCurrentArmor(0).getItem().equals(ToeItems.nimbleBoots) && 
				player.getCurrentArmor(1) != null && player.getCurrentArmor(1).getItem().equals(ToeItems.nimblePants) &&
				player.getCurrentArmor(2) != null && player.getCurrentArmor(2).getItem().equals(ToeItems.nimblePlate) &&
				player.getCurrentArmor(3) != null && player.getCurrentArmor(3).getItem().equals(ToeItems.nimbleHelmet))
		{
			player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 40));
		}
	}

}
