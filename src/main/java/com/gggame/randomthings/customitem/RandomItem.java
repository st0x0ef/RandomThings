package com.gggame.randomthings.customitem;

import com.gggame.randomthings.init.ItemInit;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Objects;
import java.util.Random;

public class RandomItem extends Item {
    public RandomItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        if (!pLevel.isClientSide()) {
            double value = Math.random() * 100; // 0 - 100

            if (value < 0.8 /* 0.8% chance*/) {
                give(pPlayer, ItemInit.UPGRADED_NETHERITE_INGOT.get(), 2);
            }
            if (value < 1 /* 0.2% chance*/) {
                give(pPlayer, ItemInit.UPGRADED_NETHERITE_INGOT.get(), 4);
            }
            else if (value < 4 /* 3% chance*/) {
                give(pPlayer, Items.GOLDEN_APPLE, 8);
            }
            else if (value < 5 /* 1% chance*/) {
                give(pPlayer, Items.ENCHANTED_GOLDEN_APPLE, 4);
            }
            else if (value < 7.5 /* 2.5% chance*/) {
                give(pPlayer, ItemInit.SAP_SPOUT.get(), 1);
            }
            else if (value < 9 /* 1.5% chance*/) {
                give(pPlayer, Items.NETHERITE_INGOT, 2);
            }
            else if (value < 11 /* 4% chance*/) {
                give(pPlayer, ItemInit.SILVER_SWORD.get(), 1);
            }
            else if (value < 23 /* 10% chance*/) {
                give(pPlayer, Items.DIAMOND, 8);
            }
            else if (value < 27 /* 4% chance*/) {
                give(pPlayer, Items.DIAMOND, 16);
            }
            else if (value < 32 /* 5% chance*/) {
                give(pPlayer, Items.DIAMOND_AXE, 1);
            }
            else if (value < 41 /* 9% chance*/) {
                give(pPlayer, Items.IRON_INGOT, 32);
            }
            else if (value < 50 /* 9% chance*/) {
                give(pPlayer, ItemInit.SILVER_INGOT.get(), 32);
            }
            else if (value < 50.8 /* 0.8% chance*/) {
                give(pPlayer,  ItemInit.UPGRADED_NETHERITE_SWORD.get(), 1);
            }
            else if (value < 51.6 /* 0.8% chance*/) {
                give(pPlayer,  ItemInit.UPGRADED_NETHERITE_PICKAXE.get(), 1);
            }
            else if (value < 52.4 /* 0.8% chance*/) {
                give(pPlayer,  ItemInit.UPGRADED_NETHERITE_AXE.get(), 1);
            }
            else if (value < 53.2 /* 0.8% chance*/) {
                give(pPlayer,  Items.NETHERITE_SWORD, 1);
            }
            else if (value < 54 /* 0.8% chance*/) {
                give(pPlayer,  Items.NETHERITE_PICKAXE, 1);
            }
            else if (value < 54.8 /* 0.8% chance*/) {
                give(pPlayer,  Items.NETHERITE_AXE, 1);
            }
            else if (value < 59.8 /* 5% chance*/) {
                give(pPlayer, Items.GOLD_INGOT, 16);
            }
            else if (value < 62 /* 2.2% chance*/) {
                give(pPlayer, Items.GOLD_INGOT, 32);
            }
            else if (value < 70 /* 8% chance*/) {
                give(pPlayer, Items.FIRE_CHARGE, 2);
            }
            else if (value < 80 /* 10% chance*/) {
                give(pPlayer, Items.COAL, 32);
            }
            else if (value < 85 /* 5% chance*/) {
                give(pPlayer, Items.COAL, 64);
            }
            else if (value < 89 /* 4% chance*/) {
                give(pPlayer, Items.TURTLE_HELMET, 1);
            }
            else if (value < 91 /* 2% chance*/) {
                give(pPlayer, Items.AMETHYST_SHARD, 16);
            }
            else if (value < 92 /* 1% chance*/) {
                give(pPlayer, Items.BEACON, 1);
            }
            else if (value < 95 /* 3% chance*/) {
                give(pPlayer, Items.CHORUS_FRUIT, 16);
            }
            else if (value < 97 /* 2% chance*/) {
                give(pPlayer, Items.DRAGON_BREATH, 4);
            }
            else if (value < 97.1 /* 0.1% chance*/) {
                give(pPlayer, ItemInit.END_ERBIUM_GEM.get(), 4);
            }
            else if (value < 97.3 /* 0.2% chance*/) {
                give(pPlayer, ItemInit.NETHER_ERBIUM_GEM.get(), 4);
            }
            else if (value < 97.9 /* 0.6% chance*/) {
                give(pPlayer, ItemInit.ERBIUM_GEM.get(), 4);
            }
            else if (value < 98.25 /* 0.35% chance*/) {
                give(pPlayer, ItemInit.ERBIUM_RING_TIER_1.get(), 1);
            }
            else if (value < 98.4 /* 0.15% chance*/) {
                give(pPlayer, ItemInit.ERBIUM_RING_TIER_2.get(), 1);
            }
            else if (value < 98.5 /* 0.1% chance*/) {
                give(pPlayer, ItemInit.ERBIUM_RING_TIER_3.get(), 1);
            }
            else if (value < 99.5 /* 1% chance*/) {
                give(pPlayer, Items.DRAGON_HEAD, 1);
            }
            else if (value < 100 /* 0.5% chance*/) {
                give(pPlayer, Items.MAGMA_CREAM, 4);
            }
        }

        pPlayer.getItemInHand(pUsedHand).hurtAndBreak(1, pPlayer, (player) ->  player.broadcastBreakEvent(player.getUsedItemHand()));

        return super.use(pLevel, pPlayer, pUsedHand);
    }

    private void give(Player pPlayer, Item item, int quantity) {
        ItemStack itemStack = new ItemStack(() -> item, quantity);
        pPlayer.drop(itemStack, false, false);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(new TranslatableComponent("tooltip.randomthings.random_item"));
    }
}
