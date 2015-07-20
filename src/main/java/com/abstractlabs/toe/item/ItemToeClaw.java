package com.abstractlabs.toe.item;

import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IIcon;

import com.abstractlabs.toe.creativetab.ToeTab;
import com.abstractlabs.toe.reference.Reference;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemToeClaw extends ItemTool {
    private static final Set set = Sets.newHashSet(new Block[] {Blocks.cobblestone, Blocks.double_stone_slab, Blocks.stone_slab, Blocks.stone, Blocks.sandstone, Blocks.mossy_cobblestone, Blocks.iron_ore, Blocks.iron_block, Blocks.coal_ore, Blocks.gold_block, Blocks.gold_ore, Blocks.diamond_ore, Blocks.diamond_block, Blocks.ice, Blocks.netherrack, Blocks.lapis_ore, Blocks.lapis_block, Blocks.redstone_ore, Blocks.lit_redstone_ore, Blocks.rail, Blocks.detector_rail, Blocks.golden_rail, Blocks.activator_rail});
    private float damage;
    
    public ItemToeClaw(String name, Item.ToolMaterial material) {
        super(2.0F, material, set);
	    this.setCreativeTab(ToeTab.TOE_TAB);
	    this.setUnlocalizedName(name);
	    this.setTextureName(Reference.MOD_ID+":"+name);
        this.damage = 4.0F + material.getDamageVsEntity();
    }

    @Override
    public String getUnlocalizedName() {
        return String.format("item.%s%s", "toe" + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack) {
        return String.format("item.%s%s", "toe" + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }
    
    protected String getUnwrappedUnlocalizedName(String unlocalizedName) {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }
    
    public boolean func_150897_b(Block block) {
    	if(block == Blocks.obsidian) {
        	return this.toolMaterial.getHarvestLevel() == 3;
        } else if(block == Blocks.web) {
        	return true;
        } else {
        	if(block != Blocks.diamond_block && block != Blocks.diamond_ore) {
        		if(block != Blocks.emerald_ore && block != Blocks.emerald_block) {
        			if(block != Blocks.gold_block && block != Blocks.gold_ore) {
        				if(block != Blocks.iron_block && block != Blocks.iron_ore) {
        					if(block != Blocks.lapis_block && block != Blocks.lapis_ore) {
        						if(block != Blocks.redstone_ore && block != Blocks.lit_redstone_ore) {
        							if(block.getMaterial() == Material.rock) {
        								return true;
        							} else if(block.getMaterial() == Material.iron) {
        								return true;
        							} else if(block.getMaterial() == Material.anvil) {
        								return this.toolMaterial.getHarvestLevel() >= 2;
        							}
        							return this.toolMaterial.getHarvestLevel() >= 1;
        						}
    							return this.toolMaterial.getHarvestLevel() >= 1;
        					}
							return this.toolMaterial.getHarvestLevel() >= 2;
        				}
						return this.toolMaterial.getHarvestLevel() >= 2;
        			}
					return this.toolMaterial.getHarvestLevel() >= 2;
        		}
        	}
        }
    	
    	return false;
    	
    	//vanilla's single line if statement
        //return block == Blocks.obsidian ? this.toolMaterial.getHarvestLevel() == 3 : (block != Blocks.diamond_block && block != Blocks.diamond_ore ? (block != Blocks.emerald_ore && block != Blocks.emerald_block ? (block != Blocks.gold_block && block != Blocks.gold_ore ? (block != Blocks.iron_block && block != Blocks.iron_ore ? (block != Blocks.lapis_block && block != Blocks.lapis_ore ? (block != Blocks.redstone_ore && block != Blocks.lit_redstone_ore ? (block.getMaterial() == Material.rock ? true : (block.getMaterial() == Material.iron ? true : block.getMaterial() == Material.anvil)) : this.toolMaterial.getHarvestLevel() >= 2) : this.toolMaterial.getHarvestLevel() >= 1) : this.toolMaterial.getHarvestLevel() >= 1) : this.toolMaterial.getHarvestLevel() >= 2) : this.toolMaterial.getHarvestLevel() >= 2) : this.toolMaterial.getHarvestLevel() >= 2);
    }

    public float func_150893_a(ItemStack is, Block block) {
    	if (block == Blocks.web) {
            return 15.0F;
        } else if(block.getMaterial() != Material.iron && block.getMaterial() != Material.anvil && block.getMaterial() != Material.rock) {
    		return super.func_150893_a(is, block);
    	} else {
    		return this.efficiencyOnProperMaterial;
    	}
    	
    	//vanilla's single line if statement
        //return block.getMaterial() != Material.iron && block.getMaterial() != Material.anvil && block.getMaterial() != Material.rock ? super.func_150893_a(is, block) : this.efficiencyOnProperMaterial;
    }
    
    public boolean hitEntity(ItemStack is, EntityLivingBase victim, EntityLivingBase attacker) {
    	is.damageItem(1, attacker);
        return true;
    }
    
    public Multimap getItemAttributeModifiers() {
        Multimap multimap = super.getItemAttributeModifiers();
        multimap.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(field_111210_e, "Weapon modifier", (double)this.damage, 0));
        return multimap;
    }
    
    //color code
    
    @SideOnly(Side.CLIENT)
    public int getColorFromItemStack(ItemStack is, int par2) {
        if (par2 > 0) {
            return 16777215;
        } else {
            int j = this.getColor(is);

            if (j < 0) {
                j = 16777215;
            }

            return j;
        }
    }
    
    /**
     * Return whether the specified armor ItemStack has a color.
     */
    public boolean hasColor(ItemStack is) {
        return !is.hasTagCompound() ? false : (!is.getTagCompound().hasKey("display", 10) ? false : is.getTagCompound().getCompoundTag("display").hasKey("color", 3));
    }

    /**
     * Return the color for the specified armor ItemStack.
     */
    public int getColor(ItemStack is) {
        NBTTagCompound tag = is.getTagCompound();

        if (tag == null) {
            return 10511680;
        } else {
            NBTTagCompound tag1 = tag.getCompoundTag("display");
            return tag1 == null ? 10511680 : (tag1.hasKey("color", 3) ? tag1.getInteger("color") : 10511680);
        }
    }
    
    public void dye(ItemStack is, int color) {
        NBTTagCompound nbttagcompound = is.getTagCompound();

        if (nbttagcompound == null) {
            nbttagcompound = new NBTTagCompound();
            is.setTagCompound(nbttagcompound);
        }

        NBTTagCompound nbttagcompound1 = nbttagcompound.getCompoundTag("display");

        if (!nbttagcompound.hasKey("display", 10)) {
            nbttagcompound.setTag("display", nbttagcompound1);
        }

        nbttagcompound1.setInteger("color", color);
    }
    
    public void removeColor(ItemStack is) {
        NBTTagCompound nbttagcompound = is.getTagCompound();

        if (nbttagcompound != null) {
            NBTTagCompound nbttagcompound1 = nbttagcompound.getCompoundTag("display");

            if (nbttagcompound1.hasKey("color")) {
                nbttagcompound1.removeTag("color");
            }
        }
    }
    
    //overlay code
    
    @SideOnly(Side.CLIENT)
    private IIcon overlayIcon;
    
    @SideOnly(Side.CLIENT)
    public boolean requiresMultipleRenderPasses() {
        return true;
    }
    
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamageForRenderPass(int meta, int pass) {
        return pass == 1 ? this.overlayIcon : super.getIconFromDamageForRenderPass(meta, pass);
    }
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister ir) {
        this.itemIcon = ir.registerIcon(Reference.MOD_ID+":claw");
        this.overlayIcon = ir.registerIcon(this.getIconString()+"_overlay");
    }
}