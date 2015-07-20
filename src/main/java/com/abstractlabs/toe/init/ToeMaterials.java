package com.abstractlabs.toe.init;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

import com.abstractlabs.toe.reference.Reference;

public class ToeMaterials {
	public static ArmorMaterial emeraldArmor = addArmor("emerald", 33, new int[]{3, 8, 6, 3}, 10);
	public static ArmorMaterial rubyArmor = addArmor("ruby", 33, new int[]{3, 8, 6, 3}, 10);
	public static ArmorMaterial sapphireArmor = addArmor("sapphire", 33, new int[]{3, 8, 6, 3}, 10);
	public static ArmorMaterial magmaArmor = addArmor("magma", 33, new int[]{2, 5, 4, 2}, 10);
	public static ArmorMaterial nimbleArmor = addArmor("nimble", 33, new int[]{2, 5, 4, 2}, 10);
	public static ArmorMaterial dynamicArmor = addArmor("dynamic", 33, new int[]{2, 5, 4, 2}, 10);
	public static ArmorMaterial spacesuitArmor = addArmor("spacesuit", 33, new int[]{2, 5, 4, 2}, 10);
	public static ArmorMaterial suit = addArmor("suit", 33, new int[]{2, 5, 4, 2}, 10);
	
	public static ToolMaterial caneTool = addTool("cane", 0, 300, 2.0F, 1.0F, 30);
	public static ToolMaterial specialTool = addTool("special", 3, 1561, 8.0F, 3.0F, 10);
	public static ToolMaterial veinTool = addTool("vein", 3, 1561, 8.0F, 3.0F, 10);
	public static ToolMaterial smeltingTool = addTool("smelting", 0, 1561, 8.0F, 3.0F, 10);
	public static ToolMaterial stripTool = addTool("strip", 3, 1561, 16.0F, 3.0F, 10);
	public static ToolMaterial timberTool = addTool("timber", 3, 1561, 8.0F, 3.0F, 10);
	public static ToolMaterial emeraldTool = addTool("emerald", 3, 2500, 8.0F, 3.0F, 10);
	public static ToolMaterial rubyTool = addTool("ruby", 3, 2500, 8.0F, 3.0F, 10);
	public static ToolMaterial sapphireTool = addTool("sapphire", 3, 2500, 8.0F, 3.0F, 10);
	public static ToolMaterial ghostbladeTool = addTool("ghostblade", 3, 500, 3, 4, 10);
	public static ToolMaterial rapierTool = addTool("rapier", 3, 500, 3, 4, 10);
	public static ToolMaterial lunarBlade = addTool("lunar", 3, 500, 3, 4, 10);
	
	private static ArmorMaterial addArmor(String name, int durability, int[] reductionAmounts, int enchantability) {
        return EnumHelper.addArmorMaterial(Reference.MOD_ID+":"+name+"_armor", durability, reductionAmounts, enchantability);
    }
	
	private static ToolMaterial addTool(String name, int harvestLevel, int maxUses, float efficiency, float damage, int enchantability) {
        return EnumHelper.addToolMaterial(Reference.MOD_ID+":"+name+"_tool", harvestLevel, maxUses, efficiency, damage, enchantability);
    }
}