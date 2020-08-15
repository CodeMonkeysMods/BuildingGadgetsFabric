package com.thecodemonkey.buildinggadgets.common.building.tilesupport;

import net.minecraft.block.entity.BlockEntity;

import jdk.internal.jline.internal.Nullable;

@FunctionalInterface
public interface ITileDataFactory {
    @Nullable
    ITileEntityData createDataFor(BlockEntity tileEntity);
}
