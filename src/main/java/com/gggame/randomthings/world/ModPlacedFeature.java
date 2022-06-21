package com.gggame.randomthings.world;

import com.gggame.randomthings.Main;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import static com.gggame.randomthings.world.ModConfiguredFeature.*;

public class ModPlacedFeature {
    public static final DeferredRegister<PlacedFeature> PLACED_FEATURE =
            DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, Main.MOD_ID);

    public static final RegistryObject<PlacedFeature> CHERRY_PLACED =
            PLACED_FEATURE.register("cherry_placed",
                    () -> new PlacedFeature(((Holder<ConfiguredFeature<?,?>>)(Holder<? extends ConfiguredFeature<?,?>>) ModConfiguredFeature.CHERRY_TREE),
                            VegetationPlacements.treePlacement(
                            PlacementUtils.countExtra(1, 0.1f, 2))));
    public static final RegistryObject<PlacedFeature> MAPLE_PLACED =
            PLACED_FEATURE.register("maple_placed",
                    () -> new PlacedFeature(((Holder<ConfiguredFeature<?,?>>)(Holder<? extends ConfiguredFeature<?,?>>) ModConfiguredFeature.MAPLE_TREE),
                            VegetationPlacements.treePlacement(
                            PlacementUtils.countExtra(1, 0.1f, 2))));

    public static final RegistryObject<PlacedFeature> SILVER_ORE_PLACED = PLACED_FEATURE.register("silver_ore_placed", () -> new PlacedFeature((Holder<ConfiguredFeature<?,?>>)(Holder<? extends ConfiguredFeature<?,?>>)SILVER_ORE,
            OrePlacement.commonOrePlacement(8,
            HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-40), VerticalAnchor.aboveBottom(100)))));
    public static final RegistryObject<PlacedFeature>  OVERWORLD_ERBIUM_ORE_PLACED = PLACED_FEATURE.register("overworld_erbium_ore_placed", () -> new PlacedFeature((Holder<ConfiguredFeature<?,?>>)(Holder<? extends ConfiguredFeature<?,?>>)OVERWORLD_ERBIUM_ORE,
            OrePlacement.rareOrePlacement(2,
            HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-64), VerticalAnchor.aboveBottom(0)))));
    public static final RegistryObject<PlacedFeature>  NETHER_ERBIUM_ORE_PLACED = PLACED_FEATURE.register("nether_erbium_ore_placed", () -> new PlacedFeature((Holder<ConfiguredFeature<?,?>>)(Holder<? extends ConfiguredFeature<?,?>>)NETHER_ERBIUM_ORE,
            OrePlacement.rareOrePlacement(2,
            HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(0), VerticalAnchor.aboveBottom(32)))));
    public static final RegistryObject<PlacedFeature>  END_ERBIUM_ORE_PLACED = PLACED_FEATURE.register("end_erbium_ore_placed", () -> new PlacedFeature((Holder<ConfiguredFeature<?,?>>)(Holder<? extends ConfiguredFeature<?,?>>)END_ERBIUM_ORE,
            OrePlacement.rareOrePlacement(2,
            HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(0), VerticalAnchor.aboveBottom(32)))));
    public static final RegistryObject<PlacedFeature> RANDOM_ORE_PLACED = PLACED_FEATURE.register("random_ore_placed", () -> new PlacedFeature((Holder<ConfiguredFeature<?,?>>)(Holder<? extends ConfiguredFeature<?,?>>)RANDOM_ORE,
            OrePlacement.rareOrePlacement(4,
            HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-64), VerticalAnchor.aboveBottom(64)))));
    public static final RegistryObject<PlacedFeature>  SOLID_LAVA_PLACED = PLACED_FEATURE.register("solid_lava_placed", () -> new PlacedFeature((Holder<ConfiguredFeature<?,?>>)(Holder<? extends ConfiguredFeature<?,?>>)SOLID_LAVA,
            OrePlacement.commonOrePlacement(16,
            HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(0), VerticalAnchor.aboveBottom(128)))));


    public static void register(IEventBus bus) {
        PLACED_FEATURE.register(bus);
    }
}
