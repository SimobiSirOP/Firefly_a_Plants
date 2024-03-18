package org.exampl.japan_mod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.exampl.japan_mod.Japan_mod;
import org.exampl.japan_mod.block.ModBlocks;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output,lookupProvider, Japan_mod.MODID,existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(BlockTags.LOGS)
                .add(ModBlocks.MAPLE_LOG.get())
                .add(ModBlocks.MAPLE_WOOD.get())
                .add(ModBlocks.STRIPPED_MAPLE_LOG.get())
                .add(ModBlocks.STRIPPED_MAPLE_WOOD.get())
                .add(ModBlocks.GLYCINIA_LOG.get())
                .add(ModBlocks.GLYCINIA_WOOD.get())
                .add(ModBlocks.STRIPPED_GLYCINIA_LOG.get())
                .add(ModBlocks.STRIPPED_GLYCINIA_WOOD.get());

        this.tag(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.MAPLE_LOG.get())
                .add(ModBlocks.MAPLE_WOOD.get())
                .add(ModBlocks.STRIPPED_MAPLE_LOG.get())
                .add(ModBlocks.STRIPPED_MAPLE_WOOD.get())
                .add(ModBlocks.GLYCINIA_LOG.get())
                .add(ModBlocks.GLYCINIA_WOOD.get())
                .add(ModBlocks.STRIPPED_GLYCINIA_LOG.get())
                .add(ModBlocks.STRIPPED_GLYCINIA_WOOD.get());

        this.tag(BlockTags.PLANKS)
                .add(ModBlocks.GLYCINIA_PLANKS.get())
                .add(ModBlocks.MAPLE_PLANKS.get());

        this.tag(BlockTags.DOORS)
                .add(ModBlocks.GLICINIYA_DOOR.get());
        this.tag(BlockTags.TRAPDOORS)
                .add(ModBlocks.GLICINIYA_TRAPDOOR.get());

    }
}
