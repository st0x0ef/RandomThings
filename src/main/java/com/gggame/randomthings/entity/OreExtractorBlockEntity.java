package com.gggame.randomthings.entity;

import com.gggame.randomthings.init.BlockInit;
import com.gggame.randomthings.init.ItemInit;
import com.gggame.randomthings.screen.OreExtractorMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;

public class OreExtractorBlockEntity extends BlockEntity implements MenuProvider {
    private final ItemStackHandler itemHandler = new ItemStackHandler(4) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
        }
    };

    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();

    protected final ContainerData data;
    private int progress = 0;
    private int maxProgress = 72;
    private int fuelTime = 0;
    private int maxFuelTime = 0;

    public OreExtractorBlockEntity(BlockPos pWorldPosition, BlockState pBlockState) {
        super(ModBlockEntities.ORE_EXTRACTOR.get(), pWorldPosition, pBlockState);
        this.data = new ContainerData() {
            public int get(int index) {
                switch (index) {
                    case 0: return OreExtractorBlockEntity.this.progress;
                    case 1: return OreExtractorBlockEntity.this.maxProgress;
                    case 2: return OreExtractorBlockEntity.this.fuelTime;
                    case 3: return OreExtractorBlockEntity.this.maxFuelTime;
                    default: return 0;
                }
            }

            public void set(int index, int value) {
                switch(index) {
                    case 0: OreExtractorBlockEntity.this.progress = value; break;
                    case 1: OreExtractorBlockEntity.this.maxProgress = value; break;
                    case 2: OreExtractorBlockEntity.this.fuelTime = value; break;
                    case 3: OreExtractorBlockEntity.this.maxFuelTime = value; break;
                }
            }

            public int getCount() {
                return 4;
            }
        };
    }

    @Override
    public Component getDisplayName() {
        return new TextComponent("Ore extractor");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int pContainerId, Inventory pInventory, Player pPlayer) {
        return new OreExtractorMenu(pContainerId, pInventory, this, this.data);
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @javax.annotation.Nullable Direction side) {
        if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            return lazyItemHandler.cast();
        }

        return super.getCapability(cap, side);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemHandler = LazyOptional.of(() -> itemHandler);
    }

    @Override
    public void invalidateCaps()  {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
    }

    @Override
    protected void saveAdditional(@NotNull CompoundTag tag) {
        tag.put("inventory", itemHandler.serializeNBT());
        tag.putInt("extractor.progress", progress);
        tag.putInt("extractor.fuelTime", fuelTime);
        tag.putInt("extractor.maxFuelTime", maxFuelTime);
        super.saveAdditional(tag);
    }

    @Override
    public void load(CompoundTag nbt) {
        super.load(nbt);
        itemHandler.deserializeNBT(nbt.getCompound("inventory"));
        progress = nbt.getInt("extractor.progress");
        fuelTime = nbt.getInt("extractor.fuelTime");
        maxFuelTime = nbt.getInt("blaster.maxFuelTime");
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }

        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    public static void tick(Level pLevel, BlockPos pPos, BlockState pState, OreExtractorBlockEntity pBlockEntity) {
        if(isConsumingFuel(pBlockEntity)) {
            pBlockEntity.fuelTime--;
        }

        if(hasRecipe(pBlockEntity)) {
            if(hasFuelInFuelSlot(pBlockEntity) && !isConsumingFuel(pBlockEntity)) {
                pBlockEntity.consumeFuel();
                setChanged(pLevel, pPos, pState);
            }
            if(isConsumingFuel(pBlockEntity) && hasNotReachedStackLimit(pBlockEntity)) {
                pBlockEntity.progress++;
                setChanged(pLevel, pPos, pState);
                if(pBlockEntity.progress >= pBlockEntity.maxProgress) {
                    craftItem(pBlockEntity);
                }
            }
            else {
                pBlockEntity.resetProgress();
                setChanged(pLevel, pPos, pState);
            }
        } else {
            pBlockEntity.resetProgress();
            setChanged(pLevel, pPos, pState);
        }
    }

    private static void craftItem(OreExtractorBlockEntity entity) {
        entity.itemHandler.extractItem(1, 1, false);

        if (recipeId(entity) == 0) {
            entity.itemHandler.setStackInSlot(2, new ItemStack(ItemInit.RAW_SILVER.get(), entity.itemHandler.getStackInSlot(2).getCount() + 1));
            entity.itemHandler.setStackInSlot(3, new ItemStack(Blocks.STONE.asItem(), entity.itemHandler.getStackInSlot(3).getCount() + 1));
        }
        else if (recipeId(entity) == 1) {
            entity.itemHandler.setStackInSlot(2, new ItemStack(ItemInit.RAW_SILVER.get(), entity.itemHandler.getStackInSlot(2).getCount() + 1));
            entity.itemHandler.setStackInSlot(3, new ItemStack(Blocks.DEEPSLATE.asItem(), entity.itemHandler.getStackInSlot(3).getCount() + 1));
        }

        else if (recipeId(entity) == 2) {
            entity.itemHandler.setStackInSlot(2, new ItemStack(Items.RAW_IRON, entity.itemHandler.getStackInSlot(2).getCount() + 1));
            entity.itemHandler.setStackInSlot(3, new ItemStack(Blocks.STONE.asItem(), entity.itemHandler.getStackInSlot(3).getCount() + 1));
        }
        else if (recipeId(entity) == 3) {
            entity.itemHandler.setStackInSlot(2, new ItemStack(Items.RAW_IRON, entity.itemHandler.getStackInSlot(2).getCount() + 1));
            entity.itemHandler.setStackInSlot(3, new ItemStack(Blocks.DEEPSLATE.asItem(), entity.itemHandler.getStackInSlot(3).getCount() + 1));
        }

        else if (recipeId(entity) == 4) {
            entity.itemHandler.setStackInSlot(2, new ItemStack(Items.RAW_COPPER, entity.itemHandler.getStackInSlot(2).getCount() + 1));
            entity.itemHandler.setStackInSlot(3, new ItemStack(Blocks.STONE.asItem(), entity.itemHandler.getStackInSlot(3).getCount() + 1));
        }
        else if (recipeId(entity) == 5) {
            entity.itemHandler.setStackInSlot(2, new ItemStack(Items.RAW_COPPER, entity.itemHandler.getStackInSlot(2).getCount() + 1));
            entity.itemHandler.setStackInSlot(3, new ItemStack(Blocks.DEEPSLATE.asItem(), entity.itemHandler.getStackInSlot(3).getCount() + 1));
        }

        else if (recipeId(entity) == 6) {
            entity.itemHandler.setStackInSlot(2, new ItemStack(Items.RAW_GOLD, entity.itemHandler.getStackInSlot(2).getCount() + 1));
            entity.itemHandler.setStackInSlot(3, new ItemStack(Blocks.STONE.asItem(), entity.itemHandler.getStackInSlot(3).getCount() + 1));
        }
        else if (recipeId(entity) == 7) {
            entity.itemHandler.setStackInSlot(2, new ItemStack(Items.RAW_GOLD, entity.itemHandler.getStackInSlot(2).getCount() + 1));
            entity.itemHandler.setStackInSlot(3, new ItemStack(Blocks.DEEPSLATE.asItem(), entity.itemHandler.getStackInSlot(3).getCount() + 1));
        }

        entity.resetProgress();
    }

    private static boolean hasRecipe(OreExtractorBlockEntity entity) {
        if(entity.itemHandler.getStackInSlot(1).getItem() == BlockInit.SILVER_ORE.get().asItem()) return true;
        if(entity.itemHandler.getStackInSlot(1).getItem() == BlockInit.SILVER_ORE_DEEPSLATE.get().asItem()) return true;

        if(entity.itemHandler.getStackInSlot(1).getItem() == Blocks.IRON_ORE.asItem()) return true;
        if(entity.itemHandler.getStackInSlot(1).getItem() == Blocks.DEEPSLATE_IRON_ORE.asItem()) return true;

        if(entity.itemHandler.getStackInSlot(1).getItem() == Blocks.COPPER_ORE.asItem()) return true;
        if(entity.itemHandler.getStackInSlot(1).getItem() == Blocks.DEEPSLATE_COPPER_ORE.asItem()) return true;

        if(entity.itemHandler.getStackInSlot(1).getItem() == Blocks.GOLD_ORE.asItem()) return true;
        if(entity.itemHandler.getStackInSlot(1).getItem() == Blocks.DEEPSLATE_GOLD_ORE.asItem()) return true;

        return false;
    }

    private static int recipeId(OreExtractorBlockEntity entity) {
        if (!hasRecipe(entity)) return -1;

        if(entity.itemHandler.getStackInSlot(1).getItem() == BlockInit.SILVER_ORE.get().asItem()) return 0;
        if(entity.itemHandler.getStackInSlot(1).getItem() == BlockInit.SILVER_ORE_DEEPSLATE.get().asItem()) return 1;

        if(entity.itemHandler.getStackInSlot(1).getItem() == Blocks.IRON_ORE.asItem()) return 2;
        if(entity.itemHandler.getStackInSlot(1).getItem() == Blocks.DEEPSLATE_IRON_ORE.asItem()) return 3;

        if(entity.itemHandler.getStackInSlot(1).getItem() == Blocks.COPPER_ORE.asItem()) return 4;
        if(entity.itemHandler.getStackInSlot(1).getItem() == Blocks.DEEPSLATE_COPPER_ORE.asItem()) return 5;

        if(entity.itemHandler.getStackInSlot(1).getItem() == Blocks.GOLD_ORE.asItem()) return 6;
        if(entity.itemHandler.getStackInSlot(1).getItem() == Blocks.DEEPSLATE_GOLD_ORE.asItem()) return 7;

        return -1;
    }

    private static boolean hasNotReachedStackLimit(OreExtractorBlockEntity entity) {
        boolean slot2 = entity.itemHandler.getStackInSlot(2).getCount() < entity.itemHandler.getStackInSlot(2).getMaxStackSize();
        boolean slot3 = entity.itemHandler.getStackInSlot(3).getCount() < entity.itemHandler.getStackInSlot(3).getMaxStackSize();
        return slot2 && slot3;
    }

    private static boolean hasFuelInFuelSlot(OreExtractorBlockEntity entity) {
        return !entity.itemHandler.getStackInSlot(0).isEmpty();
    }

    private static boolean isConsumingFuel(OreExtractorBlockEntity entity) {
        return entity.fuelTime > 0;
    }

    private void resetProgress() {
        this.progress = 0;
    }

    private void consumeFuel() {
        if(!itemHandler.getStackInSlot(0).isEmpty()) {
            this.fuelTime = ForgeHooks.getBurnTime(this.itemHandler.extractItem(0, 1, false), RecipeType.SMELTING);
            this.maxFuelTime = this.fuelTime;
        }
    }
}
