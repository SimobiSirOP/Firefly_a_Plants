package org.simobisirop.firefly_a_plants.event;

import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.simobisirop.firefly_a_plants.Firefly_a_plants;
import org.simobisirop.firefly_a_plants.entity.ModEntities;
import org.simobisirop.firefly_a_plants.entity.custom.FireflyEntity;

@Mod.EventBusSubscriber(modid = Firefly_a_plants.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void regiisterAttributes(EntityAttributeCreationEvent event){
    event.put(ModEntities.FIREFLY.get(), FireflyEntity.createAttrinutes().build());}
}
