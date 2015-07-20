package com.abstractlabs.toe.item;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

import com.abstractlabs.toe.creativetab.ToeTab;
import com.abstractlabs.toe.init.ToeMaterials;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

public class ItemCane extends ItemToeSword {
	public ItemCane() {
		super(ToeMaterials.caneTool);
		this.setCreativeTab(ToeTab.TOE_TAB);
	}
	
	public void onUpdate(ItemStack is, World world, Entity entity, int par4, boolean par5) {
		if (is.stackTagCompound == null) {
			is.stackTagCompound = new NBTTagCompound();
		    is.stackTagCompound.setInteger("stacks", 0);
		}
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean boo) {
		if (stack.stackTagCompound != null) {
			int stacks = stack.stackTagCompound.getInteger("stacks");
			list.add(EnumChatFormatting.GOLD + "Stacks: " + stacks);
		}
	}
	
	@Override
	public Multimap getAttributeModifiers(ItemStack stack) {
		Multimap multimap = HashMultimap.create();
		
		if (stack.stackTagCompound != null) {
			int stacks = stack.stackTagCompound.getInteger("stacks");
			multimap.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(field_111210_e, "Weapon modifier", 1 + (stacks / 10), 0));
		}
		
		return multimap;
	}
}
