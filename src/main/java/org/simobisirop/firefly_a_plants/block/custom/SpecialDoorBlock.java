package org.simobisirop.firefly_a_plants.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class SpecialDoorBlock extends DoorBlock {
    public SpecialDoorBlock(Properties pProperties, BlockSetType pType) {
        super(pProperties, pType);
        this.registerDefaultState(((BlockState)((BlockState)((BlockState)((BlockState)((BlockState) this.stateDefinition.any()).setValue(FACING, Direction.NORTH)).setValue(OPEN, false)).setValue(HINGE, DoorHingeSide.LEFT)).setValue(POWERED, false)).setValue(HALF, DoubleBlockHalf.LOWER));
    }
    public static final EnumProperty<DoorHingeSide> HINGE = BlockStateProperties.DOOR_HINGE;

    protected static final VoxelShape SOUTH_AABB = Block.box(0.0, 0.0, 0.0, 16.0, 16.0, 2.0);
    protected static final VoxelShape NORTH_AABB = Block.box(0.0, 0.0, 14.0, 16.0, 16.0, 16.0);
    protected static final VoxelShape WEST_AABB = Block.box(14.0, 0.0, 0.0, 16.0, 16.0, 16.0);
    protected static final VoxelShape EAST_AABB = Block.box(0.0, 0.0, 0.0, 2.0, 16.0, 16.0);

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        Direction $$4 = (Direction)pState.getValue(FACING);
        boolean $$5 = !(Boolean)pState.getValue(OPEN);
        boolean $$6 = pState.getValue(HINGE) == DoorHingeSide.RIGHT;
        switch ($$4) {
            case EAST:
            default:
                return $$5 ? EAST_AABB : ($$6 ? NORTH_AABB : SOUTH_AABB);
            case SOUTH:
                return $$5 ? SOUTH_AABB : ($$6 ? EAST_AABB : WEST_AABB);
            case WEST:
                return $$5 ? WEST_AABB : ($$6 ? SOUTH_AABB : NORTH_AABB);
            case NORTH:
                return $$5 ? NORTH_AABB : ($$6 ? WEST_AABB : EAST_AABB);
        }
    }

}
