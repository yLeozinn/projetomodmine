package br.com.leozin.modz.projetomodmine.worldgen;

import br.com.leozin.modz.projetomodmine.Projetomodmine;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class ModPlacedFeatures {
    public static final ResourceKey<PlacedFeature> TUNGSTEN_ORE_PLACED_KEY = registerKey("tungsten_ore_placed");

    public static final ResourceKey<PlacedFeature> MOISSANITE_ORE_PLACED_KEY = registerKey("moissanite_ore_placed");

    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        Holder<ConfiguredFeature<?, ?>> configuredFeature = context.lookup(Registries.CONFIGURED_FEATURE)
                .getOrThrow(ModConfiguredFeatures.OVERWORLD_TUNGSTEN_ORE_KEY);

        Holder<ConfiguredFeature<?, ?>> moissaniteFeature = context.lookup(Registries.CONFIGURED_FEATURE)
                .getOrThrow(ModConfiguredFeatures.OVERWORLD_MOISSANITE_ORE_KEY);

        register(context, TUNGSTEN_ORE_PLACED_KEY, configuredFeature,
                Modifiers.commonOrePlacement(10,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));

        register(context, MOISSANITE_ORE_PLACED_KEY, moissaniteFeature,
                Modifiers.commonOrePlacement(7,
                        HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.absolute(16))
                ));
    }

    public static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(Projetomodmine.MODID, name));
    }

    private static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, modifiers));
    }

    public static class Modifiers {
        public static List<PlacementModifier> orePlacement(PlacementModifier countModifier, PlacementModifier heightModifier) {
            return List.of(countModifier, InSquarePlacement.spread(), heightModifier, BiomeFilter.biome());
        }
        public static List<PlacementModifier> commonOrePlacement(int countPerChunk, PlacementModifier heightModifier) {
            return orePlacement(CountPlacement.of(countPerChunk), heightModifier);
        }
    }
}

