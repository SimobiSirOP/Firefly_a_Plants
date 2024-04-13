package org.exampl.japan_mod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.LightLayer;
import org.exampl.japan_mod.Japan_mod;
import org.exampl.japan_mod.entity.custom.FireflyEntity;

public class FireflyRenderer extends MobRenderer<FireflyEntity, FireflyModel<FireflyEntity>> {
    public FireflyRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new FireflyModel<>(pContext.bakeLayer(ModModelLayers.FIREFLY_LAYER)), 0f);
    }

    @Override
    public ResourceLocation getTextureLocation(FireflyEntity pEntity) {
        return new ResourceLocation(Japan_mod.MODID, "textures/entity/firefly.png");
    }
    @Override
    public void render(FireflyEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight){
        super.render(pEntity,pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight );
    }
    protected int getBlockLightLevel(FireflyEntity pEntity, BlockPos pPos) {
        return (pEntity.level().getBrightness(LightLayer.BLOCK, pPos) < 8) ? 15 - pEntity.level().getBrightness(LightLayer.BLOCK, pPos) : pEntity.level().getBrightness(LightLayer.BLOCK, pPos);
    }
}
