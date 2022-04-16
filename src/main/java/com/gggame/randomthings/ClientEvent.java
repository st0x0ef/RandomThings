package com.gggame.randomthings;

import com.gggame.randomthings.client.renderer.SapSpoutBlockEntityRenderer;
import com.gggame.randomthings.entity.ModBlockEntities;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Main.MOD_ID)
public class ClientEvent {
    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(ModBlockEntities.SAP_SPOUT.get(), SapSpoutBlockEntityRenderer::new);
    }
}
