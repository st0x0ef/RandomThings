package com.gggame.randomthings.event;

import com.gggame.randomthings.Main;
import com.gggame.randomthings.init.WoodTypeInit;
import com.gggame.randomthings.screen.MapleFurnaceScreen;
import com.gggame.randomthings.screen.MenuTypes;
import com.gggame.randomthings.screen.OreExtractorScreen;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = Main.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEvent {
    @SubscribeEvent
    public static void clientSetup(final FMLClientSetupEvent event) {
        MenuScreens.register(MenuTypes.ORE_EXTRACTOR_MENU.get(), OreExtractorScreen::new);
        MenuScreens.register(MenuTypes.MAPLE_FURNACE_MENU.get(), MapleFurnaceScreen::new);

        WoodType.register(WoodTypeInit.CHERRY);
        WoodType.register(WoodTypeInit.MAPLE);
    }
}
