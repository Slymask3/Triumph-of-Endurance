package com.abstractlabs.toe.item;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

import com.abstractlabs.toe.creativetab.ToeTab;
import com.abstractlabs.toe.reference.Reference;

public class ItemToeArmor extends ItemArmor {
	private String set;
	
	public ItemToeArmor(ArmorMaterial material, String set, int type) {
		super(material, 0, type);
		
		String part = "";
		if(type == 0) {
			part = "Helmet";
		} else if(type == 1) {
			part = "Plate";
		} else if(type == 2) {
			part = "Pants";
		} else if(type == 3) {
			part = "Boots";
		}
		
		this.setTextureName(Reference.MOD_ID + ":" + set+part);
		this.setUnlocalizedName(Reference.MOD_ID + ":" + set+part);
		this.setCreativeTab(ToeTab.TOE_TAB);
		this.set = set;
	}
	
	public String getArmorTexture(ItemStack is, Entity entity, int slot, String type) {
		if (slot == 0 || slot == 1 || slot == 3) {
			return Reference.MOD_ID + ":textures/armor/"+set+"1.png";
		} else if(slot == 2) {
			return Reference.MOD_ID + ":textures/armor/"+set+"2.png";
		}
		return null;
	}
	
	public void addInformation(ItemStack is, EntityPlayer player, List list, boolean par4) {
		int max = (is.getMaxDamage()) + 1;
		int dmg = (is.getMaxDamage() - is.getItemDamage()) + 1;
		
		if(set.equalsIgnoreCase("magma")) {
			list.add(EnumChatFormatting.AQUA + "Full Set Bonus:");
			list.add(EnumChatFormatting.AQUA + "- Set enemies that");
			list.add(EnumChatFormatting.AQUA + "hit you on fire.");
			list.add(EnumChatFormatting.AQUA + "- Immune to lava.");
		} else if(set.equalsIgnoreCase("nimble")) {
			list.add(EnumChatFormatting.AQUA + "Full Set Bonus:");
			list.add(EnumChatFormatting.AQUA + "- Speed 1");
		} else if(set.equalsIgnoreCase("dynamic")) {
			list.add(EnumChatFormatting.AQUA + "Full Set Bonus:");
			list.add(EnumChatFormatting.AQUA + "- Jump 1");
		} else if(set.equalsIgnoreCase("spacesuit")) {
			list.add(EnumChatFormatting.AQUA + "Full Set Bonus:");
			list.add(EnumChatFormatting.AQUA + "- Ability to survive");
			list.add(EnumChatFormatting.AQUA + "on moon dimensions.");
		}
		
		list.add(EnumChatFormatting.GREEN + "Durability: " + dmg + "/" + max);
	}
}