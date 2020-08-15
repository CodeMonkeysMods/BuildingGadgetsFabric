package com.thecodemonkey.buildinggadgets.common.tileentities;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;

public class ConstructionBlockTileEntity extends BlockEntity {

    private BlockState blockState;
    private BlockState actualBlockState;

    public ConstructionBlockTileEntity(BlockEntityType<?> type) {
        super(type);
    }
}
