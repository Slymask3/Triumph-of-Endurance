package com.abstractlabs.toe.handler.skill;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.block.BlockRedstoneOre;
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
import com.abstractlabs.toe.skill.mining.MiningHelper;
import com.abstractlabs.toe.utility.Helper;
import com.abstractlabs.toe.utility.LogHelper;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class MiningHandler {
	@SubscribeEvent
	public void onHarvest(BlockEvent.HarvestDropsEvent e) {
		if(e.harvester != null && e.harvester.getHeldItem() != null) {
			EntityPlayer player = e.harvester;
			Block block = e.block;
			World world = e.world;
			int x = e.x;
			int y = e.y;
			int z = e.z;
			
			MiningHelper mining = MiningHelper.getProperties(player);
			
			if(!e.isSilkTouching) {
				//Tool XP Boost
				Item tool = player.getHeldItem().getItem();
				float boost = 1.00F;
				
				if(tool == Items.wooden_pickaxe || tool == ToeItems.woodAxepick) {
					boost = 1.01F;
				} else if(tool == Items.stone_pickaxe || tool == ToeItems.stoneAxepick) {
					boost = 1.02F;
				} else if(tool == Items.iron_pickaxe || tool == ToeItems.ironAxepick) {
					boost = 1.05F;
				} else if(tool == Items.golden_pickaxe || tool == ToeItems.goldAxepick) {
					boost = 2.00F;
				} else if(tool == Items.diamond_pickaxe || tool == ToeItems.diamondAxepick) {
					boost = 1.10F;
				}
				
				
				//XP
				if(block == Blocks.stone) {
					mining.addExperience(1*boost);
				} else if(block == Blocks.coal_ore) {
					mining.addExperience(10*boost);
				} else if(block == Blocks.iron_ore) {
					mining.addExperience(20*boost);
				} else if(block == Blocks.redstone_ore) {
					mining.addExperience(20*boost);
				} else if(block == Blocks.lit_redstone_ore) {
					mining.addExperience(20*boost);
				} else if(block == Blocks.lapis_ore) {
					mining.addExperience(30*boost);
				} else if(block == Blocks.gold_ore) {
					mining.addExperience(40*boost);
				} else if(block == Blocks.diamond_ore) {
					mining.addExperience(50*boost);
				} else if(block == Blocks.emerald_ore) {
					mining.addExperience(50*boost);
				} else if(block == Blocks.quartz_ore) {
					mining.addExperience(20*boost);
				} else if(block == ToeBlocks.randomOre) {
					mining.addExperience(10*boost);
				} else if(block == ToeBlocks.rubyOre) {
					mining.addExperience(50*boost);
				}
				
				//Reward Drops
				Random rand = new Random();
				int lvl = MiningHelper.getProperties(player).getLevel();
				int r = rand.nextInt(200)-lvl;
				
				if(block instanceof BlockOre || block instanceof BlockRedstoneOre || block == Blocks.stone || block == ToeBlocks.randomOre) {
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
			}
			
			//Special Pickaxe
//			if(player.getHeldItem() != null && player.getHeldItem().getItem() == ToeItems.specialPickaxe) {
//				Random rand = new Random();
//				Block b1 = world.getBlock(x, y+1, z);
//				int m1 = world.getBlockMetadata(x, y+1, z);
//
//				Vec3 posVec = Vec3.createVectorHelper(player.posX, player.posY + player.getEyeHeight(), player.posZ);
//				Vec3 lookVec = player.getLookVec();
//				MovingObjectPosition mop = world.rayTraceBlocks(lookVec, posVec);
//				int side = mop.sideHit;
//				
//				LogHelper.info("side == " + side);
//				
//				if(b1 instanceof BlockOre || b1 instanceof BlockRedstoneOre || b1 == Blocks.stone || b1 == ToeBlocks.randomOre) {
//					world.spawnEntityInWorld(new EntityItem(world, x, y+1, z, new ItemStack(b1.getItemDropped(m1, rand, e.fortuneLevel))));
//					world.setBlock(x, y+1, z, Blocks.air);
//				}
//			}
			
			//Vein Pickaxe
			if(player.getHeldItem() != null && player.getHeldItem().getItem() == ToeItems.veinPickaxe) {
				if(block instanceof BlockRedstoneOre) {
					findAndHarvestVeinRedstone(world, x, y, z, Blocks.redstone_ore, e.blockMetadata, e.fortuneLevel, e.isSilkTouching, player);
				} else if(block == Blocks.lapis_ore) {
					findAndHarvestVeinLapis(world, x, y, z, Blocks.lapis_ore, e.blockMetadata, e.fortuneLevel, e.isSilkTouching, player);
				} else if(block instanceof BlockOre || block == ToeBlocks.randomOre) {
					findAndHarvestVein(world, x, y, z, block, e.blockMetadata, e.fortuneLevel, e.isSilkTouching, player);
				}
			}
			
			//Smelting Pickaxe
			if(player.getHeldItem() != null && player.getHeldItem().getItem() == ToeItems.smeltingPickaxe) {
				if(block == Blocks.iron_ore) {
					e.drops.clear();
					e.drops.add(new ItemStack(Items.iron_ingot));
				} else if(block == Blocks.gold_ore) {
					e.drops.clear();
					e.drops.add(new ItemStack(Items.gold_ingot));
				}
			}
			
			
		}
	}
	
	@SubscribeEvent
	public void onBreak(BlockEvent.BreakEvent e) {
		if(e.getPlayer() != null) {
			EntityPlayer player = e.getPlayer();
			int lvl = MiningHelper.getProperties(player).getLevel();
			
			//Smelting Pickaxe
			if(player.getHeldItem() != null && player.getHeldItem().getItem() == ToeItems.smeltingPickaxe) {
				if(lvl < 10) {
					Helper.msgClean(player, "You can only use this pickaxe at level 10 mining.", Color.red);
					e.setCanceled(true);
				}
			}
			
			//3x3 Pickaxe
			if(player.getHeldItem() != null && player.getHeldItem().getItem() == ToeItems.specialPickaxe) {
				if(lvl < 30) {
					Helper.msgClean(player, "You can only use this pickaxe at level 30 mining.", Color.red);
					e.setCanceled(true);
				}
			}
			
			//Vein Pickaxe
			if(player.getHeldItem() != null && player.getHeldItem().getItem() == ToeItems.veinPickaxe) {
				if(lvl < 50) {
					Helper.msgClean(player, "You can only use this pickaxe at level 50 mining.", Color.red);
					e.setCanceled(true);
				}
			}
		}
	}

	private synchronized void findAndHarvestVein(World world, int x, int y, int z, Block block, int meta, int fortune/*, int count*/, boolean silk, EntityPlayer player) {
//		count--;
//		if(count <= 0) {
//			return;
//		}
		Random rand = new Random();
		
		Block b1 = world.getBlock(x+1, y, z);
		Block b2 = world.getBlock(x-1, y, z);
		Block b3 = world.getBlock(x, y+1, z);
		Block b4 = world.getBlock(x, y-1, z);
		Block b5 = world.getBlock(x, y, z+1);
		Block b6 = world.getBlock(x, y, z-1);
//		int m1 = world.getBlockMetadata(x+1, y, z);
//		int m2 = world.getBlockMetadata(x-1, y, z);
//		int m3 = world.getBlockMetadata(x, y+1, z);
//		int m4 = world.getBlockMetadata(x, y-1, z);
//		int m5 = world.getBlockMetadata(x, y, z+1);
//		int m6 = world.getBlockMetadata(x, y, z-1);
		
//		LogHelper.info("x == " + x + ", y == " + y + ", z == " + z);

//		world.setBlock(x, y, z, Blocks.wool);
//		world.setBlockMetadataWithNotify(x, y, z, world.getBlockMetadata(x, y, z)+1, 2);
//		world.spawnEntityInWorld(new EntityItem(world, x, y, z, new ItemStack(block.getItemDropped(meta, rand, fortune))));
		
		if(silk) {
			breakAndDropBlock(world, x, y, z, block, new ItemStack(Item.getItemFromBlock(block)), player);
		} else {
			breakAndDropBlock(world, x, y, z, block, new ItemStack(block.getItemDropped(meta, rand, fortune), block.quantityDropped(rand), 0), player);
		}
		
		if(block == b1) {
			findAndHarvestVein(world, x+1, y, z, block, meta, fortune/*, count*/, silk, player);
		}
		if(block == b2) {
//			world.setBlock(x-1, y, z, Blocks.air);
//			world.spawnEntityInWorld(new EntityItem(world, x-1, y, z, new ItemStack(b2.getItemDropped(m2, rand, fortune))));
			findAndHarvestVein(world, x-1, y, z, block, meta, fortune/*, count*/, silk, player);
		}
		if(block == b3) {
//			world.setBlock(x, y+1, z, Blocks.air);
//			world.spawnEntityInWorld(new EntityItem(world, x, y+1, z, new ItemStack(b3.getItemDropped(m3, rand, fortune))));
			findAndHarvestVein(world, x, y+1, z, block, meta, fortune/*, count*/, silk, player);
		}
		if(block == b4) {
//			world.setBlock(x, y-1, z, Blocks.air);
//			world.spawnEntityInWorld(new EntityItem(world, x, y-1, z, new ItemStack(b4.getItemDropped(m4, rand, fortune))));
			findAndHarvestVein(world, x, y-1, z, block, meta, fortune/*, count*/, silk, player);
		}
		if(block == b5) {
//			world.setBlock(x, y, z+1, Blocks.air);
//			world.spawnEntityInWorld(new EntityItem(world, x, y, z+1, new ItemStack(b5.getItemDropped(m5, rand, fortune))));
			findAndHarvestVein(world, x, y, z+1, block, meta, fortune/*, count*/, silk, player);
		}
		if(block == b6) {
//			world.setBlock(x, y, z-1, Blocks.air);
//			world.spawnEntityInWorld(new EntityItem(world, x, y, z-1, new ItemStack(b6.getItemDropped(m6, rand, fortune))));
			findAndHarvestVein(world, x, y, z-1, block, meta, fortune/*, count*/, silk, player);
		}
	}
	
	private synchronized void findAndHarvestVeinRedstone(World world, int x, int y, int z, Block block, int meta, int fortune, boolean silk, EntityPlayer player) {
		Random rand = new Random();
		
		Block blocklit = Blocks.lit_redstone_ore;
		
		Block b1 = world.getBlock(x+1, y, z);
		Block b2 = world.getBlock(x-1, y, z);
		Block b3 = world.getBlock(x, y+1, z);
		Block b4 = world.getBlock(x, y-1, z);
		Block b5 = world.getBlock(x, y, z+1);
		Block b6 = world.getBlock(x, y, z-1);
		
		if(silk) {
			breakAndDropBlockRedstone(world, x, y, z, block, new ItemStack(Item.getItemFromBlock(block)), player);
		} else {
			breakAndDropBlockRedstone(world, x, y, z, block, new ItemStack(block.getItemDropped(meta, rand, fortune), block.quantityDropped(rand), 0), player);
		}
		
		if(block == b1 || blocklit == b1) {
			findAndHarvestVein(world, x+1, y, z, block, meta, fortune/*, count*/, silk, player);
		}
		if(block == b2 || blocklit == b2) {
			findAndHarvestVein(world, x-1, y, z, block, meta, fortune/*, count*/, silk, player);
		}
		if(block == b3 || blocklit == b3) {
			findAndHarvestVein(world, x, y+1, z, block, meta, fortune/*, count*/, silk, player);
		}
		if(block == b4 || blocklit == b4) {
			findAndHarvestVein(world, x, y-1, z, block, meta, fortune/*, count*/, silk, player);
		}
		if(block == b5 || blocklit == b5) {
			findAndHarvestVein(world, x, y, z+1, block, meta, fortune/*, count*/, silk, player);
		}
		if(block == b6 || blocklit == b6) {
			findAndHarvestVein(world, x, y, z-1, block, meta, fortune/*, count*/, silk, player);
		}
	}
	
	private synchronized void findAndHarvestVeinLapis(World world, int x, int y, int z, Block block, int meta, int fortune, boolean silk, EntityPlayer player) {
		Random rand = new Random();
		
		Block b1 = world.getBlock(x+1, y, z);
		Block b2 = world.getBlock(x-1, y, z);
		Block b3 = world.getBlock(x, y+1, z);
		Block b4 = world.getBlock(x, y-1, z);
		Block b5 = world.getBlock(x, y, z+1);
		Block b6 = world.getBlock(x, y, z-1);
		
		if(silk) {
			breakAndDropBlock(world, x, y, z, block, new ItemStack(Item.getItemFromBlock(block)), player);
		} else {
			breakAndDropBlock(world, x, y, z, block, new ItemStack(block.getItemDropped(meta, rand, fortune), block.quantityDropped(rand), 4), player);
		}
		
		if(block == b1) {
			findAndHarvestVein(world, x+1, y, z, block, meta, fortune/*, count*/, silk, player);
		}
		if(block == b2) {
			findAndHarvestVein(world, x-1, y, z, block, meta, fortune/*, count*/, silk, player);
		}
		if(block == b3) {
			findAndHarvestVein(world, x, y+1, z, block, meta, fortune/*, count*/, silk, player);
		}
		if(block == b4) {
			findAndHarvestVein(world, x, y-1, z, block, meta, fortune/*, count*/, silk, player);
		}
		if(block == b5) {
			findAndHarvestVein(world, x, y, z+1, block, meta, fortune/*, count*/, silk, player);
		}
		if(block == b6) {
			findAndHarvestVein(world, x, y, z-1, block, meta, fortune/*, count*/, silk, player);
		}
	}
	
	private void breakAndDropBlock(World world, int x, int y, int z, Block mainBlock, ItemStack is, EntityPlayer player) {
		if(world.getBlock(x, y, z) == mainBlock) {
			world.setBlock(x, y, z, Blocks.air);
			//world.setBlockMetadataWithNotify(x, y, z, world.getBlockMetadata(x, y, z)+1, 2);
			world.spawnEntityInWorld(new EntityItem(world, x, y, z, is));
			
			//XP
			if(mainBlock == Blocks.coal_ore) {
				MiningHelper.getProperties(player).addExperience(10);
			} else if(mainBlock == Blocks.iron_ore) {
				MiningHelper.getProperties(player).addExperience(20);
			} else if(mainBlock == Blocks.gold_ore) {
				MiningHelper.getProperties(player).addExperience(40);
			} else if(mainBlock == Blocks.diamond_ore) {
				MiningHelper.getProperties(player).addExperience(50);
			} else if(mainBlock == Blocks.emerald_ore) {
				MiningHelper.getProperties(player).addExperience(50);
			} else if(mainBlock == ToeBlocks.randomOre) {
				MiningHelper.getProperties(player).addExperience(10);
			} else if(mainBlock == ToeBlocks.rubyOre) {
				MiningHelper.getProperties(player).addExperience(50);
			}
			
			LogHelper.info("Found a block in the vein, destorying and dropping it.");
		}
	}
	
	private void breakAndDropBlockRedstone(World world, int x, int y, int z, Block mainBlock, ItemStack is, EntityPlayer player) {
		if(world.getBlock(x, y, z) == mainBlock || world.getBlock(x, y, z) == Blocks.lit_redstone_ore) {
			world.setBlock(x, y, z, Blocks.air);
			//world.setBlockMetadataWithNotify(x, y, z, world.getBlockMetadata(x, y, z)+1, 2);
			world.spawnEntityInWorld(new EntityItem(world, x, y, z, is));
			
			MiningHelper.getProperties(player).addExperience(20);
			
			LogHelper.info("Found a block in the vein, destorying and dropping it.");
		}
	}
}