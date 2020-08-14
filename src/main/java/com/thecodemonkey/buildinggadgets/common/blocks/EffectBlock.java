package com.thecodemonkey.buildinggadgets.common.blocks;

import jdk.internal.jline.internal.Nullable;
import net.minecraft.block.*;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.context.LootContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;

import java.util.ArrayList;
import java.util.List;

public class EffectBlock extends Block {

    public enum Mode {
        PLACE() {

        },
        REMOVE() {

        },
        REPLACE() {

        };

        public static final Mode[] VALUES = values();

        public abstract void onBuilderRemoved(EffectBlockTileEntity builder);
    }

    private static final Material EFFECT_BLOCK_MATERIAL = new Material.Builder(MaterialColor.DIRT).notSolid().build();

    public static void spawnUndoBlock(BuildContext context, PlacementTarget target) {

    }

    public static void spawnEffectBlock(BuildContext context, PlacementTarget target, Mode mode, boolean usePaste) {

    }

    public static void spawnEffectBlock(IWorld world, BlockPos spawnPos, BlockData spawnBlock, Mode mode, boolean usePaste) {

    }

    private static void spawnEffectBlock(@Nullable TileEntity curTe, BlockState curState, IWorld world, BlockPos spawnPos, BlockData spawnBlock, Mode mode, boolean usePaste) {

    }

    public EffectBlock() {
//        super(Block.Properties.create(EFFECT_BLOCK_MATERIAL).hardnessAndResistance(20f).nonOpaque().noDrops());
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new EffectBlockTileEntity();
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.INVISIBLE;
    }

    @Override
    public boolean isSideInvisible(BlockState p_200122_1_, BlockState p_200122_2_, Direction p_200122_3_) {
        return true;
    }

    @Override
    public List<ItemStack> getDrops(BlockState p_220076_1_, LootContext.Builder p_220076_2_) {
        return new ArrayList<>();
    }

    @Override
    public PushReaction getPushReaction(BlockState state) {
        return PushReaction.BLOCK;
    }

    @Override
    public int getOpacity(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return 0;
    }

    @Override
    public float getAmbientOcclusionLightValue(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return 1.0f;
    }
}
