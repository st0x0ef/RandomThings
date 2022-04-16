package com.gggame.randomthings.customitem;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ErbiumRingItem extends Item {
    private boolean upgraded;

    public ErbiumRingItem(Properties pProperties, boolean upgraded) {
        super(pProperties);
        this.upgraded = upgraded;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        if (upgraded) {
            pPlayer.heal(2);
            pPlayer.removeEffect(MobEffects.BLINDNESS);
            pPlayer.removeEffect(MobEffects.WITHER);
            pPlayer.removeEffect(MobEffects.WEAKNESS);
            pPlayer.removeEffect(MobEffects.CONFUSION);
            pPlayer.removeEffect(MobEffects.HUNGER);
            pPlayer.removeEffect(MobEffects.POISON);
            pPlayer.removeEffect(MobEffects.LEVITATION);
            pPlayer.removeEffect(MobEffects.UNLUCK);
            pPlayer.removeEffect(MobEffects.DIG_SLOWDOWN);
            pPlayer.removeEffect(MobEffects.MOVEMENT_SLOWDOWN);
            pPlayer.removeEffect(MobEffects.HARM);
            pPlayer.removeEffect(MobEffects.BAD_OMEN);
            pPlayer.removeEffect(MobEffects.GLOWING);
        }
        else {
            pPlayer.heal(1);
            pPlayer.removeAllEffects();
        }

        pPlayer.clearFire();

        pPlayer.getItemInHand(pUsedHand).hurtAndBreak(1, pPlayer, (player) ->  player.broadcastBreakEvent(player.getUsedItemHand()));

        return super.use(pLevel, pPlayer, pUsedHand);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        if (Screen.hasShiftDown()) {
            if (upgraded) {
                pTooltipComponents.add(new TranslatableComponent("tooltip.randomthings.nether_erbium_ring"));
            }
            else {
                pTooltipComponents.add(new TranslatableComponent("tooltip.randomthings.erbium_ring"));
            }
        }
        else {
            pTooltipComponents.add(new TranslatableComponent("tooltip.randomthings.shift"));
        }
    }
}
