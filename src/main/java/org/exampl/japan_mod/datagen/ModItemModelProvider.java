package org.exampl.japan_mod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.exampl.japan_mod.Japan_mod;
import org.exampl.japan_mod.block.ModBlocks;
import org.exampl.japan_mod.item.ModItems;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Japan_mod.MODID, existingFileHelper);
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

            simpleBlockItem(ModBlocks.GLYCINIA_DOOR);
            fenceItem(ModBlocks.GLYCINIA_FENCE, ModBlocks.GLYCINIA_PLANKS);
            buttonItem(ModBlocks.GLYCINIA_BUTTON, ModBlocks.GLYCINIA_PLANKS);
            evenSimplerBlockItem(ModBlocks.GLYCINIA_STAIRS);
            evenSimplerBlockItem(ModBlocks.GLYCINIA_SLAB);
            evenSimplerBlockItem(ModBlocks.GLYCINIA_PRESSURE_PLATE);
            evenSimplerBlockItem(ModBlocks.GLYCINIA_FENCE_GATE);
            trapdoorItem(ModBlocks.GLYCINIA_TRAPDOOR);
            inBlocksBlockItem(ModBlocks.GLYCINIA_SAPLING);
            inBlocksBlockItem(ModBlocks.LAVENDER);
            simpleBlockItem(ModBlocks.GIBISKUS);
            simpleBlockItem(ModBlocks.PIJERYS);
            simpleBlockItem(ModBlocks.GLYCINIA_VINE);
            simpleItem(ModItems.GLYCINIA_BOAT);
            simpleItem(ModItems.GLYCINIA_CHEST_BOAT);
            this.withExistingParent(ModItems.FIREFLY_SPAWN_EGG.getId().getPath(),
                    new ResourceLocation("item/generated"))
                    .texture("layer0", new ResourceLocation(Japan_mod.MODID, "item/"+ ModItems.FIREFLY_SPAWN_EGG.getId().getPath()+ "_0"))
                    .texture("layer1", new ResourceLocation(Japan_mod.MODID, "item/"+ ModItems.FIREFLY_SPAWN_EGG.getId().getPath()+ "_1"));
    }
    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Japan_mod.MODID,"item/" + item.getId().getPath()));
    }
    private ItemModelBuilder inBlocksBlockItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Japan_mod.MODID,"block/" + item.getId().getPath()));
    }
    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Japan_mod.MODID,"item/" + item.getId().getPath()));
    }

    public void evenSimplerBlockItem(RegistryObject<Block> block) {
        this.withExistingParent(Japan_mod.MODID + ":" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
    }

    public void trapdoorItem(RegistryObject<Block> block) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath() + "_bottom"));
    }

    public void fenceItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  new ResourceLocation(Japan_mod.MODID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void buttonItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  new ResourceLocation(Japan_mod.MODID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }
}
