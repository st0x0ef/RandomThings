package com.gggame.randomthings.customblock.entity;

import com.gggame.randomthings.Main;
import com.gggame.randomthings.init.BlockInit;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, Main.MOD_ID);

    public static final RegistryObject<BlockEntityType<OreExtractorBlockEntity>> ORE_EXTRACTOR = BLOCK_ENTITIES.register("ore_extractor",
            () -> BlockEntityType.Builder.of(OreExtractorBlockEntity::new, BlockInit.ORE_EXTRACTOR.get()).build(null));
    public static final RegistryObject<BlockEntityType<MapleFurnaceBlockEntity>> MAPLE_FURNACE = BLOCK_ENTITIES.register("maple_furnace",
            () -> BlockEntityType.Builder.of(MapleFurnaceBlockEntity::new, BlockInit.MAPLE_FURNACE.get()).build(null));
}
