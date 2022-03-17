package com.gggame.randomthings.world;

import com.gggame.randomthings.init.BlockInit;
import net.minecraft.data.worldgen.features.FeatureUtils;
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

import java.util.List;

public class ModConfiguredFeature {
    public static final ConfiguredFeature<TreeConfiguration, ?> CHERRY_TREE =
            FeatureUtils.register("cherry", Feature.TREE.configured(
                    new TreeConfiguration.TreeConfigurationBuilder(
                            BlockStateProvider.simple(BlockInit.CHERRY_LOG.get()),
                            new ForkingTrunkPlacer(4, 3, 6),
                            BlockStateProvider.simple(BlockInit.CHERRY_LEAVES.get()),
                            new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 4),
                            new TwoLayersFeatureSize(1, 0, 2)).build()));

    public static final ConfiguredFeature<RandomFeatureConfiguration, ?> CHERRY_TREE_CHECKED =
            FeatureUtils.register("cherry_feature",
                    Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(
                            CHERRY_TREE.filteredByBlockSurvival(Blocks.OAK_SAPLING), 0.1f)),
                            CHERRY_TREE.filteredByBlockSurvival(Blocks.OAK_SAPLING))));

    public static final ConfiguredFeature<TreeConfiguration, ?> MAPLE_TREE =
            FeatureUtils.register("maple", Feature.TREE.configured(
                    new TreeConfiguration.TreeConfigurationBuilder(
                            BlockStateProvider.simple(BlockInit.MAPLE_LOG.get()),
                            new ForkingTrunkPlacer(3, 4, 10),
                            BlockStateProvider.simple(BlockInit.MAPLE_LEAVES.get()),
                            new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 4),
                            new TwoLayersFeatureSize(1, 0, 2)).build()));

    public static final ConfiguredFeature<RandomFeatureConfiguration, ?> MAPLE_TREE_CHECKED =
            FeatureUtils.register("maple_feature",
                    Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(
                            MAPLE_TREE.filteredByBlockSurvival(Blocks.OAK_SAPLING), 0.1f)),
                            MAPLE_TREE.filteredByBlockSurvival(Blocks.OAK_SAPLING))));


}
