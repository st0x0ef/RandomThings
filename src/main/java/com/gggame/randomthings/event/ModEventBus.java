package com.gggame.randomthings.event;

import com.gggame.randomthings.Main;
import com.gggame.randomthings.event.loot.ErbiumGemInAbandonedMineshaftAdditionModifier;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import javax.annotation.Nonnull;

public class ModEventBus {
    @SubscribeEvent
    public static void registerModifierSerializers(@Nonnull final RegistryEvent.Register<GlobalLootModifierSerializer<?>>
                                                           event) {
        event.getRegistry().registerAll(
                new ErbiumGemInAbandonedMineshaftAdditionModifier.Serializer().setRegistryName
                        (new ResourceLocation(Main.MOD_ID,"erbium_gem_in_abandoned_mineshaft"))
        );
    }
}
