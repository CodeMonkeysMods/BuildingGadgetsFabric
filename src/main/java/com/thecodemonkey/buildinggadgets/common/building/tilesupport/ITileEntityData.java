package com.thecodemonkey.buildinggadgets.common.building.tilesupport;

import com.thecodemonkey.buildinggadgets.common.building.view.BuildContext;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;

public interface ITileEntityData {
    ITileDataSerializer getSerializer();

    boolean placeIn(BuildContext context, BlockState state, BlockPos position);

//    default MaterialList getRequiredItems(BuildContext context, BlockState state, RayTraceContext target, BlockPos pos) {
//        ItemStack stack = null;
//        try {
//            stack = state.getBlock().getPickStack()
//        } catch (Exception e) {
//            BuildingGadgets.LOG.trace("Failed to retrieve pickBlock for {}.", state, e);
//        }
//        if (stack == null)
//            stack = new ItemStack(state.getBlock());
//        if (stack.isEmpty())
//            return MaterialList.empty();
//        return MaterialList.of(UniqueItem.ofStack(stack));
//    }
}
