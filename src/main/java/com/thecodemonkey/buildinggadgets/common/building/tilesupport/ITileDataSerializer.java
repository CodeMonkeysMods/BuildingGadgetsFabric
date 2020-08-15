package com.thecodemonkey.buildinggadgets.common.building.tilesupport;

import net.fabricmc.fabric.api.event.registry.RegistryEntryAddedCallback;
import net.minecraft.nbt.CompoundTag;

public interface ITileDataSerializer extends RegistryEntryAddedCallback<ITileDataSerializer> {
    CompoundTag serialize(ITileEntityData data, boolean persisted);

    ITileEntityData deserialize(CompoundTag tagCompound, boolean persisted);
}
