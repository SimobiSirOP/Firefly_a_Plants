package org.exampl.japan_mod.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.NeutralMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.util.AirAndWaterRandomPos;
import net.minecraft.world.entity.ai.util.HoverRandomPos;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Bee;
import net.minecraft.world.entity.animal.FlyingAnimal;
import net.minecraft.world.entity.animal.Parrot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.Vec3;
import org.exampl.japan_mod.entity.ModEntities;
import org.jetbrains.annotations.Nullable;

import java.util.EnumSet;
import java.util.UUID;

public class FireflyEntity extends Animal implements NeutralMob, FlyingAnimal {
    public FireflyEntity(EntityType<? extends Animal> pEntityType, Level pLevel) {

        super(pEntityType, pLevel);
        this.moveControl = new FlyingMoveControl(this, 20, true);
        this.setPathfindingMalus(BlockPathTypes.DANGER_FIRE, -1.0F);
        this.setPathfindingMalus(BlockPathTypes.WATER, -1.0F);
        this.setPathfindingMalus(BlockPathTypes.WATER_BORDER, 16.0F);
        this.setPathfindingMalus(BlockPathTypes.COCOA, -1.0F);
        this.setPathfindingMalus(BlockPathTypes.FENCE, -1.0F);
    }
    @Override
    protected void registerGoals(){
        this.goalSelector.addGoal(1, new FireflyEntityWanderGoal());
    }
    public static AttributeSupplier.Builder createAttrinutes(){
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 2.0D)
                .add(Attributes.FLYING_SPEED, (double)0.6F)
                .add(Attributes.MOVEMENT_SPEED, (double)0.3F)
                .add(Attributes.FOLLOW_RANGE, 48.0D);
    }

    @Nullable

    public boolean isFlying() {
        return !this.onGround();
    }
    protected void checkFallDamage(double p_20990_, boolean p_20991_, BlockState p_20992_, BlockPos p_20993_){

    }

    @Override
    public int getRemainingPersistentAngerTime() {
        return 0;
    }

    @Override
    public void setRemainingPersistentAngerTime(int pRemainingPersistentAngerTime) {

    }

    @Nullable
    @Override
    public UUID getPersistentAngerTarget() {
        return null;
    }

    @Override
    public void setPersistentAngerTarget(@Nullable UUID pPersistentAngerTarget) {

    }
    @Override
    public void startPersistentAngerTimer() {

    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {
        return null;
    }

    class FireflyEntityWanderGoal extends Goal {
        private static final int WANDER_THRESHOLD = 22;

        FireflyEntityWanderGoal() {
            this.setFlags(EnumSet.of(Goal.Flag.MOVE));
        }

        public boolean canUse() {
            return FireflyEntity.this.navigation.isDone() && FireflyEntity.this.random.nextInt(10) == 0;
        }

        public boolean canContinueToUse() {
            return FireflyEntity.this.navigation.isInProgress();
        }

        public void start() {
            Vec3 vec3 = this.findPos();
            if (vec3 != null) {
                FireflyEntity.this.navigation.moveTo(FireflyEntity.this.navigation.createPath(BlockPos.containing(vec3), 1), 1.0D);
            }

        }

        @javax.annotation.Nullable
        private Vec3 findPos() {
            Vec3 vec3;
            vec3 = FireflyEntity.this.getViewVector(0.0F);

            int i = 8;
            Vec3 vec32 = HoverRandomPos.getPos(FireflyEntity.this, 8, 7, vec3.x, vec3.z, ((float)Math.PI / 2F), 3, 1);
            return vec32 != null ? vec32 : AirAndWaterRandomPos.getPos(FireflyEntity.this, 8, 4, 0, vec3.x, vec3.z, (double)((float)Math.PI / 2F));
        }
    }
}
