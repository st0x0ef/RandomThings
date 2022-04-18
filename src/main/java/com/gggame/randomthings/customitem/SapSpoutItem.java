package com.gggame.randomthings.customitem;

import com.gggame.randomthings.init.BlockInit;
import com.gggame.randomthings.init.ItemInit;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class SapSpoutItem extends Item {

    public SapSpoutItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        if (!pContext.getLevel().isClientSide()) {
            Player pPlayer = pContext.getPlayer();
            BlockPos positionClicked = pContext.getClickedPos();
            if (pContext.getLevel().getBlockState(positionClicked).getBlock() == BlockInit.MAPLE_LOG.get()) {
                pPlayer.addItem(ItemInit.MAPLE_WATER_BOTTLE.get().getDefaultInstance());
                pPlayer.getItemInHand(pContext.getHand()).hurtAndBreak(1, pPlayer, (player) ->  player.broadcastBreakEvent(player.getUsedItemHand()));
            }
        }

        return super.useOn(pContext);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        if (Screen.hasShiftDown()) {
            pTooltipComponents.add(new TranslatableComponent("tooltip.randomthings.sap_spout"));
        }
        else {
            pTooltipComponents.add(new TranslatableComponent("tooltip.randomthings.shift"));
        }
    }
}
