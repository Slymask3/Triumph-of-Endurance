package com.abstractlabs.toe.handler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.IExtendedEntityProperties;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;

import com.abstractlabs.toe.entity.player.ATM;
import com.abstractlabs.toe.entity.player.GrapplingHook;
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
import com.abstractlabs.toe.utility.LogHelper;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class PlayerHandler {
	@SubscribeEvent
	public void onEntityConstructing(EntityConstructing event) {
		if (/*!event.entity.worldObj.isRemote && */event.entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer)event.entity;

			if(SwordsHelper.getProperties((EntityPlayer)event.entity) == null) {
				SwordsHelper.addProperties((EntityPlayer)event.entity);
			} else {
				SwordsHelper.getProperties((EntityPlayer)event.entity).sync();
			}

			if(RangedHelper.getProperties((EntityPlayer)event.entity) == null) {
				RangedHelper.addProperties((EntityPlayer)event.entity);
			} else {
				RangedHelper.getProperties((EntityPlayer)event.entity).sync();
			}

			if(MagicHelper.getProperties((EntityPlayer)event.entity) == null) {
				MagicHelper.addProperties((EntityPlayer)event.entity);
			} else {
				MagicHelper.getProperties((EntityPlayer)event.entity).sync();
			}

			if(MiningHelper.getProperties((EntityPlayer)event.entity) == null) {
				MiningHelper.addProperties((EntityPlayer)event.entity);
			} else {
				MiningHelper.getProperties((EntityPlayer)event.entity).sync();
			}
			
			if(WoodcuttingHelper.getProperties((EntityPlayer)event.entity) == null) {
				WoodcuttingHelper.addProperties((EntityPlayer)event.entity);
			} else {
				WoodcuttingHelper.getProperties((EntityPlayer)event.entity).sync();
			}
			
			if(FishingHelper.getProperties((EntityPlayer)event.entity) == null) {
				FishingHelper.addProperties((EntityPlayer)event.entity);
			} else {
				FishingHelper.getProperties((EntityPlayer)event.entity).sync();
			}

			if(FarmingHelper.getProperties((EntityPlayer)event.entity) == null) {
				FarmingHelper.addProperties((EntityPlayer)event.entity);
			} else {
				FarmingHelper.getProperties((EntityPlayer)event.entity).sync();
			}

			if(CookingHelper.getProperties((EntityPlayer)event.entity) == null) {
				CookingHelper.addProperties((EntityPlayer)event.entity);
			} else {
				CookingHelper.getProperties((EntityPlayer)event.entity).sync();
			}

			if(SmeltingHelper.getProperties((EntityPlayer)event.entity) == null) {
				SmeltingHelper.addProperties((EntityPlayer)event.entity);
			} else {
				SmeltingHelper.getProperties((EntityPlayer)event.entity).sync();
			}

			if(BrewingHelper.getProperties((EntityPlayer)event.entity) == null) {
				BrewingHelper.addProperties((EntityPlayer)event.entity);
			} else {
				BrewingHelper.getProperties((EntityPlayer)event.entity).sync();
			}

			if(RunemakingHelper.getProperties((EntityPlayer)event.entity) == null) {
				RunemakingHelper.addProperties((EntityPlayer)event.entity);
			} else {
				RunemakingHelper.getProperties((EntityPlayer)event.entity).sync();
			}

			if(PrayerHelper.getProperties((EntityPlayer)event.entity) == null) {
				PrayerHelper.addProperties((EntityPlayer)event.entity);
			} else {
				PrayerHelper.getProperties((EntityPlayer)event.entity).sync();
			}

			if(SlayerHelper.getProperties((EntityPlayer)event.entity) == null) {
				SlayerHelper.addProperties((EntityPlayer)event.entity);
			} else {
				SlayerHelper.getProperties((EntityPlayer)event.entity).sync();
			}

			if(AgilityHelper.getProperties((EntityPlayer)event.entity) == null) {
				AgilityHelper.addProperties((EntityPlayer)event.entity);
			} else {
				AgilityHelper.getProperties((EntityPlayer)event.entity).sync();
			}
			
			if(ThievingHelper.getProperties((EntityPlayer)event.entity) == null) {
				ThievingHelper.addProperties((EntityPlayer)event.entity);
			} else {
				ThievingHelper.getProperties((EntityPlayer)event.entity).sync();
			}

			if(ArenalismHelper.getProperties((EntityPlayer)event.entity) == null) {
			    ArenalismHelper.addProperties((EntityPlayer)event.entity);
			} else {
				ArenalismHelper.getProperties((EntityPlayer)event.entity).sync();
			}
			
//			addProperties(SwordsHelper.getProperties(player), player);
//			addProperties(RangedHelper.getProperties(player), player);
//			addProperties(MagicHelper.getProperties(player), player);
//			addProperties(MiningHelper.getProperties(player), player);
//			addProperties(WoodcuttingHelper.getProperties(player), player);
//			addProperties(FishingHelper.getProperties(player), player);
//			addProperties(FarmingHelper.getProperties(player), player);
//			addProperties(CookingHelper.getProperties(player), player);
//			addProperties(SmeltingHelper.getProperties(player), player);
//			addProperties(BrewingHelper.getProperties(player), player);
//			addProperties(RunemakingHelper.getProperties(player), player);
//			addProperties(PrayerHelper.getProperties(player), player);
//			addProperties(SlayerHelper.getProperties(player), player);
//			addProperties(AgilityHelper.getProperties(player), player);
//			addProperties(ThievingHelper.getProperties(player), player);
//			addProperties(ArenalismHelper.getProperties(player), player);
			
			if(ATM.getProperties((EntityPlayer)event.entity) == null) {
				ATM.addProperties((EntityPlayer)event.entity);
			} else {
				ATM.getProperties((EntityPlayer)event.entity).sync();
			}
			
			if(GrapplingHook.getProperties((EntityPlayer)event.entity) == null) {
				GrapplingHook.addProperties((EntityPlayer)event.entity);
			} else {
				GrapplingHook.getProperties((EntityPlayer)event.entity).sync();
			}
			
			LogHelper.info("[PlayerHandler] onEntityConstructing()");
		}
	}
	
	private void addProperties(IExtendedEntityProperties p, EntityPlayer player) {
		if(p == null) {
			if(p instanceof SwordsHelper) {
				((SwordsHelper) p).addProperties(player);
			} else if(p instanceof RangedHelper) {
				((RangedHelper) p).addProperties(player);
			} else if(p instanceof MagicHelper) {
				((MagicHelper) p).addProperties(player);
			} else if(p instanceof MiningHelper) {
				((MiningHelper) p).addProperties(player);
			} else if(p instanceof WoodcuttingHelper) {
				((WoodcuttingHelper) p).addProperties(player);
			} else if(p instanceof FishingHelper) {
				((FishingHelper) p).addProperties(player);
			} else if(p instanceof FarmingHelper) {
				((FarmingHelper) p).addProperties(player);
			} else if(p instanceof CookingHelper) {
				((CookingHelper) p).addProperties(player);
			} else if(p instanceof SmeltingHelper) {
				((SmeltingHelper) p).addProperties(player);
			} else if(p instanceof BrewingHelper) {
				((BrewingHelper) p).addProperties(player);
			} else if(p instanceof RunemakingHelper) {
				((RunemakingHelper) p).addProperties(player);
			} else if(p instanceof PrayerHelper) {
				((PrayerHelper) p).addProperties(player);
			} else if(p instanceof SlayerHelper) {
				((SlayerHelper) p).addProperties(player);
			} else if(p instanceof AgilityHelper) {
				((AgilityHelper) p).addProperties(player);
			} else if(p instanceof ThievingHelper) {
				((ThievingHelper) p).addProperties(player);
			} else if(p instanceof ArenalismHelper) {
				((ArenalismHelper) p).addProperties(player);
			}
		} else {
			if(p instanceof SwordsHelper) {
				((SwordsHelper) p).sync();
			} else if(p instanceof RangedHelper) {
				((RangedHelper) p).sync();
			} else if(p instanceof MagicHelper) {
				((MagicHelper) p).sync();
			} else if(p instanceof MiningHelper) {
				((MiningHelper) p).sync();
			} else if(p instanceof WoodcuttingHelper) {
				((WoodcuttingHelper) p).sync();
			} else if(p instanceof FishingHelper) {
				((FishingHelper) p).sync();
			} else if(p instanceof FarmingHelper) {
				((FarmingHelper) p).sync();
			} else if(p instanceof CookingHelper) {
				((CookingHelper) p).sync();
			} else if(p instanceof SmeltingHelper) {
				((SmeltingHelper) p).sync();
			} else if(p instanceof BrewingHelper) {
				((BrewingHelper) p).sync();
			} else if(p instanceof RunemakingHelper) {
				((RunemakingHelper) p).sync();
			} else if(p instanceof PrayerHelper) {
				((PrayerHelper) p).sync();
			} else if(p instanceof SlayerHelper) {
				((SlayerHelper) p).sync();
			} else if(p instanceof AgilityHelper) {
				((AgilityHelper) p).sync();
			} else if(p instanceof ThievingHelper) {
				((ThievingHelper) p).sync();
			} else if(p instanceof ArenalismHelper) {
				((ArenalismHelper) p).sync();
			}
		}
	}
}