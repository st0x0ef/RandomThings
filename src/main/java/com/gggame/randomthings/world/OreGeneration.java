package com.gggame.randomthings.world;

import com.gggame.randomthings.init.BlockInit;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import java.util.List;

public class OreGeneration {
    public static final List<OreConfiguration.TargetBlockState> OVERWORLD_SILVER_ORE = List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, BlockInit.SILVER_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, BlockInit.SILVER_ORE_DEEPSLATE.get().defaultBlockState()));

    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> SILVER_ORE = FeatureUtils.register("sivler_ore", Feature.ORE, new OreConfiguration(OVERWORLD_SILVER_ORE, 5));

    public static final Holder<PlacedFeature> SILVER_ORE_PLACED = PlacementUtils.register("silver_ore_placed", SILVER_ORE, OrePlacement.commonOrePlacement(8,
            HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-40), VerticalAnchor.aboveBottom(100))));

    public static final List<OreConfiguration.TargetBlockState> OVERWORLD_ERBIUM_ORE_REPLACEABLES = List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, BlockInit.ERBIUM_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, BlockInit.ERBIUM_ORE_DEEPSLATE.get().defaultBlockState()));
    public static final List<OreConfiguration.TargetBlockState> NETHER_ERBIUM_ORE_REPLACEABLES = List.of(
            OreConfiguration.target(OreFeatures.NETHER_ORE_REPLACEABLES, BlockInit.NETHER_ERBIUM_ORE.get().defaultBlockState()));

    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> OVERWORLD_ERBIUM_ORE = FeatureUtils.register("overworld_erbium_ore", Feature.ORE, new OreConfiguration(OVERWORLD_ERBIUM_ORE_REPLACEABLES, 4));
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> NETHER_ERBIUM_ORE = FeatureUtils.register("nether_erbium_ore", Feature.ORE, new OreConfiguration(NETHER_ERBIUM_ORE_REPLACEABLES, 4));

    public static final Holder<PlacedFeature>  OVERWORLD_ERBIUM_ORE_PLACED = PlacementUtils.register("overworld_erbium_ore_placed", OVERWORLD_ERBIUM_ORE, OrePlacement.rareOrePlacement(1,
            HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-64), VerticalAnchor.aboveBottom(0))));
    public static final Holder<PlacedFeature>  NETHER_ERBIUM_ORE_PLACED = PlacementUtils.register("nether_erbium_ore_placed", OVERWORLD_ERBIUM_ORE, OrePlacement.rareOrePlacement(1,
            HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(0), VerticalAnchor.aboveBottom(32))));

    public static final List<OreConfiguration.TargetBlockState> OVERWORLD_RANDOM_ORE = List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, BlockInit.SILVER_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, BlockInit.SILVER_ORE_DEEPSLATE.get().defaultBlockState()));

    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> RANDOM_ORE = FeatureUtils.register("random_ore", Feature.ORE, new OreConfiguration(OVERWORLD_SILVER_ORE, 5));

    public static final Holder<PlacedFeature> RANDOM_ORE_PLACED = PlacementUtils.register("random_ore_placed", SILVER_ORE, OrePlacement.rareOrePlacement(4,
            HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-64), VerticalAnchor.aboveBottom(64))));

    public static void generateOres(final BiomeLoadingEvent event) {
        List<Holder<PlacedFeature>> base = event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES);
        base.add(SILVER_ORE_PLACED);
        base.add(OVERWORLD_ERBIUM_ORE_PLACED);
        base.add(NETHER_ERBIUM_ORE_PLACED);
        base.add(RANDOM_ORE_PLACED);
    }
}
