package org.exampl.japan_mod.worldgen;

import com.google.common.collect.ImmutableList;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FancyFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.minecraft.world.level.levelgen.feature.trunkplacers.FancyTrunkPlacer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import org.exampl.japan_mod.Japan_mod;
import org.exampl.japan_mod.block.ModBlocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.stateproviders.NoiseProvider;
import net.minecraft.world.level.levelgen.synth.NormalNoise;
import org.exampl.japan_mod.worldgen.tree.custom.GlyciniaVineDecorator;

import java.util.List;
import java.util.OptionalInt;


public class ModConfiguredFeatures {
    private static final DeferredRegister<TreeDecoratorType<?>> TREE_DECORATOR_TYPE_DEFERRED_REGISTER = DeferredRegister.create(Registries.TREE_DECORATOR_TYPE, Japan_mod.MODID);
    public static final RegistryObject<TreeDecoratorType<GlyciniaVineDecorator>> GLYCINIA_VINE_TREE_DECORATOR = TREE_DECORATOR_TYPE_DEFERRED_REGISTER.register("glycinia_vine",
            ()-> new TreeDecoratorType<>(GlyciniaVineDecorator.CODEC));
    public static final ResourceKey<ConfiguredFeature<?, ?>> MAPLE_KEY = registerKey("maple_key");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MODFLOWERS_KEY = registerKey("modflowers");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LAVENDER_KEY = registerKey("lavender");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GLYCINIA_KEY = registerKey("glycinia");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BIOME_FLOWER_CARPET_KEY = registerKey("biome_flower_carpet");
    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(Japan_mod.MODID, name));
    }
    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        register(context, MAPLE_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.MAPLE_LOG.get()),
                new FancyTrunkPlacer(3, 11, 0),

                BlockStateProvider.simple(ModBlocks.MAPLE_LEAVES.get()),
                new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(4), 4),

                new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4))).build());

        register(context, LAVENDER_KEY, Feature.RANDOM_PATCH, FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.LAVENDER.get()))));

        register(context, MODFLOWERS_KEY, Feature.FLOWER, new RandomPatchConfiguration(126,
                8,
                4,
                PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new NoiseProvider(2345L, new NormalNoise.NoiseParameters(0,1.0D), 0.5F, List.of(ModBlocks.PIJERYS.get().defaultBlockState(), ModBlocks.GIBISKUS.get().defaultBlockState()))))));
        register(context, GLYCINIA_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.GLYCINIA_LOG.get()),
                new FancyTrunkPlacer(3,11,0),

                BlockStateProvider.simple(ModBlocks.GLYCINIA_LEAVES.get()),
                new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(4), 4),

                new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4))).decorators(ImmutableList.of(GlyciniaVineDecorator.INSTANCE)).build());
        register(context, BIOME_FLOWER_CARPET_KEY, Feature.RANDOM_PATCH, FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.BIOME_FLOWER_CARPET.get()))));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
    public static void register(IEventBus eventBus){
        TREE_DECORATOR_TYPE_DEFERRED_REGISTER.register(eventBus);
    }
}
