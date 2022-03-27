package com.gggame.randomthings.world;

import com.gggame.randomthings.init.BlockInit;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.ForkingTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

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


}
