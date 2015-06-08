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
	//private float weaponDamage;
	
	public ItemCane(String unlocalizedName, ToolMaterial material) {
		super(material);
		this.setUnlocalizedName(unlocalizedName);
		this.setTextureName(Reference.MOD_ID + ":" + unlocalizedName);
		this.setCreativeTab(ToeTab.TOE_TAB);
		//this.weaponDamage = 1.0F;
	}
	
	public void onUpdate(ItemStack is, World world, Entity entity, int par4, boolean par5) {
		if (is.stackTagCompound == null) {
			is.stackTagCompound = new NBTTagCompound();
		    is.stackTagCompound.setInteger("stacks", 0);
		}
		
//		EntityPlayer player = (EntityPlayer) entity;
		
//		if(player.getHeldItem() != null && player.getHeldItem().getItem() == this) {
////			EntityScorpion e = new EntityScorpion(world);
////			Helper.createEntity(e, 0, 10, 0);
////			entity.mountEntity(e);
////			LogHelper.info("mounted");
//			//player.setInvisible(true);
//			int x = (int) Math.floor(player.posX);
//			int y = (int) Math.floor(player.posY);
//			int z = (int) Math.floor(player.posZ);
////			world.getBlock(x, y, z).setLightLevel(1);
////			world.getBlock(x, y+1, z).setLightLevel(1);
////			world.setBlock(x, y-2, z, Blocks.glowstone);
//			if(!world.isRemote && world.getBlock(x, y-1, z) == Blocks.water) {
//				world.setBlock(x+1, y-1, z+1, Blocks.ice);
//				world.setBlock(x+1, y-1, z, Blocks.ice);
//				world.setBlock(x+1, y-1, z-1, Blocks.ice);
//				world.setBlock(x, y-1, z+1, Blocks.ice);
//				world.setBlock(x, y-1, z, Blocks.ice);
//				world.setBlock(x, y-1, z-1, Blocks.ice);
//				world.setBlock(x-1, y-1, z+1, Blocks.ice);
//				world.setBlock(x-1, y-1, z, Blocks.ice);
//				world.setBlock(x-1, y-1, z-1, Blocks.ice);
//				LogHelper.info("iced");
//			}
//			
//		} else {
//			//player.setInvisible(false);
////			int x = (int) player.posX;
////			int y = (int) player.posY;
////			int z = (int) player.posZ;
////			world.getBlock(x, y, z).setLightLevel(0);
////			world.getBlock(x, y+1, z).setLightLevel(0);
//		}
	}
	
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
			multimap.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(field_111210_e, "Weapon modifier", 1 + (stacks / 10), 0));
		}
		
		return multimap;
	}
}
