package com.gggame.randomthings.event.loot;

import com.gggame.randomthings.Main;
import com.mojang.serialization.Codec;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModLootModifiers {
    public static final DeferredRegister<Codec<? extends IGlobalLootModifier>> REGISTER = DeferredRegister.create(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, Main.MOD_ID);
    public static final RegistryObject<Codec<EndErbiumGemInEndCitiesAdditionModifier>> EndErbiumGemInEndCities = REGISTER.register("end_erbium_gem_in_end_cities", () -> EndErbiumGemInEndCitiesAdditionModifier.CODEC);
    public static final RegistryObject<Codec<ErbiumGemInAbandonedMineshaftAdditionModifier>> ErbiumGemInAbandonedMineshaft = REGISTER.register("erbium_gem_in_abandoned_mineshaft", () -> ErbiumGemInAbandonedMineshaftAdditionModifier.CODEC);
}
