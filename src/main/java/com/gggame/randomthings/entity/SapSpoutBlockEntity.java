
package com.gggame.randomthings.entity;

import com.gggame.randomthings.client.renderer.SapSpoutBlockEntityRenderer;
import com.gggame.randomthings.init.ItemInit;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.Containers;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import java.util.Objects;

public class SapSpoutBlockEntity extends BlockEntity {
    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();

    protected final ContainerData data;
    private int progress = 0;
    private int maxProgress = 100;
    private int haveBucket = 0;

    public SapSpoutBlockEntity(BlockPos pWorldPosition, BlockState pBlockState) {
        super(ModBlockEntities.ORE_EXTRACTOR.get(), pWorldPosition, pBlockState);
        this.data = new ContainerData() {
            public int get(int index) {
                return switch (index) {
                    case 0 -> SapSpoutBlockEntity.this.progress;
                    case 1 -> SapSpoutBlockEntity.this.maxProgress;
                    case 2 -> SapSpoutBlockEntity.this.haveBucket;
                    default -> 0;
                };
            }

            public void set(int index, int value) {
                switch (index) {
                    case 0 -> SapSpoutBlockEntity.this.progress = value;
                    case 1 -> SapSpoutBlockEntity.this.maxProgress = value;
                    case 2 -> SapSpoutBlockEntity.this.haveBucket = value;
                }
            }

            public int getCount() {
                return 1;
            }
        };
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
    }

    @Override
    public void invalidateCaps()  {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
    }

    @Override
    protected void saveAdditional(@NotNull CompoundTag tag) {
        tag.putInt("sap_spout.progress", progress);
        tag.putInt("sap_spout.haveBucket", haveBucket);
        super.saveAdditional(tag);
    }

    @Override
    public void load(@NotNull CompoundTag nbt) {
        super.load(nbt);
        progress = nbt.getInt("sap_spout.progress");
        haveBucket = nbt.getInt("sap_spout.haveBucket");
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer();

        if (haveBucket()) {
            if (this.progress == maxProgress) {
                inventory.setItem(0, ItemInit.MAPLE_WATER_BOTTLE.get().getDefaultInstance());
            }
            else {
                inventory.setItem(0, Items.BUCKET.getDefaultInstance());
            }
        }

        Containers.dropContents(Objects.requireNonNull(this.level), this.worldPosition, inventory);
    }

    public static void tick(Level pLevel, BlockPos pPos, BlockState pState, SapSpoutBlockEntity pBlockEntity) {
        if (pBlockEntity.progress <= pBlockEntity.maxProgress) {
            pBlockEntity.progress++;
        }

        if (pBlockEntity.haveBucket()) {

        }
    }

    public void addBucket(Level pLevel, BlockPos pPos, BlockState pState, SapSpoutBlockEntity pBlockEntity) {
        if (this.haveBucket == 1) return;
        this.haveBucket = 1;
    }

    public boolean haveBucket() {
        if (this.haveBucket == 1) return true;
        return false;
    }

    public void dropResult() {
        if (this.progress == this.maxProgress && haveBucket()) {
            drops();
            resetProgress();
        }
    }

    private void resetProgress() {
        this.progress = 0;
        this.haveBucket = 0;
    }
}