package com.gggame.randomthings.init;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ItemMaterialInit {
    public static final Tier ARGENT = new BaseToolMaterial(5, 500, 2, 1, 300,
            () -> Ingredient.of(ItemInit.SILVER_INGOT.get()));
    public static final ForgeTier UPGRADED_NETHERITE = new ForgeTier(4, 3000, 9.0f,
            4.0f, 18, BlockTags.NEEDS_DIAMOND_TOOL,
            () -> Ingredient.of(Items.NETHERITE_INGOT));

    private ItemMaterialInit() {

    }
}
