package com.gggame.randomthings.util;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.ItemStackHandler;

public class SetStackInSlot {
    public SetStackInSlot(ItemStackHandler itemStackHandler, int slot, Item item, int quantity) {
        ItemStack itemStack = new ItemStack(() -> item, quantity);
        itemStackHandler.setStackInSlot(slot, itemStack);
    }
}
