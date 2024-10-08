package org.simobisirop.firefly_a_plants.datagen;

import net.minecraft.core.Direction;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoorHingeSide;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraftforge.client.model.generators.*;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.simobisirop.firefly_a_plants.Firefly_a_plants;
import org.simobisirop.firefly_a_plants.block.ModBlocks;
import org.simobisirop.firefly_a_plants.block.custom.WisteriaVine;
import org.simobisirop.firefly_a_plants.block.custom.RiceBlock;

import java.util.function.Function;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Firefly_a_plants.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        crossBlock(ModBlocks.GIBISKUS);
        crossBlock(ModBlocks.PIJERYS);
        simpleBlock(ModBlocks.LAVENDER.get(), models().crop(ForgeRegistries.BLOCKS.getKey(ModBlocks.LAVENDER.get()).getPath(), blockTexture(ModBlocks.LAVENDER.get())).renderType("cutout"));
        makeRiceCrop((CropBlock) ModBlocks.RICE.get(), "rice_stage_");
        simpleBlock(ModBlocks.BIOME_FLOWER_CARPET.get(), models().carpet(ForgeRegistries.BLOCKS.getKey(ModBlocks.BIOME_FLOWER_CARPET.get()).getPath(), blockTexture(ModBlocks.BIOME_FLOWER_CARPET.get())).renderType("cutout"));
            blockItem(ModBlocks.BIOME_FLOWER_CARPET);
        // MAPLE

        logBlock((RotatedPillarBlock) ModBlocks.MAPLE_LOG.get());
        blockItem(ModBlocks.MAPLE_LOG);
        axisBlock((RotatedPillarBlock) ModBlocks.MAPLE_WOOD.get(), blockTexture(ModBlocks.MAPLE_LOG.get()),blockTexture(ModBlocks.MAPLE_LOG.get()));
        blockItem(ModBlocks.MAPLE_WOOD);
        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_MAPLE_LOG.get()), blockTexture(ModBlocks.STRIPPED_MAPLE_LOG.get()), new ResourceLocation(Firefly_a_plants.MODID, "block/stripped_maple_log_top"));
            blockItem(ModBlocks.STRIPPED_MAPLE_LOG);
        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_MAPLE_WOOD.get()), blockTexture(ModBlocks.STRIPPED_MAPLE_LOG.get()), blockTexture(ModBlocks.STRIPPED_MAPLE_LOG.get()));
            blockItem(ModBlocks.STRIPPED_MAPLE_WOOD);
        cubeBlockWithItem(ModBlocks.MAPLE_PLANKS);
        leavesBlockWithItem(ModBlocks.MAPLE_LEAVES);
        crossBlock(ModBlocks.MAPLE_SAPLING);
        specialDoorBlockWithRenderType((DoorBlock) ModBlocks.MAPLE_DOOR.get(), modLoc("block/maple_door_bottom"), modLoc("block/maple_door_top"), modLoc("block/maple_door_side"), "cutout");
        trapdoorBlockWithRenderType((TrapDoorBlock) ModBlocks.MAPLE_TRAPDOOR.get(), modLoc("block/maple_trapdoor"), true, "cutout");
        slabBlock(((SlabBlock) ModBlocks.MAPLE_SLAB.get()), blockTexture(ModBlocks.MAPLE_PLANKS.get()), blockTexture(ModBlocks.MAPLE_PLANKS.get()));
        stairsBlock(((StairBlock) ModBlocks.MAPLE_STAIRS.get()), blockTexture(ModBlocks.MAPLE_PLANKS.get()));
        pressurePlateBlock((PressurePlateBlock) ModBlocks.MAPLE_PRESSURE_PLATE.get(), blockTexture(ModBlocks.MAPLE_PLANKS.get()));
        buttonBlock(((ButtonBlock) ModBlocks.MAPLE_BUTTON.get()), blockTexture(ModBlocks.MAPLE_PLANKS.get()));
        fenceBlockWithRenderType(((FenceBlock) ModBlocks.MAPLE_FENCE.get()), blockTexture(ModBlocks.MAPLE_PLANKS.get()), "cutout");
        fenceGateBlockWithRenderType(((FenceGateBlock) ModBlocks.MAPLE_FENCE_GATE.get()), blockTexture(ModBlocks.MAPLE_PLANKS.get()), "cutout");

        // WISTERIA

        logBlock((RotatedPillarBlock) ModBlocks.WISTERIA_LOG.get());
            blockItem(ModBlocks.WISTERIA_LOG);
        axisBlock((RotatedPillarBlock) ModBlocks.WISTERIA_WOOD.get(), blockTexture(ModBlocks.WISTERIA_LOG.get()),blockTexture(ModBlocks.WISTERIA_LOG.get()));
            blockItem(ModBlocks.WISTERIA_WOOD);
        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_WISTERIA_LOG.get()), blockTexture(ModBlocks.STRIPPED_WISTERIA_LOG.get()), new ResourceLocation(Firefly_a_plants.MODID, "block/stripped_wisteria_log_top"));
            blockItem(ModBlocks.STRIPPED_WISTERIA_LOG);
        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_WISTERIA_WOOD.get()), blockTexture(ModBlocks.STRIPPED_WISTERIA_LOG.get()), blockTexture(ModBlocks.STRIPPED_WISTERIA_LOG.get()));
            blockItem(ModBlocks.STRIPPED_WISTERIA_WOOD);
        cubeBlockWithItem(ModBlocks.WISTERIA_PLANKS);
        leavesBlockWithItem(ModBlocks.WISTERIA_LEAVES);
        crossBlock(ModBlocks.WISTERIA_SAPLING);
        specialDoorBlockWithRenderType((DoorBlock) ModBlocks.WISTERIA_DOOR.get(), modLoc("block/wisteria_door_bottom"), modLoc("block/wisteria_door_top"), modLoc("block/wisteria_door_side"), "cutout");
        trapdoorBlockWithRenderType((TrapDoorBlock) ModBlocks.WISTERIA_TRAPDOOR.get(), modLoc("block/wisteria_trapdoor"), true, "cutout");
        slabBlock(((SlabBlock) ModBlocks.WISTERIA_SLAB.get()), blockTexture(ModBlocks.WISTERIA_PLANKS.get()), blockTexture(ModBlocks.WISTERIA_PLANKS.get()));
        stairsBlock(((StairBlock) ModBlocks.WISTERIA_STAIRS.get()), blockTexture(ModBlocks.WISTERIA_PLANKS.get()));
        pressurePlateBlock((PressurePlateBlock) ModBlocks.WISTERIA_PRESSURE_PLATE.get(), blockTexture(ModBlocks.WISTERIA_PLANKS.get()));
        buttonBlock(((ButtonBlock) ModBlocks.WISTERIA_BUTTON.get()), blockTexture(ModBlocks.WISTERIA_PLANKS.get()));
        fenceBlockWithRenderType(((FenceBlock) ModBlocks.WISTERIA_FENCE.get()), blockTexture(ModBlocks.WISTERIA_PLANKS.get()), "cutout");
        fenceGateBlockWithRenderType(((FenceGateBlock) ModBlocks.WISTERIA_FENCE_GATE.get()), blockTexture(ModBlocks.WISTERIA_PLANKS.get()), "cutout");
        makeWisteriaVine(((CropBlock) ModBlocks.WISTERIA_VINE.get()), "wisteria_vine_");
    }
    private String getPath(RegistryObject<Block> blockOfMod){
        return ForgeRegistries.BLOCKS.getKey(blockOfMod.get()).getPath();
    }

    private void leavesBlockWithItem(RegistryObject<Block> blockOfMod) {
        simpleBlockWithItem(blockOfMod.get(),
                models().singleTexture(ForgeRegistries.BLOCKS.getKey(blockOfMod.get()).getPath(), new ResourceLocation("minecraft:block/leaves"),
                        "all", blockTexture(blockOfMod.get())).renderType("cutout"));
        blockItem(blockOfMod);
    }

    private void blockItem(RegistryObject<Block> blockOfMod) {
        simpleBlockItem(blockOfMod.get(), new ModelFile.UncheckedModelFile(Firefly_a_plants.MODID + ":block/" + ForgeRegistries.BLOCKS.getKey(blockOfMod.get()).getPath()));
    }

    private void cubeBlockWithItem(RegistryObject<Block> blockOfMod) {
        simpleBlockWithItem(blockOfMod.get(), cubeAll(blockOfMod.get()));
    }

    private void crossBlock(RegistryObject<Block> blockOfMod) {
        simpleBlock(blockOfMod.get(), models().cross(ForgeRegistries.BLOCKS.getKey(blockOfMod.get()).getPath(), blockTexture(blockOfMod.get())).renderType("cutout"));
    }

    private void makeRiceCrop(CropBlock block, String modelName) {
        Function<BlockState, ConfiguredModel[]> function = state -> riceStates(state, block, modelName, modelName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] riceStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((RiceBlock) block).getAgeProperty()),
                new ResourceLocation(Firefly_a_plants.MODID, "block/" + textureName + state.getValue(((RiceBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }
    private void makeWisteriaVine(CropBlock block, String modelName) {
        Function<BlockState, ConfiguredModel[]> function = state -> WisteriaVineStates(state, block, modelName, modelName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] WisteriaVineStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().cross(modelName + state.getValue(((WisteriaVine) block).getAgeProperty()),
                new ResourceLocation(Firefly_a_plants.MODID, "block/" + textureName + state.getValue(((WisteriaVine) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }
    private ResourceLocation key(Block block) {
        return ForgeRegistries.BLOCKS.getKey(block);
    }
    
    private void specialDoorBlockInternalWithRenderType(DoorBlock block, String baseName, ResourceLocation bottom, ResourceLocation top, ResourceLocation side, ResourceLocation renderType) {
        ModelFile bottomLeft = ((BlockModelBuilder)this.specialDoorBottomLeft(baseName + "_bottom_left", bottom, top, side)).renderType(renderType);
        ModelFile bottomLeftOpen = ((BlockModelBuilder)this.specialDoorBottomLeftOpen(baseName + "_bottom_left_open", bottom, top, side)).renderType(renderType);
        ModelFile bottomRight = ((BlockModelBuilder)this.specialDoorBottomRight(baseName + "_bottom_right", bottom, top, side)).renderType(renderType);
        ModelFile bottomRightOpen = ((BlockModelBuilder)this.specialDoorBottomRightOpen(baseName + "_bottom_right_open", bottom, top, side)).renderType(renderType);
        ModelFile topLeft = ((BlockModelBuilder)this.specialDoorTopLeft(baseName + "_top_left", bottom, top, side)).renderType(renderType);
        ModelFile topLeftOpen = ((BlockModelBuilder)this.specialDoorTopLeftOpen(baseName + "_top_left_open", bottom, top, side)).renderType(renderType);
        ModelFile topRight = ((BlockModelBuilder)this.specialDoorTopRight(baseName + "_top_right", bottom, top, side)).renderType(renderType);
        ModelFile topRightOpen = ((BlockModelBuilder)this.specialDoorTopRightOpen(baseName + "_top_right_open", bottom, top, side)).renderType(renderType);
        this.specialDoorBlock(block, bottomLeft, bottomLeftOpen, bottomRight, bottomRightOpen, topLeft, topLeftOpen, topRight, topRightOpen);
    }
    public void specialDoorBlock(DoorBlock block, ModelFile bottomLeft, ModelFile bottomLeftOpen, ModelFile bottomRight, ModelFile bottomRightOpen, ModelFile topLeft, ModelFile topLeftOpen, ModelFile topRight, ModelFile topRightOpen) {
        this.getVariantBuilder(block).forAllStatesExcept((state) -> {
            int yRot = (int)((Direction)state.getValue(DoorBlock.FACING)).toYRot() + 90;
            boolean right = state.getValue(DoorBlock.HINGE) == DoorHingeSide.RIGHT;
            boolean open = (Boolean)state.getValue(DoorBlock.OPEN);
            boolean lower = state.getValue(DoorBlock.HALF) == DoubleBlockHalf.LOWER;
            if (open) {
                yRot += 90;
            }

            if (right && open) {
                yRot += 180;
            }

            yRot %= 360;
            ModelFile model = null;
            if (lower && right && open) {
                model = bottomRightOpen;
            } else if (lower && !right && open) {
                model = bottomLeftOpen;
            }

            if (lower && right && !open) {
                model = bottomRight;
            } else if (lower && !right && !open) {
                model = bottomLeft;
            }

            if (!lower && right && open) {
                model = topRightOpen;
            } else if (!lower && !right && open) {
                model = topLeftOpen;
            }

            if (!lower && right && !open) {
                model = topRight;
            } else if (!lower && !right && !open) {
                model = topLeft;
            }

            return ConfiguredModel.builder().modelFile(model).rotationY(yRot).build();
        }, new Property[]{DoorBlock.POWERED});
    }
    public BlockModelBuilder withExistingParent(String name, String parent) {
        return models().withExistingParent(name, this.modLoc(parent));
    }
    private BlockModelBuilder specialDoor(String name, String model, ResourceLocation bottom, ResourceLocation top, ResourceLocation side) {
        return this.withExistingParent(name, "block/" + model).texture("bottom", bottom).texture("top", top).texture("side", side);
    }

    public BlockModelBuilder specialDoorBottomLeft(String name, ResourceLocation bottom, ResourceLocation top, ResourceLocation side) {
        return this.specialDoor(name, "special_door_bottom_left", bottom, top, side);
    }

    public BlockModelBuilder specialDoorBottomLeftOpen(String name, ResourceLocation bottom, ResourceLocation top, ResourceLocation side) {
        return this.specialDoor(name, "special_door_bottom_left_open", bottom, top, side);
    }

    public BlockModelBuilder specialDoorBottomRight(String name, ResourceLocation bottom, ResourceLocation top, ResourceLocation side) {
        return this.specialDoor(name, "special_door_bottom_right", bottom, top, side);
    }

    public BlockModelBuilder specialDoorBottomRightOpen(String name, ResourceLocation bottom, ResourceLocation top, ResourceLocation side) {
        return this.specialDoor(name, "special_door_bottom_right_open", bottom, top, side);
    }

    public BlockModelBuilder specialDoorTopLeft(String name, ResourceLocation bottom, ResourceLocation top, ResourceLocation side) {
        return this.specialDoor(name, "special_door_top_left", bottom, top, side);
    }

    public BlockModelBuilder specialDoorTopLeftOpen(String name, ResourceLocation bottom, ResourceLocation top, ResourceLocation side) {
        return this.specialDoor(name, "special_door_top_left_open", bottom, top, side);
    }

    public BlockModelBuilder specialDoorTopRight(String name, ResourceLocation bottom, ResourceLocation top, ResourceLocation side) {
        return this.specialDoor(name, "special_door_top_right", bottom, top, side);
    }
    public void specialDoorBlockWithRenderType(DoorBlock block, ResourceLocation bottom, ResourceLocation top, ResourceLocation side, String renderType) {
        this.specialDoorBlockInternalWithRenderType(block, this.key(block).toString(), bottom, top, side, ResourceLocation.tryParse(renderType));
    }

    public BlockModelBuilder specialDoorTopRightOpen(String name, ResourceLocation bottom, ResourceLocation top, ResourceLocation side) {
        return this.specialDoor(name, "special_door_top_right_open", bottom, top, side);
    }

}
