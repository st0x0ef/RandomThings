package com.gggame.randomthings.init;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ItemMaterialInit {
    public static final ForgeTier SILVER = new ForgeTier(2, 1000, 5.0f,
            3.0f, 10, BlockTags.NEEDS_IRON_TOOL,
            () -> Ingredient.of(ItemInit.SILVER_INGOT.get()));
    public static final ForgeTier UPGRADED_NETHERITE = new ForgeTier(4, 3000, 9.0f,
            4.0f, 18, BlockTags.NEEDS_DIAMOND_TOOL,
            () -> Ingredient.of(Items.NETHERITE_INGOT));
    public static final ForgeTier DESTRUCTIVE = new ForgeTier(99, 30, 9999f,
            4.0f, 0, BlockTags.NEEDS_DIAMOND_TOOL,
            () -> Ingredient.of(ItemInit.END_ERBIUM_GEM.get()));

    private ItemMaterialInit() {

    }
}
