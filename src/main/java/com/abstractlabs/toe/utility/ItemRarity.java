package com.abstractlabs.toe.utility;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.abstractlabs.toe.init.ToeBlocks;
import com.abstractlabs.toe.init.ToeItems;
import com.abstractlabs.toe.reference.Color;

public class ItemRarity {
	public static final int WILD_CARD = -9;
	public static final int SPECIAL = -2;
	public static final int UNATTAINABLE = -1;
	public static final int NO_VALUE = 0;

	public static final int SHIT = 1;
	public static final int BASIC = 2;
	public static final int COMMON = 3;
	public static final int UNCOMMON = 4;
	public static final int RARE = 5;
	public static final int EPIC = 6;
	public static final int SUPERIOR = 7;
	public static final int ULTIMATE = 8;
	public static final int LEGENDARY = 9;
	
	// MYSTIC ?
	
	public static ItemRarity[] items = {
		//Vanilla Items
		new ItemRarity(Items.iron_shovel, UNCOMMON),
		new ItemRarity(Items.iron_pickaxe, UNCOMMON),
		new ItemRarity(Items.iron_axe, UNCOMMON),
		new ItemRarity(Items.flint_and_steel, BASIC),
		new ItemRarity(Items.apple, BASIC),
		new ItemRarity(Items.bow, COMMON),
		new ItemRarity(Items.arrow, BASIC),
		new ItemRarity(Items.coal, BASIC),
		new ItemRarity(Items.diamond, RARE),
		new ItemRarity(Items.iron_ingot, UNCOMMON),
		new ItemRarity(Items.gold_ingot, UNCOMMON),
		new ItemRarity(Items.iron_sword, UNCOMMON),
		new ItemRarity(Items.wooden_sword, SHIT),
		new ItemRarity(Items.wooden_shovel, SHIT),
		new ItemRarity(Items.wooden_pickaxe, SHIT),
		new ItemRarity(Items.wooden_axe, SHIT),
		new ItemRarity(Items.stone_sword, COMMON),
		new ItemRarity(Items.stone_shovel, COMMON),
		new ItemRarity(Items.stone_pickaxe, COMMON),
		new ItemRarity(Items.stone_axe, COMMON),
		new ItemRarity(Items.diamond_sword, RARE),
		new ItemRarity(Items.diamond_shovel, RARE),
		new ItemRarity(Items.diamond_pickaxe, RARE),
		new ItemRarity(Items.diamond_axe, RARE),
		new ItemRarity(Items.stick, SHIT),
		new ItemRarity(Items.bowl, SHIT),
		new ItemRarity(Items.mushroom_stew, UNCOMMON),
		new ItemRarity(Items.golden_sword, UNCOMMON),
		new ItemRarity(Items.golden_shovel, UNCOMMON),
		new ItemRarity(Items.golden_pickaxe, UNCOMMON),
		new ItemRarity(Items.golden_axe, UNCOMMON),
		new ItemRarity(Items.string, BASIC),
		new ItemRarity(Items.feather, BASIC),
		new ItemRarity(Items.gunpowder, BASIC),
		new ItemRarity(Items.wooden_hoe, BASIC),
		new ItemRarity(Items.stone_hoe, COMMON),
		new ItemRarity(Items.iron_hoe, UNCOMMON),
		new ItemRarity(Items.diamond_hoe, RARE),
		new ItemRarity(Items.golden_hoe, UNCOMMON),
		new ItemRarity(Items.wheat_seeds, BASIC),
		new ItemRarity(Items.wheat, BASIC),
		new ItemRarity(Items.bread, BASIC),
		new ItemRarity(Items.leather_helmet, COMMON),
		new ItemRarity(Items.leather_chestplate, COMMON),
		new ItemRarity(Items.leather_leggings, COMMON),
		new ItemRarity(Items.leather_boots, COMMON),
		new ItemRarity(Items.chainmail_helmet, UNATTAINABLE),
		new ItemRarity(Items.chainmail_chestplate, UNATTAINABLE),
		new ItemRarity(Items.chainmail_leggings, UNATTAINABLE),
		new ItemRarity(Items.chainmail_boots, UNATTAINABLE),
		new ItemRarity(Items.iron_helmet, RARE),
		new ItemRarity(Items.iron_chestplate, RARE),
		new ItemRarity(Items.iron_leggings, RARE),
		new ItemRarity(Items.iron_boots, RARE),
		new ItemRarity(Items.diamond_helmet, EPIC),
		new ItemRarity(Items.diamond_chestplate, EPIC),
		new ItemRarity(Items.diamond_leggings, EPIC),
		new ItemRarity(Items.diamond_boots, EPIC),
		new ItemRarity(Items.golden_helmet, UNCOMMON),
		new ItemRarity(Items.golden_chestplate, UNCOMMON),
		new ItemRarity(Items.golden_leggings, UNCOMMON),
		new ItemRarity(Items.golden_boots, UNCOMMON),
		new ItemRarity(Items.flint, BASIC),
		new ItemRarity(Items.porkchop, BASIC),
		new ItemRarity(Items.cooked_porkchop, COMMON),
		new ItemRarity(Items.painting, BASIC),
		new ItemRarity(Items.golden_apple, UNCOMMON),
		new ItemRarity(Items.golden_apple, 1, EPIC),
		new ItemRarity(Items.sign, BASIC),
		new ItemRarity(Items.wooden_door, BASIC),
		new ItemRarity(Items.bucket, BASIC),
		new ItemRarity(Items.lava_bucket, COMMON),
		new ItemRarity(Items.minecart, UNCOMMON),
		new ItemRarity(Items.saddle, UNCOMMON),
		new ItemRarity(Items.iron_door, UNCOMMON),
		new ItemRarity(Items.redstone, BASIC),
		new ItemRarity(Items.snowball, BASIC),
		new ItemRarity(Items.boat, COMMON),
		new ItemRarity(Items.leather, BASIC),
		new ItemRarity(Items.milk_bucket, BASIC),
		new ItemRarity(Items.brick, BASIC),
		new ItemRarity(Items.clay_ball, BASIC),
		new ItemRarity(Items.reeds, BASIC),
		new ItemRarity(Items.paper, BASIC),
		new ItemRarity(Items.book, COMMON),
		new ItemRarity(Items.slime_ball, UNCOMMON),
		new ItemRarity(Items.chest_minecart, UNCOMMON),
		new ItemRarity(Items.furnace_minecart, UNCOMMON),
		new ItemRarity(Items.egg, BASIC),
		new ItemRarity(Items.compass, UNCOMMON),
		new ItemRarity(Items.fishing_rod, COMMON, false),
		new ItemRarity(Items.clock, UNCOMMON),
		new ItemRarity(Items.glowstone_dust, BASIC),
		new ItemRarity(Items.fish, BASIC),
		new ItemRarity(Items.fish, 1, COMMON),
		new ItemRarity(Items.fish, 2, UNCOMMON),
		new ItemRarity(Items.fish, 3, UNCOMMON),
		new ItemRarity(Items.cooked_fished, COMMON),
		new ItemRarity(Items.cooked_fished, 1, UNCOMMON),
		new ItemRarity(Items.dye, 0, BASIC),
		new ItemRarity(Items.dye, 1, BASIC),
		new ItemRarity(Items.dye, 2, BASIC),
		new ItemRarity(Items.dye, 3, BASIC),
		new ItemRarity(Items.dye, 4, BASIC),
		new ItemRarity(Items.dye, 5, BASIC),
		new ItemRarity(Items.dye, 6, BASIC),
		new ItemRarity(Items.dye, 7, BASIC),
		new ItemRarity(Items.dye, 8, BASIC),
		new ItemRarity(Items.dye, 9, BASIC),
		new ItemRarity(Items.dye, 10, BASIC),
		new ItemRarity(Items.dye, 11, BASIC),
		new ItemRarity(Items.dye, 12, BASIC),
		new ItemRarity(Items.dye, 13, BASIC),
		new ItemRarity(Items.dye, 14, BASIC),
		new ItemRarity(Items.dye, 15, BASIC),
		new ItemRarity(Items.bone, BASIC),
		new ItemRarity(Items.sugar, BASIC),
		new ItemRarity(Items.cake, UNCOMMON),
		new ItemRarity(Items.bed, COMMON),
		new ItemRarity(Items.repeater, COMMON),
		new ItemRarity(Items.cookie, BASIC),
		new ItemRarity(Items.filled_map, BASIC, false),
		new ItemRarity(Items.shears, COMMON),
		new ItemRarity(Items.melon, BASIC),
		new ItemRarity(Items.pumpkin_seeds, BASIC),
		new ItemRarity(Items.melon_seeds, BASIC),
		new ItemRarity(Items.beef, BASIC),
	    new ItemRarity(Items.cooked_beef, COMMON),
	    new ItemRarity(Items.chicken, BASIC),
	    new ItemRarity(Items.cooked_chicken, COMMON),
	    new ItemRarity(Items.rotten_flesh, SHIT),
	    new ItemRarity(Items.ender_pearl, COMMON),
	    new ItemRarity(Items.blaze_rod, COMMON),
	    new ItemRarity(Items.ghast_tear, UNCOMMON),
	    new ItemRarity(Items.gold_nugget, BASIC),
	    new ItemRarity(Items.nether_wart, BASIC),
	    new ItemRarity(Items.potionitem, COMMON, false),
	    new ItemRarity(Items.glass_bottle, SHIT),
	    new ItemRarity(Items.spider_eye, BASIC),
	    new ItemRarity(Items.fermented_spider_eye, BASIC),
	    new ItemRarity(Items.blaze_powder, BASIC),
	    new ItemRarity(Items.magma_cream, COMMON),
	    new ItemRarity(Items.brewing_stand, UNCOMMON),
	    new ItemRarity(Items.cauldron, UNCOMMON),
	    new ItemRarity(Items.ender_eye, COMMON),
	    new ItemRarity(Items.speckled_melon, COMMON),
	    new ItemRarity(Items.spawn_egg, UNATTAINABLE, false),
	    new ItemRarity(Items.experience_bottle, UNATTAINABLE, false), //might allow
	    new ItemRarity(Items.fire_charge, COMMON),
	    new ItemRarity(Items.writable_book, COMMON),
	    new ItemRarity(Items.written_book, COMMON, false),
	    new ItemRarity(Items.emerald, RARE),
	    new ItemRarity(Items.item_frame, COMMON),
	    new ItemRarity(Items.flower_pot, COMMON),
	    new ItemRarity(Items.carrot, BASIC),
	    new ItemRarity(Items.potato, BASIC),
	    new ItemRarity(Items.baked_potato, COMMON),
	    new ItemRarity(Items.poisonous_potato, BASIC),
	    new ItemRarity(Items.map, BASIC),
	    new ItemRarity(Items.golden_carrot, UNCOMMON),
	    new ItemRarity(Items.skull, 0, RARE),
	    new ItemRarity(Items.skull, 1, RARE),
	    new ItemRarity(Items.skull, 2, RARE),
	    new ItemRarity(Items.skull, 3, RARE, false),
	    new ItemRarity(Items.skull, 4, RARE),
	    new ItemRarity(Items.carrot_on_a_stick, COMMON),
	    new ItemRarity(Items.nether_star, SUPERIOR),
	    new ItemRarity(Items.pumpkin_pie, COMMON),
	    new ItemRarity(Items.fireworks, COMMON, false),
	    new ItemRarity(Items.firework_charge, COMMON, false),
	    new ItemRarity(Items.enchanted_book, SPECIAL, false),
	    new ItemRarity(Items.comparator, COMMON),
	    new ItemRarity(Items.netherbrick, BASIC),
	    new ItemRarity(Items.quartz, COMMON),
	    new ItemRarity(Items.tnt_minecart, UNCOMMON),
	    new ItemRarity(Items.hopper_minecart, UNCOMMON),
	    new ItemRarity(Items.iron_horse_armor, UNCOMMON),
	    new ItemRarity(Items.golden_horse_armor, UNCOMMON),
	    new ItemRarity(Items.diamond_horse_armor, RARE),
	    new ItemRarity(Items.lead, UNCOMMON),
	    new ItemRarity(Items.name_tag, UNCOMMON),
	    new ItemRarity(Items.command_block_minecart, UNATTAINABLE, false),
	    new ItemRarity(Items.record_13, RARE),
	    new ItemRarity(Items.record_cat, RARE),
	    new ItemRarity(Items.record_blocks, EPIC),
	    new ItemRarity(Items.record_chirp, EPIC),
	    new ItemRarity(Items.record_far, EPIC),
	    new ItemRarity(Items.record_mall, EPIC),
	    new ItemRarity(Items.record_mellohi, EPIC),
	    new ItemRarity(Items.record_stal, EPIC),
	    new ItemRarity(Items.record_strad, EPIC),
	    new ItemRarity(Items.record_ward, EPIC),
	    new ItemRarity(Items.record_11, SUPERIOR),
	    new ItemRarity(Items.record_wait, EPIC),
		
	    //Vanilla Blocks
		new ItemRarity(Blocks.stone, BASIC),
		new ItemRarity(Blocks.grass, UNCOMMON),
	    new ItemRarity(Blocks.dirt, SHIT),
	    new ItemRarity(Blocks.cobblestone, SHIT),
	    new ItemRarity(Blocks.planks, 0, SHIT),
	    new ItemRarity(Blocks.planks, 1, SHIT),
	    new ItemRarity(Blocks.planks, 2, SHIT),
	    new ItemRarity(Blocks.planks, 3, SHIT),
	    new ItemRarity(Blocks.planks, 4, SHIT),
	    new ItemRarity(Blocks.planks, 5, SHIT),
	    new ItemRarity(Blocks.sapling, 0, BASIC),
	    new ItemRarity(Blocks.sapling, 1, BASIC),
	    new ItemRarity(Blocks.sapling, 2, BASIC),
	    new ItemRarity(Blocks.sapling, 3, BASIC),
	    new ItemRarity(Blocks.sapling, 4, BASIC),
	    new ItemRarity(Blocks.sapling, 5, BASIC),
	    new ItemRarity(Blocks.bedrock, UNATTAINABLE, false),
	    new ItemRarity(Blocks.flowing_water, UNATTAINABLE, false),
	    new ItemRarity(Blocks.water, UNATTAINABLE, false),
	    new ItemRarity(Blocks.flowing_lava, UNATTAINABLE, false),
	    new ItemRarity(Blocks.lava, UNATTAINABLE, false),
	    new ItemRarity(Blocks.sand, SHIT),
	    new ItemRarity(Blocks.sand, 1, SHIT),
	    new ItemRarity(Blocks.gravel, BASIC),
	    new ItemRarity(Blocks.gold_ore, UNCOMMON),
	    new ItemRarity(Blocks.iron_ore, COMMON),
	    new ItemRarity(Blocks.coal_ore, BASIC),
	    new ItemRarity(Blocks.log, 0, BASIC),
	    new ItemRarity(Blocks.log, 1, BASIC),
	    new ItemRarity(Blocks.log, 2, BASIC),
	    new ItemRarity(Blocks.log, 3, BASIC),
	    new ItemRarity(Blocks.log2, 0, BASIC),
	    new ItemRarity(Blocks.log2, 1, BASIC),
	    new ItemRarity(Blocks.log2, 2, BASIC),
	    new ItemRarity(Blocks.log2, 3, BASIC),
	    new ItemRarity(Blocks.leaves, 0, SHIT),
	    new ItemRarity(Blocks.leaves, 1, SHIT),
	    new ItemRarity(Blocks.leaves, 2, SHIT),
	    new ItemRarity(Blocks.leaves, 3, SHIT),
	    new ItemRarity(Blocks.leaves2, 0, SHIT),
	    new ItemRarity(Blocks.leaves2, 1, SHIT),
	    new ItemRarity(Blocks.leaves2, 2, SHIT),
	    new ItemRarity(Blocks.leaves2, 3, SHIT),
	    new ItemRarity(Blocks.sponge, UNATTAINABLE, false),
	    new ItemRarity(Blocks.glass, BASIC),
	    new ItemRarity(Blocks.lapis_ore, UNCOMMON),
	    new ItemRarity(Blocks.lapis_block, RARE),
	    new ItemRarity(Blocks.dispenser, COMMON),
	    new ItemRarity(Blocks.sandstone, BASIC),
	    new ItemRarity(Blocks.noteblock, BASIC),
	    new ItemRarity(Blocks.bed, UNATTAINABLE, false),
	    new ItemRarity(Blocks.golden_rail, UNCOMMON),
	    new ItemRarity(Blocks.detector_rail, UNCOMMON),
	    new ItemRarity(Blocks.sticky_piston, UNCOMMON),
	    new ItemRarity(Blocks.web, COMMON),
	    new ItemRarity(Blocks.tallgrass, 0, SHIT, false),
	    new ItemRarity(Blocks.tallgrass, 1, SHIT),
	    new ItemRarity(Blocks.tallgrass, 2, SHIT),
	    new ItemRarity(Blocks.deadbush, SHIT, false),
	    new ItemRarity(Blocks.piston, UNCOMMON),
	    new ItemRarity(Blocks.piston_head, UNATTAINABLE, false),
	    new ItemRarity(Blocks.wool, 0, BASIC),
	    new ItemRarity(Blocks.wool, 1, BASIC),
	    new ItemRarity(Blocks.wool, 2, BASIC),
	    new ItemRarity(Blocks.wool, 3, BASIC),
	    new ItemRarity(Blocks.wool, 4, BASIC),
	    new ItemRarity(Blocks.wool, 5, BASIC),
	    new ItemRarity(Blocks.wool, 6, BASIC),
	    new ItemRarity(Blocks.wool, 7, BASIC),
	    new ItemRarity(Blocks.wool, 8, BASIC),
	    new ItemRarity(Blocks.wool, 9, BASIC),
	    new ItemRarity(Blocks.wool, 10, BASIC),
	    new ItemRarity(Blocks.wool, 11, BASIC),
	    new ItemRarity(Blocks.wool, 12, BASIC),
	    new ItemRarity(Blocks.wool, 13, BASIC),
	    new ItemRarity(Blocks.wool, 14, BASIC),
	    new ItemRarity(Blocks.wool, 15, BASIC),
	    new ItemRarity(Blocks.piston_extension, UNATTAINABLE, false),
	    new ItemRarity(Blocks.yellow_flower, SHIT),
	    new ItemRarity(Blocks.red_flower, SHIT),
	    new ItemRarity(Blocks.red_flower, 1, SHIT),
	    new ItemRarity(Blocks.red_flower, 2, SHIT),
	    new ItemRarity(Blocks.red_flower, 3, SHIT),
	    new ItemRarity(Blocks.red_flower, 4, SHIT),
	    new ItemRarity(Blocks.red_flower, 5, SHIT),
	    new ItemRarity(Blocks.red_flower, 6, SHIT),
	    new ItemRarity(Blocks.red_flower, 7, SHIT),
	    new ItemRarity(Blocks.red_flower, 8, SHIT),
	    new ItemRarity(Blocks.brown_mushroom, SHIT),
	    new ItemRarity(Blocks.red_mushroom, SHIT),
	    new ItemRarity(Blocks.gold_block, RARE),
	    new ItemRarity(Blocks.iron_block, RARE),
	    new ItemRarity(Blocks.double_stone_slab, UNATTAINABLE, false),
	    new ItemRarity(Blocks.stone_slab, 0, BASIC),
	    new ItemRarity(Blocks.stone_slab, 1, BASIC),
	    new ItemRarity(Blocks.stone_slab, 2, BASIC),
	    new ItemRarity(Blocks.stone_slab, 3, BASIC),
	    new ItemRarity(Blocks.stone_slab, 4, BASIC),
	    new ItemRarity(Blocks.stone_slab, 5, BASIC),
	    new ItemRarity(Blocks.stone_slab, 6, BASIC),
	    new ItemRarity(Blocks.stone_slab, 7, BASIC),
	    new ItemRarity(Blocks.brick_block, COMMON),
	    new ItemRarity(Blocks.tnt, UNCOMMON),
	    new ItemRarity(Blocks.bookshelf, UNCOMMON),
	    new ItemRarity(Blocks.mossy_cobblestone, UNCOMMON),
	    new ItemRarity(Blocks.obsidian, COMMON),
	    new ItemRarity(Blocks.torch, SHIT),
	    new ItemRarity(Blocks.fire, UNATTAINABLE, false),
	    new ItemRarity(Blocks.mob_spawner, UNATTAINABLE, false),
	    new ItemRarity(Blocks.oak_stairs, SHIT),
	    new ItemRarity(Blocks.chest, BASIC),
	    new ItemRarity(Blocks.redstone_wire, UNATTAINABLE, false),
	    new ItemRarity(Blocks.diamond_ore, RARE),
	    new ItemRarity(Blocks.diamond_block, EPIC),
	    new ItemRarity(Blocks.crafting_table, SHIT),
	    new ItemRarity(Blocks.wheat, UNATTAINABLE, false),
	    new ItemRarity(Blocks.farmland, UNATTAINABLE, false),
	    new ItemRarity(Blocks.furnace, BASIC),
	    new ItemRarity(Blocks.lit_furnace, UNATTAINABLE, false),
	    new ItemRarity(Blocks.standing_sign, UNATTAINABLE, false),
	    new ItemRarity(Blocks.wooden_door, UNATTAINABLE, false),
	    new ItemRarity(Blocks.ladder, SHIT),
	    new ItemRarity(Blocks.rail, BASIC),
	    new ItemRarity(Blocks.stone_stairs, SHIT),
	    new ItemRarity(Blocks.wall_sign, UNATTAINABLE, false),
	    new ItemRarity(Blocks.lever, SHIT),
	    new ItemRarity(Blocks.stone_pressure_plate, BASIC),
	    new ItemRarity(Blocks.iron_door, UNATTAINABLE, false),
	    new ItemRarity(Blocks.wooden_pressure_plate, BASIC),
	    new ItemRarity(Blocks.redstone_ore, COMMON),
	    new ItemRarity(Blocks.lit_redstone_ore, UNATTAINABLE, false),
	    new ItemRarity(Blocks.unlit_redstone_torch, UNATTAINABLE, false),
	    new ItemRarity(Blocks.redstone_torch, SHIT),
	    new ItemRarity(Blocks.stone_button, BASIC),
	    new ItemRarity(Blocks.snow_layer, SHIT),
	    new ItemRarity(Blocks.ice, BASIC),
	    new ItemRarity(Blocks.snow, BASIC),
	    new ItemRarity(Blocks.cactus, BASIC),
	    new ItemRarity(Blocks.clay, BASIC),
	    new ItemRarity(Blocks.reeds, UNATTAINABLE, false),
	    new ItemRarity(Blocks.jukebox, RARE),
	    new ItemRarity(Blocks.fence, SHIT),
	    new ItemRarity(Blocks.pumpkin, BASIC),
	    new ItemRarity(Blocks.netherrack, SHIT),
	    new ItemRarity(Blocks.soul_sand, SHIT),
	    new ItemRarity(Blocks.glowstone, BASIC),
	    new ItemRarity(Blocks.portal, UNATTAINABLE, false),
	    new ItemRarity(Blocks.lit_pumpkin, UNATTAINABLE, false),
	    new ItemRarity(Blocks.cake, UNATTAINABLE, false),
	    new ItemRarity(Blocks.unpowered_repeater, UNATTAINABLE, false),
	    new ItemRarity(Blocks.powered_repeater, UNATTAINABLE, false),
	    new ItemRarity(Blocks.trapdoor, BASIC),
	    new ItemRarity(Blocks.monster_egg, UNATTAINABLE, false),
	    new ItemRarity(Blocks.stonebrick, 0, BASIC),
	    new ItemRarity(Blocks.stonebrick, 1, COMMON),
	    new ItemRarity(Blocks.stonebrick, 2, COMMON),
	    new ItemRarity(Blocks.stonebrick, 3, UNCOMMON),
	    new ItemRarity(Blocks.brown_mushroom_block, UNCOMMON),
	    new ItemRarity(Blocks.red_mushroom_block, UNCOMMON),
	    new ItemRarity(Blocks.iron_bars, BASIC),
	    new ItemRarity(Blocks.glass_pane, SHIT),
	    new ItemRarity(Blocks.melon_block, COMMON),
	    new ItemRarity(Blocks.pumpkin_stem, UNATTAINABLE, false),
	    new ItemRarity(Blocks.melon_stem, UNATTAINABLE, false),
	    new ItemRarity(Blocks.vine, SHIT),
	    new ItemRarity(Blocks.fence_gate, SHIT),
	    new ItemRarity(Blocks.brick_stairs, SHIT),
	    new ItemRarity(Blocks.stone_brick_stairs, SHIT),
	    new ItemRarity(Blocks.mycelium, RARE),
	    new ItemRarity(Blocks.waterlily, BASIC),
	    new ItemRarity(Blocks.nether_brick, BASIC),
	    new ItemRarity(Blocks.nether_brick_fence, BASIC),
	    new ItemRarity(Blocks.nether_brick_stairs, SHIT),
	    new ItemRarity(Blocks.nether_wart, UNATTAINABLE, false),
	    new ItemRarity(Blocks.enchanting_table, RARE),
	    new ItemRarity(Blocks.brewing_stand, UNATTAINABLE, false),
	    new ItemRarity(Blocks.cauldron, UNATTAINABLE, false),
	    new ItemRarity(Blocks.end_portal, UNATTAINABLE, false),
	    new ItemRarity(Blocks.end_portal_frame, UNCOMMON),
	    new ItemRarity(Blocks.end_stone, BASIC),
	    new ItemRarity(Blocks.dragon_egg, EPIC),
	    new ItemRarity(Blocks.redstone_lamp, BASIC),
	    new ItemRarity(Blocks.lit_redstone_lamp, UNATTAINABLE, false),
	    new ItemRarity(Blocks.double_wooden_slab, UNATTAINABLE, false),
	    new ItemRarity(Blocks.wooden_slab, 0, SHIT),
	    new ItemRarity(Blocks.wooden_slab, 1, SHIT),
	    new ItemRarity(Blocks.wooden_slab, 2, SHIT),
	    new ItemRarity(Blocks.wooden_slab, 3, SHIT),
	    new ItemRarity(Blocks.wooden_slab, 4, SHIT),
	    new ItemRarity(Blocks.wooden_slab, 5, SHIT),
	    new ItemRarity(Blocks.cocoa, UNATTAINABLE, false),
	    new ItemRarity(Blocks.sandstone_stairs, SHIT),
	    new ItemRarity(Blocks.emerald_ore, RARE),
	    new ItemRarity(Blocks.ender_chest, UNCOMMON),
	    new ItemRarity(Blocks.tripwire_hook, BASIC),
	    new ItemRarity(Blocks.tripwire, UNATTAINABLE, false),
	    new ItemRarity(Blocks.emerald_block, EPIC),
	    new ItemRarity(Blocks.spruce_stairs, SHIT),
	    new ItemRarity(Blocks.birch_stairs, SHIT),
	    new ItemRarity(Blocks.jungle_stairs, SHIT),
	    new ItemRarity(Blocks.command_block, UNATTAINABLE, false),
	    new ItemRarity(Blocks.beacon, SUPERIOR),
	    new ItemRarity(Blocks.cobblestone_wall, SHIT),
	    new ItemRarity(Blocks.cobblestone_wall, 1, BASIC),
	    new ItemRarity(Blocks.flower_pot, UNATTAINABLE, false),
	    new ItemRarity(Blocks.carrots, UNATTAINABLE, false),
	    new ItemRarity(Blocks.potatoes, UNATTAINABLE, false),
	    new ItemRarity(Blocks.wooden_button, SHIT),
	    new ItemRarity(Blocks.skull, UNATTAINABLE, false),
	    new ItemRarity(Blocks.anvil, 0, EPIC),
	    new ItemRarity(Blocks.anvil, 1, RARE, false),
	    new ItemRarity(Blocks.anvil, 2, UNCOMMON, false),
	    new ItemRarity(Blocks.trapped_chest, BASIC),
	    new ItemRarity(Blocks.light_weighted_pressure_plate, BASIC),
	    new ItemRarity(Blocks.heavy_weighted_pressure_plate, BASIC),
	    new ItemRarity(Blocks.unpowered_comparator, UNATTAINABLE, false),
	    new ItemRarity(Blocks.powered_comparator, UNATTAINABLE, false),
	    new ItemRarity(Blocks.daylight_detector, COMMON),
	    new ItemRarity(Blocks.redstone_block, COMMON),
	    new ItemRarity(Blocks.quartz_ore, COMMON),
	    new ItemRarity(Blocks.hopper, UNCOMMON),
	    new ItemRarity(Blocks.quartz_block, 0, UNCOMMON),
	    new ItemRarity(Blocks.quartz_block, 1, UNCOMMON),
	    new ItemRarity(Blocks.quartz_block, 2, UNCOMMON),
	    new ItemRarity(Blocks.quartz_stairs, BASIC),
	    new ItemRarity(Blocks.activator_rail, UNCOMMON),
	    new ItemRarity(Blocks.dropper, BASIC),
	    new ItemRarity(Blocks.stained_hardened_clay, 0, BASIC),
	    new ItemRarity(Blocks.stained_hardened_clay, 1, BASIC),
	    new ItemRarity(Blocks.stained_hardened_clay, 2, BASIC),
	    new ItemRarity(Blocks.stained_hardened_clay, 3, BASIC),
	    new ItemRarity(Blocks.stained_hardened_clay, 4, BASIC),
	    new ItemRarity(Blocks.stained_hardened_clay, 5, BASIC),
	    new ItemRarity(Blocks.stained_hardened_clay, 6, BASIC),
	    new ItemRarity(Blocks.stained_hardened_clay, 7, BASIC),
	    new ItemRarity(Blocks.stained_hardened_clay, 8, BASIC),
	    new ItemRarity(Blocks.stained_hardened_clay, 9, BASIC),
	    new ItemRarity(Blocks.stained_hardened_clay, 10, BASIC),
	    new ItemRarity(Blocks.stained_hardened_clay, 11, BASIC),
	    new ItemRarity(Blocks.stained_hardened_clay, 12, BASIC),
	    new ItemRarity(Blocks.stained_hardened_clay, 13, BASIC),
	    new ItemRarity(Blocks.stained_hardened_clay, 14, BASIC),
	    new ItemRarity(Blocks.stained_hardened_clay, 15, BASIC),
	    new ItemRarity(Blocks.hay_block, BASIC),
	    new ItemRarity(Blocks.carpet, BASIC),
	    new ItemRarity(Blocks.hardened_clay, BASIC),
	    new ItemRarity(Blocks.coal_block, UNCOMMON),
	    new ItemRarity(Blocks.packed_ice, COMMON),
	    new ItemRarity(Blocks.acacia_stairs, SHIT),
	    new ItemRarity(Blocks.dark_oak_stairs, SHIT),
	    new ItemRarity(Blocks.double_plant, SHIT),
	    new ItemRarity(Blocks.stained_glass, 0, BASIC),
	    new ItemRarity(Blocks.stained_glass, 1, BASIC),
	    new ItemRarity(Blocks.stained_glass, 2, BASIC),
	    new ItemRarity(Blocks.stained_glass, 3, BASIC),
	    new ItemRarity(Blocks.stained_glass, 4, BASIC),
	    new ItemRarity(Blocks.stained_glass, 5, BASIC),
	    new ItemRarity(Blocks.stained_glass, 6, BASIC),
	    new ItemRarity(Blocks.stained_glass, 7, BASIC),
	    new ItemRarity(Blocks.stained_glass, 8, BASIC),
	    new ItemRarity(Blocks.stained_glass, 9, BASIC),
	    new ItemRarity(Blocks.stained_glass, 10, BASIC),
	    new ItemRarity(Blocks.stained_glass, 11, BASIC),
	    new ItemRarity(Blocks.stained_glass, 12, BASIC),
	    new ItemRarity(Blocks.stained_glass, 13, BASIC),
	    new ItemRarity(Blocks.stained_glass, 14, BASIC),
	    new ItemRarity(Blocks.stained_glass, 15, BASIC),
	    new ItemRarity(Blocks.stained_glass_pane, 0, SHIT),
	    new ItemRarity(Blocks.stained_glass_pane, 1, SHIT),
	    new ItemRarity(Blocks.stained_glass_pane, 2, SHIT),
	    new ItemRarity(Blocks.stained_glass_pane, 3, SHIT),
	    new ItemRarity(Blocks.stained_glass_pane, 4, SHIT),
	    new ItemRarity(Blocks.stained_glass_pane, 5, SHIT),
	    new ItemRarity(Blocks.stained_glass_pane, 6, SHIT),
	    new ItemRarity(Blocks.stained_glass_pane, 7, SHIT),
	    new ItemRarity(Blocks.stained_glass_pane, 8, SHIT),
	    new ItemRarity(Blocks.stained_glass_pane, 9, SHIT),
	    new ItemRarity(Blocks.stained_glass_pane, 10, SHIT),
	    new ItemRarity(Blocks.stained_glass_pane, 11, SHIT),
	    new ItemRarity(Blocks.stained_glass_pane, 12, SHIT),
	    new ItemRarity(Blocks.stained_glass_pane, 13, SHIT),
	    new ItemRarity(Blocks.stained_glass_pane, 14, SHIT),
	    new ItemRarity(Blocks.stained_glass_pane, 15, SHIT),
	    
	    //Toe Items
	    new ItemRarity(ToeItems.flashbang, BASIC),
		new ItemRarity(ToeItems.grenade, BASIC),
		new ItemRarity(ToeItems.hollowLighter, BASIC),
		new ItemRarity(ToeItems.recall, BASIC),
		new ItemRarity(ToeItems.cane, BASIC),
		new ItemRarity(ToeItems.paperclip, BASIC),
		new ItemRarity(ToeItems.lockpick, BASIC),
		new ItemRarity(ToeItems.masterKey, EPIC),
		new ItemRarity(ToeItems.tester, UNATTAINABLE, false),
		new ItemRarity(ToeItems.coinCopper, SHIT),
		new ItemRarity(ToeItems.coinSilver, UNCOMMON),
		new ItemRarity(ToeItems.coinGold, EPIC),
		new ItemRarity(ToeItems.specialPickaxe, SUPERIOR),
		new ItemRarity(ToeItems.veinPickaxe, SUPERIOR),
		new ItemRarity(ToeItems.smeltingPickaxe, SUPERIOR),
		new ItemRarity(ToeItems.stripPickaxe, EPIC),
		new ItemRarity(ToeItems.woodAxepick, SHIT),
		new ItemRarity(ToeItems.goldAxepick, COMMON),
		new ItemRarity(ToeItems.stoneAxepick, SHIT),
		new ItemRarity(ToeItems.ironAxepick, UNCOMMON),
		new ItemRarity(ToeItems.diamondAxepick, RARE),
		new ItemRarity(ToeItems.timberAxe, SUPERIOR),
		new ItemRarity(ToeItems.ruby, RARE),
		new ItemRarity(ToeItems.undeadbatBone, UNCOMMON), 
		new ItemRarity(ToeItems.healingTab, UNCOMMON), //not sure how the tablets are gonna be made/found, so change rarity if unreasonable.
		new ItemRarity(ToeItems.cleanseTab, UNCOMMON),
		new ItemRarity(ToeItems.resistTab, UNCOMMON),
		new ItemRarity(ToeItems.hasteTab, UNCOMMON),
		new ItemRarity(ToeItems.strTab_crs, UNCOMMON),
		new ItemRarity(ToeItems.jumpTab, UNCOMMON),
		new ItemRarity(ToeItems.ghostblade, EPIC),
		new ItemRarity(ToeItems.crystal, RARE),
		new ItemRarity(ToeItems.crystalIce, RARE),
		new ItemRarity(ToeItems.aluminium, BASIC),
		new ItemRarity(ToeItems.aluminiumSheet, BASIC),
		new ItemRarity(ToeItems.sapphire, RARE),
		new ItemRarity(ToeItems.greenLeather, BASIC),
		new ItemRarity(ToeItems.alienBeef, BASIC),
		new ItemRarity(ToeItems.alienSteak, COMMON),
		new ItemRarity(ToeItems.bucketGoo, UNCOMMON),
		new ItemRarity(ToeItems.emeraldSword, RARE),
		new ItemRarity(ToeItems.emeraldPickaxe, RARE),
		new ItemRarity(ToeItems.emeraldShovel, RARE),
		new ItemRarity(ToeItems.emeraldAxe, RARE),
		new ItemRarity(ToeItems.emeraldAxepick, RARE),
		new ItemRarity(ToeItems.emeraldHoe, RARE),
		new ItemRarity(ToeItems.rubySword, RARE),
		new ItemRarity(ToeItems.rubyPickaxe, RARE),
		new ItemRarity(ToeItems.rubyShovel, RARE),
		new ItemRarity(ToeItems.rubyAxe, RARE),
		new ItemRarity(ToeItems.rubyAxepick, RARE),
		new ItemRarity(ToeItems.rubyHoe, RARE),
		new ItemRarity(ToeItems.sapphireSword, RARE),
		new ItemRarity(ToeItems.sapphirePickaxe, RARE),
		new ItemRarity(ToeItems.sapphireShovel, RARE),
		new ItemRarity(ToeItems.sapphireAxe, RARE),
		new ItemRarity(ToeItems.sapphireAxepick, RARE),
		new ItemRarity(ToeItems.sapphireHoe, RARE),
		new ItemRarity(ToeItems.magmaHelmet, EPIC), //made most armors epic, sicne diamond armor is epic, change if needed.
		new ItemRarity(ToeItems.magmaPlate, EPIC),
		new ItemRarity(ToeItems.magmaPants, EPIC),
		new ItemRarity(ToeItems.magmaBoots, EPIC),
		new ItemRarity(ToeItems.nimbleHelmet, EPIC),
		new ItemRarity(ToeItems.nimblePlate, EPIC),
		new ItemRarity(ToeItems.nimblePants, EPIC),
		new ItemRarity(ToeItems.nimbleBoots, EPIC),
		new ItemRarity(ToeItems.dynamicHelmet, EPIC),
		new ItemRarity(ToeItems.dynamicPlate, EPIC),
		new ItemRarity(ToeItems.dynamicPants, EPIC),
		new ItemRarity(ToeItems.dynamicBoots, EPIC),
		new ItemRarity(ToeItems.spacesuitHelmet, EPIC),
		new ItemRarity(ToeItems.spacesuitPlate, EPIC),
		new ItemRarity(ToeItems.spacesuitPants, EPIC),
		new ItemRarity(ToeItems.spacesuitBoots, EPIC),
		new ItemRarity(ToeItems.emeraldHelmet, EPIC),
		new ItemRarity(ToeItems.emeraldPlate, EPIC),
		new ItemRarity(ToeItems.emeraldPants, EPIC),
		new ItemRarity(ToeItems.emeraldBoots, EPIC),
		new ItemRarity(ToeItems.rubyHelmet, EPIC),
		new ItemRarity(ToeItems.rubyPlate, EPIC),
		new ItemRarity(ToeItems.rubyPants, EPIC),
		new ItemRarity(ToeItems.rubyBoots, EPIC),
		new ItemRarity(ToeItems.sapphireHelmet, EPIC),
		new ItemRarity(ToeItems.sapphirePlate, EPIC),
		new ItemRarity(ToeItems.sapphirePants, EPIC),
		new ItemRarity(ToeItems.sapphireBoots, EPIC),
		new ItemRarity(ToeItems.fishingRodWood, COMMON),
		new ItemRarity(ToeItems.fishingRodIron, UNCOMMON),
		new ItemRarity(ToeItems.fishingRodGold, SUPERIOR),
		new ItemRarity(ToeItems.shrimp, SHIT),
		new ItemRarity(ToeItems.shrimpCooked, BASIC),
		new ItemRarity(ToeItems.sardine, SHIT),
		new ItemRarity(ToeItems.sardineCooked, BASIC),
		new ItemRarity(ToeItems.tuna, BASIC),
		new ItemRarity(ToeItems.tunaCooked, COMMON),
		new ItemRarity(ToeItems.trout, BASIC),
		new ItemRarity(ToeItems.troutCooked, COMMON),
		new ItemRarity(ToeItems.pike, BASIC),
		new ItemRarity(ToeItems.pikeCooked, COMMON),
		new ItemRarity(ToeItems.catfish, COMMON),
		new ItemRarity(ToeItems.catfishCooked, UNCOMMON),
		new ItemRarity(ToeItems.bass, COMMON),
		new ItemRarity(ToeItems.bassCooked, UNCOMMON),
		new ItemRarity(ToeItems.swordfish, COMMON),
		new ItemRarity(ToeItems.swordfishCooked, UNCOMMON),
		new ItemRarity(ToeItems.monkfish, UNCOMMON),
		new ItemRarity(ToeItems.monkfishCooked, RARE),
		new ItemRarity(ToeItems.shark, RARE),
		new ItemRarity(ToeItems.sharkCooked, RARE),
		new ItemRarity(ToeItems.lunarBlade, EPIC),
		new ItemRarity(ToeItems.rapier, UNCOMMON),
		new ItemRarity(ToeItems.woodClaw, SHIT),
		new ItemRarity(ToeItems.goldClaw, COMMON),
		new ItemRarity(ToeItems.stoneClaw, SHIT),
		new ItemRarity(ToeItems.ironClaw, UNCOMMON),
		new ItemRarity(ToeItems.diamondClaw, RARE),
		new ItemRarity(ToeItems.emeraldClaw, RARE),
		new ItemRarity(ToeItems.rubyClaw, RARE),
		new ItemRarity(ToeItems.sapphireClaw, RARE),
		new ItemRarity(ToeItems.randomShit, SHIT),
		new ItemRarity(ToeItems.randomBasic, BASIC),
		new ItemRarity(ToeItems.randomCommon, COMMON),
		new ItemRarity(ToeItems.randomUncommon, UNCOMMON),
		new ItemRarity(ToeItems.randomRare, RARE),
		new ItemRarity(ToeItems.randomEpic, EPIC),
		new ItemRarity(ToeItems.randomSuperior, SUPERIOR),
		new ItemRarity(ToeItems.randomUltimate, ULTIMATE),
		new ItemRarity(ToeItems.randomLegendary, LEGENDARY),
		new ItemRarity(ToeItems.randomWildcard, WILD_CARD),
		
		//Toe Blocks
		new ItemRarity(ToeBlocks.armoury, UNATTAINABLE, false),
		new ItemRarity(ToeBlocks.utility, UNATTAINABLE, false),
		new ItemRarity(ToeBlocks.weaponry, UNATTAINABLE, false),
		new ItemRarity(ToeBlocks.exteriorDesert, UNATTAINABLE, false),
		new ItemRarity(ToeBlocks.exteriorForest, UNATTAINABLE, false),
		new ItemRarity(ToeBlocks.exteriorGlass, UNATTAINABLE, false),
		new ItemRarity(ToeBlocks.landmine, UNCOMMON),
		new ItemRarity(ToeBlocks.quicksand, SHIT),
		new ItemRarity(ToeBlocks.entranceDesert, UNATTAINABLE, false),
		new ItemRarity(ToeBlocks.breakableDesert, BASIC), //still unsure
		new ItemRarity(ToeBlocks.cash, UNATTAINABLE, false),
		new ItemRarity(ToeBlocks.hollowPortal, UNATTAINABLE, false),
		new ItemRarity(ToeBlocks.blockHollow, UNCOMMON), //not sure how hard you want this block to be to get from mobs
		new ItemRarity(ToeBlocks.hollowFire, UNATTAINABLE, false),
		new ItemRarity(ToeBlocks.beam, UNCOMMON),
		new ItemRarity(ToeBlocks.tester, UNATTAINABLE, false),
		new ItemRarity(ToeBlocks.hollowLog, BASIC),
		new ItemRarity(ToeBlocks.hollowLeaf, SHIT),
		new ItemRarity(ToeBlocks.hollowSapling, SHIT),
		new ItemRarity(ToeBlocks.hollowDirt, SHIT),
		new ItemRarity(ToeBlocks.hollowGrass, UNCOMMON),
		new ItemRarity(ToeBlocks.destination, RARE),
		new ItemRarity(ToeBlocks.lockedChest, UNATTAINABLE, false),
		new ItemRarity(ToeBlocks.randomOre, UNCOMMON),
		new ItemRarity(ToeBlocks.rubyOre, RARE),
		new ItemRarity(ToeBlocks.statueBiped, UNATTAINABLE, false), //not sure what ill be doing with this later
		new ItemRarity(ToeBlocks.atm, UNCOMMON),
		new ItemRarity(ToeBlocks.furnaceIron, UNCOMMON),
		new ItemRarity(ToeBlocks.furnaceIronLit, UNCOMMON, false),
		new ItemRarity(ToeBlocks.furnaceGold, RARE),
		new ItemRarity(ToeBlocks.furnaceGoldLit, RARE, false),
		new ItemRarity(ToeBlocks.furnaceDiamond, EPIC),
		new ItemRarity(ToeBlocks.furnaceDiamondLit, EPIC, false),
		new ItemRarity(ToeBlocks.furnaceEmerald, EPIC),
		new ItemRarity(ToeBlocks.furnaceEmeraldLit, EPIC, false),
		new ItemRarity(ToeBlocks.furnaceRedstone, UNCOMMON),
		new ItemRarity(ToeBlocks.furnaceRedstoneLit, UNCOMMON, false),
		new ItemRarity(ToeBlocks.rubyBlock, EPIC),
		new ItemRarity(ToeBlocks.portalCallisto, UNATTAINABLE, false),
		new ItemRarity(ToeBlocks.moonRock, SHIT),
		new ItemRarity(ToeBlocks.lapisLamp, COMMON),
		new ItemRarity(ToeBlocks.crystalOre, RARE),
		new ItemRarity(ToeBlocks.crystalIceOre, RARE),
		new ItemRarity(ToeBlocks.crystalBlock, EPIC),
		new ItemRarity(ToeBlocks.crystalIceBlock, EPIC),
		new ItemRarity(ToeBlocks.glassLava, BASIC),
		new ItemRarity(ToeBlocks.glassWater, BASIC),
		new ItemRarity(ToeBlocks.displayCase, BASIC),
		new ItemRarity(ToeBlocks.bauxiteOre, COMMON),
		new ItemRarity(ToeBlocks.coinCopperOre, BASIC),
		new ItemRarity(ToeBlocks.coinSilverOre, UNCOMMON),
		new ItemRarity(ToeBlocks.coinGoldOre, EPIC),
		new ItemRarity(ToeBlocks.sapphireOre, RARE),
		new ItemRarity(ToeBlocks.sapphireBlock, EPIC),
		new ItemRarity(ToeBlocks.moonBrick, BASIC),
		new ItemRarity(ToeBlocks.glassHard, COMMON),
		new ItemRarity(ToeBlocks.glassHardLava, COMMON),
		new ItemRarity(ToeBlocks.glassHardWater, COMMON),
		new ItemRarity(ToeBlocks.neptuneRock, SHIT), //currently not used
		new ItemRarity(ToeBlocks.neptuneRockSolid, SHIT), //currently not used
		new ItemRarity(ToeBlocks.neptuneBrick, BASIC),
		new ItemRarity(ToeBlocks.portalNeptune, UNATTAINABLE, false),
		new ItemRarity(ToeBlocks.iceSolid, SHIT), //currently not used
		new ItemRarity(ToeBlocks.pedestalStonebrick, BASIC),
		new ItemRarity(ToeBlocks.pedestalPlanks, SHIT),
		new ItemRarity(ToeBlocks.pedestalBrick, BASIC),
		new ItemRarity(ToeBlocks.pedestalQuartz, COMMON),
		new ItemRarity(ToeBlocks.transmutation, UNCOMMON),
		new ItemRarity(ToeBlocks.transmutationLit, UNCOMMON, false)
	};
	
	private Item item;
	private int meta;
	private int rarityLevel;
	private boolean allow;
	
	public ItemRarity(Item item, int rarityLevel) {
		this.item = item;
		this.meta = 0;
		this.rarityLevel = rarityLevel;
		this.allow = true;
	}
	
	public ItemRarity(Item item, int meta, int rarityLevel) {
		this.item = item;
		this.meta = meta;
		this.rarityLevel = rarityLevel;
		this.allow = true;
	}
	
	public ItemRarity(Block block, int rarityLevel) {
		this.item = Item.getItemFromBlock(block);
		this.meta = 0;
		this.rarityLevel = rarityLevel;
		this.allow = true;
	}
	
	public ItemRarity(Block block, int meta, int rarityLevel) {
		this.item = Item.getItemFromBlock(block);
		this.meta = meta;
		this.rarityLevel = rarityLevel;
		this.allow = true;
	}
	
	public ItemRarity(Item item, int rarityLevel, boolean shouldAllowToBeRandomItem) {
		this.item = item;
		this.meta = 0;
		this.rarityLevel = rarityLevel;
		this.allow = shouldAllowToBeRandomItem;
	}
	
	public ItemRarity(Item item, int meta, int rarityLevel, boolean shouldAllowToBeRandomItem) {
		this.item = item;
		this.meta = meta;
		this.rarityLevel = rarityLevel;
		this.allow = shouldAllowToBeRandomItem;
	}
	
	public ItemRarity(Block block, int rarityLevel, boolean shouldAllowToBeRandomItem) {
		this.item = Item.getItemFromBlock(block);
		this.meta = 0;
		this.rarityLevel = rarityLevel;
		this.allow = shouldAllowToBeRandomItem;
	}
	
	public ItemRarity(Block block, int meta, int rarityLevel, boolean shouldAllowToBeRandomItem) {
		this.item = Item.getItemFromBlock(block);
		this.meta = meta;
		this.rarityLevel = rarityLevel;
		this.allow = shouldAllowToBeRandomItem;
	}
	
	public Item getItem() {
		return this.item;
	}
	
	public int getMeta() {
		return this.meta;
	}
	
	public int getRarityLevel() {
		return this.rarityLevel;
	}
	
	public boolean isAllowed() {
		return this.allow;
	}
	
	public static int getRarityLevel(Item item) {
		for(int i=0; i<items.length; i++) {
			if(items[i].getItem() == item) {
				return items[i].getRarityLevel();
			}
		}
		
		return -3; //returns -3 if item is not in database
	}
	
	public static int getRarityLevel(Block block) {
		return getRarityLevel(Item.getItemFromBlock(block));
	}
	
	public static int getRarityLevel(ItemStack is) {
		for(int i=0; i<items.length; i++) {
			if(items[i].getItem() == is.getItem() && items[i].getMeta() == is.getItemDamage()) {
				return items[i].getRarityLevel();
			}
		}
		
		return -3; //returns -3 if item is not in database
	}
	
	public static ArrayList<Item> getItemsWithRarity(int rarity) {
		ArrayList<Item> newItems = new ArrayList<Item>();
		
		for(int i=0; i<items.length; i++) {
			if(items[i].getRarityLevel() == rarity) {
				newItems.add(items[i].getItem());
			}
		}
		
		return newItems;
	}
	
	public static ArrayList<ItemStack> getItemStacksWithRarity(int rarity) {
		ArrayList<ItemStack> newItems = new ArrayList<ItemStack>();
		
		for(int i=0; i<items.length; i++) {
			if(items[i].getRarityLevel() == rarity && items[i].isAllowed()) {
				newItems.add(new ItemStack(items[i].getItem(), 1, items[i].getMeta()));
			}
		}
		
		return newItems;
	}
	
	public static ArrayList<ItemStack> getItemStacksWithRarityIgnoreAllowed(int rarity) {
		ArrayList<ItemStack> newItems = new ArrayList<ItemStack>();
		
		for(int i=0; i<items.length; i++) {
			if(items[i].getRarityLevel() == rarity) {
				newItems.add(new ItemStack(items[i].getItem(), 1, items[i].getMeta()));
			}
		}
		
		return newItems;
	}
	
	public static ArrayList<String> getItemStringsWithRarity(int rarity) {
		ArrayList<String> newItems = new ArrayList<String>();
		
		for(int i=0; i<items.length; i++) {
			if(items[i].getRarityLevel() == rarity) {
				newItems.add(items[i].getItem().getUnlocalizedName());
			}
		}
		
		return newItems;
	}
	
	public static ArrayList<String> getItemStackStringsWithRarity(int rarity) {
		ArrayList<String> newItems = new ArrayList<String>();
		
		for(int i=0; i<items.length; i++) {
			if(items[i].getRarityLevel() == rarity && items[i].isAllowed()) {
				newItems.add(new ItemStack(items[i].getItem(), 1, items[i].getMeta()).getDisplayName());
			}
		}
		
		return newItems;
	}
	
	public static Item getRandomItemWithRarity(int rarity) {
		Random random = new Random();
		ArrayList<Item> newItems = getItemsWithRarity(rarity);
		
		int rand = random.nextInt(newItems.size());
		
		return newItems.get(rand);
	}
	
	public static ItemStack getRandomItemStackWithRarity(int rarity) {
		Random random = new Random();
		ArrayList<ItemStack> newItems = getItemStacksWithRarity(rarity);
		
		int rand = random.nextInt(newItems.size());
		
		return newItems.get(rand);
	}
	
	public static ItemStack getRandomItemStackWithRarityIgnoreAllowed(int rarity) {
		Random random = new Random();
		ArrayList<ItemStack> newItems = getItemStacksWithRarityIgnoreAllowed(rarity);
		
		int rand = random.nextInt(newItems.size());
		
		return newItems.get(rand);
	}
	
	public static String getColoredName(ItemStack is) {
		return getRarityLevel(is) == WILD_CARD ? getWildCardColor(is) : getColorFromRarity(getRarityLevel(is)) + is.getDisplayName();
	}
	
	public static String getColorFromRarity(int rarity) {
		String pre = "\u00a7";
		
		if(rarity == SHIT) { return pre + Color.gray;
		} else if(rarity == BASIC) { return pre + Color.yellow;
		} else if(rarity == COMMON) { return pre + Color.lime;
		} else if(rarity == UNCOMMON) { return pre + Color.green;
		} else if(rarity == RARE) { return pre + Color.blue;
		} else if(rarity == EPIC) { return pre + Color.aqua;
		} else if(rarity == SUPERIOR) { return pre + Color.teal;
		} else if(rarity == ULTIMATE) { return pre + Color.gold;
		} else if(rarity == LEGENDARY) { return pre + Color.purple;
		} else if(rarity == UNATTAINABLE) { return pre + Color.maroon;
		} else if(rarity == NO_VALUE) { return pre + Color.maroon;
		}

		return pre + Color.white;
	}
	
	public static String getWildCardColor(ItemStack is) {
		StringBuilder sb = new StringBuilder();
		char[] chars = is.getDisplayName().toCharArray();
		
		for(int i=0; i<chars.length; i++) {
			sb.append(getColorFromI(i) + chars[i]);
		}
		
		return sb.toString();
	}
	
	public static String getColorFromI(int i) {
		String pre = "\u00a7";
		int i2 = i%8;
		
		if(i2 == SHIT-1) { return pre + Color.gray;
		} else if(i2 == BASIC-1) { return pre + Color.yellow;
		} else if(i2 == COMMON-1) { return pre + Color.lime;
		} else if(i2 == UNCOMMON-1) { return pre + Color.green;
		} else if(i2 == RARE-1) { return pre + Color.blue;
		} else if(i2 == EPIC-1) { return pre + Color.aqua;
		} else if(i2 == SUPERIOR-1) { return pre + Color.teal;
		} else if(i2 == ULTIMATE-1) { return pre + Color.gold;
		} else if(i2 == LEGENDARY-1) { return pre + Color.purple;
		}

		return pre + Color.white;
	} 
	
	//unused
	public static boolean shouldColorName(ItemStack is) {
		return getRarityLevel(is) != SPECIAL ? true : false;
	}
	
	public static boolean canTransmute(ItemStack is) {
		return getItemStacksWithRarity(getRarityLevel(is)).size() > 1 ? true : false;
	}
}