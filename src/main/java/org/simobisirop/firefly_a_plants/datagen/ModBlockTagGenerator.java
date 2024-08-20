package org.simobisirop.firefly_a_plants.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.simobisirop.firefly_a_plants.Firefly_a_plants;
import org.simobisirop.firefly_a_plants.block.ModBlocks;
import org.simobisirop.firefly_a_plants.util.ModTags;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output,lookupProvider, Firefly_a_plants.MODID,existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(BlockTags.LOGS)
                .add(ModBlocks.MAPLE_LOG.get())
                .add(ModBlocks.MAPLE_WOOD.get())
                .add(ModBlocks.STRIPPED_MAPLE_LOG.get())
                .add(ModBlocks.STRIPPED_MAPLE_WOOD.get())
                .add(ModBlocks.WISTERIA_LOG.get())
                .add(ModBlocks.WISTERIA_WOOD.get())
                .add(ModBlocks.STRIPPED_WISTERIA_LOG.get())
                .add(ModBlocks.STRIPPED_WISTERIA_WOOD.get());
        this.tag(BlockTags.LEAVES)
                .add(ModBlocks.MAPLE_LEAVES.get())
                .add(ModBlocks.WISTERIA_LEAVES.get());
        this.tag(BlockTags.FLOWERS)
                .add(ModBlocks.GIBISKUS.get())
                .add(ModBlocks.PIJERYS.get());
        this.tag(BlockTags.CROPS)
                .add(ModBlocks.RICE.get());
        this.tag(BlockTags.REPLACEABLE_BY_TREES)
                .add(ModBlocks.GIBISKUS.get())
                .add(ModBlocks.PIJERYS.get());

        this.tag(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.MAPLE_LOG.get())
                .add(ModBlocks.MAPLE_WOOD.get())
                .add(ModBlocks.STRIPPED_MAPLE_LOG.get())
                .add(ModBlocks.STRIPPED_MAPLE_WOOD.get())
                .add(ModBlocks.WISTERIA_LOG.get())
                .add(ModBlocks.WISTERIA_WOOD.get())
                .add(ModBlocks.STRIPPED_WISTERIA_LOG.get())
                .add(ModBlocks.STRIPPED_WISTERIA_WOOD.get());

        this.tag(ModTags.Blocks.MAPLE_LOGS)
                .add(ModBlocks.MAPLE_LOG.get())
                .add(ModBlocks.MAPLE_WOOD.get())
                .add(ModBlocks.STRIPPED_MAPLE_LOG.get())
                .add(ModBlocks.STRIPPED_MAPLE_WOOD.get());

        this.tag(ModTags.Blocks.WISTERIA_LOGS)
                .add(ModBlocks.WISTERIA_LOG.get())
                .add(ModBlocks.WISTERIA_WOOD.get())
                .add(ModBlocks.STRIPPED_WISTERIA_LOG.get())
                .add(ModBlocks.STRIPPED_WISTERIA_WOOD.get());
        // IDK HOW TO MAKE IT
        this.tag(BlockTags.PLANKS)
                .add(ModBlocks.WISTERIA_PLANKS.get())
                .add(ModBlocks.MAPLE_PLANKS.get());
        this.tag(BlockTags.DOORS)
                .add(ModBlocks.WISTERIA_DOOR.get())
                .add(ModBlocks.MAPLE_DOOR.get());
        this.tag(BlockTags.TRAPDOORS)
                .add(ModBlocks.WISTERIA_TRAPDOOR.get())
                .add(ModBlocks.MAPLE_DOOR.get());
        this.tag(BlockTags.SLABS)
                .add(ModBlocks.MAPLE_SLAB.get())
                .add(ModBlocks.WISTERIA_SLAB.get());
        this.tag(BlockTags.STAIRS)
                .add(ModBlocks.MAPLE_STAIRS.get())
                .add(ModBlocks.WISTERIA_STAIRS.get());
        this.tag(BlockTags.BUTTONS)
                .add(ModBlocks.MAPLE_BUTTON.get())
                .add(ModBlocks.WISTERIA_BUTTON.get());
        this.tag(BlockTags.FENCES)
                .add(ModBlocks.MAPLE_FENCE.get())
                .add(ModBlocks.WISTERIA_FENCE.get());
        this.tag(BlockTags.FENCE_GATES)
                .add(ModBlocks.MAPLE_FENCE_GATE.get())
                .add(ModBlocks.WISTERIA_FENCE_GATE.get());
        // WOODEN
        this.tag(BlockTags.WOODEN_DOORS)
                .add(ModBlocks.WISTERIA_DOOR.get());
        this.tag(BlockTags.WOODEN_TRAPDOORS)
                .add(ModBlocks.WISTERIA_TRAPDOOR.get());
        this.tag(BlockTags.WOODEN_SLABS)
                .add(ModBlocks.MAPLE_SLAB.get())
                .add(ModBlocks.WISTERIA_SLAB.get());
        this.tag(BlockTags.WOODEN_STAIRS)
                .add(ModBlocks.MAPLE_STAIRS.get())
                .add(ModBlocks.WISTERIA_STAIRS.get());
        this.tag(BlockTags.WOODEN_PRESSURE_PLATES)
                .add(ModBlocks.MAPLE_PRESSURE_PLATE.get())
                .add(ModBlocks.WISTERIA_PRESSURE_PLATE.get());
        this.tag(BlockTags.WOODEN_BUTTONS)
                .add(ModBlocks.MAPLE_BUTTON.get())
                .add(ModBlocks.WISTERIA_BUTTON.get());
        this.tag(BlockTags.WOODEN_FENCES)
                .add(ModBlocks.MAPLE_FENCE.get())
                .add(ModBlocks.WISTERIA_FENCE.get());
        // MOD TAGS
        this.tag(ModTags.Blocks.MAPLE_LOGS)
                .add(ModBlocks.MAPLE_LOG.get())
                .add(ModBlocks.MAPLE_WOOD.get())
                .add(ModBlocks.STRIPPED_MAPLE_LOG.get())
                .add(ModBlocks.STRIPPED_MAPLE_WOOD.get());

        this.tag(ModTags.Blocks.WISTERIA_LOGS)
                .add(ModBlocks.WISTERIA_LOG.get())
                .add(ModBlocks.WISTERIA_WOOD.get())
                .add(ModBlocks.STRIPPED_WISTERIA_LOG.get())
                .add(ModBlocks.STRIPPED_WISTERIA_WOOD.get());

    }
}
