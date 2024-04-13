package org.exampl.japan_mod.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.event.entity.living.LivingKnockBackEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.exampl.japan_mod.Japan_mod;
import org.exampl.japan_mod.entity.custom.FireflyEntity;
import org.exampl.japan_mod.entity.custom.ModBoatEntity;
import org.exampl.japan_mod.entity.custom.ModChestBoatEntity;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Japan_mod.MODID);

    public static final RegistryObject<EntityType<FireflyEntity>> FIREFLY =
            ENTITY_TYPES.register("firefly", ()-> EntityType.Builder.of(FireflyEntity::new, MobCategory.CREATURE)
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

