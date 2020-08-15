package com.thecodemonkey.buildinggadgets.common.building;

import com.thecodemonkey.buildinggadgets.common.building.tilesupport.TileSupport;
import net.minecraft.block.Blocks;

public final class BlockData {
    public static final BlockData AIR = new BlockData(Blocks.AIR.getDefaultState(), TileSupport.dummyTileEntityData());
}
