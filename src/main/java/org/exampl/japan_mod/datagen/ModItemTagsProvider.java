package org.exampl.japan_mod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.world.BiomeModifier;
import org.exampl.japan_mod.Japan_mod;
import org.exampl.japan_mod.block.ModBlocks;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class ModItemTagsProvider extends ItemTagsProvider {
    public ModItemTagsProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pLookupProvider, CompletableFuture<TagLookup<Block>> pBlockTags, @Nullable ExistingFileHelper existingFileHelper){
        super(pOutput, pLookupProvider, pBlockTags, Japan_mod.MODID, existingFileHelper);

    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(ItemTags.LOGS)
                .add(ModBlocks.MAPLE_LOG.get().asItem())
                .add(ModBlocks.MAPLE_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_MAPLE_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_MAPLE_WOOD.get().asItem())
                .add(ModBlocks.GLYCINIA_LOG.get().asItem())
                .add(ModBlocks.GLYCINIA_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_GLYCINIA_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_GLYCINIA_WOOD.get().asItem());

        this.tag(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.MAPLE_LOG.get().asItem())
                .add(ModBlocks.MAPLE_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_MAPLE_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_MAPLE_WOOD.get().asItem())
                .add(ModBlocks.GLYCINIA_LOG.get().asItem())
                .add(ModBlocks.GLYCINIA_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_GLYCINIA_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_GLYCINIA_WOOD.get().asItem());

        this.tag(ItemTags.PLANKS)
                .add(ModBlocks.GLYCINIA_PLANKS.get().asItem()).add(ModBlocks.MAPLE_PLANKS.get().asItem());
        this.tag(ItemTags.DOORS)
                .add(ModBlocks.GLICINIYA_DOOR.get().asItem());
        this.tag(ItemTags.TRAPDOORS)
                .add(ModBlocks.GLICINIYA_TRAPDOOR.get().asItem());

    }
}
