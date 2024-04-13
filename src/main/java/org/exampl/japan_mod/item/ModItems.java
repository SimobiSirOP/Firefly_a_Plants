package org.exampl.japan_mod.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.PlaceOnWaterBlockItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.exampl.japan_mod.Japan_mod;
import org.exampl.japan_mod.block.ModBlocks;
import org.exampl.japan_mod.entity.ModEntities;
import org.exampl.japan_mod.entity.custom.ModBoatEntity;
import org.exampl.japan_mod.item.custom.CMSpawnEggItem;
import org.exampl.japan_mod.item.custom.ItemNamePlaceOnWaterBlockItem;
import org.exampl.japan_mod.item.custom.ModBoatItem;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Japan_mod.MODID);

    public static final RegistryObject<Item> RICE_SEEDS = ITEMS.register("rice_seeds",
            () -> new ItemNamePlaceOnWaterBlockItem(ModBlocks.RICE.get(), new Item.Properties()));
    public static final RegistryObject<Item> RICE = ITEMS.register("rice",
            () -> new Item(new Item.Properties()));


    public static final RegistryObject<Item> RICE_BOWL = ITEMS.register("rice_bowl",
            () -> new Item(new Item.Properties().food(ModFoods.RICE_BOWL)));

    public static final RegistryObject<Item> LOTOS = ITEMS.register("lotos",
            () -> new PlaceOnWaterBlockItem(ModBlocks.LOTOS.get(),new Item.Properties()));
    public static final RegistryObject<Item> MAPLE_BOAT = ITEMS.register("maple_boat",
            () -> new ModBoatItem(false, ModBoatEntity.Type.MAPLE, new Item.Properties()));
    public static final RegistryObject<Item> GLYCINIA_BOAT = ITEMS.register("glycinia_boat",
            () -> new ModBoatItem(false, ModBoatEntity.Type.GLYCINIA, new Item.Properties()));
    public static final RegistryObject<Item> MAPLE_CHEST_BOAT = ITEMS.register("maple_chest_boat",
            () -> new ModBoatItem(true, ModBoatEntity.Type.MAPLE, new Item.Properties()));
    public static final RegistryObject<Item> GLYCINIA_CHEST_BOAT = ITEMS.register("glycinia_chest_boat",
            () -> new ModBoatItem(true, ModBoatEntity.Type.GLYCINIA, new Item.Properties()));
    public static final RegistryObject<Item> FIREFLY_SPAWN_EGG = ITEMS.register("firefly_spawn_egg",
            ()-> new CMSpawnEggItem(ModEntities.FIREFLY, new Item.Properties()));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}


