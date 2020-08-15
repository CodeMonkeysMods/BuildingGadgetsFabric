package com.thecodemonkey.buildinggadgets.common.tileentities;

import com.thecodemonkey.buildinggadgets.common.blocks.EffectBlock.Mode;
import com.thecodemonkey.buildinggadgets.common.building.BlockData;
import com.thecodemonkey.buildinggadgets.common.building.tilesupport.TileSupport;
import com.thecodemonkey.buildinggadgets.common.util.ref.NBTKeys;
import jdk.internal.jline.internal.Nullable;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.world.BlockView;

public class EffectBlockTileEntity extends BlockEntity implements BlockEntityProvider {

    private BlockState renderedBlock;

    private BlockState sourceBlock;

    private Mode mode = null;

    private boolean usePaste;

    private int ticks;

    public EffectBlockTileEntity() {
        super(TileEntityRegistry.EFFECT_BLOCK_TILE_ENTITY.get());
    }

    public void initializeData(BlockState curState, @Nullable BlockEntity te, BlockState replacementBlock, Mode mode, boolean usePaste) {
        this.ticks = 0;
        this.sourceBlock = replacementBlock;
        this.mode = mode;
        this.usePaste = usePaste;

        if (mode == Mode.REPLACE)
            this.renderedBlock = te instanceof ConstructionBlockTileEntity ? te.getConstructionBlockData() : TileSupport.createBlockData(curState, te);
        else
            this.renderedBlock = te instanceof ConstructionBlockTileEntity ? te.getConstructionBlockData() : replacementBlock;
    }

//    @Override
//    public void tick() {
//        ticks++;
//        if (ticks >= getLifeSpan()) {
//            complete();
//        }
//    }

    private void complete() {
        if (world == null || mode == null || renderedBlock == null)
            return;

        mode.onBuilderRemoved(this);
    }

    public BlockState getRenderedBlock() {
        return renderedBlock;
    }

    public BlockState getSourceBlock() {
        return sourceBlock;
    }

    public Mode getReplacementMode() {
        return mode;
    }

    public boolean isUsingPaste() {
        return usePaste;
    }

    public int getTicksExisted() {
        return ticks;
    }

    public int getLifeSpan() {
        return 20;
    }

//    @Override
//    public BlockEntityUpdateS2CPacket getUpdatePacket() {
//        return new BlockEntityUpdateS2CPacket(pos, 0, getUpdateTag());
//    }

//    @Override
//    public CompoundTag getUpdateTag() {
//        return write(new CompoundTag());
//    }

//    @Override
//    public void handleUpdateTag(BlockState state, CompoundTag tag) {
//        deserializeNBT(tag);
//    }

//    @Override
//    public CompoundTag write(CompoundTag compound) {
//        if (mode != null && renderedBlock != null && sourceBlock != null) {
//            compound.putInt(NBTKeys.GADGET_TICKS, ticks);
//            compound.putInt(NBTKeys.GADGET_MODE, mode.ordinal());
//            compound.put(NBTKeys.GADGET_REPLACEMENT_BLOCK, renderedBlock.serialize(true));
//            compound.put(NBTKeys.GADGET_SOURCE_BLOCK, sourceBlock.serialize(true));
//            compound.putBoolean(NBTKeys.GADGET_USE_PASTE, usePaste);
//        }
//        return super.write(compound);
//    }
//
//    public void deserializeNBT(CompoundTag compound) {
//        super.deserializeNBT(compound);
//
//        if (compound.contains(NBTKeys.GADGET_TICKS, NBT.TAG_INT) &&
//                compound.contains(NBTKeys.GADGET_MODE, NBT.TAG_INT) &&
//                compound.contains(NBTKeys.GADGET_SOURCE_BLOCK, NBT.TAG_COMPOUND) &&
//                compound.contains(NBTKeys.GADGET_REPLACEMENT_BLOCK, NBT.TAG_COMPOUND) &&
//                compound.contains(NBTKeys.GADGET_USE_PASTE)) {
//
//            ticks = compound.getInt(NBTKeys.GADGET_TICKS);
//            mode = Mode.VALUES[compound.getInt(NBTKeys.GADGET_MODE)];
//            renderedBlock = BlockState.tryDeserialize(compound.getCompound(NBTKeys.GADGET_REPLACEMENT_BLOCK), true);
//            sourceBlock = BlockState.tryDeserialize(compound.getCompound(NBTKeys.GADGET_SOURCE_BLOCK), true);
//            usePaste = compound.getBoolean(NBTKeys.GADGET_USE_PASTE);
//        }
//    }
}
