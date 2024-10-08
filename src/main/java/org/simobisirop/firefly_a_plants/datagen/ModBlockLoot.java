package org.simobisirop.firefly_a_plants.datagen;

import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.registries.RegistryObject;
import org.simobisirop.firefly_a_plants.block.ModBlocks;
import org.simobisirop.firefly_a_plants.block.custom.RiceBlock;
import org.simobisirop.firefly_a_plants.item.ModItems;

import java.util.Set;

public class ModBlockLoot extends BlockLootSubProvider {
    public ModBlockLoot() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }
    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.FLOWERVINE.get());
        this.dropSelf(ModBlocks.GIBISKUS.get());
        this.dropSelf(ModBlocks.PIJERYS.get());
        this.dropSelf(ModBlocks.LAVENDER.get());
        this.dropSelf(ModBlocks.LOTOS.get());
        LootItemCondition.Builder lootitemcondition$builder = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlocks.RICE.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(RiceBlock.AGE, 2));

        this.add(ModBlocks.RICE.get(), createCropDrops(ModBlocks.RICE.get(), ModItems.RICE.get(),
                ModItems.RICE_SEEDS.get(), lootitemcondition$builder));
        this.dropSelf(ModBlocks.MAPLE_LOG.get());
        this.dropSelf(ModBlocks.MAPLE_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_MAPLE_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_MAPLE_WOOD.get());
        this.dropSelf(ModBlocks.MAPLE_PLANKS.get());
        this.dropSelf(ModBlocks.MAPLE_LOG.get());
        this.add(ModBlocks.MAPLE_LEAVES.get(), block ->
                createLeavesDrops(block, ModBlocks.MAPLE_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        this.dropSelf(ModBlocks.MAPLE_SAPLING.get());
        this.add(ModBlocks.MAPLE_DOOR.get(),
                block -> createDoorTable(ModBlocks.MAPLE_DOOR.get()));
        this.dropSelf(ModBlocks.MAPLE_TRAPDOOR.get());
        this.add(ModBlocks.MAPLE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.MAPLE_SLAB.get()));
        this.dropSelf(ModBlocks.MAPLE_STAIRS.get());
        this.dropSelf(ModBlocks.MAPLE_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.MAPLE_BUTTON.get());
        this.dropSelf(ModBlocks.MAPLE_FENCE.get());
        this.dropSelf(ModBlocks.MAPLE_FENCE_GATE.get());
        this.dropSelf(ModBlocks.WISTERIA_LOG.get());
        this.dropSelf(ModBlocks.WISTERIA_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_WISTERIA_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_WISTERIA_WOOD.get());
        this.dropSelf(ModBlocks.WISTERIA_PLANKS.get());
        this.dropSelf(ModBlocks.WISTERIA_LOG.get());
        this.add(ModBlocks.WISTERIA_LEAVES.get(), block ->
                createLeavesDrops(block, ModBlocks.WISTERIA_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        this.add(ModBlocks.WISTERIA_VINE.get(), block -> createShearsOnlyDrop(block)
                );
        this.add(ModBlocks.BIOME_FLOWER_CARPET.get(), block -> createShearsOnlyDrop(block)
        );
        this.dropSelf(ModBlocks.WISTERIA_SAPLING.get());
        this.add(ModBlocks.WISTERIA_DOOR.get(),
                block -> createDoorTable(ModBlocks.WISTERIA_DOOR.get()));
        this.dropSelf(ModBlocks.WISTERIA_TRAPDOOR.get());
        this.add(ModBlocks.WISTERIA_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.WISTERIA_SLAB.get()));
        this.dropSelf(ModBlocks.WISTERIA_STAIRS.get());
        this.dropSelf(ModBlocks.WISTERIA_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.WISTERIA_BUTTON.get());
        this.dropSelf(ModBlocks.WISTERIA_FENCE.get());
        this.dropSelf(ModBlocks.WISTERIA_FENCE_GATE.get());
    }
}
