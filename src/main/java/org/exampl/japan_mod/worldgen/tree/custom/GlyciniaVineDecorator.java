package org.exampl.japan_mod.worldgen.tree.custom;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import org.exampl.japan_mod.block.ModBlocks;
import org.exampl.japan_mod.block.custom.GlyciniaVine;
import org.exampl.japan_mod.worldgen.ModConfiguredFeatures;

public class GlyciniaVineDecorator extends TreeDecorator {
    public static final Codec<GlyciniaVineDecorator> CODEC = Codec.unit(() -> GlyciniaVineDecorator.INSTANCE);
    public static final GlyciniaVineDecorator INSTANCE = new GlyciniaVineDecorator();
    @Override
    protected TreeDecoratorType<?> type() {
        return ModConfiguredFeatures.GLYCINIA_VINE_TREE_DECORATOR.get();
    }

    @Override
    public void place(Context context) {
        RandomSource randomsource = context.random();
        context.leaves().forEach((p_226075_) -> {
            if (randomsource.nextInt(3) > 0) {
                BlockPos blockpos = p_226075_.below();
                if (context.isAir(blockpos)) {
                    GlyciniaVine glyciniaVine = ((GlyciniaVine) ModBlocks.GLYCINIA_VINE.get());
                    context.setBlock(blockpos, ModBlocks.GLYCINIA_VINE.get().defaultBlockState().setValue(glyciniaVine.getAgeProperty(), Mth.nextInt((context.random()), 0, glyciniaVine.getMaxAge())));
                }
            }

        });
    }
}
