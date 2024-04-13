package org.exampl.japan_mod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.exampl.japan_mod.block.ModBlocks;

public class GlyciniaVine extends CropBlock {
    public static final int MAX_AGE = 1;
    public static final IntegerProperty AGE = BlockStateProperties.AGE_1;
    @Override
    public IntegerProperty getAgeProperty(){
        return AGE;
    }

    @Override
    public int getMaxAge(){
        return MAX_AGE;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(AGE);
    }
    public GlyciniaVine(Properties pProperties) {
        super(pProperties);
    }
    public boolean mayPlaceOn(BlockState pState, BlockGetter pLevel, BlockPos pPos) {
        BlockState state = pLevel.getBlockState(pPos.above());
        return state.is(BlockTags.LEAVES);
    }
    public boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
        return this.mayPlaceOn(pLevel.getBlockState(pPos), pLevel, pPos);
    }

}
