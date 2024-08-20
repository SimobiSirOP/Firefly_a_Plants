package org.simobisirop.firefly_a_plants.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.simobisirop.firefly_a_plants.Firefly_a_plants;
import org.simobisirop.firefly_a_plants.entity.custom.FireflyEntity;
import org.simobisirop.firefly_a_plants.entity.custom.ModBoatEntity;
import org.simobisirop.firefly_a_plants.entity.custom.ModChestBoatEntity;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Firefly_a_plants.MODID);

    public static final RegistryObject<EntityType<FireflyEntity>> FIREFLY =
            ENTITY_TYPES.register("firefly",
                    ()-> EntityType.Builder.of(FireflyEntity::new, MobCategory.CREATURE)
                    .sized(0.4f, 0.4f).build("firefly"));

    public static final RegistryObject<EntityType<ModBoatEntity>> MODBOAT = ENTITY_TYPES.register("modboat",
            ()-> EntityType.Builder.<ModBoatEntity>of(ModBoatEntity::new, MobCategory.MISC)
                    .sized(1.375f, 0.5625f)
                    .build("modboat"));

    public static final RegistryObject<EntityType<ModChestBoatEntity>> MODCHESTBOAT = ENTITY_TYPES.register("modchestboat",
            ()-> EntityType.Builder.<ModChestBoatEntity>of(ModChestBoatEntity::new, MobCategory.MISC)
                    .sized(1.375f, 0.5625f)
                    .build("modchestboat"));
    public static void register(IEventBus eventBus){
        ENTITY_TYPES.register(eventBus);
    }
}

