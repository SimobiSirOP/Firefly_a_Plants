package org.exampl.japan_mod.worldgen;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.NoiseThresholdProvider;
import org.exampl.japan_mod.Japan_mod;
import org.exampl.japan_mod.block.ModBlocks;


public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> PIJERYS_KEY = registerKey("pijerys");
    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(Japan_mod.MODID, name));
    }
    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {

        register(context, PIJERYS_KEY, Feature.FLOWER, new RandomPatchConfiguration(64,
                8,
                4,
                PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.PIJERYS.get())))));
    }
        private static <FC extends FeatureConfiguration, F extends Feature<FC>>void register
        (BootstapContext < ConfiguredFeature < ?, ?>>context, ResourceKey < ConfiguredFeature < ?, ?>>key, F feature, FC
        configuration){
            context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
