package org.exampl.japan_mod.datagen;

import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.registries.RegistryObject;
import org.exampl.japan_mod.block.ModBlocks;
import org.exampl.japan_mod.block.custom.RiceBlock;
import org.exampl.japan_mod.item.ModItems;

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
        this.dropSelf(ModBlocks.GLYCINIA_LOG.get());
        this.dropSelf(ModBlocks.GLYCINIA_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_GLYCINIA_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_GLYCINIA_WOOD.get());
        this.dropSelf(ModBlocks.GLYCINIA_PLANKS.get());
        this.dropSelf(ModBlocks.GLYCINIA_LOG.get());
        this.add(ModBlocks.GLYCINIA_LEAVES.get(), block ->
                createLeavesDrops(block, ModBlocks.GLYCINIA_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        this.dropSelf(ModBlocks.GLYCINIA_SAPLING.get());
        this.add(ModBlocks.GLYCINIA_DOOR.get(),
                block -> createDoorTable(ModBlocks.GLYCINIA_DOOR.get()));
        this.dropSelf(ModBlocks.GLYCINIA_TRAPDOOR.get());
        this.add(ModBlocks.GLYCINIA_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.GLYCINIA_SLAB.get()));
        this.dropSelf(ModBlocks.GLYCINIA_STAIRS.get());
        this.dropSelf(ModBlocks.GLYCINIA_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.GLYCINIA_BUTTON.get());
        this.dropSelf(ModBlocks.GLYCINIA_FENCE.get());
        this.dropSelf(ModBlocks.GLYCINIA_FENCE_GATE.get());
    }
}
