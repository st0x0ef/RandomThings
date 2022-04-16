package com.gggame.randomthings.init;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ItemMaterialInit {
    public static final ForgeTier ARGENT = new ForgeTier(2, 1000, 5.0f,
            3.0f, 10, BlockTags.NEEDS_IRON_TOOL,
            () -> Ingredient.of(Items.NETHERITE_INGOT));
    public static final ForgeTier UPGRADED_NETHERITE = new ForgeTier(4, 3000, 9.0f,
            4.0f, 18, BlockTags.NEEDS_DIAMOND_TOOL,
            () -> Ingredient.of(Items.NETHERITE_INGOT));

    private ItemMaterialInit() {

    }
}
