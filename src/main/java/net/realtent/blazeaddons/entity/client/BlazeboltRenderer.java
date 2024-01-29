/*
 * Decompiled with CFR 0.2.1 (FabricMC 53fa44c9).
 */
package net.realtent.blazeaddons.entity.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.ProjectileEntityRenderer;
import net.minecraft.entity.projectile.SpectralArrowEntity;
import net.minecraft.util.Identifier;
import net.realtent.blazeaddons.entity.projectile.BlazeboltEntity;

@Environment(value=EnvType.CLIENT)
public class BlazeboltRenderer
        extends ProjectileEntityRenderer<BlazeboltEntity> {
    public static final Identifier TEXTURE = new Identifier("textures/entity/projectiles/blazebolt_projectile.png");

    public BlazeboltRenderer(EntityRendererFactory.Context context) {
        super(context);
    }

    @Override
    public Identifier getTexture(BlazeboltEntity blazeboltEntity) {
        return TEXTURE;
    }
}

