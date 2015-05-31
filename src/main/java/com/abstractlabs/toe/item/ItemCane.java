package com.abstractlabs.toe.item;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

import com.abstractlabs.toe.creativetab.ToeTab;
import com.abstractlabs.toe.reference.Reference;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

public class ItemCane extends ItemSword {
	//private static HashMap<EntityPlayer, Integer> map = new HashMap<EntityPlayer, Integer>();
	
	private float weaponDamage;
	
	public ItemCane(String unlocalizedName, ToolMaterial material) {
		super(material);
		this.setUnlocalizedName(unlocalizedName);
		this.setTextureName(Reference.MOD_ID + ":" + unlocalizedName);
		this.setCreativeTab(ToeTab.TOE_TAB);
		this.weaponDamage = 1.0F;
	}
	
	public void onUpdate(ItemStack is, World world, Entity entity, int par4, boolean par5) {
	    //LogHelper.info("stackTagCompound == " + is.stackTagCompound);
		if (is.stackTagCompound == null) {
			is.stackTagCompound = new NBTTagCompound();
		    is.stackTagCompound.setInteger("stacks", 0);
		    //LogHelper.info("cane created on update..");
		}
	}
	
//	@Override
//	public void onCreated(ItemStack itemStack, World world, EntityPlayer player) {
//	    itemStack.stackTagCompound = new NBTTagCompound();
//	    itemStack.stackTagCompound.setInteger("stacks", 0);
//	    
//	    LogHelper.info("cane created..");
//	}
	
	@Override
	public boolean hitEntity(ItemStack itemStack, EntityLivingBase elb, EntityLivingBase elb2) {
		itemStack.damageItem(1, elb);
		return true;
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
			multimap.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(field_111210_e, "Weapon modifier", (double)this.weaponDamage + (stacks / 10), 0));
		}
		
		return multimap;
	}
	
//	public static void addPlayer(ItemStack is, EntityPlayer player, int stacks) {
//		map.put(player, stacks);
//	}
//	
//	public static void update(EntityPlayer player, int stacks)
//	{
//		if (map.containsKey(player))
//		{
//			map.put(player, stacks);
//		}
//		else
//		{
//			LogHelper.info("Doesnt contatin player");
//		}
//	}
//	
//	public static void removePlayer(EntityPlayer player, int stacks)
//	{
//		if (map.containsKey(player))
//		{
//			map.remove(player);
//		}
//		else
//		{
//			LogHelper.info("Doesnt contatin player");
//		}
//	}
//	
//	public static int getStacks(EntityPlayer player)
//	{
//		if (map.containsKey(player))
//		{
//			return map.get(player);
//		}
//		else
//		{
//			LogHelper.info("Doesnt contatin player");
//			return 0;
//		}
//	}
//	
//	public static boolean playerExists(EntityPlayer player)
//	{
//		if (map.containsKey(player))
//		{
//			return true;
//		}
//		else
//		{
//			LogHelper.info("Player doesnt exist");
//			return false;
//		}
//	}
}
