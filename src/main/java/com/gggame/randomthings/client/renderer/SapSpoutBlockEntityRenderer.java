package com.gggame.randomthings.client.renderer;

import com.gggame.randomthings.entity.SapSpoutBlockEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.world.item.Items;

public class SapSpoutBlockEntityRenderer implements BlockEntityRenderer<SapSpoutBlockEntity> {
    public SapSpoutBlockEntityRenderer(BlockEntityRendererProvider.Context context) {
    }

    @Override
    public void render(SapSpoutBlockEntity pBlockEntity, float partialTicks, PoseStack stack, MultiBufferSource buffer, int combinedOverlay, int packedLight) {
        ItemRenderer render =  Minecraft.getInstance().getItemRenderer();
        render.renderStatic(Minecraft.getInstance().player, Items.BUCKET.getDefaultInstance(), ItemTransforms.TransformType.FIXED, false, stack, buffer, Minecraft.getInstance().level, combinedOverlay, packedLight, 0);
    }
}
