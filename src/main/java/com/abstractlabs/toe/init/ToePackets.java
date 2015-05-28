package com.abstractlabs.toe.init;

import com.abstractlabs.toe.skill.arenalism.ArenalismPacket;
import com.abstractlabs.toe.skill.mining.MiningPacket;
import com.abstractlabs.toe.skill.woodcutting.WoodcuttingPacket;

import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;

public class ToePackets {
	public static SimpleNetworkWrapper network;
  
	public static void init() {
	     network = NetworkRegistry.INSTANCE.newSimpleChannel("ToeSkills");
	     network.registerMessage(MiningPacket.Handler.class, MiningPacket.class, 0, Side.CLIENT);
	     network.registerMessage(ArenalismPacket.Handler.class, ArenalismPacket.class, 1, Side.CLIENT);
	     network.registerMessage(WoodcuttingPacket.Handler.class, WoodcuttingPacket.class, 2, Side.CLIENT);
	}
}