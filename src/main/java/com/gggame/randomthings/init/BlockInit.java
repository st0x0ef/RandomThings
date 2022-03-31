package com.gggame.randomthings.init;

import com.gggame.randomthings.Main;
import com.gggame.randomthings.customblock.OreExtractorBlock;
import com.gggame.randomthings.world.tree.CherryTreeGrower;
import com.gggame.randomthings.world.tree.MapleTreeGrower;
import com.google.common.base.Supplier;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;

public class BlockInit {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Main.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = ItemInit.ITEMS;

    public static final RegistryObject<Block> SILVER_BLOCK = register("silver_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_LIGHT_GRAY).strength(6.0f).sound(SoundType.METAL)),
            object -> () -> new BlockItem(object.get(), new Item.Properties().tab(Main.RANDOMTHINGS_DECORATION_TAB)));
    public static final RegistryObject<Block> RAW_SILVER_BLOCK = register("raw_silver_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_GRAY).strength(3.0f).sound(SoundType.METAL)),
            object -> () -> new BlockItem(object.get(), new Item.Properties().tab(Main.RANDOMTHINGS_DECORATION_TAB)));
    public static final RegistryObject<Block> SILVER_ORE = register("silver_ore",
            () -> new OreBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).strength(4f).sound(SoundType.STONE).requiresCorrectToolForDrops()),
            object -> () -> new BlockItem(object.get(), new Item.Properties().tab(Main.RANDOMTHINGS_ORE_TAB)));
    public static final RegistryObject<Block> SILVER_ORE_DEEPSLATE = register("silver_ore_deepslate",
            () -> new OreBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).strength(8f).sound(SoundType.STONE).requiresCorrectToolForDrops()),
            object -> () -> new BlockItem(object.get(), new Item.Properties().tab(Main.RANDOMTHINGS_ORE_TAB)));

    public static final RegistryObject<Block> ORE_EXTRACTOR = register("ore_extractor",
            () -> new OreExtractorBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).strength(2f).sound(SoundType.METAL).noOcclusion()),
            object -> () -> new BlockItem(object.get(), new Item.Properties().tab(Main.RANDOMTHINGS_TAB)));

    public static final RegistryObject<Block> GRANITE_BRICK = register("granite_brick",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_RED).strength(1.5f).sound(SoundType.STONE)),
            object -> () -> new BlockItem(object.get(), new Item.Properties().tab(Main.RANDOMTHINGS_DECORATION_TAB)));
    public static final RegistryObject<Block> DIORITE_BRICK = register("diorite_brick",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_LIGHT_GRAY).strength(1.5f).sound(SoundType.STONE)),
            object -> () -> new BlockItem(object.get(), new Item.Properties().tab(Main.RANDOMTHINGS_DECORATION_TAB)));
    public static final RegistryObject<Block> ANDESITE_BRICK = register("andesite_brick",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).strength(1.5f).sound(SoundType.STONE)),
            object -> () -> new BlockItem(object.get(), new Item.Properties().tab(Main.RANDOMTHINGS_DECORATION_TAB)));

    public static final RegistryObject<Block> CHERRY_PLANKS = register("cherry_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).color(MaterialColor.COLOR_PINK))
            {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 5;
                }}, object -> () -> new BlockItem(object.get(), new Item.Properties().tab(Main.RANDOMTHINGS_DECORATION_TAB)));

    public static final RegistryObject<Block> CHERRY_LOG = register("cherry_log",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG).color(MaterialColor.COLOR_PINK))
            {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 5;
                }}, object -> () -> new BlockItem(object.get(), new Item.Properties().tab(Main.RANDOMTHINGS_DECORATION_TAB)));
    public static final RegistryObject<Block> CHERRY_LEAVES = register("cherry_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES).color(MaterialColor.COLOR_PINK)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 60;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 30;
                }
            },  object -> () -> new BlockItem(object.get(), new Item.Properties().tab(Main.RANDOMTHINGS_DECORATION_TAB)));

    public static final RegistryObject<Block> MAPLE_PLANKS = register("maple_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))
            {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 5;
                }}, object -> () -> new BlockItem(object.get(), new Item.Properties().tab(Main.RANDOMTHINGS_DECORATION_TAB)));

    public static final RegistryObject<Block> MAPLE_LOG = register("maple_log",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG))
            {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 5;
                }}, object -> () -> new BlockItem(object.get(), new Item.Properties().tab(Main.RANDOMTHINGS_DECORATION_TAB)));
    public static final RegistryObject<Block> MAPLE_LEAVES = register("maple_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 60;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 30;
                }
            },  object -> () -> new BlockItem(object.get(), new Item.Properties().tab(Main.RANDOMTHINGS_DECORATION_TAB)));

    public static final RegistryObject<Block> UPGRADED_NETHERITE_BLOCK = register("upgraded_netherite_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_BLACK).strength(60.0F, 1500.0F).sound(SoundType.NETHERITE_BLOCK)),
            object -> () -> new BlockItem(object.get(), new Item.Properties().tab(Main.RANDOMTHINGS_DECORATION_TAB)));

    public static final RegistryObject<Block> CHERRY_SAPLING = register("cherry_sapling",
            () -> new SaplingBlock(new CherryTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)),
            object -> () -> new BlockItem(object.get(), new Item.Properties().tab(Main.RANDOMTHINGS_DECORATION_TAB)));

    public static final RegistryObject<Block> MAPLE_SAPLING = register("maple_sapling",
            () -> new SaplingBlock(new MapleTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)),
            object -> () -> new BlockItem(object.get(), new Item.Properties().tab(Main.RANDOMTHINGS_DECORATION_TAB)));

    public static final RegistryObject<Block> DEGRADE_BLOCK_BLACK = register("degrade_block_black",
            () -> new Block(BlockBehaviour.Properties.of(Material.DECORATION, MaterialColor.COLOR_BLACK).strength(1f)),
            object -> () -> new BlockItem(object.get(), new Item.Properties().tab(Main.RANDOMTHINGS_DECORATION_TAB)));
    public static final RegistryObject<Block> DEGRADE_BLOCK_BLUE = register("degrade_block_blue",
            () -> new Block(BlockBehaviour.Properties.of(Material.DECORATION, MaterialColor.COLOR_BLACK).strength(1f)),
            object -> () -> new BlockItem(object.get(), new Item.Properties().tab(Main.RANDOMTHINGS_DECORATION_TAB)));
    public static final RegistryObject<Block> DEGRADE_BLOCK_BROWN = register("degrade_block_brown",
            () -> new Block(BlockBehaviour.Properties.of(Material.DECORATION, MaterialColor.COLOR_BLACK).strength(1f)),
            object -> () -> new BlockItem(object.get(), new Item.Properties().tab(Main.RANDOMTHINGS_DECORATION_TAB)));
    public static final RegistryObject<Block> DEGRADE_BLOCK_CYAN = register("degrade_block_cyan",
            () -> new Block(BlockBehaviour.Properties.of(Material.DECORATION, MaterialColor.COLOR_BLACK).strength(1f)),
            object -> () -> new BlockItem(object.get(), new Item.Properties().tab(Main.RANDOMTHINGS_DECORATION_TAB)));
    public static final RegistryObject<Block> DEGRADE_BLOCK_GRAY = register("degrade_block_gray",
            () -> new Block(BlockBehaviour.Properties.of(Material.DECORATION, MaterialColor.COLOR_BLACK).strength(1f)),
            object -> () -> new BlockItem(object.get(), new Item.Properties().tab(Main.RANDOMTHINGS_DECORATION_TAB)));
    public static final RegistryObject<Block> DEGRADE_BLOCK_GREEN = register("degrade_block_green",
            () -> new Block(BlockBehaviour.Properties.of(Material.DECORATION, MaterialColor.COLOR_BLACK).strength(1f)),
            object -> () -> new BlockItem(object.get(), new Item.Properties().tab(Main.RANDOMTHINGS_DECORATION_TAB)));
    public static final RegistryObject<Block> DEGRADE_BLOCK_LIGHT_BLUE = register("degrade_block_light_blue",
            () -> new Block(BlockBehaviour.Properties.of(Material.DECORATION, MaterialColor.COLOR_BLACK).strength(1f)),
            object -> () -> new BlockItem(object.get(), new Item.Properties().tab(Main.RANDOMTHINGS_DECORATION_TAB)));
    public static final RegistryObject<Block> DEGRADE_BLOCK_LIGHT_GRAY = register("degrade_block_light_gray",
            () -> new Block(BlockBehaviour.Properties.of(Material.DECORATION, MaterialColor.COLOR_BLACK).strength(1f)),
            object -> () -> new BlockItem(object.get(), new Item.Properties().tab(Main.RANDOMTHINGS_DECORATION_TAB)));
    public static final RegistryObject<Block> DEGRADE_BLOCK_LIME = register("degrade_block_lime",
            () -> new Block(BlockBehaviour.Properties.of(Material.DECORATION, MaterialColor.COLOR_BLACK).strength(1f)),
            object -> () -> new BlockItem(object.get(), new Item.Properties().tab(Main.RANDOMTHINGS_DECORATION_TAB)));
    public static final RegistryObject<Block> DEGRADE_BLOCK_MAGENTA = register("degrade_block_magenta",
            () -> new Block(BlockBehaviour.Properties.of(Material.DECORATION, MaterialColor.COLOR_BLACK).strength(1f)),
            object -> () -> new BlockItem(object.get(), new Item.Properties().tab(Main.RANDOMTHINGS_DECORATION_TAB)));
    public static final RegistryObject<Block> DEGRADE_BLOCK_ORANGE = register("degrade_block_orange",
            () -> new Block(BlockBehaviour.Properties.of(Material.DECORATION, MaterialColor.COLOR_BLACK).strength(1f)),
            object -> () -> new BlockItem(object.get(), new Item.Properties().tab(Main.RANDOMTHINGS_DECORATION_TAB)));
    public static final RegistryObject<Block> DEGRADE_BLOCK_PINK = register("degrade_block_pink",
            () -> new Block(BlockBehaviour.Properties.of(Material.DECORATION, MaterialColor.COLOR_BLACK).strength(1f)),
            object -> () -> new BlockItem(object.get(), new Item.Properties().tab(Main.RANDOMTHINGS_DECORATION_TAB)));
    public static final RegistryObject<Block> DEGRADE_BLOCK_PURPLE = register("degrade_block_purple",
            () -> new Block(BlockBehaviour.Properties.of(Material.DECORATION, MaterialColor.COLOR_BLACK).strength(1f)),
            object -> () -> new BlockItem(object.get(), new Item.Properties().tab(Main.RANDOMTHINGS_DECORATION_TAB)));
    public static final RegistryObject<Block> DEGRADE_BLOCK_RED = register("degrade_block_red",
            () -> new Block(BlockBehaviour.Properties.of(Material.DECORATION, MaterialColor.COLOR_BLACK).strength(1f)),
            object -> () -> new BlockItem(object.get(), new Item.Properties().tab(Main.RANDOMTHINGS_DECORATION_TAB)));
    public static final RegistryObject<Block> DEGRADE_BLOCK_WHITE = register("degrade_block_white",
            () -> new Block(BlockBehaviour.Properties.of(Material.DECORATION, MaterialColor.COLOR_BLACK).strength(1f)),
            object -> () -> new BlockItem(object.get(), new Item.Properties().tab(Main.RANDOMTHINGS_DECORATION_TAB)));
    public static final RegistryObject<Block> DEGRADE_BLOCK_YELLOW = register("degrade_block_yellow",
            () -> new Block(BlockBehaviour.Properties.of(Material.DECORATION, MaterialColor.COLOR_BLACK).strength(1f)),
            object -> () -> new BlockItem(object.get(), new Item.Properties().tab(Main.RANDOMTHINGS_DECORATION_TAB)));


    private static <T extends Block> RegistryObject<T> register(final String name, final Supplier<? extends T> block, Function<RegistryObject<T>, Supplier<? extends Item>> item) {
        RegistryObject<T> obj = BLOCKS.register(name, block);
        ITEMS.register(name, item.apply(obj));
        return obj;
    }
}
