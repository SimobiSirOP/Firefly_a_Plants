package org.exampl.japan_mod.entity.custom;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.util.ByIdMap;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import org.exampl.japan_mod.block.ModBlocks;
import org.exampl.japan_mod.entity.ModEntities;
import org.exampl.japan_mod.item.ModItems;

import java.util.function.IntFunction;

public class ModBoatEntity extends Boat {
    private static final EntityDataAccessor<Integer> DATA_ID_TYPE= SynchedEntityData.defineId(Boat.class, EntityDataSerializers.INT);

    public ModBoatEntity(EntityType<? extends Boat> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }
    public ModBoatEntity(Level level, double pX, double pY, double pZ) {
        this(ModEntities.MODBOAT.get(), level);
        this.setPos(pX, pY, pZ);
        this.xo = pX;
        this.yo = pY;
        this.zo = pZ;
    }
    @Override
    public Item getDropItem() {
        return switch (getModVariant()) {
            case MAPLE -> ModItems.MAPLE_BOAT.get();
            case GLYCINIA -> ModItems.GLYCINIA_BOAT.get();
        };
    }

    public void setVariant(Type pVariant) {
        this.entityData.set(DATA_ID_TYPE, pVariant.ordinal());
    }

    public Type getModVariant() {
        return Type.byId(this.entityData.get(DATA_ID_TYPE));
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_ID_TYPE, Type.MAPLE.ordinal());
    }

    protected void addAdditionalSaveData(CompoundTag pCompound) {
        pCompound.putString("Type", this.getModVariant().getSerializedName());
    }

    protected void readAdditionalSaveData(CompoundTag pCompound) {
        if (pCompound.contains("Type", 8)) {
            this.setVariant(Type.byName(pCompound.getString("Type")));
        }
    }

    public static enum Type implements StringRepresentable {
        MAPLE(ModBlocks.MAPLE_PLANKS.get(), "maple"),
        GLYCINIA(ModBlocks.GLYCINIA_PLANKS.get(), "glycinia");

        private final String name;
        private final Block planks;
        public static final StringRepresentable.EnumCodec<ModBoatEntity.Type> CODEC = StringRepresentable.fromEnum(ModBoatEntity.Type::values);
        private static final IntFunction<ModBoatEntity.Type> BY_ID = ByIdMap.continuous(Enum::ordinal, values(), ByIdMap.OutOfBoundsStrategy.ZERO);

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

        public Block getPlanks() {
            return this.planks;
        }

        public String toString() {
            return this.name;
        }

        public static ModBoatEntity.Type byId(int p_38431_) {
            return BY_ID.apply(p_38431_);
        }

        public static ModBoatEntity.Type byName(String p_38433_) {
            return CODEC.byName(p_38433_, MAPLE);
        }
    }
}
