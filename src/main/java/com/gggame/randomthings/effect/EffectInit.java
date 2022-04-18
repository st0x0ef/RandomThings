package com.gggame.randomthings.effect;

import com.gggame.randomthings.Main;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EffectInit {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, Main.MOD_ID);

    public static final RegistryObject<MobEffect> CLEAR_EFFECT = MOB_EFFECTS.register("clear_effect",
            () -> new ClearEffect(MobEffectCategory.NEUTRAL, 285949));
}
