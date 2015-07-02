package com.abstractlabs.toe.handler;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraftforge.event.world.BlockEvent;

import com.abstractlabs.toe.init.ToeBlocks;
import com.abstractlabs.toe.reference.Color;
import com.abstractlabs.toe.skill.arenalism.ArenalismHelper;
import com.abstractlabs.toe.utility.Helper;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class BlockHandler {
	@SubscribeEvent
	public void onBreak(BlockEvent.BreakEvent e) {
		EntityPlayer player = e.getPlayer();
		Block block = e.block;
		World world = e.world;
		int x = e.x;
		int y = e.y;
		int z = e.z;
		
		if(ArenalismHelper.getProperties(player).inArena() && !e.world.isRemote) { //if the player is in an arena && if its serverside (used for better random)
			if(block == ToeBlocks.cash) { //if the block breaking is the cash block
				ArenalismHelper helper = ArenalismHelper.getProperties(player);
				Random random = new Random();
				int amount = random.nextInt(20)+1;
				
				helper.updateCash(helper.getCash() + amount);
				Helper.msgClean(player, "You got $" + amount + " from breaking the cash block!", Color.gold);
			}
		}
	}
	
	@SubscribeEvent
	public void onHarvest(BlockEvent.HarvestDropsEvent e) {
		EntityPlayer player = e.harvester;
		Block block = e.block;
		World world = e.world;
		int x = e.x;
		int y = e.y;
		int z = e.z;
		
		if(block == ToeBlocks.glassWater) {
			Random rand = new Random();
			int i = rand.nextInt(5);
			
			//LogHelper.info(i);
			
			if(i == 0) {
				e.drops.clear();
				world.setBlock(x, y, z, Blocks.water);
			}
		}
		
		if(block == ToeBlocks.glassLava) {
			Random rand = new Random();
			int i = rand.nextInt(5);
			
			//LogHelper.info(i);
			
			if(i == 0) {
				e.drops.clear();
				world.setBlock(x, y, z, Blocks.lava);
			}
		}
	}
}