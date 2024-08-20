package org.simobisirop.firefly_a_plants.item.custom;

import net.minecraft.core.Direction;
import net.minecraft.core.dispenser.DispenseItemBehavior;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import org.simobisirop.firefly_a_plants.Firefly_a_plants;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class CMSpawnEggItem extends NCSpawnEggItem {
    private static final List<CMSpawnEggItem> MOD_EGGS = new ArrayList();
    private static final Map<EntityType<? extends Mob>, CMSpawnEggItem> TYPE_MAP = new IdentityHashMap();
    private final Supplier<? extends EntityType<? extends Mob>> typeSupplier;
    private static final DispenseItemBehavior DEFAULT_DISPENSE_BEHAVIOR = (source, stack) -> {
        Direction face = (Direction)source.state().getValue(DispenserBlock.FACING);
        EntityType<?> type = ((SpawnEggItem)stack.getItem()).getType(stack.getTag());

        try {
            type.spawn(source.level(), stack, (Player)null, source.pos().relative(face), MobSpawnType.DISPENSER, face != Direction.UP, false);
        } catch (Exception var5) {
            DispenseItemBehavior.LOGGER.error("Error while dispensing spawn egg from dispenser at {}", source.pos(), var5);
            return ItemStack.EMPTY;
        }

        stack.shrink(1);
        source.level().gameEvent(GameEvent.ENTITY_PLACE, source.pos(), GameEvent.Context.of(source.state()));
        return stack;
    };

    public CMSpawnEggItem(Supplier<? extends EntityType<? extends Mob>> type, Item.Properties props) {
        super((EntityType)null, props);
        this.typeSupplier = type;
        MOD_EGGS.add(this);
    }

    public EntityType<?> getType(@Nullable CompoundTag tag) {
        EntityType<?> type = super.getType(tag);
        return type != null ? type : (EntityType)this.typeSupplier.get();
    }

    protected @Nullable DispenseItemBehavior createDispenseBehavior() {
        return DEFAULT_DISPENSE_BEHAVIOR;
    }

    public static @Nullable NCSpawnEggItem fromEntityType(@Nullable EntityType<?> type) {
        NCSpawnEggItem ret = (NCSpawnEggItem)TYPE_MAP.get(type);
        return ret != null ? ret : NCSpawnEggItem.byId(type);
    }

    protected EntityType<?> getDefaultType() {
        return (EntityType)this.typeSupplier.get();
    }

    @Mod.EventBusSubscriber(
            modid = Firefly_a_plants.MODID,
            bus = Mod.EventBusSubscriber.Bus.MOD
    )
    private static class CommonHandler {
        private CommonHandler() {
        }

        @SubscribeEvent
        public static void onCommonSetup(FMLCommonSetupEvent event) {
            CMSpawnEggItem.MOD_EGGS.forEach((egg) -> {
                DispenseItemBehavior dispenseBehavior = egg.createDispenseBehavior();
                if (dispenseBehavior != null) {
                    DispenserBlock.registerBehavior(egg, dispenseBehavior);
                }

                CMSpawnEggItem.TYPE_MAP.put((EntityType)egg.typeSupplier.get(), egg);
            });
        }
    }
}
