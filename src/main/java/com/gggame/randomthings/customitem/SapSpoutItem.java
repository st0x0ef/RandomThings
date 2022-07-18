package com.gggame.randomthings.customitem;

import com.gggame.randomthings.init.BlockInit;
import com.gggame.randomthings.init.ItemInit;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
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
                int qt = (int) Math.round(3 * Math.random() + 1); // 1 - 4
                qt = qt <= 2 ? 1 : qt - 1;

                give(pPlayer, ItemInit.MAPLE_WATER_BOTTLE.get(), qt);

                if (Math.random() < 0.1) {
                    pPlayer.level.removeBlock(positionClicked, false);
                    pPlayer.level.setBlock(positionClicked, BlockInit.MAPLE_LOG_WITHOUT_SAP.get().defaultBlockState(), 1);
                }

                pPlayer.getItemInHand(pContext.getHand()).hurtAndBreak(1, pPlayer, (player) ->  player.broadcastBreakEvent(player.getUsedItemHand()));
            }
        }

        return super.useOn(pContext);
    }

    private void give(Player pPlayer, Item item, int quantity) {
        ItemStack itemStack = new ItemStack(() -> item, quantity);
        pPlayer.drop(itemStack, false, false);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("tooltip.randomthings.sap_spout"));
    }
}
