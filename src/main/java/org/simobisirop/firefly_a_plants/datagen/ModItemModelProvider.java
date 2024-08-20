package org.simobisirop.firefly_a_plants.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.simobisirop.firefly_a_plants.Firefly_a_plants;
import org.simobisirop.firefly_a_plants.block.ModBlocks;
import org.simobisirop.firefly_a_plants.item.ModItems;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Firefly_a_plants.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
            simpleItem(ModItems.RICE_SEEDS);
            simpleItem(ModItems.RICE);
            simpleItem(ModItems.RICE_BOWL);
            simpleBlockItem(ModBlocks.MAPLE_DOOR);
            fenceItem(ModBlocks.MAPLE_FENCE, ModBlocks.MAPLE_PLANKS);
            buttonItem(ModBlocks.MAPLE_BUTTON, ModBlocks.MAPLE_PLANKS);
            evenSimplerBlockItem(ModBlocks.MAPLE_STAIRS);
            evenSimplerBlockItem(ModBlocks.MAPLE_SLAB);
            evenSimplerBlockItem(ModBlocks.MAPLE_PRESSURE_PLATE);
            evenSimplerBlockItem(ModBlocks.MAPLE_FENCE_GATE);
            trapdoorItem(ModBlocks.MAPLE_TRAPDOOR);
            inBlocksBlockItem(ModBlocks.MAPLE_SAPLING);
            simpleItem(ModItems.MAPLE_BOAT);
            simpleItem(ModItems.MAPLE_CHEST_BOAT);

            simpleBlockItem(ModBlocks.WISTERIA_DOOR);
            fenceItem(ModBlocks.WISTERIA_FENCE, ModBlocks.WISTERIA_PLANKS);
            buttonItem(ModBlocks.WISTERIA_BUTTON, ModBlocks.WISTERIA_PLANKS);
            evenSimplerBlockItem(ModBlocks.WISTERIA_STAIRS);
            evenSimplerBlockItem(ModBlocks.WISTERIA_SLAB);
            evenSimplerBlockItem(ModBlocks.WISTERIA_PRESSURE_PLATE);
            evenSimplerBlockItem(ModBlocks.WISTERIA_FENCE_GATE);
            trapdoorItem(ModBlocks.WISTERIA_TRAPDOOR);
            inBlocksBlockItem(ModBlocks.WISTERIA_SAPLING);
            inBlocksBlockItem(ModBlocks.LAVENDER);
            simpleBlockItem(ModBlocks.GIBISKUS);
            simpleBlockItem(ModBlocks.PIJERYS);
            simpleBlockItem(ModBlocks.WISTERIA_VINE);
            simpleItem(ModItems.WISTERIA_BOAT);
            simpleItem(ModItems.WISTERIA_CHEST_BOAT);
            this.withExistingParent(ModItems.FIREFLY_SPAWN_EGG.getId().getPath(),
                    new ResourceLocation("item/generated"))
                    .texture("layer0", new ResourceLocation(Firefly_a_plants.MODID, "item/"+ ModItems.FIREFLY_SPAWN_EGG.getId().getPath()+ "_0"))
                    .texture("layer1", new ResourceLocation(Firefly_a_plants.MODID, "item/"+ ModItems.FIREFLY_SPAWN_EGG.getId().getPath()+ "_1"));
    }
    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Firefly_a_plants.MODID,"item/" + item.getId().getPath()));
    }
    private ItemModelBuilder inBlocksBlockItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Firefly_a_plants.MODID,"block/" + item.getId().getPath()));
    }
    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Firefly_a_plants.MODID,"item/" + item.getId().getPath()));
    }

    public void evenSimplerBlockItem(RegistryObject<Block> block) {
        this.withExistingParent(Firefly_a_plants.MODID + ":" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
    }

    public void trapdoorItem(RegistryObject<Block> block) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath() + "_bottom"));
    }

    public void fenceItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  new ResourceLocation(Firefly_a_plants.MODID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void buttonItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  new ResourceLocation(Firefly_a_plants.MODID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }
}
