package com.abstractlabs.toe.handler;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

import com.abstractlabs.toe.entity.player.ATM;
import com.abstractlabs.toe.entity.player.Coins;
import com.abstractlabs.toe.entity.player.ToeSkills;
import com.abstractlabs.toe.reference.Color;
import com.abstractlabs.toe.skill.agility.AgilityHelper;
import com.abstractlabs.toe.skill.arenalism.ArenalismHelper;
import com.abstractlabs.toe.skill.brewing.BrewingHelper;
import com.abstractlabs.toe.skill.cooking.CookingHelper;
import com.abstractlabs.toe.skill.farming.FarmingHelper;
import com.abstractlabs.toe.skill.fishing.FishingHelper;
import com.abstractlabs.toe.skill.magic.MagicHelper;
import com.abstractlabs.toe.skill.mining.MiningHelper;
import com.abstractlabs.toe.skill.prayer.PrayerHelper;
import com.abstractlabs.toe.skill.ranged.RangedHelper;
import com.abstractlabs.toe.skill.runemaking.RunemakingHelper;
import com.abstractlabs.toe.skill.slayer.SlayerHelper;
import com.abstractlabs.toe.skill.smelting.SmeltingHelper;
import com.abstractlabs.toe.skill.swords.SwordsHelper;
import com.abstractlabs.toe.skill.theiving.ThievingHelper;
import com.abstractlabs.toe.skill.woodcutting.WoodcuttingHelper;
import com.abstractlabs.toe.utility.Helper;
import com.abstractlabs.toe.utility.LogHelper;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;

public class NBTRespawnHandler {
	private static final Map<EntityPlayer, NBTTagCompound> atmMap = new HashMap<EntityPlayer, NBTTagCompound>();
	private static final Map<EntityPlayer, NBTTagCompound> skillsMap = new HashMap<EntityPlayer, NBTTagCompound>();

	private static final Map<EntityPlayer, ToeSkills> tsMap = new HashMap<EntityPlayer, ToeSkills>();
	private static final Map<EntityPlayer, Coins> coinsMap = new HashMap<EntityPlayer, Coins>();
	
	@SubscribeEvent
	public void onDeath(LivingDeathEvent event) {
		if (!event.entity.worldObj.isRemote && event.entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer)event.entity;
//			NBTTagCompound skillsTag = player.getEntityData().getCompoundTag("ToeSkills");
//			NBTTagCompound atmTag = player.getEntityData().getCompoundTag("ATM");
//			
//			LogHelper.info("[NBTRespawnHandler] onDeath() - Copper == " + atmTag.getInteger("CopperCoins") + " (atmTag)");
//			LogHelper.info("[NBTRespawnHandler] onDeath() - Silver == " + atmTag.getInteger("SilverCoins") + " (atmTag)");
//			LogHelper.info("[NBTRespawnHandler] onDeath() - Gold == " + atmTag.getInteger("GoldCoins") + " (atmTag)");
//
//			skillsMap.put(player, skillsTag);
//			atmMap.put(player, atmTag);
//
//			LogHelper.info("[NBTRespawnHandler] onDeath()");
//
//			LogHelper.info("[NBTRespawnHandler] onDeath() - Copper == " + atmMap.get(player).getInteger("CopperCoins"));
//			LogHelper.info("[NBTRespawnHandler] onDeath() - Silver == " + atmMap.get(player).getInteger("SilverCoins"));
//			LogHelper.info("[NBTRespawnHandler] onDeath() - Gold == " + atmMap.get(player).getInteger("GoldCoins"));
//			
//			LogHelper.info("[NBTRespawnHandler] onDeath() - Copper == " + ATM.getProperties(player).getCopperCoins() + " (props)");
//			LogHelper.info("[NBTRespawnHandler] onDeath() - Silver == " + ATM.getProperties(player).getSilverCoins() + " (props)");
//			LogHelper.info("[NBTRespawnHandler] onDeath() - Gold == " + ATM.getProperties(player).getGoldCoins() + " (props)");
			
			ATM atm = ATM.getProperties(player);
			Coins coins = new Coins(atm.getCopperCoins(), atm.getSilverCoins(), atm.getGoldCoins());
			
			coinsMap.put(player, coins);
			

			SwordsHelper swords = SwordsHelper.getProperties(player);
			RangedHelper ranged = RangedHelper.getProperties(player);
			MagicHelper magic = MagicHelper.getProperties(player);
			MiningHelper mining = MiningHelper.getProperties(player);
			WoodcuttingHelper woodcutting = WoodcuttingHelper.getProperties(player);
			FishingHelper fishing = FishingHelper.getProperties(player);
			FarmingHelper farming = FarmingHelper.getProperties(player);
			CookingHelper cooking = CookingHelper.getProperties(player);
			SmeltingHelper smelting = SmeltingHelper.getProperties(player);
			BrewingHelper brewing = BrewingHelper.getProperties(player);
			RunemakingHelper runemaking = RunemakingHelper.getProperties(player);
			PrayerHelper prayer = PrayerHelper.getProperties(player);
			SlayerHelper slayer = SlayerHelper.getProperties(player);
			AgilityHelper agility = AgilityHelper.getProperties(player);
			ThievingHelper thieving = ThievingHelper.getProperties(player);
			ArenalismHelper arenalism = ArenalismHelper.getProperties(player);
			
			ToeSkills ts = new ToeSkills(swords.getLevel(), swords.getExperience(), 
					ranged.getLevel(), ranged.getExperience(),
					magic.getLevel(), magic.getExperience(),
					mining.getLevel(), mining.getExperience(),
					woodcutting.getLevel(), woodcutting.getExperience(),
					fishing.getLevel(), fishing.getExperience(),
					farming.getLevel(), farming.getExperience(),
					cooking.getLevel(), cooking.getExperience(),
					smelting.getLevel(), smelting.getExperience(),
					brewing.getLevel(), brewing.getExperience(),
					runemaking.getLevel(), runemaking.getExperience(),
					prayer.getLevel(), prayer.getExperience(),
					slayer.getLevel(), slayer.getExperience(),
					agility.getLevel(), agility.getExperience(),
					thieving.getLevel(), thieving.getExperience(),
					arenalism.getLevel(), arenalism.getExperience());
			
			tsMap.put(player, ts);
			
			LogHelper.info("[NBTRespawnHandler] onDeath() - Copper == " + coinsMap.get(player).getCopperCoins() + " (coinsMap)");
			LogHelper.info("[NBTRespawnHandler] onDeath() - Silver == " + coinsMap.get(player).getSilverCoins() + " (coinsMap)");
			LogHelper.info("[NBTRespawnHandler] onDeath() - Gold == " + coinsMap.get(player).getGoldCoins() + " (coinsMap)");
			
			LogHelper.info("[NBTRespawnHandler] onRespawn() - Copper == " + ATM.getProperties(player).getCopperCoins() + " (props)");
			LogHelper.info("[NBTRespawnHandler] onRespawn() - Silver == " + ATM.getProperties(player).getSilverCoins() + " (props)");
			LogHelper.info("[NBTRespawnHandler] onRespawn() - Gold == " + ATM.getProperties(player).getGoldCoins() + " (props)");
		}
	}
	
	@SubscribeEvent
	public void onRespawn(PlayerEvent.PlayerRespawnEvent event) {
		if (!event.player.worldObj.isRemote) {
			EntityPlayer player = (EntityPlayer)event.player;
//			NBTTagCompound skillsTag = skillsMap.get(player);
//			NBTTagCompound atmTag = atmMap.get(player);

//			LogHelper.info("[NBTRespawnHandler] onRespawn() - Copper == " + ATM.getProperties(player).getCopperCoins() + " (props)");
//			LogHelper.info("[NBTRespawnHandler] onRespawn() - Silver == " + ATM.getProperties(player).getSilverCoins() + " (props)");
//			LogHelper.info("[NBTRespawnHandler] onRespawn() - Gold == " + ATM.getProperties(player).getGoldCoins() + " (props)");
			
			if(tsMap.containsKey(player) && coinsMap.containsKey(player)) {
				ToeSkills ts = tsMap.get(player);
				Coins coins = coinsMap.get(player);
				
				SwordsHelper.getProperties(player).setLevel(ts.getSwordsLvl());
				SwordsHelper.getProperties(player).setExperience(ts.getSwordsXP());
				
				RangedHelper.getProperties(player).setLevel(ts.getRangedLvl());
				RangedHelper.getProperties(player).setExperience(ts.getRangedXP());
				
				MagicHelper.getProperties(player).setLevel(ts.getMagicLvl());
				MagicHelper.getProperties(player).setExperience(ts.getMagicXP());
				
				MiningHelper.getProperties(player).setLevel(ts.getMiningLvl());
				MiningHelper.getProperties(player).setExperience(ts.getMiningXP());
				
				WoodcuttingHelper.getProperties(player).setLevel(ts.getWoodcuttingLvl());
				WoodcuttingHelper.getProperties(player).setExperience(ts.getWoodcuttingXP());
				
				FishingHelper.getProperties(player).setLevel(ts.getFishingLvl());
				FishingHelper.getProperties(player).setExperience(ts.getFishingXP());
				
				FarmingHelper.getProperties(player).setLevel(ts.getFarmingLvl());
				FarmingHelper.getProperties(player).setExperience(ts.getFarmingXP());
				
				CookingHelper.getProperties(player).setLevel(ts.getCookingLvl());
				CookingHelper.getProperties(player).setExperience(ts.getCookingXP());
				
				SmeltingHelper.getProperties(player).setLevel(ts.getSmeltingLvl());
				SmeltingHelper.getProperties(player).setExperience(ts.getSmeltingXP());
				
				BrewingHelper.getProperties(player).setLevel(ts.getBrewingLvl());
				BrewingHelper.getProperties(player).setExperience(ts.getBrewingXP());
				
				RunemakingHelper.getProperties(player).setLevel(ts.getRunemakingLvl());
				RunemakingHelper.getProperties(player).setExperience(ts.getRunemakingXP());
				
				PrayerHelper.getProperties(player).setLevel(ts.getPrayerLvl());
				PrayerHelper.getProperties(player).setExperience(ts.getPrayerXP());
				
				SlayerHelper.getProperties(player).setLevel(ts.getSlayerLvl());
				SlayerHelper.getProperties(player).setExperience(ts.getSlayerXP());
				
				AgilityHelper.getProperties(player).setLevel(ts.getAgilityLvl());
				AgilityHelper.getProperties(player).setExperience(ts.getAgilityXP());
				
				ThievingHelper.getProperties(player).setLevel(ts.getThievingLvl());
				ThievingHelper.getProperties(player).setExperience(ts.getThievingXP());
				
				ArenalismHelper.getProperties(player).setLevel(ts.getArenalismLvl());
				ArenalismHelper.getProperties(player).setExperience(ts.getArenalismXP());
	
	//			LogHelper.info("[NBTRespawnHandler] onRespawn() - Copper == " + coinsMap.get(player).getCopperCoins() + " (coinsMap)");
	//			LogHelper.info("[NBTRespawnHandler] onRespawn() - Silver == " + coinsMap.get(player).getSilverCoins() + " (coinsMap)");
	//			LogHelper.info("[NBTRespawnHandler] onRespawn() - Gold == " + coinsMap.get(player).getGoldCoins() + " (coinsMap)");
				
				ATM atm = ATM.getProperties(player);
				atm.setCopperCoins(coins.getCopperCoins());
				atm.setSilverCoins(coins.getSilverCoins());
				atm.setGoldCoins(coins.getGoldCoins());
	
				tsMap.remove(player);
				coinsMap.remove(player);
			} else {
				//This else statement will go through if the player hits 'title screen' when they die instead of respawning.
				Helper.msgClean(player, "There was an error with keeping your skill and atm values.", Color.red);
			}
		}
	}
}