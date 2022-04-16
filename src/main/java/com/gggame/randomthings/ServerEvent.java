package com.gggame.randomthings;

import com.gggame.randomthings.world.OreGeneration;
import com.gggame.randomthings.world.TreeGeneration;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Main.MOD_ID)
public class ServerEvent {
    @SubscribeEvent
    public static void biomeLoadingEvent(final BiomeLoadingEvent event) {
        TreeGeneration.generateTrees(event);
        OreGeneration.generateOres(event);
    }
}
