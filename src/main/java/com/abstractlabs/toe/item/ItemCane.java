package com.abstractlabs.toe.item;

import java.util.HashMap;
import java.util.List;

import sun.security.krb5.Config;

import com.abstractlabs.toe.Toe;
import com.abstractlabs.toe.creativetab.ToeTab;
import com.abstractlabs.toe.handler.EntityHandler;
import com.abstractlabs.toe.init.ToeItems;
import com.abstractlabs.toe.reference.Reference;
import com.abstractlabs.toe.utility.LogHelper;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

import cpw.mods.fml.common.eventhandler.Event;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IChatComponent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

public class ItemCane extends ItemSword
{
	private static HashMap<EntityPlayer, Integer> map = new HashMap<EntityPlayer, Integer>();
	
	private float weaponDamage;
	
	public ItemCane(String unlocalizedName, ToolMaterial material)
	{
		super(material);
		this.setUnlocalizedName(unlocalizedName);
		this.setTextureName(Reference.MOD_ID + ":" + unlocalizedName);
		this.setCreativeTab(ToeTab.TOE_TAB);
		this.weaponDamage = 1.0F;
	}
	
	@Override
	public boolean hitEntity(ItemStack itemStack, EntityLivingBase elb, EntityLivingBase elb2)
    {
		itemStack.damageItem(1, elb);
		return true;
    }
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean boo)
	{
		list.add("Stacks: " + ItemCane.getStacks(player));
	}
	
	public static void addPlayer(ItemStack is, EntityPlayer player, int stacks)
	{
		map.put(player, stacks);
	}
	
	public static void update(EntityPlayer player, int stacks)
	{
		if (map.containsKey(player))
		{
			map.put(player, stacks);
		}
		else
		{
			LogHelper.info("Doesnt contatin player");
		}
	}
	
	public static void removePlayer(EntityPlayer player, int stacks)
	{
		if (map.containsKey(player))
		{
			map.remove(player);
		}
		else
		{
			LogHelper.info("Doesnt contatin player");
		}
	}
	
	public static int getStacks(EntityPlayer player)
	{
		if (map.containsKey(player))
		{
			return map.get(player);
		}
		else
		{
			LogHelper.info("Doesnt contatin player");
			return 0;
		}
	}
	
	public static boolean playerExists(EntityPlayer player)
	{
		if (map.containsKey(player))
		{
			return true;
		}
		else
		{
			LogHelper.info("Player doesnt exist");
			return false;
		}
	}
	
	@Override
	public Multimap getItemAttributeModifiers()
	{
		EntityPlayer player = Minecraft.getMinecraft().thePlayer;
		
		Multimap multimap = HashMultimap.create();
		multimap.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(field_111210_e, "Weapon modifier", (double)this.weaponDamage + (ItemCane.getStacks(player) / 10), 0));
		LogHelper.info("2 dmg added");
		
		return multimap;
	}
}
