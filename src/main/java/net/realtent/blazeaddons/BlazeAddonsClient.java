package net.realtent.blazeaddons;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.minecraft.client.render.entity.ProjectileEntityRenderer;
import net.minecraft.util.Identifier;
import net.realtent.blazeaddons.entity.ModEntities;
import net.realtent.blazeaddons.entity.client.BlazeboltRenderer;
import net.realtent.blazeaddons.entity.client.FirespriteModel;
import net.realtent.blazeaddons.entity.client.FirespriteRenderer;
import net.realtent.blazeaddons.entity.client.ModModelLayers;
import net.realtent.blazeaddons.entity.projectile.BlazeboltEntity;

public class BlazeAddonsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ModEntities.MINIROCKET_PROJECTILE, FlyingItemEntityRenderer::new);

        EntityRendererRegistry.register(ModEntities.BLAZEBOLT, BlazeboltRenderer::new);

        EntityRendererRegistry.register(ModEntities.FIRESPRITE, FirespriteRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.FIRESPRITE, FirespriteModel::getTexturedModelData);
    }
}
