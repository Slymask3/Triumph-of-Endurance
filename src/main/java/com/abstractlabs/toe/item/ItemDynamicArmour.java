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

public class ItemDynamicArmour extends ItemArmor
{
	public String textureName;
	
	public PotionEffect pf;

	public ItemDynamicArmour(String unlocalizedName, ArmorMaterial material, String textureName, int type) 
	{
		super(material, 0, type);
		this.textureName = textureName;
		this.setUnlocalizedName(unlocalizedName);
		this.setTextureName(Reference.MOD_ID + ":" + unlocalizedName);
		this.setCreativeTab(ToeTab.TOE_TAB);
	}

	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) 
	{
		if (stack.getItem() == ToeItems.dynamicHelmet || stack.getItem() == ToeItems.dynamicPlate || stack.getItem() == ToeItems.dynamicBoots) 
		{
			return Reference.MOD_ID + ":textures/armor/dynamicArmor1.png";
		}
		else if(stack.getItem() == ToeItems.dynamicPants)
		{
			return Reference.MOD_ID + ":textures/armor/dynamicArmor2.png";
		}
		else
		{
			return null;
		}
	}
	
	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) 
	{	
		if (player.getCurrentArmor(0) != null && player.getCurrentArmor(0).getItem().equals(ToeItems.dynamicBoots) && 
				player.getCurrentArmor(1) != null && player.getCurrentArmor(1).getItem().equals(ToeItems.dynamicPants) &&
				player.getCurrentArmor(2) != null && player.getCurrentArmor(2).getItem().equals(ToeItems.dynamicPlate) &&
				player.getCurrentArmor(3) != null && player.getCurrentArmor(3).getItem().equals(ToeItems.dynamicHelmet))
		{
			player.addPotionEffect(new PotionEffect(Potion.jump.id, 40));
		}
	}

}