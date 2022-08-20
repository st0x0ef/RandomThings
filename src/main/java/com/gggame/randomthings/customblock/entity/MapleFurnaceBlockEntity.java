
package com.gggame.randomthings.customblock.entity;

import com.gggame.randomthings.init.ItemInit;
import com.gggame.randomthings.screen.MapleFurnaceMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
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
import java.util.Objects;

public class MapleFurnaceBlockEntity extends BlockEntity implements MenuProvider {
    private final ItemStackHandler itemHandler = new ItemStackHandler(3) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
        }
    };

    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();

    protected final ContainerData data;
    private int progress = 0;
    private int maxProgress = 500;
    private int fuelTime = 0;
    private int maxFuelTime = 0;

    public MapleFurnaceBlockEntity(BlockPos pWorldPosition, BlockState pBlockState) {
        super(ModBlockEntities.MAPLE_FURNACE.get(), pWorldPosition, pBlockState);
        this.data = new ContainerData() {
            public int get(int index) {
                return switch (index) {
                    case 0 -> MapleFurnaceBlockEntity.this.progress;
                    case 1 -> MapleFurnaceBlockEntity.this.maxProgress;
                    case 2 -> MapleFurnaceBlockEntity.this.fuelTime;
                    case 3 -> MapleFurnaceBlockEntity.this.maxFuelTime;
                    default -> 0;
                };
            }

            public void set(int index, int value) {
                switch (index) {
                    case 0 -> MapleFurnaceBlockEntity.this.progress = value;
                    case 1 -> MapleFurnaceBlockEntity.this.maxProgress = value;
                    case 2 -> MapleFurnaceBlockEntity.this.fuelTime = value;
                    case 3 -> MapleFurnaceBlockEntity.this.maxFuelTime = value;
                }
            }

            public int getCount() {
                return 4;
            }
        };
    }

    @Override
    public @NotNull Component getDisplayName() {
        return Component.literal("Maple furnace");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int pContainerId, @NotNull Inventory pInventory, @NotNull Player pPlayer) {
        return new MapleFurnaceMenu(pContainerId, pInventory, this, this.data);
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
        tag.put("maple.inventory", itemHandler.serializeNBT());
        tag.putInt("maple.progress", progress);
        tag.putInt("maple.fuelTime", fuelTime);
        tag.putInt("maple.maxFuelTime", maxFuelTime);
        super.saveAdditional(tag);
    }

    @Override
    public void load(@NotNull CompoundTag nbt) {
        super.load(nbt);
        itemHandler.deserializeNBT(nbt.getCompound("maple.inventory"));
        progress = nbt.getInt("maple.progress");
        fuelTime = nbt.getInt("maple.fuelTime");
        maxFuelTime = nbt.getInt("maple.maxFuelTime");
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }

        Containers.dropContents(Objects.requireNonNull(this.level), this.worldPosition, inventory);
    }

    public static void tick(Level pLevel, BlockPos pPos, BlockState pState, MapleFurnaceBlockEntity pBlockEntity) {
        if(isConsumingFuel(pBlockEntity)) {
            pBlockEntity.fuelTime--;
        }

        if(hasRecipe(pBlockEntity) && canCraft(pBlockEntity)) {
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

    private static void craftItem(MapleFurnaceBlockEntity entity) {
        entity.itemHandler.extractItem(1, 1, false);

        if (recipeId(entity) == 0) {
            entity.itemHandler.setStackInSlot(2, new ItemStack(ItemInit.MAPLE_SYRUP_BOTTLE.get(), entity.itemHandler.getStackInSlot(2).getCount() + 1));
        }
        else if (recipeId(entity) == 1) {
            entity.itemHandler.setStackInSlot(2, new ItemStack(ItemInit.MAPLE_TAFFY.get(), entity.itemHandler.getStackInSlot(2).getCount() + 1));
        }
        else if (recipeId(entity) == 2) {
            entity.itemHandler.setStackInSlot(2, new ItemStack(ItemInit.MAPLE_SUGAR.get(), entity.itemHandler.getStackInSlot(2).getCount() + 1));
        }
        else if (recipeId(entity) == 3) {
            entity.itemHandler.setStackInSlot(2, new ItemStack(ItemInit.MAPLE_BUTTER.get(), entity.itemHandler.getStackInSlot(2).getCount() + 1));
        }


        entity.resetProgress();
    }

    private static boolean hasRecipe(MapleFurnaceBlockEntity entity) {
        if(entity.itemHandler.getStackInSlot(1).getItem() == ItemInit.MAPLE_WATER_BOTTLE.get().asItem()) return true;
        if(entity.itemHandler.getStackInSlot(1).getItem() == ItemInit.MAPLE_SYRUP_BOTTLE.get().asItem()) return true;
        if(entity.itemHandler.getStackInSlot(1).getItem() == ItemInit.MAPLE_TAFFY.get().asItem()) return true;
        if(entity.itemHandler.getStackInSlot(1).getItem() == ItemInit.MAPLE_SUGAR.get().asItem()) return true;

        return false;
    }

    private static boolean canCraft(MapleFurnaceBlockEntity entity) {
        if (getItem(entity, 2) == Items.AIR) return true;

        else if (recipeId(entity) == 0) { if (getItem(entity, 2) == ItemInit.MAPLE_SYRUP_BOTTLE.get()) { return true; } else return false; }
        else if (recipeId(entity) == 1) { if (getItem(entity, 2) == ItemInit.MAPLE_TAFFY.get()) { return true; } else return false; }
        else if (recipeId(entity) == 2) { if (getItem(entity, 2) == ItemInit.MAPLE_SUGAR.get()) { return true; } else return false; }
        else if (recipeId(entity) == 3) { if (getItem(entity, 2) == ItemInit.MAPLE_BUTTER.get()) { return true; } else return false; }

        return false;
    }

    private static Item getItem(MapleFurnaceBlockEntity entity, int slot) {
        return entity.itemHandler.getStackInSlot(slot).getItem();
    }

    private static int recipeId(MapleFurnaceBlockEntity entity) {
        if (!hasRecipe(entity)) return -1;

        if(entity.itemHandler.getStackInSlot(1).getItem() == ItemInit.MAPLE_WATER_BOTTLE.get().asItem()) return 0;
        if(entity.itemHandler.getStackInSlot(1).getItem() == ItemInit.MAPLE_SYRUP_BOTTLE.get().asItem()) return 1;
        if(entity.itemHandler.getStackInSlot(1).getItem() == ItemInit.MAPLE_TAFFY.get().asItem()) return 2;
        if(entity.itemHandler.getStackInSlot(1).getItem() == ItemInit.MAPLE_SUGAR.get().asItem()) return 3;

        return -1;
    }

    private static boolean hasNotReachedStackLimit(MapleFurnaceBlockEntity entity) {
        return entity.itemHandler.getStackInSlot(2).getCount() < entity.itemHandler.getStackInSlot(2).getMaxStackSize();
    }

    private static boolean hasFuelInFuelSlot(MapleFurnaceBlockEntity entity) {
        return !entity.itemHandler.getStackInSlot(0).isEmpty();
    }

    private static boolean isConsumingFuel(MapleFurnaceBlockEntity entity) {
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