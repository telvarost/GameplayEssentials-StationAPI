package com.github.telvarost.gameplayessentials.events.init;

import com.github.telvarost.gameplayessentials.Config;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.block.BlockBase;
import net.minecraft.item.ItemInstance;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeRegistry;
import net.minecraft.recipe.ShapedRecipe;
import net.modificationstation.stationapi.api.event.recipe.RecipeRegisterEvent;
import net.modificationstation.stationapi.api.recipe.CraftingRegistry;
import net.modificationstation.stationapi.api.util.Identifier;

import java.util.List;

public class RecipeListener {

    @EventListener
    public void registerRecipes(RecipeRegisterEvent event) {
        Identifier type = event.recipeId;

        if (type == RecipeRegisterEvent.Vanilla.CRAFTING_SHAPED.type()) {
            List<Recipe> recipes = RecipeRegistry.getInstance().getRecipes();

            for (int i = 0; i < recipes.size(); i++) {
                Recipe recipe = recipes.get(i);

                if (recipe.getOutput().itemId == BlockBase.WOOD_STAIRS.asItem().id) {
                    ItemInstance[] inputArray = new ItemInstance[9];
                    inputArray[0] = new ItemInstance(BlockBase.WOOD.asItem(), 1);
                    inputArray[3] = new ItemInstance(BlockBase.WOOD.asItem(), 1);
                    inputArray[4] = new ItemInstance(BlockBase.WOOD.asItem(), 1);
                    inputArray[6] = new ItemInstance(BlockBase.WOOD.asItem(), 1);
                    inputArray[7] = new ItemInstance(BlockBase.WOOD.asItem(), 1);
                    inputArray[8] = new ItemInstance(BlockBase.WOOD.asItem(), 1);
                    recipes.set(i, new ShapedRecipe(3, 3, inputArray, new ItemInstance(BlockBase.WOOD_STAIRS.asItem(), Config.config.STAIRS_OUTPUT)));
                }

                if (recipe.getOutput().itemId == BlockBase.COBBLESTONE_STAIRS.asItem().id) {
                    ItemInstance[] inputArray = new ItemInstance[9];
                    inputArray[0] = new ItemInstance(BlockBase.COBBLESTONE.asItem(), 1);
                    inputArray[3] = new ItemInstance(BlockBase.COBBLESTONE.asItem(), 1);
                    inputArray[4] = new ItemInstance(BlockBase.COBBLESTONE.asItem(), 1);
                    inputArray[6] = new ItemInstance(BlockBase.COBBLESTONE.asItem(), 1);
                    inputArray[7] = new ItemInstance(BlockBase.COBBLESTONE.asItem(), 1);
                    inputArray[8] = new ItemInstance(BlockBase.COBBLESTONE.asItem(), 1);
                    recipes.set(i, new ShapedRecipe(3, 3, inputArray, new ItemInstance(BlockBase.COBBLESTONE_STAIRS.asItem(), Config.config.STAIRS_OUTPUT)));
                }
            }
        }

        if (type == RecipeRegisterEvent.Vanilla.CRAFTING_SHAPELESS.type())
        {
            if (Config.config.SHAPELESS_JACKOLANTERN_RECIPE) {
                CraftingRegistry.addShapelessRecipe(new ItemInstance(BlockBase.JACK_O_LANTERN.asItem(), 1), BlockBase.PUMPKIN, BlockBase.TORCH);
            }
        }
    }
}