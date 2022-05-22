package com.gggame.randomthings.init;


import com.gggame.randomthings.Main;
import com.gggame.randomthings.customitem.ErbiumRingItem;
import com.gggame.randomthings.customitem.RandomItem;
import com.gggame.randomthings.customitem.SapSpoutItem;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ItemInit {
    // item
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Main.MOD_ID);

    public static final RegistryObject<Item> SILVER_INGOT = register("silver_ingot", () -> new Item(new Item.Properties().tab(Main.RANDOMTHINGS_ORE_TAB)));
    public static final RegistryObject<Item> RAW_SILVER = register("raw_silver", () -> new Item(new Item.Properties().tab(Main.RANDOMTHINGS_ORE_TAB)));

    public static final RegistryObject<Item> UPGRADED_NETHERITE_INGOT = register("upgraded_netherite_ingot", () -> new Item(new Item.Properties().fireResistant().tab(Main.RANDOMTHINGS_ORE_TAB)));

    // tool
    public static final RegistryObject<SwordItem> SILVER_SWORD = register("silver_sword", () -> new SwordItem(ItemMaterialInit.SILVER, 3, 1.2f, new Item.Properties().tab(Main.RANDOMTHINGS_TOOL_AND_ARMOR_TAB)));
    public static final RegistryObject<PickaxeItem> SILVER_PICKAXE = register("silver_pickaxe", () -> new PickaxeItem(ItemMaterialInit.SILVER, 2, 1.2f, new Item.Properties().tab(Main.RANDOMTHINGS_TOOL_AND_ARMOR_TAB)));
    public static final RegistryObject<AxeItem> SILVER_AXE = register("silver_axe", () -> new AxeItem(ItemMaterialInit.SILVER, 5, 1.2f, new Item.Properties().tab(Main.RANDOMTHINGS_TOOL_AND_ARMOR_TAB)));
    public static final RegistryObject<HoeItem> SILVER_HOE = register("silver_hoe", () -> new HoeItem(ItemMaterialInit.SILVER, 2, 1f, new Item.Properties().tab(Main.RANDOMTHINGS_TOOL_AND_ARMOR_TAB)));
    public static final RegistryObject<ShovelItem> SILVER_SHOVEL = register("silver_shovel", () -> new ShovelItem(ItemMaterialInit.SILVER, 2, 1f, new Item.Properties().tab(Main.RANDOMTHINGS_TOOL_AND_ARMOR_TAB)));

    public static final RegistryObject<SwordItem> UPGRADED_NETHERITE_SWORD = register("upgraded_netherite_sword", () -> new SwordItem(ItemMaterialInit.UPGRADED_NETHERITE, 3, 1.2f, new Item.Properties().fireResistant().tab(Main.RANDOMTHINGS_TOOL_AND_ARMOR_TAB)));
    public static final RegistryObject<PickaxeItem> UPGRADED_NETHERITE_PICKAXE = register("upgraded_netherite_pickaxe", () -> new PickaxeItem(ItemMaterialInit.UPGRADED_NETHERITE, 2, 1.2f, new Item.Properties().fireResistant().tab(Main.RANDOMTHINGS_TOOL_AND_ARMOR_TAB)));
    public static final RegistryObject<AxeItem> UPGRADED_NETHERITE_AXE = register("upgraded_netherite_axe", () -> new AxeItem(ItemMaterialInit.UPGRADED_NETHERITE, 5, 1.2f, new Item.Properties().fireResistant().tab(Main.RANDOMTHINGS_TOOL_AND_ARMOR_TAB)));
    public static final RegistryObject<HoeItem> UPGRADED_NETHERITE_HOE = register("upgraded_netherite_hoe", () -> new HoeItem(ItemMaterialInit.UPGRADED_NETHERITE, 2, 1f, new Item.Properties().fireResistant().tab(Main.RANDOMTHINGS_TOOL_AND_ARMOR_TAB)));
    public static final RegistryObject<ShovelItem> UPGRADED_NETHERITE_SHOVEL = register("upgraded_netherite_shovel", () -> new ShovelItem(ItemMaterialInit.UPGRADED_NETHERITE, 2, 1f, new Item.Properties().fireResistant().tab(Main.RANDOMTHINGS_TOOL_AND_ARMOR_TAB)));

    // armor
    public static final RegistryObject<Item> SILVER_HELMET = register("silver_helmet",
            () -> new ArmorItem(BaseArmorMaterial.SILVER, EquipmentSlot.HEAD,
                    new Item.Properties().tab(Main.RANDOMTHINGS_TOOL_AND_ARMOR_TAB)));
    public static final RegistryObject<Item> SILVER_CHESTPLATE = register("silver_chestplate",
            () -> new ArmorItem(BaseArmorMaterial.SILVER, EquipmentSlot.CHEST,
                    new Item.Properties().tab(Main.RANDOMTHINGS_TOOL_AND_ARMOR_TAB)));
    public static final RegistryObject<Item> SILVER_LEGGINGS = register("silver_leggings",
            () -> new ArmorItem(BaseArmorMaterial.SILVER, EquipmentSlot.LEGS,
                    new Item.Properties().tab(Main.RANDOMTHINGS_TOOL_AND_ARMOR_TAB)));
    public static final RegistryObject<Item> SILVER_BOOTS = register("silver_boots",
            () -> new ArmorItem(BaseArmorMaterial.SILVER, EquipmentSlot.FEET,
                    new Item.Properties().tab(Main.RANDOMTHINGS_TOOL_AND_ARMOR_TAB)));

    public static final RegistryObject<Item> UPGRADED_NETHERITE_HELMET = register("upgraded_netherite_helmet",
            () -> new ModArmorItem(BaseArmorMaterial.UPGRADED_NETHERITE, EquipmentSlot.HEAD,
                    new Item.Properties().fireResistant().tab(Main.RANDOMTHINGS_TOOL_AND_ARMOR_TAB)));
    public static final RegistryObject<Item> UPGRADED_NETHERITE_CHESTPLATE = register("upgraded_netherite_chestplate",
            () -> new ArmorItem(BaseArmorMaterial.UPGRADED_NETHERITE, EquipmentSlot.CHEST,
                    new Item.Properties().fireResistant().tab(Main.RANDOMTHINGS_TOOL_AND_ARMOR_TAB)));
    public static final RegistryObject<Item> UPGRADED_NETHERITE_LEGGINGS = register("upgraded_netherite_leggings",
            () -> new ArmorItem(BaseArmorMaterial.UPGRADED_NETHERITE, EquipmentSlot.LEGS,
                    new Item.Properties().fireResistant().tab(Main.RANDOMTHINGS_TOOL_AND_ARMOR_TAB)));
    public static final RegistryObject<Item> UPGRADED_NETHERITE_BOOTS = register("upgraded_netherite_boots",
            () -> new ArmorItem(BaseArmorMaterial.UPGRADED_NETHERITE, EquipmentSlot.FEET,
                    new Item.Properties().fireResistant().tab(Main.RANDOMTHINGS_TOOL_AND_ARMOR_TAB)));

    public static final RegistryObject<Item> MAPLE_SYRUP_BOTTLE = register("maple_syrup_bottle",
            () -> new Item(new Item.Properties().food(FoodInit.MAPLE_SYRUP).tab(Main.RANDOMTHINGS_FOOD_TAB)));
    public static final RegistryObject<Item> MAPLE_WATER_BOTTLE = register("maple_water_bottle",
            () -> new Item(new Item.Properties().food(FoodInit.MAPLE_WATER).tab(Main.RANDOMTHINGS_FOOD_TAB)));

    public static final RegistryObject<Item> ERBIUM_GEM = register("erbium_gem", () -> new Item(new Item.Properties().tab(Main.RANDOMTHINGS_ORE_TAB)));
    public static final RegistryObject<Item> NETHER_ERBIUM_GEM = register("nether_erbium_gem", () -> new Item(new Item.Properties().tab(Main.RANDOMTHINGS_ORE_TAB)));
    public static final RegistryObject<Item> END_ERBIUM_GEM = register("end_erbium_gem", () -> new Item(new Item.Properties().tab(Main.RANDOMTHINGS_ORE_TAB)));

    public static final RegistryObject<Item> ERBIUM_RING_TIER_1 = register("erbium_ring_tier_1", () -> new ErbiumRingItem(new Item.Properties().tab(Main.RANDOMTHINGS_OTHER_TAB).durability(30).rarity(Rarity.UNCOMMON), 1));
    public static final RegistryObject<Item> ERBIUM_RING_TIER_2 = register("erbium_ring_tier_2", () -> new ErbiumRingItem(new Item.Properties().tab(Main.RANDOMTHINGS_OTHER_TAB).durability(80).rarity(Rarity.UNCOMMON), 2));
    public static final RegistryObject<Item> ERBIUM_RING_TIER_3 = register("erbium_ring_tier_3", () -> new ErbiumRingItem(new Item.Properties().tab(Main.RANDOMTHINGS_OTHER_TAB).durability(150).rarity(Rarity.UNCOMMON), 3));

    public static final RegistryObject<Item> ERBIUM_CRYSTAL = register("erbium_crystal", () -> new Item(new Item.Properties().tab(Main.RANDOMTHINGS_ORE_TAB)));

    public static final RegistryObject<Item> SAP_SPOUT = register("sap_spout", () -> new SapSpoutItem(new Item.Properties().tab(Main.RANDOMTHINGS_OTHER_TAB).durability(12)));

    public static final RegistryObject<Item> ERBIUM_HELMET = register("erbium_helmet",
            () -> new ModArmorItem(BaseArmorMaterial.ERBIUM, EquipmentSlot.HEAD,
                    new Item.Properties().fireResistant().tab(Main.RANDOMTHINGS_TOOL_AND_ARMOR_TAB)));
    public static final RegistryObject<Item> ERBIUM_CHESTPLATE = register("erbium_chestplate",
            () -> new ArmorItem(BaseArmorMaterial.ERBIUM, EquipmentSlot.CHEST,
                    new Item.Properties().fireResistant().tab(Main.RANDOMTHINGS_TOOL_AND_ARMOR_TAB)));
    public static final RegistryObject<Item> ERBIUM_LEGGINGS = register("erbium_leggings",
            () -> new ArmorItem(BaseArmorMaterial.ERBIUM, EquipmentSlot.LEGS,
                    new Item.Properties().fireResistant().tab(Main.RANDOMTHINGS_TOOL_AND_ARMOR_TAB)));
    public static final RegistryObject<Item> ERBIUM_BOOTS = register("erbium_boots",
            () -> new ArmorItem(BaseArmorMaterial.ERBIUM, EquipmentSlot.FEET,
                    new Item.Properties().fireResistant().tab(Main.RANDOMTHINGS_TOOL_AND_ARMOR_TAB)));

    public static final RegistryObject<Item> NETHER_ERBIUM_HELMET = register("nether_erbium_helmet",
            () -> new ModArmorItem(BaseArmorMaterial.NETHER_ERBIUM, EquipmentSlot.HEAD,
                    new Item.Properties().fireResistant().tab(Main.RANDOMTHINGS_TOOL_AND_ARMOR_TAB)));
    public static final RegistryObject<Item> NETHER_ERBIUM_CHESTPLATE = register("nether_erbium_chestplate",
            () -> new ArmorItem(BaseArmorMaterial.NETHER_ERBIUM, EquipmentSlot.CHEST,
                    new Item.Properties().fireResistant().tab(Main.RANDOMTHINGS_TOOL_AND_ARMOR_TAB)));
    public static final RegistryObject<Item> NETHER_ERBIUM_LEGGINGS = register("nether_erbium_leggings",
            () -> new ArmorItem(BaseArmorMaterial.NETHER_ERBIUM, EquipmentSlot.LEGS,
                    new Item.Properties().fireResistant().tab(Main.RANDOMTHINGS_TOOL_AND_ARMOR_TAB)));
    public static final RegistryObject<Item> NETHER_ERBIUM_BOOTS = register("nether_erbium_boots",
            () -> new ArmorItem(BaseArmorMaterial.NETHER_ERBIUM, EquipmentSlot.FEET,
                    new Item.Properties().fireResistant().tab(Main.RANDOMTHINGS_TOOL_AND_ARMOR_TAB)));

    public static final RegistryObject<Item> END_ERBIUM_HELMET = register("end_erbium_helmet",
            () -> new ModArmorItem(BaseArmorMaterial.END_ERBIUM, EquipmentSlot.HEAD,
                    new Item.Properties().fireResistant().tab(Main.RANDOMTHINGS_TOOL_AND_ARMOR_TAB)));
    public static final RegistryObject<Item> END_ERBIUM_CHESTPLATE = register("end_erbium_chestplate",
            () -> new ArmorItem(BaseArmorMaterial.END_ERBIUM, EquipmentSlot.CHEST,
                    new Item.Properties().fireResistant().tab(Main.RANDOMTHINGS_TOOL_AND_ARMOR_TAB)));
    public static final RegistryObject<Item> END_ERBIUM_LEGGINGS = register("end_erbium_leggings",
            () -> new ArmorItem(BaseArmorMaterial.END_ERBIUM, EquipmentSlot.LEGS,
                    new Item.Properties().fireResistant().tab(Main.RANDOMTHINGS_TOOL_AND_ARMOR_TAB)));
    public static final RegistryObject<Item> END_ERBIUM_BOOTS = register("end_erbium_boots",
            () -> new ArmorItem(BaseArmorMaterial.END_ERBIUM, EquipmentSlot.FEET,
                    new Item.Properties().fireResistant().tab(Main.RANDOMTHINGS_TOOL_AND_ARMOR_TAB)));

    public static final RegistryObject<Item> RANDOM_ITEM = register("random_item", () -> new RandomItem(new Item.Properties().tab(Main.RANDOMTHINGS_OTHER_TAB).durability(1)));

    private static <T extends Item> RegistryObject<T> register(final String name, final Supplier<T> item) {
        return ITEMS.register(name, item);
    }
}
