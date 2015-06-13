package com.abstractlabs.toe.handler.skill;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.event.world.BlockEvent;

import com.abstractlabs.toe.init.ToeBlocks;
import com.abstractlabs.toe.init.ToeItems;
import com.abstractlabs.toe.reference.Color;
import com.abstractlabs.toe.skill.woodcutting.WoodcuttingHelper;
import com.abstractlabs.toe.utility.Helper;
import com.abstractlabs.toe.utility.LogHelper;

import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class WoodcuttingHandler {
	@SubscribeEvent(priority=EventPriority.NORMAL, receiveCanceled=true)
	public void onHarvest(BlockEvent.HarvestDropsEvent e) {
		if(e.harvester != null) {
			LogHelper.info("[WoodcuttingHelper] onHarvest() - " + e.block.getLocalizedName());
			
			EntityPlayer player = e.harvester;
			Block block = e.block;
			World world = e.world;
			int x = e.x;
			int y = e.y;
			int z = e.z;
			
			WoodcuttingHelper woodcutting = WoodcuttingHelper.getProperties(player);
			
			//Tool XP Boost
			float boost = 1.00F;
			if(player.getHeldItem() != null) {
				Item tool = player.getHeldItem().getItem();
				
				if(tool == Items.wooden_pickaxe || tool == ToeItems.woodAxepick || tool == ToeItems.woodAxepick_pick) {
					boost = 1.01F;
				} else if(tool == Items.stone_axe || tool == ToeItems.stoneAxepick || tool == ToeItems.stoneAxepick_pick) {
					boost = 1.02F;
				} else if(tool == Items.iron_axe || tool == ToeItems.ironAxepick || tool == ToeItems.ironAxepick_pick) {
					boost = 1.05F;
				} else if(tool == Items.golden_axe || tool == ToeItems.goldAxepick || tool == ToeItems.goldAxepick_pick) {
					boost = 2.00F;
				} else if(tool == Items.diamond_axe || tool == ToeItems.diamondAxepick || tool == ToeItems.diamondAxepick_pick) {
					boost = 1.10F;
				} else if(tool == Items.shears) {
					boost = 2.00F;
				}
			}
			
			//XP
			if(block == Blocks.log || block == Blocks.log2) {
				woodcutting.addExperience(5*boost);
			} else if(block == Blocks.leaves || block == Blocks.leaves2) {
				woodcutting.addExperience(1*boost);
			} else if(block == ToeBlocks.hollowLog) {
				woodcutting.addExperience(10*boost);
			} else if(block == ToeBlocks.hollowLeaf) {
				woodcutting.addExperience(2*boost);
			}
			
			//Reward Drops
			Random rand = new Random();
			int lvl = WoodcuttingHelper.getProperties(player).getLevel();
			int r = rand.nextInt(200)-lvl;
			
			if(block == Blocks.log || block == Blocks.log2 || block == Blocks.leaves || block == Blocks.leaves2 || block == ToeBlocks.hollowLog || block == ToeBlocks.hollowLeaf) {
				if(lvl >= 1) {
					if(r==0) {
						e.drops.add(new ItemStack(ToeItems.coinCopper, 1, 0));
					}
				}
				if(lvl >=10) {
					if(r==1) {
						e.drops.add(new ItemStack(ToeItems.coinSilver, 1, 0));
					}
				}
				if(lvl >=50) {
					if(r==2) {
						e.drops.add(new ItemStack(ToeItems.coinGold, 1, 0));
					}
				}
			}
			
			//Timber Axe
			if(player.getHeldItem() != null && player.getHeldItem().getItem() == ToeItems.timberAxe) {
//				if(lvl < 50) {
//					Helper.msg(player, "You can only use this axe at level 50 woodcutting.", Color.red);
//					e.setCanceled(true);
//				}
				
				if((block == Blocks.log || block == Blocks.log2) && (world.getBlock(x,y-1,z) == Blocks.grass || world.getBlock(x,y-1,z) == Blocks.dirt)) {
					harvestFullTreeVanilla(world, x, y, z, block, e.blockMetadata, player);
				} else if((block == ToeBlocks.hollowLog) && (world.getBlock(x,y-1,z) == ToeBlocks.hollowGrass || world.getBlock(x,y-1,z) == ToeBlocks.hollowDirt)) {
					harvestFullTree(world, x, y, z, block, player);
				}
			}
		}
	}
	
	@SubscribeEvent
	public void onBreak(BlockEvent.BreakEvent e) {
		if(e.getPlayer() != null) {
			EntityPlayer player = e.getPlayer();
			int lvl = WoodcuttingHelper.getProperties(player).getLevel();
			
			//Timber Axe
			if(player.getHeldItem() != null && player.getHeldItem().getItem() == ToeItems.timberAxe) {
				if(lvl < 50) {
					Helper.msgClean(player, "You can only use this axe at level 50 woodcutting.", Color.red);
					e.setCanceled(true);
				}
			}
		}
	}

	private synchronized void harvestFullTree(World world, int x, int y, int z, Block block, EntityPlayer player) {
		Random rand = new Random();
		
		Block b1 = world.getBlock(x+1, y, z);
		Block b2 = world.getBlock(x-1, y, z);
		Block b3 = world.getBlock(x, y+1, z);
		Block b4 = world.getBlock(x, y-1, z);
		Block b5 = world.getBlock(x, y, z+1);
		Block b6 = world.getBlock(x, y, z-1);
		int m1 = world.getBlockMetadata(x+1, y, z);
		int m2 = world.getBlockMetadata(x-1, y, z);
		int m3 = world.getBlockMetadata(x, y+1, z);
		int m4 = world.getBlockMetadata(x, y-1, z);
		int m5 = world.getBlockMetadata(x, y, z+1);
		int m6 = world.getBlockMetadata(x, y, z-1);
		
		breakAndDropBlock(world, x, y, z, block, new ItemStack(Item.getItemFromBlock(block)), player);
		
		if(block == b1) {
			harvestFullTree(world, x+1, y, z, block, player);
		}
		if(block == b2) {
			harvestFullTree(world, x-1, y, z, block, player);
		}
		if(block == b3) {
			harvestFullTree(world, x, y+1, z, block, player);
		}
		if(block == b4) {
			harvestFullTree(world, x, y-1, z, block, player);
		}
		if(block == b5) {
			harvestFullTree(world, x, y, z+1, block, player);
		}
		if(block == b6) {
			harvestFullTree(world, x, y, z-1, block, player);
		}
	}
	
	private synchronized void harvestFullTreeVanilla(World world, int x, int y, int z, Block block, int meta, EntityPlayer player) {
		Random rand = new Random();
		
		Block b1 = world.getBlock(x+1, y, z);
		Block b2 = world.getBlock(x-1, y, z);
		Block b3 = world.getBlock(x, y+1, z);
		Block b4 = world.getBlock(x, y-1, z);
		Block b5 = world.getBlock(x, y, z+1);
		Block b6 = world.getBlock(x, y, z-1);
		int m1 = world.getBlockMetadata(x+1, y, z);
		int m2 = world.getBlockMetadata(x-1, y, z);
		int m3 = world.getBlockMetadata(x, y+1, z);
		int m4 = world.getBlockMetadata(x, y-1, z);
		int m5 = world.getBlockMetadata(x, y, z+1);
		int m6 = world.getBlockMetadata(x, y, z-1);
		
		breakAndDropBlockVanilla(world, x, y, z, block, meta, player);
		
		if(block == b1) {
			harvestFullTreeVanilla(world, x+1, y, z, block, m1, player);
		}
		if(block == b2) {
			harvestFullTreeVanilla(world, x-1, y, z, block, m2, player);
		}
		if(block == b3) {
			harvestFullTreeVanilla(world, x, y+1, z, block, m3, player);
		}
		if(block == b4) {
			harvestFullTreeVanilla(world, x, y-1, z, block, m4, player);
		}
		if(block == b5) {
			harvestFullTreeVanilla(world, x, y, z+1, block, m5, player);
		}
		if(block == b6) {
			harvestFullTreeVanilla(world, x, y, z-1, block, m6, player);
		}
	}
	
	private void breakAndDropBlock(World world, int x, int y, int z, Block mainBlock, ItemStack is, EntityPlayer player) {
		if(world.getBlock(x, y, z) == mainBlock) {
			world.setBlock(x, y, z, Blocks.air);
			world.spawnEntityInWorld(new EntityItem(world, x, y, z, is));
			
			if(mainBlock == Blocks.log || mainBlock == Blocks.log2) {
				WoodcuttingHelper.getProperties(player).addExperience(5);
			} else if(mainBlock == ToeBlocks.hollowLog) {
				WoodcuttingHelper.getProperties(player).addExperience(10);
			}
			
			LogHelper.info("Found a log part of the tree, destorying and dropping it.");
		}
	}
	
	private void breakAndDropBlockVanilla(World world, int x, int y, int z, Block mainBlock, int meta, EntityPlayer player) {
		if(world.getBlock(x, y, z) == mainBlock) {
			ItemStack is = null;
			
			if(meta == 0 || meta == 4 || meta == 8 || meta == 12) {
				is = new ItemStack(Item.getItemFromBlock(mainBlock), 1, 0);
			} else if(meta == 1 || meta == 5 || meta == 9 || meta == 13) {
				is = new ItemStack(Item.getItemFromBlock(mainBlock), 1, 1);
			} else if(meta == 2 || meta == 6 || meta == 10 || meta == 14) {
				is = new ItemStack(Item.getItemFromBlock(mainBlock), 1, 2);
			} else if(meta == 3 || meta == 7 || meta == 11 || meta == 15) {
				is = new ItemStack(Item.getItemFromBlock(mainBlock), 1, 3);
			}
			
			world.setBlock(x, y, z, Blocks.air);
			world.spawnEntityInWorld(new EntityItem(world, x, y, z, is));
			
			if(mainBlock == Blocks.log || mainBlock == Blocks.log2) {
				WoodcuttingHelper.getProperties(player).addExperience(5);
			} else if(mainBlock == ToeBlocks.hollowLog) {
				WoodcuttingHelper.getProperties(player).addExperience(10);
			}
			
			LogHelper.info("Found a log part of the tree, destorying and dropping it.");
		}
	}
}