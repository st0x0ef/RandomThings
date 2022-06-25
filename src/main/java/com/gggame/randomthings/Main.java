package com.gggame.randomthings;

import com.gggame.randomthings.customblock.entity.ModBlockEntities;
import com.gggame.randomthings.init.BlockInit;
import com.gggame.randomthings.init.ItemInit;
import com.gggame.randomthings.init.WoodTypeInit;
import com.gggame.randomthings.screen.MenuTypes;
import com.gggame.randomthings.world.ModPlacedFeature;
import com.gggame.randomthings.world.biomemodifiers.ModBiomeModifiers;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;


@Mod(Main.MOD_ID)
public class Main
{
    public static final String MOD_ID = "randomthings";

    public static final CreativeModeTab RANDOMTHINGS_OTHER_TAB = new CreativeModeTab("randomthings_other_tab") {
        @Override
        @OnlyIn(Dist.CLIENT)
        public ItemStack makeIcon() {
            return new ItemStack(ItemInit.SILVER_INGOT.get());
        }
    };
    public static final CreativeModeTab RANDOMTHINGS_TOOL_AND_ARMOR_TAB = new CreativeModeTab("randomthings_tool_and_armor_tab") {
        @Override
        @OnlyIn(Dist.CLIENT)
        public ItemStack makeIcon() {
            return new ItemStack(ItemInit.UPGRADED_NETHERITE_AXE.get());
        }
    };
    public static final CreativeModeTab RANDOMTHINGS_DECORATION_TAB = new CreativeModeTab("randomthings_decoration_tab") {
        @Override
        @OnlyIn(Dist.CLIENT)
        public ItemStack makeIcon() {
            return new ItemStack(BlockInit.ANDESITE_BRICK.get().asItem());
        }
    };
    public static final CreativeModeTab RANDOMTHINGS_ORE_TAB = new CreativeModeTab("randomthings_ore_tab") {
        @Override
        @OnlyIn(Dist.CLIENT)
        public ItemStack makeIcon() {
            return new ItemStack(BlockInit.ERBIUM_ORE.get().asItem());
        }
    };
    public static final CreativeModeTab RANDOMTHINGS_FOOD_TAB = new CreativeModeTab("randomthings_food_tab") {
        @Override
        @OnlyIn(Dist.CLIENT)
        public ItemStack makeIcon() {
            return new ItemStack(ItemInit.MAPLE_SYRUP_BOTTLE.get());
        }
    };

    public Main() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        ItemInit.ITEMS.register(bus);
        BlockInit.BLOCKS.register(bus);

        ModBlockEntities.BLOCK_ENTITIES.register(bus);
        MenuTypes.MENUS.register(bus);

        ModPlacedFeature.register(bus);
        ModBiomeModifiers.register(bus);

        bus.addListener(this::setup);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            Sheets.addWoodType(WoodTypeInit.CHERRY);
            Sheets.addWoodType(WoodTypeInit.MAPLE);
        });
    }
}
