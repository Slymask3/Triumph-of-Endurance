package com.abstractlabs.toe.init;

import java.util.ArrayList;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

import com.abstractlabs.toe.utility.LogHelper;

public class ToeRecipes {
	public static void init() {
		removeRecipe(new ItemStack(Items.fishing_rod));
	}
	
	private static void removeRecipe(ItemStack resultItem) {
	    ItemStack recipeResult = null;
	    ArrayList recipes = (ArrayList) CraftingManager.getInstance().getRecipeList();

	    for (int scan = 0; scan < recipes.size(); scan++) {
	        IRecipe tmpRecipe = (IRecipe) recipes.get(scan);

	        if (tmpRecipe instanceof ShapelessRecipes) {
	            ShapelessRecipes recipe = (ShapelessRecipes)tmpRecipe;
	            recipeResult = recipe.getRecipeOutput();
	        } else if (tmpRecipe instanceof ShapedRecipes) {
	            ShapedRecipes recipe = (ShapedRecipes)tmpRecipe;
	            recipeResult = recipe.getRecipeOutput();
	        } else if (tmpRecipe instanceof ShapedOreRecipe) {
	        	ShapedOreRecipe recipe = (ShapedOreRecipe)tmpRecipe;
	            recipeResult = recipe.getRecipeOutput();
	        } else if (tmpRecipe instanceof ShapelessOreRecipe) {
	        	ShapelessOreRecipe recipe = (ShapelessOreRecipe)tmpRecipe;
	            recipeResult = recipe.getRecipeOutput();
	        }
	        
	        if (ItemStack.areItemStacksEqual(resultItem, recipeResult)) {
	            LogHelper.info("Removed Recipe: " + recipes.get(scan) + " -> " + recipeResult);
	            recipes.remove(scan);
	        }
	    }
	}
}