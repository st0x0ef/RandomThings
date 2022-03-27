package com.gggame.randomthings.world;

import com.gggame.randomthings.init.BlockInit;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import java.util.List;
import java.util.function.Supplier;

public class OreGeneration {
    public static final List<OreConfiguration.TargetBlockState> OVERWORLD_SILVER_ORE = List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, BlockInit.SILVER_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, BlockInit.SILVER_ORE_DEEPSLATE.get().defaultBlockState()));

    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> SILVER_ORE = FeatureUtils.register("sivler_ore", Feature.ORE, new OreConfiguration(OVERWORLD_SILVER_ORE, 5));

    public static final Holder<PlacedFeature> SILVER_ORE_PLACED = PlacementUtils.register("silver_ore_placed", SILVER_ORE, OrePlacement.commonOrePlacement(12,
            HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-40), VerticalAnchor.aboveBottom(100))));

    public static void generateOres(final BiomeLoadingEvent event) {
        List<Holder<PlacedFeature>> base = event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES);
        base.add(SILVER_ORE_PLACED);
    }
}
