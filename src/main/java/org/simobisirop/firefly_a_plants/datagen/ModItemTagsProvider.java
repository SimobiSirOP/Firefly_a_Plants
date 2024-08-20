package org.simobisirop.firefly_a_plants.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.simobisirop.firefly_a_plants.Firefly_a_plants;
import org.simobisirop.firefly_a_plants.block.ModBlocks;
import org.simobisirop.firefly_a_plants.item.ModItems;
import org.simobisirop.firefly_a_plants.util.ModTags;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class ModItemTagsProvider extends ItemTagsProvider {
    public ModItemTagsProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pLookupProvider, CompletableFuture<TagLookup<Block>> pBlockTags, @Nullable ExistingFileHelper existingFileHelper){
        super(pOutput, pLookupProvider, pBlockTags, Firefly_a_plants.MODID, existingFileHelper);

    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(ItemTags.BOATS)
                .add(ModItems.MAPLE_BOAT.get().asItem())
                .add(ModItems.WISTERIA_BOAT.get().asItem());
        this.tag(ItemTags.CHEST_BOATS)
                .add(ModItems.MAPLE_CHEST_BOAT.get().asItem())
                .add(ModItems.WISTERIA_CHEST_BOAT.get().asItem());
        this.tag(ItemTags.LOGS)
                .add(ModBlocks.MAPLE_LOG.get().asItem())
                .add(ModBlocks.MAPLE_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_MAPLE_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_MAPLE_WOOD.get().asItem())
                .add(ModBlocks.WISTERIA_LOG.get().asItem())
                .add(ModBlocks.WISTERIA_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_WISTERIA_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_WISTERIA_WOOD.get().asItem());
        this.tag(ItemTags.LEAVES)
                .add(ModBlocks.MAPLE_LEAVES.get().asItem())
                .add(ModBlocks.WISTERIA_LEAVES.get().asItem());
        this.tag(ItemTags.FLOWERS)
                .add(ModBlocks.GIBISKUS.get().asItem())
                .add(ModBlocks.PIJERYS.get().asItem());
        this.tag(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.MAPLE_LOG.get().asItem())
                .add(ModBlocks.MAPLE_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_MAPLE_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_MAPLE_WOOD.get().asItem())
                .add(ModBlocks.WISTERIA_LOG.get().asItem())
                .add(ModBlocks.WISTERIA_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_WISTERIA_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_WISTERIA_WOOD.get().asItem());

        this.tag(ModTags.Items.MAPLE_LOGS)
                .add(ModBlocks.MAPLE_LOG.get().asItem())
                .add(ModBlocks.MAPLE_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_MAPLE_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_MAPLE_WOOD.get().asItem());

        this.tag(ModTags.Items.WISTERIA_LOGS)
                .add(ModBlocks.WISTERIA_LOG.get().asItem())
                .add(ModBlocks.WISTERIA_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_WISTERIA_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_WISTERIA_WOOD.get().asItem());

        this.tag(ItemTags.PLANKS)
                .add(ModBlocks.WISTERIA_PLANKS.get().asItem())
                .add(ModBlocks.MAPLE_PLANKS.get().asItem());
        this.tag(ItemTags.DOORS)
                .add(ModBlocks.WISTERIA_DOOR.get().asItem())
                .add(ModBlocks.MAPLE_DOOR.get().asItem());
        this.tag(ItemTags.TRAPDOORS)
                .add(ModBlocks.WISTERIA_TRAPDOOR.get().asItem())
                .add(ModBlocks.MAPLE_DOOR.get().asItem());
        this.tag(ItemTags.SLABS)
                .add(ModBlocks.MAPLE_SLAB.get().asItem())
                .add(ModBlocks.WISTERIA_SLAB.get().asItem());
        this.tag(ItemTags.STAIRS)
                .add(ModBlocks.MAPLE_STAIRS.get().asItem())
                .add(ModBlocks.WISTERIA_STAIRS.get().asItem());
        this.tag(ItemTags.BUTTONS)
                .add(ModBlocks.MAPLE_BUTTON.get().asItem())
                .add(ModBlocks.WISTERIA_BUTTON.get().asItem());
        this.tag(ItemTags.FENCES)
                .add(ModBlocks.MAPLE_FENCE.get().asItem())
                .add(ModBlocks.WISTERIA_FENCE.get().asItem());
        this.tag(ItemTags.FENCE_GATES)
                .add(ModBlocks.MAPLE_FENCE_GATE.get().asItem())
                .add(ModBlocks.WISTERIA_FENCE_GATE.get().asItem());
        this.tag(ItemTags.WOODEN_DOORS)
                .add(ModBlocks.WISTERIA_DOOR.get().asItem());
        this.tag(ItemTags.WOODEN_TRAPDOORS)
                .add(ModBlocks.WISTERIA_TRAPDOOR.get().asItem());
        this.tag(ItemTags.WOODEN_SLABS)
                .add(ModBlocks.MAPLE_SLAB.get().asItem())
                .add(ModBlocks.WISTERIA_SLAB.get().asItem());
        this.tag(ItemTags.WOODEN_STAIRS)
                .add(ModBlocks.MAPLE_STAIRS.get().asItem())
                .add(ModBlocks.WISTERIA_STAIRS.get().asItem());
        this.tag(ItemTags.WOODEN_PRESSURE_PLATES)
                .add(ModBlocks.MAPLE_PRESSURE_PLATE.get().asItem())
                .add(ModBlocks.WISTERIA_PRESSURE_PLATE.get().asItem());
        this.tag(ItemTags.WOODEN_BUTTONS)
                .add(ModBlocks.MAPLE_BUTTON.get().asItem())
                .add(ModBlocks.WISTERIA_BUTTON.get().asItem());

    }
}
