package net.realtent.blazeaddons;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.minecraft.client.render.entity.ProjectileEntityRenderer;
import net.minecraft.util.Identifier;
import net.realtent.blazeaddons.entity.ModEntities;
import net.realtent.blazeaddons.entity.projectile.BlazeboltEntity;

public class BlazeAddonsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ModEntities.MINIROCKET_PROJECTILE, FlyingItemEntityRenderer::new);

        EntityRendererRegistry.register(ModEntities.BLAZEBOLT,
                (context) -> new ProjectileEntityRenderer<BlazeboltEntity>(context) {
                    @Override
                    public Identifier getTexture(BlazeboltEntity entity) {
                        return new Identifier(BlazeAddons.MOD_ID, "blazebolt");
                    }
                });
    }
}
