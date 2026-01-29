package br.com.leozin.modz.projetomodmine.datagen;

import br.com.leozin.modz.projetomodmine.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider){
        super(output, lookupProvider);
    }

    @Override
    protected  void buildRecipes(RecipeOutput output) {
        List<net.minecraft.world.level.ItemLike> tungstenSmeltables = List.of(ModItems.RAW_TUNGSTEN.get());

        oreSmelting(output, tungstenSmeltables, RecipeCategory.MISC, ModItems.TUNGSTEN_INGOT.get(), 0.7f, 200, "tungsten_ingot");

        oreBlasting(output, tungstenSmeltables, RecipeCategory.MISC, ModItems.TUNGSTEN_INGOT.get(), 0.7f, 100, "tungsten_ingot");
    }

}

