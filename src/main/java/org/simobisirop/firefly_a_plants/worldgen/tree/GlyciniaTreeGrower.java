package org.simobisirop.firefly_a_plants.worldgen.tree;

import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import org.simobisirop.firefly_a_plants.worldgen.ModConfiguredFeatures;
import org.jetbrains.annotations.Nullable;

public class WisteriaTreeGrower extends AbstractTreeGrower {
    @Nullable
    @Override
    protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource pRandom, boolean pHasFlowers) {
        return ModConfiguredFeatures.WISTERIA_KEY;
    }

}
