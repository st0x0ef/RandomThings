package com.gggame.randomthings.world;

import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class ModPlacedFeature {
    public static final PlacedFeature CHERRY_PLACED =
            PlacementUtils.register("cherry_placed",
                    ModConfiguredFeature.CHERRY_TREE_CHECKED.placed(VegetationPlacements.treePlacement(
                            PlacementUtils.countExtra(1, 0.1f, 2))));
    public static final PlacedFeature MAPLE_PLACED =
            PlacementUtils.register("maple_placed",
                    ModConfiguredFeature.MAPLE_TREE_CHECKED.placed(VegetationPlacements.treePlacement(
                            PlacementUtils.countExtra(1, 0.1f, 2))));
}
