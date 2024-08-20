package org.simobisirop.firefly_a_plants.worldgen.tree.custom;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import org.simobisirop.firefly_a_plants.block.ModBlocks;
import org.simobisirop.firefly_a_plants.block.custom.WisteriaVine;
import org.simobisirop.firefly_a_plants.worldgen.ModConfiguredFeatures;

public class WisteriaVineDecorator extends TreeDecorator {
    public static final Codec<WisteriaVineDecorator> CODEC = Codec.unit(() -> WisteriaVineDecorator.INSTANCE);
    public static final WisteriaVineDecorator INSTANCE = new WisteriaVineDecorator();
    @Override
    protected TreeDecoratorType<?> type() {
        return ModConfiguredFeatures.WISTERIA_VINE_TREE_DECORATOR.get();
    }

    @Override
    public void place(Context context) {
        RandomSource randomsource = context.random();
        context.leaves().forEach((p_226075_) -> {
            if (randomsource.nextInt(3) > 0) {
                BlockPos blockpos = p_226075_.below();
                if (context.isAir(blockpos)) {
                    WisteriaVine wisteriaVine = ((WisteriaVine) ModBlocks.WISTERIA_VINE.get());
                    context.setBlock(blockpos, ModBlocks.WISTERIA_VINE.get().defaultBlockState().setValue(wisteriaVine.getAgeProperty(), Mth.nextInt((context.random()), 0, wisteriaVine.getMaxAge())));
                }
            }

        });
    }
}
