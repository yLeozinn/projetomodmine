package br.com.leozin.modz.projetomodmine.datagen;

import br.com.leozin.modz.projetomodmine.ModBlocks;
import br.com.leozin.modz.projetomodmine.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.Collections;
import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider{
    public ModBlockLootTableProvider(HolderLookup.Provider provider){
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), provider);
    }

    @Override
    protected void generate(){
        this.add(ModBlocks.TUNGSTEN_ORE.get(),
                block -> createOreDrop(block, ModItems.RAW_TUNGSTEN.get()));
        this.add(ModBlocks.MOISSANITE_ORE.get(),
                block -> createOreDrop(ModBlocks.MOISSANITE_ORE.get(), ModItems.MOISSANITE_SHARD.get())
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 3.0f)))
        );
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(e -> (Block) e.get())::iterator;
    }
}
