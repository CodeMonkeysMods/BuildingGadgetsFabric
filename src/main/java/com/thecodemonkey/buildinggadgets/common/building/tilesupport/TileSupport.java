package com.thecodemonkey.buildinggadgets.common.building.tilesupport;

import net.minecraft.block.entity.BlockEntity;

import java.util.Iterator;

public final class TileSupport {
    private TileSupport() {}

    private static ITileDataFactory DATA_PROVIDER_FACTORY = new DataProviderFactory();

    public static ITileDataFactory dataProviderFactory() {
        return DATA_PROVIDER_FACTORY;
    }

    public static ITileEntityData createTileData(BlockEntity te) {
        if (te == null)
            return dummyTileEntityData();
        ITileEntityData res;

        for (Iterator<ITileDataFactory> it = TileEntityData.getTileDataFactories().iterator(); it.hasNext();) {
            ITileDataFactory factory = it.next();
            res = factory.createDataFor(te);
            if (res != null)
                return res;
        }

        return dummyTileEntityData();
    }

    public static ITileEntityData createTileData()
}
