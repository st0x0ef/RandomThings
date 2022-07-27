package com.gggame.randomthings.event.loot;


import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nonnull;
import java.util.Random;

public class EndErbiumGemInEndCitiesAdditionModifier extends LootModifier {
    public static final Codec<EndErbiumGemInEndCitiesAdditionModifier> CODEC = RecordCodecBuilder.create(
            inst -> LootModifier.codecStart(inst)
                    .and(
                            ForgeRegistries.ITEMS.getCodec().fieldOf("item").forGetter(m -> m.addition)
                    )
                    .apply(inst, EndErbiumGemInEndCitiesAdditionModifier::new)
    );

    private final Item addition;

    protected EndErbiumGemInEndCitiesAdditionModifier(LootItemCondition[] conditionsIn, Item addition) {
        super(conditionsIn);
        this.addition = addition;
    }

    @Nonnull
    @Override
    protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        if(context.getRandom().nextFloat() < 0.75f) {
            generatedLoot.add(new ItemStack(addition, new Random().nextInt(2) + 1));
        }

        return generatedLoot;
    }

    @Override
    public Codec<? extends IGlobalLootModifier> codec() {
        return ModLootModifiers.EndErbiumGemInEndCities.get();
    }
}
