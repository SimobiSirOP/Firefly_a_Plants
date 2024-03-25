package org.exampl.japan_mod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import org.exampl.japan_mod.block.ModBlocks;
import org.exampl.japan_mod.util.ModTags;

import java.util.function.Consumer;

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
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GLYCINIA_PLANKS.get(), 4)
                .requires(ModTags.Items.GLYCINIA_LOGS)
                .unlockedBy(getHasName(ModBlocks.GLYCINIA_LOG.get()), has(ModBlocks.GLYCINIA_LOG.get()))
                .save(writer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GLYCINIA_WOOD.get(), 3)
                .pattern("SS")
                .pattern("SS")
                .define('S', ModBlocks.GLYCINIA_LOG.get())
                .unlockedBy(getHasName(ModBlocks.GLYCINIA_LOG.get()), has(ModBlocks.GLYCINIA_LOG.get()))
                .save(writer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.GLYCINIA_DOOR.get(),3)
                .pattern("MM")
                .pattern("MM")
                .pattern("MM")
                .define('M', ModBlocks.GLYCINIA_PLANKS.get())
                .unlockedBy(getHasName(ModBlocks.GLYCINIA_PLANKS.get()), has(ModBlocks.GLYCINIA_PLANKS.get()))
                .save(writer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.GLYCINIA_TRAPDOOR.get(),2)
                .pattern("MMM")
                .pattern("MMM")
                .define('M', ModBlocks.GLYCINIA_PLANKS.get())
                .unlockedBy(getHasName(ModBlocks.GLYCINIA_PLANKS.get()), has(ModBlocks.GLYCINIA_PLANKS.get()))
                .save(writer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.GLYCINIA_SLAB.get(),6)
                .pattern("MMM")
                .unlockedBy(getHasName(ModBlocks.GLYCINIA_PLANKS.get()), has(ModBlocks.GLYCINIA_PLANKS.get()))
                .define('M', ModBlocks.GLYCINIA_PLANKS.get())
                .save(writer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.GLYCINIA_STAIRS.get(),4)
                .pattern("M  ")
                .pattern("MM ")
                .pattern("MMM")
                .unlockedBy(getHasName(ModBlocks.GLYCINIA_PLANKS.get()), has(ModBlocks.GLYCINIA_PLANKS.get()))
                .define('M', ModBlocks.GLYCINIA_PLANKS.get())
                .save(writer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.GLYCINIA_PRESSURE_PLATE.get(),1)
                .pattern("MM")
                .define('M', ModBlocks.GLYCINIA_PLANKS.get())
                .unlockedBy(getHasName(ModBlocks.GLYCINIA_PLANKS.get()), has(ModBlocks.GLYCINIA_PLANKS.get()))
                .save(writer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModBlocks.GLYCINIA_BUTTON.get(),1)
                .requires(ModBlocks.GLYCINIA_PLANKS.get())
                .unlockedBy(getHasName(ModBlocks.GLYCINIA_PLANKS.get()), has(ModBlocks.GLYCINIA_PLANKS.get()))
                .save(writer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.GLYCINIA_FENCE.get(),3)
                .pattern("MSM")
                .pattern("MSM")
                .define('M', ModBlocks.GLYCINIA_PLANKS.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModBlocks.GLYCINIA_PLANKS.get()), has(ModBlocks.GLYCINIA_PLANKS.get()))
                .save(writer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.GLYCINIA_FENCE_GATE.get(),3)
                .pattern("SMS")
                .pattern("SMS")
                .define('M', ModBlocks.GLYCINIA_PLANKS.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModBlocks.GLYCINIA_PLANKS.get()), has(ModBlocks.GLYCINIA_PLANKS.get()))
                .save(writer);
    }
}


