package com.gggame.randomthings.world;

import com.gggame.randomthings.init.BlockInit;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.ForkingTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;

import java.util.List;

public class ModConfiguredFeature {
    public static final Holder<? extends ConfiguredFeature<TreeConfiguration, ?>> CHERRY_TREE =
            FeatureUtils.register("cherry", Feature.TREE, (
                    new TreeConfiguration.TreeConfigurationBuilder(
                            BlockStateProvider.simple(BlockInit.CHERRY_LOG.get()),
                            new ForkingTrunkPlacer(4, 3, 6),
                            BlockStateProvider.simple(BlockInit.CHERRY_LEAVES.get()),
                            new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 4),
                            new TwoLayersFeatureSize(1, 0, 2)).build()));

    public static final Holder<PlacedFeature> CHERRY_TREE_CHECKED =
            PlacementUtils.register("cherry_checked", CHERRY_TREE, PlacementUtils.filteredByBlockSurvival(BlockInit.CHERRY_SAPLING.get()));

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> CHERRY_TREE_SPAWN =
            FeatureUtils.register("cherry_spawn", Feature.RANDOM_SELECTOR,
                    new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(CHERRY_TREE_CHECKED,
                            0.5F)), CHERRY_TREE_CHECKED));

    public static final Holder<? extends ConfiguredFeature<TreeConfiguration, ?>> MAPLE_TREE =
            FeatureUtils.register("maple", Feature.TREE,
                    new TreeConfiguration.TreeConfigurationBuilder(
                            BlockStateProvider.simple(BlockInit.MAPLE_LOG.get()),
                            new ForkingTrunkPlacer(3, 4, 10),
                            BlockStateProvider.simple(BlockInit.MAPLE_LEAVES.get()),
                            new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 4),
                            new TwoLayersFeatureSize(1, 0, 2)).build());

    public static final Holder<PlacedFeature> MAPLE_TREE_CHECKED =
            PlacementUtils.register("maple_checked", MAPLE_TREE, PlacementUtils.filteredByBlockSurvival(BlockInit.MAPLE_SAPLING.get()));

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> MAPLE_TREE_SPAWN =
            FeatureUtils.register("maple_spawn", Feature.RANDOM_SELECTOR,
                    new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(MAPLE_TREE_CHECKED,
                            0.5F)), MAPLE_TREE_CHECKED));

    public static final List<OreConfiguration.TargetBlockState> OVERWORLD_SILVER_ORE = List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, BlockInit.SILVER_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, BlockInit.SILVER_ORE_DEEPSLATE.get().defaultBlockState()));
    public static final List<OreConfiguration.TargetBlockState> OVERWORLD_ERBIUM_ORE_REPLACEABLES = List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, BlockInit.ERBIUM_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, BlockInit.ERBIUM_ORE_DEEPSLATE.get().defaultBlockState()));
    public static final List<OreConfiguration.TargetBlockState> NETHER_ERBIUM_ORE_REPLACEABLES = List.of(
            OreConfiguration.target(OreFeatures.NETHER_ORE_REPLACEABLES, BlockInit.NETHER_ERBIUM_ORE.get().defaultBlockState()));

    public static final List<OreConfiguration.TargetBlockState> END_ERBIUM_ORE_REPLACEABLES = List.of(
            OreConfiguration.target(new BlockMatchTest(Blocks.END_STONE), BlockInit.END_ERBIUM_ORE.get().defaultBlockState()));

    public static final List<OreConfiguration.TargetBlockState> SOLID_LAVA_ORE_REPLACEABLES = List.of(
            OreConfiguration.target(OreFeatures.NETHERRACK, BlockInit.SOLID_LAVA.get().defaultBlockState()),
            OreConfiguration.target(new BlockMatchTest(Blocks.MAGMA_BLOCK), BlockInit.SOLID_LAVA.get().defaultBlockState()));

    public static final List<OreConfiguration.TargetBlockState> OVERWORLD_RANDOM_ORE_REPLACEABLES = List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, BlockInit.RANDOM_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, BlockInit.DEEPSLATE_RANDOM_ORE.get().defaultBlockState()));


    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> SILVER_ORE = FeatureUtils.register("sivler_ore", Feature.ORE, new OreConfiguration(OVERWORLD_SILVER_ORE, 5));
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> OVERWORLD_ERBIUM_ORE = FeatureUtils.register("overworld_erbium_ore", Feature.ORE, new OreConfiguration(OVERWORLD_ERBIUM_ORE_REPLACEABLES, 4));
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> NETHER_ERBIUM_ORE = FeatureUtils.register("nether_erbium_ore", Feature.ORE, new OreConfiguration(NETHER_ERBIUM_ORE_REPLACEABLES, 4));
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> END_ERBIUM_ORE = FeatureUtils.register("end_erbium_ore", Feature.ORE, new OreConfiguration(END_ERBIUM_ORE_REPLACEABLES, 4));
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> RANDOM_ORE = FeatureUtils.register("random_ore", Feature.ORE, new OreConfiguration(OVERWORLD_RANDOM_ORE_REPLACEABLES, 5));
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> SOLID_LAVA = FeatureUtils.register("solid_lava", Feature.ORE, new OreConfiguration(SOLID_LAVA_ORE_REPLACEABLES, 20));
}
