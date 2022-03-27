package com.gggame.randomthings.world;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class ModPlacedFeature {
    public static final Holder<PlacedFeature> CHERRY_PLACED =
            PlacementUtils.register("cherry_placed",
                    ModConfiguredFeature.CHERRY_TREE, VegetationPlacements.treePlacement(
                            PlacementUtils.countExtra(1, 0.1f, 2)));
    public static final Holder<PlacedFeature> MAPLE_PLACED =
            PlacementUtils.register("maple_placed",
                    ModConfiguredFeature.MAPLE_TREE, VegetationPlacements.treePlacement(
                            PlacementUtils.countExtra(1, 0.1f, 2)));
}
