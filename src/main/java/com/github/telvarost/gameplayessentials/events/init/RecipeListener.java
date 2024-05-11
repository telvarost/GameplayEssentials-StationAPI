package com.github.telvarost.gameplayessentials.events.init;

import com.github.telvarost.gameplayessentials.Config;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.ShapedRecipe;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.CraftingRecipe;
import net.minecraft.recipe.CraftingRecipeManager;
import net.modificationstation.stationapi.api.event.recipe.RecipeRegisterEvent;
import net.modificationstation.stationapi.api.recipe.CraftingRegistry;
import net.modificationstation.stationapi.api.util.Identifier;

import java.util.List;

public class RecipeListener {

    @EventListener
    public void registerRecipes(RecipeRegisterEvent event) {
        Identifier type = event.recipeId;

        if (type == RecipeRegisterEvent.Vanilla.CRAFTING_SHAPED.type()) {
            List<CraftingRecipe> recipes = CraftingRecipeManager.getInstance().getRecipes();

            for (int i = 0; i < recipes.size(); i++) {
                CraftingRecipe recipe = recipes.get(i);

                if (recipe.getOutput().itemId == Block.WOODEN_STAIRS.asItem().id) {
                    ItemStack[] inputArray = new ItemStack[9];
                    inputArray[0] = new ItemStack(Block.PLANKS.asItem(), 1);
                    inputArray[3] = new ItemStack(Block.PLANKS.asItem(), 1);
                    inputArray[4] = new ItemStack(Block.PLANKS.asItem(), 1);
                    inputArray[6] = new ItemStack(Block.PLANKS.asItem(), 1);
                    inputArray[7] = new ItemStack(Block.PLANKS.asItem(), 1);
                    inputArray[8] = new ItemStack(Block.PLANKS.asItem(), 1);
                    recipes.set(i, new ShapedRecipe(3, 3, inputArray, new ItemStack(Block.WOODEN_STAIRS.asItem(), Config.config.STAIRS_OUTPUT)));
                }

                if (recipe.getOutput().itemId == Block.COBBLESTONE_STAIRS.asItem().id) {
                    ItemStack[] inputArray = new ItemStack[9];
                    inputArray[0] = new ItemStack(Block.COBBLESTONE.asItem(), 1);
                    inputArray[3] = new ItemStack(Block.COBBLESTONE.asItem(), 1);
                    inputArray[4] = new ItemStack(Block.COBBLESTONE.asItem(), 1);
                    inputArray[6] = new ItemStack(Block.COBBLESTONE.asItem(), 1);
                    inputArray[7] = new ItemStack(Block.COBBLESTONE.asItem(), 1);
                    inputArray[8] = new ItemStack(Block.COBBLESTONE.asItem(), 1);
                    recipes.set(i, new ShapedRecipe(3, 3, inputArray, new ItemStack(Block.COBBLESTONE_STAIRS.asItem(), Config.config.STAIRS_OUTPUT)));
                }
            }
        }

        if (type == RecipeRegisterEvent.Vanilla.CRAFTING_SHAPELESS.type())
        {
            if (Config.config.SHAPELESS_JACKOLANTERN_RECIPE) {
                CraftingRegistry.addShapelessRecipe(new ItemStack(Block.JACK_O_LANTERN.asItem(), 1), Block.PUMPKIN, Block.TORCH);
            }
        }
    }
}