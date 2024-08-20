package org.simobisirop.firefly_a_plants.entity.custom;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.util.ByIdMap;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.ChestBoat;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import org.simobisirop.firefly_a_plants.block.ModBlocks;
import org.simobisirop.firefly_a_plants.entity.ModEntities;
import org.simobisirop.firefly_a_plants.item.ModItems;

import java.util.function.IntFunction;

public class ModChestBoatEntity extends ChestBoat {
    public ModChestBoatEntity(EntityType<? extends ChestBoat> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }
    private static final EntityDataAccessor<Integer> DATA_ID_TYPE= SynchedEntityData.defineId(ModChestBoatEntity.class, EntityDataSerializers.INT);

    public ModChestBoatEntity(Level level, double pX, double pY, double pZ) {
        this(ModEntities.MODCHESTBOAT.get(), level);
        this.setPos(pX, pY, pZ);
        this.xo = pX;
        this.yo = pY;
        this.zo = pZ;
    }
    @Override
    public Item getDropItem() {
        return switch (getModVariant()) {
            case MAPLE -> ModItems.MAPLE_CHEST_BOAT.get();
            case WISTERIA -> ModItems.WISTERIA_CHEST_BOAT.get();
        };
    }

    public void setVariant(ModBoatEntity.Type pVariant) {
        this.entityData.set(DATA_ID_TYPE, pVariant.ordinal());
    }

    public ModBoatEntity.Type getModVariant() {
        return ModBoatEntity.Type.byId(this.entityData.get(DATA_ID_TYPE));
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_ID_TYPE, ModBoatEntity.Type.MAPLE.ordinal());
    }

    protected void addAdditionalSaveData(CompoundTag pCompound) {
        pCompound.putString("Type", this.getModVariant().getSerializedName());
    }

    protected void readAdditionalSaveData(CompoundTag pCompound) {
        if (pCompound.contains("Type", 8)) {
            this.setVariant(ModBoatEntity.Type.byName(pCompound.getString("Type")));
        }
    }



    public static enum Type implements StringRepresentable {
        MAPLE(ModBlocks.MAPLE_PLANKS.get(), "maple"),
        WISTERIA(ModBlocks.WISTERIA_PLANKS.get(), "wisteria");

        private final String name;
        private final Block planks;
        public static final StringRepresentable.EnumCodec<ModChestBoatEntity.Type> CODEC = StringRepresentable.fromEnum(ModChestBoatEntity.Type::values);
        private static final IntFunction<ModChestBoatEntity.Type> BY_ID = ByIdMap.continuous(Enum::ordinal, values(), ByIdMap.OutOfBoundsStrategy.ZERO);

        private Type(Block p_38427_, String p_38428_) {
            this.name = p_38428_;
            this.planks = p_38427_;
        }

        public String getSerializedName() {
            return this.name;
        }

        public String getName() {
            return this.name;
        }

        public String toString() {
            return this.name;
        }

        public static ModChestBoatEntity.Type byId(int p_38431_) {
            return BY_ID.apply(p_38431_);
        }

    }
}
