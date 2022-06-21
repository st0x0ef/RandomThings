package com.gggame.randomthings.event;

import com.gggame.randomthings.Main;
import com.gggame.randomthings.event.loot.EndErbiumGemInEndCitiesAdditionModifier;
import com.gggame.randomthings.event.loot.ErbiumGemInAbandonedMineshaftAdditionModifier;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;

import javax.annotation.Nonnull;

@Mod.EventBusSubscriber(modid = Main.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBus {
    @SubscribeEvent
    public static void registerModifierSerializers(@Nonnull final RegisterEvent event) {
        event.register(ForgeRegistries.Keys.LOOT_MODIFIER_SERIALIZERS, helper -> {
            helper.register(new ResourceLocation(Main.MOD_ID,"erbium_gem_in_abandoned_mineshaft"),
                    new ErbiumGemInAbandonedMineshaftAdditionModifier.Serializer());
            helper.register(new ResourceLocation(Main.MOD_ID, "end_erbium_gem_in_end_cities"),
                    new EndErbiumGemInEndCitiesAdditionModifier.Serializer());
        });
    }
}
