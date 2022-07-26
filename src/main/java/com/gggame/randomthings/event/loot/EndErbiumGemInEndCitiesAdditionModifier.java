package com.gggame.randomthings.event.loot;

/*
public class EndErbiumGemInEndCitiesAdditionModifier extends LootModifier {
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

    public static class Serializer extends GlobalLootModifierSerializer<EndErbiumGemInEndCitiesAdditionModifier> {

        @Override
        public EndErbiumGemInEndCitiesAdditionModifier read(ResourceLocation name, JsonObject object,
                                                            LootItemCondition[] conditionsIn) {
            Item addition = ForgeRegistries.ITEMS.getValue(
                    new ResourceLocation(GsonHelper.getAsString(object, "addition")));
            return new EndErbiumGemInEndCitiesAdditionModifier(conditionsIn, addition);
        }

        @Override
        public JsonObject write(EndErbiumGemInEndCitiesAdditionModifier instance) {
            JsonObject json = makeConditions(instance.conditions);
            json.addProperty("addition", ForgeRegistries.ITEMS.getKey(instance.addition).toString());
            return json;
        }
    }
}

 */
