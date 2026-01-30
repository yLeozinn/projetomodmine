package br.com.leozin.modz.projetomodmine.datagen;

import br.com.leozin.modz.projetomodmine.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
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

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.MOISSANITE.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.MOISSANITE_SHARD.get()).unlockedBy("has_shard", has(ModItems.MOISSANITE_SHARD.get()))
                .save(output);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.MOISSANITE_SHARD.get(), 9)
                .requires(ModItems.MOISSANITE.get())
                .unlockedBy("has_gem", has(ModItems.MOISSANITE.get()))
                .save(output, "moissanite_shards_from_gem");
    }

}

