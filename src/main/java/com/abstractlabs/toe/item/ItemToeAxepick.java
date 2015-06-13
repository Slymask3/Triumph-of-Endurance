package com.abstractlabs.toe.item;

import java.util.List;
import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.util.EnumChatFormatting;

import com.abstractlabs.toe.creativetab.ToeTab;
import com.abstractlabs.toe.init.ToeItems;
import com.google.common.collect.Sets;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemToeAxepick extends ItemTool {
	private static final Set set = Sets.newHashSet(new Block[] {Blocks.cobblestone, Blocks.double_stone_slab, Blocks.stone_slab, Blocks.stone, Blocks.sandstone, Blocks.mossy_cobblestone, Blocks.iron_ore, Blocks.iron_block, Blocks.coal_ore, Blocks.gold_block, Blocks.gold_ore, Blocks.diamond_ore, Blocks.diamond_block, Blocks.ice, Blocks.netherrack, Blocks.lapis_ore, Blocks.lapis_block, Blocks.redstone_ore, Blocks.lit_redstone_ore, Blocks.rail, Blocks.detector_rail, Blocks.golden_rail, Blocks.activator_rail, Blocks.planks, Blocks.bookshelf, Blocks.log, Blocks.log2, Blocks.chest, Blocks.pumpkin, Blocks.lit_pumpkin});
    
	public ItemToeAxepick(ToolMaterial material, boolean addToTab) {
		super(3.0F, material, set);
		if(addToTab) {
	        this.setCreativeTab(ToeTab.TOE_TAB);
		}
	}

    public boolean func_150897_b(Block block) {
        return block == Blocks.obsidian ? this.toolMaterial.getHarvestLevel() == 3 : (block != Blocks.diamond_block && block != Blocks.diamond_ore ? (block != Blocks.emerald_ore && block != Blocks.emerald_block ? (block != Blocks.gold_block && block != Blocks.gold_ore ? (block != Blocks.iron_block && block != Blocks.iron_ore ? (block != Blocks.lapis_block && block != Blocks.lapis_ore ? (block != Blocks.redstone_ore && block != Blocks.lit_redstone_ore ? (block.getMaterial() == Material.rock ? true : (block.getMaterial() == Material.iron ? true : block.getMaterial() == Material.anvil)) : this.toolMaterial.getHarvestLevel() >= 2) : this.toolMaterial.getHarvestLevel() >= 1) : this.toolMaterial.getHarvestLevel() >= 1) : this.toolMaterial.getHarvestLevel() >= 2) : this.toolMaterial.getHarvestLevel() >= 2) : this.toolMaterial.getHarvestLevel() >= 2);
    }

    public float func_150893_a(ItemStack is, Block block) {
        return block.getMaterial() != Material.iron && block.getMaterial() != Material.anvil && block.getMaterial() != Material.rock && block.getMaterial() != Material.wood && block.getMaterial() != Material.plants && block.getMaterial() != Material.vine? super.func_150893_a(is, block) : this.efficiencyOnProperMaterial;
    }
	
	@Override
    public String getUnlocalizedName() {
        return String.format("item.%s%s", "toe" + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack) {
        return String.format("item.%s%s", "toe" + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        itemIcon = iconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
    }

    protected String getUnwrappedUnlocalizedName(String unlocalizedName) {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }
    
//    public ItemStack onItemRightClick(ItemStack is, World world, EntityPlayer player) {
//        MovingObjectPosition mop = this.getMovingObjectPositionFromPlayer(world, player, true);
//
//        if (mop == null) {
//            return is;
//        } else {
//        	Block block = world.getBlock(mop.blockX, mop.blockY, mop.blockZ);
//	    	if(is.getItem() == ToeItems.diamondAxepick && block == Blocks.stone) {
//	    		return new ItemStack(ToeItems.diamondAxepick_pick, 1, is.getItemDamage());
//	    	} else if(is.getItem() == ToeItems.diamondAxepick_pick && block == Blocks.log) {
//	    		return new ItemStack(ToeItems.diamondAxepick, 1, is.getItemDamage());
//	    	}
//        }
//    	
//        return is;
//    }
    
    public void addInformation(ItemStack is, EntityPlayer player, List list, boolean par4) {
		int max = (is.getMaxDamage()) + 1;
		int dmg = (is.getMaxDamage() - is.getItemDamage()) + 1;
		String state = "";
		
		if(is.getItem() == ToeItems.woodAxepick || is.getItem() == ToeItems.stoneAxepick || is.getItem() == ToeItems.ironAxepick || is.getItem() == ToeItems.goldAxepick || is.getItem() == ToeItems.diamondAxepick) {
			state = "Axe";
		} else if(is.getItem() == ToeItems.woodAxepick_pick || is.getItem() == ToeItems.stoneAxepick_pick || is.getItem() == ToeItems.ironAxepick_pick || is.getItem() == ToeItems.goldAxepick_pick || is.getItem() == ToeItems.diamondAxepick_pick) {
			state = "Pickaxe";
		}
		
		list.add(EnumChatFormatting.AQUA + "Mode: " + state);
		list.add(EnumChatFormatting.GREEN + "Uses: " + dmg + "/" + max);
	}
}
