package org.simobisirop.firefly_a_plants.datagen;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.EnterBlockTrigger;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import org.simobisirop.firefly_a_plants.Firefly_a_plants;
import org.simobisirop.firefly_a_plants.block.ModBlocks;
import org.simobisirop.firefly_a_plants.item.ModItems;
import org.simobisirop.firefly_a_plants.util.ModTags;

import java.util.Optional;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(RecipeOutput writer) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MAPLE_PLANKS.get(), 4)
                        .requires(ModTags.Items.MAPLE_LOGS)
                .unlockedBy(getHasName(ModBlocks.MAPLE_LOG.get()), has(ModBlocks.MAPLE_LOG.get()))
                .save(writer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MAPLE_WOOD.get(), 3)
                .pattern("SS")
                .pattern("SS")
                .define('S', ModBlocks.MAPLE_LOG.get())
                .unlockedBy(getHasName(ModBlocks.MAPLE_LOG.get()), has(ModBlocks.MAPLE_LOG.get()))
                .save(writer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.MAPLE_DOOR.get(),3)
                .pattern("MM")
                .pattern("MM")
                .pattern("MM")
                .define('M', ModBlocks.MAPLE_PLANKS.get())
                .unlockedBy(getHasName(ModBlocks.MAPLE_PLANKS.get()), has(ModBlocks.MAPLE_PLANKS.get()))
                .save(writer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.MAPLE_TRAPDOOR.get(),2)
                .pattern("MMM")
                .pattern("MMM")
                .define('M', ModBlocks.MAPLE_PLANKS.get())
                .unlockedBy(getHasName(ModBlocks.MAPLE_PLANKS.get()), has(ModBlocks.MAPLE_PLANKS.get()))
                .save(writer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.MAPLE_SLAB.get(),6)
                .pattern("MMM")
                .unlockedBy(getHasName(ModBlocks.MAPLE_PLANKS.get()), has(ModBlocks.MAPLE_PLANKS.get()))
                .define('M', ModBlocks.MAPLE_PLANKS.get())
                .save(writer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.MAPLE_STAIRS.get(),4)
                .pattern("M  ")
                .pattern("MM ")
                .pattern("MMM")
                .unlockedBy(getHasName(ModBlocks.MAPLE_PLANKS.get()), has(ModBlocks.MAPLE_PLANKS.get()))
                .define('M', ModBlocks.MAPLE_PLANKS.get())
                .save(writer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.MAPLE_PRESSURE_PLATE.get(),1)
                .pattern("MM")
                .define('M', ModBlocks.MAPLE_PLANKS.get())
                .unlockedBy(getHasName(ModBlocks.MAPLE_PLANKS.get()), has(ModBlocks.MAPLE_PLANKS.get()))
                .save(writer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModBlocks.MAPLE_BUTTON.get(),1)
                .requires(ModBlocks.MAPLE_PLANKS.get())
                .unlockedBy(getHasName(ModBlocks.MAPLE_PLANKS.get()), has(ModBlocks.MAPLE_PLANKS.get()))
                .save(writer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.MAPLE_FENCE.get(),3)
                .pattern("MSM")
                .pattern("MSM")
                .define('M', ModBlocks.MAPLE_PLANKS.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModBlocks.MAPLE_PLANKS.get()), has(ModBlocks.MAPLE_PLANKS.get()))
                .save(writer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.MAPLE_FENCE_GATE.get(),3)
                .pattern("SMS")
                .pattern("SMS")
                .define('M', ModBlocks.MAPLE_PLANKS.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModBlocks.MAPLE_PLANKS.get()), has(ModBlocks.MAPLE_PLANKS.get()))
                .save(writer);
        ShapedRecipeBuilder.shaped(RecipeCategory.TRANSPORTATION, ModItems.MAPLE_BOAT.get())
                .pattern("M M")
                .pattern("MMM")
                .define('M', ModBlocks.MAPLE_PLANKS.get())
                .unlockedBy(getHasName(ModItems.MAPLE_BOAT.get()), insideOf(Blocks.WATER))
                .save(writer);
        ShapedRecipeBuilder.shaped(RecipeCategory.TRANSPORTATION, ModItems.MAPLE_CHEST_BOAT.get())
                .pattern("MCM")
                .pattern("MMM")
                .define('M', ModBlocks.MAPLE_PLANKS.get())
                .define('C', Items.CHEST)
                .unlockedBy(getHasName(ModItems.MAPLE_CHEST_BOAT.get()), insideOf(Blocks.WATER))
                .save(writer);
        ShapedRecipeBuilder.shaped(RecipeCategory.TRANSPORTATION, ModItems.MAPLE_CHEST_BOAT.get())
                .pattern("C")
                .pattern("M")
                .define('M', ModItems.MAPLE_BOAT.get())
                .define('C', Items.CHEST)
                .unlockedBy(getHasName(ModItems.MAPLE_CHEST_BOAT.get()), insideOf(Blocks.WATER))
                .save(writer, new ResourceLocation(Firefly_a_plants.MODID, "maple_chest_boat_alt"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.WISTERIA_PLANKS.get(), 4)
                .requires(ModTags.Items.WISTERIA_LOGS)
                .unlockedBy(getHasName(ModBlocks.WISTERIA_LOG.get()), has(ModBlocks.WISTERIA_LOG.get()))
                .save(writer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.WISTERIA_WOOD.get(), 3)
                .pattern("SS")
                .pattern("SS")
                .define('S', ModBlocks.WISTERIA_LOG.get())
                .unlockedBy(getHasName(ModBlocks.WISTERIA_LOG.get()), has(ModBlocks.WISTERIA_LOG.get()))
                .save(writer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.WISTERIA_DOOR.get(),3)
                .pattern("MM")
                .pattern("MM")
                .pattern("MM")
                .define('M', ModBlocks.WISTERIA_PLANKS.get())
                .unlockedBy(getHasName(ModBlocks.WISTERIA_PLANKS.get()), has(ModBlocks.WISTERIA_PLANKS.get()))
                .save(writer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.WISTERIA_TRAPDOOR.get(),2)
                .pattern("MMM")
                .pattern("MMM")
                .define('M', ModBlocks.WISTERIA_PLANKS.get())
                .unlockedBy(getHasName(ModBlocks.WISTERIA_PLANKS.get()), has(ModBlocks.WISTERIA_PLANKS.get()))
                .save(writer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.WISTERIA_SLAB.get(),6)
                .pattern("MMM")
                .unlockedBy(getHasName(ModBlocks.WISTERIA_PLANKS.get()), has(ModBlocks.WISTERIA_PLANKS.get()))
                .define('M', ModBlocks.WISTERIA_PLANKS.get())
                .save(writer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.WISTERIA_STAIRS.get(),4)
                .pattern("M  ")
                .pattern("MM ")
                .pattern("MMM")
                .unlockedBy(getHasName(ModBlocks.WISTERIA_PLANKS.get()), has(ModBlocks.WISTERIA_PLANKS.get()))
                .define('M', ModBlocks.WISTERIA_PLANKS.get())
                .save(writer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.WISTERIA_PRESSURE_PLATE.get(),1)
                .pattern("MM")
                .define('M', ModBlocks.WISTERIA_PLANKS.get())
                .unlockedBy(getHasName(ModBlocks.WISTERIA_PLANKS.get()), has(ModBlocks.WISTERIA_PLANKS.get()))
                .save(writer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModBlocks.WISTERIA_BUTTON.get(),1)
                .requires(ModBlocks.WISTERIA_PLANKS.get())
                .unlockedBy(getHasName(ModBlocks.WISTERIA_PLANKS.get()), has(ModBlocks.WISTERIA_PLANKS.get()))
                .save(writer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.WISTERIA_FENCE.get(),3)
                .pattern("MSM")
                .pattern("MSM")
                .define('M', ModBlocks.WISTERIA_PLANKS.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModBlocks.WISTERIA_PLANKS.get()), has(ModBlocks.WISTERIA_PLANKS.get()))
                .save(writer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.WISTERIA_FENCE_GATE.get(),3)
                .pattern("SMS")
                .pattern("SMS")
                .define('M', ModBlocks.WISTERIA_PLANKS.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModBlocks.WISTERIA_PLANKS.get()), has(ModBlocks.WISTERIA_PLANKS.get()))
                .save(writer);
        ShapedRecipeBuilder.shaped(RecipeCategory.TRANSPORTATION, ModItems.WISTERIA_BOAT.get())
                .pattern("M M")
                .pattern("MMM")
                .define('M', ModBlocks.WISTERIA_PLANKS.get())
                .unlockedBy(getHasName(ModItems.WISTERIA_BOAT.get()), insideOf(Blocks.WATER))
                .save(writer);
        ShapedRecipeBuilder.shaped(RecipeCategory.TRANSPORTATION, ModItems.WISTERIA_CHEST_BOAT.get())
                .pattern("MCM")
                .pattern("MMM")
                .define('M', ModBlocks.WISTERIA_PLANKS.get())
                .define('C', Items.CHEST)
                .unlockedBy(getHasName(ModItems.WISTERIA_CHEST_BOAT.get()), insideOf(Blocks.WATER))
                .save(writer);
        ShapedRecipeBuilder.shaped(RecipeCategory.TRANSPORTATION, ModItems.WISTERIA_CHEST_BOAT.get())
                .pattern("C")
                .pattern("M")
                .define('M', ModItems.WISTERIA_BOAT.get())
                .define('C', Items.CHEST)
                .unlockedBy(getHasName(ModItems.WISTERIA_CHEST_BOAT.get()), insideOf(Blocks.WATER))
                .save(writer, new ResourceLocation(Firefly_a_plants.MODID,"wisteria_chest_boat_alt"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.RICE_BOWL.get())
                .requires(ModItems.RICE.get())
                .requires(Items.BOWL)
                .requires(Items.WATER_BUCKET)
                .unlockedBy(getHasName(ModItems.RICE.get()), has(ModItems.RICE.get()))
                .save(writer);
    }
    private static Criterion<EnterBlockTrigger.TriggerInstance> insideOf(Block pBlock) {
        return CriteriaTriggers.ENTER_BLOCK.createCriterion(new EnterBlockTrigger.TriggerInstance(Optional.empty(), pBlock, Optional.empty()));
    }
}


