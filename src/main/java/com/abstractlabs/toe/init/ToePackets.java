package com.abstractlabs.toe.init;

import com.abstractlabs.toe.skill.agility.AgilityPacket;
import com.abstractlabs.toe.skill.arenalism.ArenalismPacket;
import com.abstractlabs.toe.skill.brewing.BrewingPacket;
import com.abstractlabs.toe.skill.cooking.CookingPacket;
import com.abstractlabs.toe.skill.farming.FarmingPacket;
import com.abstractlabs.toe.skill.fishing.FishingPacket;
import com.abstractlabs.toe.skill.magic.MagicPacket;
import com.abstractlabs.toe.skill.mining.MiningPacket;
import com.abstractlabs.toe.skill.prayer.PrayerPacket;
import com.abstractlabs.toe.skill.ranged.RangedPacket;
import com.abstractlabs.toe.skill.runemaking.RunemakingPacket;
import com.abstractlabs.toe.skill.slayer.SlayerPacket;
import com.abstractlabs.toe.skill.smelting.SmeltingPacket;
import com.abstractlabs.toe.skill.swords.SwordsPacket;
import com.abstractlabs.toe.skill.theiving.ThievingPacket;
import com.abstractlabs.toe.skill.woodcutting.WoodcuttingPacket;

import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;

public class ToePackets {
	public static SimpleNetworkWrapper network;
  
	public static void init() {
	     network = NetworkRegistry.INSTANCE.newSimpleChannel("ToeSkills");
	     network.registerMessage(SwordsPacket.Handler.class, SwordsPacket.class, 0, Side.CLIENT);
	     network.registerMessage(RangedPacket.Handler.class, RangedPacket.class, 1, Side.CLIENT);
	     network.registerMessage(MagicPacket.Handler.class, MagicPacket.class, 2, Side.CLIENT);
	     network.registerMessage(MiningPacket.Handler.class, MiningPacket.class, 3, Side.CLIENT);
	     network.registerMessage(WoodcuttingPacket.Handler.class, WoodcuttingPacket.class, 4, Side.CLIENT);
	     network.registerMessage(FishingPacket.Handler.class, FishingPacket.class, 5, Side.CLIENT);
	     network.registerMessage(FarmingPacket.Handler.class, FarmingPacket.class, 6, Side.CLIENT);
	     network.registerMessage(CookingPacket.Handler.class, CookingPacket.class, 7, Side.CLIENT);
	     network.registerMessage(SmeltingPacket.Handler.class, SmeltingPacket.class, 8, Side.CLIENT);
	     network.registerMessage(BrewingPacket.Handler.class, BrewingPacket.class, 9, Side.CLIENT);
	     network.registerMessage(RunemakingPacket.Handler.class, RunemakingPacket.class, 10, Side.CLIENT);
	     network.registerMessage(PrayerPacket.Handler.class, PrayerPacket.class, 11, Side.CLIENT);
	     network.registerMessage(SlayerPacket.Handler.class, SlayerPacket.class, 12, Side.CLIENT);
	     network.registerMessage(AgilityPacket.Handler.class, AgilityPacket.class, 13, Side.CLIENT);
	     network.registerMessage(ThievingPacket.Handler.class, ThievingPacket.class, 14, Side.CLIENT);
	     network.registerMessage(ArenalismPacket.Handler.class, ArenalismPacket.class, 15, Side.CLIENT);
	}
}