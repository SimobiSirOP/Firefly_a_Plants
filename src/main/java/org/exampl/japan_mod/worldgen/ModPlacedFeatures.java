package org.exampl.japan_mod.worldgen;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;
import org.exampl.japan_mod.Japan_mod;
import org.exampl.japan_mod.block.ModBlocks;

import java.util.List;

public class ModPlacedFeatures {

    public static final ResourceKey<PlacedFeature> MAPLE_PLACED_KEY = registerKey("maple_placed");
    public static final ResourceKey<PlacedFeature> GLYCINIA_PLACED_KEY = registerKey("glycinia_placed");
    public static final ResourceKey<PlacedFeature> MODFLOWERS_PLACED_PLAINS_KEY = registerKey("modflowers_placed_plains_key");
    public static final ResourceKey<PlacedFeature> MODFLOWERS_PLACED_BIOME_KEY = registerKey("modflowers_placed_biome_key");
    public static final ResourceKey<PlacedFeature> LAVENDER_PLACED_PLAINS_KEY = registerKey("lavender_placed_common_key");
    public static final ResourceKey<PlacedFeature> LAVENDER_PLACED_BIOME_KEY = registerKey("lavender_placed_biome_key");
    public static final ResourceKey<PlacedFeature> BIOME_FLOWER_CARPET_PLACED_KEY = registerKey("biome_flower_carpet_placed_key");
    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);
        register(context, LAVENDER_PLACED_PLAINS_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.LAVENDER_KEY), List.of(RarityFilter.onAverageOnceEvery(64), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
        register(context, MODFLOWERS_PLACED_PLAINS_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.MODFLOWERS_KEY), List.of(RarityFilter.onAverageOnceEvery(64), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
        register(context, MAPLE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.MAPLE_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(5, 0.1f, 1),
                        ModBlocks.MAPLE_SAPLING.get()));
        register(context, GLYCINIA_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.GLYCINIA_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(5, 0.1f, 1),
                        ModBlocks.GLYCINIA_SAPLING.get()));
   


        register(context, LAVENDER_PLACED_BIOME_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.LAVENDER_KEY), List.of(RarityFilter.onAverageOnceEvery(8), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
        register(context, MODFLOWERS_PLACED_BIOME_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.MODFLOWERS_KEY), List.of(RarityFilter.onAverageOnceEvery(8), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
        register(context, BIOME_FLOWER_CARPET_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.BIOME_FLOWER_CARPET_KEY), List.of(RarityFilter.onAverageOnceEvery(2), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
    }


    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(Japan_mod.MODID, name));
    }
    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));

    }
}

