package org.simobisirop.firefly_a_plants.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import org.simobisirop.firefly_a_plants.Firefly_a_plants;
import org.simobisirop.firefly_a_plants.block.ModBlocks;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TAB = 
    DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Firefly_a_plants.MODID);
    public static final RegistryObject<CreativeModeTab> FIREFLY_A_PLANTS_TAB = CREATIVE_TAB.register("firefly_a_tab",
        () -> CreativeModeTab.builder().icon(
        () -> new ItemStack(ModItems.RICE_BOWL.get()))
        .title(Component.translatable("creative_tab_firefly_a_plants"))
        .displayItems((pDisplayParameters, pItemOutput) -> {
        pItemOutput.accept(ModBlocks.PIJERYS.get());
        pItemOutput.accept(ModBlocks.GIBISKUS.get());
        pItemOutput.accept(ModBlocks.LAVENDER.get());
        pItemOutput.accept(ModBlocks.BIOME_FLOWER_CARPET.get());

        pItemOutput.accept(ModBlocks.MAPLE_LOG.get());
        pItemOutput.accept(ModBlocks.MAPLE_WOOD.get());
        pItemOutput.accept(ModBlocks.STRIPPED_MAPLE_LOG.get());
        pItemOutput.accept(ModBlocks.STRIPPED_MAPLE_WOOD.get());
        pItemOutput.accept(ModBlocks.MAPLE_LEAVES.get());
        pItemOutput.accept(ModBlocks.MAPLE_SAPLING.get());
        pItemOutput.accept(ModBlocks.MAPLE_PLANKS.get());
        pItemOutput.accept(ModBlocks.MAPLE_DOOR.get());
        pItemOutput.accept(ModBlocks.MAPLE_TRAPDOOR.get());
        pItemOutput.accept(ModBlocks.MAPLE_SLAB.get());
        pItemOutput.accept(ModBlocks.MAPLE_STAIRS.get());
        pItemOutput.accept(ModBlocks.MAPLE_PRESSURE_PLATE.get());
        pItemOutput.accept(ModBlocks.MAPLE_BUTTON.get());
        pItemOutput.accept(ModBlocks.MAPLE_FENCE.get());
        pItemOutput.accept(ModBlocks.MAPLE_FENCE_GATE.get());
        pItemOutput.accept(ModItems.MAPLE_BOAT.get());
        pItemOutput.accept(ModItems.MAPLE_CHEST_BOAT.get());

        pItemOutput.accept(ModBlocks.WISTERIA_LOG.get());
        pItemOutput.accept(ModBlocks.WISTERIA_WOOD.get());
        pItemOutput.accept(ModBlocks.STRIPPED_WISTERIA_LOG.get());
        pItemOutput.accept(ModBlocks.STRIPPED_WISTERIA_WOOD.get());
        pItemOutput.accept(ModBlocks.WISTERIA_LEAVES.get());
        pItemOutput.accept(ModBlocks.WISTERIA_SAPLING.get());
        pItemOutput.accept(ModBlocks.WISTERIA_VINE.get());
        pItemOutput.accept(ModBlocks.WISTERIA_PLANKS.get());
        pItemOutput.accept(ModBlocks.WISTERIA_DOOR.get());
        pItemOutput.accept(ModBlocks.WISTERIA_TRAPDOOR.get());
        pItemOutput.accept(ModBlocks.WISTERIA_SLAB.get());
        pItemOutput.accept(ModBlocks.WISTERIA_STAIRS.get());
        pItemOutput.accept(ModBlocks.WISTERIA_PRESSURE_PLATE.get());
        pItemOutput.accept(ModBlocks.WISTERIA_BUTTON.get());
        pItemOutput.accept(ModBlocks.WISTERIA_FENCE.get());
        pItemOutput.accept(ModBlocks.WISTERIA_FENCE_GATE.get());
        pItemOutput.accept(ModItems.WISTERIA_BOAT.get());
        pItemOutput.accept(ModItems.WISTERIA_CHEST_BOAT.get());
        pItemOutput.accept(ModItems.RICE.get());
        pItemOutput.accept(ModItems.RICE_SEEDS.get());
        pItemOutput.accept(ModItems.RICE_BOWL.get());
        pItemOutput.accept(ModItems.FIREFLY_SPAWN_EGG.get());
    }).build());
    public static void register(IEventBus eventBus){
        CREATIVE_TAB.register(eventBus);
    }
}
