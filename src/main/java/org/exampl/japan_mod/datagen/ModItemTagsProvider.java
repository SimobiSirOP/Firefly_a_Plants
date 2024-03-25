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
import org.exampl.japan_mod.util.ModTags;

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
                .add(ModBlocks.GLYCINIA_PLANKS.get().asItem())
                .add(ModBlocks.MAPLE_PLANKS.get().asItem());
        this.tag(ItemTags.DOORS)
                .add(ModBlocks.GLYCINIA_DOOR.get().asItem())
                .add(ModBlocks.MAPLE_DOOR.get().asItem());
        this.tag(ItemTags.TRAPDOORS)
                .add(ModBlocks.GLYCINIA_TRAPDOOR.get().asItem())
                .add(ModBlocks.MAPLE_DOOR.get().asItem());
        this.tag(ItemTags.SLABS)
                .add(ModBlocks.MAPLE_SLAB.get().asItem())
                .add(ModBlocks.GLYCINIA_SLAB.get().asItem());
        this.tag(ItemTags.STAIRS)
                .add(ModBlocks.MAPLE_STAIRS.get().asItem())
                .add(ModBlocks.GLYCINIA_STAIRS.get().asItem());
        this.tag(ItemTags.BUTTONS)
                .add(ModBlocks.MAPLE_BUTTON.get().asItem())
                .add(ModBlocks.GLYCINIA_BUTTON.get().asItem());
        this.tag(ItemTags.WOODEN_DOORS)
                .add(ModBlocks.GLYCINIA_DOOR.get().asItem());
        this.tag(ItemTags.WOODEN_TRAPDOORS)
                .add(ModBlocks.GLYCINIA_TRAPDOOR.get().asItem());
        this.tag(ItemTags.WOODEN_SLABS)
                .add(ModBlocks.MAPLE_SLAB.get().asItem())
                .add(ModBlocks.GLYCINIA_SLAB.get().asItem());
        this.tag(ItemTags.WOODEN_STAIRS)
                .add(ModBlocks.MAPLE_STAIRS.get().asItem())
                .add(ModBlocks.GLYCINIA_STAIRS.get().asItem());
        this.tag(ItemTags.WOODEN_PRESSURE_PLATES)
                .add(ModBlocks.MAPLE_PRESSURE_PLATE.get().asItem())
                .add(ModBlocks.GLYCINIA_PRESSURE_PLATE.get().asItem());
        this.tag(ItemTags.WOODEN_BUTTONS)
                .add(ModBlocks.MAPLE_BUTTON.get().asItem())
                .add(ModBlocks.GLYCINIA_BUTTON.get().asItem());
        this.tag(ModTags.Items.MAPLE_LOGS)
                .add(ModBlocks.MAPLE_LOG.get().asItem())
                .add(ModBlocks.MAPLE_WOOD.get().asItem());
        this.tag(ModTags.Items.GLYCINIA_LOGS)
                .add(ModBlocks.GLYCINIA_LOG.get().asItem())
                .add(ModBlocks.GLYCINIA_WOOD.get().asItem());

    }
}
