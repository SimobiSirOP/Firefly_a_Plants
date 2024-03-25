package org.exampl.japan_mod.block.custom;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.phys.shapes.VoxelShape;

public class SpecialDoorBlock extends DoorBlock {
    public SpecialDoorBlock(Properties pProperties, BlockSetType pType) {
        super(pProperties, pType);
    }
    public static final DirectionProperty FACING;
    public static final BooleanProperty OPEN;
    public static final EnumProperty<DoorHingeSide> HINGE;
    public static final BooleanProperty POWERED;
    public static final EnumProperty<DoubleBlockHalf> HALF;
    protected static final float AABB_DOOR_THICKNESS = 3.0F;
    protected static final VoxelShape SOUTH_AABB;
    protected static final VoxelShape NORTH_AABB;
    protected static final VoxelShape WEST_AABB;
    protected static final VoxelShape EAST_AABB;
    static {
        FACING = HorizontalDirectionalBlock.FACING;
        OPEN = BlockStateProperties.OPEN;
        HINGE = BlockStateProperties.DOOR_HINGE;
        POWERED = BlockStateProperties.POWERED;
        HALF = BlockStateProperties.DOUBLE_BLOCK_HALF;
        SOUTH_AABB = Block.box(0.0, 0.0, 0.0, 16.0, 16.0, 2.0);
        NORTH_AABB = Block.box(0.0, 0.0, 14.0, 16.0, 16.0, 16.0);
        WEST_AABB = Block.box(14.0, 0.0, 0.0, 16.0, 16.0, 16.0);
        EAST_AABB = Block.box(0.0, 0.0, 0.0, 2.0, 16.0, 16.0);
    }
}
