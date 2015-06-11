package com.abstractlabs.toe.handler;

import net.minecraft.nbt.NBTTagCompound;

import com.abstractlabs.toe.player.ATM;
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

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;


public class PlayerRespawnHandler {
	@SubscribeEvent
	public void onRespawn(PlayerEvent.PlayerRespawnEvent event) {
		NBTTagCompound tag = event.player.getEntityData().getCompoundTag("ToeSkills");
		NBTTagCompound atm = event.player.getEntityData().getCompoundTag("ATM");
		
		SwordsHelper.getProperties(event.player).setLevel(tag.getInteger("SwordsLevel"));
		SwordsHelper.getProperties(event.player).setExperience(tag.getFloat("SwordsExp"));
		
		RangedHelper.getProperties(event.player).setLevel(tag.getInteger("RangedLevel"));
		RangedHelper.getProperties(event.player).setExperience(tag.getFloat("RangedExp"));
		
		MagicHelper.getProperties(event.player).setLevel(tag.getInteger("MagicLevel"));
		MagicHelper.getProperties(event.player).setExperience(tag.getFloat("MagicExp"));
		
		MiningHelper.getProperties(event.player).setLevel(tag.getInteger("MiningLevel"));
		MiningHelper.getProperties(event.player).setExperience(tag.getFloat("MiningExp"));
		
		WoodcuttingHelper.getProperties(event.player).setLevel(tag.getInteger("WoodcuttingLevel"));
		WoodcuttingHelper.getProperties(event.player).setExperience(tag.getFloat("WoodcuttingExp"));
		
		FishingHelper.getProperties(event.player).setLevel(tag.getInteger("FishingLevel"));
		FishingHelper.getProperties(event.player).setExperience(tag.getFloat("FishingExp"));
		
		FarmingHelper.getProperties(event.player).setLevel(tag.getInteger("FarmingLevel"));
		FarmingHelper.getProperties(event.player).setExperience(tag.getFloat("FarmingExp"));
		
		CookingHelper.getProperties(event.player).setLevel(tag.getInteger("CookingLevel"));
		CookingHelper.getProperties(event.player).setExperience(tag.getFloat("CookingExp"));
		
		SmeltingHelper.getProperties(event.player).setLevel(tag.getInteger("SmeltingLevel"));
		SmeltingHelper.getProperties(event.player).setExperience(tag.getFloat("SmeltingExp"));
		
		BrewingHelper.getProperties(event.player).setLevel(tag.getInteger("BrewingLevel"));
		BrewingHelper.getProperties(event.player).setExperience(tag.getFloat("BrewingExp"));
		
		RunemakingHelper.getProperties(event.player).setLevel(tag.getInteger("RunemakingLevel"));
		RunemakingHelper.getProperties(event.player).setExperience(tag.getFloat("RunemakingExp"));
		
		PrayerHelper.getProperties(event.player).setLevel(tag.getInteger("PrayerLevel"));
		PrayerHelper.getProperties(event.player).setExperience(tag.getFloat("PrayerExp"));
		
		SlayerHelper.getProperties(event.player).setLevel(tag.getInteger("SlayerLevel"));
		SlayerHelper.getProperties(event.player).setExperience(tag.getFloat("SlayerExp"));
		
		AgilityHelper.getProperties(event.player).setLevel(tag.getInteger("AgilityLevel"));
		AgilityHelper.getProperties(event.player).setExperience(tag.getFloat("AgilityExp"));
		
		ThievingHelper.getProperties(event.player).setLevel(tag.getInteger("ThievingLevel"));
		ThievingHelper.getProperties(event.player).setExperience(tag.getFloat("ThievingExp"));
		
		ArenalismHelper.getProperties(event.player).setLevel(tag.getInteger("ArenalismLevel"));
		ArenalismHelper.getProperties(event.player).setExperience(tag.getFloat("ArenalismExp"));

		ATM.getProperties(event.player).setCopperCoins(atm.getInteger("CopperCoins"));
		ATM.getProperties(event.player).setSilverCoins(atm.getInteger("SilverCoins"));
		ATM.getProperties(event.player).setGoldCoins(atm.getInteger("GoldCoins"));
	}
}