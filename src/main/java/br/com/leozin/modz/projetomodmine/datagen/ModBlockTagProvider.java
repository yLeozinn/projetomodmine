package br.com.leozin.modz.projetomodmine.datagen;

import br.com.leozin.modz.projetomodmine.ModBlocks;
import br.com.leozin.modz.projetomodmine.Projetomodmine;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;
import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Projetomodmine.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        // cria o arquivo pickaxe.json
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.TUNGSTEN_ORE.get())
                .add(ModBlocks.MOISSANITE_ORE.get());

        // cria o arquivo needs_iron_tool.json
        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.TUNGSTEN_ORE.get());

        // cria o arquivo needs_diamond_tool.json
        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.MOISSANITE_ORE.get());
    }
}