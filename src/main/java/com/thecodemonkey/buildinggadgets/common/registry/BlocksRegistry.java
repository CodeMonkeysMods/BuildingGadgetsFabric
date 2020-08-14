package com.thecodemonkey.buildinggadgets.common.registry;

import com.thecodemonkey.buildinggadgets.BuildingGadgets;
import com.thecodemonkey.buildinggadgets.common.blocks.EffectBlock;
import com.thecodemonkey.buildinggadgets.common.tab.CreativeTab;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BlocksRegistry {

    public static final Block EFFECT_BLOCK = new EffectBlock();
//    public static final Block CONSTRUCTION_BLOCK = new ConstructionBlock();
//    public static final Block CONSTRUCTION_DENSE_BLOCK = new ConstructionBlockDense();
//    public static final Block CONSTRUCTION_POWDER_BLOCK = new ConstructionBlockPowder();
//    public static final Block TEMPLATE_MANAGER_BLOCK = new TemplateManager();

    public static void register() {
        registerBlock("effect_block", EFFECT_BLOCK);
//        registerBlock("construction_block", CONSTRUCTION_BLOCK);
//        registerBlock("construction_block_dense", CONSTRUCTION_DENSE_BLOCK);
//        registerBlock("construction_block_powder", CONSTRUCTION_POWDER_BLOCK);
//        registerBlock("template_manager", TEMPLATE_MANAGER_BLOCK);
    }

    private static Block registerBlock(String name, Block block) {
        Registry.register(Registry.BLOCK, new Identifier(BuildingGadgets.MOD_ID, name), block);
        ItemsRegistry.registerItem(name, new BlockItem(block, new Item.Settings().group(CreativeTab.TAB)));
        return block;
    }
}