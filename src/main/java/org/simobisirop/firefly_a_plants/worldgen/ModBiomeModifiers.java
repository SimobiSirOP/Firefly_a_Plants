package org.simobisirop.firefly_a_plants.worldgen;

import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;
import org.simobisirop.firefly_a_plants.Firefly_a_plants;
import org.simobisirop.firefly_a_plants.entity.ModEntities;
import org.simobisirop.firefly_a_plants.entity.custom.FireflyEntity;

import java.util.List;

public class ModBiomeModifiers {

    public static final ResourceKey<BiomeModifier> MODFLOWERS_BIOME_MODIFIER = registerKey("modflowers_biome_modifier");
    public static final ResourceKey<BiomeModifier> LAVENDER_BIOME_MODIFIER = registerKey("lavender_biome_modifier");
    public static final ResourceKey<BiomeModifier> FIREFLY_BIOME_MODIFIER = registerKey("firefly_biome_modifier");

    public static void bootstrap(BootstapContext<BiomeModifier> context) {
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);
        context.register(MODFLOWERS_BIOME_MODIFIER, new ForgeBiomeModifiers.AddFeaturesBiomeModifier((biomes.getOrThrow(Tags.Biomes.IS_PLAINS)), HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.MODFLOWERS_PLACED_PLAINS_KEY)), GenerationStep.Decoration.VEGETAL_DECORATION));
        context.register(LAVENDER_BIOME_MODIFIER, new ForgeBiomeModifiers.AddFeaturesBiomeModifier((biomes.getOrThrow(Tags.Biomes.IS_PLAINS)), HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.LAVENDER_PLACED_PLAINS_KEY)), GenerationStep.Decoration.VEGETAL_DECORATION));
        context.register(FIREFLY_BIOME_MODIFIER, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(biomes.getOrThrow(Tags.Biomes.IS_SWAMP), List.of(new MobSpawnSettings.SpawnerData(ModEntities.FIREFLY.get(), 14, 4, 8))));


    }
    private static ResourceKey<BiomeModifier> registerKey(String name){
            return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(Firefly_a_plants.MODID, name));
    }
}
