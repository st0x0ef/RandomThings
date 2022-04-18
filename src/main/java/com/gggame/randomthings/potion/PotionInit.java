package com.gggame.randomthings.potion;

import com.gggame.randomthings.Main;
import com.gggame.randomthings.effect.EffectInit;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class PotionInit {
    public static final DeferredRegister<Potion> POTIONS = DeferredRegister.create(ForgeRegistries.POTIONS, Main.MOD_ID);

    public static RegistryObject<Potion> ERBIUM_POTION = POTIONS.register("erbium_potion",
            () -> new Potion(new MobEffectInstance(EffectInit.CLEAR_EFFECT.get(), 20, 0)));
}
