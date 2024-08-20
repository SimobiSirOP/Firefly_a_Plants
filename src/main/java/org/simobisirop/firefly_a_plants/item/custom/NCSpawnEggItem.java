package org.simobisirop.firefly_a_plants.item.custom;

import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.SpawnerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class NCSpawnEggItem extends Item {
    private static final Map<EntityType<? extends Mob>, NCSpawnEggItem> BY_ID = Maps.newIdentityHashMap();
    private final EntityType<?> defaultType;

    /** @deprecated */
    @Deprecated
    public NCSpawnEggItem(EntityType<? extends Mob> pDefaultType, Item.Properties pProperties) {
        super(pProperties);
        this.defaultType = pDefaultType;
        if (pDefaultType != null) {
            BY_ID.put(pDefaultType, this);
        }

    }

    public InteractionResult useOn(UseOnContext pContext) {
        Level level = pContext.getLevel();
        if (!(level instanceof ServerLevel)) {
            return InteractionResult.SUCCESS;
        } else {
            ItemStack itemstack = pContext.getItemInHand();
            BlockPos blockpos = pContext.getClickedPos();
            Direction direction = pContext.getClickedFace();
            BlockState blockstate = level.getBlockState(blockpos);
            if (blockstate.is(Blocks.SPAWNER)) {
                BlockEntity blockentity = level.getBlockEntity(blockpos);
                if (blockentity instanceof SpawnerBlockEntity) {
                    SpawnerBlockEntity spawnerblockentity = (SpawnerBlockEntity)blockentity;
                    EntityType<?> entitytype1 = this.getType(itemstack.getTag());
                    spawnerblockentity.setEntityId(entitytype1, level.getRandom());
                    blockentity.setChanged();
                    level.sendBlockUpdated(blockpos, blockstate, blockstate, 3);
                    level.gameEvent(pContext.getPlayer(), GameEvent.BLOCK_CHANGE, blockpos);
                    itemstack.shrink(1);
                    return InteractionResult.CONSUME;
                }
            }

            BlockPos blockpos1;
            if (blockstate.getCollisionShape(level, blockpos).isEmpty()) {
                blockpos1 = blockpos;
            } else {
                blockpos1 = blockpos.relative(direction);
            }

            EntityType<?> entitytype = this.getType(itemstack.getTag());
            if (entitytype.spawn((ServerLevel)level, itemstack, pContext.getPlayer(), blockpos1, MobSpawnType.SPAWN_EGG, true, !Objects.equals(blockpos, blockpos1) && direction == Direction.UP) != null) {
                itemstack.shrink(1);
                level.gameEvent(pContext.getPlayer(), GameEvent.ENTITY_PLACE, blockpos);
            }

            return InteractionResult.CONSUME;
        }
    }

    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pHand) {
        ItemStack itemstack = pPlayer.getItemInHand(pHand);
        BlockHitResult blockhitresult = getPlayerPOVHitResult(pLevel, pPlayer, ClipContext.Fluid.SOURCE_ONLY);
        if (blockhitresult.getType() != HitResult.Type.BLOCK) {
            return InteractionResultHolder.pass(itemstack);
        } else if (!(pLevel instanceof ServerLevel)) {
            return InteractionResultHolder.success(itemstack);
        } else {
            BlockPos blockpos = blockhitresult.getBlockPos();
            if (!(pLevel.getBlockState(blockpos).getBlock() instanceof LiquidBlock)) {
                return InteractionResultHolder.pass(itemstack);
            } else if (pLevel.mayInteract(pPlayer, blockpos) && pPlayer.mayUseItemAt(blockpos, blockhitresult.getDirection(), itemstack)) {
                EntityType<?> entitytype = this.getType(itemstack.getTag());
                Entity entity = entitytype.spawn((ServerLevel)pLevel, itemstack, pPlayer, blockpos, MobSpawnType.SPAWN_EGG, false, false);
                if (entity == null) {
                    return InteractionResultHolder.pass(itemstack);
                } else {
                    if (!pPlayer.getAbilities().instabuild) {
                        itemstack.shrink(1);
                    }

                    pPlayer.awardStat(Stats.ITEM_USED.get(this));
                    pLevel.gameEvent(pPlayer, GameEvent.ENTITY_PLACE, entity.position());
                    return InteractionResultHolder.consume(itemstack);
                }
            } else {
                return InteractionResultHolder.fail(itemstack);
            }
        }
    }

    public boolean spawnsEntity(@Nullable CompoundTag pNbt, EntityType<?> pType) {
        return Objects.equals(this.getType(pNbt), pType);
    }

    /** @deprecated */
    @Deprecated
    @Nullable
    public static NCSpawnEggItem byId(@Nullable EntityType<?> pType) {
        return (NCSpawnEggItem)BY_ID.get(pType);
    }

    public static Iterable<NCSpawnEggItem> eggs() {
        return Iterables.unmodifiableIterable(BY_ID.values());
    }

    public EntityType<?> getType(@Nullable CompoundTag pNbt) {
        if (pNbt != null && pNbt.contains("EntityTag", 10)) {
            CompoundTag compoundtag = pNbt.getCompound("EntityTag");
            if (compoundtag.contains("id", 8)) {
                return (EntityType)EntityType.byString(compoundtag.getString("id")).orElse(this.getDefaultType());
            }
        }

        return this.getDefaultType();
    }

    public FeatureFlagSet requiredFeatures() {
        return this.getDefaultType().requiredFeatures();
    }

    public Optional<Mob> spawnOffspringFromSpawnEgg(Player pPlayer, Mob pMob, EntityType<? extends Mob> pEntityType, ServerLevel pServerLevel, Vec3 pPos, ItemStack pStack) {
        if (!this.spawnsEntity(pStack.getTag(), pEntityType)) {
            return Optional.empty();
        } else {
            Object mob;
            if (pMob instanceof AgeableMob) {
                mob = ((AgeableMob)pMob).getBreedOffspring(pServerLevel, (AgeableMob)pMob);
            } else {
                mob = (Mob)pEntityType.create(pServerLevel);
            }

            if (mob == null) {
                return Optional.empty();
            } else {
                ((Mob) mob).setBaby(true);
                if (!((Mob) mob).isBaby()) {
                    return Optional.empty();
                } else {
                    ((Mob) mob).moveTo(pPos.x(), pPos.y(), pPos.z(), 0.0F, 0.0F);
                    pServerLevel.addFreshEntityWithPassengers((Entity) mob);
                    if (pStack.hasCustomHoverName()) {
                        ((Mob)mob).setCustomName(pStack.getHoverName());
                    }

                    if (!pPlayer.getAbilities().instabuild) {
                        pStack.shrink(1);
                    }

                    return Optional.of((Mob) mob);
                }
            }
        }
    }

    protected EntityType<?> getDefaultType() {
        return this.defaultType;
    }
}
